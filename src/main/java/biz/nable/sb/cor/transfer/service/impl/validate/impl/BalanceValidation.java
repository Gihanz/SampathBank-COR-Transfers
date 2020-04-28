/*
 * ******************************************************************************
 *  * Copyright 2020 (C) N*able
 *  * @author Roshan Wijendra
 *  ******************************************************************************
 */

package biz.nable.sb.cor.transfer.service.impl.validate.impl;

import biz.nable.sb.cor.transfer.bean.RetrieveFinacleBean;
import biz.nable.sb.cor.transfer.bean.TransferBean;
import biz.nable.sb.cor.transfer.exception.FinacleRequestException;
import biz.nable.sb.cor.transfer.exception.SystemException;
import biz.nable.sb.cor.transfer.response.CalculatedCommissionResponse;
import biz.nable.sb.cor.transfer.service.impl.validate.TransferValidator;
import biz.nable.sb.cor.transfer.service.impl.validate.ValidatableRequest;
import biz.nable.sb.cor.transfer.soap.schemas.IIBRequestComponent;
import biz.nable.sb.cor.transfer.soap.schemas.iib.GetBalanceInquiryRequestType;
import biz.nable.sb.cor.transfer.soap.schemas.iib.GetBalanceInquiryResponseType;
import biz.nable.sb.cor.transfer.util.ErrorCode;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;

@Component
public class BalanceValidation implements TransferValidator {
    @Autowired
    IIBRequestComponent iibRequestComponent;
    @Autowired
    RetrieveFinacleBean retrieveFinacleBean;

    @Autowired
    private MessageSource messageSource;

    @Override
    public Boolean doValidate(ValidatableRequest validatableRequest, CalculatedCommissionResponse commissionResponse) {
        TransferBean transferBean = (TransferBean) validatableRequest;
        String accountNo = transferBean.getFromAccount();
        Float amount = transferBean.getAmount();
        amount += commissionAmount(transferBean, commissionResponse);
        GetBalanceInquiryResponseType balanceInquiryResponseType = getAccountBalance(accountNo);
        if (amount <= balanceInquiryResponseType.getAvailableBalance()) {
            return Boolean.TRUE;
        } else {
            throw new SystemException(ErrorCode.VALIDATION_ERROR, HttpStatus.BAD_REQUEST.value(), "Error");
        }
    }

    private Float commissionAmount(TransferBean transferBean, CalculatedCommissionResponse commissionResponse) {
        float amount = 0.0F;
        if ((null == transferBean.getCommissionAccount()
                || transferBean.getCommissionAccount().isEmpty())
                && (null == commissionResponse.getFrequency()
                || commissionResponse.getFrequency().isEmpty()
                || commissionResponse.getFrequency().equalsIgnoreCase("I"))) {
            amount = null != commissionResponse.getCommissionAmount()
                    ? commissionResponse.getCommissionAmount() : 0.0F;
        }
        return amount;
    }

    private GetBalanceInquiryResponseType getAccountBalance(String accountNo) {
        GetBalanceInquiryRequestType balanceInquiryRequest = new GetBalanceInquiryRequestType();
        BeanUtils.copyProperties(retrieveFinacleBean, balanceInquiryRequest);
        balanceInquiryRequest.setAccountNo(accountNo);
        GetBalanceInquiryResponseType responseType = iibRequestComponent.getBalanceInquiry(balanceInquiryRequest);
        if (!responseType.getActionCode().equals("000")) {
            throw new FinacleRequestException(ErrorCode.FINACLE_REQUEST_ERROR, HttpStatus.BAD_REQUEST.value(), messageSource.getMessage(ErrorCode.FINACLE_REQUEST_ERROR, null,
                    LocaleContextHolder.getLocale()));
        } else {
            return responseType;
        }
    }
}

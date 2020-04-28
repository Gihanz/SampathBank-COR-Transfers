/*
 * ******************************************************************************
 *  * Copyright 2020 (C) N*able
 *  * @author Roshan Wijendra
 *  ******************************************************************************
 */

package biz.nable.sb.cor.transfer.factory.impl;

import biz.nable.sb.cor.transfer.component.TempComponent;
import biz.nable.sb.cor.transfer.util.ErrorCode;
import biz.nable.sb.cor.common.bean.ApprovalBean;
import biz.nable.sb.cor.common.bean.ApprovalResponseBean;
import biz.nable.sb.cor.common.response.CommonResponse;
import biz.nable.sb.cor.common.service.impl.CommonConverter;
import biz.nable.sb.cor.common.template.CommonApprovalTemplate;
import biz.nable.sb.cor.common.utility.ActionTypeEnum;
import biz.nable.sb.cor.common.utility.ApprovalStatus;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Transactional
@Component
public class TransferApproval implements CommonApprovalTemplate {

    @Autowired
    private CommonConverter commonConverter;
    @Autowired
    private MessageSource messageSource;

    @Autowired
    TempComponent tempComponent;

    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    public CommonResponse doApprove(ApprovalBean approvalBean) {
        logger.info("Start Company approval process");
        CommonResponse commonResponse = new CommonResponse();
        ApprovalResponseBean approvalResponseBean = tempComponent.doApprove(approvalBean);
        if (ApprovalStatus.VERIFIED.name().equalsIgnoreCase(approvalBean.getApprovalStatus())) {
            if (!ActionTypeEnum.DELETE.name().equalsIgnoreCase(approvalBean.getActionType())) {
                logger.info("Start Record Add/Update approving");
//                doApproveNew(approvalBean, approvalResponseBean, approvalBean.getVerifiedBy(), approvalBean.getUserGroup());
                logger.info("Record Add/Update approved");
            } else {
                logger.info("Start Record deletion approving");
//                doRemove(approvalResponseBean, approvalBean.getVerifiedBy(), approvalBean.getUserGroup());
                logger.info("Record deletion approved");
            }
        } else {
            logger.info("Start Creation/Modification Rejecting");
            if (!ActionTypeEnum.CREATE.name().equalsIgnoreCase(approvalBean.getActionType())) {
//                doChangeStatus(approvalResponseBean);

            }
            logger.info("Creation/Modification Rejected");
        }
        commonResponse.setReturnCode(HttpStatus.ACCEPTED.value());
        commonResponse.setErrorCode(ErrorCode.OPERATION_SUCCESS);
        commonResponse.setReturnMessage(
                messageSource.getMessage(ErrorCode.OPERATION_SUCCESS, null, LocaleContextHolder.getLocale()));
        return commonResponse;
    }


}

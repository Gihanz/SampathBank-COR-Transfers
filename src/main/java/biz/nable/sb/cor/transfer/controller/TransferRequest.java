/*
 * ******************************************************************************
 *  * Copyright 2020 (C) N*able
 *  * @author Roshan Wijendra
 *  ******************************************************************************
 */

package biz.nable.sb.cor.transfer.controller;

import biz.nable.sb.cor.transfer.bean.RetrieveFinacleBean;
import biz.nable.sb.cor.transfer.soap.schemas.IIBRequestComponent;
import biz.nable.sb.cor.transfer.soap.schemas.iib.GetBalanceInquiryRequestType;
import biz.nable.sb.cor.transfer.soap.schemas.iib.GetBalanceInquiryResponseType;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TransferRequest {
    @Autowired
    IIBRequestComponent iibRequestComponent;
    @Autowired
    RetrieveFinacleBean retrieveFinacleBean;

    @GetMapping("/account/balance")
    public ResponseEntity<GetBalanceInquiryResponseType> getAccountBalance(@RequestParam String accountNo) {
        GetBalanceInquiryRequestType balanceInquiryRequest = new GetBalanceInquiryRequestType();
        BeanUtils.copyProperties(retrieveFinacleBean, balanceInquiryRequest);
        balanceInquiryRequest.setAccountNo(accountNo);
        return ResponseEntity.ok(iibRequestComponent.getBalanceInquiry(balanceInquiryRequest));
    }
}

/*
 * ******************************************************************************
 *  * Copyright 2020 (C) N*able
 *  * @author Roshan Wijendra
 *  ******************************************************************************
 */

package biz.nable.sb.cor.transfer.service.impl;

import biz.nable.sb.cor.common.response.CommonResponse;
import biz.nable.sb.cor.transfer.exception.FinacleRequestException;
import biz.nable.sb.cor.transfer.exception.ValidationException;
import biz.nable.sb.cor.transfer.request.SingleTransferRequest;
import biz.nable.sb.cor.transfer.util.ErrorCode;
import biz.nable.sb.cor.transfer.util.Util;
import biz.nable.sb.cor.transfer.validator.TransferValidationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

@Service
public class TransferService {
    @Autowired
    TransferValidationService validationService;
    @Autowired
    Util util;

    public CommonResponse singleTransfer(SingleTransferRequest singleTransferRequest, String userId, String userGroup, String requestId) {
        CommonResponse response = new CommonResponse();
        try {
            validationService.initTranValidate(singleTransferRequest, null);

        } catch (ValidationException e) {
            util.generateCommonResponse(e.getErrorCode(), HttpStatus.BAD_REQUEST.value(), response);
        } catch (FinacleRequestException e) {
            util.generateCommonResponse(e.getErrorCode(), HttpStatus.BAD_REQUEST.value(), response);
        } catch (Exception e) {
            util.generateCommonResponse(ErrorCode.UNKNOWN_ERROR, HttpStatus.INTERNAL_SERVER_ERROR.value(), response);
        }
        return response;
    }
}
/*
 * ******************************************************************************
 *  * Copyright 2020 (C) N*able
 *  * @author Roshan Wijendra
 *  ******************************************************************************
 */

package biz.nable.sb.cor.transfer.controller;

import biz.nable.sb.cor.common.exception.SystemException;
import biz.nable.sb.cor.common.response.CommonResponse;
import biz.nable.sb.cor.common.utility.ErrorCode;
import biz.nable.sb.cor.transfer.request.SingleTransferRequest;
import biz.nable.sb.cor.transfer.service.impl.TransferService;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.slf4j.MDC;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/transfer")
public class TransferController {

    Logger logger = LoggerFactory.getLogger(TransferController.class);
    @Autowired
    TransferService transferService;

    private static final String REQUEST_ID_HEADER = "request-id";

    @Autowired
    MessageSource messageSource;

    @ApiOperation(value = "Single Transfer Request", nickname = "Single Transfer Request", notes = "Create singleTransfer.", httpMethod = "POST")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Single Transfer Request successful", response = CommonResponse.class),
            @ApiResponse(code = 400, message = "Input parameters are not valid"),
            @ApiResponse(code = 500, message = "Internal server error")})
    @PostMapping(value = "/single")
    public ResponseEntity<CommonResponse> singleTransfer(@Valid @RequestBody SingleTransferRequest singleTransferRequest,
                                                         @RequestHeader(name = REQUEST_ID_HEADER, required = true) String requestId,
                                                         @RequestHeader(name = "userId", required = true) String userId,
                                                         @RequestHeader(name = "userGroup", required = true) String userGroup) {
        MDC.put(REQUEST_ID_HEADER, requestId);
        long startTime = System.currentTimeMillis();

        logger.info("Start execute method singleTransfer");
        CommonResponse commonResponse;

        try {
            logger.debug("singleTransfer for {}.", singleTransferRequest.toString());
            commonResponse = this.transferService.singleTransfer(singleTransferRequest, userId, userGroup,
                    requestId);
            logger.info(commonResponse.getReturnMessage());
        } catch (SystemException e) {
            logger.info("SystemException occurred while init singleTransfer for {}.", e.getMessage());
            commonResponse = new CommonResponse(HttpStatus.BAD_REQUEST.value(), e.getMessage(),
                    e.getErrorCode());
        } catch (Exception e) {
            logger.error("Error occurred while init singleTransfer for {}.", e);
            commonResponse = new CommonResponse(HttpStatus.INTERNAL_SERVER_ERROR.value(),
                    "Error occurred while singleTransfer. " + e.getMessage(), ErrorCode.UNKNOWN_ERROR);
        }


        long endTime = System.currentTimeMillis();
        logger.info("singleTransfer rate: avg_resp={}", (endTime - startTime));
        MDC.clear();
        return ResponseEntity.status(HttpStatus.resolve(commonResponse.getReturnCode())).body(commonResponse);
    }

}

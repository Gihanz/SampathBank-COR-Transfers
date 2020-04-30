package biz.nable.sb.cor.transfer.controller;


import biz.nable.sb.cor.common.exception.SystemException;
import biz.nable.sb.cor.common.response.CommonResponse;
import biz.nable.sb.cor.common.utility.ErrorCode;
import biz.nable.sb.cor.transfer.request.GetSingleTransferRequest;
import biz.nable.sb.cor.transfer.request.SingleTransferRequest;
import biz.nable.sb.cor.transfer.response.GetSingleTransferResponse;
import biz.nable.sb.cor.transfer.response.GetTransferDetailsResponse;
import biz.nable.sb.cor.transfer.service.impl.AdminService;
import biz.nable.sb.cor.transfer.util.ErrorDescription;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.slf4j.MDC;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Objects;

@RestController
@RequestMapping("/transfer")
public class AdminController {

    private Logger logger = LoggerFactory.getLogger(AdminController.class);

    @Autowired
    AdminService adminService;

    private static final String REQUEST_ID_HEADER = "requestID";
    private static final String USER_ID = "userId";

    @ApiOperation(value = "Get Single Transfer Status Inquiry", nickname = "Get Single Transfer Status Inquiry", notes = "Get Single Transfer Details", httpMethod = "POST")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Get Single Transfer Status Inquiry Request successful", response = GetSingleTransferResponse.class),
            @ApiResponse(code = 400, message = ErrorDescription.INPUT_PARAMETERS_ARE_NOT_VALID),
            @ApiResponse(code = 500, message = ErrorDescription.INTERNAL_SERVER_ERROR)})
    @PostMapping (value = "/admin/details")
    public ResponseEntity<GetSingleTransferResponse> getSingleTransferStatusInquiry(@Valid @RequestBody GetSingleTransferRequest getSingleTransferRequest,
                                                         @RequestHeader(name = REQUEST_ID_HEADER) String requestId,
                                                         @RequestHeader(name = USER_ID) String userId) {
        MDC.put(REQUEST_ID_HEADER, requestId);
        GetSingleTransferResponse getSingleTransferResponse = new GetSingleTransferResponse();
        try {
            logger.debug("getSingleTransferStatusInquiry for {}.", getSingleTransferRequest.toString());
            getSingleTransferResponse = adminService.getSingleTransferStatusInquiryDetails(getSingleTransferRequest, userId, requestId);
            logger.info(getSingleTransferResponse.getReturnMessage());
        } catch (SystemException e) {
            logger.info("SystemException occurred while init singleTransfer for {}.", e.toString());
            getSingleTransferResponse = new GetSingleTransferResponse(HttpStatus.BAD_REQUEST.value(), e.getMessage(),
                    e.getErrorCode());
        } catch (Exception e) {
            logger.error("Error occurred while init singleTransfer for {}.", e.toString());
            getSingleTransferResponse = new GetSingleTransferResponse(HttpStatus.INTERNAL_SERVER_ERROR.value(),
                    "Error occurred while singleTransfer. " + e.getMessage(), ErrorCode.UNKNOWN_ERROR);
        }

        MDC.clear();
        return ResponseEntity.status(Objects.requireNonNull(HttpStatus.resolve(getSingleTransferResponse.getReturnCode()))).body(getSingleTransferResponse);

    }

    @ApiOperation(value = "Get Transfer Details Inquiry", nickname = "Get Transfer Details Inquiry", notes = "Get Transfer Details", httpMethod = "GET")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Get Transfer Details Inquiry Request successful", response = GetTransferDetailsResponse.class),
            @ApiResponse(code = 400, message = ErrorDescription.INPUT_PARAMETERS_ARE_NOT_VALID),
            @ApiResponse(code = 500, message = ErrorDescription.INTERNAL_SERVER_ERROR)})
    @GetMapping (value = "/admin/details/{transferId}")
    public ResponseEntity<GetTransferDetailsResponse> getTransferDetailsInquiry(@PathVariable(name = "transferId")String transferId,
                                                                                    @RequestHeader(name = REQUEST_ID_HEADER) String requestId,
                                                                                    @RequestHeader(name = USER_ID) String userId) {
        MDC.put(REQUEST_ID_HEADER, requestId);
        GetTransferDetailsResponse getTransferDetailsResponse = new GetTransferDetailsResponse();
        try {
            logger.debug("getTransferDetailsInquiry for {}.", transferId);
            getTransferDetailsResponse = adminService.getTransferInquiryDetails(transferId, userId, requestId);
            logger.info(getTransferDetailsResponse.getReturnMessage());
        } catch (SystemException e) {
            logger.info("SystemException occurred while init singleTransfer for {}.", e.toString());
            getTransferDetailsResponse = new GetTransferDetailsResponse(HttpStatus.BAD_REQUEST.value(), e.getMessage(),
                    e.getErrorCode());
        } catch (Exception e) {
            logger.error("Error occurred while init singleTransfer for {}.", e.toString());
            getTransferDetailsResponse = new GetTransferDetailsResponse(HttpStatus.INTERNAL_SERVER_ERROR.value(),
                    "Error occurred while singleTransfer. " + e.getMessage(), ErrorCode.UNKNOWN_ERROR);
        }

        MDC.clear();
        return ResponseEntity.status(Objects.requireNonNull(HttpStatus.resolve(getTransferDetailsResponse.getReturnCode()))).body(getTransferDetailsResponse);

    }
}

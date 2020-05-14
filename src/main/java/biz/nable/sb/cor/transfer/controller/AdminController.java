package biz.nable.sb.cor.transfer.controller;


import biz.nable.sb.cor.common.exception.SystemException;
import biz.nable.sb.cor.common.response.CommonResponse;
import biz.nable.sb.cor.common.utility.ErrorCode;
import biz.nable.sb.cor.common.utility.RecordStatusEnum;
import biz.nable.sb.cor.transfer.constants.YnFlagEnum;
import biz.nable.sb.cor.transfer.request.GetAdvanceTransferStatusRequest;
import biz.nable.sb.cor.transfer.request.GetSingleTransferRequest;
import biz.nable.sb.cor.transfer.request.SingleTransferRequest;
import biz.nable.sb.cor.transfer.response.GetAdvanceTransferStatusResponse;
import biz.nable.sb.cor.transfer.response.GetCorporatePayeeTemplateResponse;
import biz.nable.sb.cor.transfer.response.GetFailedTransferDetailsResponse;
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
    public ResponseEntity<GetTransferDetailsResponse> getTransferDetailsInquiry(@PathVariable(name = "transferId") String transferId,
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
    
    @ApiOperation(value = "Get Corporate Payee Template", nickname = "Get Corporate Payee Template", notes = "Get Corporate Payee Template", httpMethod = "GET")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Get Corporate Payee Template Request successful", response = GetCorporatePayeeTemplateResponse.class),
            @ApiResponse(code = 400, message = ErrorDescription.INPUT_PARAMETERS_ARE_NOT_VALID),
            @ApiResponse(code = 500, message = ErrorDescription.INTERNAL_SERVER_ERROR)})
    @GetMapping (value = "/admin/template/{companyId}")
    public ResponseEntity<GetCorporatePayeeTemplateResponse> getCorporatePayeeTemplate(@PathVariable(name = "companyId") String companyId,
                                                                                    @RequestHeader(name = REQUEST_ID_HEADER) String requestId,
                                                                                    @RequestHeader(name = USER_ID) String userId) {
        MDC.put(REQUEST_ID_HEADER, requestId);
        GetCorporatePayeeTemplateResponse getCorporatePayeeTemplateResponse = new GetCorporatePayeeTemplateResponse();
        try {
            logger.debug("getCorporatePayeeTemplate for {}.", companyId);
            getCorporatePayeeTemplateResponse = adminService.getCorporatePayeeTemplate(companyId, userId, requestId);
            logger.info(getCorporatePayeeTemplateResponse.getReturnMessage());
        } catch (SystemException e) {
            logger.info("SystemException occurred while init corporatePayeeTemplate for {}.", e.toString());
            getCorporatePayeeTemplateResponse = new GetCorporatePayeeTemplateResponse(HttpStatus.BAD_REQUEST.value(), e.getMessage(),
                    e.getErrorCode());
        } catch (Exception e) {
            logger.error("Error occurred while init corporatePayeeTemplate for {}.", e.toString());
            getCorporatePayeeTemplateResponse = new GetCorporatePayeeTemplateResponse(HttpStatus.INTERNAL_SERVER_ERROR.value(),
                    "Error occurred while corporatePayeeTemplate. " + e.getMessage(), ErrorCode.UNKNOWN_ERROR);
        }

        MDC.clear();
        return ResponseEntity.status(Objects.requireNonNull(HttpStatus.resolve(getCorporatePayeeTemplateResponse.getReturnCode()))).body(getCorporatePayeeTemplateResponse);

    }
    
    @ApiOperation(value = "Get Failed Transfers", nickname = "Get Failed Transfers", notes = "Get Failed Transfers and Retry possible failed transfers", httpMethod = "GET")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Get Failed Transfers Request successful", response = GetFailedTransferDetailsResponse.class),
            @ApiResponse(code = 400, message = ErrorDescription.INPUT_PARAMETERS_ARE_NOT_VALID),
            @ApiResponse(code = 500, message = ErrorDescription.INTERNAL_SERVER_ERROR)})
    @GetMapping (value = "/admin/failed/{retryFlag}/{transferStatus}")
    public ResponseEntity<GetFailedTransferDetailsResponse> getFailedTransfers(@PathVariable(name = "retryFlag") YnFlagEnum retryFlag,
    																				@PathVariable(name = "transferStatus") RecordStatusEnum transferStatus,
                                                                                    @RequestHeader(name = REQUEST_ID_HEADER) String requestId,
                                                                                    @RequestHeader(name = USER_ID) String userId) {
        MDC.put(REQUEST_ID_HEADER, requestId);
        GetFailedTransferDetailsResponse getFailedTransferDetailsResponse = new GetFailedTransferDetailsResponse();
        try {
            logger.debug("getFailedTransferDetails for {}.", requestId);
            getFailedTransferDetailsResponse = adminService.getFailedTransferDetails(retryFlag, transferStatus, userId, requestId);
            logger.info(getFailedTransferDetailsResponse.getReturnMessage());
        } catch (SystemException e) {
            logger.info("SystemException occurred while init FailedTransferDetails for {}.", e.toString());
            getFailedTransferDetailsResponse = new GetFailedTransferDetailsResponse(HttpStatus.BAD_REQUEST.value(), e.getMessage(),
                    e.getErrorCode());
        } catch (Exception e) {
            logger.error("Error occurred while init FailedTransferDetails for {}.", e.toString());
            getFailedTransferDetailsResponse = new GetFailedTransferDetailsResponse(HttpStatus.INTERNAL_SERVER_ERROR.value(),
                    "Error occurred while FailedTransferDetails. " + e.getMessage(), ErrorCode.UNKNOWN_ERROR);
        }

        MDC.clear();
        return ResponseEntity.status(Objects.requireNonNull(HttpStatus.resolve(getFailedTransferDetailsResponse.getReturnCode()))).body(getFailedTransferDetailsResponse);

    }
    
    @ApiOperation(value = "Get Advance Transfer Status Inquiry", nickname = "Get Advance Transfer Status Inquiry", notes = "Get Advance Transfer Status", httpMethod = "POST")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Get Advance Transfer Status Inquiry Request successful", response = GetAdvanceTransferStatusResponse.class),
            @ApiResponse(code = 400, message = ErrorDescription.INPUT_PARAMETERS_ARE_NOT_VALID),
            @ApiResponse(code = 500, message = ErrorDescription.INTERNAL_SERVER_ERROR)})
    @PostMapping (value = "/admin/advanceDetails")
    public ResponseEntity<GetAdvanceTransferStatusResponse> getAdvanceTransferStatusInquiry(@Valid @RequestBody GetAdvanceTransferStatusRequest getAdvanceTransferStatusRequest,
                                                                                    @RequestHeader(name = REQUEST_ID_HEADER) String requestId,
                                                                                    @RequestHeader(name = USER_ID) String userId) {
        MDC.put(REQUEST_ID_HEADER, requestId);
        GetAdvanceTransferStatusResponse getAdvanceTransferStatusResponse = new GetAdvanceTransferStatusResponse();
        try {
            logger.debug("getAdvanceTransferStatusInquiry for {}.", requestId);
            getAdvanceTransferStatusResponse = adminService.getAdvanceTransferStatus(getAdvanceTransferStatusRequest, userId, requestId);
            logger.info(getAdvanceTransferStatusResponse.getReturnMessage());
        } catch (SystemException e) {
            logger.info("SystemException occurred while init AdvanceTransferStatus for {}.", e.toString());
            getAdvanceTransferStatusResponse = new GetAdvanceTransferStatusResponse(HttpStatus.BAD_REQUEST.value(), e.getMessage(),
                    e.getErrorCode());
        } catch (Exception e) {
            logger.error("Error occurred while init AdvanceTransferStatus for {}.", e.toString());
            getAdvanceTransferStatusResponse = new GetAdvanceTransferStatusResponse(HttpStatus.INTERNAL_SERVER_ERROR.value(),
                    "Error occurred while AdvanceTransferStatus. " + e.getMessage(), ErrorCode.UNKNOWN_ERROR);
        }

        MDC.clear();
        return ResponseEntity.status(Objects.requireNonNull(HttpStatus.resolve(getAdvanceTransferStatusResponse.getReturnCode()))).body(getAdvanceTransferStatusResponse);

    }
}

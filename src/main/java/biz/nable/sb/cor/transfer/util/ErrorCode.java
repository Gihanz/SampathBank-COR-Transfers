/*
 * ******************************************************************************
 *  * Copyright 2020 (C) N*able
 *  * @author Roshan Wijendra
 *  ******************************************************************************
 */

package biz.nable.sb.cor.transfer.util;

public class ErrorCode {

    private ErrorCode() {
        throw new IllegalStateException("Error Code class");
    }

    public static final String OPERATION_SUCCESS = "B200";
    // Business
    public static final String VALIDATION_ERROR = "B400";
    public static final String NO_TRANSFER_RECORD_FOUND = "B401";
    public static final String NO_TRANSFER_HISTORY_RECORD_FOUND = "B402";
    public static final String NO_COMMISSION_COLLECTION_RECORD_FOUND = "B403";

    public static final String WORKFLOW_SUBMISSION_ERROR = "T_TRF_001_E";
    public static final String VALIDATION_ERROR_RULE_LIMIT_CHECK = "B_TRF_002_E";
    public static final String VALIDATION_ERROR_ENTERER_LIMIT_CHECK = "B_TRF_003_E";
    public static final String VALIDATION_ERROR_APPROVER_LIMIT_CHECK = "B_TRF_004_E";
    public static final String VALIDATION_ERROR_COMPANY_LIMIT_CHECK = "B_TRF_005_E";
    public static final String VALIDATION_ERROR_BALANCE_CHECK = "B_TRF_006_E";

    public static final String EXECUTION_FAILURE = "E_EX_001";
    public static final String NOT_ENOUGH_BALANCE = "E_BL_001";
    public static final String TRANSFER_END_POINT_CALLING_ERROR = "E_TF_001";
    public static final String COMMISSION_CALCULATION_ERROR = "E_CC_001";

    public static final String USER_NOT_PERMITTED = "B4011";


    // Runtime
    public static final String UNKNOWN_ERROR = "T500";
    public static final String DATA_COPY_ERROR = "T520";
    // Network
    public static final String CREATE_APPROVAL_ERROR = "T421";
    public static final String FINACLE_REQUEST_ERROR = "T422";
}

/*
 * ******************************************************************************
 *  * Copyright 2020 (C) N*able
 *  * @author Roshan Wijendra
 *  ******************************************************************************
 */

package biz.nable.sb.cor.commission.util;

public class ErrorCode {

    private ErrorCode() {
        throw new IllegalStateException("Error Code class");
    }

    // Business
    public static final String VALIDATION_ERROR = "B400";

    public static final String COMMISSION_RECORD_NOT_FOUND = "BC01";
    public static final String INVALID_COMPANY_ID = "BC02";
    public static final String COMMISSION_PACKAGE_ALREADY_EXIST = "BC03";
    public static final String COMMISSION_TEMPLATE_ALREADY_EXIST = "BC04";
    public static final String COMMISSION_TEMPLATE_RECORD_NOT_FOUND = "BC05";
    public static final String TRAN_TYPE_RECORD_ALREADY_EXIST = "BC06";
    public static final String INVALID_TEMPLATE_ID = "BC07";
    public static final String INVALID_COMMISSION_ID = "BC08";

    public static final String USER_NOT_PERMITTED = "B4011";

    public static final String OPERATION_SUCCESS = "B200";
    // Runtime
    public static final String UNKNOWN_ERROR = "T500";
    // Network
    public static final String CREATE_APPROVAL_ERROR = "T421";
    public static final String FINACLE_REQUEST_ERROR = "T422";
}

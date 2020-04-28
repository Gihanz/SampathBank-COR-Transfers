/*
 * ******************************************************************************
 *  * Copyright 2020 (C) N*able
 *  * @author Roshan Wijendra
 *  ******************************************************************************
 */

package biz.nable.sb.cor.transfer.response;

import biz.nable.sb.cor.common.utility.ActionTypeEnum;

import java.util.Date;

public class AuthPendingResponse {
    private Long id;
    private String signature;
    private String approvalId;
    private String requestType;
    private String referenceNo;
    private String createdBy;
    private Date createdDate;
    private String lastUpdatedBy;
    private Date lastUpdatedDate;
    private String userGroup;
    private ActionTypeEnum actionType;
    private Object currentResponse;
    private Object tempResponse;
}

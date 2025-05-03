/*
 * ******************************************************************************
 *  * Copyright 2020 (C) N*able
 *  * @author Sampath Bank
 *  ******************************************************************************
 */

package biz.nable.sb.cor.transfer.response;

import biz.nable.sb.cor.common.response.CommonResponse;
import lombok.Data;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode(callSuper = true)
@Data
public class CommonTempCreateResponse extends CommonResponse {
    private String approvalID;
}

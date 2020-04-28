/*
 * ******************************************************************************
 *  * Copyright 2020 (C) N*able
 *  * @author Roshan Wijendra
 *  ******************************************************************************
 */

package biz.nable.sb.cor.transfer.response;

import biz.nable.sb.cor.transfer.constants.TranCategory;
import biz.nable.sb.cor.common.response.CommonResponse;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode(callSuper = true)
@Data
public class CalculatedCommissionResponse extends CommonResponse {
    private Float commissionAmount;
    private String companyId;
    private String tranType;
    @ApiModelProperty(notes = " BULK_TRAN / SINGLE_TRAN")
    private TranCategory tranCategory;
    private String frequency;
    private Long freeQuotaCount;
}

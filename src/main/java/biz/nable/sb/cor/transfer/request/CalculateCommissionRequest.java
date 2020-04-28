/*
 * ******************************************************************************
 *  * Copyright 2020 (C) N*able
 *  * @author Roshan Wijendra
 *  ******************************************************************************
 */

package biz.nable.sb.cor.transfer.request;

import biz.nable.sb.cor.transfer.constants.TranCategory;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;

@Data
public class CalculateCommissionRequest {
    @NotEmpty(message = "CompanyId should not be empty")
    private String companyId;
    @NotEmpty(message = "TranType should not be empty")
    private String tranType;
    @ApiModelProperty(notes = " BULK_TRAN / SINGLE_TRAN")
    private TranCategory tranCategory;

    @Min(value = 0, message = "Invalid transfer Amount")
    private Float amount;
    @Min(value = 0, message = "Invalid recode count")
    private Long recordCount;
}

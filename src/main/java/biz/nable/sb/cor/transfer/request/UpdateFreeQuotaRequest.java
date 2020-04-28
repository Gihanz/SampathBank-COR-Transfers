/*
 * ******************************************************************************
 *  * Copyright 2020 (C) N*able
 *  * @author Roshan Wijendra
 *  ******************************************************************************
 */

package biz.nable.sb.cor.transfer.request;

import lombok.Data;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;

@Data
public class UpdateFreeQuotaRequest {
    @NotEmpty(message = "CompanyId should not be empty")
    private String companyId;
    @NotEmpty(message = "TranType should not be empty")
    private String tranType;
    @Min(value = 1, message = "Invalid recode count")
    private Long recodeCount;
}

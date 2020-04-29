/*
 * ******************************************************************************
 *  * Copyright 2020 (C) N*able
 *  * @author Roshan Wijendra
 *  ******************************************************************************
 */

package biz.nable.sb.cor.transfer.validator.validate;

import biz.nable.sb.cor.transfer.response.CalculatedCommissionResponse;

public interface TransferValidator {
    Boolean doValidate(ValidatableRequest validatableRequest, CalculatedCommissionResponse commissionResponse);
}

/*
 * ******************************************************************************
 *  * Copyright 2020 (C) N*able
 *  * @author Roshan Wijendra
 *  ******************************************************************************
 */

package biz.nable.sb.cor.transfer.validator.validate.impl;

import biz.nable.sb.cor.transfer.response.CalculatedCommissionResponse;
import biz.nable.sb.cor.transfer.validator.validate.TransferValidator;
import biz.nable.sb.cor.transfer.validator.validate.ValidatableRequest;
import org.springframework.stereotype.Component;

@Component
public class UserValidation implements TransferValidator {

    @Override
    public Boolean doValidate(ValidatableRequest validatableRequest, CalculatedCommissionResponse commissionResponse) {
        return null;
    }
}

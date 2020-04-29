/*
 * ******************************************************************************
 *  * Copyright 2020 (C) N*able
 *  * @author Roshan Wijendra
 *  ******************************************************************************
 */

package biz.nable.sb.cor.transfer.validator;

import biz.nable.sb.cor.transfer.response.CalculatedCommissionResponse;
import biz.nable.sb.cor.transfer.validator.validate.TransferValidator;
import biz.nable.sb.cor.transfer.validator.validate.ValidatableRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class TransferValidationService {
    @Autowired
    List<TransferValidator> initTranValidationStack;
    @Autowired
    List<TransferValidator> execTranValidationStack;

    public Boolean initTranValidate(ValidatableRequest validatableRequest, CalculatedCommissionResponse commissionResponse) {
        for (TransferValidator transferValidator : initTranValidationStack) {
            transferValidator.doValidate(validatableRequest, commissionResponse);
        }
        return Boolean.TRUE;
    }

    public Boolean execTranValidate(ValidatableRequest validatableRequest, CalculatedCommissionResponse commissionResponse) {
        for (TransferValidator transferValidator : execTranValidationStack) {
            transferValidator.doValidate(validatableRequest, commissionResponse);
        }
        return Boolean.TRUE;
    }
}

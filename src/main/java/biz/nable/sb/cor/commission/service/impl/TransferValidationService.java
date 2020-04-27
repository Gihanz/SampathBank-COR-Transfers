/*
 * ******************************************************************************
 *  * Copyright 2020 (C) N*able
 *  * @author Roshan Wijendra
 *  ******************************************************************************
 */

package biz.nable.sb.cor.commission.service.impl;

import biz.nable.sb.cor.commission.service.impl.validate.TransferValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class TransferValidationService {
    @Autowired
    List<TransferValidator> initTranValidationStack;
    @Autowired
    List<TransferValidator> execTranValidationStack;

    public Boolean initTranValidate() {
        for (TransferValidator transferValidator : initTranValidationStack) {
            transferValidator.doValidate();
        }
        return Boolean.TRUE;
    }

    public Boolean execTranValidate() {
        for (TransferValidator transferValidator : execTranValidationStack) {
            transferValidator.doValidate();
        }
        return Boolean.TRUE;
    }
}

/*
 * ******************************************************************************
 *  * Copyright 2020 (C) N*able
 *  * @author Roshan Wijendra
 *  ******************************************************************************
 */

package biz.nable.sb.cor.commission.service.impl.validate;

import biz.nable.sb.cor.commission.service.impl.validate.impl.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class ValidationBuilder {
    @Autowired
    BalanceValidation balanceValidation;
    @Autowired
    RuleValidation ruleValidation;
    @Autowired
    UserValidation userValidation;
    @Autowired
    CompanyLimitValidation userLimitValidation;
    @Autowired
    CompanyLimitValidation companyLimitValidation;
    @Autowired
    ApproverLimitValidation approverLimitValidation;

    @Bean
    public List<TransferValidator> initTranValidationStack() {
        List<TransferValidator> transferValidators = new ArrayList<>();
        transferValidators.add(balanceValidation);
        transferValidators.add(ruleValidation);
        transferValidators.add(userValidation);
        transferValidators.add(userLimitValidation);
        transferValidators.add(companyLimitValidation);

        return transferValidators;
    }

    @Bean
    public List<TransferValidator> execTranValidate() {
        List<TransferValidator> transferValidators = new ArrayList<>();
        transferValidators.add(companyLimitValidation);

        return transferValidators;
    }
}

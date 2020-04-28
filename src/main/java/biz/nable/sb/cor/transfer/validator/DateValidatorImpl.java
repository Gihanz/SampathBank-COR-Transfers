/*
 * ******************************************************************************
 *  * Copyright 2020 (C) N*able
 *  * @author Roshan Wijendra
 *  ******************************************************************************
 */

package biz.nable.sb.cor.transfer.validator;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.util.Date;

public class DateValidatorImpl implements ConstraintValidator<DateValidator, Date> {
    @Override
    public boolean isValid(Date value, ConstraintValidatorContext context) {
        return false;
    }
}

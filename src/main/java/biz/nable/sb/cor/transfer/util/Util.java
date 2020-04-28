/*
 * ******************************************************************************
 *  * Copyright 2020 (C) N*able
 *  * @author Roshan Wijendra
 *  ******************************************************************************
 */

package biz.nable.sb.cor.transfer.util;

import biz.nable.sb.cor.common.response.CommonResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.stereotype.Component;

import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.function.Function;
import java.util.function.Predicate;

@Component
public class Util {

    @Autowired
    private MessageSource messageSource;

    public void generateCommonResponse(String errorCode, int status, CommonResponse commonResponse) {
        commonResponse.setErrorCode(errorCode);
        commonResponse.setReturnCode(status);
        commonResponse.setReturnMessage(messageSource.getMessage(errorCode, null,
                LocaleContextHolder.getLocale()));
    }

    public <T> Predicate<T> distinctByKey(Function<? super T, ?> keyExtractor) {
        Set<Object> seen = ConcurrentHashMap.newKeySet();
        return t -> seen.add(keyExtractor.apply(t));
    }
}

/*
 * ******************************************************************************
 *  * Copyright 2020 (C) N*able
 *  * @author Roshan Wijendra
 *  ******************************************************************************
 */

package biz.nable.sb.cor.commission.service.approval;

import biz.nable.sb.cor.common.response.CommonResponse;
import org.springframework.stereotype.Component;

@Component
public interface CompanyRequestHandler {

	CommonResponse addTemp(Object createCompanyRequest, String userId, String userGroup, String requestType,
			String referenceNo);

}

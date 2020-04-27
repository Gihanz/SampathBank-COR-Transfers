/*
 * ******************************************************************************
 *  * Copyright 2020 (C) N*able
 *  * @author Roshan Wijendra
 *  ******************************************************************************
 */

package biz.nable.sb.cor.commission.factory;

import biz.nable.sb.cor.commission.factory.impl.TransferApproval;
import biz.nable.sb.cor.common.template.CommonApprovalTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ApprovalTypeFactory {

	@Autowired
    TransferApproval transferApproval;

	public CommonApprovalTemplate getApproval(String type) {
//		if (null == type) {
		return transferApproval;
//		} else if (RequestTypeEnum.COMPANY.name().equalsIgnoreCase(type)) {
//			return company;
//		} else if (RequestTypeEnum.LINK_COMPANY.name().equalsIgnoreCase(type)) {
//			return linkCompanyApproval;
//		} else if (RequestTypeEnum.BRANCH.name().equalsIgnoreCase(type)) {
//			return branchApproval;
//		} else {
//			return null;
//		}
	}
}

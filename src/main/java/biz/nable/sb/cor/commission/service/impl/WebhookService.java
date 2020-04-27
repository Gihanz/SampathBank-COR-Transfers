/*
 * ******************************************************************************
 *  * Copyright 2020 (C) N*able
 *  * @author Roshan Wijendra
 *  ******************************************************************************
 */

package biz.nable.sb.cor.commission.service.impl;

import biz.nable.sb.cor.commission.factory.impl.TransferApproval;
import biz.nable.sb.cor.common.bean.ApprovalBean;
import biz.nable.sb.cor.common.bean.WebHookBean;
import biz.nable.sb.cor.common.service.impl.CommonConverter;
import biz.nable.sb.cor.common.template.CommonApprovalTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.LinkedHashMap;

@Service
public class WebhookService {

	@Autowired
	TransferApproval transferApproval;
	@Autowired
	CommonConverter commonConverter;

	public void doApprove(WebHookBean webHookBean) {
		LinkedHashMap<String, Object> map = (LinkedHashMap<String, Object>) webHookBean.getData();
		ApprovalBean approvalBean = commonConverter.mapToPojo(map, ApprovalBean.class);
		CommonApprovalTemplate approval = transferApproval;
		approval.doApprove(approvalBean);
	}

}

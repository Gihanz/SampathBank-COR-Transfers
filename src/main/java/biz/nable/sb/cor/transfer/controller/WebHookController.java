/*
 * ******************************************************************************
 *  * Copyright 2020 (C) N*able
 *  * @author Roshan Wijendra
 *  ******************************************************************************
 */

package biz.nable.sb.cor.transfer.controller;

import biz.nable.sb.cor.transfer.service.impl.WebhookService;
import biz.nable.sb.cor.common.bean.WebHookBean;
import biz.nable.sb.cor.common.utility.WebHookTypeEnum;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class WebHookController {
	@Autowired
	WebhookService webhookService;

	@PostMapping("/v1/webhook")
	public ResponseEntity<?> webhook(@RequestBody WebHookBean webHookBean) {
		if (WebHookTypeEnum.APPROVAL.name().equalsIgnoreCase(webHookBean.getWebHookType())) {
			webhookService.doApprove(webHookBean);
		}
		return ResponseEntity.accepted().body("Success");
	}

}

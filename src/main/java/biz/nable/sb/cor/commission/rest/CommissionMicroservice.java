/*
 * ******************************************************************************
 *  * Copyright 2020 (C) N*able
 *  * @author Roshan Wijendra
 *  ******************************************************************************
 */

package biz.nable.sb.cor.commission.rest;

import biz.nable.sb.cor.commission.request.CalculateCommissionRequest;
import biz.nable.sb.cor.commission.request.UpdateFreeQuotaRequest;
import biz.nable.sb.cor.commission.response.CalculatedCommissionResponse;
import biz.nable.sb.cor.common.response.CommonResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.Date;

public class CommissionMicroservice {
    @Autowired
    RestTemplate restTemplate;

    @Value("${commission.microservice.url:http://localhost:9083/commission}")
    private String commissionUrl;

    public CalculatedCommissionResponse calculateCommission(CalculateCommissionRequest request) throws URISyntaxException {

        String baseUrl = commissionUrl + "/v1/calculate";
        URI uri = new URI(baseUrl);

        HttpHeaders headers = new HttpHeaders();
        headers.set("request-id", String.valueOf(new Date().getTime()));

        HttpEntity<CalculateCommissionRequest> requestHttpEntity = new HttpEntity<>(request, headers);
        ResponseEntity<CalculatedCommissionResponse> result = restTemplate.exchange(uri, HttpMethod.POST, requestHttpEntity, CalculatedCommissionResponse.class);
        return result.getBody();
    }

    public CommonResponse updateFreeQuota(UpdateFreeQuotaRequest request) throws URISyntaxException {
        String baseUrl = commissionUrl + "/v1/freeQuota";
        URI uri = new URI(baseUrl);

        HttpHeaders headers = new HttpHeaders();
        headers.set("request-id", String.valueOf(new Date().getTime()));

        HttpEntity<UpdateFreeQuotaRequest> requestHttpEntity = new HttpEntity<>(request, headers);
        ResponseEntity<CommonResponse> result = restTemplate.exchange(uri, HttpMethod.PUT, requestHttpEntity, CommonResponse.class);
        return result.getBody();
    }
}

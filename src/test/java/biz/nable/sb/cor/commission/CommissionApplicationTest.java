/*
 * ******************************************************************************
 *  * Copyright 2020 (C) N*able
 *  * @author Roshan Wijendra
 *  ******************************************************************************
 */

package biz.nable.sb.cor.commission;

import biz.nable.sb.cor.commission.response.CommonGetListResponse;
import biz.nable.sb.cor.common.service.impl.CommonConverter;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.web.client.RestTemplate;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.Map;

@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
@ActiveProfiles("local")
public class CommissionApplicationTest {
    @LocalServerPort
    int randomServerPort;
    @Autowired
    CommonConverter commonConverter;

    @Test
    public void testGetCommissionPackagesSuccess() throws URISyntaxException {
        final String baseUrl = "http://localhost:" + randomServerPort + "/v1/commission/package";
        RestTemplate restTemplate = new RestTemplate();
        URI uri = new URI(baseUrl);

        HttpHeaders headers = new HttpHeaders();
        headers.set("request-id", "1234");
        headers.set("userGroup", "001");
        headers.set("adminUserId", "rowi");

        HttpEntity request = new HttpEntity(headers);

        ResponseEntity<String> result = restTemplate.exchange(uri, HttpMethod.GET, request, String.class);

        //Verify request succeed
        Assertions.assertEquals(200, result.getStatusCodeValue());
    }

    @Test
//    @Sql(scripts = {"/import_commission_package.sql"},
//            config = @SqlConfig(encoding = "utf-8", transactionMode = SqlConfig.TransactionMode.ISOLATED))
    public void testGetCommissionPackagesSuccessWithCompanyId() throws URISyntaxException {
        String baseUrl = "http://localhost:" + randomServerPort + "/v1/commission/package?companyId=C10";
        RestTemplate restTemplate = new RestTemplate();
        URI uri = new URI(baseUrl);

        HttpHeaders headers = new HttpHeaders();
        headers.set("request-id", "1234");
        headers.set("userGroup", "001");
        headers.set("adminUserId", "rowi");

        HttpEntity request = new HttpEntity(headers);

//        ResponseEntity<CommonGetListResponse> result = restTemplate.exchange(uri, HttpMethod.GET, request, CommonGetListResponse.class);
//
//        //Verify request succeed
//        Assertions.assertEquals(200, result.getStatusCodeValue());
//        Assertions.assertEquals(0, result.getBody().getPayLoad().size());

        String companyId = "C002";
        baseUrl = "http://localhost:" + randomServerPort + "/v1/commission/package?companyId=" + companyId;
        uri = new URI(baseUrl);
        ResponseEntity<CommonGetListResponse>  result = restTemplate.exchange(uri, HttpMethod.GET, request, CommonGetListResponse.class);
        Assertions.assertEquals(200, result.getStatusCodeValue());
        String actualCompanyId = "0";
        if (0 < result.getBody().getPayLoad().size()) {
            CommissionPackageResponseBean commissionPackageResponseBean = commonConverter.mapToPojo((Map<String, Object>) result.getBody().getPayLoad().get(0), CommissionPackageResponseBean.class);
            actualCompanyId = commissionPackageResponseBean.getCompanyId();
        }
        Assertions.assertEquals(companyId, actualCompanyId);

    }


}

/*
 * ******************************************************************************
 *  * Copyright 2020 (C) N*able
 *  * @author Roshan Wijendra
 *  ******************************************************************************
 */

package biz.nable.sb.cor.commission.service.impl;

import biz.nable.sb.cor.commission.component.TempComponent;
import biz.nable.sb.cor.commission.constants.YnFlagEnum;
import biz.nable.sb.cor.commission.response.CommonGetListResponse;
import biz.nable.sb.cor.commission.util.ErrorCode;
import biz.nable.sb.cor.commission.util.Util;
import biz.nable.sb.cor.common.bean.CommonSearchBean;
import org.junit.Assert;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.MessageSource;
import org.springframework.context.support.ReloadableResourceBundleMessageSource;
import org.springframework.test.util.ReflectionTestUtils;

import java.util.ArrayList;
import java.util.List;

class CommissionServiceTest {

    @InjectMocks
    CommissionService commissionService = new CommissionService();

    @Mock
    CommissionPackageRepository repository;

    @MockBean
    TempComponent tempComponent;
    @MockBean
    MessageSource messageSource;
    @MockBean
    private Util util;

    @BeforeEach
    void init() {
        messageSource = getMessageSource();
        tempComponent = new TempComponent();
        repository = Mockito.mock(CommissionPackageRepository.class);
//        jsonLoader = new JsonLoader();
        util = new Util();
    }

    private MessageSource getMessageSource() {
        ReloadableResourceBundleMessageSource messageSource = new ReloadableResourceBundleMessageSource();
        messageSource.setBasenames("classpath:messages");
        return messageSource;
    }

    @org.junit.jupiter.api.Test
    void createCommission() {
    }

    @org.junit.jupiter.api.Test
    void updateCommission() {
    }

    @org.junit.jupiter.api.Test
    @DisplayName("getCommissionPackages_success_Empty")
    void getCommissionPackages() {
        ReflectionTestUtils.setField(commissionService, "commissionPackageRepository", repository);
        ReflectionTestUtils.setField(commissionService, "util", util);
        ReflectionTestUtils.setField(util, "messageSource", messageSource);
        ReflectionTestUtils.setField(commissionService, "tempComponent", tempComponent);
        CommonSearchBean commonSearchBean = new CommonSearchBean();
        String userGroup = "001";
        String userId = "rowi";

         /*=======================================
        Get Mst code
        =======================================*/
        List<CommissionPackage> commissionPackageList = new ArrayList<>();
        Mockito.when(repository.findByTemplateFlagAndUserGroup(YnFlagEnum.N, userGroup))
                .thenReturn(commissionPackageList);


       /* *//*=======================================
        Get Temp code
        =======================================*//*
        commonSearchBean.setReferenceNo("1234");
        commonSearchBean.setActionType(ActionTypeEnum.CREATE);
        commonSearchBean.setRequestType(RequestTypeEnum.COMMISSION_PACKAGE.name());
        commonSearchBean.setTempList(new ArrayList<>());
        commonSearchBean.setUserGroup(userGroup);
        commonSearchBean.setUserId(userId);
        Mockito.when(tempComponent.getTempRecord(commonSearchBean))
                .thenReturn(commonSearchBean);
*/
        CommonGetListResponse<CommissionPackageResponseBean> commissionPackages = commissionService.getCommissionPackages(null, "001");
        Assert.assertEquals(ErrorCode.OPERATION_SUCCESS, commissionPackages.getErrorCode());
        Assert.assertEquals(new ArrayList<>(), commissionPackages.getPayLoad());
    }

    @org.junit.jupiter.api.Test
    @DisplayName("getCommissionPackages_success_Filed")
    void getCommissionPackages_Filed() {
        ReflectionTestUtils.setField(commissionService, "commissionPackageRepository", repository);
        ReflectionTestUtils.setField(commissionService, "util", util);
        ReflectionTestUtils.setField(util, "messageSource", messageSource);
        ReflectionTestUtils.setField(commissionService, "tempComponent", tempComponent);
        CommonSearchBean commonSearchBean = new CommonSearchBean();
        String userGroup = "001";
        String userId = "rowi";

         /*=======================================
        Get Mst code
        =======================================*/
        List<CommissionPackage> commissionPackageList = new ArrayList<>();
        Mockito.when(repository.findByTemplateFlagAndUserGroup(YnFlagEnum.N, userGroup))
                .thenReturn(commissionPackageList);

        CommonGetListResponse<CommissionPackageResponseBean> commissionPackages = commissionService.getCommissionPackages(null, "001");
        Assert.assertEquals(ErrorCode.OPERATION_SUCCESS, commissionPackages.getErrorCode());
        Assert.assertEquals(new ArrayList<>(), commissionPackages.getPayLoad());
    }

    @org.junit.jupiter.api.Test
    void getCommissionTemplates() {
    }

    @org.junit.jupiter.api.Test
    void getCommissionByCompanyId() {
    }

    @org.junit.jupiter.api.Test
    void getCommissionByTemplateId() {
    }

    @org.junit.jupiter.api.Test
    void addTranTypeCommissionByCompanyId() {
    }

    @org.junit.jupiter.api.Test
    void addTranTypeCommissionByTemplateId() {

    }

    @org.junit.jupiter.api.Test
    void removeExistingCommissionRecord() {

    }

    @org.junit.jupiter.api.Test
    void getApprovalPendingRecord() {

    }
}
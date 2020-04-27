/*
 * ******************************************************************************
 *  * Copyright 2020 (C) N*able
 *  * @author Roshan Wijendra
 *  ******************************************************************************
 */

package biz.nable.sb.cor.commission.component;

import biz.nable.sb.cor.common.annotation.*;
import biz.nable.sb.cor.common.bean.*;
import biz.nable.sb.cor.common.utility.ActionTypeEnum;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;

@Component
public class TempComponent {

    @TempRecord(actionType = ActionTypeEnum.CREATE)
    public CommonResponseBean createTemp(CommonRequestBean commonRequestBean, String requestId) {
        CommonResponseBean commonResponseBean = new CommonResponseBean();
        commonResponseBean.setReturnCode(HttpStatus.OK.value());
        return commonResponseBean;
    }

    @TempRecord(actionType = ActionTypeEnum.UPDATE)
    public CommonResponseBean updateTemp(CommonRequestBean commonRequestBean, String requestId) {
        CommonResponseBean commonResponseBean = new CommonResponseBean();
        commonResponseBean.setReturnCode(HttpStatus.OK.value());
        return commonResponseBean;
    }

    @TempRecord(actionType = ActionTypeEnum.DELETE)
    public CommonResponseBean deleteTemp(CommonRequestBean commonRequestBean, String requestId) {
        CommonResponseBean commonResponseBean = new CommonResponseBean();
        commonResponseBean.setReturnCode(HttpStatus.OK.value());
        return commonResponseBean;
    }

    @FindTempRecord
    public CommonSearchBean getTempRecord(CommonSearchBean commonSearchBean) {
        return commonSearchBean;
    }

    @AuthPending
    public CommonSearchBean getAuthPendingRecord(CommonSearchBean commonSearchBean) {
        return commonSearchBean;
    }

    @FindTempRecordByRef
    public TempDto getTempRecordByRef(FindTempByRefBean findTempByRefBean) {
        return new TempDto();
    }

    @Approve
    public ApprovalResponseBean doApprove(ApprovalBean approvalBean) {
        return new ApprovalResponseBean();
    }

}

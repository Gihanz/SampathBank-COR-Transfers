
/*
 * ******************************************************************************
 *  * Copyright 2020 (C) N*able
 *  * @author Roshan Wijendra
 *  ******************************************************************************
 */

package biz.nable.sb.cor.transfer.bean;

import biz.nable.sb.cor.transfer.constants.*;
import lombok.Data;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.Date;

@Data
public class TransferBean {
    @NotNull
    @Size(max = 50)
    private String accountName;
    private Float amount;
    @NotNull
    @Size(max = 20)
    private String bankCode;
    @Size(max = 20)
    private String branchCode;
    @Size(max = 30)
    private String commissionAccount;
    @Size(max = 30)
    private String companyId;
    @Size(max = 50)
    private String companyRef;
    private String corporatePayee;
    private Date endDate;
    private Date executionDate;
    @Size(max = 30)
    private String fromAccount;
    @Size(max = 20)
    private String mCahReceiverMobile;
    private OccurrenceEnum occurrence;
    private String period;
    @Size(max = 20)
    private String receiverMobile;
    @Size(max = 50)
    private String receiverName;
    @Size(max = 30)
    private String receiverNic;
    @Size(max = 350)
    private String remarks;
    private YnFlagEnum retryFlag;
    @Size(max = 20)
    private String retryRef;
    @Size(max = 20)
    private String senderMobile;
    private YnFlagEnum scheduleFlag;
    private Date startDate;
    @Size(max = 30)
    private String toAccount;
    private Long transferCount;
    private Date transferDate;
    private TransferFrequency transferFrequency;
    private TransferMode transferMode;
    private TransferType transferType;
}

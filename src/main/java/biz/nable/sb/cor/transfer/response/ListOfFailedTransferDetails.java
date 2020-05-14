package biz.nable.sb.cor.transfer.response;

import java.util.Date;

import biz.nable.sb.cor.common.utility.RecordStatusEnum;
import biz.nable.sb.cor.transfer.constants.TransferFrequency;
import biz.nable.sb.cor.transfer.constants.TransferMode;
import biz.nable.sb.cor.transfer.constants.TransferType;
import biz.nable.sb.cor.transfer.constants.YnFlagEnum;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class ListOfFailedTransferDetails {

	private Long transferReqId;
    private TransferType transferType;
    private TransferMode transferMode;
    private String fromAccount;
    private String toAccount;
    private float amount;
    private String companyRef;
    private String remark;
    private YnFlagEnum scheduleFlag;    
    private String createdBy;
    private Date createdOn;
    private String companyId;
    private String accountName;
    private String bankCode;
    private String branchCode;
    private String commissionAccount;
    private float commissionValue;
    private RecordStatusEnum commissionStatus;
    private RecordStatusEnum wfStatus;
    private String wfComment;
    private RecordStatusEnum transferStatus;
    private String transferCode;
    private String transferReference;
    private YnFlagEnum retryFlag;
    private YnFlagEnum retryRef;
    private String receiverNic;
    private String receiverName;
    private String senderMobile;
    private String receiverMobile;
    private String corporatePayee;
    private Long occurrence;
    private Date transferDate;
    private TransferFrequency transferFrequency;
    private Long transferCount;
    private String period;
    private Date startDate;
    private Date endDate;
    private Date executionDate;
}

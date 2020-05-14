
package biz.nable.sb.cor.transfer.db.models;

import biz.nable.sb.cor.common.utility.RecordStatusEnum;
import biz.nable.sb.cor.transfer.constants.TransferFrequency;
import biz.nable.sb.cor.transfer.constants.TransferMode;
import biz.nable.sb.cor.transfer.constants.TransferType;
import biz.nable.sb.cor.transfer.constants.YnFlagEnum;

import lombok.Data;

import javax.persistence.*;
import java.util.Date;

@Data
@Entity
@Table(name = "SB_COR_TRANSFER_REQUEST")
public class TransferRequest {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "TRANSFER_REQUEST_SEQ")
    @SequenceGenerator(name = "TRANSFER_REQUEST_SEQ", sequenceName = "SB_COR_TRANSFER_REQUEST_SEQ", allocationSize = 1)
    private Long id;
    private TransferType transferType;
    private TransferMode transferMode;
    @Column(length = 30)
    private String fromAccount;
    @Column(length = 30)
    private String toAccount;
    private float amount;
    @Column(length = 50)
    private String companyRef;
    @Column(length = 350)
    private String remark;
    private YnFlagEnum scheduleFlag;
    @Column(length = 30)
    private String companyId;
    @Column(length = 30)
    private String createdUser;
    private Date createdDate;
    /* Other Account Details */
    @Column(length = 50)
    private String accountName;
    @Column(length = 20)
    private String bankCode;
    @Column(length = 20)
    private String branchCode;
    /* Workflow and execution */
    private float commissionValue;
    private RecordStatusEnum commissionStatus;
    @Column(length = 30)
    private String commissionAccount;
    @Column(length = 20)
    private String wfValue;
    private RecordStatusEnum wfStatus;
    @Column(length = 350)
    private String wfComment;
    private RecordStatusEnum transferStatus;
    @Column(length = 20)
    private String transferCode;
    @Column(length = 20)
    private String transferReference;
    private YnFlagEnum retryFlag;
    private YnFlagEnum retryRef;
    /* Mobile cash details */
    @Column(length = 30)
    private String receiverNic;
    @Column(length = 50)
    private String receiverName;
    @Column(length = 20)
    private String receiverMobile;
    @Column(length = 20)
    private String senderMobile;
    /* Corporate details */
    @Column(length = 20)
    private String corporatePayee;
    /* Schedule related details */
    private Date transferDate;
    private TransferFrequency transferFrequency;
    private Long transferCount;
    private String period;
    private Date startDate;
    private Date endDate;
    private Date executionDate;
    private Long occurrence;
    private Long scheduleId;
}

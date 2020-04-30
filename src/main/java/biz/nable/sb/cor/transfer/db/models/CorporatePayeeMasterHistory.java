package biz.nable.sb.cor.transfer.db.models;


import biz.nable.sb.cor.common.db.audit.Auditable;
import biz.nable.sb.cor.common.utility.RecordStatusEnum;
import biz.nable.sb.cor.common.utility.StatusEnum;
import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

@Data
@Entity
@Table(name = "SB_COR_CORPORATE_PAYEE_MASTER_HISTORY")
public class CorporatePayeeMasterHistory extends Auditable {

    @Id
    private Long corPayeeID;
    @Column(length = 30)
    private String companyId;
    @Column(length = 350)
    private String reference;
    @Column(length = 50)
    private String accountName;
    @Column(length = 50)
    private String accountNickName;
    @Column(length = 20)
    private String accountNumber;
    @Column(length = 20)
    private String bankCode;
    @Column(length = 20)
    private String branchCode;
    @Column(length = 12)
    private String receiverNIC;
    @Column(length = 10)
    private String receiverMobile;
    @Column(length = 30)
    private String receiverEmail;
    private StatusEnum status;
    private RecordStatusEnum wfStatus;
    @Column(length = 350)
    private String wfComment;
    @Column(length = 50)
    private String companyName;
    @Column(length = 30)
    private String deletedBy;
    private Date deleteNo;

}

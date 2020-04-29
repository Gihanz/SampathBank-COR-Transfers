package biz.nable.sb.cor.transfer.db.models;

import biz.nable.sb.cor.common.db.audit.Auditable;
import biz.nable.sb.cor.common.utility.RecordStatusEnum;
import biz.nable.sb.cor.common.utility.StatusEnum;
import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "SB_COR_CORPORATE_PAYEE_MASTER")
public class CorporatePayeeMaster extends Auditable {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "CORPORATE_PAYEE_MST_SEQ")
    @SequenceGenerator(name = "CORPORATE_PAYEE_MST_SEQ", sequenceName = "SB_COR_CORPORATE_PAYEE_MASTER_SEQ", allocationSize = 1)
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
}

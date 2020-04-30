package biz.nable.sb.cor.transfer.db.models;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

@Data
@Entity
@Table(name = "SB_COR_CP_APPROVALS_HISTORY")
public class CpApprovalHistory {

    @Id
    private Long CpApprovalID;
    @Column(length = 30)
    private String fromAccount;
    @Column(length = 30)
    private String userGroup;
    private Date approvalDate;
    @Column(length = 30)
    private String corporatePayee;
}

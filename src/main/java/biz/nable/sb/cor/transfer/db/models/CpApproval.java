package biz.nable.sb.cor.transfer.db.models;

import lombok.Data;

import javax.persistence.*;
import java.util.Date;
import javax.persistence.Id;

@Data
@Entity
@Table(name = "SB_COR_CP_APPROVALS")
public class CpApproval {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "CP_APPROVALS_SEQ")
    @SequenceGenerator(name = "CP_APPROVALS_SEQ", sequenceName = "SB_COR_CP_APPROVALS_SEQ", allocationSize = 1)
    private Long cpApprovalID;
    @Column(length = 30)
    private String fromAccount;
    @Column(length = 30)
    private String userGroup;
    private Date approvalDate;
    @Column(length = 30)
    private String corporatePayee;
}

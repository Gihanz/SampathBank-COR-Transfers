/*
 * ******************************************************************************
 *  * Copyright 2020 (C) N*able
 *  * @author Roshan Wijendra
 *  ******************************************************************************
 */

package biz.nable.sb.cor.transfer.db.models;

import biz.nable.sb.cor.common.utility.RecordStatusEnum;
import biz.nable.sb.cor.transfer.constants.TransferFrequency;
import lombok.Data;

import javax.persistence.*;
import java.util.Date;

@Data
@Entity
@Table(name = "SB_COR_COMMISSION_COLLECTION")
public class CommissionCollection {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "COMMISSION_COLLECTION_SEQ")
    @SequenceGenerator(name = "COMMISSION_COLLECTION_SEQ", sequenceName = "SB_COR_COMMISSION_COLLECTION_SEQ", allocationSize = 1)
    private Long id;
    private Long transferId;
    private String companyId;
    private String createdBy;
    private String userGroup;
    private Float amount;
    private TransferFrequency frequency;
    private String drAccount;
    private Date executionTime;
    private RecordStatusEnum transferStatus;
    private String transferType;
}

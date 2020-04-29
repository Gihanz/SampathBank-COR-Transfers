/*
 * ******************************************************************************
 *  * Copyright 2020 (C) N*able
 *  * @author Roshan Wijendra
 *  ******************************************************************************
 */

package biz.nable.sb.cor.transfer.db.models;

import lombok.Data;

import javax.persistence.*;
import java.util.Date;

@Data
@Entity
@Table(name = "SB_COR_TRANSFER_STATS")
public class TransferStats {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "TRANSFER_STATS_SEQ")
    @SequenceGenerator(name = "TRANSFER_STATS_SEQ", sequenceName = "SB_COR_TRANSFER_STATS", allocationSize = 1)
    private Long id;
    private String companyId;
    private String userId;
    private String userGroup;
    private Date lastUpdated;
    private Float dailyAmount;
    private Float monthlyAmount;
    private Float yearlyAmount;
    private Long dailyCount;
    private Long monthlyCount;
    private Long yearlyCount;
}

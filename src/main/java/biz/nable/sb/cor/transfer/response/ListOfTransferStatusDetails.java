package biz.nable.sb.cor.transfer.response;

import lombok.*;

import java.util.Date;

import biz.nable.sb.cor.common.utility.RecordStatusEnum;
import biz.nable.sb.cor.transfer.constants.TransferType;

@Data
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ListOfTransferStatusDetails {

    private TransferType transferType;
    private Date startDate;
    private Date endDate;
    private float amount;
    private Long transferId;
    private String transferReference;
    private Long scheduleId;
    private RecordStatusEnum transferStatus;
    
}

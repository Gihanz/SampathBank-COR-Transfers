package biz.nable.sb.cor.transfer.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;

import biz.nable.sb.cor.common.utility.RecordStatusEnum;
import biz.nable.sb.cor.transfer.constants.TransferType;

import java.util.Date;

@Data
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class GetAdvanceTransferStatusRequest {

    private String companyId;
    private TransferType transferType;
    private Date transferRequestDate;
    @Min(value = 0, message = "Invalid transfer Amount")
    private float amount;
    private String referenceId;
    private Long transferId;
    private Long scheduleId;
    private RecordStatusEnum transferStatus;

}

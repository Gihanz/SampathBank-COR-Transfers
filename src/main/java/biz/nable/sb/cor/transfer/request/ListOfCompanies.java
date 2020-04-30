package biz.nable.sb.cor.transfer.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.validation.constraints.NotBlank;
import java.util.Date;

@Data
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class ListOfCompanies {

    @NotBlank(message = "company ID can't be null-TCT09")
    private String companyId;

    @NotBlank(message = "company ID can't be null-TCT09")
    private String transferType;

    private Date startTransferRequestDate;
    private Date endTransferRequestDate;
    private String fromTransferAmount;
    private String toTransferAmount;
    private String referenceId;
    private String transferId;
    private String scheduledId;
    private String transferStatus;

}

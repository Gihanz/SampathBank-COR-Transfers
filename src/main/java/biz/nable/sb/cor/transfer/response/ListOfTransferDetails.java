package biz.nable.sb.cor.transfer.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.Date;

@Data
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class ListOfTransferDetails {

    private String transferType;
    private String transferMode;
    private String fromAccount;
    private String toAccount;
    private String amount;
    private String companyRef;
    private String remarks;
    private String scheduleFlag;
    private String companyId;
    private String accountName;
    private String bankCode;
    private String branchCode;
    private String receiverMobile;
    private String commissionAccount;
    private String retryFlag;
    private String retryRef;
    private String receiverNic;
    private String receiverName;
    private String senderMobile;
    private String corporatePayee;
    private String occurrence;
    private Date transferDate;
    private String transferFrequency;
    private String transferCount;
    private String period;
    private Date startDate;
    private Date endDate;
    private Date executionDate;
}

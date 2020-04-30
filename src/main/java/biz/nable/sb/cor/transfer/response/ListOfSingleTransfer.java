package biz.nable.sb.cor.transfer.response;

import lombok.*;

import java.util.Date;

@Data
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ListOfSingleTransfer {

    private String referenceId;
    private String transactionId;
    private Date transactionDate ;
    private String mc;
    private String category;
    private String currency ;
    private String amount;
    private String fromAccount;
    private String toAccountOrMobile;
    private String transferStatus;
}

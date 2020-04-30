package biz.nable.sb.cor.transfer.response;

import biz.nable.sb.cor.common.response.CommonResponse;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.Set;

@Data
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class GetSingleTransferResponse extends CommonResponse {

    public GetSingleTransferResponse(int returnCode, String returnMessage, String errorCode) {
        super(returnCode, returnMessage, errorCode);
    }

    Set<ListOfSingleTransfer> listOfCompaniesSet;
}

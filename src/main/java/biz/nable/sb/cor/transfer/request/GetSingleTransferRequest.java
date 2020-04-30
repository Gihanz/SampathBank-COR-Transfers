package biz.nable.sb.cor.transfer.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.validation.Valid;
import java.util.Set;


@Data
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class GetSingleTransferRequest {

    @Valid
    Set<ListOfCompanies> listOfCompaniesSet;
}

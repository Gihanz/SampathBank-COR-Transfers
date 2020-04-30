package biz.nable.sb.cor.transfer.db.repository;

import biz.nable.sb.cor.transfer.db.models.TransferRequest;
import org.springframework.data.repository.CrudRepository;


public interface TransferRepository extends CrudRepository<TransferRequest, Long> {

//    Set<TransferRequest> findByCompanyIdAndTransferTypeAndStartDateAndEndDateAnd
}

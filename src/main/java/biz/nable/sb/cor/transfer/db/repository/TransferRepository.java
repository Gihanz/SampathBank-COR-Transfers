package biz.nable.sb.cor.transfer.db.repository;

import biz.nable.sb.cor.transfer.constants.TransferType;
import biz.nable.sb.cor.transfer.db.models.TransferRequest;

import java.util.Set;

import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;


public interface TransferRepository extends CrudRepository<TransferRequest, Long> ,JpaSpecificationExecutor<TransferRequest>{

    Set<TransferRequest> findByTransferType(@Param("transferType") TransferType transferType);

}

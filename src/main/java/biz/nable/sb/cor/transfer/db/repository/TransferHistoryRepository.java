package biz.nable.sb.cor.transfer.db.repository;

import java.util.Set;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import biz.nable.sb.cor.common.utility.RecordStatusEnum;
import biz.nable.sb.cor.transfer.constants.YnFlagEnum;
import biz.nable.sb.cor.transfer.db.models.TransferRequestHistory;


public interface TransferHistoryRepository extends CrudRepository<TransferRequestHistory, Long>{

	Set<TransferRequestHistory> findByRetryFlagAndTransferStatus(@Param("retryFlag") YnFlagEnum retryFlag, @Param("transferStatus") RecordStatusEnum transferStatus);
}

package biz.nable.sb.cor.transfer.db.repository;

import java.util.Set;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import biz.nable.sb.cor.transfer.db.models.CorporatePayeeMaster;


public interface CorporatePayeeRepository extends CrudRepository<CorporatePayeeMaster, Long>{

	Set<CorporatePayeeMaster> findByCompanyId(@Param("companyId") String companyId);
}

package biz.nable.sb.cor.transfer.dao;
/**
 * @author GIHAN
 *
 */


import biz.nable.sb.cor.transfer.response.GetCorporatePayeeTemplateResponse;

public interface AdminDao {

	 public GetCorporatePayeeTemplateResponse getCorporatePayeeTemplate(String companyId, String userId, String requestId);
}

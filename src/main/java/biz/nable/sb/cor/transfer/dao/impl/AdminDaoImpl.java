package biz.nable.sb.cor.transfer.dao.impl;

import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import biz.nable.sb.cor.common.utility.RecordStatusEnum;
import biz.nable.sb.cor.common.utility.StatusEnum;
import biz.nable.sb.cor.transfer.dao.AdminDao;
import biz.nable.sb.cor.transfer.response.GetCorporatePayeeTemplateResponse;
import biz.nable.sb.cor.transfer.response.ListOfCorporatePayeeTemplate;

/**
 * @author GIHAN
 *
 */

@Repository
public class AdminDaoImpl implements AdminDao{
	
	private Logger logger = LoggerFactory.getLogger(AdminDaoImpl.class);
	
	@PersistenceContext
	private EntityManager entityManager;
	
    public GetCorporatePayeeTemplateResponse getCorporatePayeeTemplate(String companyId, String userId, String requestId) {
    	
    	String corporatePayeeTemplateSQL = "select companyId, reference, accountName, accountNickName, accountNumber, bankCode, branchCode, receiverNIC, receiverMobile, receiverEmail, status, wfStatus, wfComment, createdBy, createdDate, lastUpdatedBy, lastUpdatedDate from CorporatePayeeMaster";
    	logger.debug("sql : "+corporatePayeeTemplateSQL);
    	Query qry = entityManager.createQuery(corporatePayeeTemplateSQL);
    	List<Object[]> corporatePayeeTemplateLst = qry.getResultList();
    	logger.info(corporatePayeeTemplateLst.toString());
    	
    	GetCorporatePayeeTemplateResponse getCorporatePayeeTemplateResponse = new GetCorporatePayeeTemplateResponse();
    	
    	if(corporatePayeeTemplateLst != null) {
    		
    		Set<ListOfCorporatePayeeTemplate> listOfCorporatePayeeTemplateSet = new HashSet<>();
    		
    		for(Object[] corPayeeTemplateItem : corporatePayeeTemplateLst) {
    			
    			ListOfCorporatePayeeTemplate listOfCorporatePayeeTemplate = new ListOfCorporatePayeeTemplate();
    			listOfCorporatePayeeTemplate.setCompanyId(corPayeeTemplateItem[0] != null ? (String)corPayeeTemplateItem[0] : null);
    			listOfCorporatePayeeTemplate.setReference(corPayeeTemplateItem[1] != null ? (String)corPayeeTemplateItem[1] : null);
    			listOfCorporatePayeeTemplate.setAccountName(corPayeeTemplateItem[2] != null ? (String)corPayeeTemplateItem[2] : null);
    			listOfCorporatePayeeTemplate.setAccountNickName(corPayeeTemplateItem[3] != null ? (String)corPayeeTemplateItem[3] : null);
    			listOfCorporatePayeeTemplate.setAccountNumber(corPayeeTemplateItem[4] != null ? (String)corPayeeTemplateItem[4] : null);
    			listOfCorporatePayeeTemplate.setBankCode(corPayeeTemplateItem[5] != null ? (String)corPayeeTemplateItem[5] : null);
    			listOfCorporatePayeeTemplate.setBranchCode(corPayeeTemplateItem[6] != null ? (String)corPayeeTemplateItem[6] : null);
    			listOfCorporatePayeeTemplate.setReceiverNic(corPayeeTemplateItem[7] != null ? (String)corPayeeTemplateItem[7] : null);
    			listOfCorporatePayeeTemplate.setReceiverMobile(corPayeeTemplateItem[8] != null ? (String)corPayeeTemplateItem[8] : null);
    			listOfCorporatePayeeTemplate.setReceiverEmail(corPayeeTemplateItem[9] != null ? (String)corPayeeTemplateItem[9] : null);
    			listOfCorporatePayeeTemplate.setStatus(corPayeeTemplateItem[10] != null ? (StatusEnum)corPayeeTemplateItem[10] : null);
    			listOfCorporatePayeeTemplate.setWfStatus(corPayeeTemplateItem[11] != null ? (RecordStatusEnum)corPayeeTemplateItem[11] : null);   			
    			listOfCorporatePayeeTemplate.setWfComment(corPayeeTemplateItem[12] != null ? (String)corPayeeTemplateItem[12] : null);
    			listOfCorporatePayeeTemplate.setCreatedBy(corPayeeTemplateItem[13] != null ? (String)corPayeeTemplateItem[13] : null);
    			listOfCorporatePayeeTemplate.setCreatedDate(corPayeeTemplateItem[14] != null ? (Date)corPayeeTemplateItem[14] : null);
    			listOfCorporatePayeeTemplate.setModifiedBy(corPayeeTemplateItem[15] != null ? (String)corPayeeTemplateItem[15] : null);
    			listOfCorporatePayeeTemplate.setModifiedDate(corPayeeTemplateItem[16] != null ? (Date)corPayeeTemplateItem[16] : null);
    			   			
    			listOfCorporatePayeeTemplateSet.add(listOfCorporatePayeeTemplate);
    		}
	
        	getCorporatePayeeTemplateResponse.setListOfCorporatePayeeTemplate(listOfCorporatePayeeTemplateSet);
        	getCorporatePayeeTemplateResponse.setReturnCode(200);
        	getCorporatePayeeTemplateResponse.setReturnMessage("Successfully Submitted For Approval");
    	}
    	
        return getCorporatePayeeTemplateResponse;
    }

}

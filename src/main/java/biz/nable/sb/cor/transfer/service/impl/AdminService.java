package biz.nable.sb.cor.transfer.service.impl;

import biz.nable.sb.cor.common.utility.RecordStatusEnum;
import biz.nable.sb.cor.transfer.constants.YnFlagEnum;
import biz.nable.sb.cor.transfer.dao.AdminDao;
import biz.nable.sb.cor.transfer.db.models.CorporatePayeeMaster;
import biz.nable.sb.cor.transfer.db.models.TransferRequest;
import biz.nable.sb.cor.transfer.db.models.TransferRequestHistory;
import biz.nable.sb.cor.transfer.db.repository.CorporatePayeeRepository;
import biz.nable.sb.cor.transfer.db.repository.TransferHistoryRepository;
import biz.nable.sb.cor.transfer.db.repository.TransferRepository;
import biz.nable.sb.cor.transfer.request.GetAdvanceTransferStatusRequest;
import biz.nable.sb.cor.transfer.request.GetSingleTransferRequest;
import biz.nable.sb.cor.transfer.response.GetAdvanceTransferStatusResponse;
import biz.nable.sb.cor.transfer.response.GetCorporatePayeeTemplateResponse;
import biz.nable.sb.cor.transfer.response.GetFailedTransferDetailsResponse;
import biz.nable.sb.cor.transfer.response.GetSingleTransferResponse;
import biz.nable.sb.cor.transfer.response.GetTransferDetailsResponse;
import biz.nable.sb.cor.transfer.response.ListOfCorporatePayeeTemplate;
import biz.nable.sb.cor.transfer.response.ListOfFailedTransferDetails;
import biz.nable.sb.cor.transfer.response.ListOfTransferStatusDetails;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class AdminService {

    public GetSingleTransferResponse getSingleTransferStatusInquiryDetails(GetSingleTransferRequest getSingleTransferRequest, String userId, String requestId){
        return new GetSingleTransferResponse();
    }

    public GetTransferDetailsResponse getTransferInquiryDetails(String transferId, String userId, String requestId){
        return new GetTransferDetailsResponse();
    }
    
    @Autowired
    private CorporatePayeeRepository corporatePayeeRepository;
     
    @Transactional
    public GetCorporatePayeeTemplateResponse getCorporatePayeeTemplate(String companyId, String userId, String requestId) {
    	
        //return adminDao.getCorporatePayeeTemplate(companyId, userId, requestId);
    	GetCorporatePayeeTemplateResponse getCorporatePayeeTemplateResponse = new GetCorporatePayeeTemplateResponse();
    	
    	Iterable<CorporatePayeeMaster> it = corporatePayeeRepository.findByCompanyId(companyId);
    	Iterator <CorporatePayeeMaster> iterator = it.iterator();
    	
    	Set<ListOfCorporatePayeeTemplate> listOfCorporatePayeeTemplateSet = new HashSet<>();
    	
    	while (iterator.hasNext()) {
    		ListOfCorporatePayeeTemplate listOfCorporatePayeeTemplate = new ListOfCorporatePayeeTemplate();
    		CorporatePayeeMaster corporatePayeeMaster = iterator.next();
    		
    		listOfCorporatePayeeTemplate.setCompanyId(corporatePayeeMaster.getCompanyId());
    		listOfCorporatePayeeTemplate.setReference(corporatePayeeMaster.getReference());
    		listOfCorporatePayeeTemplate.setAccountName(corporatePayeeMaster.getAccountName());
    		listOfCorporatePayeeTemplate.setAccountNickName(corporatePayeeMaster.getAccountNickName());
    		listOfCorporatePayeeTemplate.setAccountNumber(corporatePayeeMaster.getAccountNumber());
    		listOfCorporatePayeeTemplate.setBankCode(corporatePayeeMaster.getBankCode());
    		listOfCorporatePayeeTemplate.setBranchCode(corporatePayeeMaster.getBranchCode());
    		listOfCorporatePayeeTemplate.setReceiverNic(corporatePayeeMaster.getReceiverNIC());
    		listOfCorporatePayeeTemplate.setReceiverMobile(corporatePayeeMaster.getReceiverMobile());
    		listOfCorporatePayeeTemplate.setReceiverEmail(corporatePayeeMaster.getReceiverEmail());
    		listOfCorporatePayeeTemplate.setStatus(corporatePayeeMaster.getStatus());
    		listOfCorporatePayeeTemplate.setWfStatus(corporatePayeeMaster.getWfStatus());
    		listOfCorporatePayeeTemplate.setWfComment(corporatePayeeMaster.getWfComment());
    		listOfCorporatePayeeTemplate.setCreatedBy(corporatePayeeMaster.getCreatedBy());
    		listOfCorporatePayeeTemplate.setCreatedDate(corporatePayeeMaster.getCreatedDate());
    		listOfCorporatePayeeTemplate.setModifiedBy(corporatePayeeMaster.getLastUpdatedBy());
    		listOfCorporatePayeeTemplate.setModifiedDate(corporatePayeeMaster.getLastUpdatedDate());
    		
            listOfCorporatePayeeTemplateSet.add(listOfCorporatePayeeTemplate);
        }
    	
    	getCorporatePayeeTemplateResponse.setListOfCorporatePayeeTemplate(listOfCorporatePayeeTemplateSet);
    	getCorporatePayeeTemplateResponse.setReturnCode(200);
    	getCorporatePayeeTemplateResponse.setReturnMessage("Get corporate payee template successful");
    	
    	return getCorporatePayeeTemplateResponse;
    }
    
    @Autowired
    private TransferHistoryRepository transferHistoryRepository;
    
    @Transactional
    public GetFailedTransferDetailsResponse getFailedTransferDetails(YnFlagEnum retryFlag, RecordStatusEnum transferStatus, String userId, String requestId) {
    	
    	GetFailedTransferDetailsResponse getFailedTransferDetailsResponse = new GetFailedTransferDetailsResponse();

    	Iterable<TransferRequestHistory> it = transferHistoryRepository.findByRetryFlagAndTransferStatus(retryFlag, transferStatus);
    	Iterator<TransferRequestHistory> iterator = it.iterator();
    	
    	Set<ListOfFailedTransferDetails> listOfFailedTransferDetailsSet = new HashSet<>();
    	
    	while (iterator.hasNext()) {
    		ListOfFailedTransferDetails listOfFailedTransferDetails = new ListOfFailedTransferDetails();
    		TransferRequestHistory transferRequestHistory = iterator.next();

    		listOfFailedTransferDetails.setTransferReqId(transferRequestHistory.getId());
    		listOfFailedTransferDetails.setTransferType(transferRequestHistory.getTransferType());
    		listOfFailedTransferDetails.setTransferMode(transferRequestHistory.getTransferMode());
    		listOfFailedTransferDetails.setFromAccount(transferRequestHistory.getFromAccount());
    		listOfFailedTransferDetails.setToAccount(transferRequestHistory.getToAccount());
    		listOfFailedTransferDetails.setAmount(transferRequestHistory.getAmount());
    		listOfFailedTransferDetails.setCompanyRef(transferRequestHistory.getCompanyRef());
    		listOfFailedTransferDetails.setRemark(transferRequestHistory.getRemark());
    		listOfFailedTransferDetails.setScheduleFlag(transferRequestHistory.getScheduleFlag());
    		listOfFailedTransferDetails.setCreatedBy(transferRequestHistory.getCreatedUser());
    		listOfFailedTransferDetails.setCreatedOn(transferRequestHistory.getCreatedDate());
    		listOfFailedTransferDetails.setCompanyId(transferRequestHistory.getCompanyId());
    		listOfFailedTransferDetails.setAccountName(transferRequestHistory.getAccountName());    		
    		listOfFailedTransferDetails.setBankCode(transferRequestHistory.getBankCode());
    		listOfFailedTransferDetails.setBranchCode(transferRequestHistory.getBranchCode());    		
    		listOfFailedTransferDetails.setCommissionAccount(transferRequestHistory.getCommissionAccount());
    		listOfFailedTransferDetails.setCommissionValue(transferRequestHistory.getCommissionValue());
    		listOfFailedTransferDetails.setCommissionStatus(transferRequestHistory.getCommissionStatus());
    		listOfFailedTransferDetails.setWfStatus(transferRequestHistory.getWfStatus());
    		listOfFailedTransferDetails.setWfComment(transferRequestHistory.getWfComment());
    		listOfFailedTransferDetails.setTransferStatus(transferRequestHistory.getTransferStatus());
    		listOfFailedTransferDetails.setTransferCode(transferRequestHistory.getTransferCode());
    		listOfFailedTransferDetails.setTransferReference(transferRequestHistory.getTransferReference());
    		listOfFailedTransferDetails.setRetryFlag(transferRequestHistory.getRetryFlag());
    		listOfFailedTransferDetails.setRetryRef(transferRequestHistory.getRetryRef());
    		listOfFailedTransferDetails.setReceiverNic(transferRequestHistory.getReceiverNic());
    		listOfFailedTransferDetails.setReceiverName(transferRequestHistory.getReceiverName());
    		listOfFailedTransferDetails.setSenderMobile(transferRequestHistory.getSenderMobile());    		
    		listOfFailedTransferDetails.setReceiverMobile(transferRequestHistory.getReceiverMobile());
    		listOfFailedTransferDetails.setCorporatePayee(transferRequestHistory.getCorporatePayee());
    		listOfFailedTransferDetails.setOccurrence(transferRequestHistory.getOccurrence());
    		listOfFailedTransferDetails.setTransferDate(transferRequestHistory.getTransferDate());
    		listOfFailedTransferDetails.setTransferFrequency(transferRequestHistory.getTransferFrequency());
    		listOfFailedTransferDetails.setTransferCount(transferRequestHistory.getTransferCount());
    		listOfFailedTransferDetails.setPeriod(transferRequestHistory.getPeriod());
    		listOfFailedTransferDetails.setStartDate(transferRequestHistory.getStartDate());
    		listOfFailedTransferDetails.setEndDate(transferRequestHistory.getEndDate());
    		listOfFailedTransferDetails.setExecutionDate(transferRequestHistory.getExecutionDate());
    		
    		listOfFailedTransferDetailsSet.add(listOfFailedTransferDetails);
        }
    	
    	getFailedTransferDetailsResponse.setListOfFailedTransfers(listOfFailedTransferDetailsSet);
    	getFailedTransferDetailsResponse.setReturnCode(200);
    	getFailedTransferDetailsResponse.setReturnMessage("Get failed transfers request successful");
    	
    	return getFailedTransferDetailsResponse;
    }
     
    @Autowired
    private TransferRepository transferRepository;
    
    @Transactional
    public GetAdvanceTransferStatusResponse getAdvanceTransferStatus(GetAdvanceTransferStatusRequest getAdvanceTransferStatusRequest, String userId, String requestId) {
    	
    	GetAdvanceTransferStatusResponse getAdvanceTransferStatusResponse = new GetAdvanceTransferStatusResponse();
    	
    	Iterable<TransferRequest> it = transferRepository.findAll(new Specification<TransferRequest>() {

			@Override
			public Predicate toPredicate(Root<TransferRequest> root, CriteriaQuery<?> query, CriteriaBuilder cb) {

				List<Predicate> predicates = new ArrayList<>();

				if (getAdvanceTransferStatusRequest.getCompanyId() != null) {
					predicates.add(cb.equal(root.get("companyId"), getAdvanceTransferStatusRequest.getCompanyId()));
				}
				if (getAdvanceTransferStatusRequest.getTransferType() != null) {
					predicates.add(cb.equal(root.get("transferType"), getAdvanceTransferStatusRequest.getTransferType()));
				}
				if (getAdvanceTransferStatusRequest.getTransferRequestDate() != null) {
					predicates.add(cb.equal(root.get("transferDate"), getAdvanceTransferStatusRequest.getTransferRequestDate()));
				}
				if (getAdvanceTransferStatusRequest.getAmount() != 0.0f) {
					predicates.add(cb.equal(root.get("amount"), getAdvanceTransferStatusRequest.getAmount()));
				}
				if (getAdvanceTransferStatusRequest.getReferenceId() != null) {
					predicates.add(cb.equal(root.get("transferReference"), getAdvanceTransferStatusRequest.getReferenceId()));
				}
				if (getAdvanceTransferStatusRequest.getTransferId() != null) {
					predicates.add(cb.equal(root.get("id"), getAdvanceTransferStatusRequest.getTransferId()));
				}
				if (getAdvanceTransferStatusRequest.getScheduleId() != null) {
					predicates.add(cb.equal(root.get("scheduleId"), getAdvanceTransferStatusRequest.getScheduleId()));
				}
				if (getAdvanceTransferStatusRequest.getTransferStatus() != null) {
					predicates.add(cb.equal(root.get("transferStatus"), getAdvanceTransferStatusRequest.getTransferStatus()));
				}
				return cb.and(predicates.toArray(new Predicate[0]));
			}
		});
    	Iterator <TransferRequest> iterator = it.iterator();
    	
    	Set<ListOfTransferStatusDetails> ListOfTransferStatusSet = new HashSet<>();
    	
    	while (iterator.hasNext()) {
    		ListOfTransferStatusDetails listOfTransferStatusDetails = new ListOfTransferStatusDetails();
    		TransferRequest transferRequest = iterator.next();
    		
    		listOfTransferStatusDetails.setTransferType(transferRequest.getTransferType());
    		listOfTransferStatusDetails.setStartDate(transferRequest.getStartDate());
    		listOfTransferStatusDetails.setEndDate(transferRequest.getEndDate());
    		listOfTransferStatusDetails.setAmount(transferRequest.getAmount());
    		listOfTransferStatusDetails.setTransferId(transferRequest.getId());
    		listOfTransferStatusDetails.setTransferReference(transferRequest.getTransferReference());
    		listOfTransferStatusDetails.setScheduleId(transferRequest.getScheduleId());
    		listOfTransferStatusDetails.setTransferStatus(transferRequest.getTransferStatus());
    		
    		ListOfTransferStatusSet.add(listOfTransferStatusDetails);
        }
    	
    	getAdvanceTransferStatusResponse.setListOfTransferStatus(ListOfTransferStatusSet);
    	getAdvanceTransferStatusResponse.setReturnCode(200);
    	getAdvanceTransferStatusResponse.setReturnMessage("Get advance transfer status successful");
    	
    	return getAdvanceTransferStatusResponse;
    }
    

}

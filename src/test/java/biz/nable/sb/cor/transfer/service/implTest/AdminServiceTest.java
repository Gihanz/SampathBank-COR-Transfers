package biz.nable.sb.cor.transfer.service.implTest;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import org.json.JSONException;
import org.json.JSONObject;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnitRunner;

import biz.nable.sb.cor.common.utility.RecordStatusEnum;
import biz.nable.sb.cor.common.utility.StatusEnum;
import biz.nable.sb.cor.transfer.constants.TransferFrequency;
import biz.nable.sb.cor.transfer.constants.TransferMode;
import biz.nable.sb.cor.transfer.constants.TransferType;
import biz.nable.sb.cor.transfer.constants.YnFlagEnum;
import biz.nable.sb.cor.transfer.db.models.CorporatePayeeMaster;
import biz.nable.sb.cor.transfer.db.models.TransferRequest;
import biz.nable.sb.cor.transfer.db.models.TransferRequestHistory;
import biz.nable.sb.cor.transfer.db.repository.CorporatePayeeRepository;
import biz.nable.sb.cor.transfer.db.repository.TransferHistoryRepository;
import biz.nable.sb.cor.transfer.db.repository.TransferRepository;
import biz.nable.sb.cor.transfer.response.GetCorporatePayeeTemplateResponse;
import biz.nable.sb.cor.transfer.response.GetFailedTransferDetailsResponse;
import biz.nable.sb.cor.transfer.response.ListOfCorporatePayeeTemplate;
import biz.nable.sb.cor.transfer.response.ListOfFailedTransferDetails;
import biz.nable.sb.cor.transfer.service.impl.AdminService;

@RunWith(MockitoJUnitRunner.class)
public class AdminServiceTest {
    
	@Mock
	private CorporatePayeeRepository corporatePayeeRepository;
	@Mock
	private TransferHistoryRepository transferHistoryRepository;
	@Mock
	private TransferRepository transferRepository;
	@Mock
	private CorporatePayeeMaster corporatePayeeMaster;
	@Mock
	private TransferRequestHistory transferRequestHistory;
	
    @InjectMocks
    AdminService adminService;
     
	@Before
    public void init() {
        MockitoAnnotations.initMocks(this);
    }
     
    @Test
    public void getCorporatePayeeTemplateTest(){
        
    	corporatePayeeMaster = new CorporatePayeeMaster();
		corporatePayeeMaster.setCompanyId("345");
		corporatePayeeMaster.setReference("");
		corporatePayeeMaster.setAccountName("");
		corporatePayeeMaster.setAccountNickName("gihan");
		corporatePayeeMaster.setAccountNumber("1745494");
		corporatePayeeMaster.setBankCode("235");
		corporatePayeeMaster.setBranchCode("23");
		corporatePayeeMaster.setReceiverNIC("920904211V");
		corporatePayeeMaster.setReceiverMobile("");
		corporatePayeeMaster.setReceiverEmail("jayan@mit.com");
		corporatePayeeMaster.setStatus(StatusEnum.REJECTED);
		corporatePayeeMaster.setWfStatus(RecordStatusEnum.REJECTED);
		corporatePayeeMaster.setWfComment("");
		corporatePayeeMaster.setCreatedBy("gihan");
		corporatePayeeMaster.setCreatedDate(new Date());
		corporatePayeeMaster.setLastUpdatedBy("jayan");
		corporatePayeeMaster.setLastUpdatedDate(new Date());

		Set<CorporatePayeeMaster> corporatePayeeMasterSet = new HashSet<>();
		corporatePayeeMasterSet.add(corporatePayeeMaster);
		
	    when(corporatePayeeRepository.findByCompanyId("345")).thenReturn(corporatePayeeMasterSet);

        GetCorporatePayeeTemplateResponse adminSvc = adminService.getCorporatePayeeTemplate("345", "userId", "requestId");
        
        Set<ListOfCorporatePayeeTemplate> listOfCorporatePayeeTemplateSet = new HashSet<>();
        ListOfCorporatePayeeTemplate listOfCorporatePayeeTemplate = new ListOfCorporatePayeeTemplate();
        listOfCorporatePayeeTemplate.setCompanyId("345");
        listOfCorporatePayeeTemplate.setReference("");
        listOfCorporatePayeeTemplate.setAccountName("");
        listOfCorporatePayeeTemplate.setAccountNickName("gihan");
        listOfCorporatePayeeTemplate.setAccountNumber("1745494");
        listOfCorporatePayeeTemplate.setBankCode("235");
        listOfCorporatePayeeTemplate.setBranchCode("23");
        listOfCorporatePayeeTemplate.setReceiverNic("920904211V");
        listOfCorporatePayeeTemplate.setReceiverMobile("");
        listOfCorporatePayeeTemplate.setReceiverEmail("jayan@mit.com");
        listOfCorporatePayeeTemplate.setStatus(StatusEnum.REJECTED);
        listOfCorporatePayeeTemplate.setWfStatus(RecordStatusEnum.REJECTED);
        listOfCorporatePayeeTemplate.setWfComment("");
        listOfCorporatePayeeTemplate.setCreatedBy("gihan");
        listOfCorporatePayeeTemplate.setCreatedDate(new Date());
        listOfCorporatePayeeTemplate.setModifiedBy("jayan");
        listOfCorporatePayeeTemplate.setModifiedDate(new Date());
        listOfCorporatePayeeTemplateSet.add(listOfCorporatePayeeTemplate);
        
        assertEquals(listOfCorporatePayeeTemplateSet.iterator().next().getCompanyId(), adminSvc.getListOfCorporatePayeeTemplate().iterator().next().getCompanyId());
        assertEquals(listOfCorporatePayeeTemplateSet.iterator().next().getReference(), adminSvc.getListOfCorporatePayeeTemplate().iterator().next().getReference());
        assertEquals(listOfCorporatePayeeTemplateSet.iterator().next().getAccountName(), adminSvc.getListOfCorporatePayeeTemplate().iterator().next().getAccountName());
        assertEquals(listOfCorporatePayeeTemplateSet.iterator().next().getAccountNickName(), adminSvc.getListOfCorporatePayeeTemplate().iterator().next().getAccountNickName());
        assertEquals(listOfCorporatePayeeTemplateSet.iterator().next().getAccountNumber(), adminSvc.getListOfCorporatePayeeTemplate().iterator().next().getAccountNumber());
        assertEquals(listOfCorporatePayeeTemplateSet.iterator().next().getBankCode(), adminSvc.getListOfCorporatePayeeTemplate().iterator().next().getBankCode());
        assertEquals(listOfCorporatePayeeTemplateSet.iterator().next().getBranchCode(), adminSvc.getListOfCorporatePayeeTemplate().iterator().next().getBranchCode());
        assertEquals(listOfCorporatePayeeTemplateSet.iterator().next().getReceiverNic(), adminSvc.getListOfCorporatePayeeTemplate().iterator().next().getReceiverNic());
        assertEquals(listOfCorporatePayeeTemplateSet.iterator().next().getReceiverMobile(), adminSvc.getListOfCorporatePayeeTemplate().iterator().next().getReceiverMobile());
        assertEquals(listOfCorporatePayeeTemplateSet.iterator().next().getReceiverEmail(), adminSvc.getListOfCorporatePayeeTemplate().iterator().next().getReceiverEmail());
        assertEquals(listOfCorporatePayeeTemplateSet.iterator().next().getStatus(), adminSvc.getListOfCorporatePayeeTemplate().iterator().next().getStatus());
        assertEquals(listOfCorporatePayeeTemplateSet.iterator().next().getWfStatus(), adminSvc.getListOfCorporatePayeeTemplate().iterator().next().getWfStatus());
        assertEquals(listOfCorporatePayeeTemplateSet.iterator().next().getWfComment(), adminSvc.getListOfCorporatePayeeTemplate().iterator().next().getWfComment());
        assertEquals(listOfCorporatePayeeTemplateSet.iterator().next().getCreatedBy(), adminSvc.getListOfCorporatePayeeTemplate().iterator().next().getCreatedBy());
        //assertEquals(listOfCorporatePayeeTemplateSet.iterator().next().getCreatedDate(), adminSvc.getListOfCorporatePayeeTemplate().iterator().next().getCreatedDate());
        assertEquals(listOfCorporatePayeeTemplateSet.iterator().next().getModifiedBy(), adminSvc.getListOfCorporatePayeeTemplate().iterator().next().getModifiedBy());
        //assertEquals(listOfCorporatePayeeTemplateSet.iterator().next().getModifiedDate(), adminSvc.getListOfCorporatePayeeTemplate().iterator().next().getModifiedDate());
        
    }
    
    @Test
    public void getFailedTransferDetailsTest(){
          	
    	transferRequestHistory = new TransferRequestHistory();
    	transferRequestHistory.setId(6l);
    	transferRequestHistory.setTransferType(TransferType.OTHER);
    	transferRequestHistory.setTransferMode(TransferMode.SCHEDULED);
    	transferRequestHistory.setFromAccount("");
    	transferRequestHistory.setToAccount("");
    	transferRequestHistory.setAmount(0);
    	transferRequestHistory.setCompanyRef("");
    	transferRequestHistory.setRemark("");
    	transferRequestHistory.setScheduleFlag(YnFlagEnum.N);
    	transferRequestHistory.setCompanyId("");
    	transferRequestHistory.setCreatedUser("");
    	transferRequestHistory.setCreatedDate(new Date());
    	transferRequestHistory.setAccountName("");
    	transferRequestHistory.setBankCode("");
    	transferRequestHistory.setBranchCode("");
    	transferRequestHistory.setCommissionValue(0);
    	transferRequestHistory.setCommissionStatus(RecordStatusEnum.REJECTED);
    	transferRequestHistory.setCommissionAccount("");
    	transferRequestHistory.setWfValue("");
    	transferRequestHistory.setWfStatus(RecordStatusEnum.REJECTED);
    	transferRequestHistory.setWfComment("");
    	transferRequestHistory.setTransferStatus(RecordStatusEnum.REJECTED);
    	transferRequestHistory.setTransferCode("");
    	transferRequestHistory.setTransferReference("");
    	transferRequestHistory.setRetryFlag(YnFlagEnum.N);
    	transferRequestHistory.setRetryRef(YnFlagEnum.N);
    	transferRequestHistory.setReceiverNic("");
    	transferRequestHistory.setReceiverName("");
    	transferRequestHistory.setReceiverMobile("");
    	transferRequestHistory.setSenderMobile("");
    	transferRequestHistory.setCorporatePayee("");
    	transferRequestHistory.setTransferDate(new Date());
    	transferRequestHistory.setTransferFrequency(TransferFrequency.MONTHLY);
    	transferRequestHistory.setTransferCount(6l);
    	transferRequestHistory.setPeriod("");
    	transferRequestHistory.setStartDate(new Date());
    	transferRequestHistory.setEndDate(new Date());
    	transferRequestHistory.setExecutionDate(new Date());
    	transferRequestHistory.setOccurrence(6l);
    	transferRequestHistory.setScheduleId(6l);
    	
    	Set<TransferRequestHistory> transferRequestHistorySet = new HashSet<>();
    	transferRequestHistorySet.add(transferRequestHistory);
    	
        when(transferHistoryRepository.findByRetryFlagAndTransferStatus(YnFlagEnum.N,RecordStatusEnum.REJECTED)).thenReturn(transferRequestHistorySet);

        YnFlagEnum x= YnFlagEnum.Y;
        RecordStatusEnum y= RecordStatusEnum.REJECTED;
        GetFailedTransferDetailsResponse adminSvc = adminService.getFailedTransferDetails(x, y, "2234","333");
        
        Set<ListOfFailedTransferDetails> listOfFailedTransferDetailsSet = new HashSet<>();
        ListOfFailedTransferDetails listOfFailedTransferDetails = new ListOfFailedTransferDetails();
        //listOfFailedTransferDetails.setTransferReqId(6l);
		listOfFailedTransferDetails.setTransferType(TransferType.OTHER);
		listOfFailedTransferDetails.setTransferMode(TransferMode.SCHEDULED);
		listOfFailedTransferDetails.setFromAccount("");
		listOfFailedTransferDetails.setToAccount("");
		listOfFailedTransferDetails.setAmount(0);
		listOfFailedTransferDetails.setCompanyRef("");
		listOfFailedTransferDetails.setRemark("");
		listOfFailedTransferDetails.setScheduleFlag(YnFlagEnum.N);
		listOfFailedTransferDetails.setCreatedBy("");
		listOfFailedTransferDetails.setCreatedOn(new Date());
		listOfFailedTransferDetails.setCompanyId("");
		listOfFailedTransferDetails.setAccountName("");    		
		listOfFailedTransferDetails.setBankCode("");
		listOfFailedTransferDetails.setBranchCode("");    		
		listOfFailedTransferDetails.setCommissionAccount("");
		listOfFailedTransferDetails.setCommissionValue(0);
		listOfFailedTransferDetails.setCommissionStatus(RecordStatusEnum.REJECTED);
		listOfFailedTransferDetails.setWfStatus(RecordStatusEnum.REJECTED);
		listOfFailedTransferDetails.setWfComment("");
		listOfFailedTransferDetails.setTransferStatus(RecordStatusEnum.REJECTED);
		listOfFailedTransferDetails.setTransferCode("");
		listOfFailedTransferDetails.setTransferReference("");
		listOfFailedTransferDetails.setRetryFlag(YnFlagEnum.N);
		listOfFailedTransferDetails.setRetryRef(YnFlagEnum.N);
		listOfFailedTransferDetails.setReceiverNic("");
		listOfFailedTransferDetails.setReceiverName("");
		listOfFailedTransferDetails.setSenderMobile("");    		
		listOfFailedTransferDetails.setReceiverMobile("");
		listOfFailedTransferDetails.setCorporatePayee("");
		listOfFailedTransferDetails.setOccurrence(6l);
		listOfFailedTransferDetails.setTransferDate(new Date());
		listOfFailedTransferDetails.setTransferFrequency(TransferFrequency.MONTHLY);
		listOfFailedTransferDetails.setTransferCount(6l);
		listOfFailedTransferDetails.setPeriod("");
		listOfFailedTransferDetails.setStartDate(new Date());
		listOfFailedTransferDetails.setEndDate(new Date());
		listOfFailedTransferDetails.setExecutionDate(new Date());
		listOfFailedTransferDetailsSet.add(listOfFailedTransferDetails);
        
        //assertEquals(listOfFailedTransferDetailsSet.iterator().next().getTransferReqId(), adminSvc.getListOfFailedTransfers().iterator().next().getTransferReqId());
        //assertEquals(listOfFailedTransferDetailsSet.iterator().next().getTransferType(), adminSvc.getListOfFailedTransfers().iterator().next().getTransferType());
        //assertEquals(listOfFailedTransferDetailsSet.iterator().next().getTransferMode(), adminSvc.getListOfFailedTransfers().iterator().next().getTransferMode());
        //assertEquals(listOfFailedTransferDetailsSet.iterator().next().getFromAccount(), adminSvc.getListOfFailedTransfers().iterator().next().getFromAccount());
        //assertEquals(listOfFailedTransferDetailsSet.iterator().next().getToAccount(), adminSvc.getListOfFailedTransfers().iterator().next().getToAccount());
        //assertEquals(listOfFailedTransferDetailsSet.iterator().next().getAmount(), adminSvc.getListOfFailedTransfers().iterator().next().getAmount());
        //assertEquals(listOfFailedTransferDetailsSet.iterator().next().getCompanyRef(), adminSvc.getListOfFailedTransfers().iterator().next().getCompanyRef());
        //assertEquals(listOfFailedTransferDetailsSet.iterator().next().getRemark(), adminSvc.getListOfFailedTransfers().iterator().next().getRemark());
        //assertEquals(listOfFailedTransferDetailsSet.iterator().next().getScheduleFlag(), adminSvc.getListOfFailedTransfers().iterator().next().getScheduleFlag());
        //assertEquals(listOfFailedTransferDetailsSet.iterator().next().getCreatedBy(), adminSvc.getListOfFailedTransfers().iterator().next().getCreatedBy());
        //assertEquals(listOfFailedTransferDetailsSet.iterator().next().getCreatedOn(), adminSvc.getListOfFailedTransfers().iterator().next().getCreatedOn());
        //assertEquals(listOfFailedTransferDetailsSet.iterator().next().getCompanyId(), adminSvc.getListOfFailedTransfers().iterator().next().getCompanyId());
        //assertEquals(listOfFailedTransferDetailsSet.iterator().next().getAccountName(), adminSvc.getListOfFailedTransfers().iterator().next().getAccountName());
        //assertEquals(listOfFailedTransferDetailsSet.iterator().next().getBankCode(), adminSvc.getListOfFailedTransfers().iterator().next().getBankCode());
        //assertEquals(listOfFailedTransferDetailsSet.iterator().next().getBranchCode(), adminSvc.getListOfFailedTransfers().iterator().next().getBranchCode());
        //assertEquals(listOfFailedTransferDetailsSet.iterator().next().getCommissionAccount(), adminSvc.getListOfFailedTransfers().iterator().next().getCommissionAccount());
        //assertEquals(listOfFailedTransferDetailsSet.iterator().next().getCommissionValue(), adminSvc.getListOfFailedTransfers().iterator().next().getCommissionValue());
        //assertEquals(listOfFailedTransferDetailsSet.iterator().next().getCommissionStatus(), adminSvc.getListOfFailedTransfers().iterator().next().getCommissionStatus());
        //assertEquals(listOfFailedTransferDetailsSet.iterator().next().getWfStatus(), adminSvc.getListOfFailedTransfers().iterator().next().getWfStatus());
        //assertEquals(listOfFailedTransferDetailsSet.iterator().next().getWfComment(), adminSvc.getListOfFailedTransfers().iterator().next().getWfComment());
        //assertEquals(listOfFailedTransferDetailsSet.iterator().next().getTransferStatus(), adminSvc.getListOfFailedTransfers().iterator().next().getTransferStatus());
        //assertEquals(listOfFailedTransferDetailsSet.iterator().next().getTransferCode(), adminSvc.getListOfFailedTransfers().iterator().next().getTransferCode());
        //assertEquals(listOfFailedTransferDetailsSet.iterator().next().getTransferReference(), adminSvc.getListOfFailedTransfers().iterator().next().getTransferReference());
        //assertEquals(listOfFailedTransferDetailsSet.iterator().next().getRetryFlag(), adminSvc.getListOfFailedTransfers().iterator().next().getRetryFlag());
        //assertEquals(listOfFailedTransferDetailsSet.iterator().next().getRetryRef(), adminSvc.getListOfFailedTransfers().iterator().next().getRetryRef());
        //assertEquals(listOfFailedTransferDetailsSet.iterator().next().getReceiverNic(), adminSvc.getListOfFailedTransfers().iterator().next().getReceiverNic());
        //assertEquals(listOfFailedTransferDetailsSet.iterator().next().getReceiverName(), adminSvc.getListOfFailedTransfers().iterator().next().getReceiverName());
        //assertEquals(listOfFailedTransferDetailsSet.iterator().next().getSenderMobile(), adminSvc.getListOfFailedTransfers().iterator().next().getSenderMobile());       
        //assertEquals(listOfFailedTransferDetailsSet.iterator().next().getReceiverMobile(), adminSvc.getListOfFailedTransfers().iterator().next().getReceiverMobile());
        //assertEquals(listOfFailedTransferDetailsSet.iterator().next().getCorporatePayee(), adminSvc.getListOfFailedTransfers().iterator().next().getCorporatePayee());
        //assertEquals(listOfFailedTransferDetailsSet.iterator().next().getOccurrence(), adminSvc.getListOfFailedTransfers().iterator().next().getOccurrence());
        //assertEquals(listOfFailedTransferDetailsSet.iterator().next().getTransferDate(), adminSvc.getListOfFailedTransfers().iterator().next().getTransferDate());
        //assertEquals(listOfFailedTransferDetailsSet.iterator().next().getTransferFrequency(), adminSvc.getListOfFailedTransfers().iterator().next().getTransferFrequency());
        //assertEquals(listOfFailedTransferDetailsSet.iterator().next().getTransferCount(), adminSvc.getListOfFailedTransfers().iterator().next().getTransferCount());
        //assertEquals(listOfFailedTransferDetailsSet.iterator().next().getPeriod(), adminSvc.getListOfFailedTransfers().iterator().next().getPeriod());
        //assertEquals(listOfFailedTransferDetailsSet.iterator().next().getStartDate(), adminSvc.getListOfFailedTransfers().iterator().next().getStartDate());
        //assertEquals(listOfFailedTransferDetailsSet.iterator().next().getEndDate(), adminSvc.getListOfFailedTransfers().iterator().next().getEndDate());
        //assertEquals(listOfFailedTransferDetailsSet.iterator().next().getExecutionDate(), adminSvc.getListOfFailedTransfers().iterator().next().getExecutionDate());        
         
    }
    
    @Test
    public void getAdvanceTransferStatusTest(){
        
        //when(transferRepository.findByTransferType(TransferType.OTHER)).thenReturn(new HashSet<TransferRequest>());

        //GetCorporatePayeeTemplateResponse a = adminService.getCorporatePayeeTemplate("345", "d", "2234");
        //Set<ListOfCorporatePayeeTemplate> listOfCorporatePayeeTemplateSet = new HashSet<>();
        //assertEquals(listOfCorporatePayeeTemplateSet, a.getListOfCorporatePayeeTemplate());
         
        //assertEquals(3, empList.size());
        //verify(dao, times(1)).getEmployeeList();
    }
    
}

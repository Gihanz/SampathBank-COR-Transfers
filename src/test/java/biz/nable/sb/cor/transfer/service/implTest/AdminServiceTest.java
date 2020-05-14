package biz.nable.sb.cor.transfer.service.implTest;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

import java.util.HashSet;
import java.util.Set;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnitRunner;

import biz.nable.sb.cor.common.utility.RecordStatusEnum;
import biz.nable.sb.cor.transfer.constants.TransferType;
import biz.nable.sb.cor.transfer.constants.YnFlagEnum;
import biz.nable.sb.cor.transfer.db.models.CorporatePayeeMaster;
import biz.nable.sb.cor.transfer.db.models.TransferRequest;
import biz.nable.sb.cor.transfer.db.models.TransferRequestHistory;
import biz.nable.sb.cor.transfer.db.repository.CorporatePayeeRepository;
import biz.nable.sb.cor.transfer.db.repository.TransferHistoryRepository;
import biz.nable.sb.cor.transfer.db.repository.TransferRepository;
import biz.nable.sb.cor.transfer.response.GetCorporatePayeeTemplateResponse;
import biz.nable.sb.cor.transfer.response.ListOfCorporatePayeeTemplate;
import biz.nable.sb.cor.transfer.service.impl.AdminService;

@RunWith(MockitoJUnitRunner.class)
public class AdminServiceTest {
    
	@Mock
	private CorporatePayeeRepository corporatePayeeRepository;
	@Mock
	private TransferHistoryRepository transferHistoryRepository;
	@Mock
	private TransferRepository transferRepository;
	
    @InjectMocks
    AdminService adminService;
     

	@Before
    public void init() {
        MockitoAnnotations.initMocks(this);
    }
     
    @Test
    public void getCorporatePayeeTemplateTest(){
        
        when(corporatePayeeRepository.findByCompanyId("345")).thenReturn(new HashSet<CorporatePayeeMaster>());

        GetCorporatePayeeTemplateResponse a = adminService.getCorporatePayeeTemplate("345", "d", "2234");
        Set<ListOfCorporatePayeeTemplate> listOfCorporatePayeeTemplateSet = new HashSet<>();
        assertEquals(listOfCorporatePayeeTemplateSet, a.getListOfCorporatePayeeTemplate());
         
        //assertEquals(3, empList.size());
        //verify(dao, times(1)).getEmployeeList();
    }
    
    @Test
    public void getFailedTransferDetailsTest(){
        
        //when(transferHistoryRepository.findByRetryFlagAndTransferStatus(YnFlagEnum.N,RecordStatusEnum.REJECTED)).thenReturn(new HashSet<TransferRequestHistory>());

        //GetCorporatePayeeTemplateResponse a = adminService.getCorporatePayeeTemplate("345", "d", "2234");
        //Set<ListOfCorporatePayeeTemplate> listOfCorporatePayeeTemplateSet = new HashSet<>();
        //assertEquals(listOfCorporatePayeeTemplateSet, a.getListOfCorporatePayeeTemplate());
         
        //assertEquals(3, empList.size());
        //verify(dao, times(1)).getEmployeeList();
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

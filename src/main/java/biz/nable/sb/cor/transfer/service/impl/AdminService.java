package biz.nable.sb.cor.transfer.service.impl;

import biz.nable.sb.cor.transfer.request.GetSingleTransferRequest;
import biz.nable.sb.cor.transfer.response.GetSingleTransferResponse;
import biz.nable.sb.cor.transfer.response.GetTransferDetailsResponse;
import org.springframework.stereotype.Service;

@Service
public class AdminService {

    public GetSingleTransferResponse getSingleTransferStatusInquiryDetails(GetSingleTransferRequest getSingleTransferRequest, String userId, String requestId){


        return new GetSingleTransferResponse();
    }

    public GetTransferDetailsResponse getTransferInquiryDetails(String transferId, String userId, String requestId){
        return new GetTransferDetailsResponse();
    }
}

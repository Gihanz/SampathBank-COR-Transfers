/*
 * ******************************************************************************
 *  * Copyright 2020 (C) N*able
 *  * @author Roshan Wijendra
 *  ******************************************************************************
 */

package biz.nable.sb.cor.transfer.soap.schemas;

import biz.nable.sb.cor.transfer.soap.SOAPConnector;
import biz.nable.sb.cor.transfer.soap.schemas.iib.GetBalanceInquiryRequestType;
import biz.nable.sb.cor.transfer.soap.schemas.iib.GetBalanceInquiryResponseType;
import biz.nable.sb.cor.transfer.soap.schemas.iib.ObjectFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import javax.xml.bind.JAXBElement;

@Component
public class IIBRequestComponent {
    @Autowired
    SOAPConnector soapConnector;

    @Value("${custom.iib.finacle.integration.url}")
    private String iibUrl;

    @Bean
    private ObjectFactory objectFactory() {
        return new ObjectFactory();
    }

    public GetBalanceInquiryResponseType getBalanceInquiry(GetBalanceInquiryRequestType balanceInquiryRequest) {
        JAXBElement<GetBalanceInquiryRequestType> xmlRequest = objectFactory().createGetBalanceInquiryRequest(balanceInquiryRequest);
        JAXBElement<GetBalanceInquiryResponseType> xmlResponse = (JAXBElement<GetBalanceInquiryResponseType>) soapConnector.callWebService(iibUrl, xmlRequest);
        return xmlResponse.getValue();
    }
}

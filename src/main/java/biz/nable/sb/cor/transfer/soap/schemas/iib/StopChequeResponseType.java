//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.11 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2020.04.28 at 09:23:00 AM IST 
//


package biz.nable.sb.cor.transfer.soap.schemas.iib;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for StopChequeResponseType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="StopChequeResponseType"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="ProcessedCode" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *         &lt;element name="ProcessedDesc" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *         &lt;element name="ActionCode" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="CDCIResponse" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "StopChequeResponseType", propOrder = {
    "processedCode",
    "processedDesc",
    "actionCode",
    "cdciResponse"
})
public class StopChequeResponseType {

    @XmlElement(name = "ProcessedCode", required = true)
    protected String processedCode;
    @XmlElement(name = "ProcessedDesc", required = true)
    protected String processedDesc;
    @XmlElement(name = "ActionCode")
    protected String actionCode;
    @XmlElement(name = "CDCIResponse")
    protected String cdciResponse;

    /**
     * Gets the value of the processedCode property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getProcessedCode() {
        return processedCode;
    }

    /**
     * Sets the value of the processedCode property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setProcessedCode(String value) {
        this.processedCode = value;
    }

    /**
     * Gets the value of the processedDesc property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getProcessedDesc() {
        return processedDesc;
    }

    /**
     * Sets the value of the processedDesc property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setProcessedDesc(String value) {
        this.processedDesc = value;
    }

    /**
     * Gets the value of the actionCode property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getActionCode() {
        return actionCode;
    }

    /**
     * Sets the value of the actionCode property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setActionCode(String value) {
        this.actionCode = value;
    }

    /**
     * Gets the value of the cdciResponse property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCDCIResponse() {
        return cdciResponse;
    }

    /**
     * Sets the value of the cdciResponse property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCDCIResponse(String value) {
        this.cdciResponse = value;
    }

}

//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.11 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2020.05.13 at 04:11:07 PM IST 
//


package biz.nable.sb.cor.transfer.soap.schemas.iib;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for DepositScheduleRecord complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="DepositScheduleRecord"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="AcctNo" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *         &lt;element name="FlowSerial" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *         &lt;element name="PaymentIndicator" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *         &lt;element name="PaymentType" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *         &lt;element name="DueOnDate" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *         &lt;element name="Amount" type="{http://www.w3.org/2001/XMLSchema}double"/&gt;
 *         &lt;element name="AcctBalance" type="{http://www.w3.org/2001/XMLSchema}double"/&gt;
 *         &lt;element name="PaidDate" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *         &lt;element name="AmountPaid" type="{http://www.w3.org/2001/XMLSchema}double"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "DepositScheduleRecord", propOrder = {
    "acctNo",
    "flowSerial",
    "paymentIndicator",
    "paymentType",
    "dueOnDate",
    "amount",
    "acctBalance",
    "paidDate",
    "amountPaid"
})
public class DepositScheduleRecord {

    @XmlElement(name = "AcctNo", required = true)
    protected String acctNo;
    @XmlElement(name = "FlowSerial", required = true)
    protected String flowSerial;
    @XmlElement(name = "PaymentIndicator", required = true)
    protected String paymentIndicator;
    @XmlElement(name = "PaymentType", required = true)
    protected String paymentType;
    @XmlElement(name = "DueOnDate", required = true)
    protected String dueOnDate;
    @XmlElement(name = "Amount")
    protected double amount;
    @XmlElement(name = "AcctBalance")
    protected double acctBalance;
    @XmlElement(name = "PaidDate", required = true)
    protected String paidDate;
    @XmlElement(name = "AmountPaid")
    protected double amountPaid;

    /**
     * Gets the value of the acctNo property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getAcctNo() {
        return acctNo;
    }

    /**
     * Sets the value of the acctNo property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setAcctNo(String value) {
        this.acctNo = value;
    }

    /**
     * Gets the value of the flowSerial property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getFlowSerial() {
        return flowSerial;
    }

    /**
     * Sets the value of the flowSerial property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setFlowSerial(String value) {
        this.flowSerial = value;
    }

    /**
     * Gets the value of the paymentIndicator property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPaymentIndicator() {
        return paymentIndicator;
    }

    /**
     * Sets the value of the paymentIndicator property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPaymentIndicator(String value) {
        this.paymentIndicator = value;
    }

    /**
     * Gets the value of the paymentType property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPaymentType() {
        return paymentType;
    }

    /**
     * Sets the value of the paymentType property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPaymentType(String value) {
        this.paymentType = value;
    }

    /**
     * Gets the value of the dueOnDate property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDueOnDate() {
        return dueOnDate;
    }

    /**
     * Sets the value of the dueOnDate property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDueOnDate(String value) {
        this.dueOnDate = value;
    }

    /**
     * Gets the value of the amount property.
     * 
     */
    public double getAmount() {
        return amount;
    }

    /**
     * Sets the value of the amount property.
     * 
     */
    public void setAmount(double value) {
        this.amount = value;
    }

    /**
     * Gets the value of the acctBalance property.
     * 
     */
    public double getAcctBalance() {
        return acctBalance;
    }

    /**
     * Sets the value of the acctBalance property.
     * 
     */
    public void setAcctBalance(double value) {
        this.acctBalance = value;
    }

    /**
     * Gets the value of the paidDate property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPaidDate() {
        return paidDate;
    }

    /**
     * Sets the value of the paidDate property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPaidDate(String value) {
        this.paidDate = value;
    }

    /**
     * Gets the value of the amountPaid property.
     * 
     */
    public double getAmountPaid() {
        return amountPaid;
    }

    /**
     * Sets the value of the amountPaid property.
     * 
     */
    public void setAmountPaid(double value) {
        this.amountPaid = value;
    }

}

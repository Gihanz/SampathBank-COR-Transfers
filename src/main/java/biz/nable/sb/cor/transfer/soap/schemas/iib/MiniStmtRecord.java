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
 * <p>Java class for MiniStmtRecord complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="MiniStmtRecord"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="SerialNo" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *         &lt;element name="TxnDate" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *         &lt;element name="TxnType" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *         &lt;element name="TxnAmount" type="{http://www.w3.org/2001/XMLSchema}double"/&gt;
 *         &lt;element name="TxnDesc" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "MiniStmtRecord", propOrder = {
    "serialNo",
    "txnDate",
    "txnType",
    "txnAmount",
    "txnDesc"
})
public class MiniStmtRecord {

    @XmlElement(name = "SerialNo", required = true)
    protected String serialNo;
    @XmlElement(name = "TxnDate", required = true)
    protected String txnDate;
    @XmlElement(name = "TxnType", required = true)
    protected String txnType;
    @XmlElement(name = "TxnAmount")
    protected double txnAmount;
    @XmlElement(name = "TxnDesc", required = true)
    protected String txnDesc;

    /**
     * Gets the value of the serialNo property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSerialNo() {
        return serialNo;
    }

    /**
     * Sets the value of the serialNo property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSerialNo(String value) {
        this.serialNo = value;
    }

    /**
     * Gets the value of the txnDate property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTxnDate() {
        return txnDate;
    }

    /**
     * Sets the value of the txnDate property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTxnDate(String value) {
        this.txnDate = value;
    }

    /**
     * Gets the value of the txnType property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTxnType() {
        return txnType;
    }

    /**
     * Sets the value of the txnType property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTxnType(String value) {
        this.txnType = value;
    }

    /**
     * Gets the value of the txnAmount property.
     * 
     */
    public double getTxnAmount() {
        return txnAmount;
    }

    /**
     * Sets the value of the txnAmount property.
     * 
     */
    public void setTxnAmount(double value) {
        this.txnAmount = value;
    }

    /**
     * Gets the value of the txnDesc property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTxnDesc() {
        return txnDesc;
    }

    /**
     * Sets the value of the txnDesc property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTxnDesc(String value) {
        this.txnDesc = value;
    }

}

package biz.nable.sb.cor.transfer.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.Date;

import biz.nable.sb.cor.common.utility.RecordStatusEnum;
import biz.nable.sb.cor.common.utility.StatusEnum;

@Data
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class ListOfCorporatePayeeTemplate{
	
	private String companyId;
	private String reference;
	private String accountName;
	private String accountNickName;
	private String accountNumber;
	private String bankCode;
	private String branchCode;
	private String receiverNic;
	private String receiverMobile;
	private String receiverEmail;	
	private StatusEnum status;
	private RecordStatusEnum wfStatus;
	private String wfComment;
	private String createdBy;	
	private Date createdDate;
	private String modifiedBy;
	private Date modifiedDate;

}

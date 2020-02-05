package com.mobileapp.DTO;

import java.sql.Date;
import java.time.LocalDate;

public final class PurchaseDTO {
	int purchaseId, mobileid;
	String cname, mailid, phoneno;
	Date purchasedate;
	public PurchaseDTO(int mobileid, String cname, String mailid, String phoneno) {
		this.mobileid = mobileid;
		this.cname = cname;
		this.mailid = mailid;
		this.phoneno = phoneno;
		this.purchasedate = Date.valueOf(LocalDate.now());
	}
	public int getPurchaseId() {
		return purchaseId;
	}
	public void setPurchaseId(int purchaseId) {
		this.purchaseId = purchaseId;
	}
	public int getMobileid() {
		return this.mobileid;
	}
	public void setMobileid(int mobileid) {
		this.mobileid = mobileid;
	}
	public String getCname() {
		return cname;
	}
	public void setCname(String cname) {
		this.cname = cname;
	}
	public String getMailid() {
		return mailid;
	}
	public void setMailid(String mailid) {
		this.mailid = mailid;
	}
	public String getPhoneno() {
		return phoneno;
	}
	public void setPhoneno(String phoneno) {
		this.phoneno = phoneno;
	}
	public Date getPurchasedate() {
		return purchasedate;
	}
	public void setPurchasedate(Date purchasedate) {
		this.purchasedate = purchasedate;
	}
}

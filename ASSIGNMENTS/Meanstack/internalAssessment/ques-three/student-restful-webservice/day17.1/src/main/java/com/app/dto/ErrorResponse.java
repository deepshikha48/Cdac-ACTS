package com.app.dto;

import java.time.LocalDateTime;

public class ErrorResponse {
	private String mesg,detailedMesg;
	private LocalDateTime dateTime;
	
	public ErrorResponse(String mesg, String detailedMesg) {
		super();
		this.mesg = mesg;
		this.detailedMesg = detailedMesg;
		dateTime=LocalDateTime.now();
	}

	public String getMesg() {
		return mesg;
	}

	public void setMesg(String mesg) {
		this.mesg = mesg;
	}

	public String getDetailedMesg() {
		return detailedMesg;
	}

	public void setDetailedMesg(String detailedMesg) {
		this.detailedMesg = detailedMesg;
	}

	public LocalDateTime getDateTime() {
		return dateTime;
	}

	public void setDateTime(LocalDateTime dateTime) {
		this.dateTime = dateTime;
	}
	
	
	
}

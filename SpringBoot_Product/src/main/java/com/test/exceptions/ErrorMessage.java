package com.test.exceptions;

import java.util.Date;

public class ErrorMessage {
	
	private String url;
	private Date timeStamp;
	private String msg;
	
	
	
	private int statusCode;

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public Date getTimeStamp() {
		return timeStamp;
	}

	public void setTimeStamp(Date timeStamp) {
		this.timeStamp = timeStamp;
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}

	public int getStatusCode() {
		return statusCode;
	}

	public void setStatusCode(int statusCode) {
		this.statusCode = statusCode;
	}

	@Override
	public String toString() {
		return "ErrorMessage [url=" + url + ", timeStamp=" + timeStamp + ", msg=" + msg + ", statusCode=" + statusCode
				+ "]";
	}
	
	
	
	

}

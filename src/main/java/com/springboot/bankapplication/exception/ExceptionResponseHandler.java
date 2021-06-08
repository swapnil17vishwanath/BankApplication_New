package com.springboot.bankapplication.exception;

import java.time.LocalDateTime;

import org.springframework.http.HttpStatus;

public class ExceptionResponseHandler {
	
	private final String message;
	private final HttpStatus httpStatus;
	private final LocalDateTime timeStamp;
	
	public ExceptionResponseHandler(String message, HttpStatus httpStatus,
			LocalDateTime timeStamp) {
		super();
		this.message = message;
		this.httpStatus = httpStatus;
		this.timeStamp = timeStamp;
	}

	public String getMessage() {
		return message;
	}

	public LocalDateTime getTimeStamp() {
		return timeStamp;
	}

	public HttpStatus getHttpStatus() {
		return httpStatus;
	}
	
}

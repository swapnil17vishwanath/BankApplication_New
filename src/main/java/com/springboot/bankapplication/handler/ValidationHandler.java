package com.springboot.bankapplication.handler;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.springboot.bankapplication.exception.AccountNotFoundException;
import com.springboot.bankapplication.exception.ExceptionResponseHandler;
import com.springboot.bankapplication.exception.InsufficientBalanceException;

@ControllerAdvice
public class ValidationHandler extends ResponseEntityExceptionHandler {

	HttpStatus badRequest = HttpStatus.BAD_REQUEST;

	@Override
	protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex,
			HttpHeaders headers, HttpStatus status, WebRequest request) {

		Map<String, String> errors = new HashMap<>();
		ex.getBindingResult().getAllErrors().forEach((error) -> {

			String fieldName = ((FieldError) error).getField();
			String message = error.getDefaultMessage();
			errors.put(fieldName, message);
		});
		return new ResponseEntity<Object>(errors, badRequest);
	}

	@ExceptionHandler(AccountNotFoundException.class)
	public ResponseEntity<Object> handleAccountNotFoundException(AccountNotFoundException accountNotFoundException) {

		ExceptionResponseHandler exceptionResponseHandler = new ExceptionResponseHandler(
				accountNotFoundException.getMessage(), badRequest, LocalDateTime.now());

		return new ResponseEntity<Object>(exceptionResponseHandler, badRequest);

	}

	@ExceptionHandler(InsufficientBalanceException.class)
	public ResponseEntity<Object> handleInsufficientBalanceException(
			InsufficientBalanceException insufficientBalanceException, Throwable throwable) {

		ExceptionResponseHandler exceptionResponseHandler = new ExceptionResponseHandler(
				insufficientBalanceException.getMessage(), badRequest, LocalDateTime.now());

		return new ResponseEntity<Object>(exceptionResponseHandler, badRequest);
	}
}

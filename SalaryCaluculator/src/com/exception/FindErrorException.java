package com.exception;

public class FindErrorException extends RuntimeException {
	public FindErrorException() {

	}

	public FindErrorException(String msg) {
		super(msg);
	}
}

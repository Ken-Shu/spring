package com.study.spring.case07.tx.exception;

public class InsufficientAmount extends Throwable{
	
	public InsufficientAmount() {
		super("Wallet 餘額不足");
	}
	public InsufficientAmount(String message) {
		super(message);
	}
}

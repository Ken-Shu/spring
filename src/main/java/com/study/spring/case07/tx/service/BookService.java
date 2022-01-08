package com.study.spring.case07.tx.service;

import com.study.spring.case07.tx.exception.InsufficientAmount;
import com.study.spring.case07.tx.exception.InsufficientQuantity;

public interface BookService {
	public void buyOne(Integer wid , Integer bid) throws InsufficientAmount , InsufficientQuantity;
	public void buyMany(Integer wid , Integer... bids)throws InsufficientAmount , InsufficientQuantity;
	
}

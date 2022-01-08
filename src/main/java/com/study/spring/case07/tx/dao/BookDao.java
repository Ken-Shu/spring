package com.study.spring.case07.tx.dao;

import com.study.spring.case07.tx.exception.InsufficientAmount;
import com.study.spring.case07.tx.exception.InsufficientQuantity;

public interface BookDao {
	Integer getprice(Integer bid);
	Integer getStockAmount(Integer bid);
	Integer updateStock(Integer bid , Integer amount) throws InsufficientQuantity;
	Integer updateWallet(Integer wid , Integer money)throws InsufficientAmount;
	Integer getWalledMoney(Integer wid);
}

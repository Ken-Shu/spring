package com.study.spring.case07.tx.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.study.spring.case07.tx.dao.BookDao;
import com.study.spring.case07.tx.exception.InsufficientAmount;
import com.study.spring.case07.tx.exception.InsufficientQuantity;

@Service
public class BookServiceImpl implements BookService{
	@Autowired
	private BookDao bookDao;
	
	//@Transactional(propagation = Propagation.REQUIRED)
	//由資料庫自行處理交易機制
	//Propagation.REQUIRES_NEW 每次呼叫BuyOne 的時候 都會另外獨立執行
	//一個 new Transactional
	@Transactional(
			propagation = Propagation.REQUIRES_NEW,
/*回滾*/		rollbackFor = {InsufficientAmount.class,InsufficientQuantity.class}
/*不回滾*/	//noRollbackFor = {InsufficientQuantity.class}
			)
	@Override
	public void buyOne(Integer wid, Integer bid) throws InsufficientAmount,InsufficientQuantity{
		//消耗一本庫存
		bookDao.updateStock(bid, 1);
		//取得書籍價格
		Integer price = bookDao.getprice(bid);
		//減去錢包裡的金額
		bookDao.updateWallet(wid, price);
		
	}
	
	//@Transactional(propagation = Propagation.REQUIRED)
	@Transactional(
			propagation = Propagation.REQUIRES_NEW,
/*回滾*/		rollbackFor = {InsufficientAmount.class,InsufficientQuantity.class}
/*不回滾*/	//noRollbackFor = {InsufficientQuantity.class}
			)
	@Override
	public void buyMany(Integer wid, Integer... bids)throws InsufficientAmount,InsufficientQuantity {
		for(Integer bid : bids) {
			buyOne(wid, bid);
		}
		
	}
}

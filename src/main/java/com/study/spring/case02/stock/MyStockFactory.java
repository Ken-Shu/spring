package com.study.spring.case02.stock;

import org.springframework.beans.factory.FactoryBean;

import yahoofinance.Stock;
import yahoofinance.YahooFinance;

public class MyStockFactory implements FactoryBean<MyStock> {

	@Override
	public MyStock getObject() throws Exception {
		Stock stock = YahooFinance.get("2330.TW");
		MyStock myStock = new MyStock();
		Double price = stock.getQuote().getPrice().doubleValue();
		System.out.println(price);
		myStock.setSymbol(stock.getSymbol());
		myStock.setPrice(price);
		return myStock;
	}

	@Override
	public Class<?> getObjectType() {
		
		return MyStock.class;
	}

	@Override
	public boolean isSingleton() {
		
		return false;
	}

}

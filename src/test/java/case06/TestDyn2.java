package case06;

import java.util.Scanner;

import com.study.spring.case06.proxy.dyn.jdk.Calc;
import com.study.spring.case06.proxy.dyn.jdk.CalcImpl;
import com.study.spring.case06.proxy.dyn.jdk.ProxyUtil;
import com.study.spring.case06.proxy.sta.Man;
import com.study.spring.case06.proxy.sta.Person;


public class TestDyn2 {
	public static void main(String[] args) throws Exception{
		Calc calc = (Calc)new ProxyUtil(new CalcImpl()).getProxy();
		int div = calc.div(40, 0);
		System.out.println("div : " +div);
		
		
	}
}

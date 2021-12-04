package lab;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.study.spring.lab.RoundBean;

public class Test {
	public static void main(String[] args) {
		ApplicationContext ctx = new ClassPathXmlApplicationContext("beans.xml");
		
		RoundBean round = ctx.getBean("radius" , RoundBean.class);
		System.out.println(round.getRoundArea());
	}
}

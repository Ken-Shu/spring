package case01;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.study.spring.case01.TurnOn;


public class Test7 {
	public static void main(String[] args) {
		
		//載入配置黨會講所有的<bean scope="singleton"> 標籤內容實例化 不論程式碼是否有用到
		//<bean scope="prototype"> 則不會預先實例化
		ApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext.xml");
		
		TurnOn turnOn = ctx.getBean("turnon",TurnOn.class);
		turnOn.play();
		//自動調用 destroy()
		((ClassPathXmlApplicationContext)ctx).close();
	}
}

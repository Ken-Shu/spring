package case06;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.study.spring.case06.aop_dancer.AOPConfig;
import com.study.spring.case06.aop_dancer.Actor;
import com.study.spring.case06.aop_dancer.Performance;
import com.study.spring.case06.aop_dancer.Singer;

public class TestDancer {
	public static void main(String[] args) {
		//使用 Java 配置
		ApplicationContext ctx = new AnnotationConfigApplicationContext(AOPConfig.class);
		
		//使用 xml 配置
		//ApplicationContext ctx = new ClassPathXmlApplicationContext("aop-dancer.xml");
		
		Performance performance = ctx.getBean("dancer", Performance.class);
		//觀眾 關手機	
		//觀眾 找座位		
		//觀眾 鼓掌	
		// 觀眾
		try {
			performance.perform();
		} catch (Exception e) {
			System.out.println(e);
			//舞者 轉職 歌者
			Singer singer = (Singer)performance;
			singer.sing();
			//演員
			Actor actor = (Actor)performance;
			actor.show();
		}
		//觀眾退票(有表演錯誤發生)
		//觀眾 離開表演場地
	}
}

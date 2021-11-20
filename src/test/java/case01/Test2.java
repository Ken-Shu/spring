package case01;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.study.spring.case01.Author;


public class Test2 {
	public static void main(String[] args) {
		ApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext.xml");
		//Author a1 = ctx.getBean(Author.class); //只能用在配置檔中 針對只有"一個"該類別的設定
		//System.out.println(a1);
		
		//透過 xml 的id 來取得 但前面必須轉型
		Author a = (Author)ctx.getBean("author");
		a.setName("John");
		a.setSex('M');
		a.setAge(20);
		System.out.println(a);
		
		
		Author a2 = ctx.getBean("author2",Author.class);
		System.out.println(a2);
		
		Author a3 = ctx.getBean("author3",Author.class);
		System.out.println(a3);
		
		Author a4 = ctx.getBean("author4",Author.class);
		System.out.println(a4);
		
		Author a5 = ctx.getBean("author5",Author.class);
		System.out.println(a5);
	}
}

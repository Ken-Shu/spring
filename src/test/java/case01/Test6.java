package case01;

import java.util.stream.Stream;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.study.spring.case01.Animal;
import com.study.spring.case01.Dog;
import com.study.spring.case01.Cat;


public class Test6 {
	public static void main(String[] args) {
		
		//載入配置黨會講所有的<bean scope="singleton"> 標籤內容實例化 不論程式碼是否有用到
		//<bean scope="prototype"> 則不會預先實例化
		ApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext.xml");
		
		Animal[] animals = {
				ctx.getBean("dog",Dog.class),
				ctx.getBean("dog2",Dog.class),
				ctx.getBean("cat",Cat.class) //ctx.getBean(Cat.class)
		};
		Stream.of(animals).forEach(Animal::printName);
	}
}

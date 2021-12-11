package case06;



import org.springframework.cglib.proxy.Enhancer;

import com.study.spring.case06.proxy.dyn.cglid.EnhancerMessage;
import com.study.spring.case06.proxy.dyn.cglid.Message;
import com.study.spring.case06.proxy.dyn.cglid.MyMethodInterceptor;

public class TestDyn3 {
	public static void main(String[] args) {
		//透過 子類別(增強) 來代理
		Message message = new EnhancerMessage();
		System.out.println(message.send("John"));
		System.out.println();
		
		//使用 cglid 
		//建議使用 openjdk 1.8
		//下載位置 : https://github.com/ojdkbuild/ojdkbuild
		//變更 JDK  Window -> Preferences -> Java (Installed JREs) 
		// -> Edit 變更 Location 
		// ->路徑為 C:\Program Files\ojdkbuild\java-1.8.0-openjdk-1.8.0.232-1\jre
		Enhancer enhancer = new Enhancer(); //增強器
		enhancer.setSuperclass(Message.class); //目標
		enhancer.setCallback(new MyMethodInterceptor()); //回呼並攔截
		
		Message message2 = (Message)enhancer.create();
		System.out.println(message2.send("Marry"));
	}
}

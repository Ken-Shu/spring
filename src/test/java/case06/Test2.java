package case06;

import com.study.spring.case06.proxy.sta.Man;
import com.study.spring.case06.proxy.sta.Person;
import com.study.spring.case06.proxy.sta.PersonProxy;
import com.study.spring.case06.proxy.sta.Woman;

public class Test2 {
	public static void main(String[] args) {
		Person man = new Man();
		Person p1 = new PersonProxy(man);
		Person p2 = new PersonProxy(new Woman());
		p1.work();
		p2.work();
	}
}

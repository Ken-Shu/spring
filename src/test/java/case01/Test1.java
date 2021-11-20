package case01;

import com.study.spring.case01.Author;

public class Test1 {
	public static void main(String[] args) {
		Author a1 = new Author();
		a1.setName("John");
		a1.setSex('M');
		a1.setAge(20);
		System.out.println(a1);
		
		Author a2 = new Author("Mary",'F',18);
		System.out.println(a2);
	}
}

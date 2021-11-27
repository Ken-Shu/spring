package case02.classroom;

import java.util.Arrays;
import java.util.IntSummaryStatistics;
import java.util.function.ToDoubleFunction;
import java.util.function.ToIntFunction;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.study.spring.case02.classroom.Student;
import com.study.spring.case02.classroom.Teacher;
import com.study.spring.case02.pagers.Pager;
import com.study.spring.case02.pagers.Pager2;
import com.study.spring.case02.pagers.Pager3;


public class Test1 {
	public static void main(String[] args) {
		
		//載入配置黨會講所有的<bean scope="singleton"> 標籤內容實例化 不論程式碼是否有用到
		//<bean scope="prototype"> 則不會預先實例化
		ApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext2.xml");
		Student[]students = {
				ctx.getBean("student1",Student.class),
				ctx.getBean("student2",Student.class),
				ctx.getBean("student3",Student.class)
		};
		Arrays.stream(students).forEach(System.out::println);
		
		Teacher teacher1 = ctx.getBean("teacher1",Teacher.class);
		System.out.println(teacher1);
		
		//求出學生總分
		Student student1 = ctx.getBean("student1",Student.class);
		int sum =student1.getClazzs()
		.stream()
		.mapToInt(e->e.getCredit())
		.peek(System.out::println)
		.sum();
		System.out.println("sum = "+sum);
		//將上述邏輯寫成 function
		ToIntFunction<Student> func1 = (s) -> s.getClazzs().stream().mapToInt(e ->e.getCredit()).sum();
		//學生所選的科目 平均每一科的平均
		ToDoubleFunction<Student> func2 = (s) -> s.getClazzs().stream().mapToInt(e ->e.getCredit()).average().getAsDouble();
		//teacher 也就是 Bob 這位老師
		//他旗下所有學生的總學分為何?
		//例如 :若 John 的總學分 3+1=4 Helen 3+2+1=6
		//則總學分=10
		int total = teacher1.getStudents().stream().mapToInt(func1).sum();
		System.out.println("total : "+ total);
		double avg = teacher1.getStudents().stream()
				.mapToDouble(func2)
				.peek(System.out::println)
				.average().getAsDouble();
		System.out.println("平均 : "+avg);
		//--------------------------------------------------
		int total2 = teacher1.getStudents().stream().mapToInt(s -> s.getTotalCredits()).sum();
		System.out.println("total2 : "+total2);
		//--------------------------------------------------
		int total3 = teacher1.getTotalByStudentCredit();
		System.out.println("total3 : "+total3);
	}
}

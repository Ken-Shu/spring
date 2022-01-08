package case07.jdbc;

import java.util.Iterator;
import java.util.List;
import java.util.stream.Collectors;



import org.simpleflatmapper.jdbc.spring.JdbcTemplateMapperFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.ResultSetExtractor;

import com.study.spring.case07.jdbc.Emp;
import com.study.spring.case07.jdbc.Job;

public class TestReadEmpAndJob3 {
	public static void main(String[] args) {
		ApplicationContext ctx = new ClassPathXmlApplicationContext("jdbc-config.xml");
		JdbcTemplate jdbcTemplate = ctx.getBean("jdbcTemplate",JdbcTemplate.class);
		//請查出每個人的工作人名
		//例如 : 寫程式 -> mary 
		//      寫報告 -> mary
		//      倒茶水 -> john
		//      寫App -> john
		// 提示 將 Job.java 加入 private Emp emp ; 屬性
		String sql = "select j.jid , j.jname , j.eid ," +
				"e.eid as emp_eid ,e.ename as emp_ename ,e.age as emp_age, e.createtime as emp_createtime from job j left outer join emp e on j.eid = e.eid";
		//j.jid as job_jid 這樣的命名原則 "job_jid" 是表示將 jid 的內容 對應給 job 的資料表
		
		ResultSetExtractor<List<Job>>resultSetExtractor =
				JdbcTemplateMapperFactory.newInstance()
				.addKeys("jid")
				.newResultSetExtractor(Job.class);
		
		List<Job> jobs = jdbcTemplate.query(sql,resultSetExtractor);
		
		for(Job job: jobs) {
			System.out.printf("%s -> %s \n",
					job.getJname(),
					job.getEmp().getEname());
		}
		
		System.out.println("---------------------------");
		
		jobs.stream().forEach(job -> System.out.printf("%s -> %s \n",job.getJname(),job.getEmp().getEname()));
	
	}
}

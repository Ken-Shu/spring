package case07;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.Map;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import com.study.spring.case07.jdbc.Emp;

public class TestReadEmp {
	public static void main(String[] args) {
		ApplicationContext ctx = new ClassPathXmlApplicationContext("jdbc-config.xml");
		JdbcTemplate jdbcTemplate = ctx.getBean("jdbcTemplate",JdbcTemplate.class);
		
		//多筆查詢 1
		//String sql = "Select * FROM emp";
		String sql = "Select eid, ename, age, createtime FROM emp";
		List<Map<String , Object>> emps = jdbcTemplate.queryForList(sql);
		System.out.println(emps);
		
		//多筆查詢 2
		List<Emp> emps2 = jdbcTemplate.query(sql, (ResultSet rs , int rowNum) ->{
			Emp emp = new Emp();
			Integer eid = rs.getInt("eid");
			String ename = rs.getString("ename");
			Integer age = rs.getInt("age");
			Date createtime = rs.getTimestamp("createtime");
			emp.setEid(eid);
			emp.setEname(ename);
			emp.setAge(age);
			emp.setCreatedate(createtime);
			return emp;
		});
		System.out.println(emps2);
		
		//多筆查詢 3
		List<Emp> emps3 = jdbcTemplate.query(sql, new BeanPropertyRowMapper<>(Emp.class));
		System.out.println(emps3);
		
		//查詢單筆資料
		Integer geteid = 2;
		String sql2 = "Select * FROM emp WHERE eid=? and ename=?";
		Emp row = jdbcTemplate.queryForObject(sql2,new Object[] {geteid,"john"} ,(ResultSet rs , int rowNums)->{
			Emp emp = new Emp();
			Integer eid = rs.getInt("eid");
			String ename = rs.getString("ename");
			Integer age = rs.getInt("age");
			Date createtime = rs.getTimestamp("createtime");
			emp.setEid(eid);
			emp.setEname(ename);
			emp.setAge(age);
			emp.setCreatedate(createtime);
			return emp;
		});
		System.out.println(row);
	}
}

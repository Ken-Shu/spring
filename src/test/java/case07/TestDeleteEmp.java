package case07;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;
import java.util.List;
import java.util.Map;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import com.study.spring.case07.jdbc.Emp;

public class TestDeleteEmp {
	public static void main(String[] args) {
		ApplicationContext ctx = new ClassPathXmlApplicationContext("jdbc-config.xml");
		JdbcTemplate jdbcTemplate = ctx.getBean("jdbcTemplate",JdbcTemplate.class);
		
		//將 eid = 1 的資料刪除
		Integer eid = 1;
		
		String sql = "DELETE FROM emp WHERE eid=?";
		//String sql = "UPDATE emp SET :ename , :age WHERE :eid";
		int row = jdbcTemplate.update(sql,eid);
		System.out.println("Delete OK : " + row);
		
		//查詢單筆 練習
		//jdbcTemplate.queryForObject(String sql,Class<T>requiredType )
	}
}

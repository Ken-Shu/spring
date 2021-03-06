package case07.jdbc;


import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.core.BatchPreparedStatementSetter;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;

import com.study.spring.case07.jdbc.Emp;


public class TestCreateEmp {
	
	ApplicationContext ctx = new ClassPathXmlApplicationContext("jdbc-config.xml");
	JdbcTemplate jdbcTemplate = ctx.getBean("jdbcTemplate",JdbcTemplate.class);
	NamedParameterJdbcTemplate namedParameterJdbcTemplate = ctx.getBean("namedParameterJdbcTemplate",NamedParameterJdbcTemplate.class);
	@Test
	public void test() {
		//case1();
		//case2("Happy",23); //單筆新增
		//case3(); //多筆新增
		case4(); //多筆新增2
	}
	
	// 單筆新增 1
	private void case1() {
		String sql = "INSERT INTO emp(ename,age) VALUE(?,?)";
		int row = jdbcTemplate.update(sql , "Jojo" , 21);
		System.out.println("Insert OK 1 : " + row);
	}
	// 單筆新增 2
	private void case2(String ename , Integer age) {
		String sql = "INSERT INTO emp(ename,age) VALUE(:ename,:age)";
		MapSqlParameterSource params = new MapSqlParameterSource()
				.addValue("ename", ename)
				.addValue("age", age);
		int row = namedParameterJdbcTemplate.update(sql, params);
		System.out.println("Insert OK 2 : " + row);
	}
	//多筆新增 1
	public void case3(){
		String sql = "INSERT INTO emp(ename,age) VALUE(?,?)";
		List<Object[]> list = new ArrayList<>();
		list.add(new Object[] {"Jean",22});
		list.add(new Object[] {"Anita",23});
		list.add(new Object[] {"Jo",24});
		int [] rows = jdbcTemplate.batchUpdate(sql,list);
		System.out.println("Batch instert 1: "+Arrays.toString(rows));
	}
	//多筆查詢 2
	public void case4() {
		String sql = "INSERT INTO emp(ename,age) VALUE(?,?)";
		List<Emp> emps = Arrays.asList(
				new Emp("Bob" , 30),
				new Emp("Alic", 40)
				);
		BatchPreparedStatementSetter setter = new BatchPreparedStatementSetter() {
			
			@Override
			public void setValues(PreparedStatement ps, int i) throws SQLException {
				// i = emps 的 index
				ps.setString(1, emps.get(i).getEname());
				ps.setInt(2, emps.get(i).getAge());
			}
			
			@Override
			public int getBatchSize() {
				
				return emps.size();
			}
		} ;
		//Entity 的屬性 -> 資料表欄位
		//batchUpdate{sql , PreparedStatmentSetter} 透過對應欄位 塞入資料表
		int [] rows = jdbcTemplate.batchUpdate(sql, setter);
		System.out.println("Batch instert 2: "+Arrays.toString(rows));
		
	}
}

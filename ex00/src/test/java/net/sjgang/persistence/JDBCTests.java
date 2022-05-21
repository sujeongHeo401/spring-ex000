package net.sjgang.persistence;

import static org.junit.Assert.fail;

import java.sql.Connection;
import java.sql.DriverManager;

import org.junit.Test;

import lombok.extern.log4j.Log4j;

@Log4j
public class JDBCTests {
	static {
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	@Test
	public void testConnection() throws Exception {
		Class clz = Class.forName("oracle.jdbc.driver.OracleDriver");
		
		long start = System.currentTimeMillis();
		for(int i = 0; i < 100; i++) {
			Connection con = DriverManager.getConnection(
					"jdbc:oracle:thin:@localhost:1521:XE", 
					"book_ex", "book_ex");
		
			log.info(con);
			
			con.close(); //// bad code 
		}
		
		long end = System.currentTimeMillis();
		log.info("----------");
		log.info(end - start);

//		try(Connection con = DriverManager.getConnection(
//				"jdbc:oracle:thin:@localhost:1521:XE",
//				"book_ex",
//				"book_ex")){
//			
//		 log.info(con);
//		} catch(Exception e) {
//		  fail(e.getMessage());
//		}
	}
}

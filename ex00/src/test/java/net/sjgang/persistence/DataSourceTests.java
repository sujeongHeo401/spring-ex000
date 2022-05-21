package net.sjgang.persistence;

import static org.junit.Assert.fail;

import java.sql.Connection;

import javax.sql.DataSource;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import net.sjgang.config.RootConfig;
import lombok.Setter;
import lombok.extern.log4j.Log4j;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {RootConfig.class})
@Log4j
public class DataSourceTests {
	
	@Autowired
	private DataSource ds;
	
//	@Test
//	public void testConnection(){
//		
//		long start = System.currentTimeMillis();
//		for(int i = 0; i < 100; i++) {
//			try(Connection con = ds.getConnection()){
//				log.info(con);
//			}catch(Exception e) {
//				e.printStackTrace();
//				log.error(e.getMessage());
//			}
//		}
//		
//		long end = System.currentTimeMillis();
//		log.info("--------------");
//		log.info(end - start);
//	}

//	@Setter(onMethod_ = {@Autowired} )
	private DataSource dataSource;
//	
//	@Setter(onMethod_ = { @Autowired })
	@Autowired
	private SqlSessionFactory sqlSessionFactory;
	
	@Test
	public void testMybatis() {
		try(SqlSession session = sqlSessionFactory.openSession();
				Connection con = session.getConnection();
				) {
					log.info(session);
//					log.info(con);
				} catch(Exception e) {
					fail(e.getMessage());
				}
	}
//	@Test
//	public void testConnection() {
//		try(Connection con = dataSource.getConnection()){
//			log.info(con);
//		} catch(Exception e) {
//			fail(e.getMessage());
//		}
//	}

}

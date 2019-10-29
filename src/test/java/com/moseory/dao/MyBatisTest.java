package com.moseory.dao;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import lombok.Setter;
import lombok.extern.log4j.Log4j;

@Log4j
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"file:src/main/webapp/WEB-INF/spring/**/root-context.xml"})
public class MyBatisTest {

	
    @Setter(onMethod_ = @Autowired)
    private SqlSessionFactory sqlSessionFactory;
    
    @Setter(onMethod_ = @Autowired)
    private SqlSession sqlSession;
    
    @Test
    public void testFactory() {
	
	try(SqlSession session = sqlSessionFactory.openSession()) {
	    log.info(session);
	} catch(Exception e) {
	    e.printStackTrace();
	}
	 
    }
    
    @Test
    public void testTemplate() {
	
	log.info(sqlSession);		
	
    }
    
}






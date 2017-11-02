package main;

import java.sql.Connection;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import bang.BangDao;
import bang.BangVO;
import bang.ReplyBangDao;

import user.UserDao;
import user.UserVO;

public class TEST {
	public static void main( String[] args ){
		ApplicationContext ac = 
			new ClassPathXmlApplicationContext(
			"spring.xml");
		UserDao dao = ac.getBean("userDao",UserDao.class);
		BangDao dao2 = ac.getBean("bangDao",BangDao.class);
		ReplyBangDao dao3 = ac.getBean("replyDao",ReplyBangDao.class);
		
		System.out.println( dao.hashCode() );
		System.out.println( dao2.hashCode() );
		System.out.println( dao3.hashCode() );
		
		try {	
		
		 
		
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
}












package funvideo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementSetter;
import org.springframework.jdbc.core.RowMapper;

public class ReplyFunVideoDao_OracleImpl implements ReplyFunVideoDao{
	
	private JdbcTemplate jdbcTemplate = null;
	
	public void setJdbcTemplate( JdbcTemplate j ){
		jdbcTemplate = j;
	}
	
	// Ȯ�οϷ�
	
	@Override
	public int add(final ReplyFunVideoVO pvo) throws Exception {
		String sql = "INSERT INTO ReplyFunVideo VALUES ( ?, SEQ_ReFunVideo.NEXTVAL,?,?,?,SYSDATE )";
		
		return jdbcTemplate.update( sql, 
		new PreparedStatementSetter(){
			public void setValues(PreparedStatement stmt)
				throws SQLException 
			{
				stmt.setInt(1, pvo.getNo() );
				stmt.setString(2, pvo.getUserId() );
				stmt.setString(3, pvo.getReply() );
				stmt.setString(4, pvo.getClientIp() );
			}
		});
	}

	
	
	@Override
	public int update(final ReplyFunVideoVO pvo) throws Exception {
		String sql = "update ReplyFunVideo set reply=?,"+
					"client_ip=? where reno=?";

		return jdbcTemplate.update( sql, 
		new PreparedStatementSetter(){
			public void setValues(PreparedStatement stmt)
				throws SQLException 
			{
				stmt.setString(1, pvo.getReply() );
				stmt.setString(2, pvo.getClientIp() );
				stmt.setInt(3, pvo.getReno() );
			}
		});
	}
		
	
	
	@Override
	public int del(final String no) throws Exception {
		
		String sql = "delete from ReplyFunVideo where reno=?";
		
		return jdbcTemplate.update( sql, 
		new PreparedStatementSetter(){
			public void setValues(PreparedStatement stmt)
				throws SQLException 
			{
				stmt.setString(1, no );
			}
		});
		
	}
	
	@Override
	public List<ReplyFunVideoVO> findReply(String no) throws Exception {
		
		String sql = "select no, reno, user_ID, reply, client_ip, to_Char(the_time,'YYYY-MM-DD HH24:MI:SS')AS the_time from ReplyFunVideo where no="+ no +" ORDER BY reno DESC";
		
		// �ð� �ҷ��ö� AS�� �ʵ�� �������ٰ�.
		
		List<ReplyFunVideoVO> ls = jdbcTemplate.query( sql, new RM_ReplyFunVideo() );
		System.out.println ( ls );
		return ls;
	}

	
}













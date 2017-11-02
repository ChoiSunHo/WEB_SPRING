package movievideo;

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

public class ReplyMovieVideoDao_OracleImpl implements ReplyMovieVideoDao{
	
	private JdbcTemplate jdbcTemplate = null;
	
	public void setJdbcTemplate( JdbcTemplate j ){
		jdbcTemplate = j;
	}
	
	// 확인완료
	
	@Override
	public int add(final ReplyMovieVideoVO pvo) throws Exception {
		String sql = "INSERT INTO ReplyMovieVideo VALUES ( ?, SEQ_ReMovieVideo.NEXTVAL,?,?,?,SYSDATE )";
		
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
	public int update(final ReplyMovieVideoVO pvo) throws Exception {
		String sql = "update ReplyMovieVideo set reply=?,"+
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
		
		String sql = "delete from ReplyMovieVideo where reno=?";
		
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
	public List<ReplyMovieVideoVO> findReply(String no) throws Exception {
		
		String sql = "select no, reno, user_ID, reply, client_ip, to_Char(the_time,'YYYY-MM-DD HH24:MI:SS')AS the_time from ReplyMovieVideo where no="+ no +" ORDER BY reno DESC";
		
		// 시간 불러올때 AS로 필드명 수정해줄것.
		
		List<ReplyMovieVideoVO> ls = jdbcTemplate.query( sql, new RM_ReplyMovieVideo() );
		System.out.println ( ls );
		return ls;
	}

	
}













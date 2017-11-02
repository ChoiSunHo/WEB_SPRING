package thinknote;

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

public class ThinkNoteDao_OracleImpl implements ThinkNoteDao{
	
	private JdbcTemplate jdbcTemplate = null;
	
	public void setJdbcTemplate( JdbcTemplate j ){
		jdbcTemplate = j;
	}
	
	
	// ok
	@Override
	public int add(final ThinkNoteVO pvo) throws Exception {
		
		String sql = "INSERT INTO ThinkNote VALUES "+
				"(SEQ_ThinkNote.NEXTVAL,?,?,SYSDATE,?,?,"+
				"0,0)";
	
		return jdbcTemplate.update( sql, 
		new PreparedStatementSetter(){
			public void setValues(PreparedStatement stmt)
				throws SQLException 
			{
				stmt.setString(1, pvo.getTitle() );
				stmt.setString(2, pvo.getText() );
				stmt.setString(3, pvo.getClientIp() );
				stmt.setString(4, pvo.getUserId() );
			}
		});
	}
	
	
	//ok 제목 글자수 허용범위 늘려줄것.
	@Override
	public int update( final ThinkNoteVO pvo) throws Exception {
		
		String sql = "UPDATE ThinkNote SET TITLE=?,TEXT=?,"+ 
					 "CLIENT_IP= ? WHERE NO=?";
		
		return jdbcTemplate.update( sql, 
		new PreparedStatementSetter(){
			public void setValues(PreparedStatement stmt)
				throws SQLException 
			{
				stmt.setString(1, pvo.getTitle() );
				stmt.setString(2, pvo.getText() );
				stmt.setString(3, pvo.getClientIp() );
				stmt.setInt(4, pvo.getNo() );
			}
		});
	}
	
	
	// ok 작성자가 아닌 사용자가 삭제하려할 경우 alert처리해줄것.
	@Override
	public int del(final String no) throws Exception {
		
		String sql = "delete from ThinkNote where no=?";
		
		return jdbcTemplate.update( sql, 
		new PreparedStatementSetter(){
			public void setValues(PreparedStatement stmt)
				throws SQLException 
			{
				stmt.setString(1, no );
			}
		});
	}
	
	
	// ok
	@Override
	public int plusview( final String no ) throws Exception {
		String sql = "UPDATE ThinkNote SET ViewNo=ViewNo+1"+
					"WHERE no=?";
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
	public List<ThinkNoteVO> findAll() throws Exception {
		String sql = "SELECT no, title, text, TO_CHAR(the_time,"+
				"'YYYY-MM-DD HH24:MI:SS'), client_ip, "+
				"ThinkNote.user_id, viewNo, likeNo FROM UserTb, "+
				"ThinkNote WHERE UserTb.user_id = ThinkNote.user_id "+
				"ORDER BY no DESC";
		List<ThinkNoteVO> ls = jdbcTemplate.query( sql, 
			new RowMapper<ThinkNoteVO>(){

				@Override
				public ThinkNoteVO mapRow(ResultSet rs, int arg1)
						throws SQLException {
					ThinkNoteVO vo = new ThinkNoteVO();
					vo.setNo( rs.getInt(1) );
					vo.setTitle( rs.getString(2) );
					vo.setText( rs.getString(3) );
					vo.setTheTime( rs.getString(4) );
					vo.setClientIp( rs.getString(5) );
					vo.setUserId( rs.getString(6) );
					vo.setViewNo( rs.getInt(7));
					vo.setLikeNo( rs.getInt(8));
					return vo;
				}} );
		return ls;
	}

	
	// ok 페이지나누는 거 익히기
	@Override
	public List<ThinkNoteVO> findGleNo( String no ) throws Exception {
		String sql = "SELECT no, title, text, TO_CHAR(the_time,'YYYY-MM-DD HH24:MI:SS'),"+
					"client_ip, user_id, viewNo, likeNo FROM ThinkNote where no="+no;
		List<ThinkNoteVO> ls = jdbcTemplate.query( sql, 
			new RowMapper<ThinkNoteVO>(){

				@Override
				public ThinkNoteVO mapRow(ResultSet rs, int arg1)
						throws SQLException {
					ThinkNoteVO vo = new ThinkNoteVO();
					vo.setNo( rs.getInt(1) );
					vo.setTitle( rs.getString(2) );
					vo.setText( rs.getString(3) );
					vo.setTheTime( rs.getString(4) );
					vo.setClientIp( rs.getString(5) );
					vo.setUserId( rs.getString(6) );
					vo.setViewNo( rs.getInt(7));
					vo.setLikeNo( rs.getInt(8));
					return vo;
				}} );
		return ls;
	}

	
	
	@Override
	public List<ThinkNoteVO> findGleTitle(String title) throws Exception {
		String sql = "SELECT no, title, text, TO_CHAR(the_time,'YYYY-MM-DD HH24:MI:SS'),"+
					 "client_ip, user_id, viewNo, likeNo FROM ThinkNote where "+
					 "title LIKE '%"+title+"%' ORDER BY no DESC";
		
		System.out.println(sql);
		List<ThinkNoteVO> ls = jdbcTemplate.query( sql, 
			new RowMapper<ThinkNoteVO>(){

				@Override
				public ThinkNoteVO mapRow(ResultSet rs, int arg1)
						throws SQLException {
					ThinkNoteVO vo = new ThinkNoteVO();
					vo.setNo( rs.getInt(1) );
					vo.setTitle( rs.getString(2) );
					vo.setText( rs.getString(3) );
					vo.setTheTime( rs.getString(4) );
					vo.setClientIp( rs.getString(5) );
					vo.setUserId( rs.getString(6) );
					vo.setViewNo( rs.getInt(7));
					vo.setLikeNo( rs.getInt(8));
					return vo;
				}} );
		return ls;
	}

	
	
	@Override
	public List<ThinkNoteVO> findGleText(String text) throws Exception {
		String sql = "SELECT no, title, text, TO_CHAR(the_time,'YYYY-MM-DD HH24:MI:SS'),"+
					 "client_ip, user_id, viewNo, likeNo FROM ThinkNote where text "+
					 "LIKE '%"+text+"%' ORDER BY no DESC";

		System.out.println("sql");
		List<ThinkNoteVO> ls = jdbcTemplate.query( sql, 
			new RowMapper<ThinkNoteVO>(){

				@Override
				public ThinkNoteVO mapRow(ResultSet rs, int arg1)
						throws SQLException {
					ThinkNoteVO vo = new ThinkNoteVO();
					vo.setNo( rs.getInt(1) );
					vo.setTitle( rs.getString(2) );
					vo.setText( rs.getString(3) );
					vo.setTheTime( rs.getString(4) );
					vo.setClientIp( rs.getString(5) );
					vo.setUserId( rs.getString(6) );
					vo.setViewNo( rs.getInt(7));
					vo.setLikeNo( rs.getInt(8));
					return vo;
				}} );
		return ls;
	}

	
	
	@Override
	public List<ThinkNoteVO> findGleId(String id) throws Exception {
		String sql = "SELECT no, title, text, TO_CHAR(the_time,'YYYY-MM-DD HH24:MI:SS'),"+
					 " client_ip, user_id, viewNo, likeNo FROM ThinkNote where user_id "+
					 "LIKE '%"+ id +"%' ORDER BY no DESC";
		
		List<ThinkNoteVO> ls = jdbcTemplate.query( sql, 
			new RowMapper<ThinkNoteVO>(){

				@Override
				public ThinkNoteVO mapRow(ResultSet rs, int arg1)
						throws SQLException {
					ThinkNoteVO vo = new ThinkNoteVO();
					vo.setNo( rs.getInt(1) );
					vo.setTitle( rs.getString(2) );
					vo.setText( rs.getString(3) );
					vo.setTheTime( rs.getString(4) );
					vo.setClientIp( rs.getString(5) );
					vo.setUserId( rs.getString(6) );
					vo.setViewNo( rs.getInt(7));
					vo.setLikeNo( rs.getInt(8));
					return vo;
				}} );
		return ls;
	}

	
	
	@Override
	public List<ThinkNoteVO> findGleReply(String reply) throws Exception {
		String sql = "SELECT no, title, text, TO_CHAR(the_time,'YYYY-MM-DD HH24:MI:SS'),"+
					"client_ip, user_id, viewNo, likeNo FROM ThinkNote where no in"+
					"(SELECT no from ReplyThinkNote where reply LIKE '%"+
					reply+"%' GROUP BY no)"; //댓글내용을 토대로 게시글 no를 선택해 가져오도록한다.
		List<ThinkNoteVO> ls = jdbcTemplate.query( sql, 
			new RM_ThinkNote() );
		return ls;
	}

	
	
	@Override
	public boolean pluslikecheck(String no, String userId) throws Exception {
		
		boolean bln = true;
		String sql = "SELECT USER_ID FROM LikeThinkNote WHERE NO="+no;
		List<String> ls = jdbcTemplate.query( sql, new RowMapper<String>(){

			@Override
			public String mapRow(ResultSet rs, int arg1)
				throws SQLException {

				String id =  rs.getString(1);
				return id;
			}} );
			
		for ( String t : ls){
			if ( t.equals(userId) ){
				bln = false;
				break;
			}	
		}
		
		return bln; 
	}
	
	
	
	@Override
	public int pluslike( final String no, final String userId ) throws Exception {

		String sql = "UPDATE ThinkNote SET LIKENO=LIKENO+1"+
					 "WHERE NO=?";

		int i = jdbcTemplate.update( sql, new PreparedStatementSetter(){
					public void setValues(PreparedStatement stmt)
					throws SQLException 
				{
					stmt.setString(1, no );
				}	});
			
				
		String sql2 = "INSERT INTO LikeThinkNote VALUES(?,?)";

		int j = jdbcTemplate.update( sql2, new PreparedStatementSetter(){
					public void setValues(PreparedStatement stmt)
					throws SQLException 
				{
					stmt.setString(1, no );
					stmt.setString(2, userId );
				}
				}	);
		
		return i+j;
	}
	
	
	
	// sql 줄이려니 에러가난다.
	@Override
	public List<ThinkNoteVO> findPage( String no ) throws Exception {
		System.out.println("여기까지가");
		int n = Integer.parseInt(no);
		int start = (n-1)*10;
		int end = n*10;
		
		String sql = "SELECT no, title, text, TO_CHAR(the_time, 'YYYY-MM-DD HH24:MI:SS'), "+
					 "client_ip, ThinkNote.user_id, viewNo, likeNo "+
					 "FROM UserTb,ThinkNote WHERE UserTb.user_id = ThinkNote.user_id AND "+
					 "no IN ( SELECT no FROM ( SELECT no, rownum as sq FROM "+
					 "( SELECT no FROM ThinkNote WHERE 0 = 0 ORDER BY no DESC ) ) "+
					 "WHERE sq > "+start+" AND sq <= "+end+" ) ORDER BY no DESC";
			
		List<ThinkNoteVO> ls = jdbcTemplate.query( sql, new RM_ThinkNote() );
		return ls;
	}


}













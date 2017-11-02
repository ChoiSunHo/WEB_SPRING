package bang;

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

public class BangDao_OracleImpl implements BangDao{
	
	private JdbcTemplate jdbcTemplate = null;
	
	public void setJdbcTemplate( JdbcTemplate j ){
		jdbcTemplate = j;
	}
	
	
	// ok
	@Override
	public int add(final BangVO pvo) throws Exception {
		
		String sql = "INSERT INTO Bang VALUES "+
				"(SEQ_Bang.NEXTVAL,?,?,SYSDATE,?,?,?,?,"+
				"0,0)";
	
		return jdbcTemplate.update( sql, 
		new PreparedStatementSetter(){
			public void setValues(PreparedStatement stmt)
				throws SQLException 
			{
				stmt.setString(1, pvo.getTitle() );
				stmt.setString(2, pvo.getText() );
				stmt.setString(3, pvo.getClientIp() );
				stmt.setString(4, pvo.getFsn() );
				stmt.setString(5, pvo.getOfn() );
				stmt.setString(6, pvo.getUserId() );
			}
		});
	}
	
	
	//ok 제목 글자수 허용범위 늘려줄것.
	@Override
	public int update( final BangVO pvo) throws Exception {
		
		String sql = "UPDATE Bang SET TITLE=?,TEXT=?, OFN=?, FSN=?, CLIENT_IP= ? WHERE NO=?";
		
		return jdbcTemplate.update( sql, 
		new PreparedStatementSetter(){
			public void setValues(PreparedStatement stmt)
				throws SQLException 
			{
				stmt.setString(1, pvo.getTitle() );
				stmt.setString(2, pvo.getText() );
				stmt.setString(3, pvo.getOfn() );
				stmt.setString(4, pvo.getFsn() );
				stmt.setString(5, pvo.getClientIp() );
				stmt.setInt(6, pvo.getNo() );
			}
		});
	}
	
	
	// ok 작성자가 아닌 사용자가 삭제하려할 경우 alert처리해줄것.
	@Override
	public int del(final String no) throws Exception {
		
		String sql = "delete from Bang where no=?";
		
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
		String sql = "UPDATE Bang SET ViewNo=ViewNo+1"+
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
	public List<BangVO> findAll() throws Exception {
		String sql = "SELECT no, title, text, TO_CHAR(the_time,"+
				"'YYYY-MM-DD HH24:MI:SS'), client_ip, fsn, ofn, "+
				"Bang.user_id, viewNo, likeNo FROM UserTb, "+
				"Bang WHERE UserTb.user_id = Bang.user_id "+
				"ORDER BY no DESC";
		List<BangVO> ls = jdbcTemplate.query( sql, 
			new RowMapper<BangVO>(){

				@Override
				public BangVO mapRow(ResultSet rs, int arg1)
						throws SQLException {
					BangVO vo = new BangVO();
					vo.setNo( rs.getInt(1) );
					vo.setTitle( rs.getString(2) );
					vo.setText( rs.getString(3) );
					vo.setTheTime( rs.getString(4) );
					vo.setClientIp( rs.getString(5) );
					vo.setFsn( rs.getString(6) );
					vo.setOfn( rs.getString(7) );
					vo.setUserId( rs.getString(8) );
					vo.setViewNo( rs.getInt(9));
					vo.setLikeNo( rs.getInt(10));
					return vo;
				}} );
		return ls;
	}

	
	// ok 페이지나누는 거 익히기
	@Override
	public List<BangVO> findGleNo( String no ) throws Exception {
		String sql = "SELECT no, title, text, TO_CHAR(the_time,'YYYY-MM-DD HH24:MI:SS'),"+
					"client_ip, fsn, ofn, user_id, viewNo, likeNo FROM Bang where no="+no;
		List<BangVO> ls = jdbcTemplate.query( sql, 
			new RowMapper<BangVO>(){

				@Override
				public BangVO mapRow(ResultSet rs, int arg1)
						throws SQLException {
					BangVO vo = new BangVO();
					vo.setNo( rs.getInt(1) );
					vo.setTitle( rs.getString(2) );
					vo.setText( rs.getString(3) );
					vo.setTheTime( rs.getString(4) );
					vo.setClientIp( rs.getString(5) );
					vo.setFsn( rs.getString(6) );
					vo.setOfn( rs.getString(7) );
					vo.setUserId( rs.getString(8) );
					vo.setViewNo( rs.getInt(9));
					vo.setLikeNo( rs.getInt(10));
					return vo;
				}} );
		return ls;
	}

	
	
	@Override
	public List<BangVO> findGleTitle(String title) throws Exception {
		String sql = "SELECT no, title, text, TO_CHAR(the_time,'YYYY-MM-DD HH24:MI:SS'),"+
					 "client_ip, fsn, ofn, user_id, viewNo, likeNo FROM Bang where "+
					 "title LIKE '%"+title+"%' ORDER BY no DESC";
		
		System.out.println(sql);
		List<BangVO> ls = jdbcTemplate.query( sql, 
			new RowMapper<BangVO>(){

				@Override
				public BangVO mapRow(ResultSet rs, int arg1)
						throws SQLException {
					BangVO vo = new BangVO();
					vo.setNo( rs.getInt(1) );
					vo.setTitle( rs.getString(2) );
					vo.setText( rs.getString(3) );
					vo.setTheTime( rs.getString(4) );
					vo.setClientIp( rs.getString(5) );
					vo.setFsn( rs.getString(6) );
					vo.setOfn( rs.getString(7) );
					vo.setUserId( rs.getString(8) );
					vo.setViewNo( rs.getInt(9));
					vo.setLikeNo( rs.getInt(10));
					return vo;
				}} );
		return ls;
	}

	
	
	@Override
	public List<BangVO> findGleText(String text) throws Exception {
		String sql = "SELECT no, title, text, TO_CHAR(the_time,'YYYY-MM-DD HH24:MI:SS'),"+
					 "client_ip, fsn, ofn, user_id, viewNo, likeNo FROM Bang where text "+
					 "LIKE '%"+text+"%' ORDER BY no DESC";

		System.out.println("sql");
		List<BangVO> ls = jdbcTemplate.query( sql, 
			new RowMapper<BangVO>(){

				@Override
				public BangVO mapRow(ResultSet rs, int arg1)
						throws SQLException {
					BangVO vo = new BangVO();
					vo.setNo( rs.getInt(1) );
					vo.setTitle( rs.getString(2) );
					vo.setText( rs.getString(3) );
					vo.setTheTime( rs.getString(4) );
					vo.setClientIp( rs.getString(5) );
					vo.setFsn( rs.getString(6) );
					vo.setOfn( rs.getString(7) );
					vo.setUserId( rs.getString(8) );
					vo.setViewNo( rs.getInt(9));
					vo.setLikeNo( rs.getInt(10));
					return vo;
				}} );
		return ls;
	}

	
	
	@Override
	public List<BangVO> findGleId(String id) throws Exception {
		String sql = "SELECT no, title, text, TO_CHAR(the_time,'YYYY-MM-DD HH24:MI:SS'),"+
					 " client_ip, fsn, ofn, user_id, viewNo, likeNo FROM Bang where user_id "+
					 "LIKE '%"+ id +"%' ORDER BY no DESC";
		
		List<BangVO> ls = jdbcTemplate.query( sql, 
			new RowMapper<BangVO>(){

				@Override
				public BangVO mapRow(ResultSet rs, int arg1)
						throws SQLException {
					BangVO vo = new BangVO();
					vo.setNo( rs.getInt(1) );
					vo.setTitle( rs.getString(2) );
					vo.setText( rs.getString(3) );
					vo.setTheTime( rs.getString(4) );
					vo.setClientIp( rs.getString(5) );
					vo.setFsn( rs.getString(6) );
					vo.setOfn( rs.getString(7) );
					vo.setUserId( rs.getString(8) );
					vo.setViewNo( rs.getInt(9));
					vo.setLikeNo( rs.getInt(10));
					return vo;
				}} );
		return ls;
	}

	
	
	@Override
	public List<BangVO> findGleReply(String reply) throws Exception {
		String sql = "SELECT no, title, text, TO_CHAR(the_time,'YYYY-MM-DD HH24:MI:SS'),"+
					"client_ip, fsn, ofn, user_id, viewNo, likeNo FROM Bang where no in"+
					"(SELECT no from ReplyBang where reply LIKE '%"+
					reply+"%' GROUP BY no)"; //댓글내용을 토대로 게시글 no를 선택해 가져오도록한다.
		List<BangVO> ls = jdbcTemplate.query( sql, 
			new RM_Bang() );
		return ls;
	}

	
	
	@Override
	public boolean pluslikecheck(String no, String userId) throws Exception {
		
		boolean bln = true;
		String sql = "SELECT USER_ID FROM LikeBang WHERE NO="+no;
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

		String sql = "UPDATE Bang SET LIKENO=LIKENO+1"+
					 "WHERE NO=?";

		int i = jdbcTemplate.update( sql, new PreparedStatementSetter(){
					public void setValues(PreparedStatement stmt)
					throws SQLException 
				{
					stmt.setString(1, no );
				}	});
			
				
		String sql2 = "INSERT INTO LikeBang VALUES(?,?)";

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
	public List<BangVO> findPage( String no ) throws Exception {
		System.out.println("여기까지가");
		int n = Integer.parseInt(no);
		int start = (n-1)*10;
		int end = n*10;
		
		String sql = "SELECT no, title, text, TO_CHAR(the_time, 'YYYY-MM-DD HH24:MI:SS'), "+
					 "client_ip, fsn, ofn, Bang.user_id, viewNo, likeNo "+
					 "FROM UserTb,Bang WHERE UserTb.user_id = Bang.user_id AND "+
					 "no IN ( SELECT no FROM ( SELECT no, rownum as sq FROM "+
					 "( SELECT no FROM Bang WHERE 0 = 0 ORDER BY no DESC ) ) "+
					 "WHERE sq > "+start+" AND sq <= "+end+" ) ORDER BY no DESC";
			
		System.out.println( jdbcTemplate.hashCode() );
		

		List<BangVO> ls = jdbcTemplate.query( sql, new RM_Bang() );
		return ls;
	}


}













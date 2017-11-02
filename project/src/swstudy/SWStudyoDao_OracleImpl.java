package swstudy;

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

public class SWStudyoDao_OracleImpl implements SWStudyDao{
	
	private JdbcTemplate jdbcTemplate = null;
	
	public void setJdbcTemplate( JdbcTemplate j ){
		jdbcTemplate = j;
	}
	
	
	// ok
	@Override
	public int add(final SWStudyVO pvo) throws Exception {
		
		String sql = "INSERT INTO SWStudy VALUES "+
				"(SEQ_SWStudy.NEXTVAL,?,?,SYSDATE,?,?,"+
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
	
	
	//ok ���� ���ڼ� ������ �÷��ٰ�.
	@Override
	public int update( final SWStudyVO pvo) throws Exception {
		
		String sql = "UPDATE SWStudy SET TITLE=?,TEXT=?,"+ 
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
	
	
	// ok �ۼ��ڰ� �ƴ� ����ڰ� �����Ϸ��� ��� alertó�����ٰ�.
	@Override
	public int del(final String no) throws Exception {
		
		String sql = "delete from SWStudy where no=?";
		
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
		String sql = "UPDATE SWStudy SET ViewNo=ViewNo+1"+
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
	public List<SWStudyVO> findAll() throws Exception {
		String sql = "SELECT no, title, text, TO_CHAR(the_time,"+
				"'YYYY-MM-DD HH24:MI:SS'), client_ip, "+
				"SWStudy.user_id, viewNo, likeNo FROM UserTb, "+
				"SWStudy WHERE UserTb.user_id = SWStudy.user_id "+
				"ORDER BY no DESC";
		List<SWStudyVO> ls = jdbcTemplate.query( sql, 
			new RowMapper<SWStudyVO>(){

				@Override
				public SWStudyVO mapRow(ResultSet rs, int arg1)
						throws SQLException {
					SWStudyVO vo = new SWStudyVO();
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

	
	// ok ������������ �� ������
	@Override
	public List<SWStudyVO> findGleNo( String no ) throws Exception {
		String sql = "SELECT no, title, text, TO_CHAR(the_time,'YYYY-MM-DD HH24:MI:SS'),"+
					"client_ip, user_id, viewNo, likeNo FROM SWStudy where no="+no;
		List<SWStudyVO> ls = jdbcTemplate.query( sql, 
			new RowMapper<SWStudyVO>(){

				@Override
				public SWStudyVO mapRow(ResultSet rs, int arg1)
						throws SQLException {
					SWStudyVO vo = new SWStudyVO();
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
	public List<SWStudyVO> findGleTitle(String title) throws Exception {
		String sql = "SELECT no, title, text, TO_CHAR(the_time,'YYYY-MM-DD HH24:MI:SS'),"+
					 "client_ip, user_id, viewNo, likeNo FROM SWStudy where "+
					 "title LIKE '%"+title+"%' ORDER BY no DESC";
		
		System.out.println(sql);
		List<SWStudyVO> ls = jdbcTemplate.query( sql, 
			new RowMapper<SWStudyVO>(){

				@Override
				public SWStudyVO mapRow(ResultSet rs, int arg1)
						throws SQLException {
					SWStudyVO vo = new SWStudyVO();
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
	public List<SWStudyVO> findGleText(String text) throws Exception {
		String sql = "SELECT no, title, text, TO_CHAR(the_time,'YYYY-MM-DD HH24:MI:SS'),"+
					 "client_ip, user_id, viewNo, likeNo FROM SWStudy where text "+
					 "LIKE '%"+text+"%' ORDER BY no DESC";

		System.out.println("sql");
		List<SWStudyVO> ls = jdbcTemplate.query( sql, 
			new RowMapper<SWStudyVO>(){

				@Override
				public SWStudyVO mapRow(ResultSet rs, int arg1)
						throws SQLException {
					SWStudyVO vo = new SWStudyVO();
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
	public List<SWStudyVO> findGleId(String id) throws Exception {
		String sql = "SELECT no, title, text, TO_CHAR(the_time,'YYYY-MM-DD HH24:MI:SS'),"+
					 " client_ip, user_id, viewNo, likeNo FROM SWStudy where user_id "+
					 "LIKE '%"+ id +"%' ORDER BY no DESC";
		
		List<SWStudyVO> ls = jdbcTemplate.query( sql, 
			new RowMapper<SWStudyVO>(){

				@Override
				public SWStudyVO mapRow(ResultSet rs, int arg1)
						throws SQLException {
					SWStudyVO vo = new SWStudyVO();
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
	public List<SWStudyVO> findGleReply(String reply) throws Exception {
		String sql = "SELECT no, title, text, TO_CHAR(the_time,'YYYY-MM-DD HH24:MI:SS'),"+
					"client_ip, user_id, viewNo, likeNo FROM SWStudy where no in"+
					"(SELECT no from ReplySWStudy where reply LIKE '%"+
					reply+"%' GROUP BY no)"; //��۳����� ���� �Խñ� no�� ������ �����������Ѵ�.
		List<SWStudyVO> ls = jdbcTemplate.query( sql, 
			new RM_SWStudy() );
		return ls;
	}

	
	
	@Override
	public boolean pluslikecheck(String no, String userId) throws Exception {
		
		boolean bln = true;
		String sql = "SELECT USER_ID FROM LikeSWStudy WHERE NO="+no;
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

		String sql = "UPDATE SWStudy SET LIKENO=LIKENO+1"+
					 "WHERE NO=?";

		int i = jdbcTemplate.update( sql, new PreparedStatementSetter(){
					public void setValues(PreparedStatement stmt)
					throws SQLException 
				{
					stmt.setString(1, no );
				}	});
			
				
		String sql2 = "INSERT INTO LikeSWStudy VALUES(?,?)";

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
	
	
	
	// sql ���̷��� ����������.
	@Override
	public List<SWStudyVO> findPage( String no ) throws Exception {
		System.out.println("���������");
		int n = Integer.parseInt(no);
		int start = (n-1)*10;
		int end = n*10;
		
		String sql = "SELECT no, title, text, TO_CHAR(the_time, 'YYYY-MM-DD HH24:MI:SS'), "+
					 "client_ip, SWStudy.user_id, viewNo, likeNo "+
					 "FROM UserTb,SWStudy WHERE UserTb.user_id = SWStudy.user_id AND "+
					 "no IN ( SELECT no FROM ( SELECT no, rownum as sq FROM "+
					 "( SELECT no FROM SWStudy WHERE 0 = 0 ORDER BY no DESC ) ) "+
					 "WHERE sq > "+start+" AND sq <= "+end+" ) ORDER BY no DESC";
			
		List<SWStudyVO> ls = jdbcTemplate.query( sql, new RM_SWStudy() );
		return ls;
	}


}













package user;

import java.sql.Connection;
import java.sql.DriverManager;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;





import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementSetter;
import org.springframework.jdbc.core.RowMapper;

public class UserDao_OracleImpl implements UserDao{

	private JdbcTemplate jdbcTemplate = null;
	
	public void setJdbcTemplate( JdbcTemplate j ){
		jdbcTemplate = j;
		
	}
	
	@Override
	public UserVO findByPk(String userId) throws Exception {
		
		try{
			String sql = "SELECT user_Id,passwd,point,user_Name,"+
			"power FROM UserTb WHERE user_id ='" +userId+"'";
			
			UserVO vo = jdbcTemplate.queryForObject(sql, new RM_User() );
			return vo;
		}
		catch ( EmptyResultDataAccessException e){}
		return null;
	}
	
	@Override
	public int compareId(final String userId) throws Exception {

			String sql = "SELECT COUNT(*) FROM userTb WHERE user_id=?";
			return ( jdbcTemplate.update( sql, 
			new PreparedStatementSetter(){
				public void setValues(PreparedStatement stmt)
					throws SQLException 
				{
					stmt.setString(1, userId );
				}
			}) );
	}
	
	
	@Override
	public int add( final UserVO pvo) throws Exception {
		
		String sql = "INSERT INTO UserTb VALUES (?,?,1000,?,?,0)";
			
			return jdbcTemplate.update( sql, new PreparedStatementSetter(){
						public void setValues(PreparedStatement stmt)
						throws SQLException 
					{
						stmt.setString(1, pvo.getUserId() );
						stmt.setString(2, pvo.getPasswd() );
						stmt.setString(3, pvo.getUserName() );
					}
			});
	}

	@Override
	public int movePoint(final int no, final String downer) throws Exception {
		
			String sql = "UPDATE userTb SET point = point + 50 "+
				"WHERE user_id = ( SELECT user_id FROM "+
				"Bang WHERE no = ?)";
				
			int i = jdbcTemplate.update( sql, new PreparedStatementSetter(){
							public void setValues(PreparedStatement stmt)
								throws SQLException 
							{
								stmt.setInt(1, no );
							}
					});
		
		
			String sql2 = "UPDATE userTb SET point = point - 50 "+
				"WHERE user_id = ?";	
				
			int j = jdbcTemplate.update( sql2, new PreparedStatementSetter(){
							public void setValues(PreparedStatement stmt)
								throws SQLException 
							{
								stmt.setString(1, downer );
							}
					});		
		
		return i+j;

	}

}

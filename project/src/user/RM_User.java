package user;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;


public class RM_User implements RowMapper<UserVO>{
	@Override
	public UserVO mapRow(ResultSet rs, int arg1) throws SQLException {
		UserVO vo = new UserVO();
					vo.setUserId( rs.getString("user_Id") );
					vo.setPasswd( rs.getString("passwd") );
					vo.setPoint( rs.getInt("point") );		
					vo.setUserName( rs.getString("user_Name") );
					vo.setPower( rs.getInt("power") );
		return vo;
	}
}

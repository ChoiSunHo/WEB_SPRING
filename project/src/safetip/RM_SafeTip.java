package safetip;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;


public class RM_SafeTip implements RowMapper<SafeTipVO>{
	@Override
	public SafeTipVO mapRow(ResultSet rs, int arg1) throws SQLException {
		
			SafeTipVO vo = new SafeTipVO();
			vo.setNo( rs.getInt(1) );
			vo.setTitle( rs.getString(2) );
			vo.setText( rs.getString(3) );
			vo.setTheTime( rs.getString(4) );
			vo.setClientIp( rs.getString(5) );
			vo.setUserId( rs.getString(6) );
			vo.setViewNo( rs.getInt(7));
			vo.setLikeNo( rs.getInt(8));
			
		return vo;
		
	}
}

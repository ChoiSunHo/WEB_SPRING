package safetip;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

public class RM_ReplySafeTip implements RowMapper<ReplySafeTipVO>{
	@Override
	public ReplySafeTipVO mapRow(ResultSet rs, int arg1) throws SQLException {
		ReplySafeTipVO vo = new ReplySafeTipVO();
		vo.setNo( rs.getInt("no") );
		vo.setReno( rs.getInt("reno") );
		vo.setUserId( rs.getString("user_ID") );		
		vo.setReply( rs.getString("reply") );
		vo.setClientIp( rs.getString("client_Ip") );
		vo.setTheTime( rs.getString("the_time") );
		
		return vo;
	}
}

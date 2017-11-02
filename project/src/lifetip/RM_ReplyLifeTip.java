package lifetip;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

public class RM_ReplyLifeTip implements RowMapper<ReplyLifeTipVO>{
	@Override
	public ReplyLifeTipVO mapRow(ResultSet rs, int arg1) throws SQLException {
		ReplyLifeTipVO vo = new ReplyLifeTipVO();
		vo.setNo( rs.getInt("no") );
		vo.setReno( rs.getInt("reno") );
		vo.setUserId( rs.getString("user_ID") );		
		vo.setReply( rs.getString("reply") );
		vo.setClientIp( rs.getString("client_Ip") );
		vo.setTheTime( rs.getString("the_time") );
		
		return vo;
	}
}

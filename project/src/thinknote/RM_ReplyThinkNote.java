package thinknote;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

public class RM_ReplyThinkNote implements RowMapper<ReplyThinkNoteVO>{
	@Override
	public ReplyThinkNoteVO mapRow(ResultSet rs, int arg1) throws SQLException {
		ReplyThinkNoteVO vo = new ReplyThinkNoteVO();
		vo.setNo( rs.getInt("no") );
		vo.setReno( rs.getInt("reno") );
		vo.setUserId( rs.getString("user_ID") );		
		vo.setReply( rs.getString("reply") );
		vo.setClientIp( rs.getString("client_Ip") );
		vo.setTheTime( rs.getString("the_time") );
		
		return vo;
	}
}

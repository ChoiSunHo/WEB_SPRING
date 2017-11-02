package bang;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;


public class RM_Bang implements RowMapper<BangVO>{
	@Override
	public BangVO mapRow(ResultSet rs, int arg1) throws SQLException {
		
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
		
	}
}

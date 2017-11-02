package picture;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;


public class RM_Picture implements RowMapper<PictureVO>{
	@Override
	public PictureVO mapRow(ResultSet rs, int arg1) throws SQLException {
		
			PictureVO vo = new PictureVO();
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

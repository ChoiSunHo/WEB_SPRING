package swstudy;

import java.util.List;

public interface ReplySWStudyDao {
	public int add( ReplySWStudyVO pvo ) throws Exception;
	public int update( ReplySWStudyVO pvo ) throws Exception;
	public int del( String no ) throws Exception;
	public List<ReplySWStudyVO> findReply(String no) throws Exception;
}

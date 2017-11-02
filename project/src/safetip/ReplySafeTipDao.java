package safetip;

import java.util.List;

public interface ReplySafeTipDao {
	public int add( ReplySafeTipVO pvo ) throws Exception;
	public int update( ReplySafeTipVO pvo ) throws Exception;
	public int del( String no ) throws Exception;
	public List<ReplySafeTipVO> findReply(String no) throws Exception;
}

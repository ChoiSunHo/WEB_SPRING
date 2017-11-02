package lifetip;

import java.util.List;

public interface ReplyLifeTipDao {
	public int add( ReplyLifeTipVO pvo ) throws Exception;
	public int update( ReplyLifeTipVO pvo ) throws Exception;
	public int del( String no ) throws Exception;
	public List<ReplyLifeTipVO> findReply(String no) throws Exception;
}

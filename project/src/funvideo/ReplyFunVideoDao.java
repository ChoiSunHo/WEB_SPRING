package funvideo;

import java.util.List;

public interface ReplyFunVideoDao {
	public int add( ReplyFunVideoVO pvo ) throws Exception;
	public int update( ReplyFunVideoVO pvo ) throws Exception;
	public int del( String no ) throws Exception;
	public List<ReplyFunVideoVO> findReply(String no) throws Exception;
}

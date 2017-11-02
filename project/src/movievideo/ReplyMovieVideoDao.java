package movievideo;

import java.util.List;

public interface ReplyMovieVideoDao {
	public int add( ReplyMovieVideoVO pvo ) throws Exception;
	public int update( ReplyMovieVideoVO pvo ) throws Exception;
	public int del( String no ) throws Exception;
	public List<ReplyMovieVideoVO> findReply(String no) throws Exception;
}

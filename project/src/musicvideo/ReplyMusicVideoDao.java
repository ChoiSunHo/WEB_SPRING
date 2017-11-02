package musicvideo;

import java.util.List;

public interface ReplyMusicVideoDao {
	public int add( ReplyMusicVideoVO pvo ) throws Exception;
	public int update( ReplyMusicVideoVO pvo ) throws Exception;
	public int del( String no ) throws Exception;
	public List<ReplyMusicVideoVO> findReply(String no) throws Exception;
}

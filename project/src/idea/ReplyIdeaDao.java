package idea;

import java.util.List;

public interface ReplyIdeaDao {
	public int add( ReplyIdeaVO pvo ) throws Exception;
	public int update( ReplyIdeaVO pvo ) throws Exception;
	public int del( String no ) throws Exception;
	public List<ReplyIdeaVO> findReply(String no) throws Exception;
}

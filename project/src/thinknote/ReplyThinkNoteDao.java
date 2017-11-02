package thinknote;

import java.util.List;

public interface ReplyThinkNoteDao {
	public int add( ReplyThinkNoteVO pvo ) throws Exception;
	public int update( ReplyThinkNoteVO pvo ) throws Exception;
	public int del( String no ) throws Exception;
	public List<ReplyThinkNoteVO> findReply(String no) throws Exception;
}

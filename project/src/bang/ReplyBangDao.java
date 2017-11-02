package bang;

import java.util.List;

public interface ReplyBangDao {
	public int add( ReplyBangVO pvo ) throws Exception;
	public int update( ReplyBangVO pvo ) throws Exception;
	public int del( String no ) throws Exception;
	public List<ReplyBangVO> findReply(String no) throws Exception;
}

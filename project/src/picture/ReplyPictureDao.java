package picture;

import java.util.List;

public interface ReplyPictureDao {
	public int add( ReplyPictureVO pvo ) throws Exception;
	public int update( ReplyPictureVO pvo ) throws Exception;
	public int del( String no ) throws Exception;
	public List<ReplyPictureVO> findReply(String no) throws Exception;
}

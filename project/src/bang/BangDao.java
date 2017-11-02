package bang;

import java.util.List;

public interface BangDao {
	public int add( BangVO pvo ) throws Exception;
	public int update( BangVO pvo ) throws Exception;
	public int del( String no ) throws Exception;
	public int plusview( String no ) throws Exception;
	public boolean pluslikecheck( String no , String userId ) throws Exception;
	public int pluslike( String no, String userId ) throws Exception;
	public List<BangVO> findPage( String no ) throws Exception;
	public List<BangVO> findAll() throws Exception;
	public List<BangVO> findGleNo(String no) throws Exception;
	public List<BangVO> findGleTitle(String title) throws Exception;
	public List<BangVO> findGleText(String text) throws Exception;
	public List<BangVO> findGleId(String id) throws Exception;
	public List<BangVO> findGleReply(String reply) throws Exception;
}

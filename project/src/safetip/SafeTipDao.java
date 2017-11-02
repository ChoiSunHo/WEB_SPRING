package safetip;

import java.util.List;

public interface SafeTipDao {
	public int add( SafeTipVO pvo ) throws Exception;
	public int update( SafeTipVO pvo ) throws Exception;
	public int del( String no ) throws Exception;
	public int plusview( String no ) throws Exception;
	public boolean pluslikecheck( String no , String userId ) throws Exception;
	public int pluslike( String no, String userId ) throws Exception;
	public List<SafeTipVO> findPage( String no ) throws Exception;
	public List<SafeTipVO> findAll() throws Exception;
	public List<SafeTipVO> findGleNo(String no) throws Exception;
	public List<SafeTipVO> findGleTitle(String title) throws Exception;
	public List<SafeTipVO> findGleText(String text) throws Exception;
	public List<SafeTipVO> findGleId(String id) throws Exception;
	public List<SafeTipVO> findGleReply(String reply) throws Exception;
}

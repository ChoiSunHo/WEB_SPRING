package funvideo;

import java.util.List;

public interface FunVideoDao {
	public int add( FunVideoVO pvo ) throws Exception;
	public int update( FunVideoVO pvo ) throws Exception;
	public int del( String no ) throws Exception;
	public int plusview( String no ) throws Exception;
	public boolean pluslikecheck( String no , String userId ) throws Exception;
	public int pluslike( String no, String userId ) throws Exception;
	public List<FunVideoVO> findPage( String no ) throws Exception;
	public List<FunVideoVO> findAll() throws Exception;
	public List<FunVideoVO> findGleNo(String no) throws Exception;
	public List<FunVideoVO> findGleTitle(String title) throws Exception;
	public List<FunVideoVO> findGleText(String text) throws Exception;
	public List<FunVideoVO> findGleId(String id) throws Exception;
	public List<FunVideoVO> findGleReply(String reply) throws Exception;
}

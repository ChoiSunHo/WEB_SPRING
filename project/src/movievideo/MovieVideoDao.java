package movievideo;

import java.util.List;

public interface MovieVideoDao {
	public int add( MovieVideoVO pvo ) throws Exception;
	public int update( MovieVideoVO pvo ) throws Exception;
	public int del( String no ) throws Exception;
	public int plusview( String no ) throws Exception;
	public boolean pluslikecheck( String no , String userId ) throws Exception;
	public int pluslike( String no, String userId ) throws Exception;
	public List<MovieVideoVO> findPage( String no ) throws Exception;
	public List<MovieVideoVO> findAll() throws Exception;
	public List<MovieVideoVO> findGleNo(String no) throws Exception;
	public List<MovieVideoVO> findGleTitle(String title) throws Exception;
	public List<MovieVideoVO> findGleText(String text) throws Exception;
	public List<MovieVideoVO> findGleId(String id) throws Exception;
	public List<MovieVideoVO> findGleReply(String reply) throws Exception;
}

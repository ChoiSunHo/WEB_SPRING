package musicvideo;

import java.util.List;

public interface MusicVideoDao {
	public int add( MusicVideoVO pvo ) throws Exception;
	public int update( MusicVideoVO pvo ) throws Exception;
	public int del( String no ) throws Exception;
	public int plusview( String no ) throws Exception;
	public boolean pluslikecheck( String no , String userId ) throws Exception;
	public int pluslike( String no, String userId ) throws Exception;
	public List<MusicVideoVO> findPage( String no ) throws Exception;
	public List<MusicVideoVO> findAll() throws Exception;
	public List<MusicVideoVO> findGleNo(String no) throws Exception;
	public List<MusicVideoVO> findGleTitle(String title) throws Exception;
	public List<MusicVideoVO> findGleText(String text) throws Exception;
	public List<MusicVideoVO> findGleId(String id) throws Exception;
	public List<MusicVideoVO> findGleReply(String reply) throws Exception;
}

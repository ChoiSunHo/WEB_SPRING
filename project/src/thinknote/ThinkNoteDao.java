package thinknote;

import java.util.List;

public interface ThinkNoteDao {
	public int add( ThinkNoteVO pvo ) throws Exception;
	public int update( ThinkNoteVO pvo ) throws Exception;
	public int del( String no ) throws Exception;
	public int plusview( String no ) throws Exception;
	public boolean pluslikecheck( String no , String userId ) throws Exception;
	public int pluslike( String no, String userId ) throws Exception;
	public List<ThinkNoteVO> findPage( String no ) throws Exception;
	public List<ThinkNoteVO> findAll() throws Exception;
	public List<ThinkNoteVO> findGleNo(String no) throws Exception;
	public List<ThinkNoteVO> findGleTitle(String title) throws Exception;
	public List<ThinkNoteVO> findGleText(String text) throws Exception;
	public List<ThinkNoteVO> findGleId(String id) throws Exception;
	public List<ThinkNoteVO> findGleReply(String reply) throws Exception;
}

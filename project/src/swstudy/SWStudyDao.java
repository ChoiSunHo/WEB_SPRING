package swstudy;

import java.util.List;

public interface SWStudyDao {
	public int add( SWStudyVO pvo ) throws Exception;
	public int update( SWStudyVO pvo ) throws Exception;
	public int del( String no ) throws Exception;
	public int plusview( String no ) throws Exception;
	public boolean pluslikecheck( String no , String userId ) throws Exception;
	public int pluslike( String no, String userId ) throws Exception;
	public List<SWStudyVO> findPage( String no ) throws Exception;
	public List<SWStudyVO> findAll() throws Exception;
	public List<SWStudyVO> findGleNo(String no) throws Exception;
	public List<SWStudyVO> findGleTitle(String title) throws Exception;
	public List<SWStudyVO> findGleText(String text) throws Exception;
	public List<SWStudyVO> findGleId(String id) throws Exception;
	public List<SWStudyVO> findGleReply(String reply) throws Exception;
}

package idea;

import java.util.List;

public interface IdeaDao {
	public int add( IdeaVO pvo ) throws Exception;
	public int update( IdeaVO pvo ) throws Exception;
	public int del( String no ) throws Exception;
	public int plusview( String no ) throws Exception;
	public boolean pluslikecheck( String no , String userId ) throws Exception;
	public int pluslike( String no, String userId ) throws Exception;
	public List<IdeaVO> findPage( String no ) throws Exception;
	public List<IdeaVO> findAll() throws Exception;
	public List<IdeaVO> findGleNo(String no) throws Exception;
	public List<IdeaVO> findGleTitle(String title) throws Exception;
	public List<IdeaVO> findGleText(String text) throws Exception;
	public List<IdeaVO> findGleId(String id) throws Exception;
	public List<IdeaVO> findGleReply(String reply) throws Exception;
}

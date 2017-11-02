package lifetip;

import java.util.List;

public interface LifeTipDao {
	public int add( LifeTipVO pvo ) throws Exception;
	public int update( LifeTipVO pvo ) throws Exception;
	public int del( String no ) throws Exception;
	public int plusview( String no ) throws Exception;
	public boolean pluslikecheck( String no , String userId ) throws Exception;
	public int pluslike( String no, String userId ) throws Exception;
	public List<LifeTipVO> findPage( String no ) throws Exception;
	public List<LifeTipVO> findAll() throws Exception;
	public List<LifeTipVO> findGleNo(String no) throws Exception;
	public List<LifeTipVO> findGleTitle(String title) throws Exception;
	public List<LifeTipVO> findGleText(String text) throws Exception;
	public List<LifeTipVO> findGleId(String id) throws Exception;
	public List<LifeTipVO> findGleReply(String reply) throws Exception;
}

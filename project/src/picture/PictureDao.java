package picture;

import java.util.List;

public interface PictureDao {
	public int add( PictureVO pvo ) throws Exception;
	public int update( PictureVO pvo ) throws Exception;
	public int del( String no ) throws Exception;
	public int plusview( String no ) throws Exception;
	public boolean pluslikecheck( String no , String userId ) throws Exception;
	public int pluslike( String no, String userId ) throws Exception;
	public List<PictureVO> findPage( String no ) throws Exception;
	public List<PictureVO> findAll() throws Exception;
	public List<PictureVO> findGleNo(String no) throws Exception;
	public List<PictureVO> findGleTitle(String title) throws Exception;
	public List<PictureVO> findGleText(String text) throws Exception;
	public List<PictureVO> findGleId(String id) throws Exception;
	public List<PictureVO> findGleReply(String reply) throws Exception;
}

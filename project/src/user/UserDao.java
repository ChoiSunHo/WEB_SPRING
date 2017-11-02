package user;

public interface UserDao {
	public UserVO findByPk( String userId ) throws Exception;
	public int add( UserVO pvo ) throws Exception;
	public int compareId( String userId ) throws Exception;
	public int movePoint( int no, String downer ) throws Exception;
}

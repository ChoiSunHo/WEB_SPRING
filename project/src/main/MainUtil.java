package main;

import java.util.UUID;

public class MainUtil {
	public static String uuid(){
		UUID uuid = UUID.randomUUID();
		String l = uuid.toString();
		return noMinus( l );
	}
	
	public static String noMinus( String l ){
		char[] l2 = new char[32];
		char[] cs = l.toCharArray();
		int j = 0;
		for( int i = 0 ; i < 36 ;i++ ){
			if( cs[i] != '-' ){
				l2[j++] = cs[i];
			}
		}
		return new String( l2 );
	}
}

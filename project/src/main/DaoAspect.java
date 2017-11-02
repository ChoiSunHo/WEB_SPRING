package main;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.support.TransactionCallback;
import org.springframework.transaction.support.TransactionTemplate;

@Aspect
public class DaoAspect {
	
	private TransactionTemplate txtpl = null;
	
	public void setTransactionTemplate( 
		TransactionTemplate l )
	{
		txtpl = l;
	}
	
	@Pointcut("execution(* bang.BangDao_OracleImpl.pluslike(..)) ||"+
				"execution(* user.UserDao_OracleImpl.movePoint(..))")
	public void xxyy(){}
	
	@Around("xxyy()")
	public Object ∆Æ∑£¿Ëº«( final ProceedingJoinPoint jp )
		throws Throwable
	{
		Object o = txtpl.execute(new TransactionCallback<Object>()
		{
			@Override
			public Object doInTransaction(TransactionStatus status) {
				try{
					System.out.println("before target");
					Object obj = jp.proceed();
					System.out.println("after target");
					return obj;
				}
				catch( Throwable e ){
					status.setRollbackOnly();
					return e;
				}
			}
		});
		
		if( o != null && o instanceof Throwable ){
			throw (Throwable)o;
		}
		return o;
	}
}



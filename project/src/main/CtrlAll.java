package main;

import idea.IdeaDao;
import idea.ReplyIdeaDao;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import lifetip.LifeTipDao;
import lifetip.ReplyLifeTipDao;
import movievideo.MovieVideoDao;
import movievideo.MovieVideoVO;
import movievideo.ReplyMovieVideoDao;
import movievideo.ReplyMovieVideoVO;
import musicvideo.MusicVideoDao;
import musicvideo.ReplyMusicVideoDao;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import picture.PictureDao;
import picture.ReplyPictureDao;

import safetip.ReplySafeTipDao;
import safetip.SafeTipDao;
import swstudy.ReplySWStudyDao;
import swstudy.SWStudyDao;
import thinknote.ReplyThinkNoteDao;
import thinknote.ThinkNoteDao;
import user.UserDao;
import user.UserDao_OracleImpl;
import user.UserVO;

import bang.BangDao;
import bang.BangDao_OracleImpl;
import bang.BangVO;
import bang.ReplyBangDao;
import bang.ReplyBangVO;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

import funvideo.FunVideoDao;
import funvideo.ReplyFunVideoDao;

@Controller
public class CtrlAll 
{
	private UserDao userDao = null;
	private BangDao bangDao = null;
	private ReplyBangDao replybangDao = null;
	private MovieVideoDao movievideoDao = null;
	private ReplyMovieVideoDao replymovievideoDao = null;
	private MusicVideoDao musicvideoDao = null;
	private ReplyMusicVideoDao replymusicvideoDao = null;
	private FunVideoDao funvideoDao = null;
	private ReplyFunVideoDao replyfunvideoDao = null;
	private PictureDao pictureDao = null;
	private ReplyPictureDao replypictureDao = null;
	private IdeaDao ideaDao = null;
	private ReplyIdeaDao replyideaDao = null;
	private SafeTipDao safetipDao = null;
	private ReplySafeTipDao replysafetipDao = null;
	private LifeTipDao lifetipDao = null;
	private ReplyLifeTipDao replylifetipDao = null;
	private ThinkNoteDao thinknoteDao = null;
	private ReplyThinkNoteDao replythinknoteDao = null;
	private SWStudyDao swstudyDao = null;
	private ReplySWStudyDao replyswstudyDao = null;
	
	

	
	
	
	
	
	public void setUserDao(UserDao userDao) {
		this.userDao = userDao;
	}


	public void setBangDao(BangDao bangDao) {
		this.bangDao = bangDao;
	}


	public void setReplybangDao(ReplyBangDao replybangDao) {
		this.replybangDao = replybangDao;
	}


	public void setMovievideoDao(MovieVideoDao movievideoDao) {
		this.movievideoDao = movievideoDao;
	}


	public void setReplymovievideoDao(ReplyMovieVideoDao replymovievideoDao) {
		this.replymovievideoDao = replymovievideoDao;
	}


	public void setMusicvideoDao(MusicVideoDao musicvideoDao) {
		this.musicvideoDao = musicvideoDao;
	}


	public void setReplymusicvideoDao(ReplyMusicVideoDao replymusicvideoDao) {
		this.replymusicvideoDao = replymusicvideoDao;
	}


	public void setFunvideoDao(FunVideoDao funvideoDao) {
		this.funvideoDao = funvideoDao;
	}


	public void setReplyfunvideoDao(ReplyFunVideoDao replyfunvideoDao) {
		this.replyfunvideoDao = replyfunvideoDao;
	}


	public void setPictureDao(PictureDao pictureDao) {
		this.pictureDao = pictureDao;
	}


	public void setReplypictureDao(ReplyPictureDao replypictureDao) {
		this.replypictureDao = replypictureDao;
	}


	public void setIdeaDao(IdeaDao ideaDao) {
		this.ideaDao = ideaDao;
	}


	public void setReplyideaDao(ReplyIdeaDao replyideaDao) {
		this.replyideaDao = replyideaDao;
	}


	public void setSafetipDao(SafeTipDao safetipDao) {
		this.safetipDao = safetipDao;
	}


	public void setReplysafetipDao(ReplySafeTipDao replysafetipDao) {
		this.replysafetipDao = replysafetipDao;
	}


	public void setLifetipDao(LifeTipDao lifetipDao) {
		this.lifetipDao = lifetipDao;
	}


	public void setReplylifetipDao(ReplyLifeTipDao replylifetipDao) {
		this.replylifetipDao = replylifetipDao;
	}


	public void setThinknoteDao(ThinkNoteDao thinknoteDao) {
		this.thinknoteDao = thinknoteDao;
	}


	public void setReplythinknoteDao(ReplyThinkNoteDao replythinknoteDao) {
		this.replythinknoteDao = replythinknoteDao;
	}


	public void setSwstudyDao(SWStudyDao swstudyDao) {
		this.swstudyDao = swstudyDao;
	}


	public void setReplyswstudyDao(ReplySWStudyDao replyswstudyDao) {
		this.replyswstudyDao = replyswstudyDao;
	}




	@RequestMapping("/main.do")
	public String main( HttpServletRequest request,
		HttpServletResponse response ) throws Exception
	{
		return "main";
	}

	
	
	@RequestMapping("/mains.do")
	public ModelAndView mains( HttpServletRequest request,
		HttpServletResponse response ) throws Exception
	{
		List<String> ls = new ArrayList<String>();
		String state = request.getParameter("state");
		ls.add( state );
		System.out.println(state);
		ModelAndView mnv = new ModelAndView("mains");
		mnv.addObject("l",ls);
		return mnv;
	}


	@RequestMapping("/plususer.do")
	public ModelAndView plususer( HttpServletRequest request,
		@ModelAttribute UserVO pvo ) throws Exception
	{
		/*
		try{
			byte[] buf = userName.getBytes("8859_1");
			userName = new String( buf, "utf-8");
		}
		catch(Exception e){}
		*/
		if ( userDao.findByPk(pvo.getUserId()) == null ){
			userDao.add( pvo );
			return new ModelAndView("redirect:/mains.do?state=fini");
		}
		return new ModelAndView("redirect:/mains.do?state=dupl");
	}
	
	
	
	@RequestMapping("/logout.do")
	public ModelAndView logout( HttpServletRequest request,
		HttpServletResponse response ) throws Exception
	{
		HttpSession session = request.getSession();
				session.removeAttribute("UID");
		session.invalidate(); // 세션 지우기
		
		return new ModelAndView("redirect:/main.do");
	}
	
	
	
	@RequestMapping("/main2.do")
	public ModelAndView main2( HttpServletRequest request,
		HttpServletResponse response ) throws Exception
	{
		
		HttpSession session = request.getSession();
		String userId = (String)session.getAttribute("UID");
		ModelAndView mnv = new ModelAndView();
		
		if(userId == null){ // 로그인인증없이 바로 들어올 경우 로그인화면으로 이동
			return new ModelAndView("redirect:/main.do");
		}
		
		List<UserVO> ls = new ArrayList<UserVO>();
		
		UserVO vo = userDao.findByPk(userId);
		ls.add(vo);
		
		mnv.addObject("l", ls);
		mnv.setViewName("main2");
		return mnv;
	}
	
	
	@RequestMapping("/login.do")
	public ModelAndView login2( HttpServletRequest request,
		HttpServletResponse response ) throws Exception
	{
		
			System.out.println("ctrlLogin");
			String userId = request.getParameter("userId");
			String passwd = request.getParameter("passwd");
			
			UserVO fvo = userDao.findByPk(userId);
			if ( fvo == null ){						// 입력받은 ID가 없다
				return new ModelAndView("redirect:/mains.do?state=noid");
			}else if ( passwd.equals(fvo.getPasswd()) ) {// 로그인 성공
				
				HttpSession session = request.getSession();
				session.setAttribute("UID", userId);
				
				return new ModelAndView("redirect:/main2.do");
				
			}else{								   // 비밀번호 불일치
				return new ModelAndView("redirect:/mains.do?state=pwfls");
				}
			}
	
	
	@RequestMapping("/listbang.do")
	public ModelAndView listbang( HttpServletRequest request,
		HttpServletResponse response ) throws Exception
	{
		System.out.println("list.do");
		String page = request.getParameter("page");
		ModelAndView mnv = new ModelAndView("listbang");
		
		HttpSession session = request.getSession();
		String uid = (String)session.getAttribute("UID");
		if(uid == null){
			return new ModelAndView("redirect:/main.do");
		}
		
		List<BangVO> ls = bangDao.findPage(page);
		for (BangVO pvo : ls){
			System.out.println( pvo.toString() );
		}
		mnv.addObject("l", ls);
		return mnv;
	}
	
	
	@RequestMapping("/searchbang.do")
	public ModelAndView searchbang( HttpServletRequest request,
		HttpServletResponse response ) throws Exception
	{
		ModelAndView mnv = new ModelAndView();
		
		String category = request.getParameter("category");
		String text = request.getParameter("search");
		/*
		try{
			byte[] buf = text.getBytes("8859_1");
			text = new String( buf, "utf-8");
		}
		catch(Exception e){}
		*/
		if  (category.equals("title") ){
			List<BangVO>ls = bangDao.findGleTitle(text);
			mnv.addObject("l",ls);
			mnv.setViewName("listbang");
			return mnv;
		} else if ( category.equals("text") ){
			List<BangVO>ls = bangDao.findGleText(text);
			mnv.addObject("l",ls);
			mnv.setViewName("listbang");
			return mnv;
		} else if ( category.equals("id") ){
			List<BangVO>ls = bangDao.findGleId(text);
			mnv.addObject("l",ls);
			mnv.setViewName("listbang");
			return mnv;
		} else if ( category.equals("reply") ){
			List<BangVO>ls = bangDao.findGleReply(text);
			mnv.addObject("l",ls);
			mnv.setViewName("listbang");
			return mnv;
		}
		
		mnv.setViewName("redirect:/main.do");
		return mnv;
	}
	
	
	@RequestMapping("/glebang.do")
	public ModelAndView glebang( HttpServletRequest request,
		HttpServletResponse response ) throws Exception
	{
		ModelAndView mnv = new ModelAndView();
		
		HttpSession session = request.getSession();
		String uid = (String)session.getAttribute("UID");
		if(uid == null){ // 로그인인증없이 바로 들어올 경우 로그인화면으로 이동
			return new ModelAndView("redirect:/main.do");
		}
		
		System.out.println("gle.do::");
		String no = request.getParameter("no");
		
		List<BangVO> vo = bangDao.findGleNo(no);
		List<ReplyBangVO> vo2 = replybangDao.findReply(no);
		List<UserVO> vo3 = new ArrayList<UserVO>();
		
		if (!uid.equals(vo.get(0).getUserId())){ // 클라/작성자 다를경우
			bangDao.plusview(no);				 // 조회수 업
		}
		vo3.add( userDao.findByPk(uid) );
		
		mnv.addObject("l", vo);    // 게시글VO
		mnv.addObject("l2", vo2);  // 댓글VO
		mnv.addObject("l3", vo);   // 게시글VO
		mnv.addObject("l4", vo3);  // 유저VO
		
		mnv.setViewName("glebang");
		return mnv;
	}
	
	
	@RequestMapping("/pluslikebang.do")
	public ModelAndView likeplusbang( HttpServletRequest request,
		HttpServletResponse response ) throws Exception
	{
		HttpSession session = request.getSession();
		String uid = (String)session.getAttribute("UID");
		if(uid == null){ // 로그인인증없이 바로 들어올 경우 로그인화면으로 이동
			return new ModelAndView("redirect:/main.do");
		}
		
		System.out.println("pluslikebang.do::");
		
		String no = request.getParameter("no");
		
		if ( bangDao.pluslikecheck( no, uid) ){
			int i = bangDao.pluslike( no, uid );
			System.out.println( i );
		}
		return new ModelAndView("redirect:/glebang.do?no="+no);
	}
	
	
	
	@RequestMapping("/gleupdate1bang.do")
	public ModelAndView gleUpdatebang( HttpServletRequest request,
		HttpServletResponse response ) throws Exception
	{
		ModelAndView mnv = new ModelAndView();
		String no = request.getParameter("no");
		
		HttpSession session = request.getSession();
		String uid = (String)session.getAttribute("UID");
		
		if( uid.equals(request.getParameter("userId")) ||
				uid.equals("root")){
			List<BangVO> vo = bangDao.findGleNo(no);
		
			mnv.addObject("l", vo);
			mnv.setViewName("gleupdatebang");
			return mnv;
		}
		
		mnv.setViewName("redirect:/glebang.do?no="+no);
			return mnv;
	}
	
	
	@RequestMapping("/gleupdate2bang.do")
	public ModelAndView gleupdate2bang( HttpServletRequest request,
		@ModelAttribute BangVO pvo ) throws Exception
	{	
		HttpSession session = request.getSession();
		String uid = (String)session.getAttribute("UID");
		
		if(uid == null){
			return new ModelAndView("redirect:/main.do");
		}
		
		MultipartFile mf = pvo.getOne();
		pvo.setOfn( mf.getOriginalFilename() );
		
		String fsn = MainUtil.uuid();
		pvo.setFsn(fsn);
		
		byte[] buf = new byte[1024*8];
		int len = 0;
		OutputStream out = new FileOutputStream(
			"C:\\upload\\" + fsn );
		InputStream in = mf.getInputStream();
		while( ( len = in.read( buf ) ) != -1 ){
			out.write( buf, 0, len );
		}
		in.close();
		out.close();
		
		
		pvo.setNo( Integer.parseInt(request.getParameter("no")));
		pvo.setClientIp( request.getRemoteAddr() );
		bangDao.update(pvo);
		return new ModelAndView("redirect:/glebang.do?no="+request.getParameter("no"));
	}
	
	
	@RequestMapping("/gledelbang.do")
	public ModelAndView gledelbang( HttpServletRequest request,
		HttpServletResponse response ) throws Exception
	{
		HttpSession session = request.getSession();
		String uid = (String)session.getAttribute("UID");
		
		if(uid.equals(request.getParameter("userId")) || uid.equals("root")){
			 bangDao.del(request.getParameter("no"));
			return new ModelAndView("redirect:/listbang.do?page=1");
		}
		
		return new ModelAndView("redirect:/glebang.do?no="+request.getParameter("no"));
	}
	
	@RequestMapping("/plusreplybang.do")
	public ModelAndView plusreplybang( HttpServletRequest request,
		@ModelAttribute ReplyBangVO pvo ) throws Exception
	{
		HttpSession session = request.getSession();
		String uid = (String)session.getAttribute("UID");
		if(uid == null){ return new ModelAndView("redirect:/main.do"); }
		
		pvo.setNo(Integer.parseInt(request.getParameter("no")));
		pvo.setUserId(uid);
		pvo.setClientIp( request.getRemoteAddr() );

		replybangDao.add(pvo);
		
		return new ModelAndView("redirect:/glebang.do?no="+request.getParameter("no"));
	}
	
	
	@RequestMapping("/reupdatebang.do")
	public ModelAndView reupdatebang( HttpServletRequest request,
		HttpServletResponse response ) throws Exception
	{
		ModelAndView mnv = new ModelAndView();
		
		HttpSession session = request.getSession();
		String uid = (String)session.getAttribute("UID");
		
		if(uid == null || !uid.equals(request.getParameter("userId"))){
			return new ModelAndView("redirect:/glebang.do?no="+request.getParameter("no"));
		}
		
		List<BangVO> vo = bangDao.findGleNo(request.getParameter("no"));
		List<ReplyBangVO> vo2 = replybangDao.findReply(request.getParameter("no"));
		
		mnv.addObject("l", vo);
		mnv.addObject("rn", vo2);
		
		mnv.setViewName("reupdatebang");
		return mnv;
	}
	
	
	@RequestMapping("/reupdate2bang.do")
	public ModelAndView reupdate2bang( HttpServletRequest request,
		@ModelAttribute ReplyBangVO pvo ) throws Exception
	{	

		HttpSession session = request.getSession();
		String uid = (String)session.getAttribute("UID");
		
		if(uid == null){ return new ModelAndView("redirect:/main.do"); }
		
		pvo.setReno( Integer.parseInt(request.getParameter("reno")) );
		pvo.setClientIp( request.getRemoteAddr() );
		
		replybangDao.update(pvo);
		return new ModelAndView("redirect:/glebang.do?no="+request.getParameter("no"));
	}
	
	
	@RequestMapping("/redelbang.do")
	public ModelAndView redelbang( HttpServletRequest request,
		HttpServletResponse response ) throws Exception
	{

		HttpSession session = request.getSession();
		String uid = (String)session.getAttribute("UID");
		
		if(uid == null || !uid.equals(request.getParameter("userId"))){
			return new ModelAndView("redirect:/glebang.do?no="+request.getParameter("no"));
		}
	
		replybangDao.del(request.getParameter("reno"));
		return new ModelAndView("redirect:/glebang.do?no="+request.getParameter("no"));
	}
	
	
	@RequestMapping("/addbang.do")
	public ModelAndView addbang( HttpServletRequest request,
		HttpServletResponse response ) throws Exception
	{	
		HttpSession session = request.getSession();
		String uid = (String)session.getAttribute("UID");
		if(uid == null){ return new ModelAndView("redirect:/main.do"); }
		
		return new ModelAndView("addbang");
	}
	
	
	@RequestMapping("/file_downbang.do")
	public ModelAndView file_downbang( HttpServletRequest request,
		HttpServletResponse response ) throws Exception
	{
		HttpSession session = request.getSession();
		
		String cp = request.getContextPath();
		String uid = (String)session.getAttribute("UID");
		if( uid == null ){
			response.sendRedirect( cp + "/main.jsp" );
			return null;
		}
		
		String fsn = request.getParameter("fsn");
		String ofn = request.getParameter("ofn");
		String no = request.getParameter("no");
		
		Exception err = null;
		try{
			File f = new File("C:\\upload\\" + fsn );
			if( !f.exists() ){
				response.setStatus( HttpServletResponse.SC_NOT_FOUND );
				return null;
			}

			int no2 = Integer.parseInt( no );
			int rc = userDao.movePoint( no2, uid );
			
			if( rc != 2 ){
				response.setStatus( 
					HttpServletResponse.SC_INTERNAL_SERVER_ERROR );
				return null;
			}
			else
			{
				//	파일 다운로드시에 미리 통보하는 MIME TYPE 
				response.setContentType("application/octet-stream");
				response.setContentLength( (int)f.length() );
				response.setHeader("Content-Disposition",
					"attachment;filename=" + ofn );
				
				OutputStream out = response.getOutputStream();
				InputStream in = new FileInputStream( f );
				
				int len = 0;
				byte[] buf = new byte[1024*8];
				while( ( len = in.read( buf ) ) != -1 ){
					out.write( buf, 0, len );
					out.flush();
				}
				in.close();
				out.close();
			}
		}
		catch( Exception e ){ err = e; }
		
		if( err != null ){
			response.setStatus( 
				HttpServletResponse.SC_INTERNAL_SERVER_ERROR );
		}
		return null;
	}
	
	
	@RequestMapping("/add2bang.do")
	public ModelAndView add2bang( HttpServletRequest request,
		@ModelAttribute BangVO pvo) throws Exception
	{	
		HttpSession session = request.getSession();
		String uid = (String)session.getAttribute("UID");
		
		if(uid == null){
			return new ModelAndView("redirect:/main.do");
		}
		
		MultipartFile mf = pvo.getOne();
		pvo.setOfn( mf.getOriginalFilename() );
		
		String fsn = MainUtil.uuid();
		pvo.setFsn(fsn);
		
		byte[] buf = new byte[1024*8];
		int len = 0;
		OutputStream out = new FileOutputStream(
			"C:\\upload\\" + fsn );
		InputStream in = mf.getInputStream();
		while( ( len = in.read( buf ) ) != -1 ){
			out.write( buf, 0, len );
		}
		in.close();
		out.close();
		
		pvo.setClientIp( request.getRemoteAddr() );
		pvo.setUserId( uid );
		bangDao.add( pvo );
		System.out.println( pvo );
		return new ModelAndView("redirect:/listbang.do?page=1");
	}
	
	@RequestMapping("/listmovievideo.do")
	public ModelAndView listmovievideo( HttpServletRequest request,
		HttpServletResponse response ) throws Exception
	{
		System.out.println("listmovievideo.do");
		String page = request.getParameter("page");
		ModelAndView mnv = new ModelAndView("listmovievideo");
		
		HttpSession session = request.getSession();
		String uid = (String)session.getAttribute("UID");
		if(uid == null){
			return new ModelAndView("redirect:/main.do");
		}
		List<MovieVideoVO> ls = movievideoDao.findPage(page);
		for ( MovieVideoVO pvo : ls){
			System.out.println( pvo.toString() );
		}
		mnv.addObject("l", ls);
		return mnv;
	}
	
	
	
	@RequestMapping("/addmovievideo.do")
	public ModelAndView addmovievideo( HttpServletRequest request,
		HttpServletResponse response ) throws Exception
	{	
		HttpSession session = request.getSession();
		String uid = (String)session.getAttribute("UID");
		if(uid == null){ return new ModelAndView("redirect:/main.do"); }
	
		return new ModelAndView("addmovievideo");
	}
	
	
	
	@RequestMapping("/add2movievideo.do")
	public ModelAndView add2movievideo( HttpServletRequest request,
		@ModelAttribute MovieVideoVO pvo ) throws Exception
	{	
		HttpSession session = request.getSession();
		String uid = (String)session.getAttribute("UID");
		
		if(uid == null){ 
			return new ModelAndView("redirect:/main.do");
		}

		pvo.setClientIp( request.getRemoteAddr() );
		pvo.setUserId( uid );
		movievideoDao.add( pvo );
		
		return new ModelAndView("redirect:/listmovievideo.do?page=1");
	}
	
	
	@RequestMapping("/glemovievideo.do")
	public ModelAndView glemovievideo( HttpServletRequest request,
		HttpServletResponse response ) throws Exception
	{
		ModelAndView mnv = new ModelAndView();
		
		HttpSession session = request.getSession();
		String uid = (String)session.getAttribute("UID");
		if(uid == null){
			return new ModelAndView("redirect:/main.do");
		}

		String no = request.getParameter("no");
		
		List<MovieVideoVO> vo = movievideoDao.findGleNo(no);
		List<ReplyMovieVideoVO> vo2 = replymovievideoDao.findReply(no);
		List<UserVO> vo3 = new ArrayList<UserVO>();
		
		if (!uid.equals(vo.get(0).getUserId())){ movievideoDao.plusview(no); }
		vo3.add( userDao.findByPk(uid) );
		
		mnv.addObject("l", vo);    // 게시글VO
		mnv.addObject("l2", vo2);  // 댓글VO
		mnv.addObject("l3", vo);   // 게시글VO
		mnv.addObject("l4", vo3);  // 유저VO
		
		mnv.setViewName("glemovievideo");
		return mnv;
	}
	
	
	@RequestMapping("/searchmovievideo.do")
	public ModelAndView searchmovievideo( HttpServletRequest request,
		HttpServletResponse response ) throws Exception
	{
		ModelAndView mnv = new ModelAndView();
		
		String category = request.getParameter("category");
		String text = request.getParameter("search");
		/*
		try{
			byte[] buf = text.getBytes("8859_1");
			text = new String( buf, "utf-8");
		}
		catch(Exception e){}
		*/
		if  (category.equals("title") ){
			List<MovieVideoVO>ls = movievideoDao.findGleTitle(text);
			mnv.addObject("l",ls);
			mnv.setViewName("listmovievideo");
			return mnv;
		} else if ( category.equals("text") ){
			List<MovieVideoVO>ls = movievideoDao.findGleText(text);
			mnv.addObject("l",ls);
			mnv.setViewName("listmovievideo");
			return mnv;
		} else if ( category.equals("id") ){
			List<MovieVideoVO>ls = movievideoDao.findGleId(text);
			mnv.addObject("l",ls);
			mnv.setViewName("listmovievideo");
			return mnv;
		} else if ( category.equals("reply") ){
			List<MovieVideoVO>ls = movievideoDao.findGleReply(text);
			mnv.addObject("l",ls);
			mnv.setViewName("listmovievideo");
			return mnv;
		}
		
		mnv.setViewName("redirect:/main.do");
		return mnv;
	}
	
	
	@RequestMapping("/pluslikemovievideo.do")
	public ModelAndView likeplusmovievideo( HttpServletRequest request,
		HttpServletResponse response ) throws Exception
	{
		HttpSession session = request.getSession();
		String uid = (String)session.getAttribute("UID");
		if(uid == null){ 
			return new ModelAndView("redirect:/main.do");
		}
		
		System.out.println("pluslikebang.do::");
		
		String no = request.getParameter("no");
		
		if ( movievideoDao.pluslikecheck( no, uid) ){
			int i = movievideoDao.pluslike( no, uid );
			System.out.println( i );
		}
		return new ModelAndView("redirect:/glemovievideo.do?no="+no);
	}
	
	
	
	@RequestMapping("/gleupdate1movievideo.do")
	public ModelAndView gleUpdatemovievideo( HttpServletRequest request,
		HttpServletResponse response ) throws Exception
	{
		ModelAndView mnv = new ModelAndView();
		String no = request.getParameter("no");
		
		HttpSession session = request.getSession();
		String uid = (String)session.getAttribute("UID");
		
		if( uid.equals(request.getParameter("userId")) ||
				uid.equals("root")){
			List<MovieVideoVO> vo = movievideoDao.findGleNo(no);
		
			mnv.addObject("l", vo);
			mnv.setViewName("gleupdatemovievideo");
			return mnv;
		}
		
		mnv.setViewName("redirect:/glemovievideo.do?no="+no);
			return mnv;
	}
	
	
	@RequestMapping("/gleupdate2movievideo.do")
	public ModelAndView gleupdate2movievideo( HttpServletRequest request,
		@ModelAttribute MovieVideoVO pvo) throws Exception
	{	
		HttpSession session = request.getSession();
		String uid = (String)session.getAttribute("UID");
		
		if(uid == null){
			return new ModelAndView("redirect:/main.do");
		}
		
		pvo.setNo( Integer.parseInt(request.getParameter("no")));
		pvo.setClientIp( request.getRemoteAddr() );

		movievideoDao.update(pvo);
		return new ModelAndView( "redirect:/glemovievideo.do?no="+request.getParameter("no") );
	}
	
	
	@RequestMapping("/gledelmovievideo.do")
	public ModelAndView gledelmovievideo( HttpServletRequest request,
		HttpServletResponse response ) throws Exception
	{
		HttpSession session = request.getSession();
		String uid = (String)session.getAttribute("UID");
		
		if(uid.equals(request.getParameter("userId")) || uid.equals("root")){
			 movievideoDao.del(request.getParameter("no"));
			return new ModelAndView("redirect:/listmovievideo.do?page=1");
		}
		
		return new ModelAndView("redirect:/glemovievideo.do?no="+request.getParameter("no"));
	}
	
	@RequestMapping("/plusreplymovievideo.do")
	public ModelAndView plusreplymovievideo( HttpServletRequest request,
		@ModelAttribute ReplyMovieVideoVO pvo ) throws Exception
	{
		HttpSession session = request.getSession();
		
		if((String)session.getAttribute("UID") == null){
			return new ModelAndView("redirect:/main.do");
		}
	
		pvo.setNo(Integer.parseInt(request.getParameter("no")));
		pvo.setUserId((String)session.getAttribute("UID"));
		pvo.setClientIp( request.getRemoteAddr() );

		replymovievideoDao.add(pvo);
		return new ModelAndView("redirect:/glemovievideo.do?no="+request.getParameter("no"));
	}
	
	
	@RequestMapping("/reupdatemovievideo.do")
	public ModelAndView reupdatemovievideo( HttpServletRequest request,
		HttpServletResponse response ) throws Exception
	{
		ModelAndView mnv = new ModelAndView();
		String no = request.getParameter("no");

		HttpSession session = request.getSession();
		String uid = (String)session.getAttribute("UID");
		
		if(uid == null || !uid.equals(request.getParameter("userId"))){
			return new ModelAndView("redirect:/glemovievideo.do?no="+no);
		}
		
			List<MovieVideoVO> vo = movievideoDao.findGleNo(no);
			List<ReplyMovieVideoVO> vo2 = replymovievideoDao.findReply(no);
		
		mnv.addObject("l", vo);
		mnv.addObject("rn", vo2);
		
		mnv.setViewName("reupdatemovievideo");
		return mnv;
	}
	
	
	@RequestMapping("/reupdate2movievideo.do")
	public ModelAndView reupdate2movievideo( HttpServletRequest request,
		@ModelAttribute ReplyMovieVideoVO pvo ) throws Exception
	{
		HttpSession session = request.getSession();
		String uid = (String)session.getAttribute("UID");
		
		if(uid == null){ 
			return new ModelAndView("redirect:/main.do");
		}
		
		pvo.setReno( Integer.parseInt(request.getParameter("reno")));
		pvo.setClientIp( request.getRemoteAddr() );
		replymovievideoDao.update(pvo);
		
		return new ModelAndView("redirect:/glemovievideo.do?no="+request.getParameter("no"));
	}
	
	
	@RequestMapping("/redelmovievideo.do")
	public ModelAndView redelmovievideo( HttpServletRequest request,
		HttpServletResponse response ) throws Exception
	{
		String no = request.getParameter("no");

		HttpSession session = request.getSession();
		String uid = (String)session.getAttribute("UID");
		
		if(uid == null || !uid.equals(request.getParameter("userId"))){
			return new ModelAndView("redirect:/glebang.do?no="+no);
		}
	
		replymovievideoDao.del(request.getParameter("reno"));
		
		return new ModelAndView("redirect:/glemovievideo.do?no="+no);
	}
}

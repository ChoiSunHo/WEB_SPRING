<%@ page contentType="text/html; charset=utf-8"
    pageEncoding="EUC-KR"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="jl" %>
<html>
<head>
	<meta charset="utf-8"/>
		<link rel="stylesheet" href="bootstrap.css"/>
		<link rel="stylesheet" href="http://code.jquery.com/ui/1.11.4/themes/trontastic/jquery-ui.css"/>
		<style>
		@import url(http://fonts.googleapis.com/earlyaccess/nanumgothic.css);
		body{ font-family:"Helvetica Neue","Nanum Gothic";} 
		#bodyimg {
			background-image:url("https://45.media.tumblr.com/77c1e8b65077e62ab66fbe8efa62bc85/tumblr_mxpq0pMO941sxqh33o1_400.gif");
		}
		</style>
		<script src="http://code.jquery.com/jquery-1.10.2.min.js"></script>
		<script src="http://code.jquery.com/ui/1.11.4/jquery-ui.min.js"></script>
		<script src="bootstrap.js"></script>
		
		<!-- form태그에 method="POST" action="login.do" 빼도 버튼클릭시
			 이어주기때문에 코드진행에 문제없다. -->
	<script>
		getParameter = function(name){
			search=location.search;
			if(!search){	 //파라미터가 하나도 없을때
				return false;
			}
			search=search.split("?");
			data=search[1].split("=");
			if(search[1].indexOf(name)==(-1) || data[0]!=name){ //해당하는 파라미터가 없을때.
				return "";
				return;
			}
			if(search[1].indexOf("&")==(-1)){ //한개의 파라미터일때.
				data=search[1].split("=");
				return data[1];
			}else{							  //여러개의 파라미터 일때.
				data=search[1].split("&"); //엠퍼센트로 자름.
				for(i=0;i<=data.length-1;i++){
					l_data=data[i].split("=");
					if(l_data[0]==name){
						return l_data[1];
						break;
					}else continue;
				}
			}
		}
	</script>
	<script>
		window.onload = function(){			
			$(document).ready(function(){
				$("#logindv").css("overflow","hidden"); // 스크롤막기
				$("#joindv").css("overflow","hidden");
				
				
				window.setTimeout(function(){
					$("#logindv").dialog({
						modal: true
					});
					var state =  getParameter("state");
					if ( state == 'dupl' ){
						$("#dupl").dialog({
							modal: true
						});
					}
					else if ( state == 'fini' ){
						$("#fini").dialog({
							modal: true
						});
					}
					else if ( state == 'noid' ){
						$("#noid").dialog({
							modal: true
						});
					}
					else if ( state == 'pwfls' ){
						$("#pwfls").dialog({
							modal: true
						});
					}
				},0);
				
		
				var login = document.getElementById("login");
				var loginfrm = document.getElementById("loginfrm");
				
				login.onclick = function(){
					if( loginfrm.userId.value == '' ){
						alert('ID는 반드시 입력해야 합니다.');
						return false;					// submit막기
					}else if( loginfrm.passwd.value == '' ){
						alert('암호는 반드시 입력해야 합니다.');
						return false;
					}else{
							loginfrm.method = "POST";
							loginfrm.action = "login.do"
							loginfrm.submit();
					}
				};
				
				$("#plususeronbtn").on("click",function(){
					$("#logindv").dialog({
						modal: false
					});
					$("#joindv").dialog({
						modal: true
					});
				});
				
				var plususer = document.getElementById("plususer");
				var plususerfrm = document.getElementById("plususerfrm");
				
				plususer.onclick = function(){
				if( plususerfrm.userId.value == '' ){
					alert('ID는 반드시 입력해야 합니다');
					return false;					// submit막기
				}else if( plususerfrm.passwd.value == '' ){
					alert('암호는 반드시 입력해야 합니다');
					return false;
				}else if( plususerfrm.passwd2.value == '' ){
					alert('암호는 반드시 입력해야 합니다');
					return false;
				}else if( plususerfrm.passwd.value != plususerfrm.passwd2.value ){
					alert('암호가 다르게 입력되었습니다');
					return false;
				}else{
					plususerfrm.method = "POST";
					plususerfrm.action = "plususer.do"
					plususerfrm.submit();
				}
				};
				
			});
		}
	</script>
</head>
<body id="bodyimg">
	
	<div class="form-group" style="display:none" id="fini">
		<span>회원가입이 완료되었습니다</span>
	</div>
	<div class="form-group" style="display:none" id="noid">
		<span>입력한 아이디는 존재하지 않습니다</span>
	</div>
	<div class="form-group" style="display:none" id="pwfls">
		<span>비밀번호가 틀렸습니다</span>
	</div>
	<div class="form-group" style="display:none" id="dupl">
		<span>이미 가입된 아이디입니다</span>
	</div>
						
	<div id="logindv" title="Please Login" style="display:none">
		<form method="POST" action="login.do" id="loginfrm">	
		<div class="container">
				<br/><br/>
				<div class="row">
					<div>
						<div class="form-group">
							<input class="form-control" type="text"  size="30"
								placeholder="아이디를 입력하세요" name="userId"/>
						</div>
						<div class="form-group">
							<input class="form-control" type="password" size="30"
								placeholder="암호를 입력하세요" name="passwd"/>
						</div>
							<input type="submit" value="로그인" id="login">
							 <input type="button" value="회원가입" id="plususeronbtn"/>
					</div>
				</div>
			</div>
		</form>
	</div>
	
	
	<div id="joindv" title="Join" style="display:none">
		<form method="POST" action="plususer.do"" id="plususerfrm">	
		<div class="container">
				<br/><br/>
				<div class="row">
					<div>
						<div class="form-group">
							<input class="form-control" type="text"  size="30"
								placeholder="아이디를 입력" name="userId"/>
						</div>
						<div class="form-group">
							<input class="form-control" type="password" size="30"
								placeholder="암호를 입력" name="passwd"/>
						</div>
						<div class="form-group">
							<input class="form-control" type="password" size="30"
								placeholder="암호를 다시 입력" name="passwd2"/>
						</div>
						<div class="form-group">
							<input class="form-control" type="text" size="30"
								placeholder="닉네임을 입력" name="userName"/>
						</div>
							<input type="submit" value="입력완료" id="plususer">
					</div>
				</div>
			</div>
		</form>
	</div>
	
	
	
</body>
</html>
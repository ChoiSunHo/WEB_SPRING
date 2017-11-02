<%@ page contentType="text/html; charset=utf-8"
    pageEncoding="EUC-KR"%>
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
		window.onload = function(){
			$(document).ready(function(){
				$("#logindv").css("overflow","hidden"); // 스크롤막기
				$("#joindv").css("overflow","hidden");
				
				window.setTimeout(function(){
					$("#logindv").dialog({
						modal: true
					});
				}, 0);
				
		
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
				
				/*
				$("#login").click(function(){
					if( $("#loginfrm[name=userId]").val() == '' ){
						alert('ID는 반드시 입력해야 합니다.');
						return false;					// submit막기
					}else if( $("#loginfrm[name=passwd]").val() == '' ){
						alert('암호는 반드시 입력해야 합니다.');
						return false;
					}else{
							loginfrm.method = "POST";
							loginfrm.action = "login.do"
							loginfrm.submit();
					}
				});
				*/
				
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
		<form method="POST" action="plususer.do" id="plususerfrm">	
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

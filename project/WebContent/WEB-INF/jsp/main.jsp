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
		
		<!-- form�±׿� method="POST" action="login.do" ���� ��ưŬ����
			 �̾��ֱ⶧���� �ڵ����࿡ ��������. -->
			 
	<script>
		window.onload = function(){
			$(document).ready(function(){
				$("#logindv").css("overflow","hidden"); // ��ũ�Ѹ���
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
					alert('ID�� �ݵ�� �Է��ؾ� �մϴ�.');
					return false;					// submit����
				}else if( loginfrm.passwd.value == '' ){
					alert('��ȣ�� �ݵ�� �Է��ؾ� �մϴ�.');
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
						alert('ID�� �ݵ�� �Է��ؾ� �մϴ�.');
						return false;					// submit����
					}else if( $("#loginfrm[name=passwd]").val() == '' ){
						alert('��ȣ�� �ݵ�� �Է��ؾ� �մϴ�.');
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
					alert('ID�� �ݵ�� �Է��ؾ� �մϴ�');
					return false;					// submit����
				}else if( plususerfrm.passwd.value == '' ){
					alert('��ȣ�� �ݵ�� �Է��ؾ� �մϴ�');
					return false;
				}else if( plususerfrm.passwd2.value == '' ){
					alert('��ȣ�� �ݵ�� �Է��ؾ� �մϴ�');
					return false;
				}else if( plususerfrm.passwd.value != plususerfrm.passwd2.value ){
					alert('��ȣ�� �ٸ��� �ԷµǾ����ϴ�');
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
								placeholder="���̵� �Է��ϼ���" name="userId"/>
						</div>
						<div class="form-group">
							<input class="form-control" type="password" size="30"
								placeholder="��ȣ�� �Է��ϼ���" name="passwd"/>
						</div>
							<input type="submit" value="�α���" id="login">
							 <input type="button" value="ȸ������" id="plususeronbtn"/>
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
								placeholder="���̵� �Է�" name="userId"/>
						</div>
						<div class="form-group">
							<input class="form-control" type="password" size="30"
								placeholder="��ȣ�� �Է�" name="passwd"/>
						</div>
						<div class="form-group">
							<input class="form-control" type="password" size="30"
								placeholder="��ȣ�� �ٽ� �Է�" name="passwd2"/>
						</div>
						<div class="form-group">
							<input class="form-control" type="text" size="30"
								placeholder="�г����� �Է�" name="userName"/>
						</div>
							<input type="submit" value="�Է¿Ϸ�" id="plususer">
					</div>
				</div>
			</div>
		</form>
	</div>
	
</body>
</html>

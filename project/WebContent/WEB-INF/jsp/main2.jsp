<%@ page contentType="text/html; charset=utf-8"
    pageEncoding="EUC-KR" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="jl"%>
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
		<script>
			window.onload = function(){
				$(document).ready(function(){
					$("#date").datepicker({
						dateFormat:'yy/mm/dd',
						showAnim:'slideDown'
					});
				});
			};
		</script>
</head>
<body>
	<table>
		<tr>
			<td>
				<form method="POST" action="main2.do">
				<input  TYPE="IMAGE" src="images/googlemain.PNG" name="Submit" 
					value="Submit"  align="absmiddle">
				</form>
			</td>
			
			<td>
				<form method="POST" action="listbang.do?page=1">
				<input  TYPE="IMAGE" src="images/Download.png" name="Submit"
							value="Submit">
				</form>
			</td>
		</tr>
	</table>
        
       
	<br><br>
	
	
	<div class="container">
		<div class="row">
				<nav class="navbar navbar-inverse">
					<div class="container">
						<ul class="nav navbar-nav">
							<li><a href="#">������</a></li>
							<li><a href="#">����</a></li>
							<li><a href="listbang.do?page=1">�Խ���</a></li>
							<li><a href="#">����</a></li>
							<li><a href="#">��</a></li>
							<li><a href="#">���̵��</a></li>
							<li><a href="#">������Ʈ</a></li>
						</ul>
					</div>
				</nav>
		</div>
	</div>
	
	
	<div id="date"></div>
	
	
	<jl:forEach var="t" items="${l}">
		<table>	
			<tr>
				<td>${t.userName} �� ȯ���մϴ�!</td>
			</tr>
			<tr>
				<td>���� ����Ʈ : ${t.point}</td>
			</tr>
			<tr>
				<td >
					<a href="logout.do">�α׾ƿ�</a>
				</td>
			</tr>
			
			
		</table>
	</jl:forEach>
	
	<a href="listmovievideo.do?page=1">��ȭ</a>
	
</body>
</html>

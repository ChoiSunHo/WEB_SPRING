<%@ page contentType="text/html; charset=utf-8"
    pageEncoding="EUC-KR"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="jl" %>
<html>
<head>
	<link rel="stylesheet" href="http://code.jquery.com/ui/1.11.4/themes/trontastic/jquery-ui.min.css">
	<script src="http://code.jquery.com/jquery-1.10.2.min.js"></script>
	<script src="http://code.jquery.com/ui/1.11.4/jquery-ui.min.js"></script>
</head>
<body>
	<table>
		<tr><td>
		<form method="POST" action="main2.do">
			<input  TYPE="IMAGE" src="images/googlemain.PNG" name="Submit" 
				value="Submit"  align="absmiddle">
		</form></td>
		
		<td><form method="POST" action="addbang.do">
				<input TYPE="IMAGE" src="images/Folder.png" name="Submit" 
				value="Submit"/>
		</form></td>
		</tr>
	</table>	
		
	<table border="1" cellspacing="1">
		<tr bgColor="#cccccc" align="center">
			<td>글번호</td>
			<td>제목</td>
			<td>게시자</td>
			<td>조회수</td>
		</tr>
		<jl:forEach varStatus="vs" var="t" items="${l}">
			<tr bgColor="${vs.index % 2 != 0 ? '#aabbcc' : '#ccddee'}">
				<td>${t.no}</td>
				<td><a href="glemovievideo.do?no=${t.no}&userId=${t.userId}">${t.title}</a>[${t.clientIp}]</td>
				<td>${t.userId}</td>
				<td>${t.viewNo}</td>
			</tr>
		</jl:forEach>
		<tr>
			<td colspan="5">
				<form method="POST" action="searchmovievideo.do">
					<select name="category">
						<option value="title">제목</option>
						<option value="text">내용</option>
						<option value="id">ID</option>
						<option value="reply">댓글내용</option>
					</select>
				<input type="text" name="search"
							size="60"/>
				<input type="Submit">
				</form>
			</td>
		</tr>
		<tr>
			<a href="listmovievideo.do?page=1">1</a>
			<a href="listmovievideo.do?page=2">2</a>
			<a href="listmovievideo.do?page=3">3</a>
			<a href="listmovievideo.do?page=4">4</a>
			<a href="listmovievideo.do?page=5">5</a>
			<a href="listmovievideo.do?page=6">6</a>
			<a href="listmovievideo.do?page=7">7</a>
			<a href="listmovievideo.do?page=8">8</a>
		</tr>
	</table>
	<a href="addmovievideo.do">글쓰기</a>
</body>
</html>



<!-- 

<a href="gle.do?no=${t.no}&userId=${t.userId}">${t.text}</a>
-->
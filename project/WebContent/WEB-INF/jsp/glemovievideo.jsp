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
		
		<td>
		<form method="POST" action="listbang.do?page=1">
				<input  TYPE="IMAGE" src="images/Download.png" name="Submit"
							value="Submit">
		</form>
		</td>
		</tr>
	</table>	
		
<table border="1" cellspacing="1" WIDTH="540">
	<jl:forEach varStatus="vs" var="t" items="${l}">
		<tr bgColor="#aabbcc">
				<td align="center">${t.title}</td>
				<td align="center">${t.userId}</td>
		</tr>
		<tr bgColor="ccddee">
				<td colspan="2">글번호 ${t.no} ㅣ  ${t.theTime} 
				IP ${t.clientIp} &nbsp;&nbsp;&nbsp;&nbsp;
				조회수 ${t.viewNo} 추천수 ${t.likeNo}</td>
		</tr>
		<tr bgColor="aabbcc" rowspan="0">
				<td>내용</td>
				<td>${t.text}</td>
		</tr>
		<tr bgColor="ccddee">
				<td colspan="2">
					<a href="listmovievideo.do?page=1">목록</a> &nbsp;&nbsp;
					<a href="pluslikemovievideo.do?no=${t.no}">글추천</a> &nbsp;&nbsp;
					<a href="gleupdate1movievideo.do?no=${t.no}&userId=${t.userId}">수정</a> &nbsp;&nbsp;
					<a href="gledelmovievideo.do?no=${t.no}&userId=${t.userId}">삭제</a> &nbsp;&nbsp;
				</td>
		</tr>
</jl:forEach>
</table>

<table border="1" WIDTH="540">
	<jl:forEach varStatus="vs" var="t" items="${l2}">
			<tr>
					<td>${t.userId}</td>
					<td>${t.reply}</td>
					<td>${t.theTime} &nbsp;
						${t.clientIp}
						<a href="reupdatemovievideo.do?no=${t.no}&reno=${t.reno}&userId=${t.userId}">수정</a>
						<a href="redelmovievideo.do?no=${t.no}&reno=${t.reno}&userId=${t.userId}">삭제</a>
					</td>
			</tr>
	</jl:forEach>
</table>


<jl:forEach varStatus="vs" var="a" items="${l3}">
<form method="POST" action="plusreplymovievideo.do?no=${a.no}"
			enctype="Multipart/form-data">
</jl:forEach>
	<jl:forEach varStatus="vs" var="t" items="${l4}">
				<table border="1" WIDTH="540">
						<tr>
							<td>${t.userName}</td>
							<td><input type="text" name="reply"
								size="56"/>
							</td>
							
							<td>
								<input type="submit"/>
							</td>
						</tr>
				</table>
	</jl:forEach>
</form>
</body>
</html>



<!-- 

-->
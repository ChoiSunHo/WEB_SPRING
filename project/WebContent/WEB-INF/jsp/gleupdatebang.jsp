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

		<br>
			<font face="Monaco" size="3" color="green">
				게시글 수정사항을 입력하세요
			<br><br>
		</font>

	<table border="1">
		<jl:forEach varStatus="vs" var="t" items="${l}">
		<form method="POST" action="gleupdate2bang.do?no=${t.no}"
			enctype="Multipart/form-data">
				<tr>
					<td>제목</td>
					<td><input type="text" name="title"
						size="56"/>
					</td>
				</tr>
				<tr>
					<td>내용</td>
					<td><input type="text" name="text"
						size="56"/>
					</td>
				</tr>
				<tr>
						<td colspan="2">
						<input type="file" name="one" size="12"/>
						<input type="submit"/>
						</td>
				</tr>
				<tr>
					<td colspan="2">
						<a href="glebang.do?no=${t.no}">뒤로가기</a> &nbsp;&nbsp;
						<a href="listbang.do?page=1">목록으로</a>
					</td>
				</tr>
		</jl:forEach>
		</form>	
	</table>
</body>
</html>



<!-- 

<a href="gle.do?no=${t.no}&userId=${t.userId}">${t.text}</a>
-->
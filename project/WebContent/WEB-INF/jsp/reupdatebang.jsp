<%@ page contentType="text/html; charset=utf-8"
    pageEncoding="EUC-KR"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="jl" %>

<html>
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
				댓글 수정사항을 입력하세요
			<br><br>
		</font>
	


<table border="1">
	<jl:forEach varStatus="vs" var="a" items="${rn}">
		<form method="POST" action="reupdate2bang.do?no=${a.no}&reno=${a.reno}"
				enctype="Multipart/form-data">
	</jl:forEach>
		<jl:forEach varStatus="vs" var="t" items="${l}">
				<tr>
					<td>수정내용</td>
					<td><input type="text" name="reply"
						size="56"/>
					</td>
				</tr>
				<tr>
					<td colspan="2">
						<input type="submit"/>
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
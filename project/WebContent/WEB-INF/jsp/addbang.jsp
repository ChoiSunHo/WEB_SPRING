<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="EUC-KR"%>

<html>
<head>
	<link rel="stylesheet" href="http://code.jquery.com/ui/1.11.4/themes/trontastic/jquery-ui.min.css">
	<script src="http://code.jquery.com/jquery-1.10.2.min.js"></script>
	<script src="http://code.jquery.com/ui/1.11.4/jquery-ui.min.js"></script>
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
		<br>
		<font face="Monaco" size="3" color="green">
		내용을 입력하고 업로드할 파일을 불러오세요
		
		<br><br>
		
		</font>
	
		<form method="POST" action="add2bang.do"
			enctype="Multipart/form-data">
				<table border="1">
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
		</form>	
</table>
</body>
</html>
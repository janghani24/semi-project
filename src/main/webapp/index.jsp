<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>3�� �ε������Ʈ</title>
<link href="img/icon/home.png" rel="shortcut icon" type="image/x-icon">
<link rel="stylesheet" href="css/index.css">
<link rel="stylesheet" href="css/signup.css">
<script type="text/javascript" src="js/validCheck.js"></script>
</head>
<body>
	<div id="indexHeadDiv"></div>
	<table class="indexTbl">
	<tr id="indexTr1"> 
		<td width="700px">
			<img src="img/icon/home.png" width="70px" height="60px">
		</td>
		<td>
			<jsp:include page="${login}"></jsp:include>
		</td> 
	</tr>
	<tr id="indexTr2"> 
		<td colspan="2">
			<div id="menu1">����</div>
			<div id="menu2">Ŀ�´�Ƽ</div>
			<div id="menu3">�Ź�</div>
			<div id="menu4">�߰����� ���</div>
			<div id="menu5">���� ���ɸŹ�</div>
			<div id="menuLine"></div>
		</td> 
	</tr>
	<tr id="indexTr3"> 
		<td colspan="2">
			<jsp:include page="${contentPage}"></jsp:include>
		</td> 
	</tr>
	</table>
</body>
</html>
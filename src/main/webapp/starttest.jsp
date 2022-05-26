<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

  
    
    <!DOCTYPE html>
<html>
<head><title>ダミートップ画面</title></head>
<meta charset="UTF-8">
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/style3.css">
<body><div style="text-align: center;">
<h2>スタート画面（仮）</h2><br/>
ゲームをスタートする場合は、以下のボタンを押してください。<br/><br/>
<form action="${pageContext.request.contextPath}/QuizResult" method="get">
	<button class="start" name="start" value="start">ゲームスタート</button>
</form>
<br/>
<hr>
<a href="${pageContext.request.contextPath}/starttest.jsp">戻る</a><br>
</div></body>
</html>
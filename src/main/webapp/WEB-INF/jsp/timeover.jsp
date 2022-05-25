<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>



    
<!DOCTYPE html>
<html>
<head><title>タイムオーバー</title></head>
<meta charset="UTF-8">
<link rel="stylesheet" type="text/css" href="style4.css">
<body>

<p class="bounce-top"></p>

<a class="next"><br/>次に進む場合は、ボタンを押してください。</a>
<form action="http://localhost:8080/BPquizgame/QuizResult" method="get">
	<button class="bt" name="over" value="over">次に進む</button>
	<br/>
	<br/>
	<br/>

</form>

<br/><br/>
<a href="http://localhost:8080/BPquizgame/starttest.jsp">戻る</a><br>

</body>
<footer>


 
 <script>
 'use strict';
 
<%--ページを後戻りさせない処理--%>
history.pushState(null, null, null);
window.addEventListener('popstate', function(e) {
  history.pushState(null, null, null);
});
 </script>
 </footer>
</html>
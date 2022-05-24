<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
  
  <%
  float answertime = (float)session.getAttribute("answertime");
  int tokuten = (int)session.getAttribute("tokuten");
 %>
 
 <%
 answertime = answertime / 1000;
 %>
  
    <!DOCTYPE html>
<html>
<head><title>クイズ回答結果</title></head>
<meta charset="UTF-8">
<link rel="stylesheet" type="text/css" href="style3.css">
<body>
<div class="word" style="text-align: center;">
<h2>！！！  大正解です。得点10点を獲得しました！！！</h2>
<h3>回答にかかった時間は<%= answertime %>secです。</h3>
<h4>残り時間ボーナス：<%= tokuten %>点が加算されます！</h4><br/>
次に進む場合は、ボタンを押してください。<br/><br/>
<form action="http://localhost:8080/BPquizgame/QuizResult" method="get">
	<button class="next" name="next" value="next">次に進む</button>
</form>
<div class="stamp1" ></div>
<br/>

<br/><br/>
<a href="http://localhost:8080/BPquizgame/starttest.jsp">戻る</a><br>
</div>
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
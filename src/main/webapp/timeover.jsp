<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%
	String answer = (String)session.getAttribute("answer");
	String explanation = (String)session.getAttribute("explanation");
  	String result = (String)session.getAttribute("result");
%>

    
<!DOCTYPE html>
<html>
<head><title>タイムオーバー</title></head>
<meta charset="UTF-8">
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/style4.css">
<body>

<p class="bounce-top"></p>
<br/>
<div class="next">
<a>正解は ”<%= result %>" でした。</a><br/>
<a>【解説】　<%= explanation %></a><br/><br/>
<a>次に進む場合は、ボタンを押してください。</a><br/>
<form action="${pageContext.request.contextPath}/QuizResult" method="get">
	<button class="bt" name="over" value="over">次に進む</button>
	</div>
	<br/>
	<br/>
	<br/>

</form>

<br/><br/>
<a href="${pageContext.request.contextPath}/top">戻る</a><br>

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
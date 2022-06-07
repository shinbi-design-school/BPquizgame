<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%
	float answertime = (float)session.getAttribute("answertime");
	String answer = (String)session.getAttribute("answer");
	String explanation = (String)session.getAttribute("explanation");
  	String result = (String)session.getAttribute("result");
%>


 <%
 answertime = answertime / 1000;
 %>

    
<!DOCTYPE html>
<html>
<head><title>クイズ回答結果</title></head>
<meta charset="UTF-8">
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/style3.css">
<body style="background: url(${pageContext.request.contextPath}/css/背景2.png);">
<div id="img" class="stamp2 poyon" ></div>
<div class="word" style="text-align: center;">

<p class="judge TextTyping">・・・   残念！はずれです   ・・・</p>
<p class="judge2 TextTyping">回答にかかった時間は<%= answertime %>secです。</p>

<br/>
<p class="judge2 TextTyping">正解は ”<%= result %>" でした。</p>
<p class="judge2 TextTyping">【解説】　<%= explanation %></p>
<br/>
<br/>
<a class="next">次に進む場合は、ボタンを押してください。</a><br/>
<form action="${pageContext.request.contextPath}/QuizResult" method="get">
	<button name="next" value="next">次に進む</button>

</form>


<br/><br/><br/><br/>
<a href="${pageContext.request.contextPath}/top">戻る</a><br>
</div>
 <script src="https://code.jquery.com/jquery-3.4.1.min.js"
        integrity="sha256-CSXorXvZcTkaix6Yvo6HppcZGetbYMGWSFlBw8HfCJo=" crossorigin="anonymous"></script>
        <script src="${pageContext.request.contextPath}/js/8-10.js"></script>
</body>
<footer>
 
 <script>
 'use strict';
 
 <%--ID値「img」に対してCSSアニメ―ション「poyon」を300ミリ秒の間隔を空けてループ再生--%>
 looopAnimation("img", "poyon", 300);

 
<%--ページを後戻りさせない処理--%>
history.pushState(null, null, null);
window.addEventListener('popstate', function(e) {
  history.pushState(null, null, null);
});



 </script>
 </footer>
</html>
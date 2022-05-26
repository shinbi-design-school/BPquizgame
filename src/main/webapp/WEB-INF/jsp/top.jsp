<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<!-- トップページ -->    

<%@ page import="cc.shinbi.java.model.Const" %>
<%@ page import="cc.shinbi.java.model.entity.User" %>
<%@ page import="cc.shinbi.java.model.entity.Quiz" %>

<%
   User loginUser = (User)session.getAttribute(Const.LOGIN_USER_KEY);
   String error = (String)request.getAttribute("error");
%>

<!DOCTYPE html>
<html>
   <head>
      <jsp:include page="head.jsp" />
      <title>クイズゲーム</title>
   </head>
   
    <body>
      <jsp:include page="header.jsp" />
      <main>
      	<div style="text-align: center;">
         トップページ<br/><br/>
         ゲームをスタートする場合は、以下のボタンを押してください。<br/>
		<form action="${pageContext.request.contextPath}/QuizResult" method="get">
		<button class="start" name="start" value="start">ゲームスタート</button>
		</form>
		</div>

         
      </main>
      <jsp:include page="footer.jsp" />
   </body>
</html>
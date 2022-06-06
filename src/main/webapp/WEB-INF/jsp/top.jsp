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
         クイズカテゴリーを選択してください。<br/>
		<form action="${pageContext.request.contextPath}/QuizResult" method="GET" >
  		<select name="genre">
    		<option value="ジャンル１" selected>ジャンル１</option>
    		<option value="ジャンル２">ジャンル２</option>
    		<option value="ジャンル３">ジャンル３</option>
    		<option value="ジャンル４">ジャンル４</option>
    		<option value="ガンダム">ガンダム</option>
  		</select>
  		<br/><br/>
		 クイズゲームをスタートする場合は、以下のボタンを押してください。<br/>
  		<input type="submit" value="ゲームスタート">
  		<input id="start" type="hidden" name="start" value="start">
		</form>
		</div>

         
      </main>
      <jsp:include page="footer.jsp" />
   </body>
</html>
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
      
      <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/top.css">
      
   </head>
   
    <body>
      <jsp:include page="header.jsp" />
      <main>
      	<div style="text-align: center;">
         トップページ<br/><br/>
         クイズカテゴリーを選択してください。<br/>
		<form action="${pageContext.request.contextPath}/QuizResult" method="GET" >
  		<select name="genre">
    		<option value="ワイン" selected>ワイン</option>
    		<option value="酒">酒</option>
    		<option value="世界史">世界史</option>
    		<option value="地理">地理</option>
    		<option value="ＩＴ関連">ＩＴ関連</option>
    		<option value="ガンダム">ガンダム</option>
    		<option value="健康">健康</option>
  		</select>
  		<br/><br/>
		 クイズゲームをスタートする場合は、以下のボタンを押してください。<br/>
  		<input type="submit" value="ゲームスタート">
  		<input id="start" type="hidden" name="start" value="start">
		</form>
		</div>


         <div class="flex">

  <div class="box flipRight">
  <p>このクイズゲームについて</p>
		<p>〇クイズに正解すると10点を獲得! 不正解なら0点となります。</p>
		<p>〇問題には制限時間があります。10秒以内に解答してください。</p>
		<p>〇正解後の制限時間／残り時間により、ボーナス得点が加算されます。</p>
		<p>〇出題数は５問、四択問題です。</p>
		<p>〇正答と思うものを、四択画面からｸﾘｯｸして解答してください。</p>
		<p>〇お好きなクイズの【ジャンル】を、選択してください。</p>
		<p>〇スタートボタンをクリックすると、クイズがスタートします。</p>
		<p>〇スタート画面が表示された時点で、カウントダウンが始まります。</p>
  </div>

</div>
         
         
      </main>
      <jsp:include page="footer.jsp" />
   </body>
</html>
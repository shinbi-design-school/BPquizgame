<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%
	int tokutentotal = (int) session.getAttribute("tokutentotal"); 
	int count = (int) session.getAttribute("count"); 
%>

<%
	int rank = (int) request.getAttribute("rank"); 
%>
  
<%
	int totalresult = count*10 + tokutentotal;
%>
 
<!DOCTYPE html>
<html lang="ja">
<head>
<meta charset="utf-8">
<title>結果画面</title>

<link rel="stylesheet" href="last body.css">

<meta name="viewport" content="width=device-width,initial-scale=1.0">
<!--==============レイアウトを制御する独自のCSSを読み込み===============-->
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/last 1.css">
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/last slowly.css">
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/last 3.css">
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/last 5-8.css">
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/last reset.css">
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/last delya.css">

</head>

<body>
  
  <h1 style="text-align:center"></h1>
  
    <div id="particles-js"></div>
    <div id="wrapper">
  <p><span class="blurTrigger"><img src="${pageContext.request.contextPath}/css/大変よくできました.png" width="300" height="300"> <br/> 
 
  
  </span>
  </p>

<div class="text-align:center">
  <div class="box fadeUp">正解得点合計<%= count*10 %>点</div>
  <div class="delay-time01 box fadeUp">残り時間ボーナス<%= tokutentotal %>点</div>
  <div class="delay-time02 box fadeUp">総合得点<%= totalresult %>点</div>
  <div class="delay-time03 box fadeUp">あなたのランキングは<%= rank %>位</div>
  <button type="button" onclick=location.href="${pageContext.request.contextPath}/top">トップページへ戻る</button>
</div>

<!--/wrapper--></div>
<script src="https://code.jquery.com/jquery-3.4.1.min.js" integrity="sha256-CSXorXvZcTkaix6Yvo6HppcZGetbYMGWSFlBw8HfCJo="  crossorigin="anonymous"></script>
<script src="http://coco-factory.jp/ugokuweb/wp-content/themes/ugokuweb/data/move02/8-9/js/8-9.js"></script>
<script src="https://cdn.jsdelivr.net/particles.js/2.0.0/particles.min.js"></script>
  <script src="http://coco-factory.jp/ugokuweb/wp-content/themes/ugokuweb/data/move02/5-8/js/5-8.js"></script>


</body>
</html>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
    <%
    int i = (int)session.getAttribute("i");
    %>
    
    <%
    
    String str[][] = {
    		{"問題1 大島さんが好きな季節は？",
				"1.春","2.夏","3.秋","4.冬","2"
			},
			{"問題2 砂岡さんが好きな色は？",
				"1.白","2.赤","3.黒","4.青","3"
			},
			{"問題3 坪井さんが好きな動物は？",
				"1.犬","2.猫","3.馬","4.羊","1"
			},
			{"問題4 小田さんが好きな地域は？",
				"1.春","2.夏","3.秋","4.冬","4"
			},
			{"問題5 田中先生が好きな季節は？",
				"1.春","2.夏","3.秋","4.冬","2"
			}}; 
    
    
    String question = (str[i][0]);
    String answer1 = (str[i][1]);
    String answer2 = (str[i][2]);
    String answer3 = (str[i][3]); 
    String answer4 = (str[i][4]); 
    String correct= (str[i][5]); 
    
%>
      

 
  
 <% 
 String str2 = str[i][5];
 int in1 = Integer.parseInt(str2);
 %>
  
   
    
    
<!DOCTYPE html><html>
	
	<head>
        <title>クイズ出題画面サンプル</title>

    </head>

	<meta charset="UTF-8">
	<meta http-equiv="refresh" content="11.5; url=${pageContext.request.contextPath}/timeover.jsp" />
	<input id="Question1" type="hidden" name="Q1" value="Q1"> 
	<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/style3.css">
	
	<body>
	  
        <header class="header">
        <div class="ribbon20-wrapper delay-time04 box fadeUp">
  			<h3 class="ribbon20">Question!!!</h3>
  					<h2><%= question %></h2>
         	   </div>
        </header>

        
   <form action="${pageContext.request.contextPath}/QuizQuestion1" method="GET">
	<input id="Question1" type="hidden" name="Q1" value="Q1"> 
	
	
<div class="container">
	<button class="box fadeUp btn btn-flatw" name="1" value="1"><%= answer1 %></button>
    <button class="delay-time03 box fadeUp btn btn-flat" name="2" value="2"><%= answer2 %></button>
    <audio id="sound" preload="auto">
    <source src="nc97718.mp3" type="audio/mp3">
    </audio>

</div>
<div class="container">
    <button class="delay-time02 box fadeUp btn btn-flat" name="3" value="3"><%= answer3 %></button>
    <button class="delay-time04 box fadeUp btn btn-flat" name="4" value="4"><%= answer4 %></button>
</div>  	
    </form>
<section>
    <div class=timer style="text-align: center;">
    <p class="timer">あと<span id="timer">10</span>秒</p>
</div>
</section>

<br/><br/>
<a href="${pageContext.request.contextPath}/starttest.jsp">戻る</a><br>
</body>

<footer>



<audio id="sound" preload="auto">
    <source src="http://idotdesign.net/wp-content/themes/idotdesign/sound/sound.wav" type="audio/wav">
     </audio>


    <div class="bomb black"><%--爆弾の設定 --%>
  <span class="ledge"></span>
  <div class="fuse"></div>
  <div class="dust">
    <span></span>
    <span></span>
    <span></span>
    <span></span>
    <span></span>
    <span></span>
    <span></span>
    <span></span>
    <span></span>
    <span></span>
    <span></span>
    <span></span>
    <p class="msg orange">Time Over!!!</p>
  </div>
</div>

  
 <script>
 'use strict';
 
 
 <%--ページを後戻りさせない処理--%>
 history.pushState(null, null, null);
 window.addEventListener('popstate', function(e) {
   history.pushState(null, null, null);
 });

 

 <%--カウントダウンタイマー--%>
 let count = 11;<%--実際の表示に合わせて、スタート位置を決めている--%>
 const countUp = () => {
   console.log(count--);<%--カウントダウンなので、"--"を記入。カウントアップの時は"++"を記入--%>
   document.querySelector('#timer').textContent=count;<%--結果を表示させるための記述--%>
   const timeoutId = setTimeout(countUp, 1000);<%--カウントを表示させるための記述。カウントダウン設定だが、カウントをUP(表示)する意味で"countUp"を記載--%>
   if(count <= 0){　
     clearTimeout(timeoutId);<%--timeoutIdをclearTimeoutで指定している--%>
   }
 }
 countUp();
</script>

  
</footer>

 </html>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<!-- ログインページ -->

<%
    String error = (String)request.getAttribute("error");
%>
    
<!DOCTYPE html>
<html>

 <!-- 背景画像アニメ用 -->
      <div id="container">
        <div id="c-container">
            <canvas id="c">Sorry.</canvas>
        </div>
        <div id="c2-container">
            <canvas id="c2">Sorry.</canvas>
        </div>
    </div>
           
   <head>
      <jsp:include page="head.jsp" />
      <title>ログイン</title>
   </head>
   <body>
      <jsp:include page="header.jsp" />
      

      
      
      <main>
      <div class="login">
          <form method="post" action="login">
              <table id="login">
                  <tr>
                      <th>アカウント名</th>
                      <td><input type="text" name="account"></td>
                  </tr>
                  <tr>
                      <th>パスワード</th>
                      <td><input type="password" name="password"></td>
                  </tr>
                  </table>
                      
                          <br/>
                          <input id="submit" type="submit" value="ログイン">
                      
          </form>
          <br/>
          <form method="post" action="newuser">
             <input id="newbtn" type="submit" value="新規登録">
          </form>
          
<%
    if(error != null) {
%>
            <br/><div id="error"><%= error %></div>
<%
    }
%>
</div>




<!-- 背景画像アニメ用JS -->
<script src='https://cdnjs.cloudflare.com/ajax/libs/gsap/1.19.0/TimelineMax.min.js'></script>
<script src='https://cdnjs.cloudflare.com/ajax/libs/gsap/1.19.0/TweenMax.min.js'></script>
<script src='https://code.jquery.com/jquery-2.2.4.js'></script>
<script src='https://npmcdn.com/babel-core@5.8.38/browser.min.js'></script>
<script src='https://cdnjs.cloudflare.com/ajax/libs/jquery.imagesloaded/4.1.1/imagesloaded.pkgd.min.js'></script>
<script src="${pageContext.request.contextPath}/js/script-bg.js"></script>

      </main>
      <jsp:include page="footer.jsp" />
   </body>
</html>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!-- ユーザー新規登録ページ -->
    
<%@ page import="cc.shinbi.java.model.entity.User" %>
<%
   String error = (String)request.getAttribute("error");
%>

<!DOCTYPE html>
<html>
   <head>
       <meta charset="UTF-8">
       <link rel="stylesheet" type="text/css" 
       href="${pageContext.request.contextPath}/css/style.css">
      <title>新規登録</title>
   </head>
   <body>
      <jsp:include page="header.jsp" />
      
      <main>
         <form method="post" action="newuser">
            <table id="user_table">
               <tr>
                  <th>アカウント名</th>
                  <td><input type="text" name="account" ></td>
               </tr>
               <tr>
                  <th>名前</th>
                  <td><input type="text" name="name" ></td>
               </tr>
               <tr>
                  <th>パスワード</th>
                  <td><input type="password" name="password"></td>
               </tr>
               <tr>
                  <th>パスワード(確認)</th>
                  <td><input type="password" name="confirmed"></td>
               </tr>
               <tr>
                  <td>
                     <input id="submit" type="submit">
                  </td>
               </tr>
            </table>
            <input type="hidden" name="is_admin" value="false">
            <input type="hidden" name="operation" value="add">
         </form>
<%
   if(error != null) {
%>
         <div id="error"><%= error %></div>
<%
   }
%>
      </main>
      <jsp:include page="footer.jsp" />
   </body>
</html>
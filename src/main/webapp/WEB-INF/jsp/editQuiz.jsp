<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!-- メッセージ編集ページ -->
    
<%@ page import="cc.shinbi.java.model.entity.User" %>
<%@ page import="cc.shinbi.java.model.entity.Quiz" %>
<%@ page import="cc.shinbi.java.model.Const" %>

<%
   Quiz quiz = (Quiz)request.getAttribute("quiz");
   User loginUser = (User)session.getAttribute(Const.LOGIN_USER_KEY);
   String error = (String)request.getAttribute("error");
   //選択したquizオブジェクトの情報をgetで取得
   int id = quiz.getId();
   String question = quiz.getQuestion();
   String choices1 = quiz.getChoices1();
   String choices2 = quiz.getChoices2();
   String choices3 = quiz.getChoices3();
   String choices4 = quiz.getChoices4();
   String answer = quiz.getAnswer();
   String explanation = quiz.getExplanation();
   String genre = quiz.getGenre();
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
         <form method="post" action="postquiz">
         <!-- 変数にはgetで取得した値が入る -->
         <input type="hidden" id="quiz_id_input" name="id" value="<%= id %>">
         <input type="hidden"  name="operation" value="update">
            <table id="postquiz">
                <tr>
                    <th>クイズ内容</th>
                    <td><input type="text" name="question" value="<%= question %>" ></td>
                </tr>
                <tr>
                    <th>選択肢1</th>
                    <td><input type="text" name="choices1" value="<%= choices1 %>"></td>
                </tr>
                <tr>
                    <th>選択肢2</th>
                    <td><input type="text" name="choices2" value="<%= choices2 %>"></td>
                </tr>
                <tr>
                    <th>選択肢3</th>
                    <td><input type="text" name="choices3" value="<%= choices3 %>"></td>
                </tr>
                <tr>
                    <th>選択肢4</th>
                    <td><input type="text" name="choices4" value="<%= choices4 %>"></td>
                </tr>
                <tr>
                    <th>答え</th>
                    <td><input type="text" name="answer" value="<%= answer %>"></td>
                </tr>
                <tr>
                    <th>説明</th>
                    <td><input type="text" name="explanation" value="<%= explanation %>"></td>
                </tr>
                <tr>
                    <th>クイズジャンル</th>
                    <td><input type="text" name="genre" value="<%= genre %>"></td>
                </tr>

                <tr>
                    <td>
                        <input id="submit" type="submit" value="クイズを更新">
                    </td>
                </tr>
            </table>
        </form>
      </main>
      <jsp:include page="footer.jsp" />
   </body>
</html>
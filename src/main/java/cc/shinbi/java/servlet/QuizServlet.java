package cc.shinbi.java.servlet;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cc.shinbi.java.model.dao.QuizDAO;
import cc.shinbi.java.model.entity.Quiz;
import cc.shinbi.java.model.entity.User;



//quizに関するクラス
@WebServlet("/postquiz")
public class QuizServlet extends JspServlet{
	
	//ログイン認証
	public QuizServlet() {
		super(true);
	}
	
	@Override
	protected String view(
			HttpServletRequest request,
			HttpServletResponse response,
			Connection connection,
			User loginUser
		) throws Exception {
		QuizDAO dao = new QuizDAO(connection);
		
		//operationに入る値で処理が変わる
     	String operation = request.getParameter("operation");
		
		String jsp = null;
		
		if(operation != null) {
		//quizs.jspで追加ボタンを押したときの処理
		if(operation.equals("new")) {
			jsp = "/WEB-INF/jsp/postQuiz.jsp";
		}
		//postQuiz.jspで登録を押したときの処理
		else if(operation.equals("add")) {
			jsp = this.addQuiz(request, loginUser, dao);
		}
        //quizs.jspで編集ボタンを押したときの処理
		else if(operation.equals("edit")) {
			jsp = this.editQuiz(request, loginUser, dao);
		}
		//quizs.jspで削除ボタンを押したときの処理
		else if(operation.equals("delete")) {
			jsp = this.deleteQuiz(request, loginUser, dao);
		}
		}
		
		if(jsp == null) {
			jsp = getList(request, loginUser, dao);
		}
		return jsp;
	}

	
	//ユーザー一覧を取得し、表示するぺージに移動する処理
		private String getList(HttpServletRequest request, User user, QuizDAO dao)
		         throws Exception {
			String jsp = null;
			
//			if(user.isAdmin()) {
				List<Quiz> quizs = dao.findAll();
				request.setAttribute("quizs", quizs);
				
				jsp = "/WEB-INF/jsp/quizs.jsp";
//			}
			//管理者じゃない場合エラー
//			else {
//				String error = "権限がありません。";
//				request.setAttribute("error", error);
//				jsp = "/WEB-INF/jsp/error.jsp";
//			}
			
			return jsp;
		}
   
	//quizの編集ページに移動する処理
	private String editQuiz(HttpServletRequest request, User user, QuizDAO dao)
	        throws Exception {
		String id = request.getParameter("id");
		Quiz quiz = dao.findById(Integer.parseInt(id));
		
		String error = null;
		if(quiz.getId() != user.getId()) {
			error = "編集の権限がありません。";
		}
		
		String jsp = null;
		if(error == null) {
			request.setAttribute("quiz", quiz);
			jsp = "/WEB-INF/jsp/postQuiz.jsp";
		}
		else {
			request.setAttribute("error", error);
	
			jsp = "WEB-INF/jsp/top.jsp";
		}
		
		return jsp;
	}
	
	//quizの削除に関する処理
	private String deleteQuiz(HttpServletRequest request, User user, QuizDAO dao)
	        throws Exception {
		String id = request.getParameter("id");
		Quiz quiz = dao.findById(Integer.parseInt(id));
		
		if(quiz.getId() == user.getId() || user.isAdmin()) {
			dao.delete(quiz.getId());
		}
		else {
			String error = "削除する権限がありません。";
			request.setAttribute("error", error);
		}
		
		String jsp = "/WEB-INF/jsp/postQuiz.jsp";
		return jsp;
	}



    //クイズを新規登録する処理
    private String addQuiz(HttpServletRequest request, User user, QuizDAO dao) 
    		throws SQLException{
  
        String jsp = null;
        String error = "";
    
        //formから入力された値を取得
        String question = request.getParameter("question");
        String choices1 = request.getParameter("choices1");
        String choices2 = request.getParameter("choices2");
        String choices3 = request.getParameter("choices3");
        String choices4 = request.getParameter("choices4");
        String answer = request.getParameter("answer");
        String explanation = request.getParameter("explanation");
        String genre = request.getParameter("genre");
   
        //入力された値がnullか空ならエラー
        if(question == null || question.isEmpty()) {
			error = "質問内容を入力してください。";
		}
   
        if(choices1 == null || choices1.isEmpty()) {
			error = "選択肢を入力してください。";
		}
   
        if(choices2 == null || choices2.isEmpty()) {
			error = "選択肢を入力してください。";
		}
   
        if(choices3 == null || choices3.isEmpty()) {
			error = "選択肢を入力してください。";
		}		
   
        if(choices4 == null || choices4.isEmpty()) {
			error = "選択肢を入力してください。";
		}
   
        if(answer == null || answer.isEmpty()) {
			error = "答えを入力してください。";
		}
   
        if(explanation == null || explanation.isEmpty()) {
			error = "説明を入力してください。";
		}
   
        if(genre == null || genre.isEmpty()) {
     		error = "ジャンルを入力してください。";
		}
   
        //エラーじゃなかったらuserDAOのaddQuizメソッド（SQL実行）を呼び出してクイズ一覧ぺージに戻る
	    if(error.isEmpty()) {
           	dao.addQuiz(question, choices1, choices2, choices3, choices4, 
           			answer, explanation, genre);
           	jsp = "WEB-INF/jsp/quizs.jsp";
      	}
	    //エラー表示
	    else {
	        request.setAttribute("error", error);
		    jsp = "WEB-INF/jsp/error.jsp";
	    }
   
        return jsp;
    }  
    /*
  //既存quizの編集処理
  	private String updateQuiz(HttpServletRequest request, User user, QuizDAO dao) 
  	         throws Exception {
  		String jsp = null;
  		
  		if(user.isAdmin()) {
  			String error = "";
  			
  			//対象のIDを取得
  			int id = Integer.parseInt(request.getParameter("id"));
  			
  			String account = request.getParameter("account");
  			if(account == null || account.isEmpty()) {
  				error = "アカウント名を入力してください。";
  			}
  			else {
  				User user = dao.findByAccount(account);
  				if(user != null && user.getId() != id) {
  					error = "そのアカウントは既に使われています。";
  				}
  			}
  			
  			String name = request.getParameter("name");
  			if(name == null || name.isEmpty()) {
  				error += "名前を入力してください。";
  			}
  			
  			String isAdmin = request.getParameter("is_admin");
  			
  			String password = request.getParameter("password");
  			String confirmed = request.getParameter("confirmed");
  			if(!password.equals(confirmed)) {
  				error = "パスワードが一致しません。";
  			}
  			
  			if(error.isEmpty()) {
  				dao.updateQuiz(question, choices1, choices2, choices3, choices4, 
  	           			answer, explanation, genre);
  				jsp = this.getList(request, user, dao);
  			}
  			else {
  				request.setAttribute("error", error);
  				jsp = "/WEB-INF/jsp/quizs.jsp";
  			}
  		}
  		//管理者じゃない場合エラー
  		else {
  			String error = "権限がありません。";
  			request.setAttribute("error", error);
  			jsp = "/WEB-INF/jsp/error.jsp";
  		}
  		
  		return jsp;
  	}
  	*/
  	
}

package cc.shinbi.java.servlet;

import java.sql.Connection;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cc.shinbi.java.model.entity.User;



@WebServlet("/top")
public class TopServlet extends JspServlet {
	
	//ログインチェック ログインしてなかったらログイン画面に移動
	public TopServlet() {
		super(true);
	}

	//top.jspに移動する処理
	@Override
	protected String view(
			HttpServletRequest request, 
			HttpServletResponse response, 
			Connection connection,
			User loginUser
			) throws Exception {
		
		String jsp = "/WEB-INF/jsp/top.jsp";
		return jsp;
	}
}
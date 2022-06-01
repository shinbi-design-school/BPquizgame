package cc.shinbi.java.servlet;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import cc.shinbi.java.model.dao.PointDAO;
import cc.shinbi.java.model.entity.Point;
import cc.shinbi.java.model.entity.User;

@WebServlet("/point")
public class PointServlet extends JspServlet{

	//ログインチェック
	public PointServlet() {
		super(true);
	}

	
	@Override
	protected String view(
			HttpServletRequest request, 
			HttpServletResponse response,
			Connection connection,
			User loginUser) throws Exception {
		String operation = request.getParameter("operation");
		String jsp = null;
		
		PointDAO dao = new PointDAO(connection);
		
		if(operation != null) {
			//operationに値を入れた状態でリザルト画面に移動する
			//operetionに値が入っていたらデータベースに得点を登録して、
			//順位が入っているresalut.jspを表示する
			jsp = this.addPoint(request, dao, loginUser);
		}
		
		if(operation == null) {
			jsp = this.pointRanking(request, dao, loginUser);
		}
		return jsp;
	}
	
	
	//データベースに登録するメソッドを呼び出す セッションからデータを取る
	private String addPoint(HttpServletRequest request, PointDAO dao, User loginUser) throws SQLException {
		String jsp = null;
     //   String error = "";
	 	 HttpSession session = request.getSession();
        //formから入力された値を取得 ここにnameを追加
		int user_id = (int) request.getAttribute("user_id");
		String name = (String) session.getAttribute("name");
        int score = (int) session.getAttribute("tokutentotal");
                                               //tokutentotal？
        
        dao.addPoint(user_id, name, score);
        
        jsp = this.newPoint(request, dao, loginUser);
        
   //     jsp = "/WEB-INF/jsp/ranking.jsp";
   		
		return jsp;
	}

	
	//登録したレコード順位を取得するメソッドを呼び出す
	private String newPoint(HttpServletRequest request, PointDAO dao, User loginUser) throws SQLException {
		String jsp = null;
	//	int rank = 0;

		//一番新しいレコードの取得
		Point point = dao.findNew();
		//一番新しいレコードからスコアを取り出し、PointDAOの順位を取得するメソッドを呼び出す
		int rank = dao.myRank(point.getScore());
		//rankに順位をセット
   		request.setAttribute("rank", rank);
		

		
		jsp = "/WEB-INF/jsp/ranking.jsp";
		return jsp;
		
	}

	
	
	
	//ランキングを取得する
	private String pointRanking(HttpServletRequest request, PointDAO dao, User loginUser) throws SQLException {
		String jsp = null;
		List<Point> points = dao.findRanking();
		request.setAttribute("points", points);
		
		jsp = "/WEB-INF/jsp/ranking.jsp";
		
		
		return jsp;
	}

}

package cc.shinbi.java.model.test;

import java.security.NoSuchAlgorithmException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.junit.jupiter.api.Test;

import cc.shinbi.java.model.dao.GenreDAO;
import cc.shinbi.java.model.entity.Quiz;
import cc.shinbi.java.util.DbUtil;

class pointtest {

	@Test
	void genre(HttpServletRequest request) 
	        throws NoSuchAlgorithmException, SQLException, ClassNotFoundException {
		Connection connection = DbUtil.connect();
		GenreDAO dao = new GenreDAO(connection);
		
		List<Quiz> list = new ArrayList<Quiz>();
		
		list = dao.searchGenre();
		
		System.out.println(list);
		
	    

		
		
		
		
		
	//	Point point = new Point();
//	point = dao.addPoint(2, "suna", 5);
	//	System.out.print(point);

}
}
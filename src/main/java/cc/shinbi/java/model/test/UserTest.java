package cc.shinbi.java.model.test;

import java.security.NoSuchAlgorithmException;
import java.sql.Connection;
import java.sql.SQLException;

import org.junit.jupiter.api.Test;

import cc.shinbi.java.model.Const;
import cc.shinbi.java.model.dao.UserDAO;
import cc.shinbi.java.model.entity.User;
import cc.shinbi.java.util.DbUtil;



//ユーザー管理のテスト
class UserTest {

	@Test
	void testDefaultUser() 
	        throws NoSuchAlgorithmException, SQLException, ClassNotFoundException {
		Connection connection = DbUtil.connect();
		UserDAO dao = new UserDAO(connection);
		
		String account = Const.DEFAULT_USER_ACCOUNT;
		String[] passwords = {Const.DEFAULT_USER_PASSWORD, "Wrong Password"};
		
		for(String password : passwords) {
			User user = dao.login(account, password);
			if(user == null) {
				System.out.println("ログイン失敗");
			}
			else {
				System.out.println("ログイン成功");
				System.out.println(
						String.format(
							"Account: %s, Name: %s",
							user.getAccount(),
							user.getName()
							)
						);
			}
		}
		connection.close();
	}
}
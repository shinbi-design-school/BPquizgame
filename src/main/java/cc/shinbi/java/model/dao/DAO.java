package cc.shinbi.java.model.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


//データアクセスオブジェクトに関するクラス
public abstract class DAO<T> {
	protected String tableName;
	protected Connection connection;
	
	public DAO(String tableName, Connection connection) {
		this.tableName = tableName;
		this.connection = connection;
	}
	
  //レコードの数を取得する処理
	public int count() throws SQLException {
		String sql = String.format(
			"SELECT COUNT(*) AS count FROM %s",
			this.tableName
			);
		
		Statement statement = this.connection.createStatement();
		ResultSet resultSet = statement.executeQuery(sql);
		
		int count = 0;
		if(resultSet.next()) {
			count = resultSet.getInt("count");
		}
		
		resultSet.close();
		statement.close();
		
		return count;
	}
	
	//サブクラスで中身を書く抽象メソッド
	protected abstract T createEntity(ResultSet resultSet) throws SQLException;
	

	//一番新しいレコードを取得する処理
	public T findNew() throws SQLException {
		T entity = null;
		
		String sql = String.format(
			"SELECT * FROM %s ORDER BY id DESC LIMIT 1",
			this.tableName
			);
		
		Statement statement = this.connection.createStatement();
		ResultSet resultSet = statement.executeQuery(sql);
		
		if(resultSet.next()) {
			entity = this.createEntity(resultSet);
		}
		
		resultSet.close();
		statement.close();
		
		return entity;
	}
}
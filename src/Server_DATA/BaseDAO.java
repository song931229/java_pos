package Server_DATA;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class BaseDAO {
	protected Connection con;
	protected PreparedStatement ps;
	protected ResultSet rs;
	
	protected String url;
	protected String user;
	protected String pass;
	
	public BaseDAO() {
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
		}catch(ClassNotFoundException e) {
			System.err.println("오라클 드라이버 검색 실패!!");
		}
		url = "jdbc:oracle:thin:@localhost:1521:xe";
		user = "bigdata";
		pass = "a1234";
	}
}

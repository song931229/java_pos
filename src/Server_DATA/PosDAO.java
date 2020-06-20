package Server_DATA;

import java.sql.*;
import java.util.Arrays;

public class PosDAO {
	private Connection con;
	private PreparedStatement ps;
	private ResultSet rs;
	
	private String url, user, pass;
	
	public PosDAO() {
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
		}catch(ClassNotFoundException e) {
			System.err.println("오라클 드라이버 검색 실패!!");
		}
		url = "jdbc:oracle:thin:@localhost:1521:xe";
		user = "bigdata";
		pass = "a1234";
	}
	
	public void check_admin() throws SQLException {
		String sql = "select id from seller";
		try {
			
			con = DriverManager.getConnection(url, user, pass);
			ps = con.prepareStatement(sql);
			rs = ps.executeQuery();
			
			if (rs==null) {
				
			}
			System.out.println("admin check");
		}finally {
			if (rs != null) rs.close();
			if (ps != null) ps.close();
			if (con != null) con.close();
		}
	}
	
	public int create_admin() throws SQLException {
		String sql = "insert into seller values(?,?,?,?,?,?)";
		try {
			
			con = DriverManager.getConnection(url, user, pass);
			ps = con.prepareStatement(sql);
//			ps.setStirng(1,);
			
			return ps.executeUpdate();

		}finally {
			if (rs != null) rs.close();
			if (ps != null) ps.close();
			if (con != null) con.close();
		}
	}
}

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
		String sql = "select id from seller where id=?";
		try {
			
			con = DriverManager.getConnection(url, user, pass);
			ps = con.prepareStatement(sql);
			ps.setString(1,"admin");
			rs = ps.executeQuery();
			if (!rs.next()) {
				System.out.println("admin 생성필요");
				this.create_admin();
			}else {
				System.out.println("admin 이미존재");
			}
			System.out.println("admin check");
		}finally {
			if (rs != null) rs.close();
			if (ps != null) ps.close();
			if (con != null) con.close();
		}
	}
	
	public int create_admin() throws SQLException {
		String sql = "insert into seller values(seq_seller.nextval,?,?,?,?,?,?,?,?,?)";
		try {
			
			con = DriverManager.getConnection(url, user, pass);
			ps = con.prepareStatement(sql);
			ps.setString(1,"admin");
			ps.setString(2,"999-9999-9999");
			ps.setString(3,"999999");
			ps.setString(4,"admin");
			ps.setString(5,"123");
			ps.setInt(6,0);
			ps.setInt(7,0);
			ps.setInt(8,6);
			ps.setString(9,"joindate");
			
			return ps.executeUpdate();

		}finally {
			if (ps != null) ps.close();
			if (con != null) con.close();
			System.out.println("admin 생성완료");
		}
	}
}

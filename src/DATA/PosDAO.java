package DATA;

import java.sql.*;

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
	
	public boolean check() throws SQLException {
		String sql = "select * from tab";
		try {
			
			con = DriverManager.getConnection(url, user, pass);
			ps = con.prepareStatement(sql);
			rs = ps.executeQuery();
			
			if (rs==null) {
				return false;
			}else {
				while(rs.next()) {
					rs.next();
				}
			}
			return false;
		}finally {
			if (rs != null) rs.close();
			if (ps != null) ps.close();
			if (con != null) con.close();
		}
	}
}

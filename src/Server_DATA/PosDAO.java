package Server_DATA;

import java.sql.*;
import java.util.Arrays;

public class PosDAO extends BaseDAO{
	
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
		String sql = "insert into seller values(seq_seller.nextval,?,?,?,?,?,0,0,?,?)";
		SellerDTO admin= new SellerDTO("admin","999-9999-9999","999999","admin","123");
		admin.setLv(6);
		try {
			con = DriverManager.getConnection(url, user, pass);
			ps = con.prepareStatement(sql);
			ps.setString(1,admin.getName());
			ps.setString(2,admin.getTel());
			ps.setString(3,admin.getBirth());
			ps.setString(4,admin.getId());
			ps.setString(5,admin.getPw());
			ps.setInt(6,admin.getLv());
			ps.setString(7,admin.getJoindate());
			
			return ps.executeUpdate();

		}finally {
			if (ps != null) ps.close();
			if (con != null) con.close();
			System.out.println("admin 생성완료");
		}
	}
}

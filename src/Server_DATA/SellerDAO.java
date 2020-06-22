package Server_DATA;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class SellerDAO extends BaseDAO {
	
	public int isCollect(String typed_id, String typed_pw) throws SQLException {
		// 1 비번일치 0 비번불일치 -1 매치아이디없음.
		String sql = "select id,pw from seller where id=?";
		try {
			
			con = DriverManager.getConnection(url, user, pass);
			ps = con.prepareStatement(sql);
			ps.setString(1,typed_id);
			rs = ps.executeQuery();
			if(rs.next()) {
				String getpw=rs.getString("pw");
				if (typed_pw.equals(getpw)) {
					return 1;
				}else {
					return 0;
				}
			}else {
				return -1;
			}
		}finally {
			if (rs != null) rs.close();
			if (ps != null) ps.close();
			if (con != null) con.close();
		}
	}

	public SellerDTO getSeller(String typed_id) throws SQLException {
		// 로그인 후 ID값에 맞는 Seller객체 반환
		String sql = "select * from seller where id=?";
		try {
			con = DriverManager.getConnection(url, user, pass);
			ps = con.prepareStatement(sql);
			ps.setString(1,typed_id);
			rs = ps.executeQuery();
			SellerDTO sellerDTO=new SellerDTO();
			if(rs.next()) {
				String name=rs.getString("name");
				int c_cash=rs.getInt("c_cash");
				int n_cash=rs.getInt("n_cash");
				int lv=rs.getInt("lv");
				sellerDTO.setLv(lv);
				sellerDTO.setC_cash(c_cash);
				sellerDTO.setN_cash(n_cash);
				sellerDTO.setName(name);
			}
			return sellerDTO;
		}finally {
			if (rs != null) rs.close();
			if (ps != null) ps.close();
			if (con != null) con.close();
		}
	}
	
	public String Find_Id(String typed_name, String typed_tel, String typed_birth) throws SQLException {
		String sql = "select id from seller where name=? and tel=? and birth=?";
		try {
			con = DriverManager.getConnection(url, user, pass);
			ps = con.prepareStatement(sql);
			ps.setString(1,typed_name);
			ps.setString(2,typed_tel);
			ps.setString(3,typed_birth);
			rs = ps.executeQuery();
			if(rs.next()) {
				String found_id=rs.getString("id");
				return found_id;
			}
			return null;
		}finally {
			if (rs != null) rs.close();
			if (ps != null) ps.close();
			if (con != null) con.close();
		}
	}

	public boolean Find_Pw(String typed_name, String typed_tel, String typed_birth, String typed_id) throws SQLException {
		String sql = "select * from seller where name=? and tel=? and birth=? and id=?";
		try {
			con = DriverManager.getConnection(url, user, pass);
			ps = con.prepareStatement(sql);
			ps.setString(1,typed_name);
			ps.setString(2,typed_tel);
			ps.setString(3,typed_birth);
			ps.setString(4,typed_id);
			rs = ps.executeQuery();
			if(rs.next()) {
				String found_id=rs.getString("id");
				return true;
			}
			return false;
		}finally {
			if (rs != null) rs.close();
			if (ps != null) ps.close();
			if (con != null) con.close();
		}
	}

	public int changePW(String change_pw1,String id) throws SQLException {
		// TODO Auto-generated method stub
		String sql = "update seller set pw=? where id=?";
		try {
			con = DriverManager.getConnection(url, user, pass);
			ps = con.prepareStatement(sql);
			ps.setString(1,change_pw1);
			ps.setString(2,id);
			return  ps.executeUpdate();
		}finally {
			if (ps != null) ps.close();
			if (con != null) con.close();
		}
	}
	
}

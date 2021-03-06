package Server_DATA;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

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
	
	public boolean isNew(String tel) throws SQLException {
		String sql = "select * from seller where tel=?";
		try {
			con = DriverManager.getConnection(url, user, pass);
			ps = con.prepareStatement(sql);
			ps.setString(1,tel);
			rs=ps.executeQuery();
			if(rs.next()) {
				return true;
			}else {
				return false;
			}
		}finally {
			if (rs != null) rs.close();
			if (ps != null) ps.close();
			if (con != null) con.close();
		}
	}

	public int signSeller(SellerDTO sellerDTO) throws SQLException {
		// TODO Auto-generated method stub
		String sql = "insert into seller values(seq_seller.nextval,?,?,?,?,?,0,0,?,?)";
		try {
			con = DriverManager.getConnection(url, user, pass);
			ps = con.prepareStatement(sql);
			ps.setString(1,sellerDTO.getName());
			ps.setString(2,sellerDTO.getTel());
			ps.setString(3,sellerDTO.getBirth());
			ps.setString(4,sellerDTO.getId());
			ps.setString(5,sellerDTO.getPw());
			ps.setInt(6,sellerDTO.getLv());
			ps.setString(7,sellerDTO.getJoindate());
			return ps.executeUpdate();
		}finally {
			if (ps != null) ps.close();
			if (con != null) con.close();
		}
	}
	
	public SellerDTO searchSeller() {
		return null;
	}

	public ArrayList<SellerDTO> list_seller(int start,int end) throws SQLException {
		String sql="select * from (select rownum as rn,A.* from (select * from seller A order by sno desc)A) where rn between ? and ?";
		ArrayList<SellerDTO> list = new ArrayList<>();
		try {
			con = DriverManager.getConnection(url, user, pass);
			ps = con.prepareStatement(sql);
			ps.setInt(1,start);
			ps.setInt(2,end);
			rs = ps.executeQuery();
			while(rs.next()) {
				int sno=rs.getInt("sno");
				String name = rs.getString("name");
				String tel = rs.getString("tel");
				String birth = rs.getString("birth");
				String id = rs.getString("id");
				int c_cash=rs.getInt("c_cash");
				int n_cash=rs.getInt("n_cash");
				SellerDTO view = new SellerDTO(sno,name,tel,birth,id,c_cash,n_cash);
				view.setJoindate(rs.getString("joindate"));
				view.setLv(rs.getInt("lv"));
				list.add(view);
			}
			return list;
		}finally {
			if (rs != null) rs.close();
			if (ps != null) ps.close();
			if (con != null) con.close();
		}
	}
	
	public ArrayList<SellerDTO> searched_list_seller(String search,String searchvalue,int start,int end) throws SQLException {
		String sql="select * from (select rownum as rn,A.* from (select * from seller A where ? like ? order by sno desc)A) where rn between ? and ?";
		ArrayList<SellerDTO> list = new ArrayList<>();
		try {
			con = DriverManager.getConnection(url, user, pass);
			ps = con.prepareStatement(sql);
			ps.setString(1,search);
			ps.setString(2,"%"+searchvalue+"%");
			ps.setInt(3,start);
			ps.setInt(4,end);
			rs = ps.executeQuery();
			while(rs.next()) {
				int sno=rs.getInt("sno");
				String name = rs.getString("name");
				String tel = rs.getString("tel");
				String birth = rs.getString("birth");
				String id = rs.getString("id");
				int c_cash=rs.getInt("c_cash");
				int n_cash=rs.getInt("n_cash");
				SellerDTO view = new SellerDTO(sno,name,tel,birth,id,c_cash,n_cash);
				view.setJoindate(rs.getString("joindate"));
				list.add(view);
			}
			return list;
		}finally {
			if (rs != null) rs.close();
			if (ps != null) ps.close();
			if (con != null) con.close();
		}
	}

	public int counts_seller() throws SQLException {
		String sql="select count(*) from seller";
		ArrayList<SellerDTO> list = new ArrayList<>();
		try {
			con = DriverManager.getConnection(url, user, pass);
			ps = con.prepareStatement(sql);
			rs = ps.executeQuery();
			rs.next();
			return rs.getInt(1);
		}finally {
			if (rs != null) rs.close();
			if (ps != null) ps.close();
			if (con != null) con.close();
		}
	}
}

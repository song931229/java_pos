package Server_DATA;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class BuyerDAO extends BaseDAO {

	public int isCollect(String typed_tel, String typed_pw) throws SQLException {
		// 1 비번일치 0 비번불일치 -1 매치 전화번호 없음.
		String sql = "select tel,pw from buyer where tel=?";
		try {
			
			con = DriverManager.getConnection(url, user, pass);
			ps = con.prepareStatement(sql);
			ps.setString(1,typed_tel);
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
	
	public boolean isNew(String tel) throws SQLException {
		String sql = "select * from buyer where tel=?";
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
	
	public int signBuyer(BuyerDTO buyerDTO) throws SQLException {
		// TODO Auto-generated method stub
		String sql = "insert into buyer values(seq_buyer.nextval,?,?,?,?,0,1,?)";
		try {
			con = DriverManager.getConnection(url, user, pass);
			ps = con.prepareStatement(sql);
			ps.setString(1,buyerDTO.getName());
			ps.setString(2,buyerDTO.getTel());
			ps.setString(3,buyerDTO.getBirth());
			ps.setString(4,buyerDTO.getPw());
			ps.setString(5,buyerDTO.getJoindate());
			return ps.executeUpdate();
		}finally {
			if (ps != null) ps.close();
			if (con != null) con.close();
		}
	}
	
	public ArrayList<BuyerDTO> list_buyer(int start,int end) throws SQLException {
		String sql="select * from (select rownum as rn,A.* from (select * from buyer A order by bno desc)A) where rn between ? and ?";
		ArrayList<BuyerDTO> list = new ArrayList<>();
		try {
			con = DriverManager.getConnection(url, user, pass);
			ps = con.prepareStatement(sql);
			ps.setInt(1,start);
			ps.setInt(2,end);
			rs = ps.executeQuery();
			while(rs.next()) {
				int bno=rs.getInt("bno");
				String name = rs.getString("name");
				String tel = rs.getString("tel");
				String birth = rs.getString("birth");
				int point = rs.getInt("point");
				int lv = rs.getInt("lv");
				BuyerDTO view = new BuyerDTO(bno,name,tel,birth,point);
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
	
	public ArrayList<BuyerDTO> searched_list_buyer(String search,String searchvalue,int start,int end) throws SQLException {
		String sql="select * from (select rownum as rn,A.* from (select * from buyer A where "+search+" like ? order by "+search+")A) where rn between ? and ?";
		ArrayList<BuyerDTO> list = new ArrayList<>();
		System.out.println(search);
		System.out.println(searchvalue);
		try {
			con = DriverManager.getConnection(url, user, pass);
			ps = con.prepareStatement(sql);
			ps.setString(1,"%"+searchvalue+"%");
			ps.setInt(2,start);
			ps.setInt(3,end);
			rs = ps.executeQuery();
			while(rs.next()) {
				int bno=rs.getInt("bno");
				String name = rs.getString("name");
				String tel = rs.getString("tel");
				String birth = rs.getString("birth");
				int point = rs.getInt("point");
				int lv = rs.getInt("lv");
				BuyerDTO view = new BuyerDTO(bno,name,tel,birth,point);
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

	public int counts_buyer() throws SQLException {
		String sql="select count(*) from buyer";
		ArrayList<BuyerDTO> list = new ArrayList<>();
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

	public int counts_searched_buyer(String search, String searchvalue) throws SQLException {
		String sql="select count(*) from (select rownum as rn,A.* from (select * from buyer A where "+search+" like ? order by "+search+")A)";
		try {
			con = DriverManager.getConnection(url, user, pass);
			ps = con.prepareStatement(sql);
			ps.setString(1,"%"+searchvalue+"%");
			rs = ps.executeQuery();
			rs.next();
			return rs.getInt(1);
		}finally {
			if (rs != null) rs.close();
			if (ps != null) ps.close();
			if (con != null) con.close();
		}
	}
	
	public BuyerDTO infoBuyer(String typed_tel) throws SQLException {
		// 로그인 후 ID값에 맞는 Seller객체 반환
		String sql = "select * from buyer where tel=?";
		try {
			con = DriverManager.getConnection(url, user, pass);
			ps = con.prepareStatement(sql);
			ps.setString(1,typed_tel);
			rs = ps.executeQuery();
			BuyerDTO buyerDTO=new BuyerDTO();
			if(rs.next()) {
				buyerDTO.setName(rs.getString("name"));
				buyerDTO.setTel(rs.getString("tel"));
				buyerDTO.setBirth(rs.getString("birth"));
				buyerDTO.setPoint(rs.getInt("point"));
				buyerDTO.setLv(rs.getInt("lv"));
				buyerDTO.setJoindate(rs.getString("joindate"));
			}
			return buyerDTO;
		}finally {
			if (rs != null) rs.close();
			if (ps != null) ps.close();
			if (con != null) con.close();
		}
	}
	
	public int update_Buyer(BuyerDTO updateDTO) throws SQLException {
		// TODO Auto-generated method stub
		String sql="update buyer set tel=?,lv=? where bno=?";
		try {
			con = DriverManager.getConnection(url, user, pass);
			ps = con.prepareStatement(sql);
			ps.setString(1,updateDTO.getTel());
			ps.setInt(2,updateDTO.getLv());
			return ps.executeUpdate();
		}finally {
			if (ps != null) ps.close();
			if (con != null) con.close();
		}
	}

	public int delete_Seller(String tel) throws SQLException {
		// TODO Auto-generated method stub
		String sql="delete from buyer where tel=?";
		try {
			con = DriverManager.getConnection(url, user, pass);
			ps = con.prepareStatement(sql);
			ps.setString(1,tel);
			return ps.executeUpdate();
		}finally {
			if (ps != null) ps.close();
			if (con != null) con.close();
		}
	}
}

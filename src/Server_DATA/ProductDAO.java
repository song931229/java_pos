package Server_DATA;

import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ArrayList;

public class ProductDAO extends BaseDAO {
	public boolean isNew(String barcode) throws SQLException {
		String sql = "select * from product where barcode=?";
		try {
			con = DriverManager.getConnection(url, user, pass);
			ps = con.prepareStatement(sql);
			ps.setString(1,barcode);
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
	
	public int signProduct(ProductDTO productDTO) throws SQLException {
		// TODO Auto-generated method stub
		String sql = "insert into product values(seq_product.nextval,?,?,?,?,0,?)";
		try {
			con = DriverManager.getConnection(url, user, pass);
			ps = con.prepareStatement(sql);
			ps.setString(1,productDTO.getName());
			ps.setString(2,productDTO.getCompany());
			ps.setInt(3,productDTO.getOrderprice());
			ps.setInt(4,productDTO.getSellprice());
			return ps.executeUpdate();
		}finally {
			if (ps != null) ps.close();
			if (con != null) con.close();
		}
	}

	public ArrayList<ProductDTO> list_product(int start,int end) throws SQLException {
		String sql="select * from (select rownum as rn,A.* from (select * from product A order by pno desc)A) where rn between ? and ?";
		ArrayList<ProductDTO> list = new ArrayList<>();
		try {
			con = DriverManager.getConnection(url, user, pass);
			ps = con.prepareStatement(sql);
			ps.setInt(1,start);
			ps.setInt(2,end);
			rs = ps.executeQuery();
			while(rs.next()) {
				int pno=rs.getInt("pno");
				String name = rs.getString("name");
				String company = rs.getString("company");
				int orderprice = rs.getInt("orderprice");
				int sellprice = rs.getInt("sellprice");
				int pqty = rs.getInt("pqty");
				String barcode=rs.getString("barcode");
				ProductDTO view = new ProductDTO(name,company,orderprice,sellprice,barcode);
				view.setPno(pno);
				view.setPqty(pqty);
				list.add(view);
			}
			return list;
		}finally {
			if (rs != null) rs.close();
			if (ps != null) ps.close();
			if (con != null) con.close();
		}
	}
	
	public ArrayList<ProductDTO> searched_list_product(String search,String searchvalue,int start,int end) throws SQLException {
		String sql="select * from (select rownum as rn,A.* from (select * from product A where "+search+" like ? order by "+search+")A) where rn between ? and ?";
		ArrayList<ProductDTO> list = new ArrayList<>();
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
				int pno=rs.getInt("pno");
				String name = rs.getString("name");
				String company = rs.getString("company");
				int orderprice = rs.getInt("orderprice");
				int sellprice = rs.getInt("sellprice");
				int pqty = rs.getInt("pqty");
				String barcode=rs.getString("barcode");
				ProductDTO view = new ProductDTO(name,company,orderprice,sellprice,barcode);
				view.setPno(pno);
				view.setPqty(pqty);
				list.add(view);
			}
			return list;
		}finally {
			if (rs != null) rs.close();
			if (ps != null) ps.close();
			if (con != null) con.close();
		}
	}
	
	public int counts_product() throws SQLException {
		String sql="select count(*) from product";
		ArrayList<ProductDTO> list = new ArrayList<>();
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
	
	public int counts_searched_product(String search, String searchvalue) throws SQLException {
		String sql="select count(*) from (select rownum as rn,A.* from (select * from product A where "+search+" like ? order by "+search+")A)";
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
	
	public ProductDTO infoProduct(String typed_barcode) throws SQLException {
		// 로그인 후 ID값에 맞는 Seller객체 반환
		String sql = "select * from product where typed_barcode=?";
		try {
			con = DriverManager.getConnection(url, user, pass);
			ps = con.prepareStatement(sql);
			ps.setString(1,typed_barcode);
			rs = ps.executeQuery();
			ProductDTO productDTO=new ProductDTO();
			if(rs.next()) {
				int pno=rs.getInt("pno");
				String name = rs.getString("name");
				String company = rs.getString("company");
				int orderprice = rs.getInt("orderprice");
				int sellprice = rs.getInt("sellprice");
				int pqty = rs.getInt("pqty");
				String barcode=rs.getString("barcode");
				productDTO.setPno(pno);
				productDTO.setPqty(pqty);
			}
			return productDTO;
		}finally {
			if (rs != null) rs.close();
			if (ps != null) ps.close();
			if (con != null) con.close();
		}
	}
	
	public int update_poduct(ProductDTO updateDTO) throws SQLException {
		// TODO Auto-generated method stub
		String sql="update product set tel=?,lv=? where pno=?";
		try {
			con = DriverManager.getConnection(url, user, pass);
			ps = con.prepareStatement(sql);
			ps.setInt(1,updateDTO.getPqty());
			ps.setInt(2,updateDTO.getSellprice());
			return ps.executeUpdate();
		}finally {
			if (ps != null) ps.close();
			if (con != null) con.close();
		}
	}

	public int delete_Seller(String barcode) throws SQLException {
		// TODO Auto-generated method stub
		String sql="delete from product where id=?";
		try {
			con = DriverManager.getConnection(url, user, pass);
			ps = con.prepareStatement(sql);
			ps.setString(1,barcode);
			return ps.executeUpdate();
		}finally {
			if (ps != null) ps.close();
			if (con != null) con.close();
		}
	}
}

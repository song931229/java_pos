package Server_DATA;

import java.sql.DriverManager;
import java.sql.SQLException;

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
		String sql = "insert into product values(seq_product.nextval,?,?,?,?,0,1,?)";
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
}

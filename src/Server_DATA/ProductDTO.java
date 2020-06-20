package Server_DATA;

public class ProductDTO {
	private int pno;
	private String name;
	private String company;
	private int orderprice;
	private int sellprice;
	private int pqty;
	private String barcode;
	
	public ProductDTO(String name, String company,int orderprice, int sellprice, int pqyt, String barcode) {
		super();
		this.name = name;
		this.company = company;
		this.orderprice = orderprice;
		this.sellprice=sellprice;
		this.pqty=pqty;
		this.barcode=barcode;
	}

	public int getPno() {
		return pno;
	}

	public void setPno(int pno) {
		this.pno = pno;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCompany() {
		return company;
	}

	public void setCompany(String company) {
		this.company = company;
	}

	public int getOrderprice() {
		return orderprice;
	}

	public void setOrderprice(int orderprice) {
		this.orderprice = orderprice;
	}

	public int getSellprice() {
		return sellprice;
	}

	public void setSellprice(int sellprice) {
		this.sellprice = sellprice;
	}

	public int getPqty() {
		return pqty;
	}

	public void setPqty(int pqty) {
		this.pqty = pqty;
	}

	public String getBarcode() {
		return barcode;
	}

	public void setBarcode(String barcode) {
		this.barcode = barcode;
	}
	
	
}

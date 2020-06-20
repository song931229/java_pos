package Server_DATA;

public class SellerDTO {
	private int sno;
	private String name;
	private String tel;
	private String birth;
	private String id;
	private String pw;
	private int c_cash;
	private int n_cash;
	private int lv=1;
	private String joindate;
	
	public SellerDTO(String name, String tel, String birth,String id, String pw, int c_cash, int n_cash, String joindate) {
		super();
		this.name = name;
		this.tel = tel;
		this.id = id;
		this.pw=pw;
		this.c_cash=c_cash;
		this.n_cash=n_cash;
		java.util.Date date = new java.util.Date();
		java.text.SimpleDateFormat sdf = new java.text.SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		this.joindate = sdf.format(date);
	}
	
	public int getSno() {
		return sno;
	}
	public void setSno(int sno) {
		this.sno = sno;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getTel() {
		return tel;
	}
	public void setTel(String tel) {
		this.tel = tel;
	}
	public String getBirth() {
		return birth;
	}
	public void setBirth(String birth) {
		this.birth = birth;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getPw() {
		return pw;
	}
	public void setPw(String pw) {
		this.pw = pw;
	}
	public int getC_cash() {
		return c_cash;
	}
	public void setC_cash(int c_cash) {
		this.c_cash = c_cash;
	}
	public int getN_cash() {
		return n_cash;
	}
	public void setN_cash(int n_cash) {
		this.n_cash = n_cash;
	}
	public int getLv() {
		return lv;
	}
	public void setLv(int lv) {
		this.lv = lv;
	}
	public String getJoindate() {
		return joindate;
	}
	public void setJoindate(String joindate) {
		this.joindate = joindate;
	}
}

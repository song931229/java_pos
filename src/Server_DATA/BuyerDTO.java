package Server_DATA;

public class BuyerDTO {
	private int bno;
	private String name;
	private String tel;
	private String birth;
	private String pw;
	private int point;
	private int lv=1;
	private String joindate;
	
	public BuyerDTO() {}
	
	public BuyerDTO(String name, String tel, String birth, String pw) {
		this.name = name;
		this.tel = tel;
		this.birth = birth;
		this.pw=pw;
		this.point=point;
		java.util.Date date = new java.util.Date();
		java.text.SimpleDateFormat sdf = new java.text.SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		this.joindate = sdf.format(date);
	}
	
	public BuyerDTO(int bno, String name, String tel, String birth, int point) {
		this.bno=bno;
		this.name = name;
		this.tel = tel;
		this.birth = birth;
		this.pw=pw;
		this.point=point;
		java.util.Date date = new java.util.Date();
		java.text.SimpleDateFormat sdf = new java.text.SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		this.joindate = sdf.format(date);
	}

	public int getBno() {
		return bno;
	}

	public void setBno(int bno) {
		this.bno = bno;
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

	public String getPw() {
		return pw;
	}

	public void setPw(String pw) {
		this.pw = pw;
	}

	public int getPoint() {
		return point;
	}

	public void setPoint(int point) {
		this.point = point;
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

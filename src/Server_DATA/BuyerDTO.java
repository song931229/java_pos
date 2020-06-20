package Server_DATA;

public class BuyerDTO {
	private int bno;
	private String name;
	private String tel;
	private String birth;
	private int point;
	private int lv;
	private String joindate;
	
	public BuyerDTO(String name, String tel, String birth,int point, int lv, String joindate) {
		super();
		this.name = name;
		this.tel = tel;
		this.birth = birth;
		this.point=point;
		this.lv=lv;
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

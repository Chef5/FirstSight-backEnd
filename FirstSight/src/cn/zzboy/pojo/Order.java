package cn.zzboy.pojo;

public class Order {
	private int id;
	private int userid;
	private int flowerid;
	private int siteid;
	private int adminid;
	private int number;
	private float price;
	private String crtTime;
	private int crtBy;
	private String payTime;
	private String outTime;
	private String resTime;
	private String scsTime;
	private String mdfTime;
	private int mdfBy;
	
	private Site site;
	private User user;
	private String state;
	private int oldprice;
	private int discount;
	private String disCon;//’€ø€√Ë ˆ
	private String disBtn;//≤Ÿ◊˜∞¥≈•√Ë ˆ
	private Flower flower;
	
	
	public Flower getFlower() {
		return flower;
	}
	public void setFlower(Flower flower) {
		this.flower = flower;
	}
	public String getDisBtn() {
		return disBtn;
	}
	public void setDisBtn(String disBtn) {
		this.disBtn = disBtn;
	}
	public int getOldprice() {
		return oldprice;
	}
	public void setOldprice(int oldprice) {
		this.oldprice = oldprice;
	}
	public int getDiscount() {
		return discount;
	}
	public void setDiscount(int discount) {
		this.discount = discount;
	}
	public String getDisCon() {
		return disCon;
	}
	public void setDisCon(String disCon) {
		this.disCon = disCon;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public Site getSite() {
		return site;
	}
	public void setSite(Site site) {
		this.site = site;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getUserid() {
		return userid;
	}
	public void setUserid(int userid) {
		this.userid = userid;
	}
	public int getFlowerid() {
		return flowerid;
	}
	public void setFlowerid(int flowerid) {
		this.flowerid = flowerid;
	}
	public int getSiteid() {
		return siteid;
	}
	public void setSiteid(int siteid) {
		this.siteid = siteid;
	}
	public int getAdminid() {
		return adminid;
	}
	public void setAdminid(int adminid) {
		this.adminid = adminid;
	}
	public int getNumber() {
		return number;
	}
	public void setNumber(int number) {
		this.number = number;
	}
	public float getPrice() {
		return price;
	}
	public void setPrice(float price) {
		this.price = price;
	}
	public String getCrtTime() {
		return crtTime;
	}
	public void setCrtTime(String crtTime) {
		this.crtTime = crtTime;
	}
	public int getCrtBy() {
		return crtBy;
	}
	public void setCrtBy(int crtBy) {
		this.crtBy = crtBy;
	}
	public String getPayTime() {
		return payTime;
	}
	public void setPayTime(String payTime) {
		this.payTime = payTime;
	}
	public String getOutTime() {
		return outTime;
	}
	public void setOutTime(String outTime) {
		this.outTime = outTime;
	}
	public String getResTime() {
		return resTime;
	}
	public void setResTime(String resTime) {
		this.resTime = resTime;
	}
	public String getScsTime() {
		return scsTime;
	}
	public void setScsTime(String scsTime) {
		this.scsTime = scsTime;
	}
	public String getMdfTime() {
		return mdfTime;
	}
	public void setMdfTime(String mdfTime) {
		this.mdfTime = mdfTime;
	}
	public int getMdfBy() {
		return mdfBy;
	}
	public void setMdfBy(int mdfBy) {
		this.mdfBy = mdfBy;
	}
}

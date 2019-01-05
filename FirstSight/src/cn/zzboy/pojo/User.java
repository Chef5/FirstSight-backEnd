package cn.zzboy.pojo;

import javax.servlet.http.HttpSession;

public class User {
	private int id;
	private String name;
	private String phone;
	private String password;
	private int isAdmin;
	private String crtTime;
	private int crtBy;
	private String mdfTime;
	private int mdfBy;
	
	private HttpSession session;
	private String oldpassword;
	
	public String getOldpassword() {
		return oldpassword;
	}
	public void setOldpassword(String oldpassword) {
		this.oldpassword = oldpassword;
	}
	public HttpSession getSession() {
		return session;
	}
	public void setSession(HttpSession session) {
		this.session = session;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public int getIsAdmin() {
		return isAdmin;
	}
	public void setIsAdmin(int isAdmin) {
		this.isAdmin = isAdmin;
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

package cn.zzboy.pojo;

public class Kind {
	private int id;
	private String name;
	private String disc;
	private String picture;
	private String crtTime;
	private int crtBy;
	private String mdfTime;
	private int mdfBy;
	
	
	public String getPicture() {
		return picture;
	}
	public void setPicture(String picture) {
		this.picture = picture;
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
	public String getDisc() {
		return disc;
	}
	public void setDisc(String disc) {
		this.disc = disc;
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

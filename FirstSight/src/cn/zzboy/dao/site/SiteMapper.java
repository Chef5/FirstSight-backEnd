package cn.zzboy.dao.site;

import java.util.List;

import cn.zzboy.pojo.Site;

public interface SiteMapper {
	//通过用户id收货地址id
	public int getSiteidByUserid(int userid);
	//获取某条收货地址详细  通过收货地址id
	public List<Site> getSiteById(int id);
	//新增收货地址
	public int addSite(Site site);
	//修改收货地址
	public int mdfSite(Site site);
	//删除收货地址
	public int delSite(int id);
	
}

package cn.zzboy.dao.site;

import java.util.List;

import cn.zzboy.pojo.Site;

public interface SiteMapper {
	//ͨ���û�id�ջ���ַid
	public int getSiteidByUserid(int userid);
	//��ȡĳ���ջ���ַ��ϸ  ͨ���ջ���ַid
	public List<Site> getSiteById(int id);
	//�����ջ���ַ
	public int addSite(Site site);
	//�޸��ջ���ַ
	public int mdfSite(Site site);
	//ɾ���ջ���ַ
	public int delSite(int id);
	
}

package cn.zzboy.service.site;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.zzboy.dao.site.*;
import cn.zzboy.pojo.Site;
@Service("SiteService")
public class SiteServiceImpl implements SiteService{
	@Autowired
	private SiteMapper siteMapper;

	@Override
	public int getSiteidByUserid(int userid) {
		// TODO Auto-generated method stub
		return siteMapper.getSiteidByUserid(userid);
	}

	@Override
	public List<Site> getSiteById(int id) {
		// TODO Auto-generated method stub
		return siteMapper.getSiteById(id);
	}

	@Override
	public int addSite(Site site) {
		// TODO Auto-generated method stub
		return siteMapper.addSite(site);
	}

	@Override
	public int mdfSite(Site site) {
		// TODO Auto-generated method stub
		return siteMapper.mdfSite(site);
	}

	@Override
	public int delSite(int id) {
		// TODO Auto-generated method stub
		return siteMapper.delSite(id);
	}

	
	
}

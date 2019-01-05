package cn.zzboy.service.kind;

import java.util.List;

import cn.zzboy.pojo.*;

public interface KindService {
	//	获取专区
	public List<Kind> getKind();
	//获取专区名
	public String getKindNameById(int id);
	//获取专区商品
	public List<Flower> getFlowerByKind(int kind);
}

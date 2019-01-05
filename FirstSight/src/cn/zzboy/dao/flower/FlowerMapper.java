package cn.zzboy.dao.flower;

import java.util.List;

import cn.zzboy.pojo.*;


public interface FlowerMapper {
	//获取热门
	public List<Flower> getHotFlowerList();
	//依据专区获取8个商品
	public List<Flower> getFlowerByKind(int kind);
	//获取鲜花详细
	public Flower getFlowerById(int id);
	//搜索
	public List<Flower> getFlowerBySerch(String info);
	//获取所有商品
	public List<Flower> getAllFlower();
}

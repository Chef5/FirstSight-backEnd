package cn.zzboy.service.flower;

import java.util.List;

import cn.zzboy.pojo.Flower;


public interface FlowerService {
	public List<Flower> getHotFlowerList();
	public List<Flower> getFlowerByKind(int kind);
	public Flower getFlowerById(int id);;
	public List<Flower> getFlowerBySerch(String info);
	//��ȡ������Ʒ
	public List<Flower> getAllFlower();
}

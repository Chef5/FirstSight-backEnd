package cn.zzboy.dao.flower;

import java.util.List;

import cn.zzboy.pojo.*;


public interface FlowerMapper {
	//��ȡ����
	public List<Flower> getHotFlowerList();
	//����ר����ȡ8����Ʒ
	public List<Flower> getFlowerByKind(int kind);
	//��ȡ�ʻ���ϸ
	public Flower getFlowerById(int id);
	//����
	public List<Flower> getFlowerBySerch(String info);
	//��ȡ������Ʒ
	public List<Flower> getAllFlower();
}

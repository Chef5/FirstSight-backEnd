package cn.zzboy.service.flower;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.zzboy.dao.flower.FlowerMapper;
import cn.zzboy.pojo.Flower;
@Service("FlowerService")
public class FlowerServiceImpl implements FlowerService{
	@Autowired
	private FlowerMapper flowerMapper;
	
	public FlowerMapper getFlowerMapper() {
		return flowerMapper;
	}
	public void setFlowerMapper(FlowerMapper flowerMapper) {
		this.flowerMapper = flowerMapper;
	}
	@Override
	public List<Flower> getHotFlowerList(){
		// TODO Auto-generated method stub
		return flowerMapper.getHotFlowerList(); 
	}
	@Override
	public List<Flower> getFlowerByKind(int kind) {
		// TODO Auto-generated method stub
		return flowerMapper.getFlowerByKind(kind);
	}
	@Override
	public Flower getFlowerById(int id) {
		// TODO Auto-generated method stub
		return flowerMapper.getFlowerById(id);
	}
	@Override
	public List<Flower> getFlowerBySerch(String info) {
		// TODO Auto-generated method stub
		return flowerMapper.getFlowerBySerch(info);
	}
	@Override
	public List<Flower> getAllFlower() {
		// TODO Auto-generated method stub
		return flowerMapper.getAllFlower();
	}
}

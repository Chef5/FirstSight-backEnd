package cn.zzboy.service.kind;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.zzboy.dao.kind.*;
import cn.zzboy.pojo.*;
@Service("KindService")
public class KindServiceImpl implements KindService{
	@Autowired
	private KindMapper kindMapper;
	
	@Override
	public List<Kind> getKind() {
		// TODO Auto-generated method stub
		return kindMapper.getKind();
	}

	@Override
	public String getKindNameById(int id) {
		// TODO Auto-generated method stub
		return kindMapper.getKindNameById(id);
	}

	@Override
	public List<Flower> getFlowerByKind(int kind) {
		// TODO Auto-generated method stub
		return kindMapper.getFlowerByKind(kind);
	}

}

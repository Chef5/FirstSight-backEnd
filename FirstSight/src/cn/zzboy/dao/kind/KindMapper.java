package cn.zzboy.dao.kind;

import java.util.List;
import cn.zzboy.pojo.*;

public interface KindMapper {
	//获取专区
	public List<Kind> getKind(); 
	//获取专区名
	public String getKindNameById(int id);
	//获取专区鲜花
	public List<Flower> getFlowerByKind(int kind);
}

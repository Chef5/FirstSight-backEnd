package cn.zzboy.dao.kind;

import java.util.List;
import cn.zzboy.pojo.*;

public interface KindMapper {
	//��ȡר��
	public List<Kind> getKind(); 
	//��ȡר����
	public String getKindNameById(int id);
	//��ȡר���ʻ�
	public List<Flower> getFlowerByKind(int kind);
}

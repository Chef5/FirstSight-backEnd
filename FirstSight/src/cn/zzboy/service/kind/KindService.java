package cn.zzboy.service.kind;

import java.util.List;

import cn.zzboy.pojo.*;

public interface KindService {
	//	��ȡר��
	public List<Kind> getKind();
	//��ȡר����
	public String getKindNameById(int id);
	//��ȡר����Ʒ
	public List<Flower> getFlowerByKind(int kind);
}

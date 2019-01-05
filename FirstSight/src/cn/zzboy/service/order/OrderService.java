package cn.zzboy.service.order;

import java.util.List;

import cn.zzboy.pojo.Order;

public interface OrderService {
	//�û��µ�
	public int addOrder(Order order);

	//��ȡ�û����ж���
	public List<Order> getAllOrderByUserid(int userid);
	//��ȡ�����ⶩ��
	public List<Order> getNeedOutOrder();
	//���ⶩ�� 
	public int outOrderById(int id);
}

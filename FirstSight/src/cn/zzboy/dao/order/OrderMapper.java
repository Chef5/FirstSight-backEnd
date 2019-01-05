package cn.zzboy.dao.order;

import java.util.List;

import cn.zzboy.pojo.Order;

public interface OrderMapper {
	//用户下单
	public int addOrder(Order order);
	//获取用户所有订单
	public List<Order> getAllOrderByUserid(int userid);
	//获取待出库订单
	public List<Order> getNeedOutOrder();
	//出库订单 
	public int outOrderById(int id);
}

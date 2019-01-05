package cn.zzboy.service.order;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.zzboy.dao.order.*;
import cn.zzboy.pojo.Order;
@Service("OrderService")
public class OrderServiceImpl implements OrderService{
	@Autowired
	private OrderMapper orderMapper;

	@Override
	public int addOrder(Order order) {
		// TODO Auto-generated method stub
		return orderMapper.addOrder(order);
	}

	@Override
	public List<Order> getAllOrderByUserid(int userid) {
		// TODO Auto-generated method stub
		return orderMapper.getAllOrderByUserid(userid);
	}

	@Override
	public List<Order> getNeedOutOrder() {
		// TODO Auto-generated method stub
		return orderMapper.getNeedOutOrder();
	}

	@Override
	public int outOrderById(int id) {
		// TODO Auto-generated method stub
		return orderMapper.outOrderById(id);
	}
	
	
}

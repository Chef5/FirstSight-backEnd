package cn.zzboy.service.user;


import cn.zzboy.pojo.*;

public interface UserService {
	//用户验证
	public User checkUser(User user);
	//用户注册
	public int regUser(User user);
	//用户个人信息
	public User getUserById(int id);
	//修改昵称和手机号
	public int mdfUserNameandPhone(User user);
	//修改密码
	public int mdfUserPassword(User user);
}

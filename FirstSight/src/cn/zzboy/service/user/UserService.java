package cn.zzboy.service.user;


import cn.zzboy.pojo.*;

public interface UserService {
	//�û���֤
	public User checkUser(User user);
	//�û�ע��
	public int regUser(User user);
	//�û�������Ϣ
	public User getUserById(int id);
	//�޸��ǳƺ��ֻ���
	public int mdfUserNameandPhone(User user);
	//�޸�����
	public int mdfUserPassword(User user);
}

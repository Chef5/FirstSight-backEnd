package cn.zzboy.dao.user;

import cn.zzboy.pojo.*;

public interface UserMapper {
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

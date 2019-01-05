package cn.zzboy.controller;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.zzboy.pojo.*;
import cn.zzboy.service.flower.FlowerServiceImpl;
import cn.zzboy.service.kind.KindServiceImpl;
import cn.zzboy.service.order.OrderServiceImpl;
import cn.zzboy.service.site.SiteServiceImpl;
import cn.zzboy.service.user.UserServiceImpl;
import net.sf.json.JSONArray;

@Controller
public class AllController {
	//声明ServiceImpl
	@Autowired
	private FlowerServiceImpl fsi;
	@Autowired
	private KindServiceImpl ksi;
	@Autowired
	private UserServiceImpl usi;
	@Autowired
	private OrderServiceImpl osi;
	@Autowired
	private SiteServiceImpl ssi;

	

	//鲜花控制器
	/**
	 * 获取热门推荐 4个商品
	 * @return flower
	 */
	@RequestMapping(value="/getHotFlowers",method={RequestMethod.GET},produces={"application/json;charset=utf-8"})
	@ResponseBody
	public String getHotFlowerList(){
		List<Flower> flower=fsi.getHotFlowerList();
		String str=JSONArray.fromObject(flower).toString();
		return str;
	}
	/**
	 * 获取每个专区8个商品，一个集合
	 * @return flower集合
	 */
	@RequestMapping(value="/getFlowers",method={RequestMethod.GET},produces={"application/json;charset=utf-8"})
	@ResponseBody
	public String getFlowerByKind(){
		List<Flower> ret=new ArrayList<Flower>();
		List<Kind> kind=ksi.getKind();
		for (Kind item : kind){
			List<Flower> flowers=fsi.getFlowerByKind(item.getId());
			ret.addAll(flowers);
		}
		String str=JSONArray.fromObject(ret).toString();
		return str;
	}
	/**
	 * 获取单个鲜花详细 通过Id
	 * @return flower
	 */
	@RequestMapping(value="/getFlowerById",method={RequestMethod.POST},produces={"application/json;charset=utf-8"})
	@ResponseBody
	public String getFlowerById(HttpServletRequest request, HttpServletResponse respone){
		int id = Integer.parseInt(request.getParameter("id"));
		Flower flower = fsi.getFlowerById(id);
		String name = ksi.getKindNameById(flower.getKind());//设置类别名
		flower.setKindName(name);
		String[] imgArray = null;   //分割图片成数组
		imgArray = flower.getDetail().split("##");
		flower.setImgs(imgArray);
		if( String.valueOf(flower.getDiscount()) != null && flower.getDiscount()!=0){  //计算折后价
			String nowprice = String.valueOf(Math.round((float)flower.getPrice()*((float)flower.getDiscount()/10)));	
			flower.setNowPrice(nowprice);
			flower.setNowDis(String.valueOf(flower.getDiscount()));
		}else {
			flower.setNowPrice(String.valueOf(flower.getPrice()));
			flower.setNowDis("无");
		}
		String str=JSONArray.fromObject(flower).toString();
		return str;
	}
	/**
	 * 获取搜索结果
	 * @return flower
	 */
	@RequestMapping(value="/getFlowerBySerch",method={RequestMethod.POST},produces={"application/json;charset=utf-8"})
	@ResponseBody
	public String getFlowerById(HttpServletRequest request){
		//中文编码设置
		try {
			request.setCharacterEncoding("utf-8");
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		String info = request.getParameter("info");
		List<Flower> flower = fsi.getFlowerBySerch(info);
		String str=JSONArray.fromObject(flower).toString();
		return str;
	}
	/**
	 * 获取所有商品
	 * @return
	 */
	@RequestMapping(value="/getAllFlower",method={RequestMethod.GET},produces={"application/json;charset=utf-8"})
	@ResponseBody
	public String getAllFlower(){
		List<Flower> flower =  fsi.getAllFlower();
		String str=JSONArray.fromObject(flower).toString();
		return str;
	}
	
	
	
	
	
	
	
	
	//用户控制器
	/**
	 * 初始检查用户登录
	 * @param request
	 * @param respone
	 * @return
	 */
	@RequestMapping(value="/checkLogin",method={RequestMethod.GET},produces={"application/json;charset=utf-8"})
	@ResponseBody
	public String checkLogin(HttpServletRequest request, HttpServletResponse respone){
		//获取数据
		HttpSession session = request.getSession();
		User user = (User) session.getAttribute("user");
		String str=JSONArray.fromObject(user).toString();
		return str;
	}
	/**
	 * 注销登录
	 * @param request
	 * @param respone
	 */
	@RequestMapping(value="/logOut",method={RequestMethod.GET},produces={"application/json;charset=utf-8"})
	@ResponseBody
	public void logOut(HttpServletRequest request, HttpServletResponse respone){
		//获取数据
		HttpSession session = request.getSession();
		session.invalidate();
	}
	/**
	 * 用户验证
	 * @param request
	 * @param respone
	 * @return
	 */
	@RequestMapping(value="/checkUser",method={RequestMethod.POST},produces={"application/json;charset=utf-8"})
	@ResponseBody
	public String checkUser(HttpServletRequest request, HttpServletResponse respone){
		//获取数据
		String phone = request.getParameter("phone");
		String password = AllController.MD5(request.getParameter("password"));
		User user = new User();
		user.setPhone(phone);
		user.setPassword(password);
		HttpSession session =request.getSession();
		session.setMaxInactiveInterval(600);//会话生命周期 10分钟
		user.setSession(session);
		//调用业务逻辑
		User ret = usi.checkUser(user); 
		if(ret.getPhone().equals(user.getPhone()) && ret.getPassword().equals(user.getPassword())){
			session.setAttribute("user", ret);
			String str=JSONArray.fromObject(ret).toString();
			return str;
		}
		else{
			System.out.println("用户信息错误");
			return null;
		}
	}
	/**
	 * 
	 * @param request
	 * @return 
	 */
	@RequestMapping(value="/regUser",method={RequestMethod.POST},produces={"application/json;charset=utf-8"})
	@ResponseBody
	public String checkUser(HttpServletRequest request){
		//中文编码设置
		try {
			request.setCharacterEncoding("utf-8");
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//获取数据
		String phone = request.getParameter("phone");
		String password = AllController.MD5(request.getParameter("password"));
		Date date = new Date();
		SimpleDateFormat dateFormat= new SimpleDateFormat("yyyy-MM-dd");
		String crtTime = dateFormat.format(date);
		User user = new User();
		user.setPhone(phone);
		user.setPassword(password);
		user.setCrtTime(crtTime);
		//调用业务逻辑
		usi.regUser(user); 
		return "y";
	}
	/**
	 * 读取用户信息
	 * @param request
	 * @param respone
	 * @return
	 */
	@RequestMapping(value="/getUserById",method={RequestMethod.GET},produces={"application/json;charset=utf-8"})
	@ResponseBody
	public String getUserById(HttpServletRequest request, HttpServletResponse respone){
		HttpSession session = request.getSession();
		User user = (User) session.getAttribute("user");
		User ul = usi.getUserById(user.getId());
		String str=JSONArray.fromObject(ul).toString();
		return str;
	}
	/**
	 * 修改用户昵称和手机
	 * @param request
	 * @return 0,1
	 */
	@RequestMapping(value="/mdfUser",method={RequestMethod.POST},produces={"application/json;charset=utf-8"})
	@ResponseBody
	public String mdfUser(HttpServletRequest request){
		//中文编码设置
		try {
			request.setCharacterEncoding("utf-8");
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		HttpSession session = request.getSession();
		User user = (User) session.getAttribute("user");
		Date date = new Date();
		SimpleDateFormat dateFormat2= new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String mdfTime = dateFormat2.format(date);
		
		String name = request.getParameter("name");
		String phone = request.getParameter("phone");
		User u = new User();
		u.setName(name);
		u.setPhone(phone);
		u.setMdfTime(mdfTime);
		u.setMdfBy(user.getId());
		u.setId(user.getId());
		
		String oldp = request.getParameter("oldpassword");
		String newp = request.getParameter("password");
		
		if(oldp.equals("")){
			//修改昵称和手机
			System.out.println("修改昵称手机");
			int ret = usi.mdfUserNameandPhone(u);
			if(ret==1){  //更新session中的值
				user.setName(name);
				session.setAttribute("user", user);
			}
			return String.valueOf(ret);
		}else{
			//修改密码
			System.out.println("修改密码");
			String oldpassword = AllController.MD5(oldp);
			String password = AllController.MD5(newp);
			if(user.getPassword().equals(oldpassword)){
				u.setPassword(password);
				u.setMdfTime(mdfTime);
				u.setMdfBy(user.getId());
				u.setId(user.getId());
				int ret = usi.mdfUserPassword(u);
				if(ret==1){  //更新session中的值
					user.setName(name);
					session.setAttribute("user", user);
				}
				return String.valueOf(ret);
			}else return String.valueOf(0);
		}
		
	}
	
      
	
	
	
	
	
	
	
	//类别控制器
	/**
	 * 获取所有类别
	 * @return 类别信息
	 */
	@RequestMapping(value="/getKind",method={RequestMethod.GET},produces={"application/json;charset=utf-8"})
	@ResponseBody
	public String getKind(){
		List<Kind> kind=ksi.getKind();
		String str=JSONArray.fromObject(kind).toString();
		return str;
	}
	/**
	 * 获取类别下所有商品
	 * @return flower
	 */
	@RequestMapping(value="/getFlowerByKind",method={RequestMethod.POST},produces={"application/json;charset=utf-8"})
	@ResponseBody
	public String getKindNameById(HttpServletRequest request){
		String kind = request.getParameter("kind");
		String name = ksi.getKindNameById(Integer.parseInt(kind));//设置类别名
		List<Flower> flower = ksi.getFlowerByKind(Integer.parseInt(kind));
		for(Flower f:flower){ 
				f.setKindName(name);
		}
		String str=JSONArray.fromObject(flower).toString();
		return str;
	}
	
	
	
	
	//地址控制器
	/**
	 * 获取用户地址
	 * @param request
	 * @return site
	 */
	@RequestMapping(value="/getSite",method={RequestMethod.GET},produces={"application/json;charset=utf-8"})
	@ResponseBody
	public String getSite(HttpServletRequest request){
		HttpSession session = request.getSession();
		User user = (User) session.getAttribute("user");
		List<Site> site = ssi.getSiteById(user.getId());
		String str=JSONArray.fromObject(site).toString();
		return str;
	}
	/**
	 * 新增收货地址
	 * @param request
	 * @return 0,1
	 */
	@RequestMapping(value="/addSite",method={RequestMethod.POST},produces={"application/json;charset=utf-8"})
	@ResponseBody
	public String addSite(HttpServletRequest request){
		//中文编码设置
		try {
			request.setCharacterEncoding("utf-8");
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		HttpSession session = request.getSession();
		User user = (User) session.getAttribute("user");
		Date date = new Date();
		SimpleDateFormat dateFormat1= new SimpleDateFormat("yyyy-MM-dd");
		String crtTime = dateFormat1.format(date);
		
		String name = request.getParameter("name");
		String phone = request.getParameter("phone");
		String sites = request.getParameter("site");
		Site site = new Site();
		site.setName(name);
		site.setPhone(phone);
		site.setSite(sites);
		site.setUserid(user.getId());
		site.setCrtTime(crtTime);
		site.setCrtBy(user.getId());
		int ret = ssi.addSite(site);
		return String.valueOf(ret);
	}
	/**
	 * 修改收货地址
	 * @param request
	 * @return 0,1
	 */
	@RequestMapping(value="/mdfSite",method={RequestMethod.POST},produces={"application/json;charset=utf-8"})
	@ResponseBody
	public String mdfSite(HttpServletRequest request){
		//中文编码设置
		try {
			request.setCharacterEncoding("utf-8");
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		HttpSession session = request.getSession();
		User user = (User) session.getAttribute("user");
		Date date = new Date();
		SimpleDateFormat dateFormat2= new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String mdfTime = dateFormat2.format(date);
		
		String name = request.getParameter("name");
		String phone = request.getParameter("phone");
		String sites = request.getParameter("site");
		Site site = new Site();
		site.setName(name);
		site.setPhone(phone);
		site.setSite(sites);
		site.setMdfTime(mdfTime);
		site.setMdfBy(user.getId());
		site.setUserid(user.getId());
		int ret = ssi.mdfSite(site);
		return String.valueOf(ret);
	}

	/**
	 * 删除收货地址
	 * @param request
	 * @return 0,1
	 */
	@RequestMapping(value="/delSite",method={RequestMethod.POST},produces={"application/json;charset=utf-8"})
	@ResponseBody
	public String delSite(HttpServletRequest request){
		int id = Integer.parseInt(request.getParameter("id"));
		int ret = ssi.delSite(id);
		return String.valueOf(ret);
	}
	
	
	
	
	
	
	
	
	
	
	
	
	//订单控制器
	/**
	 * 用户下单
	 * @param request
	 * @param respone
	 * @return
	 */
	@RequestMapping(value="/addOrder",method={RequestMethod.POST},produces={"application/json;charset=utf-8"})
	@ResponseBody
	public String addOrder(HttpServletRequest request, HttpServletResponse respone){
		//获取数据
		HttpSession session = request.getSession();
		User user = (User) session.getAttribute("user");
		Date date = new Date();
		SimpleDateFormat dateFormat1= new SimpleDateFormat("yyyy-MM-dd");
		String crtTime = dateFormat1.format(date);
		SimpleDateFormat dateFormat2= new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String payTime = dateFormat2.format(date);
		int siteid = ssi.getSiteidByUserid(user.getId());
		Order order = new Order();
		order.setUserid(user.getId());
		order.setSiteid(siteid);
		order.setFlowerid(Integer.parseInt(request.getParameter("id")));
		order.setNumber(Integer.parseInt(request.getParameter("number")));
		order.setPrice(Float.parseFloat(request.getParameter("price")));
		order.setCrtBy(user.getId());
		order.setCrtTime(crtTime);
		order.setPayTime(payTime);//支付业务省略
		
		int ret = osi.addOrder(order);
		return String.valueOf(ret);
	}
	/**
	 * 读取用户所有订单
	 * @param request
	 * @param respone
	 * @return
	 */
	@RequestMapping(value="/getAllOrderByUserid",method={RequestMethod.GET},produces={"application/json;charset=utf-8"})
	@ResponseBody
	public String getAllOrderByUserid(HttpServletRequest request, HttpServletResponse respone){
		HttpSession session = request.getSession();
		User user = (User) session.getAttribute("user");
		List<Order> order = osi.getAllOrderByUserid(user.getId());
		for(Order ord : order){
			List<Site> site = ssi.getSiteById(user.getId());
			Flower flower = fsi.getFlowerById(ord.getFlowerid());
			ord.setUser(user);
			ord.setSite(site.get(0));
			ord.setFlower(flower);
			ord.setOldprice(flower.getPrice());
			ord.setDiscount(flower.getDiscount());
			String resTime = ord.getResTime();
			String outTime = ord.getOutTime();
			String payTime = ord.getPayTime();
			if(resTime != null){
				ord.setState("已完成");
				ord.setDisBtn("评价");
			}
			else if(outTime != null){
				ord.setState("待收货");
				ord.setDisBtn("确认收货");
			}
			else if(payTime != null){
				ord.setState("已支付");
				ord.setDisBtn("催单");
			}
			else{
				ord.setState("待付款");
				ord.setDisBtn("去付款");
			}
			if( String.valueOf(flower.getDiscount()) != null && flower.getDiscount()!=0){
				ord.setDisCon(String.valueOf(flower.getDiscount()));
			}
			else ord.setDisCon("无");
		}
		String str=JSONArray.fromObject(order).toString();
		return str;
	}

	/**
	 * 获取所有待出库
	 * @return
	 */
	@RequestMapping(value="/getNeedOutOrder",method={RequestMethod.GET},produces={"application/json;charset=utf-8"})
	@ResponseBody
	public String getNeedOutOrder(){
		List<Order> order =  osi.getNeedOutOrder();
		for(Order ord : order){
			List<Site> site = ssi.getSiteById(ord.getUserid());
			Flower flower = fsi.getFlowerById(ord.getFlowerid());
			ord.setSite(site.get(0));
			ord.setFlower(flower);
		}
		String str=JSONArray.fromObject(order).toString();
		return str;
	}
	/**
	 * 出库订单
	 * @return
	 */
	@RequestMapping(value="/outOrder",method={RequestMethod.POST},produces={"application/json;charset=utf-8"})
	@ResponseBody
	public String outOrder(HttpServletRequest request){
		int id =Integer.parseInt(request.getParameter("orderid"));
		int ret = osi.outOrderById(id);
		return String.valueOf(ret);
	}
	
	
	
	
	
	
	
	
	
	/**
	 * MD5加密
	 * @param str
	 * @return
	 */
	public static String MD5(String str){  
        String reStr = null;  
        try {  
            MessageDigest md5 = MessageDigest.getInstance("MD5");  
            byte[] bytes = md5.digest(str.getBytes());  
            StringBuffer stringBuffer = new StringBuffer();  
            for (byte b : bytes){  
                int bt = b&0xff;  
                if (bt < 16){  
                    stringBuffer.append(0);  
                }   
                stringBuffer.append(Integer.toHexString(bt));  
            }  
            reStr = stringBuffer.toString();  
        } catch (NoSuchAlgorithmException e) {  
            e.printStackTrace();  
        }  
        return reStr;  
    } 
}

package action;

import java.util.List;

import org.apache.struts2.interceptor.validation.SkipValidation;

import com.opensymphony.xwork2.ModelDriven;

import dao.ICommodityDao;
import dao.impl.CommodityDao;
import entity.Commodity;
import entity.User;
import entity.UserState;
import service.IUserService;
import service.impl.LoginService;
import service.impl.LogoutService;
import service.impl.UserService;

public class UserAction extends SuperAction implements ModelDriven<User> {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private User user = new User();
	private int ustate;//用户在线状态
	private int NOTMEM = 0;//不是会员状态
	private int ISMEM = 1;//不是会员状态
	//用户登录
	public String userLogin() {
		System.out.println("执行userLogin()……");
		IUserService userS = new UserService();
		ICommodityDao cdao = new CommodityDao();
		System.out.println(user.toString());
		if (userS.userLogin(user)) {
			System.out.println(user.getUserPhone());
			int uid = userS.queryUserByPhone(user.getUserPhone());
			
			System.out.println("当前Id="+uid);
			
			user = userS.queryUserById(uid);
			List<Commodity> clist = cdao.selectCommodityAll();
			//在session中保存登录成功的用户名
			System.out.println("当前用户："+user.toString());
			session.setAttribute("loginUser", user);
			session.setAttribute("commodity_list", clist);
			return "user_login_success";
		}
		else {
			
			return "user_login_failure";
		}
	}
	
	
	//用户注册
	public String userRegiste() {
		System.out.println("执行userRegiste()……");
		IUserService userS = new UserService();
		String phone = user.getUserPhone();
		int rs = userS.queryUserByPhone(phone);
		if (rs<1) {
			user.setMenmber(NOTMEM);
			userS.userRegiste(user);
			return "user_registe_success";
		}
		else {
			return "user_registe_failure";
		}
	}
	
	//用户退出
	@SkipValidation
	public String userLogout() {
		if (session.getAttribute("loginUser")!=null) {
			
			session.removeAttribute("loginUser");
			session.removeAttribute("loginUser_order");
		}
		return "user_logout_success";
	}
	
//	//
//	@SkipValidation
	public String queryCommodity() {
		ICommodityDao dao = new CommodityDao();
		List<Commodity> clist = dao.selectCommodityAll();
		session.setAttribute("commodity_list", clist);
		return "query_Commodity_success";
	}
	
	//购买判断状态……状态模式
//	@SkipValidation
	public String userState() {
		//状态模式
		UserState state = new UserState();
		
		if (session.getAttribute("userLoginId")!=null) {
			state.setUserState(new LoginService());
		}
		else {
			state.setUserState(new LogoutService());
		}
		ustate = state.getUserState();
		
		if(ustate==1) {
			return "user_login_state";
		}
		else {
			return "user_logout_state";
		}
	}
	
	
	/*
	@Override
	public void validate() {
		// TODO Auto-generated method stub
		System.out.println("执行validate()……");
		int code = Integer.parseInt( request.getParameter("code"));
		if (user.getPassword().length()<6) {
			this.addFieldError("suppwErorr", "密码长度不能小于6位！");
		}
		if ("".equals(user.getUserPhone().trim())&&user.getUserPhone().length()!=11) {
			this.addFieldError("userPhoneErorr", "手机号错误！");
		}
		if (code==1) {
			if ("".equals(user.getUserName().trim())) {
				this.addFieldError("supnameErorr", "用户名不能为空！");
			}
		}
	}
	*/
	@Override
	public User getModel() {
		// TODO Auto-generated method stub
		return this.user;
	}

}

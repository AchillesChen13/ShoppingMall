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
	private int ustate;//�û�����״̬
	private int NOTMEM = 0;//���ǻ�Ա״̬
	private int ISMEM = 1;//���ǻ�Ա״̬
	//�û���¼
	public String userLogin() {
		System.out.println("ִ��userLogin()����");
		IUserService userS = new UserService();
		ICommodityDao cdao = new CommodityDao();
		System.out.println(user.toString());
		if (userS.userLogin(user)) {
			System.out.println(user.getUserPhone());
			int uid = userS.queryUserByPhone(user.getUserPhone());
			
			System.out.println("��ǰId="+uid);
			
			user = userS.queryUserById(uid);
			List<Commodity> clist = cdao.selectCommodityAll();
			//��session�б����¼�ɹ����û���
			System.out.println("��ǰ�û���"+user.toString());
			session.setAttribute("loginUser", user);
			session.setAttribute("commodity_list", clist);
			return "user_login_success";
		}
		else {
			
			return "user_login_failure";
		}
	}
	
	
	//�û�ע��
	public String userRegiste() {
		System.out.println("ִ��userRegiste()����");
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
	
	//�û��˳�
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
	
	//�����ж�״̬����״̬ģʽ
//	@SkipValidation
	public String userState() {
		//״̬ģʽ
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
		System.out.println("ִ��validate()����");
		int code = Integer.parseInt( request.getParameter("code"));
		if (user.getPassword().length()<6) {
			this.addFieldError("suppwErorr", "���볤�Ȳ���С��6λ��");
		}
		if ("".equals(user.getUserPhone().trim())&&user.getUserPhone().length()!=11) {
			this.addFieldError("userPhoneErorr", "�ֻ��Ŵ���");
		}
		if (code==1) {
			if ("".equals(user.getUserName().trim())) {
				this.addFieldError("supnameErorr", "�û�������Ϊ�գ�");
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

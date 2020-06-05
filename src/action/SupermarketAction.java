package action;

import org.apache.struts2.interceptor.validation.SkipValidation;

import com.opensymphony.xwork2.ModelDriven;

import entity.Supermarket;
import service.ISupService;
import service.impl.SupService;

public class SupermarketAction extends SuperAction implements ModelDriven<Supermarket> {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Supermarket sup = new Supermarket();
	
	//���е�¼
	public String supLogin() {
		System.out.println("action:"+sup.getSupId()+" "+sup.getSupName()+" "+sup.getSupPassword()+" "+sup.getSupPhone());
		ISupService supService = new SupService();
		System.out.println(supService.supLogin(sup));
		if (supService.supLogin(sup)) {
			//��session�б����¼�ɹ����û���
			session.setAttribute("loginSupName", sup.getSupName());
			return "sup_login_success";
		}
		else {
			
			return "sup_login_failure";
		}
	}
	
	
	//�����˳�
	@SkipValidation
	public String supLogout() {
		if (session.getAttribute("loginSupName")!=null) {
			session.removeAttribute("loginSupName");
		}
		return "sup_logout_success";
	}
	
	@Override
	public void validate() {
		// TODO Auto-generated method stub
		System.out.println("validate");
		if ("".equals(sup.getSupName().trim())) {
			this.addFieldError("supnameErorr", "�û�������Ϊ�գ�");
		}
		if (sup.getSupPassword().length()<6) {
			this.addFieldError("suppwErorr", "���볤�Ȳ���С��6λ��");
		}
	}
	
	@Override
	public Supermarket getModel() {
		// TODO Auto-generated method stub
		return this.sup;
	}

}

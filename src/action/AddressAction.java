package action;

import java.util.List;

import org.apache.struts2.interceptor.validation.SkipValidation;

import com.opensymphony.xwork2.ModelDriven;

import entity.Address;
import entity.User;
import service.IAddressService;
import service.impl.AddressService;

public class AddressAction extends SuperAction implements ModelDriven<Address> {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Address address = new Address();
	private User user = null;
	private int DEFALUT = 1;//��Ĭ�ϵ�ַ
	private int NOTDEFALUT = 0;//����Ĭ�ϵ�ַ
	private IAddressService service = new AddressService();
	
	//��ӵ�ַ
	public String addAddress() {
		System.out.println("ִ��addAddress()����");
		boolean inrs = false;//������
		user = (User) session.getAttribute("loginUser");//��õ�ǰ��¼���û�
		if (user!=null&&address!=null) {
			address.setUserId(user.getUserId());
			List<Address> addlist = service.selectAddressByUserId(user.getUserId());
			//�û�δ��ӵ�ַ����һ��ΪĬ�ϵ�ַ
			if (addlist.size()>0) {
				address.setIsDefault(NOTDEFALUT);
			}
			else {
				address.setIsDefault(DEFALUT);
			}
			inrs = service.insertAddress(address);
			List<Address> addList =  service.selectAddressByUserId(user.getUserId());
			session.setAttribute("addrlist", addList);
		}
		if (inrs) {
			return "add_address_success";
		}
		else {
			return "add_address_failure";
		}
	}
	
	//��ѯȫ����ַ
	public String queryAllAddress() {
		System.out.println("ִ��queryAllAddress()����");
		user = (User) session.getAttribute("loginUser");
		System.out.println(user);
		if (user!=null) {
			List<Address> addList =  service.selectAddressByUserId(user.getUserId());
			session.setAttribute("addrlist", addList);
			return "query_address_success";
		}
		else {
			return "query_address_failure";
		}
	}
	
	//ɾ����ַ
	public String deleteAddress() {
		System.out.println("ִ��deleteAddress()����");
		int aId = Integer.parseInt(request.getParameter("addressNo"));
		System.out.println(aId);
		if (aId!=0) {
			service.deleteAddressById(aId);
			session.removeAttribute("addrlist");
			user = (User) session.getAttribute("loginUser");
			List<Address> addList =  service.selectAddressByUserId(user.getUserId());
			session.setAttribute("addrlist", addList);
			return "delete_address_success";
		}
		else {
			return "delete_address_failure";
		}
		
	}
	
	
	
	
	@Override
	public Address getModel() {
		// TODO Auto-generated method stub
		return this.address;
	}
}

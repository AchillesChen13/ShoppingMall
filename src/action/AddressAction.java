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
	private int DEFALUT = 1;//是默认地址
	private int NOTDEFALUT = 0;//不是默认地址
	private IAddressService service = new AddressService();
	
	//添加地址
	public String addAddress() {
		System.out.println("执行addAddress()……");
		boolean inrs = false;//插入结果
		user = (User) session.getAttribute("loginUser");//获得当前登录的用户
		if (user!=null&&address!=null) {
			address.setUserId(user.getUserId());
			List<Address> addlist = service.selectAddressByUserId(user.getUserId());
			//用户未添加地址，第一个为默认地址
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
	
	//查询全部地址
	public String queryAllAddress() {
		System.out.println("执行queryAllAddress()……");
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
	
	//删除地址
	public String deleteAddress() {
		System.out.println("执行deleteAddress()……");
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

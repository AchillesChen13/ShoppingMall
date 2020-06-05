package action;

import java.util.List;

import org.apache.struts2.interceptor.validation.SkipValidation;

import com.opensymphony.xwork2.ModelDriven;

import dao.ITypeDao;
import dao.impl.TypeDao;
import entity.CommodityType;
import model.TypeCommandAdd;
import model.TypeCommandModify;
import model.TypeCommand;
import model.TypeInvoker;
import service.ITypeService;
import service.impl.TypeService;

public class TypeAction extends SuperAction implements ModelDriven<CommodityType> {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private CommodityType type = new CommodityType();
	private TypeInvoker invoker = new TypeInvoker();
	private ITypeService typeService = new TypeService();
	private TypeCommand command;
	
	//命令模式：命令一(增加商品命令)
	//增加商品类型
	public String addType() {
		System.out.println("执行addType()……");
		
		ITypeDao dao = new TypeDao();
		type.getTypeName();
		
		if (type.getTypeName()!=null) {
			command = new TypeCommandAdd(typeService);
			invoker.setCommand(command);
			invoker.startExcuteCommand(type);
			return "add_type_success";
		}
		else {
			
			return "add_type_failure";
		}
	}
	
	//查询所有商品类型
	public String queryAllType() {
		System.out.println("执行queryAllType()……");
		int tcode = 0;
		List<CommodityType> tplsit = typeService.queryCommodityType();
		tcode = Integer.parseInt(request.getParameter("tcode"));
		session.setAttribute("type_list", tplsit);
		if (tcode!=1) {
			return "query_type_success";
		}
		else {
			return "query_type_failure";
		}
	}
	
	//查询商品类型通过商品编号
	public String queryTypeById() {
		int typeNo = Integer.parseInt(request.getParameter("typeNo"));
		type = typeService.queryCommodityTypeById(typeNo);
		session.setAttribute("type", type);
		System.out.println(type);
		return "query_typeOne_success";
	}
	
	//命令模式：命令二(修改商品命令)
	//修改类型
	public String modifyType() {
		
		if (type!=null) {
			command = new TypeCommandModify(typeService);
			invoker.setCommand(command);
			invoker.startExcuteCommand(type);
			
			List<CommodityType> tplsit = typeService.queryCommodityType();
			session.setAttribute("type_list", tplsit);
			
			return "modify_type_success";
		}
		else {
			return "modify_type_failure";
		}
	}
	
	@Override
	public CommodityType getModel() {
		// TODO Auto-generated method stub
		return this.type;
	}

}

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
	
	//����ģʽ������һ(������Ʒ����)
	//������Ʒ����
	public String addType() {
		System.out.println("ִ��addType()����");
		
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
	
	//��ѯ������Ʒ����
	public String queryAllType() {
		System.out.println("ִ��queryAllType()����");
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
	
	//��ѯ��Ʒ����ͨ����Ʒ���
	public String queryTypeById() {
		int typeNo = Integer.parseInt(request.getParameter("typeNo"));
		type = typeService.queryCommodityTypeById(typeNo);
		session.setAttribute("type", type);
		System.out.println(type);
		return "query_typeOne_success";
	}
	
	//����ģʽ�������(�޸���Ʒ����)
	//�޸�����
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

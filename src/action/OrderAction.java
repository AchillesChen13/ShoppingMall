package action;

import java.util.List;

import com.opensymphony.xwork2.ModelDriven;

import dao.ICommodityDao;
import dao.IOrderDao;
import dao.impl.CommodityDao;
import dao.impl.OrderDao;
import entity.Address;
import entity.CartTest;
import entity.Commodity;
import entity.OrderDB;
import entity.Supermarket;
import entity.User;
import model.AbstractTemplate;
import model.BuyTemplate;
import model.CancleTemplate;
import model.OrderCancleState;
import model.OrderCartState;
import model.OrderNormalState;
import model.StateContext;
import model.TemContext;
import service.IAddressService;
import service.ICommodityService;
import service.IDealStateService;
import service.IOrderService;
import service.impl.AddressService;
import service.impl.CommodityService;
import service.impl.HaveAcceptService;
import service.impl.MemberCashService;
import service.impl.NormalCashService;
import service.impl.OrderService;
import service.impl.WaitingAcceptService;
import service.impl.WaitingDealService;
import service.impl.WaitingSendService;

public class OrderAction extends SuperAction implements ModelDriven<OrderDB> {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private OrderDB order = new OrderDB();
	private IOrderService service = new OrderService();
	private ICommodityService cservice = new CommodityService();
	private IAddressService addressService = new AddressService();
	private StateContext stateContext = new StateContext();
	private AbstractTemplate template;
	
	private int NOTMEN = 0;
	private Commodity comm = null;
	private IDealStateService waitDeal,waitSend,waitAccept,haveEnd;

	// 增加订单
	public String addOrder() {
		System.out.println("执行addOrder()……");
		User loginUser = (User) session.getAttribute("loginUser");
		System.out.println("loginUser=  " + loginUser.toString());
		if (loginUser.getUserName() == null && "".equals(loginUser.getUserName())) {
			session.setAttribute("nameNull", "null");
			return "username_null";
		} else {
			String num = request.getParameter("buyNum1");
			if ("".equals(num) || num == null) {
				num = "0";
			}

			int buyNum = Integer.parseInt(num);

			String cno = (String) request.getParameter("buycno");
			comm = cservice.selectCommodityById(cno);
			TemContext context = new TemContext();
			Address address = addressService.selectAddressByDefalutId(loginUser.getUserId(), 1);
			
			if (address!=null) {
				if (buyNum < comm.getStock()) {
					order.setNum(buyNum);

					if (loginUser.getMenmber() != NOTMEN) {
						context.setDiscount(new MemberCashService());
						order.setSumPrice(context.getSumPrice(comm.getPrice(), buyNum));
					} else {
						context.setDiscount(new NormalCashService());
						order.setSumPrice(context.getSumPrice(comm.getPrice(), buyNum));
					}
					order.setUserId(loginUser.getUserId());
					order.setGoodsName(comm.getCommodityName());
					System.out.println(address);
					order.setRecipeName(address.getName());
					order.setRecipePhone(address.getPhone());
					order.setRecipeAddre(address.getAddress());
					order.setCommodityNo(comm.getCommodityNo());
					
					//设置订单正常交易的状态
					stateContext.setDealState(new OrderNormalState(order));
					stateContext.setOrderState();
					
					
					//模板方法改变库存,买是减少库存
					template = new BuyTemplate(comm,cservice,buyNum);
					template.changeStock();
					
					//查询所有订单
					List<OrderDB> orderList = service.selectOrderByUid(loginUser.getUserId());
					session.setAttribute("loginUser_order", orderList);
					return "ordering_success";
					
				} else {
					session.setAttribute("stockError", "null");
					return "stock_error";
				}
			}
			else {
				session.setAttribute("addressNull", "null");
				return "address_error";
			}
		}
	}

	//订单管理
	public String manageOrder() {
		System.out.println("执行manageOrder()……");
		String sup = (String) session.getAttribute("loginSupName");
		int orderNo = Integer.parseInt(request.getParameter("orderNo"));
		System.out.println(orderNo);
		String state = request.getParameter("orderState");
		if (sup!=null) {
			waitDeal = new WaitingDealService();
			waitSend = new WaitingSendService();
			waitAccept = new WaitingAcceptService();
			haveEnd = new HaveAcceptService();
			
			waitDeal.setNextState(waitSend);
			waitSend.setNextState(waitAccept);
			waitAccept.setNextState(haveEnd);
			haveEnd.setNextState(null);
			
			System.out.println(12);
			waitDeal.requestState(orderNo, state);
			waitSend.requestState(orderNo, state);
			waitAccept.requestState(orderNo, state);
			haveEnd.requestState(orderNo, state);
			List<OrderDB> list = queryOrder(state);
			session.setAttribute("stateList", list);
			return "manage_order_success";
		}
		else {
			return "manage_order_fialure";
		}
	}
	
	//查询订单状态
	public String queryOrder() {
		List<OrderDB> dbs = service.selectOrderAll();
		session.setAttribute("dbs", dbs);
		return "query_allorder_success";
	}
	
	//查询订单状态
	public String queryOrderByState() {
		int orderStateCode = Integer.parseInt(request.getParameter("orderStateCode"));
		String state =null;
		if (orderStateCode==1) {
			state = "待处理";
		}
		if (orderStateCode==2) {
			state = "待配送";
		}
		if (orderStateCode==3) {
			state = "待收货";
		}
		if (orderStateCode==4) {
			state = "订单已结束";
		}
		List<OrderDB> list = queryOrder(state);
		session.setAttribute("dbs", list);
		return "query_orderstate_success";
	}
	
	public List<OrderDB> queryOrder(String state){
		return service.queryOrderByState(state);
	}
	
	
	//修改订单状态
	public String modifyOrder() {
		int oId = Integer.parseInt(request.getParameter("orderNo"));
		String state = request.getParameter("orderState");
		User loginUser = (User) session.getAttribute("loginUser");
		
		int buyNum = (int) service.queryOrderByOid(oId).getNum();
		comm = cservice.selectCommodityById(service.queryOrderByOid(oId).getCommodityNo());
		
		order.setOrderNo(oId);
		order.setStatus(state);
		
		//设置订单取消交易的状态
		stateContext.setDealState(new OrderCancleState(order));
		stateContext.setOrderState();
		
		//模板方法改变库存,取消增加库存
		template = new CancleTemplate(comm,cservice,buyNum);
		template.changeStock();
		
		
		flushOrder(loginUser);
		return "modify_order_success";
	}

	// 查询个人全部订单
	public String queryAllOrder() {
		List<OrderDB> orderList = null;
		String userName = null;
		User loginUser = (User) session.getAttribute("loginUser");
		if (loginUser != null) {
			userName = loginUser.getUserName();
		}
		if (userName != null) {
			orderList = service.selectOrderByUid(loginUser.getUserId());
			session.setAttribute("loginUser_order", orderList);
			return "query_order_success";
		} else {
			return "query_order_failure";
		}
	}
	
	//查询订单详情
	public String queryOrderDetail() {
		int oId = Integer.parseInt(request.getParameter("orderNo"));
		OrderDB db = service.queryOrderByOid(oId);
		session.setAttribute("orderDB", db);
		return "query_orderDB_success";
	}
	
	//查询订单信息
	public void flushOrder(User loginUser) {
		List<OrderDB> orderList = service.selectOrderByUid(loginUser.getUserId());
		session.setAttribute("loginUser_order", orderList);
	}
	
	@Override
	public OrderDB getModel() {
		// TODO Auto-generated method stub
		return this.order;
	}

}

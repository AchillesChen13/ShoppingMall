package action;

import java.util.List;
import java.util.Map;
import java.util.Set;

import com.opensymphony.xwork2.ModelDriven;

import entity.Address;
import entity.Cart;
import entity.CartDetail;
import entity.Commodity;
import entity.OrderDB;
import entity.User;
import model.AbstractTemplate;
import model.BuyTemplate;
import model.OrderNormalState;
import model.StateContext;
import model.TemContext;
import service.IAddressService;
import service.ICartService;
import service.ICommodityService;
import service.IOrderService;
import service.impl.AddressService;
import service.impl.CartService;
import service.impl.CommodityService;
import service.impl.MemberCashService;
import service.impl.NormalCashService;
import service.impl.OrderService;

public class CartAction extends SuperAction implements ModelDriven<CartDetail> {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private CartDetail cartDetail = new CartDetail();
	private Commodity comm = new Commodity();
	private ICommodityService cService = new CommodityService();
	private ICartService cartService = new CartService();
	private IOrderService orderService = new OrderService();
	private IAddressService addressService = new AddressService();
	private StateContext stateContext = new StateContext();
	private AbstractTemplate template;
	
	private int NOTMEN = 0;
	private	TemContext temContext = new TemContext();
	
	// ��ӹ��ﳵ
	public String addInCart() {
		
		System.out.println("ִ��addInCart()����");
		String num = request.getParameter("buyNum");
		String commodityNo = request.getParameter("buycno");
		if (num == null && "".equals(num)) {
			num = "0";
		}
		User loginUser = (User) session.getAttribute("loginUser");
		int buyNum = Integer.parseInt(num);
		if (commodityNo != null && loginUser != null) {
			comm = cService.selectCommodityById(commodityNo);
			cartDetail.setBuyNum(buyNum);
			cartDetail.setCommodityNo(commodityNo);
			cartDetail.setUserId(loginUser.getUserId());
			
			if (cartService.addCommodityInCart(cartDetail)) {
				Cart cart = new Cart();
				List<CartDetail> cartDetails = cartService.queryCartByUid(loginUser.getUserId());
				for (CartDetail detail : cartDetails) {
					Commodity comm = cService.selectCommodityById(detail.getCommodityNo());
					cart.addGoodsInCart(comm, detail.getBuyNum());
				}

				double totalPrice = cart.calTotalPrice();

				session.setAttribute("cart", cart);
				session.setAttribute("totalPrice", totalPrice);
				
				return "add_cart_success";
			} else {
				return "add_cart_failure";
			}
		} else {
			return "add_cart_failure";
		}
	}

	// �ӹ��ﳵ���Ƴ�
	public String removeFromCart() {

		User loginUser = (User) session.getAttribute("loginUser");
		String commodityNo = request.getParameter("commodityNo");

		if (loginUser != null && commodityNo != null) {
			cartDetail.setCommodityNo(commodityNo);
			cartDetail.setUserId(loginUser.getUserId());
			if (cartService.removeCommodityFromCart(cartDetail)) {
				flushCart(loginUser);
				return "remove_cart_success";
			} else {
				return "remove_cart_failure";
			}
		} else {
			return "remove_cart_failure";
		}
	}

	// ��ʾ���ﳵ
	public String displayCart() {

		User loginUser = (User) session.getAttribute("loginUser");

		if (loginUser != null) {
			Cart cart = new Cart();
			List<CartDetail> cartDetails = cartService.queryCartByUid(loginUser.getUserId());
			for (CartDetail detail : cartDetails) {
				Commodity comm = cService.selectCommodityById(detail.getCommodityNo());
				cart.addGoodsInCart(comm, detail.getBuyNum());
			}

			double totalPrice = cart.calTotalPrice();

			session.setAttribute("cart", cart);
			session.setAttribute("totalPrice", totalPrice);

			return "display_cart_success";
		} else {
			return "display_cart_failure";
		}
	}

	
	//���ع��ﳵ
	public void flushCart(User loginUser) {
		Cart cart = new Cart();
		List<CartDetail> cartDetails = cartService.queryCartByUid(loginUser.getUserId());
		for (CartDetail detail : cartDetails) {
			Commodity comm = cService.selectCommodityById(detail.getCommodityNo());
			cart.addGoodsInCart(comm, detail.getBuyNum());
		}

		double totalPrice = cart.calTotalPrice();

		session.setAttribute("cart", cart);
		session.setAttribute("totalPrice", totalPrice);
	}
	
	//���㹺�ﳵ
	public String payCart() {
		
		Cart cart = (Cart) session.getAttribute("cart");
		User loginUser = (User) session.getAttribute("loginUser");
		if (cart!=null&&loginUser!=null) {
			Set<Map.Entry<Commodity, Integer>> items= cart.getGoods().entrySet();
			for(Map.Entry<Commodity, Integer> obj:items)
			{
				OrderDB order = new OrderDB();
//				System.out.println(obj.getKey().getCommodityName());
				order.setNum(obj.getValue());
				order.setGoodsName(obj.getKey().getCommodityName());
				order.setUserId(loginUser.getUserId());
				
				
				if (loginUser.getMenmber() != NOTMEN) {
					//���Է���һ����Ա����۸�
					temContext.setDiscount(new MemberCashService());
					order.setSumPrice(temContext.getSumPrice(obj.getKey().getPrice(), obj.getValue()));
				} else {
					//���Է��������ǻ�Ա����۸�
					temContext.setDiscount(new NormalCashService());
					order.setSumPrice(temContext.getSumPrice(obj.getKey().getPrice(), obj.getValue()));
				}
				order.setUserId(loginUser.getUserId());
				order.setGoodsName(obj.getKey().getCommodityName());
				Address address = addressService.selectAddressByDefalutId(loginUser.getUserId(), 1);
				if (address!=null) {
					order.setRecipeName(address.getName());
					order.setRecipePhone(address.getPhone());
					order.setRecipeAddre(address.getAddress());
					
					//���ö������������ģʽ
					stateContext.setDealState(new OrderNormalState(order));
					stateContext.setOrderState();
					
					//���ٿ��
					template = new BuyTemplate(obj.getKey(),cService,obj.getValue());
					template.changeStock();
					
					//��չ��ﳵ��
					cartDetail.setUserId(loginUser.getUserId());
					cartDetail.setCommodityNo(obj.getKey().getCommodityNo());
					cartService.removeCommodityFromCart(cartDetail);
				}
				//��ѯ���ж���
				List<OrderDB> orderList = orderService.selectOrderByUid(loginUser.getUserId());
				session.setAttribute("loginUser_order", orderList);
				flushCart(loginUser);
			}
			return "pay_cart_success";
		}
		else {
			return "pay_cart_failure";
		}
	}
	
	
	@Override
	public CartDetail getModel() {
		// TODO Auto-generated method stub
		return this.cartDetail;
	}
}

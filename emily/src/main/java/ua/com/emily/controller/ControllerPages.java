package ua.com.emily.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import ua.com.emily.domain.Cart;
import ua.com.emily.domain.Product;
import ua.com.emily.domain.Transporter;
import ua.com.emily.domain.Type;
import ua.com.emily.domain.Users;
import ua.com.emily.service.CartService;
import ua.com.emily.service.ProductService;
import ua.com.emily.service.TransporterService;
import ua.com.emily.service.TypeService;
import ua.com.emily.service.UsersService;
/**
 * Controller for users pages:
 *    loginPage.jsp; 
 *    index.jsp; 
 *    newUser.jsp; 
 *    emailsender.jsp; 
 *    descriptionProducts.jsp; 
 *    ordering.jsp.
 * 
 * @return
 * 
 * @author Tanskiy R.
 */
@Controller
public class ControllerPages {
	
	@Autowired
	private UsersService service;
	
	@Autowired
	private ProductService productService;
	
	@Autowired
	private TypeService typeService;
	
	@Autowired
	private CartService cartService;
	
	@Autowired
	private TransporterService transService;

	@RequestMapping(value="/loginPage") 
	public String loginPage(ModelMap model) {
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		String username = auth.getName();
		Users user = service.findByEmail(username);
		model.put("aloha", user);
		return "users/loginPage";
}
	
	@RequestMapping(value="/" ) 
	public String start() {
		
		
		return "redirect:/index";
}
	
	@RequestMapping(value="/index") 
	public String index(ModelMap model) {
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		String username = auth.getName();
		Users user = service.findByEmail(username);
		model.put("aloha", user);
		List<Product> products = productService.getAllProducts();
		List<Type> types = typeService.getAllTypes();
		model.addAttribute("allProducts", products);
		model.addAttribute("allType", types);
		
		
		return "users/index";
}
	
	
	@RequestMapping(value="/newUser" ) 
	public String newUser() {
		
		return "users/newUser";
}
	
	@RequestMapping(value = "/newUser", method = RequestMethod.POST)
	public String newUser2(
			@RequestParam(value = "emailUser") String emailUser,
			@RequestParam(value = "passwordUsers") String passwordUsers,
			@RequestParam(value = "passwordUserRepeat") String passwordUserRepeat,
			@RequestParam(value = "nameUsers") String nameUsers,
			@RequestParam(value = "telephoneNumberUsers") String phoneNumberUsers,
			@RequestParam(value = "cityUsers") String cityUsers, 
			@RequestParam(value = "adressUsers") String adressUsers)
	
	{
		
			if (passwordUsers.equals(passwordUserRepeat)) {
			if (service.findByEmail(emailUser) == null) {
				
				service.createUsers(nameUsers, emailUser, phoneNumberUsers, cityUsers, adressUsers, passwordUsers);
				return "redirect:/loginPage?reg=success";
			} else {
				return "redirect:/newUser?reg=userduplicate";
			}
		} else {
			return "redirect:/newUser?reg=wrongpass";
		}
	}
	
	@RequestMapping(value="/emailsender" ) 
	public String emailsender(ModelMap model) {
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		String username = auth.getName();
		Users user = service.findByEmail(username);
		model.put("aloha", user);
		return "users/emailsender";
		
}
	
	@RequestMapping(value="/description/{productIdProduct}")
	public String descriptionPageGet(@PathVariable String productIdProduct, Model model)
	{
		int idProduct = Integer.parseInt(productIdProduct);
		model.addAttribute("product", productService.findById(idProduct));
		return "users/descriptionProducts";
	}
	
	
	
	@RequestMapping(value="/description/{productIdProduct}", method = RequestMethod.POST)
	public String orderingProduct(@PathVariable String productIdProduct,
			@RequestParam(value = "count") String countProduct, HttpServletRequest req) {
		
		int idProduct = Integer.parseInt(productIdProduct);
		int count = Integer.parseInt(countProduct);
		
				
		HttpSession ses = req.getSession(true);
		String s = ses.getId();
		
		if(count>0){
			
			
			
		cartService.createCart(productService.findById(idProduct), count, s);
		
		return "redirect:/description/{productIdProduct}?cart=addCart";
		}else {
			return "redirect:/description/{productIdProduct}?cart=null";
		}
		
	}
	
	
	@RequestMapping(value="/ordering") 
	public String orderingPage(ModelMap model, Model model2, HttpServletRequest req) {
		
		HttpSession ses = req.getSession(false);
		String s = ses.getId();
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		String username = auth.getName();
		Users user = service.findByEmail(username);
		model.put("aloha", user);
		List<Cart> carts = cartService.getCartsSession(s);
		if(carts.isEmpty()) {
			String str = "Ви не обрали жодного товару.";
			model.put("cartNull", str);
		}
		
		
		List<Transporter> transports = transService.getAllTransporter();
		model2.addAttribute("allTransporter", transports);
		model.put("carts", carts);
		
		
		return "users/ordering";
}
	
		
	@RequestMapping(value = "deleteCart/{cartIdCart}", method = RequestMethod.GET )
	public String deleteCart(@PathVariable String cartIdCart) {
		int id = Integer.parseInt(cartIdCart);
		cartService.deleteCart(id);
		return "redirect:/ordering";
		
	}
	

	
}

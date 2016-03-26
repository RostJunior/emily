package ua.com.emily.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;



import ua.com.emily.domain.Product;
import ua.com.emily.domain.Purchase;
import ua.com.emily.domain.Roles;
import ua.com.emily.domain.Transporter;
import ua.com.emily.domain.Type;
import ua.com.emily.domain.Users;
import ua.com.emily.service.ProductService;
import ua.com.emily.service.PurchaseService;
import ua.com.emily.service.RolesService;
import ua.com.emily.service.TransporterService;
import ua.com.emily.service.TypeService;
import ua.com.emily.service.UsersService;

/**
 * Controller for admin pages:
 *     personalAccount.jsp;
 *     dostavka.jsp;
 *     adminProduct.jsp;
 *     usersList.jsp;
 *     showProductList.jsp;
 *     editProductPage.jsp;
 *     adminOrders.jsp;
 * 
 * @return
 * 
 * @author Tanskiy R.
 */

@Controller
public class ControllerAdminPage {
	
	@Autowired
	private TransporterService transService;

	@Autowired
	private UsersService userService;
	
	@Autowired
	private RolesService roleService;
	
	@Autowired
	private ProductService productService;
	
	@Autowired
	private TypeService typeService;
	
	@Autowired
	private PurchaseService orders;
	
	
	@RequestMapping(value="/personalAccount" ) 
	public String adminPage() {
		
		return "securedAdmin/personalAccount";
}
	
	@RequestMapping(value="/dostavka") 
	public String getAlldostavka(Model model) {
		List<Transporter> transports = transService.getAllTransporter();
		model.addAttribute("allTransporter", transports);

		return "securedAdmin/dostavka";
}

	
	@RequestMapping(value = "/newTransporter", method = RequestMethod.POST) 
	public String createTransporter(
			@RequestParam(value = "nameTrans") String nameTransporter,
			@RequestParam(value = "cost") String cost
			) {
		int costInt = Integer.parseInt(cost);
		transService.createTransporter(nameTransporter, costInt);
		return "redirect:/dostavka";
	}
	

	
	@RequestMapping(value = "dostavka/{transportIdTransporter}", method = RequestMethod.GET )
	public String deleteTransporter(@PathVariable String transportIdTransporter) {
		int id = Integer.parseInt(transportIdTransporter);
		transService.deleteTransporter(id);
		return "redirect:/dostavka";
		
	}
	
	
	
	@RequestMapping(value = "editTransporter", method = RequestMethod.POST)
	public String editTransporterPost( 
	@RequestParam(value = "idTrans") String idTrans,
	@RequestParam(value = "newName") String newName,
	@RequestParam(value = "newCost") String newCost) {
		int id = Integer.parseInt(idTrans);
		int cost = Integer.parseInt(newCost);
		transService.updateTransporter(id, newName, cost);
		return "redirect:/dostavka";
	}
	
	@RequestMapping(value = "/usersList")
	public String usersList(Model model) {
		List<Users> users = userService.getAllUsers();
		List<Roles> roles = roleService.getAllRoles();
		model.addAttribute("allUsers", users);
		model.addAttribute("allRoles", roles);
		
		return "securedAdmin/usersList";
	}
	
	@RequestMapping(value = "usersList/{forUsersIdUsers}")
	public String deleteUser(@PathVariable String forUsersIdUsers) {
		int idUser = Integer.parseInt(forUsersIdUsers);
		userService.deleteUsers(idUser);
		return "redirect:/usersList";
	}
	
	@RequestMapping(value="/newUsers", method = RequestMethod.POST)
	public String createUser(
			@RequestParam(value = "nameUser") String nameUser,
			@RequestParam(value = "cityUser") String cityUser,
			@RequestParam(value = "adressUser") String adressUser,
			@RequestParam(value = "telephoneUser") String telephoneUser,
			@RequestParam(value = "emailUser") String emailUser,
			@RequestParam(value = "passwordUser") String passwordUser,
			@RequestParam(value = "idRole") String idRole
			) {
		int idRoles = Integer.parseInt(idRole);
		userService.createUsersById(nameUser, emailUser, telephoneUser, cityUser, adressUser, passwordUser, roleService.findByIdRoles(idRoles));
		
		return "redirect:/usersList";
	}
	
	@RequestMapping(value="/newRole", method = RequestMethod.POST)
	public String createRole(
			@RequestParam(value = "nameRole") String nameRole			
			) {
		
		roleService.createRoles(nameRole);
		return "redirect:/usersList";
	}
	
	

	@RequestMapping(value="editUsers/{forUsersIdUsers}") 
	public String editBookGet(@PathVariable String forUsersIdUsers, Model model) {
		
		int id = Integer.parseInt(forUsersIdUsers);
		model.addAttribute("user", userService.findByIdUsers(id));
		List<Users> users = userService.getAllUsers();
		List<Roles> roles = roleService.getAllRoles();
		model.addAttribute("allUsers", users);
		model.addAttribute("allRoles", roles);
		return "securedAdmin/usersList";
	}
	
	@RequestMapping(value="/editUsers/editUsers/*")
			public String editBookErr(){
			return "redirect:/usersList?reg=wrong";
	}
	
	@RequestMapping(value="/edit/")
	public String editBookErrNoEdit(){
	return "redirect:/usersList";
}
	
	@RequestMapping(value = "editUsers/edit/{userIdUsers}", method = RequestMethod.POST)
	public String editUsersPost(@PathVariable String userIdUsers, 
			@RequestParam(value = "nameUser") String nameUser,
			@RequestParam(value = "cityUser") String cityUser,
			@RequestParam(value = "adressUser") String adressUser,
			@RequestParam(value = "telephoneUser") String telephoneUser,
			@RequestParam(value = "emailUser") String emailUser,
			@RequestParam(value = "passwordUser") String passwordUser,
			@RequestParam(value = "idRole") String idRole			
			) {
		int idUser = Integer.parseInt(userIdUsers);
		int idRoles = Integer.parseInt(idRole);
		
		userService.updateUsers(idUser, nameUser, emailUser, telephoneUser, cityUser, adressUser, passwordUser, roleService.findByIdRoles(idRoles));
		
		return "redirect:/usersList";
	}
	
	@Secured("hasRole('Admin')")
	@RequestMapping(value="/adminProduct")
	public String adminProductTo(Model model){
	List<Type> types = typeService.getAllTypes();
	model.addAttribute("allTypes", types);
	return "securedAdmin/adminProduct";
	}
	
	@RequestMapping(value = "/newType", method = RequestMethod.POST)
	public String newTypePost(@RequestParam (value="nameType") String type){
		typeService.createType(type);
		
		return "redirect:/adminProduct";
		
	}
	
	@RequestMapping(value = "deleteType/{typelistIdType}")
	public String deleteType(@PathVariable String typelistIdType){
		int typeId = Integer.parseInt(typelistIdType);
		typeService.deleteType(typeId);
		
		return "redirect:/adminProduct";
		
	}
	
	@RequestMapping(value = "/newProduct", method = RequestMethod.POST)
	public String newProduct(
			@RequestParam(value = "nameProduct") String nameProduct,
			@RequestParam(value = "priceProduct") String priceProduct,
			@RequestParam(value = "description") String description,
			@RequestParam(value = "idType") String idType,
			@RequestParam(value = "pictureArray", required = false) MultipartFile uploadedFile
			){
		
		int price = Integer.parseInt(priceProduct);
		int idtype = Integer.parseInt(idType);
		
		if (!ProductImageUpload.getFileName(uploadedFile).isEmpty()) {
			String imageName = ProductImageUpload.getFileName(uploadedFile);
			productService.createProduct(nameProduct, price, imageName, typeService.findByIdType(idtype), description);
			ProductImageUpload.fileUpload(uploadedFile);
		} else if (ProductImageUpload.getFileName(uploadedFile).isEmpty()) {
			String imageName = "NoPhoto.png";
			productService.createProduct(nameProduct, price, imageName, typeService.findByIdType(idtype), description);
		}
		
		
		return "redirect:/adminProduct";
	}
	
	@RequestMapping(value="/showProductList")
	public String showProductTo(Model model){
	List<Product> products = productService.getAllProducts();
	model.addAttribute("allProducts", products);
	return "securedAdmin/adminProductList";
	}
	
	@RequestMapping(value = "deleteProduct/{productsIdProduct}")
	public String deleteProduct(@PathVariable String productsIdProduct) {
		int idProduct = Integer.parseInt(productsIdProduct);
		productService.deleteProduct(idProduct);
		return "redirect:/showProductList";
	}
	
	
	
	@RequestMapping(value="editProduct/{productsIdProduct}") 
	public String editProductGet(@PathVariable String productsIdProduct, Model model) {
		int idProduct = Integer.parseInt(productsIdProduct);
		List<Type> type = typeService.getAllTypes();
		model.addAttribute("editProduct", productService.findById(idProduct));
		model.addAttribute("allTyps", type);
		return "securedAdmin/editProductPage";
	}
	
	
	

	@RequestMapping(value = "editProduct/{editProductIdProduct}", method = RequestMethod.POST)
	public String editProductPost(@PathVariable String editProductIdProduct, 
			@RequestParam(value = "newNameProduct") String nameProduct,
			@RequestParam(value = "newPriceProduct") String priceProduct,
			@RequestParam(value = "newdescription") String newdescription,
			@RequestParam(value = "newIdType") String idType,
			@RequestParam(value = "pictureArrays", required = false) MultipartFile uploadedFile
					
			) {
		
		int idProduct = Integer.parseInt(editProductIdProduct);
		int idTyp = Integer.parseInt(idType);
		int price = Integer.parseInt(priceProduct);
		
		
		if (!ProductImageUpload.getFileName(uploadedFile).isEmpty()) {
			
			String newImageName = ProductImageUpload.getFileName(uploadedFile);
			
			productService.updateProduct(idProduct, nameProduct, price, typeService.findByIdType(idTyp), newImageName, newdescription);
						
			ProductImageUpload.fileUpload(uploadedFile);
			
		} else if (ProductImageUpload.getFileName(uploadedFile).isEmpty()) {
			
			String namePhoto = uploadedFile.getName();
			
			productService.updateProduct(idProduct, nameProduct, price, typeService.findByIdType(idTyp), namePhoto, newdescription);
		}
		
		return "redirect:/showProductList";
	}
	
	@RequestMapping(value="/home") 
	public String testHome(Model model) {
		List<Product> products = productService.getAllProducts();
		List<Type> types = typeService.getAllTypes();
		model.addAttribute("allProducts", products);
		model.addAttribute("allType", types);
		return "other/home";
	}
	
	@RequestMapping(value="/adminOrders") 
	public String orderPage(Model model) {
		List<Purchase> orderList = orders.getAllPurchases();
		model.addAttribute("allOrders", orderList);
		
		return "securedAdmin/adminOrders";
		
	}
	
	@RequestMapping(value = "deleteOrder/{orderIdPurchase}")
	public String deleteOrder(@PathVariable String orderIdPurchase) {
		int idOrder = Integer.parseInt(orderIdPurchase);
		orders.deletePurchase(idOrder);
		return "redirect:/adminOrders";
	}
	
}

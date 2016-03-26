package ua.com.emily.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import ua.com.emily.domain.Cart;
import ua.com.emily.domain.Roles;
import ua.com.emily.domain.Transporter;
import ua.com.emily.domain.Users;
import ua.com.emily.mailsender.MailSenderOrder;
import ua.com.emily.mailsender.MailSenderValidator;
import ua.com.emily.service.CartService;
import ua.com.emily.service.PurchaseService;
import ua.com.emily.service.TransporterService;
import ua.com.emily.service.UsersService;

/**
 * Controller 
 * 
 * Method for send an email to the customer after order confirmation, and a copy of the letter to the admin
 * 
 * @param nameUsers
 *            - is the name of customer
 * @param telephoneNumberUsers
 *            - phone number
 * @param emailUser
 *            - entered email to get the copy of mail
 * @param idTrans
 *            - ID of the transporter (for delivery)
 * @param cityUsers
 *            - the user's city 
 *            
 * @param adressUsers
 *            - the address of the user            
 *            
 * @param passwordUsers
 *            - the password you enter
 *   
 * @param passwordUserRepeat
 *            - confirm password           
 *   
 * @return
 * 
 * @author Tanskiy R.
 * 
 */

@Controller
public class OrderControlerSend {

	@Autowired
	private UsersService service;

	@Autowired
	private PurchaseService purchase;

	@Autowired
	private CartService cartService;

	@Autowired
	private TransporterService transService;

	@RequestMapping(value = "/orderNew", method = RequestMethod.POST)
	public String newOrder(
			@RequestParam(value = "emailUser") String emailUser,
			@RequestParam(value = "passwordUsers") String passwordUsers,
			@RequestParam(value = "passwordUserRepeat") String passwordUserRepeat,
			@RequestParam(value = "nameUsers") String nameUsers,
			@RequestParam(value = "telephoneNumberUsers") String phoneNumberUsers,
			@RequestParam(value = "cityUsers") String cityUsers,
			@RequestParam(value = "adressUsers") String adressUsers,
			@RequestParam(value = "idTrans") String transport,
			HttpServletRequest req)

	{
		try {

			HttpSession ses = req.getSession(false);
			String s = ses.getId();
			int idTrans = Integer.parseInt(transport);
			Transporter trans = transService.findByIdTransporter(idTrans);
			
			if (passwordUsers.equals(passwordUserRepeat)) {

				if (service.findByEmail(emailUser) == null) {

					service.createUsers(nameUsers, emailUser, phoneNumberUsers,
							cityUsers, adressUsers, passwordUsers);

				} else {

					Users user = service.findByEmail(emailUser);
					if (user.getPasswordUsers().equalsIgnoreCase(passwordUsers)) {
						int id = user.getIdUsers();
						Roles roleUser = user.getRoles();
						service.updateUsers(id, nameUsers, emailUser,
								phoneNumberUsers, cityUsers, adressUsers,
								passwordUsers, roleUser);

					}

					else {
						return "redirect:/ordering?password=noUser";

					}

				}

				List<Cart> carts = cartService.getCartsSession(s);
				int total = 0;
				for (Cart cart : carts) {
					total += cart.getTotalPrice();
				}

				if (MailSenderValidator.checkEmailAddress(emailUser) == true) {

					/**
					 * Sending email, using MailSenderApp.class and
					 * MailSenderFileUpload.class. Check if there is the file
					 * attached. If there is no file then use other overrided
					 * method
					 */
					String dostavka = trans.getNameTransporter();
					MailSenderOrder.sendMail(nameUsers, phoneNumberUsers,
							emailUser, carts, total, dostavka);
					
					
					Users users = service.findByEmail(emailUser);
					for (Cart cart : carts) {
						cartService.confirmCart(cart.getIdCart());
						purchase.createPurchase(users, trans, cart);
					}

					return "redirect:/index";

				} else {
					return "redirect:/ordering?sendMail=error";
				}

			} else {
				return "redirect:/ordering?pasword=error";
			}
		} catch (NullPointerException e) {
			e.printStackTrace();
			return "users/wrongData";
		}

	}

}

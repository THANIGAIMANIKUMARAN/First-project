package com.niit.controller;

import java.security.Principal;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.niit.model.CartItem;
import com.niit.userdao.CartitemDAO;
import com.niit.userdao.ProductDAO;

@Controller
public class HomeController
{
	@Autowired
	private ProductDAO productdao;
	@Autowired
	private CartitemDAO cartItemDao;

	public HomeController(){
		System.out.println("HomeController bean is instantiated");
	}
	@RequestMapping(value="/")
	public String gethomePage(HttpSession session,@AuthenticationPrincipal Principal principal)
	{
		session.setAttribute("categories",productdao.getAllCategories());
		if(principal!=null)
		{
		String email=principal.getName();
		List<CartItem> cartItems=cartItemDao.getCart(email);
		session.setAttribute("cartSize",cartItems.size());
		}
		return "home";
	}

	public String getHomePage()
	{
		return"home";
	}
	
	@RequestMapping(value="/Login")

	public String getLoginPage()
	{
		return"Login";
	}
	
	@RequestMapping(value="/AboutUs")

	public String getAboutPage()
	{
		return"AboutUs";
	}
	@RequestMapping(value="/ContactUs")

	public String getContactUsPage()
	{
		return"ContactUs";
	}
	@RequestMapping(value="/Footer")

	public String getFooterPage()
	{
		return"Footer";
	}
	@RequestMapping(value="/Header")

	public String getheaderPage()
	{
		return"Header";
	}
	/*@RequestMapping(value="/Register")

	public String getRegisterPage()
	{
		return"Register";
	}*/
	@RequestMapping(value="/loginerror")
	public String loginFailed(Model model){
		model.addAttribute("error","Invalid credentials..");
		return "Login";
	}
	@RequestMapping(value="/logout")
	public String logout(Model model){
		model.addAttribute("msg","Loggedout successfully...");
		return "Login";
	}
}

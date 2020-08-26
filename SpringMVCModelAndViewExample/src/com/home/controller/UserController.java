package com.home.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.home.model.User;
import com.home.service.UserService;

@Controller
public class UserController {
	
	@Autowired
	private UserService userService;
	
	/*@RequestMapping(value = "/",method = RequestMethod.GET)
	public String registerPage() {
		return  "register";
	}*/
	
	//Use @ModelAttribute
	@RequestMapping(value = "/",method = RequestMethod.GET)
	public String registerPage(Model model) {
		model.addAttribute("user",new User());
		return  "register";
	}
	
	/*@RequestMapping(value = "registerSuccess",method = RequestMethod.POST)
	public ModelAndView registerSuccess(@RequestParam("name") String name,
			@RequestParam(required = false,name="email") String email,
			@RequestParam(defaultValue ="25" ,name="age") Integer age,
			@RequestParam("country") String country) {
		User user=new User(name, age, email, country);
		userService.createUser(user);
		ModelAndView modelAndView=new ModelAndView("registerSuccess");
		modelAndView.addObject("user",user);
		return modelAndView;
	}*/
	
	//redirect mechanism
	/*@RequestMapping(value = "registerSuccess",method = RequestMethod.POST)
	public String registerSuccess(@RequestParam("name") String name,
			@RequestParam(required = false,name="email") String email,
			@RequestParam(defaultValue ="25" ,name="age") Integer age,
			@RequestParam("country") String country) {
		User user=new User(name, age, email, country);
		userService.createUser(user);
		return "redirect:/listusers";
	}*/
	
	//Using @ModelAttribute
	@RequestMapping(value = "registerSuccess",method = RequestMethod.POST)
	public String registerSuccess(@Valid @ModelAttribute("user") User user,BindingResult result) {
		if(result.hasErrors()) {
			return "register";
		}
		userService.createUser(user);
		return "redirect:/listusers";
	}

	/*@RequestMapping(value = "listusers", method = RequestMethod.GET)
	public ModelAndView getUsersList(){
		ModelAndView modelAndView=new ModelAndView("userList");
		List<User> usersList=userService.getUsersList();
		modelAndView.addObject("usersList", usersList);
		return modelAndView;
	}*/
	
	@RequestMapping(value = "listusers", method = RequestMethod.GET)
	public ModelAndView getUsersList(ModelAndView modelAndView){
		modelAndView.setViewName("userList");
		List<User> usersList=userService.getUsersList();
		modelAndView.addObject("usersList", usersList);
		return modelAndView;
	}
	
	@RequestMapping(value = "saveusers")
	public ModelAndView saveUsers(User user){
		return new ModelAndView("saveUsers", "saveUsersData", "Users List Data Saved!!!");
	}
	
	@RequestMapping(value = "deleteusers")
	public ModelAndView deleteUsers(User user){
		return new ModelAndView("deleteUsers", "deleteUsersData", "Users  Data deleted!!!");
	}
	
}

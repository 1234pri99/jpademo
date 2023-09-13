package com.priya.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.priya.User1;
import com.priya.dao.UserDAO;

@Controller
public class UserController {
	@Autowired
	UserDAO userdao;

	@RequestMapping("index1")
	public String user1()
	{
		return "index1.jsp";
	}
	@RequestMapping("addUser")
	public String addUser(User1 user)
	{
		userdao.save(user);
		return "index1.jsp";
	}
	@RequestMapping("getUser")
	public ModelAndView getUser(@RequestParam int id)
	{
		ModelAndView mav=new ModelAndView("showUser.jsp");
		User1 user=userdao.findById(id).orElse(new User1());
		mav.addObject("user",user);
		return mav;
	}
	@RequestMapping("deleteUser")
	public ModelAndView deleteUser(@RequestParam int id)
	{
		ModelAndView mav=new ModelAndView("deleteUser.jsp");
		User1 user=userdao.findById(id).orElse(new User1());
		userdao.delete(user);
		mav.addObject("user",user);
		return mav;
	}
	@RequestMapping("updateUser")
	public ModelAndView updateUser(User1 user)
	{
		ModelAndView mav=new ModelAndView("updateUser.jsp");
		user=userdao.findById(user.getId()).orElse(new User1());
		userdao.deleteById(user.getId());
		mav.addObject("user",user);
		return mav;
	}
}

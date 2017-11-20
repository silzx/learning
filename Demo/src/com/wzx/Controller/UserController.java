package com.wzx.Controller;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.wzx.Dto.UserDto;
import com.wzx.Service.Inter.IUserService;

@Controller
@RequestMapping("/user")
public class UserController {
	@Autowired
	private IUserService us;
	private UserDto user;
	@RequestMapping("/userLogin")
	public @ResponseBody Map userLogin(String name,String pwd,HttpServletRequest req){
		Map<String,Object> info=new HashMap<String,Object>();
		user=us.userLogin(name, pwd);
		if(user!=null){
			req.getSession().setAttribute("user", user);
			info.put("mes", true);
			return info;
		}else{
			info.put("mes", false);
			return info;
		}
	}
}

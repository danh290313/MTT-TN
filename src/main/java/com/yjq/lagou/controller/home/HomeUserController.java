package com.yjq.lagou.controller.home;

import java.util.Date;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.yjq.lagou.bean.CodeMsg;
import com.yjq.lagou.bean.Result;
import com.yjq.lagou.constant.SessionConstant;
import com.yjq.lagou.entity.common.User;
import com.yjq.lagou.service.common.UserService;
import com.yjq.lagou.util.StringUtil;

@RequestMapping("/home/user")
@Controller
public class HomeUserController {
	
	@Autowired
	private UserService userService;
	

	@RequestMapping(value="/save",method=RequestMethod.POST)
	@ResponseBody
	public Result<Boolean> saveUserForm(User user,HttpServletRequest request)
	{
		if(user == null){
			return Result.error(CodeMsg.DATA_ERROR);
		}
		if(StringUtil.isEmpty(user.getUsername())) {
			return Result.error(CodeMsg.USER_NAME_EMPTY);
		}
		if(StringUtil.isEmpty(user.getMobile())) {
			return Result.error(CodeMsg.USER_MOBILE_EMPTY);
		}
		if(user.getMobile().length() != 10) {
			return Result.error(CodeMsg.USER_MOBILE_NOT_CORRECT);
		}
		User session_user = (User) request.getSession().getAttribute("user");
		User findById = userService.find(session_user.getId());
		if(checkUsername(user,findById.getId())){
			return Result.error(CodeMsg.USER_NAME_ALREADY_EXIST);
		}
		BeanUtils.copyProperties(user, findById, "id","createTime","updateTime","content","type","email","password");
		findById.setUpdateTime(new Date());
		if(userService.save(findById) == null){
			return Result.error(CodeMsg.USER_SAVE_ERROR);
		}
		//Cập nhật quyền
		request.getSession().setAttribute(SessionConstant.SESSION_USER_LOGIN_KEY, userService.find(session_user.getId()));
		return Result.success(true);
	}
	

	@RequestMapping(value="/save_self_description",method=RequestMethod.POST)
	@ResponseBody
	public Result<Boolean> saveSelfDescription(String content,HttpServletRequest request)
	{
		User session_user = (User) request.getSession().getAttribute("user");
		session_user.setContent(content);
		session_user.setUpdateTime(new Date());
		if(userService.save(session_user) == null){
			return Result.error(CodeMsg.USER_SAVE_SELF_DESCRIPTION_ERROR);
		}
		//Cập nhật quyền
		request.getSession().setAttribute(SessionConstant.SESSION_USER_LOGIN_KEY, userService.find(session_user.getId()));
		return Result.success(true);
	}
	
	
	//Kiểm tra xem có tên người dùng trùng lặp không
	public boolean checkUsername(User user,Long id)
	{
		User findByUsername = userService.findByUsername(user.getUsername());
		if(findByUsername == null)
			return false;  //Không lặp lại
		if(findByUsername.getId().longValue() == id.longValue())
			return false;  //Không lặp lại
		return true;  //Nhân bản
	}
}

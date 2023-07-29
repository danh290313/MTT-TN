package com.yjq.lagou.controller.home;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import org.springframework.web.bind.annotation.ResponseBody;

import com.yjq.lagou.bean.CodeMsg;
import com.yjq.lagou.bean.Result;
import com.yjq.lagou.constant.SessionConstant;
import com.yjq.lagou.entity.common.User;
import com.yjq.lagou.service.common.UserService;
import com.yjq.lagou.util.StringUtil;
@RequestMapping("/home/system")
@Controller
public class HomeSystemController {

	@Autowired
	private UserService userService;
	
	
	
	@RequestMapping(value="/register",method=RequestMethod.GET)
	public String register(Model model){
		return "home/system/register";
	}
	
	
	@RequestMapping(value="/update_password",method=RequestMethod.GET)
	public String updatePwd(Model model){
		return "home/system/update_password";
	}
	
	

	
	@RequestMapping(value="/logout")
	public String loginout(HttpServletRequest request){
		request.getSession().setAttribute(SessionConstant.SESSION_USER_LOGIN_KEY , null);
		return "redirect:/home/index/index";
	}

	
	@RequestMapping(value="/login",method=RequestMethod.GET)
	public String login(Model model){
		return "home/system/login";
	}
	
	
	@RequestMapping(value="/update_password",method=RequestMethod.POST)
	@ResponseBody
	public Result<Boolean> updatePwd(String oldPwd,String newPwd,String confirmPwd,HttpServletRequest request)
	{
		User user = (User) request.getSession().getAttribute(SessionConstant.SESSION_USER_LOGIN_KEY);
		if(!user.getPassword().equals(oldPwd)) {
			return Result.error(CodeMsg.USER_OLD_PASSWORD_NOT_CORRECT);
		}
		if(newPwd.length() <6 || newPwd.length() > 16) {
			return Result.error(CodeMsg.USER_NEW_PASSWORD_NOT_CORRECT);
		}
		if(!newPwd.equals(confirmPwd)) {
			return Result.error(CodeMsg.USER_CONFIRM_PASSWORD_NOT_CORRECT);
		}
		user.setPassword(newPwd);
		if(userService.save(user) == null) {
			return Result.error(CodeMsg.USER_NEW_PASSWORD_SAVE_ERROR);
		}
		User findUser = userService.find(user.getId());
		request.getSession().setAttribute(SessionConstant.SESSION_USER_LOGIN_KEY, findUser);
		return Result.success(true);
	}
	
	
	
	

	@RequestMapping(value="/login",method=RequestMethod.POST)
	@ResponseBody
	public Result<Boolean> loginForm(String email,String password,String cpacha,HttpServletRequest request)
	{
		if(StringUtil.isEmpty(email)){
			return Result.error(CodeMsg.USER_EMAIL_EMPTY);
		}
		if(StringUtil.isEmpty(password)){
			return Result.error(CodeMsg.USER_PASSWORD_EMPTY);
		}
		// if(StringUtil.isEmpty(cpacha)){
		// 	return Result.error(CodeMsg.CPACHA_EMPTY);
		// }
		//Nhận mã xác minh do hệ thống tạo ra
		// String correct_cpacha = (String) request.getSession().getAttribute("user_login");
		// //验证验证码是否正确
		// if(!cpacha.toUpperCase().equals(correct_cpacha.toUpperCase())) {
		// 	return Result.error(CodeMsg.CPACHA_ERROR);
		// }
		User user = userService.findByEmail(email);
		//Xác định xem địa chỉ hộp thư có tồn tại không
		if(user == null){
			return Result.error(CodeMsg.USER_EMAIL_NOT_EXIST);
		}
		//Xác định xem người dùng có nhập đúng mật khẩu không
		if(!password.equals(user.getPassword())){
			return Result.error(CodeMsg.USER_PASSWORD_ERROR);
		}
		request.getSession().setAttribute(SessionConstant.SESSION_USER_LOGIN_KEY, user);
	
		return Result.success(true);
	}
	
	
	@RequestMapping(value="/register",method=RequestMethod.POST)
	@ResponseBody
	public Result<Boolean> registerForm(HttpServletRequest request,User user,String cpacha){
		//Nếu mục đích kiểm tra mục đích trống
		if(user.getType() == null || user.getType() < 0){
			return Result.error(CodeMsg.USER_REGISTER_TYPE_EMPTY);
		}
		//Nếu địa chỉ hộp thư trống
		if(StringUtil.isEmpty(user.getEmail())){
			return Result.error(CodeMsg.USER_EMAIL_EMPTY);
		}
		//Nếu mật khẩu người dùng trống
		if(StringUtil.isEmpty(user.getPassword())) {
			return Result.error(CodeMsg.USER_PASSWORD_EMPTY);
		}
		//Nếu có biệt danh người dùng trống
		if(StringUtil.isEmpty(user.getUsername())) {
			return Result.error(CodeMsg.USER_NAME_EMPTY);
		}
		//Nếu mã xác minh trống
		// if(StringUtil.isEmpty(cpacha)){
		// 	return Result.error(CodeMsg.CPACHA_EMPTY);
		// }
		//Sử dụng phương pháp xác minh thống nhất để xác minh xem nó có hợp pháp
		user.setMobile("13774559485"); //Đặt một cái trước và phục hồi sau
		//CodeMsg validate = ValidateEntityUtil.validate(user);
		// if(validate.getCode() != CodeMsg.SUCCESS.getCode()){
		// 	return Result.error(validate);
		// }
		user.setMobile(null);//hồi phục
		//Nếu người dùng không nhấp vào email
		if(request.getSession().getAttribute("user_register") == null)
		{
			return Result.error(CodeMsg.SYSTEM_CPACHA_EMPTY);
		}
		String correct_cpacha = (String) request.getSession().getAttribute("user_register");
		//Nếu mã xác minh không chính xác
		if(!correct_cpacha.toUpperCase().equals(cpacha.toUpperCase())){
			return Result.error(CodeMsg.CPACHA_ERROR);
		}
		//Kiểm tra xem hộp thư và biệt danh của người dùng có được lặp lại không
		if(checkEmail(user,0l)){
			request.getSession().setAttribute("user_register", null); //Nhập một cái mới vào hộp thư, bạn cần gửi mã xác minh để xác định
			return Result.error(CodeMsg.USER_EMAIL_ALREADY_EXIST);
		}
		if(checkUsername(user,0l)){
			return Result.error(CodeMsg.USER_NAME_ALREADY_EXIST);
		}
		//Sau khi đánh giá ở trên được thông qua, hãy chuẩn bị thêm cơ sở dữ liệu
		if(userService.save(user) == null)
		{
			return Result.error(CodeMsg.USER_REGISTER_ERROR);
		}
		//Phá hủy các quyền mã xác minh
		request.getSession().setAttribute("user_register", null);
		return Result.success(true);
	}
	
	
	
	
	
	//Kiểm tra xem có sự trùng lặp không email
	public boolean checkEmail(User user,Long id)
	{
		User findByEmail = userService.findByEmail(user.getEmail());
		if(findByEmail == null)
			return false;  //Không lặp lại
		if(findByEmail.getId().longValue() == id.longValue())
			return false;  //Không lặp lại
		return true;  //Nhân bản
	}
	//Kiểm tra xem có sự trùng lặp không username
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

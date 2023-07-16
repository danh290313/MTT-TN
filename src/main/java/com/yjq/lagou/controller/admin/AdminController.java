package com.yjq.lagou.controller.admin;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.yjq.lagou.bean.CodeMsg;
import com.yjq.lagou.bean.Page;
import com.yjq.lagou.bean.Result;
import com.yjq.lagou.constant.SessionConstant;
import com.yjq.lagou.entity.admin.Admin;
import com.yjq.lagou.entity.admin.OperaterLog;
import com.yjq.lagou.service.admin.AdminService;
import com.yjq.lagou.service.admin.OperaterLogService;
import com.yjq.lagou.util.ValidateEntityUtil;

@RequestMapping("/admin/admin")
@Controller
public class AdminController {

	@Autowired 
	private AdminService adminService; 
	
	@Autowired
	private OperaterLogService  operaterLogService; 
	
	
	
	
	@RequestMapping(value="/my_info",method=RequestMethod.GET)
	public String myInfo(Model model){
		return "admin/admin/my_info";
	}
	
	
	@RequestMapping(value="/my_info_list",method=RequestMethod.POST)
	@ResponseBody
	public  Map<String, Object>  myInfoList(HttpServletRequest request,Page page){
		Map<String, Object> ret = new HashMap<String, Object>();
		Admin admin = (Admin) request.getSession().getAttribute(SessionConstant.SESSION_ADMIN_LOGIN_KEY);
		List<Admin> findList = adminService.findAdminList(admin.getId(),page.getOffset(), page.getRows());
		ret.put("rows", findList);
		ret.put("total", 1);
		return ret; 
	}

	@RequestMapping(value="/edit",method=RequestMethod.POST)
	@ResponseBody
	public Result<Boolean> edit(Admin admin)
	{
		if(admin == null)
		{
			return Result.error(CodeMsg.DATA_ERROR);
		}
	
		CodeMsg validate = ValidateEntityUtil.validate(admin);
		if(validate.getCode() != CodeMsg.SUCCESS.getCode()){
			return Result.error(validate);
		}
	
		if(admin.getId() == null || admin.getId().longValue() <= 0)
		{
			return Result.error(CodeMsg.USER_EDIT_ID_EMPTY);
		}
		
		Admin findAdmin = adminService.find(admin.getId());
		
		BeanUtils.copyProperties(admin, findAdmin, "id","createTime","updateTime");
		
	
		if(adminService.save(findAdmin) == null)
		{
			return Result.error(CodeMsg.USER_EDIT_ERROR);
		}
	
		OperaterLog operaterLog  = new OperaterLog();
		operaterLog.setOperator("【"+findAdmin.getAdminName()+"】：");
		operaterLog.setContent("Sửa đổi thông tin quản trị viên：【"+findAdmin+"】。");
		operaterLogService.save(operaterLog);
		
		return Result.success(true);
	}
	
}

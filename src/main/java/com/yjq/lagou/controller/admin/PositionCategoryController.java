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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.yjq.lagou.bean.CodeMsg;
import com.yjq.lagou.bean.Page;
import com.yjq.lagou.bean.Result;
import com.yjq.lagou.constant.SessionConstant;
import com.yjq.lagou.entity.admin.Admin;
import com.yjq.lagou.entity.admin.OperaterLog;
import com.yjq.lagou.entity.common.PositionCategory;
import com.yjq.lagou.service.admin.OperaterLogService;
import com.yjq.lagou.service.common.PositionCategoryService;
import com.yjq.lagou.util.PositionCategoryUtil;
import com.yjq.lagou.util.ValidateEntityUtil;
@RequestMapping("/admin/position_category")
@Controller
public class PositionCategoryController {

	@Autowired 
	private PositionCategoryService positionCategoryService;
	
	@Autowired 
	private OperaterLogService operaterLogService;
	
	
	
	@RequestMapping(value="/list",method=RequestMethod.GET)
	public String positionCategory(Model model){
		List<PositionCategory> findList = positionCategoryService.findAll();
		model.addAttribute("topPositionCategoryList", PositionCategoryUtil.getTopPositionCategory(findList));
		return "admin/position/category";
	}
	
	@RequestMapping(value="/list",method=RequestMethod.POST)
	@ResponseBody
	public  Map<String, Object>  positionCategoryList(Page page){
		Map<String, Object> ret = new HashMap<String, Object>();
		List<PositionCategory> findList = positionCategoryService.findAll();
		ret.put("rows", findList);
		ret.put("total", positionCategoryService.total());
		return ret; 
	}
	
	
	@RequestMapping(value="/add",method=RequestMethod.POST)
	@ResponseBody
	public  Result<Boolean> add(HttpServletRequest request,PositionCategory positionCategory,@RequestParam(name="parent_id",required=true)Long parent_id){
		if(parent_id == null)
		{
			return Result.error(CodeMsg.POSITION_CATEGORY_PARENT_EMPTY);
		}
		CodeMsg validate = ValidateEntityUtil.validate(positionCategory);
		if(validate.getCode() != CodeMsg.SUCCESS.getCode())
		{
			return Result.error(validate);
		}
		if(parent_id == 0)
		{
		
			positionCategory.setParentId(null);
			positionCategory.set_parentId(null);
		}else {
		
			PositionCategory pc = new PositionCategory();
			pc.setId(parent_id);
			positionCategory.setParentId(pc);
			positionCategory.set_parentId(parent_id);
		}
	
		if(positionCategoryService.save(positionCategory) == null)
		{
			return Result.error(CodeMsg.POSITION_CATEGORY_ADD_ERROR);
		}
		
	
		OperaterLog operaterLog  = new OperaterLog();
		Admin admin = (Admin) request.getSession().getAttribute(SessionConstant.SESSION_ADMIN_LOGIN_KEY);
		operaterLog.setOperator("【"+admin.getAdminName()+"】：");
		operaterLog.setContent("Đã thêm danh mục nghề nghiệp:【"+positionCategory+"】。");
		operaterLogService.save(operaterLog);
		
		return Result.success(true); 
	}
	
	
	@RequestMapping(value="/edit",method=RequestMethod.POST)
	@ResponseBody
	public  Result<Boolean> edit(PositionCategory positionCategory,HttpServletRequest request){
		if(positionCategory.getId() == null || positionCategory.getId() <= 0)
		{
			return Result.error(CodeMsg.POSITION_CATEGORY_EDIT_ID_EMPTY);
		}
		CodeMsg validate = ValidateEntityUtil.validate(positionCategory);
		if(validate.getCode() != CodeMsg.SUCCESS.getCode())
		{
			return Result.error(validate);
		}
		PositionCategory find = positionCategoryService.find(positionCategory.getId());
		BeanUtils.copyProperties(positionCategory, find, "id","createTime","updateTime","parentId","_parentId");
	
		if(positionCategoryService.save(find) == null)
		{
			return Result.error(CodeMsg.POSITION_CATEGORY_EDIT_ERROR);
		}
	
		OperaterLog operaterLog  = new OperaterLog();
		Admin admin = (Admin) request.getSession().getAttribute(SessionConstant.SESSION_ADMIN_LOGIN_KEY);
		operaterLog.setOperator("【"+admin.getAdminName()+"】：");
		operaterLog.setContent("Sửa đổi danh mục nghề nghiệp：【"+find+"】。");
		operaterLogService.save(operaterLog);
				
		return Result.success(true); 
	}
	
	
	@RequestMapping(value="/delete",method=RequestMethod.POST)
	@ResponseBody
	public  Result<Boolean> delete(Long id,HttpServletRequest request){
		if(id == null || id <= 0)
		{
			return Result.error(CodeMsg.POSITION_CATEGORY_DELETE_ID_EMPTY);
		}
		List<PositionCategory> findAll = positionCategoryService.findAll();
		for(PositionCategory positionCategory : findAll)
		{
		
			if(positionCategory.get_parentId() == id)
			{
				return Result.error(CodeMsg.POSITION_CATEGORY_PARENT_DELETE_ERROR);
			}
		}
		positionCategoryService.delete(id);
		
		
		OperaterLog operaterLog  = new OperaterLog();
		Admin admin = (Admin) request.getSession().getAttribute(SessionConstant.SESSION_ADMIN_LOGIN_KEY);
		operaterLog.setOperator("【"+admin.getAdminName()+"】：");
		operaterLog.setContent("Xóa danh mục nghề nghiệp (ID)：【"+id+"】。");
		operaterLogService.save(operaterLog);
		return Result.success(true); 
	}
	
}

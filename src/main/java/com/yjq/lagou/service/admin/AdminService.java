package com.yjq.lagou.service.admin;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yjq.lagou.dao.admin.AdminDao;
import com.yjq.lagou.entity.admin.Admin;



@Service
public class AdminService {

	@Autowired
	private AdminDao adminDao;
	
	
	public Admin findByAdminName(String admin_name)
	{
		return adminDao.findByAdminName(admin_name);
	}
	
	
	public List<Admin> findAdminList(Long id,int offset,int pageSize)
	{
		return adminDao.findAdminList(id, offset, pageSize);
	}
	
	
	public Admin save(Admin admin){
		return adminDao.save(admin);
	} 
	

	public Admin find(Long id){
		return adminDao.find(id);
	}
}

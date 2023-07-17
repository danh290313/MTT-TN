package com.yjq.lagou.service.home;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yjq.lagou.dao.home.EducationBackgroundDao;
import com.yjq.lagou.entity.home.EducationBackground;

@Service
public class EducationBackgroundService {

	@Autowired
	private EducationBackgroundDao educationBackgroundDao;
	

	public  EducationBackground save(EducationBackground educationBackground)
	{
		return educationBackgroundDao.save(educationBackground);
	}
	

	public EducationBackground findEducationBackgroundByUserId(Long user_id)
	{
		return educationBackgroundDao.findEducationBackgroundByUserId(user_id);
	}
	

	public List<EducationBackground> findAllEducationBackground(){
		return educationBackgroundDao.findAllEducationBackground();
	}
	

	public void delete(Long id) {
		educationBackgroundDao.deleteById(id);
	}
}

package com.yjq.lagou.service.home;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yjq.lagou.dao.home.ResumeDao;
import com.yjq.lagou.entity.home.Resume;

@Service 
public class ResumeService {

	@Autowired
	private ResumeDao resumeDao;
	

	public  Resume save(Resume resume)
	{
		return resumeDao.save(resume);
	}
	
	
	public Resume findByPositionIdAndUserId(Long user_id,Long position_id){
		return resumeDao.findByPositionIdAndUserId(user_id, position_id);
	}
	

	public List<Resume> findByPositionId(Long position_id){
		return resumeDao.findByPositionId(position_id);
	}
	

	public List<Resume> findByCompanyIdAndState(Long company_id,String state){
		return resumeDao.findByCompanyIdAndState(company_id, state);
	}
	

	public List<Resume> findByCompanyId(Long company_id){
		return resumeDao.findByCompanyId(company_id);
	}
	

	public List<Resume> findByUserIdAndState(Long user_id,String state){
		return resumeDao.findByUserIdAndState(user_id, state);
	}
	

	public List<Resume> findByUserId(Long user_id){
		return resumeDao.findByUserId(user_id);
	}
	

	public Resume findByResumeId(Long id){
		return resumeDao.findByResumeId(id);
	}
	

	public int getPositionTotalByStateAndCompanyId(Long id,String state){
		return resumeDao.getPositionTotalByStateAndCompanyId(id,state);
	}
	

	public void delete(Long id){
		resumeDao.deleteById(id);
	}
	

	public long total() {
		return resumeDao.count();
	}
}

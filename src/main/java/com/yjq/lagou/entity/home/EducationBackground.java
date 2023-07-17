package com.yjq.lagou.entity.home;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import com.yjq.lagou.annotion.ValidateEntity;
import com.yjq.lagou.entity.common.BaseEntity;
import com.yjq.lagou.entity.common.User;

@Entity
@Table(name="education_background")
@EntityListeners(AuditingEntityListener.class)  //Nó được sử dụng để theo dõi các hoạt động thêm hoặc xóa lớp vật lý.
public class EducationBackground extends BaseEntity{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private static final String DEFAULT_DEGREE = "khác"; 
	
	@ManyToOne
	@JoinColumn(name="user_id")
	private User user;//Người dùng nền giáo dục
	
	@ValidateEntity(required=true,errorRequiredMsg="Tên trường không thể trống！")
	@Column(name="school_name",nullable=false)
	private String school_name;  //Tên trường
	@ValidateEntity(required=true,errorRequiredMsg="Giáo dục không thể trống!")
	@Column(name="study_record",nullable=false)
	private String studyRecord = DEFAULT_DEGREE;  //Bằng cấp học thuật
	
	@ValidateEntity(required=true,errorRequiredMsg="Tên chuyên nghiệp không thể trống！")
	@Column(name="major",nullable=false)
	private String major;  //tiêu đề chuyên nghiệp
	
	@ValidateEntity(required=true,errorRequiredMsg="Không thể trống ngay từ đầu！")
	@Column(name="start_year",nullable=false)
	private String startYear;  //Năm bắt đầu học tập
	
	@ValidateEntity(required=true,errorRequiredMsg="Không thể trống cuối cùng！")
	@Column(name="end_year",nullable=false)
	private String endYear;  //Kết thúc nghiên cứu

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public String getSchool_name() {
		return school_name;
	}

	public void setSchool_name(String school_name) {
		this.school_name = school_name;
	}

	public String getStudyRecord() {
		return studyRecord;
	}

	public void setStudyRecord(String studyRecord) {
		this.studyRecord = studyRecord;
	}

	public String getMajor() {
		return major;
	}

	public void setMajor(String major) {
		this.major = major;
	}

	public String getStartYear() {
		return startYear;
	}

	public void setStartYear(String startYear) {
		this.startYear = startYear;
	}

	public String getEndYear() {
		return endYear;
	}

	public void setEndYear(String endYear) {
		this.endYear = endYear;
	}
	
	
	
	
	
}

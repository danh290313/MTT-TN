package com.yjq.lagou.entity.home;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import com.yjq.lagou.annotion.ValidateEntity;
import com.yjq.lagou.entity.common.BaseEntity;
import com.yjq.lagou.entity.common.User;

@Entity
@Table(name="project_experience")
@EntityListeners(AuditingEntityListener.class) 
public class ProjectExperience extends BaseEntity{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@ManyToOne
	@JoinColumn(name="user_id")
	private User user;//Kinh nghiệm dự án thuộc về người dùng
	
	@ValidateEntity(required=true,errorRequiredMsg="Tên dự án không thể trống！")
	@Column(name="name",nullable=false)
	private String name;  //Tên dự án
	
	@ValidateEntity(required=true,errorRequiredMsg="Không thể trống như một công việc！")
	@Column(name="position",nullable=false)
	private String position;  //Dự án nằm
	
	@ValidateEntity(required=true,errorRequiredMsg="Không thể trống ngay từ đầu！")
	@Column(name="start_year",nullable=false)
	private String startYear;  //Kinh nghiệm dự án năm bắt đầu
	
	@ValidateEntity(required=true,errorRequiredMsg="Không thể trống cuối cùng！")
	@Column(name="end_year",nullable=false)
	private String endYear;  //Kinh nghiệm dự án kết thúc năm
	
	@ValidateEntity(required=true,errorRequiredMsg="Không thể trống!")
	@Column(name="start_month",nullable=false)
	private String startMonth;  //Kinh nghiệm dự án bắt đầu tháng
	
	@ValidateEntity(required=true,errorRequiredMsg="Không thể trống cuối cùng！")
	@Column(name="end_month",nullable=false)
	private String endMonth;  //Sự kết thúc của trải nghiệm dự án
	
	@Lob
    @Basic(fetch = FetchType.LAZY)   //Loại là longtext
	private String content; //mô tả dự án

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPosition() {
		return position;
	}

	public void setPosition(String position) {
		this.position = position;
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

	public String getStartMonth() {
		return startMonth;
	}

	public void setStartMonth(String startMonth) {
		this.startMonth = startMonth;
	}

	public String getEndMonth() {
		return endMonth;
	}

	public void setEndMonth(String endMonth) {
		this.endMonth = endMonth;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}
	
	
}

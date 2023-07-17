package com.yjq.lagou.entity.home;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import com.yjq.lagou.annotion.ValidateEntity;
import com.yjq.lagou.entity.common.BaseEntity;
import com.yjq.lagou.entity.common.Company;
import com.yjq.lagou.entity.common.Position;
import com.yjq.lagou.entity.common.User;


@Entity
@Table(name = "resume")
@EntityListeners(AuditingEntityListener.class)
public class Resume extends BaseEntity {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private static final String DEFAULT_POSITION_STATE = "wait"; // Tình trạng của vị trí mặc định Chờ

	@ManyToOne
	@JoinColumn(name = "user_id")
	private User user;// Người dùng gửi sơ yếu lý lịch để thuộc về

	@ManyToOne
	@JoinColumn(name = "position_id")
	private Position position;// Gửi sơ yếu lý lịch của bạn đến vị trí của sơ yếu lý lịch

	@ManyToOne
	@JoinColumn(name = "company_id")
	private Company company;// Công ty tiếp tục giao hàng

	@ValidateEntity(required = false)
	@Column(name = "state", nullable = false)
	private String state = DEFAULT_POSITION_STATE; //Trạng thái vị trí

	@Column(name = "interview")
	private Date interview;

	public Date getInterview() {
		return interview;
	}

	public void setInterview(Date interview) {
		this.interview = interview;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Position getPosition() {
		return position;
	}

	public void setPosition(Position position) {
		this.position = position;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public Company getCompany() {
		return company;
	}

	public void setCompany(Company company) {
		this.company = company;
	}

}

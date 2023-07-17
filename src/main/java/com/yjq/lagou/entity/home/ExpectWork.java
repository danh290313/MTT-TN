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
@Table(name="expect_work")
@EntityListeners(AuditingEntityListener.class)  //Nó được sử dụng để theo dõi các hoạt động thêm hoặc xóa lớp vật lý.
public class ExpectWork extends BaseEntity{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private static final String DEFAULT_TYPE = "full"; //Mặc định dự kiến ​​bản chất của công việc
	
	@ManyToOne
	@JoinColumn(name="user_id")
	private User user;//Hy vọng người dùng làm việc
	
	@ValidateEntity(required=false)
	@Column(name="city")
	private String city;  //Hy vọng thành phố làm việc
	
	@ValidateEntity(required=false)
	@Column(name="position")
	private String position;  //Hy vọng vị trí công việc
	
	@ValidateEntity(required=false)
	@Column(name="money")
	private String money;  //Hy vọng sẽ làm việc một mức lương hàng tháng

	@ValidateEntity(required=false)
	@Column(name="type")
	private String type = DEFAULT_TYPE;  //Mong đợi bản chất của công việc


	public User getUser() {
		return user;
	}


	public void setUser(User user) {
		this.user = user;
	}


	public String getCity() {
		return city;
	}


	public void setCity(String city) {
		this.city = city;
	}


	public String getPosition() {
		return position;
	}


	public void setPosition(String position) {
		this.position = position;
	}


	public String getMoney() {
		return money;
	}


	public void setMoney(String money) {
		this.money = money;
	}


	public String getType() {
		return type;
	}


	public void setType(String type) {
		this.type = type;
	}


	
	
	
}

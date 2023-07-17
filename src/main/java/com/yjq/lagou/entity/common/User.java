package com.yjq.lagou.entity.common;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.FetchType;
import javax.persistence.Lob;
import javax.persistence.Table;

import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import com.yjq.lagou.annotion.ValidateEntity;

@Entity
@Table(name="user")
@EntityListeners(AuditingEntityListener.class)
public class User extends BaseEntity{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private static final int USER_SEX_MAN = 1;
	private static final int USER_SEX_WOMAN = 2;
	
	private static final int USER_SEX_UNKONW = 0;
	
	private static final String DEFAULT_WORK_EXPERIENCE = "Tốt nghiệp"; //Kinh nghiệm làm việc mặc định
	private static final String DEFAULT_DEGREE = "khác"; //Giáo dục mặc định
	private static final String DEFAULT_HEAD_IMAGE = "common/default_img.jpg";  //Avatar người dùng mặc định

	
	@ValidateEntity(required=true,requiredMaxLength=true,requiredMinLength=true,minLength=1,maxLength=6,errorRequiredMsg="Biệt hiệu người dùng không thể trống!",errorMinLengthMsg="Độ dài của biệt danh của người dùng cần phải lớn hơn0!",errorMaxLengthMsg="Độ dài biệt danh của người dùng không thể lớn hơn6!")
	@Column(name="username",nullable=false,length=16)
	private String username;//Biệt danh của người dùng
	
	@ValidateEntity(required=true,requiredMaxLength=true,requiredMinLength=true,minLength=6,maxLength=16,errorRequiredMsg="Mật khẩu người dùng không thể trống!",errorMinLengthMsg="Độ dài mật khẩu người dùng cần phải lớn hơn5!",errorMaxLengthMsg="Độ dài mật khẩu người dùng không thể lớn hơn16!")
	@Column(name="Password",nullable=false,length=16)
	private String Password;//Biệt danh của người dùng
	
	@ValidateEntity(required=true,errorRequiredMsg="Địa chỉ hộp thư người dùng không thể trống!")
	@Column(name="Email",nullable=false)
	private String Email;//Địa chỉ hộp thư người dùng
	
	@ValidateEntity(required=false)
	@Column(name="head_pic",length=128)
	private String headPic = DEFAULT_HEAD_IMAGE;//ảnh đại diện
	
	@ValidateEntity(required=false)
	@Column(name="work_experience",length=10)
	private String workExperience = DEFAULT_WORK_EXPERIENCE ; //Kinh nghiệm làm việc: Mặc định là sinh viên tốt nghiệp mới
	
	@ValidateEntity(required=false)
	@Column(name="degree",length=10)
	private String degree = DEFAULT_DEGREE ; //Giáo dục: Mặc định là khác
	
	@ValidateEntity(required=false)
	@Column(name="sex",length=1)
	private int sex = USER_SEX_UNKONW;//Giới tính
	
	@ValidateEntity(required=true,requiredMaxLength=true,requiredMinLength=true,minLength=11,maxLength=11,errorMinLengthMsg="Vui lòng nhập chiều dài 11bit với số điện thoại di động chính xác!",errorMaxLengthMsg="Vui lòng nhập chiều dài 11bit với số điện thoại di động chính xác!")
	@Column(name="mobile",length=12)
	private String mobile;//Số điện thoại di động của người dùng
	
	@ValidateEntity(required=false)
	@Column(name="type",length=1,nullable=false)
	private Long type;//Thể loại người dùng: 0: Ứng viên, 1: Nhà tuyển dụng
	
	@Lob
    @Basic(fetch = FetchType.LAZY)   //Loại là longtext
	private String content; //Tự mô tả


	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return Password;
	}

	public void setPassword(String password) {
		Password = password;
	}

	public String getEmail() {
		return Email;
	}

	public void setEmail(String email) {
		Email = email;
	}

	public String getHeadPic() {
		return headPic;
	}

	public void setHeadPic(String headPic) {
		this.headPic = headPic;
	}

	public int getSex() {
		return sex;
	}

	public void setSex(int sex) {
		this.sex = sex;
	}

	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	public Long getType() {
		return type;
	}

	public void setType(Long type) {
		this.type = type;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getWorkExperience() {
		return workExperience;
	}

	public void setWorkExperience(String workExperience) {
		this.workExperience = workExperience;
	}

	public String getDegree() {
		return degree;
	}

	public void setDegree(String degree) {
		this.degree = degree;
	}
	
	
}

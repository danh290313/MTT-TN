package com.yjq.lagou.entity.admin;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.Table;

import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import com.yjq.lagou.annotion.ValidateEntity;
import com.yjq.lagou.entity.common.BaseEntity;



@Entity
@Table(name="admin")
@EntityListeners(AuditingEntityListener.class)  //Nó được sử dụng để theo dõi các hoạt động thêm hoặc xóa lớp vật lý.
public class Admin extends BaseEntity{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private static final int USER_SEX_MAN = 1;
	
	private static final int USER_SEX_WOMAN = 2;
	
	private static final int USER_SEX_UNKONW = 0;
	
	
	private static final String DEFAULT_HEAD_IMAGE = "common/default_img.jpg";  //Avatar người dùng mặc định
	
	
	@ValidateEntity(required=true,requiredMaxLength=true,requiredMinLength=true,minLength=2,maxLength=10,errorRequiredMsg="Tên ngươi dung không được để trông!",errorMinLengthMsg="Độ dài tên người dùng cần phải lớn hơn 1!",errorMaxLengthMsg="Độ dài tên người dùng không thể lớn hơn 10!")
	@Column(name="admin_name",nullable=false,length=10,unique=true)  // độc đáo = true: bản ghi lặp lại chỉ được giữ lại
	private String adminName;//tên tài khoản
	
	@ValidateEntity(required=true,requiredMaxLength=true,requiredMinLength=true,minLength=4,maxLength=16,errorRequiredMsg="Mật khẩu không thể trống！",errorMinLengthMsg="Độ dài mật khẩu cần phải lớn hơn 4!",errorMaxLengthMsg="Độ dài mật khẩu không thể lớn hơn 16!")
	@Column(name="password",nullable=false,length=16)
	private String password;//mật khẩu

	@ValidateEntity(required=false)
	@Column(name="head_pic",length=128)
	private String headPic = DEFAULT_HEAD_IMAGE;//ảnh đại diện
	
	@ValidateEntity(required=false)
	@Column(name="sex",length=1)
	private int sex = USER_SEX_UNKONW;//Giới tính
	
	@ValidateEntity(required=true,requiredMaxLength=true,requiredMinLength=true,minLength=11,maxLength=11,errorMinLengthMsg="Vui lòng nhập chiều dài 11bit với số điện thoại di động chính xác!",errorMaxLengthMsg="Vui lòng nhập chiều dài 11bit với số điện thoại di động chính xác!")
	@Column(name="mobile",length=12)
	private String mobile;//Số điện thoại di động của người dùng
	
	@ValidateEntity(required=false)
	@Column(name="email",length=32)
	private String email;//Hộp thư người dùng

	public String getAdminName() {
		return adminName;
	}

	public void setAdminName(String adminName) {
		this.adminName = adminName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
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

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	@Override
	public String toString() {
		return "Admin [adminName=" + adminName + ", password=" + password + ", headPic=" + headPic + ", sex=" + sex
				+ ", mobile=" + mobile + ", email=" + email + "]";
	}
	
	
}

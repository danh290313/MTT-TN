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
@Table(name="work_show")
@EntityListeners(AuditingEntityListener.class)
public class WorkShow extends BaseEntity{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@ManyToOne
	@JoinColumn(name="user_id")
	private User user;//Người dùng công việc được hiển thị
	
	@ValidateEntity(required=false)
	@Column(name="url")
	private String url; //Liên kết công việc
	
	@ValidateEntity(required=false)
	@Column(name="file_cv")
	private String fileCv;

	public String getFileCv() {
		return this.fileCv;
	}

	public void setFileCv(String fileCv) {
		this.fileCv = fileCv;
	}
	 //Liên kết công việc
	
	@Lob
    @Basic(fetch = FetchType.LAZY)   //Loại là longtext
	private String content; //Sự miêu tả

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}
	
	

	


	
	
}

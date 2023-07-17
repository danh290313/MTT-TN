package com.yjq.lagou.entity.admin;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.Table;

import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import com.yjq.lagou.entity.common.BaseEntity;

@Entity
@Table(name="operater_log")
@EntityListeners(AuditingEntityListener.class)  //Nó được sử dụng để theo dõi các hoạt động thêm hoặc xóa lớp vật lý.
public class OperaterLog extends BaseEntity{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	
	@Column(name="operator",nullable=false,length=18)
	private String operator;//nhà điều hành
	
	@Column(name="content",nullable=false,length=512)
	private String content;//Nội dung nhật ký hoạt động

	public String getOperator() {
		return operator;
	}

	public void setOperator(String operator) {
		this.operator = operator;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}
	
	
	
	
}

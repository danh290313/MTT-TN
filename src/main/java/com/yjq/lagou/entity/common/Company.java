package com.yjq.lagou.entity.common;

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
/**
 * 公司实体类
 *
 *
 */
@Entity
@Table(name="company")
@EntityListeners(AuditingEntityListener.class)  //Nó được sử dụng để theo dõi các hoạt động thêm hoặc xóa lớp vật lý.
public class Company extends BaseEntity{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private static final String DEDAULT_STATE = "không công nhận, không chứng nhận"; 
	private static final String DEDAULT_FINANCE = "Không thể tài trợ"; 
	private static final String DEDAULT_PHOTO = "common/logo_default.png"; 
	private static final String DEDAULT_PRODUCT_PHOTO = "common/product_default.png"; 
	private static final String DEFAULT_FOUNDER_PHOTO = "common/default_headpic.png";  
	
	@Column(name="name",length=30)
	private String name;//Tên công ty
	
	@ManyToOne
	@JoinColumn(name="user_id")
	private User user;//Công ty áp dụng cho người dùng chứng nhận
	
	@Column(name="value",length=50)
	private String value;//Giá trị của tình thần đoàn kết
	
	@Column(name="tags",length=30)
	private String tags;//Nhãn công ty
	
	@Column(name="state",length=10)
	private String state = DEDAULT_STATE; //Tình trạng ứng dụng của công ty: được xem xét, không thoải mái, được chứng nhận
	
	@Column(name="photo",length=128)
	private String photo = DEDAULT_PHOTO;//Ảnh của công ty
	
	@Column(name="product_photo",length=128)
	private String productPhoto = DEDAULT_PRODUCT_PHOTO;//Hình ảnh sản phẩm của công ty
	
	@Column(name="product_title",length=15)
	private String productTitle;//Tiêu đề sản phẩm của công ty
	
	@Lob
    @Basic(fetch = FetchType.LAZY)   //Loại là longtext
	private String productContent; //Giơi thiệu sản phẩm
	
	@Lob
    @Basic(fetch = FetchType.LAZY)   //Loại là longtext
	private String introduction; //Hồ sơ công ty
	
	@Column(name="locale")
	private String locale;//Vị trí công ty
	
	@Column(name="territory")
	private String territory;//Lĩnh vực công ty
	
	@Column(name="scale")
	private String scale;//Quy mô công ty
	
	@Column(name="url")
	private String url;//Trang web trang chủ của công ty
	
	@Column(name="finance")
	private String finance = DEDAULT_FINANCE;//Giai đoạn tài chính mặc định của công ty
	
	@Column(name="founder_name",length=10)
	private String founderName;//Người sáng lập công ty
	
	@Column(name="founder_position",length=15)
	private String founderPosition;//Vị trí người sáng lập công ty
	
	
	
	@Column(name="founder_photo",length=128)
	private String founderPhoto = DEFAULT_FOUNDER_PHOTO;//Người sáng lập Avatar

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}

	public String getTags() {
		return tags;
	}

	public void setTags(String tags) {
		this.tags = tags;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getPhoto() {
		return photo;
	}

	public void setPhoto(String photo) {
		this.photo = photo;
	}

	public String getProductPhoto() {
		return productPhoto;
	}

	public void setProductPhoto(String productPhoto) {
		this.productPhoto = productPhoto;
	}

	public String getProductTitle() {
		return productTitle;
	}

	public void setProductTitle(String productTitle) {
		this.productTitle = productTitle;
	}

	public String getProductContent() {
		return productContent;
	}

	public void setProductContent(String productContent) {
		this.productContent = productContent;
	}

	public String getIntroduction() {
		return introduction;
	}

	public void setIntroduction(String introduction) {
		this.introduction = introduction;
	}

	public String getLocale() {
		return locale;
	}

	public void setLocale(String locale) {
		this.locale = locale;
	}

	public String getTerritory() {
		return territory;
	}

	public void setTerritory(String territory) {
		this.territory = territory;
	}

	public String getScale() {
		return scale;
	}

	public void setScale(String scale) {
		this.scale = scale;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getFinance() {
		return finance;
	}

	public void setFinance(String finance) {
		this.finance = finance;
	}

	public String getFounderName() {
		return founderName;
	}

	public void setFounderName(String founderName) {
		this.founderName = founderName;
	}

	public String getFounderPosition() {
		return founderPosition;
	}

	public void setFounderPosition(String founderPosition) {
		this.founderPosition = founderPosition;
	}

	
	public String getFounderPhoto() {
		return founderPhoto;
	}

	public void setFounderPhoto(String founderPhoto) {
		this.founderPhoto = founderPhoto;
	}
	
	
	
}

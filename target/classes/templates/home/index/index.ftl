<!-- Trang chủ ftl -->
<!DOCTYPE HTML>
<html xmlns:wb="http://open.weibo.com/wb">

<head>
	<script id="allmobilize" charset="utf-8" src="/home/style/js/allmobilize.min.js"></script>
	<meta http-equiv="Cache-Control" content="no-siteapp" />
	<link rel="alternate" media="handheld" />
	<!-- kết thúc tương thích đám mây -->
	<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
	<title>Nền tảng tuyển dụng</title>
	<meta property="qc:admins" content="23635710066417756375" />
	<meta content="" name="description">
	<meta content="" name="keywords">
	<meta name="baidu-site-verification" content="QIQ6KC1oZ6" />
	<script type="text/javascript">

	</script>
	<link href="THUCTAPTOTNGHIEP_N19DCCN028" rel="Shortcut Icon">
	<link rel="stylesheet" type="text/css" href="/home/style/css/style.css" />
	<link rel="stylesheet" type="text/css" href="/home/style/css/external.min.css" />
	<link rel="stylesheet" type="text/css" href="/home/style/css/popup.css" />
	<script src="/home/style/js/jquery.1.10.1.min.js" type="text/javascript"></script>
	<script type="text/javascript" src="/home/style/js/jquery.lib.min.js"></script>
	<script src="/home/style/js/ajaxfileupload.js" type="text/javascript"></script>
	<script type="text/javascript" src="/home/style/js/additional-methods.js"></script>
	<script src="/home/style/js/setting.js"></script>
	<script type="text/javascript">
	var youdao_conv_id = 271546;
	</script>
	<script type="text/javascript" src="/home/style/js/conv.js"></script>
</head>

<body>
	<div id="body">
		<#include "../common/top_menu.ftl" />
		<div id="container">
			<div id="sidebar">
				<div class="mainNavs">
					<#if topPositionCategoryList?size gt 0>
						<#list topPositionCategoryList as topPositionCategory>
							<div class="menu_box">
								<div class="menu_main">
									<h2>
										${topPositionCategory.name!""}
										<span></span>
									</h2>
									<!--Top cấp-->
									<#if quickIndexList?size gt 0>
										<#list quickIndexList as quickIndex>
											<#if quickIndex.parentId._parentId==topPositionCategory.id>
												<a href="${quickIndex.url!""}">
													${quickIndex.name!""}
												</a>
												<!--Chỉ mục nhanh-->
											</#if>
										</#list>
									</#if>
								</div>
								<div class="menu_sub dn">
									<#if secondPositionCategoryList?size gt 0>
										<#list secondPositionCategoryList as secondPositionCategory>
											<#if secondPositionCategory._parentId==topPositionCategory.id>
												<dl class="reset">
													<dt>
														${secondPositionCategory.name!""}
														<!--Cấp hai -->
													</dt>
													<dd>
														<#if thirdPositionCategoryList?size gt 0>
															<#list thirdPositionCategoryList as thirdPositionCategory>
																<#if thirdPositionCategory._parentId==secondPositionCategory.id && secondPositionCategory._parentId==topPositionCategory.id>
																	<a href="${thirdPositionCategory.url!""}">
																		${thirdPositionCategory.name!""}
																	</a>
																	<!--Cấp ba-->
																</#if>
															</#list>
														</#if>
													</dd>
												</dl>
											</#if>
										</#list>
									</#if>
								</div><!-- kết thúc menu_sub dn -->
							</div><!-- kết thúc menu box -->
						</#list>
					</#if>
				</div><!-- kết thúc main nvs -->
			</div>
			<div class="content">
				<div id="search_box">
					<ul id="searchType">
						<li data-searchtype="1" class="type_selected" id="selected_position">Vị trí</li>
						<li data-searchtype="4" id="selected_company">Công ty</li>
					</ul>
					<div class="searchtype_arrow"></div>
					<input type="text" id="search_input" name="kd" tabindex="1" value="" placeholder="Vui lòng nhập tên vị trí, ví dụ: Quản lý sản phẩm" />
					<input type="hidden" name="spc" id="spcInput" value="" />
					<input type="hidden" name="pl" id="plInput" value="" />
					<input type="hidden" name="gj" id="gjInput" value="" />
					<input type="hidden" name="xl" id="xlInput" value="" />
					<input type="hidden" name="yx" id="yxInput" value="" />
					<input type="hidden" name="gx" id="gxInput" value="" />
					<input type="hidden" name="st" id="stInput" value="" />
					<input type="hidden" name="labelWords" id="labelWords" value="" />
					<input type="hidden" name="lc" id="lc" value="" />
					<input type="hidden" name="workAddress" id="workAddress" value="" />
					<input type="hidden" name="city" id="cityInput" value="" />
					<input type="button" id="search_button" value="Tìm kiếm" onclick="search();" />
				</div>
				<style>
				.ui-autocomplete {
					width: 488px;
					background: #fafafa !important;
					position: relative;
					z-index: 10;
					border: 2px solid #91cebe;
				}

				.ui-autocomplete-category {
					font-size: 16px;
					color: #999;
					width: 50px;
					position: absolute;
					z-index: 11;
					right: 0px;
					/*top: 6px; */
					text-align: center;
					border-top: 1px dashed #e5e5e5;
					padding: 5px 0;
				}

				.ui-menu-item {
					*width: 439px;
					vertical-align: middle;
					position: relative;
					margin: 0px;
					margin-right: 50px !important;
					background: #fff;
					border-right: 1px dashed #ededed;
				}

				.ui-menu-item a {
					display: block;
					overflow: hidden;
				}
				</style>
				<script type="text/javascript" src="/home/style/js/search.min.js"></script>
				<dl class="hotSearch">
					<dt>Từ khóa phổ biến:</dt>
					<dd><a href="/home/position/list?search_value=java">JAVA</a></dd>
					<dd><a href="/home/position/list?search_value=php">PHP</a></dd>
					<dd><a href="/home/position/list?search_value=asp">ASP</a></dd>
					<dd><a href="/home/position/list?search_value=html">HTML</a></dd>
					<dd><a href="/home/position/list?search_value=sản phẩm">sản phẩm</a></dd>
					<dd><a href="/home/position/list?search_value=bán hàng">bán hàng</a></dd>
					<dd><a href="/home/position/list?search_value=Nhân sự">Nhân sự</a></dd>
				</dl>
				<div id="home_banner">
					<ul class="banner_bg">
						<li class="banner_bg_1 current">
							<img src="https://s3.amazonaws.com/media.the-next-tech.com/wp-content/uploads/2019/01/19141852/it_compaines_logos2.jpg" width="612" height="160" alt="Quỹ mua tốt -Give 1 triệu khi bạn đến" />
						</li>
						<li class="banner_bg_2">
							<img src="https://s3.amazonaws.com/media.the-next-tech.com/wp-content/uploads/2019/01/19141839/it_compaines_logos4.jpg" width="612" height="160" alt="Xem bóng trong kỳ nghỉ ở World Cup, tôi cũng muốn ông chủ!" />
						</li>
						<li class="banner_bg_3">
							<img src="https://s3.amazonaws.com/media.the-next-tech.com/wp-content/uploads/2019/01/19141826/it_compaines_logos8.jpg" width="612" height="160" alt="Rời khỏi Bắc Kinh -Điểm dừng đầu tiên Xiamen" />
						</li>
					</ul>
					<div class="banner_control">
						<em></em>
						<ul class="thumbs">
							<li class="thumbs_1 current">
								<i></i>
								<img src="https://s3.amazonaws.com/media.the-next-tech.com/wp-content/uploads/2019/01/19141852/it_compaines_logos2.jpg" width="113" height="42" />
							</li>
							<li class="thumbs_2">
								<i></i>
								<img src="https://s3.amazonaws.com/media.the-next-tech.com/wp-content/uploads/2019/01/19141839/it_compaines_logos4.jpg" width="113" height="42" />
							</li>
							<li class="thumbs_3">
								<i></i>
								<img src="https://s3.amazonaws.com/media.the-next-tech.com/wp-content/uploads/2019/01/19141826/it_compaines_logos8.jpg" width="113" height="42" />
							</li>
						</ul>
					</div>
				</div>


				<!--/#main_banner-->
				<#--  <ul id="da-thumbs" class="da-thumbs">
					<li>
						<a href="/home/company/detail?id=12" target="_blank">
							<img src="/home/style/images/a254b11ecead45bda166afa8aaa9c8bc.jpg" width="113" height="113" alt="联想" />
							<div class="hot_info">
								<h2 title="联想">联想</h2>
								<em></em>
								<p title="Thế giới tốt hơn">
									Thế giới tốt đẹp hơn nhờ Lenovo
								</p>
							</div>
						</a>
					</li>
					<li>
						<a href="/home/company/detail?id=9" target="_blank">
							<img src="/home/style/images/c75654bc2ab141df8218983cfe5c89f9.jpg" width="113" height="113" alt="淘米" />
							<div class="hot_info">
								<h2 title="淘米">Gạo nếp</h2>
								<em></em>
								<p title="将心注入 追求极致">
									Đặt trái tim vào và theo đuổi sự tuyệt vời
								</p>
							</div>
						</a>
					</li>
					<li>
						<a href="/home/company/detail?id=14" target="_blank">
							<img src="/home/style/images/2bba2b71d0b0443eaea1774f7ee17c9f.png" width="113" height="113" alt="优酷土豆" />
							<div class="hot_info">
								<h2 title="优酷土豆">优酷土豆</h2>
								<em></em>
								<p title="专注于视频领域，是中国网络视频行业领军企业">
									Tập trung vào lĩnh vực video, là công ty dẫn đầu trong ngành video trực tuyến của Trung Quốc
								</p>
							</div>
						</a>
					</li>
					<li>
						<a href="/home/company/detail?id=10" target="_blank">
							<img src="/home/style/images/f4822a445a8b495ebad81fcfad3e40e2.jpg" width="113" height="113" alt="思特沃克" />
							<div class="hot_info">
								<h2 title="思特沃克">思特沃克</h2>
								<em></em>
								<p title="一家全球信息技术服务公司">
									一家全球信息技术服务公司
								</p>
							</div>
						</a>
					</li>
					<li>
						<a href="/home/company/detail?id=15" target="_blank">
							<img src="/home/style/images/5caf8f9631114bf990f87bb11360653e.png" width="113" height="113" alt="奇猫" />
							<div class="hot_info">
								<h2 title="奇猫">奇猫</h2>
								<em></em>
								<p title="专注于移动互联网、互联网产品研发">
									专注于移动互联网、互联网产品研发
								</p>
							</div>
						</a>
					</li>
					<li class="last">
						<a href="/home/company/detail?id=11" target="_blank">
							<img src="/home/style/images/c0052c69ef4546c3b7d08366d0744974.jpg" width="113" height="113" alt="堆糖网" />
							<div class="hot_info">
								<h2 title="堆糖网">堆糖网</h2>
								<em></em>
								<p title="分享收集生活中的美好，遇见世界上的另外一个你">
									分享收集生活中的美好，遇见世界上的另外一个你
								</p>
							</div>
						</a>
					</li>
				</ul>  -->



				<ul class="reset hotabbing">
					<li class="current">Công việc gần đây</li>
				</ul>
				<div id="hotList">
					<ul class="hot_pos reset">
						<#if PositionList?size gt 0>
							<#list PositionList as position>
								<#if position_index % 2==0>
									<li class="clearfix">
										<div class="hot_pos_l">
											<div class="mb10">
												<a href="/home/position/detail?id=${position.id!""}" style="text-decoration:none">
													${position.name!""}
												</a>
												&nbsp;
												<span class="c9">[${position.city!""}]
												</span>
											</div>
											<span><em class="c7">Lương： </em>
												${position.minMoney!" "} triệu-${position.maxMoney!" "} triệu</span>
											<span><em class="c7">kinh nghiệm：</em>
												${position.workExperience!""}
											</span>
											<br />
											<span><em class="c7">Giáo dục tối thiểu： </em>
												${position.degree!""}
											</span>
											<br />
											<span><em class="c7">Yêu cầu：</em>
												${position.advantage!""}
											</span>
											<br />
											<span>Thời gian ：${position.createTime!""}
											</span>
										</div>
								</#if>
								<#if position_index % 2==1>
									<div class="hot_pos_r">
										<div class="mb10 recompany">
											<a href="/home/position/detail?id=${position.id!""}" style="text-decoration:none">
												${position.name!""}
											</a>
											&nbsp;
											<span class="c9">[${position.city!""}]
											</span>
										</div>
										<span><em class="c7">Lương: </em>
											${position.minMoney!" "} triệu-${position.maxMoney!" "} triệu</span>
										<span><em class="c7">kinh nghiệm:</em>
											${position.workExperience!""}
										</span>
											<br />
										<span><em class="c7">Giáo dục tối thiểu: </em>
											${position.degree!""}
										</span>
										<br />
										<span><em class="c7">Yêu cầu:</em>
											${position.advantage!""}
										</span>
										<br />
										<span>Thời gian: ${position.createTime!""}
										</span>
									</div>
									</li>
								</#if>
							</#list>
						</#if>
						<#if PositionTotal %2==1>
							</li>
						</#if>
					</ul>
					<a href="/home/position/list" class="btn fr">Xem thêm</a>
				</div>
				<div class="clear"></div>
			</div>
			<input type="hidden" value="" name="userid" id="userid" />
			<#include "../common/alert.ftl" />
			<!-------------------------------------lightbox  ----------------------------------------->
			<!------------------------------------- end ----------------------------------------->
			<script type="text/javascript" src="/home/style/js/Chart.min.js"></script>
			<script type="text/javascript" src="/home/style/js/home.min.js"></script>
			<script type="text/javascript" src="/home/style/js/count.js"></script>
			<#include "../common/footer.ftl" />
			<script type="text/javascript" src="/home/style/js/core.min.js"></script>
			<script type="text/javascript" src="/home/style/js/popup.min.js"></script>
			<script type="text/javascript">
			var searchType = "position"; //Mặc định là tìm kiếm công việc
			document.getElementById("selected_position").onclick = function() {
				searchType = "position";
			}
			document.getElementById("selected_company").onclick = function() {
				searchType = "company";
			}

			function search() {
				var search_value = $("#search_input").val();
				if (search_value == null || search_value == "") {
					$("#errorMsg").html("Thông tin tìm kiếm không thể trống!!!!");
					$.colorbox({inline:true, href:$("#errorTip"),title:"Gợi ý hệ thống"});
					return;
				}
				//Nếu đó là tìm kiếm việc làm
				if (searchType == "position") {
					window.location.href = "/home/position/list?search_value=" + search_value;
				}
				//Nếu đó là một tìm kiếm của công ty
				if (searchType == "company") {
					window.location.href = "/home/index/company_list?search_value=" + search_value;
				}
			}
			</script>
</body>

</html>
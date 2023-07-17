<!--发布新职位-->
<!DOCTYPE HTML>
<html xmlns:wb="http://open.weibo.com/wb"><head>
</script><script type="text/javascript" async="" src="/home/style/js/conversion.js"></script><script src="/home/style/js/allmobilize.min.js" charset="utf-8" id="allmobilize"></script><style type="text/css"></style>
<meta content="no-siteapp" http-equiv="Cache-Control">
<link  media="handheld" rel="alternate">
<!-- end 云适配 -->
<meta content="text/html; charset=utf-8" http-equiv="Content-Type">
<title>Phát hành dịch vụ nhận vị trí mới-nền tảng tuyển dụng Internet chuyên nghiệp nhất</title>
<meta content="23635710066417756375" property="qc:admins">
<meta name="description" content="">
<meta name="keywords" content="">
<meta content="QIQ6KC1oZ6" name="baidu-site-verification">


<script type="text/javascript">
var ctx = "http://www.lagou.com";
console.log(1);
</script>
<link href="http://www.lagou.com/images/favicon.ico" rel="Shortcut Icon">
<link href="/home/style/css/style.css" type="text/css" rel="stylesheet">
<link href="/home/style/css/external.min.css" type="text/css" rel="stylesheet">
<link href="/home/style/css/popup.css" type="text/css" rel="stylesheet">
<script type="text/javascript" src="/home/style/js/jquery.1.10.1.min.js"></script>
<script src="/home/style/js/jquery.lib.min.js" type="text/javascript"></script>
<script src="/home/style/js/additional-methods.js" type="text/javascript"></script>
<script src="/home/style/js/setting.js"></script>
<script src="/home/common/confirm_null.js"></script>
<script type="text/javascript">
var youdao_conv_id = 271546; 
</script> 
<script src="/home/style/js/conv.js" type="text/javascript"></script>
<body>
<div id="body">
	<#include "../common/top_menu.ftl"/>
    <div id="container">
        
        	<div class="sidebar">
            	<a class="btn_create" href="/home/index/publish_position">vị trí mới</a>
                <dl class="company_center_aside">
	<dt>Sơ yếu lý lịch tôi nhận được</dt>
	<dd>
		<a href="/home/resume/my_receive_resume?resumeState=wait">Được xử lý lịch</a> 
	</dd>

	<dd>
		<a href="/home/resume/my_receive_resume?resumeState=effective">cuộc phỏng vấn</a>
	</dd>
	<dd class="btm">
		<a href="/home/resume/my_receive_resume?resumeState=out">lý lịch không phù hợp</a>
	</dd>
</dl>
<dl class="company_center_aside">
	<dt>Vị trí tôi đã đăng</dt>
	<dd>
		<a href="/home/position/my_publish_position?positionState=effective">Vị trí hiệu quả</a>
	</dd>
	<dd>
		<a href="/home/position/my_publish_position?positionState=wait">Để được xem xét</a>
	</dd>
	<dd>
		<a href="/home/position/my_publish_position?positionState=out">Có vị trí ngoại tuyến</a>
	</dd>
</dl>
<div class="subscribe_side mt20">
   <div class="f14">Bạn muốn nhận được nhiều hơn và tiếp tục tốt hơn?</div>
   <div class="f18 mb10">Thông tin cần </div>
   <div>LH:
	 </br>
	 <a class="f16" href="mailto:danh290313@gmail.com">danh290313@gmail.com</a></div>
   <div class="f18 ti2em">SDT: 0961144072</div>
</div>

<#--  <div class="subscribe_side mt20">
   <div class="f14">Tham gia nhóm trao đổi nhân sự Internet</div>
   <div class="f18 mb10">Nói chuyện với đồng nghiệp của họ</div>
   <div class="f24">338167634</div>
</div>             -->

 </div><!-- end .sidebar -->
            <div class="content">
            	<dl class="company_center_content">
                    <dt>
                        <h1>
                            <em></em>
                       		Xuất bản một vị trí mới
                    	</h1>
                    </dt>
                    <dd>
                    	<form method="post" id="jobForm">
                    		<input type="hidden" value="" id="position_id">
                            <input type="hidden" value="" name="id">
                            <input type="hidden" value="create" name="preview">
                            <input type="hidden" value="25927" name="companyId">
                            <input type="hidden" value="c29d4a7c35314180bf3be5eb3f00048f" name="resubmitToken">
                            <table class="btm">
                            	<tbody><tr>
                                	<td width="25"><span class="redstar">*</span></td>
                                	<td width="85">Công việc</td>
                                	<td>
                                    	<input type="hidden" id="positionType" value="" name="positionType">
                                        <input type="button" value="" id="select_category" class="selectr selectr_380 require" tips="Thể loại công việc không thể trống！"  attributes="error_position_type">
                                      	<span for="position_type" generated="true" class="error" id="error_position_type" style="display:none">Thể loại công việc không thể trống!</span>                                     
                                        <div class="dn" id="box_job" style="display: none;">
                                        
                                        <#if topPositionCategoryList?size gt 0>
				 							<#list topPositionCategoryList as topPositionCategory>
                                        
                                                <dl>
                                                    <dt>${topPositionCategory.name!""}</dt>  <!--一级菜单-->
                                                    <dd>
                                                        <ul class="reset job_main">
                                                        
                                                        	<#if secondPositionCategoryList?size gt 0>
				 												<#list secondPositionCategoryList as secondPositionCategory>
				 													<#if secondPositionCategory._parentId == topPositionCategory.id>
			                                                            <li>
			                                                                <span>${secondPositionCategory.name!""}</span> <!--二级菜单 -->
			                                                                    <ul class="reset job_sub dn">
			                                                                    
				                                                                    <#if thirdPositionCategoryList?size gt 0>
					 																	<#list thirdPositionCategoryList as thirdPositionCategory>
			                                                                      			 <#if thirdPositionCategory._parentId == secondPositionCategory.id>
			                                                                      				 <li>${thirdPositionCategory.name!""}</li>  <!--三级菜单 -->
			                                                                       			 </#if>
			                                                                        	</#list>
			                                                                        </#if>
			                                                                    </ul>
			                                                            </li>
		                                                            </#if>
                                                           		</#list>
                                                           	</#if>
                                                		
                                                    	</ul>
                                                    </dd>
                                                </dl>
                                                
                                          </#list>
                                         </#if>
                                                
                                        </div>
                                    </td>
                                </tr>
                            	<tr>
                                	<td><span class="redstar">*</span></td>
                                	<td>Tiêu đề: </td>
                                		<td>
                                    	<input type="text"  class="require"  placeholder="Vui lòng chọn tên vị trí, chọn danh mục công việc"  name="positionName" id="positionName"  tips="Tên của vị trí không thể trống!"  attributes="error_position_name">
                                    	<span for="position_name" generated="true" class="error" id="error_position_name" style="display:none">Tên của vị trí không thể trống!</span>
                                    </td>
                                </tr>
                            	<tr>
                                	<td></td>
                                	<td>Bộ phận: </td>
                                	<td>
                                    	<input type="text" placeholder="Vui lòng vào bộ phận của bạn" value="" name="department" id="department" >	
                                    </td>
                                </tr>
                            </tbody></table>
                            
                            <table class="btm">
                            	<tbody><tr>
                                	<td width="25"><span class="redstar">*</span></td>
                                	<td width="85">Loại hình: </td>
                                	<td>
                                    	<ul class="profile_radio clearfix reset">
                                    		
	                                           <li>
		                                         	 Full<em></em>
		                                           <input type="radio" value="full" id="work_type1"> 
		                                       </li>
	                                           <li>
		                                       		Part<em></em>
		                                           <input type="radio" value="part" id="work_type2"> 
		                                       </li>
		                                       <li>
		                                          Remote<em></em>
		                                           <input type="radio" value="remote" id="work_type3"> 
		                                       </li>
	                                       
	                                       
                                       </ul>
                                    </td>
                                </tr>
                            	<tr>
                                	<td><span class="redstar">*</span></td>
                                	<td>Lương: </td>
                                    <!--<h3><span>(最高月薪不能大于最低月薪的2倍)</span></h3> -->
                                	<td>
                                    	<div class="salary_range">
                                            <div>
                                                <input type="text" placeholder="Mức lương tối thiểu hàng tháng"   class="require" id="position_min_money"  oninput = "value=value.replace(/[^\d]/g,'')" tips="Mức lương công việc không thể trống!"  attributes="error_position_money"> 
                                                <span>k</span>
                                            </div>
                                            <div>
                                                <input type="text" placeholder="Mức lương tối đa hàng tháng"  class="require" id="position_max_money" oninput = "value=value.replace(/[^\d]/g,'')" tips="Mức lương công việc không thể trống!"  attributes="error_position_money"> 
                                                <span>k</span>
                                            </div>
                                            <span>Chỉ nhập số</span>
                                        </div>
                                        <span for="position_money" generated="true" class="error" id="error_position_money" style="display:none">Mức lương công việc không thể trống!</span>
                                    </td>
                                </tr>
                            	<tr>
                                	<td><span class="redstar">*</span></td>
                                	<td>Thành phố: </td>
                                	<td>
                                    	<input type="text" id="position_city" placeholder="Vui lòng vào một thành phố làm việc, chẳng hạn như: Bắc Kinh"   class="require" tips="Thành phố nơi vị trí được đặt không thể trống!"  attributes="error_position_city">
                                    	<span for="position_city" generated="true" class="error" id="error_position_city" style="display:none">Thành phố nơi vị trí được đặt không thể trống!</span>
                                    </td>
                                </tr>
                            </tbody></table>

                            <table class="btm">
                            	<tbody><tr>
                                	<td width="25"><span class="redstar">*</span></td>
                                	<td width="85">kinh nghiệm: </td>
                                	<td>
                                    	<input type="hidden" id="experience" value="" name="workYear">
                                        <input type="button" value="Không yêu cầu" id="select_experience" class="selectr selectr_380">                                      
                                        <div class="boxUpDown boxUpDown_380 dn" id="box_experience" style="display: none;">
                                            <ul>
                                                    <li>
                                    					Không yêu cầu
                                                    </li>
                                                    <li>
                                                		Tốt nghiệp
                                                    </li>
                                                    <li>
                                                		Dưới 1 năm
                                                    </li>
                                                    <li>
                                                        1-3 năm
                                                    </li>
                                                    <li>
                                                        3-5 năm
                                                    </li>
                                                    <li>
                                                        5-10 năm
                                                    </li>
                                                    <li>
                                                        Hơn 10 năm
                                                    </li>
                                            </ul>
                                    	</div>
                                    </td>
                                </tr>
                            	<tr>
                                	<td><span class="redstar">*</span></td>
                                	<td>Yêu cầu học tập</td>
                                	<td>
                                    	<input type="hidden" id="education" value="" name="education">
                                        <input type="button" value="Vô hạn" id="select_education" class="selectr selectr_380">                                      
                                        <div class="boxUpDown boxUpDown_380 dn" id="box_education" style="display: none;">
                                            <ul>
                                                    <li>
                                                       	 Vô hạn
                                                    </li>
                                                    <li>
                                                       	 Cao đẳng
                                                    </li>
                                                    <li>
                                                    	Đại học
                                                    </li>
                                                    <li>
                                                    	bậc thầy
                                                    </li>
                                                    <li>
                                                       	 Bằng tiến sĩ
                                                    </li>
                                            </ul>
                                    	</div>
                                    </td>
                                </tr>
                            </tbody></table>
                           
                            <table class="btm">
                            	<tbody><tr>
                                	<td width="25"><span class="redstar">*</span></td>
                                	<td width="85">Yêu cầu: </td>
                                	<td>
                                    	<input type="text" placeholder="30 từ mô tả sự hấp dẫn của vị trí này, chẳng hạn như: lợi ích, triển vọng phát triển, v.v."    class="input_520 require" id="position_advantage" tips="Sự cám dỗ của vị trí không thể trống rỗng!"  attributes="error_position_advantage">
                                    	<span for="position_advantage" generated="true" class="error" id="error_position_advantage" style="display:none">Sự cám dỗ của vị trí không thể trống rỗng!</span>
                                    </td>
                                </tr>
                            	<tr>
                                	<td><span class="redstar">*</span></td>
                                	<td>mô tả công việc</td>
                                	<td>
                                    	<span class="c9 f14">(Nên mô tả trách nhiệm làm việc trong việc tách.Không nhập hộp thư của công ty, số điện thoại liên hệ và các liên kết bên ngoài khác, nếu không nó sẽ được tự động xóa)</span>
                                    	<textarea id="position_description" class="require"  tips="职位描述不能为空！"  attributes="error_position_description"></textarea>
                                       	<span for="position_description" generated="true" class="error" id="error_position_description" style="display:none">Mô tả công việc không thể trống!</span>
                                    </td>
                                </tr>
                                <tr>
                                	<td><span class="redstar">*</span></td>
                                	<td>địa chỉ: </td>
                                	<td>
                                    	<input type="text" placeholder="Vui lòng nhập địa chỉ làm việc chi tiết"   name="positionAddress" class="input_520 require" id="position_address"  attributes="error_position_address" tips="Địa chỉ của vị trí không thể trống!" >	
                                    	<span for="position_address" generated="true" class="error" id="error_position_address" style="display:none">Địa chỉ của vị trí không thể trống!</span>
                                        <input type="hidden" value="" name="positionLng" id="lng">
                            			<input type="hidden" value="" name="positionLat" id="lat">
                                    </td>
                                </tr>
                            </tbody></table>
                            
                            <table>
                            	<tbody>
                                <tr>
                                	<td width="25"></td>
                                	<td colspan="2">
                                    	<input type="button" value="Đăng tuyển"  onclick="saveNewPosition();" class="btn_32">
                                    </td>
                                </tr>
                         	</tbody></table>
                        </form>
                    </dd>
                </dl>
            </div><!-- end .content -->
<#include "../common/alert.ftl"/>
<!------------------------------------- 弹窗lightbox ----------------------------------------->

<!------------------------------------- end ----------------------------------------->
<!-- <script type="text/javascript" src="/home/style/js/tinymce.min.js"></script>


<!-- old -->
<script src="/home/style/js/jquery.tinymce.js" type="text/javascript"></script>
<!-- end old -->

<script src="/home/style/js/jobs.min.js" type="text/javascript"></script>
<script type="text/javascript">
var workType = '';
//获取工作性质的值
 $(function () {
 	document.getElementById("work_type1").onclick = function(){
            workType = $("#work_type1").val();
        }
    document.getElementById("work_type2").onclick = function(){
            workType = $("#work_type2").val();
        }
    document.getElementById("work_type3").onclick = function(){
            workType = $("#work_type3").val();
        }
 });
window.onload = function(){
	<!--还没认证公司，不让访问该页面-->
	<#if errorMsg??>
		$("#errorMsg").html("!!!"+'${errorMsg}');
		$.colorbox({inline:true, href:$("#errorTip"),title:"Thông báo"});
		setTimeout(function(){  
				window.location.href = "/home/company/my_company";  //页面跳转
		},3000);
	</#if>
	
	<!--判断是编辑职位还是新增职位-->
	<#if editPosition??>
		<!--是编辑-->
		document.getElementById("select_category").value='${editPosition.type!""}';
		document.getElementById("positionName").value='${editPosition.name!""}';
		document.getElementById("department").value='${editPosition.department!""}';
		document.getElementById("position_min_money").value='${editPosition.minMoney!""}';
		document.getElementById("position_max_money").value='${editPosition.maxMoney!""}';
		document.getElementById("position_city").value='${editPosition.city!""}';
		document.getElementById("select_experience").value='${editPosition.workExperience!""}';
		document.getElementById("select_education").value='${editPosition.degree!""}';
		document.getElementById("position_advantage").value='${editPosition.advantage!""}';
		document.getElementById("position_address").value='${editPosition.address!""}';
		var html = '${editPosition.description!""}';
		var description = html.replace(/<br\/>/g, "\n");  //文本框中回车换行处理
		document.getElementById("position_description").value = description;
		document.getElementById("position_id").value = '${editPosition.id!""}';
		<#if editPosition.workType == 'full'>
			workType = 'full';
			$("#work_type1").click();
		</#if>
		<#if editPosition.workType == 'part'>
			workType = 'part';
			$("#work_type2").click();
		</#if>
		<#if editPosition.workType == 'remote'>
			workType = 'remote';
			$("#work_type3").click();
		</#if>
		
	<#else>
		<!--是新增-->
		document.getElementById("positionName").value='';
		workType = "full";
		$("#work_type1").click();
	</#if>
}


//保存职位信息
function saveNewPosition(){
 var id = $("#position_id").val();
 var positionType = $("#select_category").val();
 var positionName = $("#positionName").val();
 var positionDepartment = $("#department").val();
 var positionMinMoney = $("#position_min_money").val();
 var positionMaxMoney = $("#position_max_money").val();
 var positionCity = $("#position_city").val();
 var workExperience = $("#select_experience").val();
 var degree = $("#select_education").val(); 
 var positionAdvantage = $("#position_advantage").val(); 
 var positionDescription = $("#position_description").val();
 positionDescription=positionDescription.replace(/\n/g,'<br/>');   //文本框中回车换行处理
 var positionAddress = $("#position_address").val(); 
 

 
	$('#error_position_type').css('display','none');
	$('#error_position_name').css('display','none');
	$('#error_position_money').css('display','none');
	$('#error_position_city').css('display','none');
	$('#error_position_advantage').css('display','none');
	$('#error_position_description').css('display','none');
	$('#error_position_address').css('display','none');
	//进行统一表单非空验证
	if(!checkForm('jobForm'))
	{
		return;
	}
 
  $.ajax({
		url:'/home/position/save',
		dataType:'json',
		type:'post',
		data:{type:positionType,name:positionName,department:positionDepartment,workType:workType,minMoney:positionMinMoney,maxMoney:positionMaxMoney,city:positionCity,
			workExperience:workExperience,degree:degree,advantage:positionAdvantage,description:positionDescription,address:positionAddress,id:id
		},
		success:function(data){
			if(data.code == 1){
				$("#successMsg").html("Được lưu thành công!Vui lòng đợi cho quản trị viên xem xét!");
				$.colorbox({inline:true, href:$("#successTip"),title:"Thông báo"});
				setTimeout(function(){  
						window.location.href = "/home/position/my_publish_position?positionState=wait";  //跳转到待审核职位页面
						},3000);
			}else if(data.code == 2){
				$("#successMsg").html("Được bảo tồn thành công!Vui lòng đợi cho quản trị viên xem xét!");
				$.colorbox({inline:true, href:$("#successTip"),title:"Thông báo"});
				setTimeout(function(){  
						window.location.href = "/home/position/my_publish_position?positionState=out";  //跳转到已下线职位页面
						},3000);
			}else{
					$("#errorMsg").html("保存失败，"+data.msg+"!!!");
					$.colorbox({inline:true, href:$("#errorTip"),title:"Thông báo"});
			}
		}
	});
  
  
}


</script>

<#include "../common/footer.ftl"/>	
<script src="/home/style/js/core.min.js" type="text/javascript"></script>
<script src="/home/style/js/popup.min.js" type="text/javascript"></script>



<div id="cboxOverlay" style="display: none;"></div><div id="colorbox" class="" role="dialog" tabindex="-1" style="display: none;"><div id="cboxWrapper"><div><div id="cboxTopLeft" style="float: left;"></div><div id="cboxTopCenter" style="float: left;"></div><div id="cboxTopRight" style="float: left;"></div></div><div style="clear: left;"><div id="cboxMiddleLeft" style="float: left;"></div><div id="cboxContent" style="float: left;"><div id="cboxTitle" style="float: left;"></div><div id="cboxCurrent" style="float: left;"></div><button type="button" id="cboxPrevious"></button><button type="button" id="cboxNext"></button><button id="cboxSlideshow"></button><div id="cboxLoadingOverlay" style="float: left;"></div><div id="cboxLoadingGraphic" style="float: left;"></div></div><div id="cboxMiddleRight" style="float: left;"></div></div><div style="clear: left;"><div id="cboxBottomLeft" style="float: left;"></div><div id="cboxBottomCenter" style="float: left;"></div><div id="cboxBottomRight" style="float: left;"></div></div></div><div style="position: absolute; width: 9999px; visibility: hidden; display: none;"></div></div></body></html>

<!DOCTYPE HTML>
<html xmlns:wb="http://open.weibo.com/wb"><head>
</script><script type="text/javascript" async="" src="/home/style/js/conversion.js"></script><script src="/home/style/js/allmobilize.min.js" charset="utf-8" id="allmobilize"></script><style type="text/css"></style>
<meta content="no-siteapp" http-equiv="Cache-Control">
<link  media="handheld" rel="alternate">
<meta content="text/html; charset=utf-8" http-equiv="Content-Type">
<title>Nền tảng tuyển dụng </title>
<meta content="23635710066417756375" property="qc:admins">
<meta name="description" content="">
<meta name="keywords" content="">
<meta content="QIQ6KC1oZ6" name="baidu-site-verification">

<script type="text/javascript">
</script>
<link href="http://www.lagou.com/images/favicon.ico" rel="Shortcut Icon">
<link href="/home/style/css/style.css" type="text/css" rel="stylesheet">
<link href="/home/style/css/external.min.css" type="text/css" rel="stylesheet">
<link href="/home/style/css/popup.css" type="text/css" rel="stylesheet">
<script type="text/javascript" src="/home/style/js/jquery.1.10.1.min.js"></script>
<script src="/home/style/js/jquery.lib.min.js" type="text/javascript"></script>
<script type="text/javascript" src="/home/style/js/ajaxfileupload.js"></script>
<script src="/home/style/js/additional-methods.js" type="text/javascript"></script>

<script type="text/javascript">
var youdao_conv_id = 271546; 
</script> 
<script src="/home/style/js/conv.js" type="text/javascript"></script>
<script src="/home/style/js/ajaxCross.json" charset="UTF-8"></script></head>
<body>
<div id="body">
	<#include "../common/top_menu.ftl"/>
    <div id="container">
        	  	
        <div class="clearfix">
            <div class="content_l recommend_list">
            	<#if SearchValue??>
            		<h2><font size="3">Dựa theo <font color="red">${SearchValue!""}</font> kết quả tìm kiếm: </font></h2>
            	<#else>
            		<h2></h2>
            	</#if>
            	
            	
            	<ul class="hot_pos reset">
            			<#if PositionList?size gt 0>
				 			<#list PositionList as position>	
				 			
				 			<#if position_index % 2 == 0>
			            		<li class="clearfix">
			            		
				            	  	<div class="hot_pos_l">
				                    	<div class="mb10">
				                        	<a href="/home/position/detail?id=${position.id!""}" style="text-decoration:none">${position.name!""}</a> 
				                            &nbsp;
				                            <span class="c9">[${position.city!""}]</span>
				                        </div>
				                        <span><em class="c7">Lương : </em>${position.minMoney!""}k-${position.maxMoney!""}k</span>
				                        <span><em class="c7">kinh nghiệm:</em> ${position.workExperience!""}</span>
																<br />
				                        <span><em class="c7">Giáo dục tối thiểu: </em>${position.degree!""}</span>
				                        <br />
				                        <span><em class="c7">Yêu cầu:</em>${position.advantage!""}</span>
				                        <br />
					                    <span>Thời gian: ${position.createTime!""}</span>
				                    </div>
				            </#if>
				            <#if position_index % 2 == 1>
				                	<div class="hot_pos_r">
				                    	<div class="mb10 recompany">
				                    		<a href="/home/position/detail?id=${position.id!""}" style="text-decoration:none">${position.name!""}</a> 
				                            &nbsp;
				                            <span class="c9">[${position.city!""}]</span>
				                        </div>
				                        <span><em class="c7">Lương : </em>${position.minMoney!""}k-${position.maxMoney!""}k</span>
				                        <span><em class="c7">kinh nghiệm:</em> ${position.workExperience!""}</span>
				                        <span><em class="c7">Giáo dục tối thiểu: </em>${position.degree!""}</span>
				                        <br />
				                        <span><em class="c7">Cám dỗ công việc:</em>${position.advantage!""}</span>
				                        <br />
					                    <span>Thời gian:${position.createTime!""}</span>
				                    </div>
				                    
				                    
			                	</li>
	               	     	</#if>
	                	</#list>
	                </#if>              	            				          
	                <#if PositionTotal %2 == 1>
	                	</li>
	                </#if>		                	            				            
	                		               
	                		                	            				            
	                		                	            				            	
    	            </ul>
	            
                    <div class="Pagination myself">
                    
                    	<a title="trang nhất" href="/home/position/list?page=1&rows=20&search_value=${SearchValue!""}">trang nhất</a>
       					<#if currentPage == 1>
       					 	<a title="没有上一页"  href="javascript:void(0);">Không có trang trước</a>
 						<#else>
 							<a title="上一页"  href="/home/position/list?page=${currentPage-1}&rows=20&search_value=${SearchValue!""}">Trang cuối</a>
 						</#if>
 
 						<#list 1..totalPage as i>
 							<#if i == currentPage-2>
 								<a title="${i}" href="/home/position/list?page=${i}&rows=20&search_value=${SearchValue!""}">${i}</a>
 							</#if>    
						  	<#if i == currentPage-1>
 								<a title="${i}" href="/home/position/list?page=${i}&rows=20&search_value=${SearchValue!""}">${i}</a>
 							</#if>   
 							<#if i == currentPage>
 								<a title="${i}" href="/home/position/list?page=${i}&rows=20&search_value=${SearchValue!""}" class="current">${i}</a>
 							</#if>   
 							<#if i == currentPage+1>
 								<a title="${i}" href="/home/position/list?page=${i}&rows=20&search_value=${SearchValue!""}">${i}</a>
 							</#if>    
						  	<#if i == currentPage+2>
 								<a title="${i}" href="/home/position/list?page=${i}&rows=20&search_value=${SearchValue!""}">${i}</a>
 							</#if>   
						</#list>
       					
       					
       					
       					<#if currentPage == totalPage>
       					 	<a title="Không có trang tiếp theo"  href="javascript:void(0);">Không có trang tiếp theo</a>
 						<#else>
 							<a title="Trang tiếp theo"  href="/home/position/list?page=${currentPage+1}&rows=20&search_value=${SearchValue!""}">下一页</a>
 						</#if>
 						
       					<a title="trang cuối" href="/home/position/list?page=${totalPage}&rows=20&search_value=${SearchValue!""}">trang cuối</a>
       					
       					
                    </div>
                           
                           
                </div>	
           <div class="content_r">
            	<div class="subscribe_side">
	                    <div class="subpos"><span>Nộp CV</span></div>
	                    <div class="c7">Cung cấp cho bạn rất nhiều vị trí mà bạn quan tâm
	                    </div>
	                    <div class="count">Đã có
	                    		                    		<em>${resumeTotal!"0"}</em>
	                    		                    	người nộp hồ sơ
	                    </div>
	            	
	            </div> 
                <div class="greybg qrcode mt20">
                	<img src="https://media.monster.com.vn/career-advice/wp-content/uploads/2022/03/interview-question-and-answer-for-hr-recruiter.jpg" width="242" height="242" alt="微信公众号二维码" />
                    <span class="c7"></span>
                </div>
                <#--  <a href="javascript:void(0);"  class="eventAd">
               		<img src="/home/style/images/subject280.jpg" width="280" height="135" />
               	</a>
               	<a href="javascript:void(0);" class="eventAd">
               		<img src="/home/style/images/rising280.png" width="280" height="135" />
               	</a>  -->
            </div>
       	</div>
      <input type="hidden" id="userid" name="userid" value="314873">

<#include "../common/footer.ftl"/>
<script src="/home/style/js/core.min.js" type="text/javascript"></script>
<script src="/home/style/js/popup.min.js" type="text/javascript"></script>


<script type="text/javascript">

</script>

<div id="cboxOverlay" style="display: none;"></div><div id="colorbox" class="" role="dialog" tabindex="-1" style="display: none;"><div id="cboxWrapper"><div><div id="cboxTopLeft" style="float: left;"></div><div id="cboxTopCenter" style="float: left;"></div><div id="cboxTopRight" style="float: left;"></div></div><div style="clear: left;"><div id="cboxMiddleLeft" style="float: left;"></div><div id="cboxContent" style="float: left;"><div id="cboxTitle" style="float: left;"></div><div id="cboxCurrent" style="float: left;"></div><button type="button" id="cboxPrevious"></button><button type="button" id="cboxNext"></button><button id="cboxSlideshow"></button><div id="cboxLoadingOverlay" style="float: left;"></div><div id="cboxLoadingGraphic" style="float: left;"></div></div><div id="cboxMiddleRight" style="float: left;"></div></div><div style="clear: left;"><div id="cboxBottomLeft" style="float: left;"></div><div id="cboxBottomCenter" style="float: left;"></div><div id="cboxBottomRight" style="float: left;"></div></div></div><div style="position: absolute; width: 9999px; visibility: hidden; display: none;"></div></div></body></html>
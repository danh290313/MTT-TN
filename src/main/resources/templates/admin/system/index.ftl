<!--后端系统首页ftl-->
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta name="copyright" content="All Rights Reserved, Copyright (C) 2020, 杨杨吖, Ltd." />
<title>Quản lý nền Trang chủ</title>
<link rel="stylesheet" type="text/css" href="/admin/easyui/easyui/1.3.4/themes/default/easyui.css" />
<link rel="stylesheet" type="text/css" href="/admin/easyui/css/wu.css" />
<link rel="stylesheet" type="text/css" href="/admin/easyui/css/icon.css" />
<script type="text/javascript" src="/admin/easyui/js/jquery-1.8.0.min.js"></script>
<script type="text/javascript" src="/admin/easyui/easyui/1.3.4/jquery.easyui.min.js"></script>
<script type="text/javascript" src="/admin/easyui/easyui/1.3.4/locale/easyui-lang-zh_CN.js"></script>
<script>
    var pc; 
    //不要放在$(function(){});中
    $.parser.onComplete = function () {
        if (pc) clearTimeout(pc);
        pc = setTimeout(closes, 1000);
    } 

    function closes() {
    	$('#loading').fadeOut('normal', function () {
            $(this).remove();
        });
    }
</script>
</head>
<body class="easyui-layout">
<div id="loading" style="position:absolute;z-index:1000;top:0px;left:0px;width:100%;height:100%;background:#FFFFFF;text-align :center;padding-top:6%;">
     <img src="/admin/easyui/images/loading.jpg" width="50%">
</div> 
	<!-- begin of header -->
	<div class="wu-header" data-options="region:'north',border:false,split:true">
    	<div class="wu-header-left">
        	<h1>Hệ thống quản lý nền</h1>
        </div>
        <div class="wu-header-right">
        	<p><strong class="easyui-tooltip" title="${admin.adminName!""}">Người dùng thân mến:${admin.adminName!""}</strong>，Chào mừng!</p>
            <p><a href="/home/system/index" target="_blank">Trang chủ</a>|<a href="/admin/system/logout">Logout</a></p>
        </div>
    </div>
    <!-- end of header -->
    <!-- begin of sidebar -->
	<div class="wu-sidebar" data-options="region:'west',split:true,border:true,title:'Chức năng điều hướng'"> 
    	<div class="easyui-accordion" data-options="border:false,fit:true"> 
       
        	<div title="Quản lý người dùng" data-options="iconCls:'icon-group-gear'" style="padding:5px;">  	
    			<ul class="easyui-tree wu-side-tree">
        			<li iconCls="icon-user-brown"><a href="javascript:void(0)" data-icon="icon-user-brown" data-link="/admin/admin/my_info" iframe="1">thông tin của tôi</a></li>
        			<li iconCls="icon-group"><a href="javascript:void(0)" data-icon="icon-group" data-link="/admin/user/user_info" iframe="1">thông tin người dùng</a></li>
                </ul>
            </div>
        	<div title="Quản lý công việc" data-options="iconCls:'icon-feed'" style="padding:5px;">  	
    			<ul class="easyui-tree wu-side-tree">
        			<li iconCls="icon-tag-pink"><a href="javascript:void(0)" data-icon="icon-tag-pink" data-link="/admin/position_category/list" iframe="1">Danh mục công việc</a></li>
        			<li iconCls="icon-application-form"><a href="javascript:void(0)" data-icon="icon-application-form" data-link="/admin/position/list" iframe="1">Danh sách đăng tuyển</a></li>
                </ul>
            </div>
        	<div title="Quản lý doanh nghiệp" data-options="iconCls:'icon-house'" style="padding:5px;">  	
    			<ul class="easyui-tree wu-side-tree">
        			<li iconCls="icon-application-form"><a href="javascript:void(0)" data-icon="icon-application-form" data-link="/admin/company/list" iframe="1">Danh sách công ty</a></li>
                </ul>
            </div>
            <div title="Quản lý nhật ký" data-options="iconCls:'icon-table-cell'" style="padding:5px;">  	
    			<ul class="easyui-tree wu-side-tree">
        			<li iconCls="icon-page-white-text"><a href="javascript:void(0)" data-icon="icon-page-white-text" data-link="/admin/operater_log/list" iframe="1">Danh sách nhật ký</a></li>
                </ul>
            </div>
        </div>
    </div>	
    <!-- end of sidebar -->    
    <!-- begin of main -->
    <div class="wu-main" data-options="region:'center'">
        <div id="wu-tabs" class="easyui-tabs" data-options="border:false,fit:true">  
            <div title="trang nhất" data-options="closable:false,iconCls:'icon-tip',cls:'pd3'">
            <div title="Chào mừng" style="padding:20px;overflow:hidden; color:red; " >
				<p style="font-size: 50px; line-height: 60px; height: 60px;"></p>
				<p style="font-size: 25px; line-height: 30px; height: 30px;">Chào mừng bạn đến với hệ thống quản lý nền</p>

			</div>
            
            </div>
        </div>
    </div>
    <!-- end of main --> 
    <!-- begin of footer -->
	<div class="wu-footer" data-options="region:'south',border:true,split:true">
    	&copy; All Rights Reserved
    </div>
    <!-- end of footer -->  
    <script type="text/javascript">
		$(function(){
			$('.wu-side-tree a').bind("click",function(){
				var title = $(this).text();
				var url = $(this).attr('data-link');
				var iconCls = $(this).attr('data-icon');
				var iframe = $(this).attr('iframe')==1?true:false;
				addTab(title,url,iconCls,iframe);
			});	
		})
		
		
		/**
		* Name 添加菜单选项
		* Param title 名称
		* Param href 链接
		* Param iconCls 图标样式
		* Param iframe 链接跳转方式（true为iframe，false为href）
		*/	
		function addTab(title, href, iconCls, iframe){
			var tabPanel = $('#wu-tabs');
			if(!tabPanel.tabs('exists',title)){
				var content = '<iframe scrolling="auto" frameborder="0"  src="'+ href +'" style="width:100%;height:100%;"></iframe>';
				if(iframe){
					tabPanel.tabs('add',{
						title:title,
						content:content,
						iconCls:iconCls,
						fit:true,
						cls:'pd3',
						closable:true
					});
				}
				else{
					tabPanel.tabs('add',{
						title:title,
						href:href,
						iconCls:iconCls,
						fit:true,
						cls:'pd3',
						closable:true
					});
				}
			}
			else
			{
				tabPanel.tabs('select',title);
			}
		}
		/**
		* Name 移除菜单选项
		*/
		function removeTab(){
			var tabPanel = $('#wu-tabs');
			var tab = tabPanel.tabs('getSelected');
			if (tab){
				var index = tabPanel.tabs('getTabIndex', tab);
				tabPanel.tabs('close', index);
			}
		}
	</script>
</body>
</html>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html class="no-js fixed-layout">
<head>
  <meta charset="UTF-8">
	<title>Admin Index Page | SpiderSystem</title>
	<!-- 以下代码告诉IE浏览器，IE8/9及以后的版本都会以最高版本IE来渲染页面 -->
	<meta http-equiv="X-UA-Compatible" content="IE=edge">

  <meta name="description" content="the admin_index of SpiderSystem">
  <meta name="keywords" content="index SpiderSystem">
  <meta name="viewport" content="width=device-width, initial-scale=1">
	<meta name="renderer" content="webkit">
	<!-- 以下代码取消第三方转码 -->
	<meta name="Cache-Control" content="no-siteapp">

	<link rel="icon" type="image/png"
		href="${pageContext.request.contextPath}/static/amazeui_assets/i/favicon.png">
  <link rel="apple-touch-icon-precomposed"
    href="${pageContext.request.contextPath}/static/amazeui_assets/i/app-icon72x72@2x.png">
  <link rel="stylesheet"
		href="${pageContext.request.contextPath}/static/amazeui_assets/css/amazeui.min.css">
  <link rel="stylesheet"
  	href="${pageContext.request.contextPath}/static/amazeui_assets/css/admin.css">
  <link rel="stylesheet"
  	href="${pageContext.request.contextPath}/static/css/pagination.css">
</head>
<body>
  <!--[if lte IE 9]>
  <p class="browsehappy">你正在使用<strong>过时</strong>的浏览器，Amaze UI 暂不支持。 请 <a href="http://browsehappy.com/" target="_blank">升级浏览器</a>
    以获得更好的体验！</p>
  <![endif]-->

  <header class="am-topbar am-topbar-inverse admin-header">
    <div class="am-topbar-brand">
      <strong>SpiderSystem</strong> <small>后台管理系统</small>
    </div>

    <div class="am-collapse am-topbar-collapse" id="topbar-collapse">
      <ul class="am-nav am-nav-pills am-topbar-nav am-topbar-right admin-header-list">
        <li>
          <a href="#">
            <span class="am-icon-envelope-o"></span>收件箱
            <span class="am-badge am-badge-warning">5</span>
          </a>
        </li>
        <li class="am-dropdown" data-am-dropdown>
          <a href="#" class="am-dropdown-toggle" data-am-dropdown-toggle>
            <span class="am-icon-users"></span>管理员
            <span class="am-icon-caret-down"></span>
          </a>
          <ul class="am-dropdown-content">
            <li>
              <a href="#">
                <span class="am-icon-user"></span>资料
              </a>
            </li>
            <li>
              <a href="#">
                <span class="am-icon-cog"></span>设置
              </a>
            </li>
            <li>
              <a href="#">
                <span class="am-icon-power-off"></span>退出
              </a>
            </li>
          </ul>
        </li>
        <li class="am-hide-sm-only">
          <a href="#" id="admin-fullscreen">
            <span class="am-icon-arrows-alt"></span>
            <span class="admin-fullText">开启全屏</span>
          </a>
        </li>
      </ul>
    </div>
  </header>

  <div class="am-cf admin-main">
    <!-- sidebar start-->
    <div class="admin-sidebar am-offcanvas" id="admin-offcanvas">
      <div class="am-offcanvas-bar admin-offcanvas-bar">
        <ul class="am-list admin-sidebar-list">
          <li>
            <a href="${pageContext.request.contextPath}/admin/index">
              <span class="am-icon-home"></span> 首 页
            </a>
          </li>
          <!--
          <li class="admin-parent">
            <a class="am-cf" data-am-collapse="{target: '#collapse-nav'}"><span class="am-icon-file"></span> 页面模块 <span class="am-icon-angle-right am-fr am-margin-right"></span></a>
            <ul class="am-list am-collapse admin-sidebar-sub am-in" id="collapse-nav">
              <li><a href="admin-user.html" class="am-cf"><span class="am-icon-check"></span> 个人资料<span class="am-icon-star am-fr am-margin-right admin-icon-yellow"></span></a></li>
              <li><a href="admin-help.html"><span class="am-icon-puzzle-piece"></span> 帮助页</a></li>
              <li><a href="admin-gallery.html"><span class="am-icon-th"></span> 相册页面<span class="am-badge am-badge-secondary am-margin-right am-fr">24</span></a></li>
              <li><a href="admin-log.html"><span class="am-icon-calendar"></span> 系统日志</a></li>
              <li><a href="admin-404.html"><span class="am-icon-bug"></span> 404</a></li>
            </ul>
          </li>
          -->
          <li class="admin-parent">
            <a class="am-cf" data-am-collapse="{target: '#collapse-spider'}">
              <span class="am-icon-bug"></span> 爬虫管理
              <span class="am-icon-angle-right am-fr am-margin-right"></span>
            </a>
            <ul class="am-list am-collapse admin-sidebar-sub am-in" id="collapse-spider">
              <li>
                <a href="${pageContext.request.contextPath}/spider/check" class="am-cf">
                  <span class="am-icon-bug"></span> 系统级爬虫
                  <span class="am-icon-star am-fr am-margin-right admin-icon-yellow"></span>
                </a>
              </li>
              <li>
                <a href="#">
                  <span class="am-icon-bug"></span> 用户级爬虫</a>
                </li>
            </ul>
          </li>

          <li class="admin-parent">
            <a class="am-cf" data-am-collapse="{target: '#collapse-data'}">
              <span class="am-icon-table"></span> 数据库
              <span class="am-icon-angle-right am-fr am-margin-right"></span>
            </a>
            <ul class="am-list am-collapse admin-sidebar-sub am-in" id="collapse-data">
              <li>
                <a href="${pageContext.request.contextPath}/notice/show">
                  <span class="am-icon-pencil-square-o"></span> 公告表
                </a>
              </li>
              <li>
                <a href="${pageContext.request.contextPath}/news/show">
                  <span class="am-icon-pencil-square-o"></span> 新闻表
                </a>
              </li>
            </ul>
          </li>

        </ul>

        <div class="am-panel am-panel-default admin-sidebar-panel">
          <div class="am-panel-bd">
            <p>
              <span class="am-icon-bookmark"></span> 公 告
            </p>
            <p>${notice.getText()}
            </p>
          </div>
        </div>

        <div class="am-panel am-panel-default admin-sidebar-panel">
          <div class="am-panel-bd">
            <p>
              <span class="am-icon-tag"></span>SpiderSystem
            </p>
            <p>Welcome to the SpiderSystem !</p>
          </div>
        </div>

        <ul class="am-list admin-sidebar-list">
          <li>
            <a href="#">
              <span class="am-icon-sign-out"></span> 注 销
            </a>
          </li>
        </ul>

      </div>
    </div>
    <!-- siderbar end -->

    <!-- content start -->
    <div class="admin-content">
      <div class="admin-content-body">
        <div class="am-cf am-padding am-padding-bottom-0">
          <div class="am-fl am-cf"><strong class="am-text-primary am-text-lg">表格</strong> / <small>Table</small></div>
        </div>

        <hr>
        <!--
        <div class="am-g">
          <div class="am-u-sm-12 am-u-md-6">
            <div class="am-btn-toolbar">
              <div class="am-btn-group am-btn-group-xs">
                <button type="button" class="am-btn am-btn-default"><span class="am-icon-plus"></span> 新增</button>
                <button type="button" class="am-btn am-btn-default"><span class="am-icon-save"></span> 保存</button>
                <button type="button" class="am-btn am-btn-default"><span class="am-icon-archive"></span> 审核</button>
                <button type="button" class="am-btn am-btn-default"><span class="am-icon-trash-o"></span> 删除</button>
              </div>
            </div>
          </div>
          <div class="am-u-sm-12 am-u-md-3">
            <div class="am-form-group">
              <select data-am-selected="{btnSize: 'sm'}">
                <option value="option1">所有类别</option>
                <option value="option2">IT业界</option>
                <option value="option3">数码产品</option>
                <option value="option3">笔记本电脑</option>
                <option value="option3">平板电脑</option>
                <option value="option3">只能手机</option>
                <option value="option3">超极本</option>
              </select>
            </div>
          </div>
          <div class="am-u-sm-12 am-u-md-3">
            <div class="am-input-group am-input-group-sm">
              <input type="text" class="am-form-field">
            <span class="am-input-group-btn">
              <button class="am-btn am-btn-default" type="button">搜索</button>
            </span>
            </div>
          </div>
      -->
      </div>

        <div class="am-g">
          <div class="am-u-sm-12">
            <form class="am-form">
              <table class="am-table am-table-striped am-table-hover table-main">
                <thead>
                <tr>
                  <!--
                  <th class="table-check">
                    <input type="checkbox" />
                  </th>
                -->
                  <th class="table-id">
                    id
                  </th>
                  <th class="table-title">
                    text
                  </th>
                  <!--
                  <th class="table-type">
                    类别
                  </th>
                  <th class="table-author am-hide-sm-only">
                    作者
                  </th>
                  <th class="table-date am-hide-sm-only">
                    修改日期
                  </th>
                -->
                  <th class="table-set">
                    操作
                  </th>
                </tr>
                </thead>
                <tbody>
                  <c:forEach var="entity" items="${notices}">
                    <tr>
                      <!--
                      <td>
                        <input type="checkbox" value="${entity.id}">
                      </td>
                    -->
                      <td>
                        ${entity.getId()}
                      </td>
                      <td>
                        ${entity.getText()}
                      </td>
                      <!--
                      <td>
                        default
                      </td>
                      <td class="am-hide-sm-only">
                        测试1号
                      </td>
                      <td class="am-hide-sm-only">
                        2014年9月4日 7:28:47
                      </td>
                    -->
                      <td>
                        <div class="am-btn-toolbar">
                          <div class="am-btn-group am-btn-group-xs">
                            <button type="button" class="am-btn am-btn-default am-btn-xs am-text-secondary" onclick='notice_update("${entity.getId()}","${entity.getText()}")'><span class="am-icon-pencil-square-o"></span> 编辑</button>
                            <button class="am-btn am-btn-default am-btn-xs am-hide-sm-only" onclick='notice_cop("${entity.getText()}")'><span class="am-icon-copy"></span> 复制</button>
                            <button class="am-btn am-btn-default am-btn-xs am-text-danger am-hide-sm-only" onclick="notice_del(${entity.getId()})"><span class="am-icon-trash-o"></span> 删除</button>
                          </div>
                        </div>
                      </td>
                    </tr>
                  </c:forEach>
                </tbody>
              </table>
              
              <div class="am-modal am-modal-prompt" tabindex="-1" id="my-modal" >
  				<div class="am-modal-dialog">
    				<div class="am-modal-hd">Amaze UI</div>
    				<div class="am-modal-bd">
      					输入修改的内容
      				<input id="new_notice_text" type="text" class="am-modal-prompt-input" value="">
    				</div>
    				<div class="am-modal-footer">
      					<span id="cancel" class="am-modal-btn" data-am-modal-cancel>取消</span>
      					<span id="submit" class="am-modal-btn" data-am-modal-confirm>提交</span>
    				</div>
  				</div>
			</div>
              <div id="pager">

              </div>
              
              

              <hr>

              <table class="am-table am-table-striped am-table-hover table-main">
                <thead>
                <tr>
                  <!--
                  <th class="table-check">
                    <input type="checkbox" />
                  </th>
                -->
                  <th class="table-id">
                    id
                  </th>
                  <th class="table-title">
                    text
                  </th>
                  <!--
                  <th class="table-type">
                    类别
                  </th>
                  <th class="table-author am-hide-sm-only">
                    作者
                  </th>
                  <th class="table-date am-hide-sm-only">
                    修改日期
                  </th>
                -->
                  <th class="table-set">
                    操作
                  </th>
                </tr>
                </thead>
                <tbody>
                  <tr>
                    <td>
                      <input id="noticeId" type="text" name="" value="id">
                    </td>
                    <td>
                      <input id="noticeText" type="text" name="" value="text">
                    </td>
                    <td>
                      <button class="am-btn am-btn-default am-btn-xs am-text-secondary" onclick="notice_add()">
                        <span class="am-icon-pencil-square-o"></span> 添加</button>
                    </td>
                  </tr>
                </tbody>
              </table>
            </form>
          </div>

        </div>

      <footer class="admin-content-footer">
        <hr>
        <p class="am-padding-left">@ 2018 All Rights Reserved Zzy.</p>
      </footer>
    </div>
    <!-- content end-->



  </div>

  <!--[if lt IE 9]>
  <script src="http://libs.baidu.com/jquery/1.11.1/jquery.min.js"></script>
  <script src="http://cdn.staticfile.org/modernizr/2.8.3/modernizr.js"></script>
  <script src="assets/js/amazeui.ie8polyfill.min.js"></script>
  <![endif]-->

  <!--[if (gte IE 9)|!(IE)]><!-->
  <script src="${pageContext.request.contextPath}/static/js/jquery.min.js"></script>
  <script src="${pageContext.request.contextPath}/static/js/jquery.pagination.js"></script>
  <!--<![endif]-->
  <script src="${pageContext.request.contextPath}/static/amazeui_assets/js/amazeui.min.js"></script>
  <script src="${pageContext.request.contextPath}/static/amazeui_assets/js/app.js"></script>

  <script type="text/javascript">
     //初始化分页组件
     var count=${notice_count};
     var size=${notice_size};
     var pageNO=${notice_pageNO};
     $("#pager").pagination(count, {
        items_per_page:size,
         current_page:pageNO-1,
         next_text:"下一页",
         prev_text:"上一页",
         num_edge_entries:2,
         load_first_page:false,
        callback:handlePaginationClick
      });

     //回调方法
     function handlePaginationClick(new_page_index, pagination_container){
         location.href="${pageContext.request.contextPath}/notice/show?pageNO="+(new_page_index+1);
     }

     function notice_add(){
       $.ajax({
           url: "${pageContext.request.contextPath}/notice/add",
           type: "POST",
           dataType: "json",
           data: {
             "noticeId": $('#noticeId').val(),
             "noticeText": $('#noticeText').val()
           },
           async: false,
           success: function(data) {
        	  // alert(data.result);
             if(data.result == "success"){
            	 alert("操作成功");
             }else{
            	 alert("数据库操作失败");
             }
             
             // var data = eval("("+data+")");
             // alert(data.result);
             // alert("配置保存成功");
           },
           error: function() {
             alert("保存失败，...请正确输入并且检查网络连接，如确实怀疑服务器问题请联系Zzy");
           }
         });
     }

     function notice_del(noticeId){
    	 $.ajax({
             url: "${pageContext.request.contextPath}/notice/del",
             type: "POST",
             dataType: "json",
             data: {
               "noticeId": noticeId
             },
             async: false,
             success: function(data) {
            	 if(data.result == "success"){
                	 alert("操作成功");
                 }else{
                	 alert("数据库操作失败");
                 }
             },
             error: function() {
               alert("删除失败，...请检查网络连接，如确实怀疑服务器问题请联系Zzy");
             }
           });
     }

     function notice_cop(text){
		    if(text.indexOf('-') !== -1) {
		        let arr = text.split('-');
		        text = arr[0] + arr[1];
		    }
		    var textArea = document.createElement("textarea");
		      textArea.style.position = 'fixed';
		      textArea.style.top = '0';
		      textArea.style.left = '0';
		      textArea.style.width = '2em';
		      textArea.style.height = '2em';
		      textArea.style.padding = '0';
		      textArea.style.border = 'none';
		      textArea.style.outline = 'none';
		      textArea.style.boxShadow = 'none';
		      textArea.style.background = 'transparent';
		      textArea.value = text;
		      document.body.appendChild(textArea);
		      textArea.select();

		      try {
		        var successful = document.execCommand('copy');
		        var msg = successful ? '成功复制到剪贴板' : '该浏览器不支持点击复制到剪贴板';
		       alert(msg);
		      } catch (err) {
		        alert('该浏览器不支持点击复制到剪贴板');
		      }

		      document.body.removeChild(textArea);
     }
     
     function notice_update(noticeId,text){
    	 // alert(text);
    	 $("#new_notice_text").attr('value',text);
    	 $('#my-modal').modal({
    	      relatedTarget: this,
    	      onConfirm: function(e) {
    	        // alert('你输入的是：' + e.data || '')
    	    	  $.ajax({
    	              url: "${pageContext.request.contextPath}/notice/update",
    	              type: "POST",
    	              dataType: "json",
    	              data: {
    	                "noticeId": noticeId,
    	                "noticeText":e.data
    	              },
    	              async: false,
    	              success: function(data) {
    	            	  if(data.result == "success"){
    	                 	 alert("操作成功");
    	                  }else{
    	                 	 alert("数据库操作失败");
    	                  }
    	              },
    	              error: function() {
    	                alert("修改失败，...请检查输入或者网络连接，如确实怀疑服务器问题请联系Zzy");
    	              }
    	            });
    	      },
    	      onCancel: function(e) {
    	        // alert('不想说!');
    	      }
    	    });
     }
   </script>

</body>
</html>
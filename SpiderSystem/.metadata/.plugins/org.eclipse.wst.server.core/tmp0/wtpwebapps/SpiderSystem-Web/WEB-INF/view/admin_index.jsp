<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
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

    <!-- content start-->
    <div class="admin-content">
      <div class="admin-content-body">

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
  <!--<![endif]-->
  <script src="${pageContext.request.contextPath}/static/amazeui_assets/js/amazeui.min.js"></script>
  <script src="${pageContext.request.contextPath}/static/amazeui_assets/js/app.js"></script>

</body>
</html>
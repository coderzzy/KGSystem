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

 <jsp:include page="included_header.jsp"/>

  <div class="am-cf admin-main">
    <!-- sidebar start-->
    <jsp:include page="included_sidebar.jsp"/>
    <!-- siderbar end -->

    <!-- content start-->
    <div class="admin-content">
    <div class="admin-content-body">
      <div class="am-cf am-padding am-padding-bottom-0">
        <div class="am-fl"><strong class="am-text-primary am-text-lg">系统日志</strong> / <small>System Log</small></div>
      </div>

      <hr/>

      <div class="am-g error-log">
        <div class="am-u-sm-12 am-u-sm-centered">
        <pre class="am-pre-scrollable">
<span class="am-text-success">[Tue Jan 11 17:32:52 2013]</span> <span class="am-text-danger">[error]</span> [google 123.124.2.2] client denied by server: /export/home/macadmin/testdoc
<span class="am-text-success">[Tue Jan 11 17:32:52 2013]</span> <span class="am-text-danger">[error]</span> [google 123.124.2.2] client denied by server: /export/home/macadmin/testdoc - no such file
<span class="am-text-success">[Tue Jan 11 17:32:52 2013]</span> <span class="am-text-danger">[error]</span> [google 123.124.2.2] client denied by server: /export/home/macadmin/testdoc
<span class="am-text-success">[Tue Jan 11 17:32:52 2013]</span> <span class="am-text-danger">[error]</span> [google 123.124.2.2] client denied by server: /export/home/macadmin/testdoc - no such file
<span class="am-text-success">[Tue Jan 11 17:32:52 2013]</span> <span class="am-text-danger">[error]</span> [google 123.124.2.2] client denied by server: /export/home/macadmin/testdoc
<span class="am-text-success">[Tue Jan 11 17:32:52 2013]</span> <span class="am-text-danger">[error]</span> [google 123.124.2.2] client denied by server: /export/home/macadmin/testdoc
<span class="am-text-success">[Tue Jan 11 17:32:52 2013]</span> <span class="am-text-danger">[error]</span> [google 123.124.2.2] client denied by server: /export/home/macadmin/testdoc - no such file
<span class="am-text-success">[Tue Jan 11 17:32:52 2013]</span> <span class="am-text-danger">[error]</span> [google 123.124.2.2] client denied by server: /export/home/macadmin/testdoc
<span class="am-text-success">[Tue Jan 11 17:32:52 2013]</span> <span class="am-text-danger">[error]</span> [google 123.124.2.2] client denied by server: /export/home/macadmin/testdoc
<span class="am-text-success">[Tue Jan 11 17:32:52 2013]</span> <span class="am-text-danger">[error]</span> [google 123.124.2.2] client denied by server: /export/home/macadmin/testdoc - no such file
<span class="am-text-success">[Tue Jan 11 17:32:52 2013]</span> <span class="am-text-danger">[error]</span> [google 123.124.2.2] client denied by server: /export/home/macadmin/testdoc
<span class="am-text-success">[Tue Jan 11 17:32:52 2013]</span> <span class="am-text-danger">[error]</span> [google 123.124.2.2] client denied by server: /export/home/macadmin/testdoc - no such file
<span class="am-text-success">[Tue Jan 11 17:32:52 2013]</span> <span class="am-text-danger">[error]</span> [google 123.124.2.2] client denied by server: /export/home/macadmin/testdoc
<span class="am-text-success">[Tue Jan 11 17:32:52 2013]</span> <span class="am-text-danger">[error]</span> [google 123.124.2.2] client denied by server: /export/home/macadmin/testdoc
<span class="am-text-success">[Tue Jan 11 17:32:52 2013]</span> <span class="am-text-danger">[error]</span> [google 123.124.2.2] client denied by server: /export/home/macadmin/testdoc - no such file
<span class="am-text-success">[Tue Jan 11 17:32:52 2013]</span> <span class="am-text-danger">[error]</span> [google 123.124.2.2] client denied by server: /export/home/macadmin/testdoc
<span class="am-text-success">[Tue Jan 11 17:32:52 2013]</span> <span class="am-text-danger">[error]</span> [google 123.124.2.2] client denied by server: /export/home/macadmin/testdoc - no such file
<span class="am-text-success">[Tue Jan 11 17:32:52 2013]</span> <span class="am-text-danger">[error]</span> [google 123.124.2.2] client denied by server: /export/home/macadmin/testdoc - no such file
<span class="am-text-success">[Tue Jan 11 17:32:52 2013]</span> <span class="am-text-danger">[error]</span> [google 123.124.2.2] client denied by server: /export/home/macadmin/testdoc
<span class="am-text-success">[Tue Jan 11 17:32:52 2013]</span> <span class="am-text-danger">[error]</span> [google 123.124.2.2] client denied by server: /export/home/macadmin/testdoc - no such file
<span class="am-text-success">[Tue Jan 11 17:32:52 2013]</span> <span class="am-text-danger">[error]</span> [google 123.124.2.2] client denied by server: /export/home/macadmin/testdoc - no such file
<span class="am-text-success">[Tue Jan 11 17:32:52 2013]</span> <span class="am-text-danger">[error]</span> [google 123.124.2.2] client denied by server: /export/home/macadmin/testdoc
<span class="am-text-success">[Tue Jan 11 17:32:52 2013]</span> <span class="am-text-danger">[error]</span> [google 123.124.2.2] client denied by server: /export/home/macadmin/testdoc - no such file
<span class="am-text-success">[Tue Jan 11 17:32:52 2013]</span> <span class="am-text-danger">[error]</span> [google 123.124.2.2] client denied by server: /export/home/macadmin/testdoc - no such file
        </pre>
          <p>这里是静态页面展示，使用时结合代码高亮插件</p>
        </div>
      </div>
    </div>

    <jsp:include page="included_footer.jsp"/>
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

	<script type="text/javascript">
    
	</script>

</body>
</html>

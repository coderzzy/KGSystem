<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head lang="en">
		<meta charset="UTF-8">
		<title>Login Page | SpiderSystem</title>
		<!-- 以下代码告诉IE浏览器，IE8/9及以后的版本都会以最高版本IE来渲染页面 -->
		<meta http-equiv="X-UA-Compatible" content="IE=edge">
		<meta name="viewport" content="width=device-width, initial-scale=1">
		<meta name="format-detection" content="telephone=no">
		<meta name="renderer" content="webkit">
		<!-- 以下代码取消第三方转码 -->
		<meta name="Cache-Control" content="no-siteapp">

		<link rel="icon" type="image/png"
			href="${pageContext.request.contextPath}/static/amazeui_assets/i/favicon.png">
		<link rel="stylesheet"
			href="${pageContext.request.contextPath}/static/amazeui_assets/css/amazeui.min.css">

		<style>
			.header {
				text-align: center;
			}
			.header h1 {
				font-size: 200%;
				color: #333;
				margin-top: 30px;
			}
			.header p {
				font-size: 14px;
			}
		</style>
	</head>
<body>
<div class="header">
	<div class="am-g">
		<h1>SpiderSystem知识图谱</h1>
		<p>
			the System of News-Spider &amp; News-KnowledgeGraph based on ScriptSpider
			<br/>
			基于ScriptSpider开源框架的新闻类爬虫管理及知识图谱构建系统
		</p>
	</div>
	<hr/>
</div>
<div class="am-g">
  <div class="am-u-lg-6 am-u-md-8 am-u-sm-centered">
    <h3>登  陆</h3>
    <hr>
    <div class="am-btn-group">
      <a href="#" class="am-btn am-btn-secondary am-btn-sm">
        <i class="am-icon-github am-icon-sm"></i>
        Github
      </a>
      <a href="#" class="am-btn am-btn-success am-btn-sm">
        <i class="am-icon-google-plus-square am-icon-sm"></i>
        Google+
      </a>
      <a href="#" class="am-btn am-btn-primary am-btn-sm">
        <i class="am-icon-stack-overflow am-icon-sm"></i>
        stackOverflow
      </a>
    </div>
    <br>
    <br>

    <form class="am-form" method="post">
      <label for="email">邮箱:</label>
      <input type="email" name="" id="email" value="">
      <br>
      <label for="password">密码:</label>
      <input type="password" name="" id="password" value="">
      <br>
      <label for="remember-me">
        <input type="checkbox" id="remember-me">
        记住密码
      </label>
      <br>
      <div class="am-cf">
        <input type="button" name="" value="登 陆"
          class="am-btn am-btn-primary am-btn-sm am-fl"
          onclick="admin_index();">
        <input type="submit" name="" value="忘记密码 ^_^? "
          class="am-btn am-btn-default am-btn-sm am-fr">
      </div>
    </form>
    <hr>
    <p>@ 2018 All Rights Reserved Zzy.</p>


  </div>
</div>

	<script type="text/javascript">
		function admin_index(){
			window.location.href = "${pageContext.request.contextPath}/admin/index";
		}
	</script>
</body>
</html>

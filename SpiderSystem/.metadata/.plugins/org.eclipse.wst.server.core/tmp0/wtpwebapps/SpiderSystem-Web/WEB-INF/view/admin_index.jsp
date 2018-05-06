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

    <!-- content start -->
  <div class="admin-content">
    <div class="admin-content-body">
      <div class="am-cf am-padding am-padding-bottom-0">
        <div class="am-fl am-cf"><strong class="am-text-primary am-text-lg">个人资料</strong> / <small>Personal information</small></div>
      </div>

      <hr/>

      <div class="am-g">
        <div class="am-u-sm-12 am-u-md-4 am-u-md-push-8">
      	<div class="am-panel am-panel-default">
            <div class="am-panel-bd">
              <div class="user-info">
                <p>等级信息</p>
                <div class="am-progress am-progress-sm">
                  <div class="am-progress-bar" style="width: 60%"></div>
                </div>
                <p class="user-info-order">当前等级：<strong>LV8</strong> 活跃天数：<strong>587</strong> 距离下一级别：<strong>160</strong></p>
              </div>
              <div class="user-info">
                <p>信用信息</p>
                <div class="am-progress am-progress-sm">
                  <div class="am-progress-bar am-progress-bar-success" style="width: 80%"></div>
                </div>
                <p class="user-info-order">信用等级：正常当前 信用积分：<strong>80</strong></p>
              </div>
            </div>
          </div>
        </div>


        <div class="am-u-sm-12 am-u-md-8 am-u-md-pull-4">
          <form class="am-form am-form-horizontal">
            <div class="am-form-group">
              <label for="user-name" class="am-u-sm-3 am-form-label">姓名 / Name</label>
              <div class="am-u-sm-9">
                <input type="text" id="user-name">
                <small>输入你的名字，让我们记住你。</small>
              </div>
            </div>

            <div class="am-form-group">
              <label for="user-email" class="am-u-sm-3 am-form-label">电子邮件 / Email</label>
              <div class="am-u-sm-9">
                <input type="email" id="user-email">
                <small>邮箱你懂得...</small>
              </div>
            </div>

            <div class="am-form-group">
              <label for="user-phone" class="am-u-sm-3 am-form-label">电话 / Telephone</label>
              <div class="am-u-sm-9">
                <input type="tel" id="user-phone">
              </div>
            </div>

            <div class="am-form-group">
              <label for="user-QQ" class="am-u-sm-3 am-form-label">QQ</label>
              <div class="am-u-sm-9">
                <input type="text" id="user-QQ">
              </div>
            </div>

            <div class="am-form-group">
              <label for="user-weibo" class="am-u-sm-3 am-form-label">微博 / Twitter</label>
              <div class="am-u-sm-9">
                <input type="text" id="user-weibo">
              </div>
            </div>

            <div class="am-form-group">
              <label for="user-intro" class="am-u-sm-3 am-form-label">简介 / Intro</label>
              <div class="am-u-sm-9">
                <textarea class="" rows="5" id="user-intro"></textarea>
                <small>250字以内写出你的一生...</small>
              </div>
            </div>

            <div class="am-form-group">
              <div class="am-u-sm-9 am-u-sm-push-3">
                <button type="button" class="am-btn am-btn-primary" onclick="save()">保存修改</button>
              </div>
            </div>
          </form>
        </div>
      </div>
    </div>

    <jsp:include page="included_footer.jsp"/>
  </div>
  <!-- content end -->


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
  	var ori_name,ori_email,ori_phone,ori_QQ,ori_weibo,ori_intro;
  
  
  	$(function(){
		// alert("${adminId}");
		// return;
  		$.ajax({
             url: "${pageContext.request.contextPath}/admin/show",
             type: "POST",
             dataType: "json",
             data: {
               "adminId": "${adminId}"
             },
             async: false,
             success: function(data) {
            	 if(data.result == "success"){
                	 // alert("操作成功");
                	 ori_name = data.adminName;
                	 $("#user-name").attr("value",ori_name);
                	 ori_email = data.adminEmail;
                	 $("#user-email").attr("value",ori_email);
                	 ori_phone = data.adminTelephone;
                	 $("#user-phone").attr("value",ori_phone);
                	 ori_QQ = data.adminQq;
                	 $("#user-QQ").attr("value",ori_QQ);
                	 ori_weibo = data.adminTwitter;
                	 $("#user-weibo").attr("value",ori_weibo);
                	 ori_intro = data.adminIntro;
                	 $("#user-intro").html(ori_intro);
                 }else{
                	 alert("数据读取失败");
                 }
             },
             error: function() {
               alert("访问服务器失败，...请检查网络连接，如确实怀疑服务器问题请联系Zzy");
             }
           });
	});
  	
  	function save(){
  		var now_name = $("#user-name").val(),
  		now_email = $("#user-email").val(),
  		now_phone = $("#user-phone").val(),
  		now_QQ = $("#user-QQ").val(),
  		now_weibo = $("#user-weibo").val(),
  		now_intro = $("#user-intro").val();
  		
  		
  		if(
  			now_name == ori_name &&
  			now_email == ori_email &&
  			now_phone == ori_phone &&
  			now_QQ == ori_QQ &&
  			now_weibo == ori_weibo &&
  			now_intro == ori_intro
  		){
  			alert("并没有任何修改!!!");
  			return;
  		}
  		
  		$.ajax({
            url: "${pageContext.request.contextPath}/admin/save",
            type: "POST",
            dataType: "json",
            data: {
              "adminId": "${adminId}",
              "adminName": now_name,
              "adminEmail": now_email,
              "adminPhone": now_phone,
              "adminQq": now_QQ,
              "adminTwitter": now_weibo,
              "adminIntro": now_intro
            },
            async: false,
            success: function(data) {
           	 if(data.result == "success"){
               	 alert("修改成功");
               	 
                }else{
               	 alert("数据修改失败");
                }
            },
            error: function() {
              alert("访问服务器失败，...请检查网络连接，如确实怀疑服务器问题请联系Zzy");
            }
          });
  	}

  </script>

</body>
</html>
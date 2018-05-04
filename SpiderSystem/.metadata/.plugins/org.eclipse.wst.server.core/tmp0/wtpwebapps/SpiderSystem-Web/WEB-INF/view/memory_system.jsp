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
		<div id="memory_chart" style="width:600px; height: 400px;"></div>
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
  <script src="${pageContext.request.contextPath}/static/js/echarts.js"></script>
  
  <script type="text/javascript">
  	/*
  		$(function(){
  			setInterval(function(){
  				$.ajax({
  	  	             url: "${pageContext.request.contextPath}/memory/show",
  	  	             type: "POST",
  	  	             dataType: "json",
  	  	             async: false,
  	  	             success: function(data) {
  	  	            	 if(data.result == "success"){
  	  	                	 // alert("操作成功");
  	  	                	 blank_area();
  	  	                 }else{
  	  	                	 alert("数据读取失败");
  	  	                 }
  	  	             },
  	  	             error: function() {
  	  	               alert("访问服务器失败，...请检查网络连接，如确实怀疑服务器问题请联系Zzy");
  	  	             }
  	  	           });
  			}, 5000);
  			
  		});
  		
  		function blank_area(){
  			var option = {
  					xAxis: {
  				        type: 'category',
  				        boundaryGap: false,
  				        data: ['Mon', 'Tue', 'Wed', 'Thu', 'Fri', 'Sat', 'Sun']
  				    },
  				    yAxis: {
  				        type: 'value'
  				    },
  				    series: [{
  				        data: [820, 932, 901, 934, 1290, 1330, 1320],
  				        type: 'line',
  				        areaStyle: {}
  				    }]
  				};
  			
  			//初始化echarts实例
            var memory_Chart = echarts.init(document.getElementById('memory_chart'));

            //使用制定的配置项和数据显示图表
            memory_Chart.setOption(option);
  		}
  		
  		*/
  		
  	    // 基于准备好的dom，初始化echarts实例  
  		var myChart = echarts.init(document.getElementById('memory_chart'));  
  		  
  		function initData() {  
  		    now = now + 1;  
  		    value = value + Math.random() * 21 - 10;  
  		    return {  
  		        name: now.toString(),  
  		        value: [  
  		            now,  
  		            // Math.random() * 100 
  		            0
  		        ]  
  		    }  
  		}  
  		
  		function ajaxData() {  
  		    now = now + 1;  
  		    value = value + Math.random() * 21 - 10;
  		    var ajaxValue;
  		  	$.ajax({
 	             url: "${pageContext.request.contextPath}/memory/show",
 	             type: "POST",
 	             dataType: "json",
 	             async: false,
 	             success: function(data) {
 	            	 if(data.result == "success"){
 	                	 // alert("操作成功");
 	                	 // alert(data.value);
 	                	 ajaxValue = data.value;
 	                 }else{
 	                	 alert("数据读取失败");
 	                 }
 	             },
 	             error: function() {
 	               alert("访问服务器失败，...请检查网络连接，如确实怀疑服务器问题请联系Zzy");
 	             }
 	           });
  		    return {  
  		        name: now.toString(),  
  		        value: [  
  		            now,  
  		            // Math.random() * 100 
  		            ajaxValue
  		        ]  
  		    }  
  		}  
  		  
  		var data = [];  
  		var now = +0;  
  		var oneDay = 1;  
  		var value = Math.random() * 1000;  
  		for (var i = 0; i < 7; i++) {  
  		    data.push(initData());  
  		}  
  		  
  		option = {  
  		    title: {  
  		        text: "后台可用内存"  
  		    },  
  		    tooltip: {  
  		        trigger: 'axis',  
  		        formatter: function (params) {  
  		            params = params[0];  
  		            var date = new Date(params.name);  
  		            return params.value[1];  
  		        },  
  		        axisPointer: {  
  		            animation: false  
  		        }  
  		    },  
  		    xAxis: {  
  		        type: 'value',  
  		    },  
  		    yAxis: {  
  		        type: 'value',  
  		    },  
  		    series: [{  
  		        name: '模拟数据',  
  		        type: 'line',  
  		        showSymbol: false,  
  		        hoverAnimation: false,  
  		        //stack: '总量',  
  		        data: data  
  		    }]  
  		};  
  		  
  		setInterval(function () {  
  		  
  		    for (var i = 0; i < 1; i++) {  
  		        data.shift();  
  		        data.push(ajaxData());  
  		    }  
  		  
  		    myChart.setOption({  
  		    series: [{  
  		        name: '模拟数据',  
  		        type: 'line',  
  		        showSymbol: false,  
  		        hoverAnimation: false,  
  		        //stack: '总量',  
  		        data: data  
  		    }]  
  		    });  
  		    myChart.setOption({  
  		        xAxis: [{  
  		        type: 'value',  
  		        splitLine: {  
  		            show: false  
  		        },  
  		        min: +data[0].name
  		    }]  
  		    });  
  		}, 1000);  
  		  
  		// 使用刚指定的配置项和数据显示图表。  
  		myChart.setOption(option);  
    </script>

</body>
</html>

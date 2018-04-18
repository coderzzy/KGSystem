<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>spider_result</title>
</head>
<body>
<h2>"${state}"，点击开始或者停止运行</h2>

<input value="click to spider_start" type="button" onclick="spider_start()">

<input value="click to spider_stop" type="button" onclick="spider_stop()">

<input value="click to spider_index" type="button" onclick="spider_index()">

	<script>
		function spider_start(){
			window.location.href = "${pageContext.request.contextPath}/spider/start";
		}
		
		function spider_stop(){
			window.location.href = "${pageContext.request.contextPath}/spider/stop";
		}
		
		function spider_index(){
			window.location.href = "${pageContext.request.contextPath}/spider/index";
		}
	</script>

</body>
</html>
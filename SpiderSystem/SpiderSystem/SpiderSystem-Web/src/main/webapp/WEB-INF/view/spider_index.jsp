<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>spider_index</title>
</head>
<body>
<h2>Spider_index</h2>

<input value="click to spider_check" type="button" onclick="spider_check()">


	<script>
		function spider_check(){
			window.location.href = "${pageContext.request.contextPath}/spider/check";
		}
	</script>
</body>
</html>
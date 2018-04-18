<html>
<body>
<h2>Hello World!</h2>

<input value="click to spider_index" type="button" onclick="spider_index()">

	<script>
		function spider_index(){
			window.location.href = "${pageContext.request.contextPath}/spider/index";
		}
	</script>
</body>
</html>

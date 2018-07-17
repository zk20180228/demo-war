<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!doctype html>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<html>
<head>
    <title>

    </title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/static/css/index.css">
</head>
<body>
<div>

        <img src="${pageContext.request.contextPath}/static/images/admin.png">
        <h1 id="title">${h1}</h1>

</div>
</body>
</html>
<%--引入静态文件，webjars--%>
<script src="/webjars/jquery/2.1.4/jquery.min.js" type="text/javascript"></script>
<script type="text/javascript">
    $(function(){

        $("#title").on("click",function(){
            alert("${h1}");
        });

    });


</script>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <jsp:include page="../resource.jsp"></jsp:include>
</head>
<body class="easyui-layout">
<div data-options="region:'north',split:false" style="height:80px">
    <div class="easyui-layout" data-options="fit:true">
        <div data-options="region:'west'" style="width:180px"><p>干细胞后台管理</p></div>
    </div>
</div>
<div data-options="region:'center'">
    <div class="easyui-layout" data-options="fit:true">
        <div data-options="region:'west',collapsed:false" style="width:180px"></div>
        <div data-options="region:'center',href:'../index.jsp'"></div>
    </div>
</div>

<script type="text/javascript">
    $(document).ready(function(){


    });

</script>
</body>
</html>

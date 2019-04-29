<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <jsp:include page="resource.jsp"/>
    <title>用户登录</title>
    <%--<link rel="stylesheet" href="${pageContext.request.contextPath}/css/bootstrap/bootstrap-grid.css" />--%>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/login.css"/>
</head>
<body>
    <div class="container">
        <div class="row justify-content-center">
            <div class="col-md-5">
                <div class="card p-4">
                    <div class="card-header text-center text-uppercase h4 font-weight-light">
                        账&emsp;号&emsp;登&emsp;录
                    </div>

                    <form action="toLogin" method="post">
                        <div class="card-body py-5">
                            <div class="form-group">
                                <label class="col-form-label">用户名：</label>
                                <input name="userName" maxlength="20" class="form-control" placeholder="请输入账号" >
                            </div>
                            <div class="form-group">
                                <label class="col-form-label">密&emsp;码：</label>
                                <input type="password" name="pwd" class="form-control" placeholder="请输入密码" >
                            </div>
                            <div class="form-group">
                                <label class="col-form-label">验证码：</label>
                                <input type="tel" name="" class="form-control" placeholder="请输入图形验证码" >
                                <span>
                                    <canvas id="canvas" width="120" height="45"></canvas>
                                    <a href="#" id="changeImg">看不清，换一张</a>
                                </span>
                            </div>
                        </div>

                        <div class="card-footer">
                            <div class="row">
                                <div class="col-6">
                                    <button type="submit" class="btn btn-primary px-5">登录</button>
                                </div>
                            </div>
                        </div>
                    </form>
                </div>
            </div>
        </div>

    </div>
</body>
</html>

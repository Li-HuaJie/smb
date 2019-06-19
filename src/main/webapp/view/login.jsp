<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <jsp:include page="resource.jsp"/>
    <title>用户登录</title>
    <%--<link rel="stylesheet" href="${pageContext.request.contextPath}/css/bootstrap/bootstrap-grid.css" />--%>
    <script type="text/javascript" src="${pageContext.request.contextPath}/js/form.js"></script>
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

                    <form action="toLogin" method="post" id="register-form" class="form-horizontal" role="form">
                        <div class="card-body py-5">
                            <div class="form-group">
                                <label class="col-form-label" for="userName">用户名：</label>
                                <div>
                                    <input name="userName" class="form-control" id="userName" placeholder="请输入账号" >
                                </div>
                            </div>
                            <div class="form-group">
                                <label class="col-form-label" for="pwd">密&emsp;码：</label>
                                <div>
                                    <input type="password" name="pwd" class="form-control" id="pwd"  placeholder="请输入密码" >
                                </div>
                            </div>
                            <div class="form-group">
                                <label class="col-form-label" for="captcha">验证码：</label>
                                <input type="tel" name="captcha" class="form-control-gai" id="captcha" placeholder="请输入图形验证码" >
                                <span>
                                    <img src="${pageContext.request.contextPath}/captcha" id="img" onclick="changeImage()" />
                                </span>
                            </div>
                            <%--<span>${msg}</span>--%>
                        </div>
                        <div class="card-footer form-group">
                            <div class="row">
                                <div class="col-6">
                                    <button type="submit" class="btn btn-primary px-5 btn-sm">登录</button>
                                </div>
                            </div>
                        </div>
                    </form>
                </div>
            </div>
        </div>
    </div>

    <script type="text/javascript">
        //验证码
        function changeImage(){
            document.getElementById("img").src = "${pageContext.request.contextPath}/captcha?time=" + new Date().getTime();
        }
    </script>
    <script type="text/javascript" src="${pageContext.request.contextPath}/js/login.js"></script>
</body>

</html>

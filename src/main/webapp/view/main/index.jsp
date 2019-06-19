<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
    <jsp:include page="../resource.jsp"></jsp:include>
    <link href="${pageContext.request.contextPath}/css/main.css" rel="stylesheet">
</head>
<body>

    <nav class="navbar navbar-dark sticky-top bg-dark flex-md-nowrap p-0">
        <a class="navbar-brand col-sm-3 col-md-2 mr-0"><span style="color: #fff;">Company name</span></a>
        <%--<input class="form-control form-control-dark w-100" type="text" placeholder="Search" aria-label="Search">--%>
        <ul class="navbar-nav px-3">
            <li class="nav-item text-nowrap">
                <a class="nav-link" href="${smeUrl}/outLogin">注销</a>
            </li>
        </ul>
    </nav>

    <div class="container-fluid">
        <div class="row">
            <nav class="col-md-2 d-none d-md-block bg-light sidebar">
                <div class="sidebar-sticky">
                    <ul class="nav flex-column">
                        <c:forEach var="item" items="${menuList}">
                        <li class="nav-item">
                            <div>${item.text}</div>
                            <c:forEach var="node" items="${item.children}">
                                <a class="menu-item" href="${msUrl}${node.url}">${node.text}</a>
                            </c:forEach>
                        </li>
                        </c:forEach>
                    </ul>


                    <%--<c:forEach var="item" items="${menuList}">--%>
                        <%--<div title="${item.text}">--%>
                            <%--<c:forEach var="node" items="${item.children}">--%>
                                <%--<a class="menu-item" href="${msUrl}${node.url}">${node.text}</a>--%>
                            <%--</c:forEach>--%>
                        <%--</div>--%>
                    <%--</c:forEach>--%>
                </div>
            </nav>

            <main role="main" class="col-md-9 ml-sm-auto col-lg-10 pt-3 px-4">

            </main>

        </div>
    </div>

<script type="text/javascript">
    $(document).ready(function(){

    });

</script>
</body>
</html>

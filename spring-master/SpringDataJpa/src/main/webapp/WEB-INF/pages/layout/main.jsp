<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html xmlns="http://www.w3.org/1999/xhtml">

    <head>
        <%
            String path = request.getContextPath();
            String basePath = request.getScheme() + "://" + request.getServerName();
            if (request.getServerPort() != 80) {
                basePath += ":" + request.getServerPort();
            }
            basePath += path + "/";
        %>

        <base href="<%=basePath%>"/>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
        <title>Home</title>

        <link rel="stylesheet" type="text/css" href="resources/css/bootstrap.min.css" />
        <link rel="stylesheet" type="text/css" href="resources/css/dashboard.css" />

        <!--Icons-->
        <script src="resources/js/lumino.glyphs.js"></script>
    </head>
    <body>
        <!-- Header Section -->
        <tiles:insertAttribute name="header" />
        <div class="container-fluid">
            <div class="row">
                <!-- Sidebar Section -->
                <tiles:insertAttribute name="menu" />
                <div class="col-sm-9 col-sm-offset-3 col-md-10 col-md-offset-2 main">
                    <!-- Content/Main Section -->
                    <tiles:insertAttribute name="body" />
                </div>
            </div>
        </div>

        <script src="resources/js/jquery.min.js"></script>
        <script src="resources/js/bootstrap.min.js"></script>


    </body>
</html>
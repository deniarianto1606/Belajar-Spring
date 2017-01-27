<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html style="height: 100%">
    <head>
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Login</title>
        <link href="favicon.ico" type="image/x-icon" rel="icon" />
    </head>
    <body style="height: 100%">
        <div class="login-wrapper">
            <div class="container login-container">
                <div class="row">
                    <div class="col-md-4 col-md-offset-4">
                        <div class="login-panel panel panel-default">
                            <div class="panel-heading">
                                <h3 class="panel-title">Express Taxi</h3>
                            </div>
                            <div class="panel-body">
                                <c:if test="${not empty SPRING_SECURITY_LAST_EXCEPTION}">
                                    <div class="alert alert-warning">
                                        ${SPRING_SECURITY_LAST_EXCEPTION.message}
                                    </div>
                                </c:if>
                                <form method="POST" action="<c:url value='j_spring_security_check' />">
                                    <fieldset>
                                        <div class="input-group voffset-bottom-md">
                                            <span class="input-group-addon" title="Username">
                                                <i class="fa fa-user fa-fw"></i>
                                            </span>
                                            <input class="form-control" placeholder="Enter your username" name="j_username" type="text" autofocus>
                                        </div>
                                        <div class="input-group voffset-bottom-md">
                                            <span class="input-group-addon" title="Password">
                                                <i class="fa fa-key fa-fw"></i>
                                            </span>
                                            <input class="form-control" placeholder="*******" name="j_password" type="password" value="">
                                        </div>
                                        <input type="submit" class="btn btn-lg btn-success btn-block" value="Login"/>
                                    </fieldset>
                                </form>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </body>
</html>
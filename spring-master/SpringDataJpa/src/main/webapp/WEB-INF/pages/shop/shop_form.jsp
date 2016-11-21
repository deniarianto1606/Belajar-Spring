<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>

<tiles:insertDefinition name="master_layout">

    <tiles:putAttribute name="body">

        <h2 class="sub-header">Form Shop</h2>
        <form:form method="POST" commandName="shop">
            <div class="form-group row">
                <label for="example-text-input" class="col-xs-2 col-form-label">Shop Name</label>
                <div class="col-xs-10">
                    <form:input id="example-text-input" class="form-control" path="name"/>
                    <form:errors path="name" cssStyle="color: red;"/>
                </div>
            </div>
            <div class="form-group row">
                <label for="example-text-input" class="col-xs-2 col-form-label">Employees Number</label>
                <div class="col-xs-10">
                    <form:input id="example-text-input" class="form-control" path="emplNumber"/>
                    <form:errors path="emplNumber" cssStyle="color: red;"/>
                </div>
            </div>
            <div class="form-group row">
                <div class="col-xs-2"></div>
                <div class="col-xs-10">
                    <input type="submit" class="btn btn-primary" value="Create" />
                    <a href="${pageContext.request.contextPath}/" class="btn btn-default">Kembali</a>
                </div>
            </div>
            
        </form:form>

    </tiles:putAttribute>
</tiles:insertDefinition>
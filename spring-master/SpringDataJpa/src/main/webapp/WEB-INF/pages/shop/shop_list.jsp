<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<%@ taglib prefix="z" uri="/META-INF/paging.tld" %>

<tiles:insertDefinition name="master_layout">

    <tiles:putAttribute name="body">

        <h2 class="sub-header">List Shop</h2>
        <c:choose>
            <c:when test="${empty shopList.content}">
                <div class="notice">
                    Nothing to show.
                </div>
            </c:when>
            <c:otherwise>
                <table class="dataTable table table-striped table-hover">
                    <thead>
                        <tr>
                            <th>No.</th>
                            <th>Nama</th>
                        </tr>
                    </thead>
                    <tbody>
                        <c:forEach items="${shopList.content}" var="row" varStatus="i">
                            <tr>
                                <td>${paging.startRow + i.count}</td>
                                <td>
                                    <a href="detail?name=${row.name}&id=${row.id}">${row.name}</a>
                                </td>
                            </tr>

                        </c:forEach>

                    </tbody>
                </table>
                <z:paging2 paging="${shopList}" url="shop/list"/>
            </c:otherwise>
        </c:choose>

        <a href="shop/create" class="btn btn-primary">
            <i class="fa fa-fw fa-plus"></i>
            Tambah
        </a>

    </tiles:putAttribute>
</tiles:insertDefinition>
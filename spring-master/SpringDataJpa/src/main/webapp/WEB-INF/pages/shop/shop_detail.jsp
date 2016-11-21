<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<tiles:insertDefinition name="master_layout">

    <tiles:putAttribute name="body">

        <table>
            <tr>
                <td>${shop.name}</td>
            </tr>
            <tr>
                <td>${shop.emplNumber}</td>
            </tr>
        </table>

    </tiles:putAttribute>
</tiles:insertDefinition>
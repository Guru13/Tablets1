<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ page session="false" %>
<html>
<head>
    <title>Tablet Page</title>
    <style type="text/css">
        .tg {
            border-collapse: collapse;
            border-spacing: 0;
            border-color: #ccc;
        }

        .tg td {
            font-family: Arial, sans-serif;
            font-size: 14px;
            padding: 10px 5px;
            border-style: solid;
            border-width: 1px;
            overflow: hidden;
            word-break: normal;
            border-color: #ccc;
            color: #333;
            background-color: #fff;
        }

        .tg th {
            font-family: Arial, sans-serif;
            font-size: 14px;
            font-weight: normal;
            padding: 10px 5px;
            border-style: solid;
            border-width: 1px;
            overflow: hidden;
            word-break: normal;
            border-color: #ccc;
            color: #333;
            background-color: #f0f0f0;
        }

        .tg .tg-4eph {
            background-color: #f9f9f9
        }
    </style>
</head>
<body>
<h1>
    Add a Tablet
</h1>

<p>
    <a href="${pageContext.request.contextPath}/">back</a>
</p>
<c:url var="addAction" value="/tablet/add"/>

<form:form action="${addAction}" commandName="tablet">

    <table>
        <c:if test="${!empty tablet.brand}">
            <tr>
                <td>
                    <form:label path="id">
                        <spring:message text="ID"/>
                    </form:label>
                </td>
                <td>
                    <form:input path="id" readonly="true" size="8" disabled="true"/>
                    <form:hidden path="id"/>
                </td>
            </tr>
        </c:if>
        <tr>
            <td>
                <form:label path="brand">
                    <spring:message text="Brand"/>
                </form:label>
            </td>
            <td>
                <form:input path="brand"/>
            </td>
        </tr>
        <tr>
            <td>
                <form:label path="price">
                    <spring:message text="Price"/>
                </form:label>
            </td>
            <td>
                <form:input path="price"/>
            </td>
        </tr>
        <tr>
            <td>
                <form:label path="year">
                    <spring:message text="Year"/>
                </form:label>
            </td>
            <td>
                <form:input path="year"/>
            </td>
        </tr>
        <tr>
            <td>
                <form:label path="ram">
                    <spring:message text="Ram"/>
                </form:label>
            </td>
            <td>
                <form:input path="ram"/>
            </td>
        </tr>
        <tr>
            <td>
                <form:label path="rom">
                    <spring:message text="Rom"/>
                </form:label>
            </td>
            <td>
                <form:input path="rom"/>
            </td>
        </tr>
        <tr>
            <td>
                <form:label path="system">
                    <spring:message text="System"/>
                </form:label>
            </td>
            <td>
                <form:input path="system"/>
            </td>
        </tr>
        <tr>
            <td>
                <form:label path="battery">
                    <spring:message text="Battery"/>
                </form:label>
            </td>
            <td>
                <form:input path="battery"/>
            </td>
        </tr>
        <tr>
            <td>
                <form:label path="color">
                    <spring:message text="Color"/>
                </form:label>
            </td>
            <td>
                <form:input path="color"/>
            </td>
        </tr>
        <tr>
            <td>
                <form:label path="screenSize">
                    <spring:message text="ScreenSize"/>
                </form:label>
            </td>
            <td>
                <form:input path="screenSize"/>
            </td>
        </tr>
        <tr>
            <td>
                <form:label path="image">
                    <spring:message text="Image"/>
                </form:label>
            </td>
            <td>
                <form:input path="image"/>
            </td>
        </tr>
        <tr>
            <td colspan="2">
                <c:if test="${!empty tablet.brand}">
                    <input type="submit"
                           value="<spring:message text="Edit tablet"/>"/>
                </c:if>
                <c:if test="${empty tablet.brand}">
                    <input type="submit"
                           value="<spring:message text="Add tablet"/>"/>
                </c:if>
            </td>
        </tr>
    </table>
</form:form>
<br>

<h3>Tablets List</h3>
<c:if test="${!empty listTablets}">
    <table class="tg">
        <tr>
            <th width="80">ID</th>
            <th width="80">Brand</th>
            <th width="60">Price</th>
            <th width="60">Year</th>
            <th width="60">Ram</th>
            <th width="60">Rom</th>
            <th width="80">System</th>
            <th width="80">Battery</th>
            <th width="80">Color</th>
            <th width="80">Screen Size</th>
            <th width="100">Image</th>
            <th width="60">Edit</th>
            <th width="60">Delete</th>

        </tr>
        <c:forEach items="${listTablets}" var="tablet">
            <tr>
                <td>${tablet.id}</td>
                <td>${tablet.brand}</td>
                <td>${tablet.price}</td>
                <td>${tablet.year}</td>
                <td>${tablet.ram}</td>
                <td>${tablet.rom}</td>
                <td>${tablet.system}</td>
                <td>${tablet.battery}</td>
                <td>${tablet.color}</td>
                <td>${tablet.screenSize}</td>
                <td>${tablet.image}</td>
                <td><a href="<c:url value='/edit/${tablet.id}' />">Edit</a></td>
                <td><a href="<c:url value='/remove/${tablet.id}' />">Delete</a></td>
            </tr>
        </c:forEach>
    </table>
</c:if>

</body>
</html>

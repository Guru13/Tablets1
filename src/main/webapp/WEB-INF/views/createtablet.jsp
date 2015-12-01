<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1" %>
<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <link href="${pageContext.request.contextPath}/resources/css/main.css" rel="stylesheet" type="text/css">
    <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
    <title>Insert title here</title>
</head>
<body>

<sf:form method="post" action="${pageContext.request.contextPath}/docreate" commandName="tablet">
    <table class="formtable">
        <tr>
            <td class="label">Brand:</td>
            <td><sf:input path="brand" name="brand" type="text"/></br><sf:errors path="brand"
                                                                                 cssClass="error"></sf:errors></td>
        </tr>
        <tr>
            <td class="label">Price:</td>
            <td><sf:input path="price" name="price" type="text"/></br><sf:errors path="price"
                                                                                 cssClass="error"></sf:errors></td>
        </tr>
        <tr>
            <td class="label">Year:</td>
            <td><sf:input path="year" name="year" type="text"/></br><sf:errors path="year"
                                                                               cssClass="error"></sf:errors></td>
        </tr>
        <tr>
            <td class="label">RAM:</td>
            <td><sf:input path="ram" name="ram" type="text"/></br><sf:errors path="ram"
                                                                             cssClass="error"></sf:errors></td>
        </tr>
        <tr>
            <td class="label">ROM:</td>
            <td><sf:input path="rom" name="rom" type="text"/></br><sf:errors path="rom"
                                                                             cssClass="error"></sf:errors></td>
        </tr>
        <tr>
            <td class="label">System:</td>
            <td><sf:input path="system" name="system" type="text"/></br><sf:errors path="system"
                                                                                   cssClass="error"></sf:errors></td>
        </tr>
        <tr>
            <td class="label">Battery:</td>
            <td><sf:input path="battery" name="battery" type="text"/></br><sf:errors path="battery"
                                                                                     cssClass="error"></sf:errors></td>
        </tr>
        <tr>
            <td class="label">Color:</td>
            <td><sf:input path="color" name="color" type="text"/></br><sf:errors path="color"
                                                                                 cssClass="error"></sf:errors></td>
        </tr>
        <tr>
            <td class="label">Screen size:</td>
            <td><sf:input path="screenSize" name="screenSize" type="text"/></br><sf:errors path="screenSize"
                                                                                           cssClass="error"></sf:errors></td>
        </tr>
        <tr>
            <td class="label">Image:</td>
            <td><sf:input path="image" name="image" type="text"/></br><sf:errors path="image"
                                                                                 cssClass="error"></sf:errors></td>
        </tr>
        <tr>
            <td class="label"></td>
            <td><input value="create tablet" type="submit"/></td>
        </tr>
    </table>
</sf:form>


</body>
</html>
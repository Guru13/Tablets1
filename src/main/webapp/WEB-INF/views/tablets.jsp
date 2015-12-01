<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ page session="false" %>
<html>
<head>
  <title>Tablet Page</title>
  <style type="text/css">
    .tg  {border-collapse:collapse;border-spacing:0;border-color:#ccc;}
    .tg td{font-family:Arial, sans-serif;font-size:14px;padding:10px 5px;border-style:solid;border-width:1px;overflow:hidden;word-break:normal;border-color:#ccc;color:#333;background-color:#fff;}
    .tg th{font-family:Arial, sans-serif;font-size:14px;font-weight:normal;padding:10px 5px;border-style:solid;border-width:1px;overflow:hidden;word-break:normal;border-color:#ccc;color:#333;background-color:#f0f0f0;}
    .tg .tg-4eph{background-color:#f9f9f9}
  </style>
</head>
<body>
<h1>
  Show Tablets
</h1>
<p>
  <a href="${pageContext.request.contextPath}/">back</a>
</p>
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
      <th width="60">Compare</th>
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
        <td><a href="<c:url value='/addToCompare/${tablet.id}' />" >Compare </a></td>
      </tr>
    </c:forEach>
  </table>
</c:if>
<form:form action="/tablets/toCompare"  method="post">
  <input type="submit" value="<spring:message text="Compare tablets"/>" />
</form:form>
</body>
</html>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%@taglib  uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions"
prefix="fn" %>

<html>
<body>
<h2>Employees</h2>
<p>${requestScope.employees}</p>
 <c:if test="${fn:length(applicationScope.employees) > 0}">
                 <ul>
                     <c:forEach var="employee" items="${applicationScope.employees}">
                         <li>${employee}</li>
                     </c:forEach>
                 </ul>
             </c:if>       
</body>
</html>

<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ include file="/init.jsp" %>

<h2>Danh Sách Nhân Viên</h2>
<ul>
	<c:forEach var="emp" items="${employeeList}">
		<li>
			<a href="<c:url value='/employee/${emp.empId}'/>">${emp.firstName}</a>
		</li>
	</c:forEach>
</ul>
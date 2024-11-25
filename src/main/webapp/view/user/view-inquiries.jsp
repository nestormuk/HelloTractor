<%@ include file="../components/taglib.jsp" %>
<!DOCTYPE html>
<html>
<head>
    <%@ include file="../components/header.jsp" %>
</head>
<body>
<%@ include file="../components/navbar.jsp" %>

<div class="container mt-4">
    <h2>My Inquiries</h2>

    <table class="table">
        <thead>
        <tr>
            <th>Date</th>
            <th>Car</th>
            <th>Message</th>
            <th>Response</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach items="${inquiries}" var="inquiry">
            <tr>
                <td><fmt:formatDate value="${inquiry.date}" pattern="yyyy-MM-dd"/></td>
                <td>${inquiry.car.make} ${inquiry.car.model}</td>
                <td>${inquiry.message}</td>
                <td>${inquiry.response != null ? inquiry.response : 'Pending'}</td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
</div>

<%@ include file="../components/footer.jsp" %>
</body>
</html>
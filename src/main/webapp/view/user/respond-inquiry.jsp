<%@ include file="../components/taglib.jsp" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <%@ include file="../components/header.jsp" %>
</head>
<body>
<%@ include file="../components/navbar.jsp" %>

<main class="container pt-5">
    <h3 class="text-center">Respond to Inquiry</h3>
    <form action="<%= request.getContextPath() %>/user/inquiry/${inquiry.idInquiry}/respond" method="post">
        <div class="mb-3">
            <label for="message" class="form-label">Original Message</label>
            <textarea class="form-control" id="message" rows="5" readonly>${inquiry.message}</textarea>
        </div>
        <div class="mb-3">
            <label for="response" class="form-label">Response</label>
            <textarea class="form-control" id="response" name="response" rows="5" required>${inquiry.response}</textarea>
        </div>
        <button type="submit" class="btn btn-success">Save Response</button>
    </form>
</main>

<%@ include file="../components/footer.jsp" %>
</body>
</html>

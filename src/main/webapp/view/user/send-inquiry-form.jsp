<%@ include file="../components/taglib.jsp" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <%@ include file="../components/header.jsp" %>
    <link rel="stylesheet" href="/css/inquiry.css" />
</head>
<body>
<%@ include file="../components/navbar.jsp" %>

<main>
    <div class="container pt-5">
        <div class="row">
            <div class="col-md-8 offset-md-2">
                <h3 class="text-center">Send Inquiry</h3>
                <form action="${pageContext.request.contextPath}/user/send-inquiry" method="post">
                    <input type="hidden" name="car.idCar" value="${car.idCar}" />
                    <input type="hidden" name="user.idUser" value="${user.idUser}" />

                    <div class="mb-3">
                        <label for="make" class="form-label">Car Make</label>
                        <input type="text" class="form-control" id="make" value="${car.make}" readonly />
                    </div>

                    <div class="mb-3">
                        <label for="model" class="form-label">Car Model</label>
                        <input type="text" class="form-control" id="model" value="${car.model}" readonly />
                    </div>

                    <div class="mb-3">
                        <label for="message" class="form-label">Message</label>
                        <textarea class="form-control" id="message" name="message" rows="5" required></textarea>
                    </div>

                    <div class="mb-3">
                        <button type="submit" class="btn btn-primary">Submit Inquiry</button>
                        <a href="${pageContext.request.contextPath}/cars" class="btn btn-secondary">Cancel</a>
                    </div>
                </form>

                <c:if test="${not empty errorMessage}">
                    <div class="alert alert-danger mt-3">${errorMessage}</div>
                </c:if>
            </div>
        </div>
    </div>
</main>

<%@ include file="../components/footer.jsp" %>
</body>
</html>
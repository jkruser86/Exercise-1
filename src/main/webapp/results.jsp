<%@include file="taglib.jsp"%>
<c:set var="title" value="Search Results" />
<%@include file="head.jsp"%>

<html><body>

<div class="container-fluid">
    <h2>Search Results: </h2>

    <c:choose>
        <c:when test="${empty users}">
            <h3>Name not found</h3>
        </c:when>
        <c:otherwise>
            <table id="userTable" class="display" border="1" style="width:75%">
                <thead>
                <th>ID</th>
                <th>First Name</th>
                <th>Last Name</th>
                <th>Age</th>
                </thead>
                <tbody>
                <c:forEach var="user" items="${users}">
                    <tr>
                        <td>${user.userid}</td>
                        <td>${user.firstName}</td>
                        <td>${user.lastName}</td>
                        <td>${user.age()}</td>
                    </tr>
                </c:forEach>
                </tbody>
            </table>
        </c:otherwise>
    </c:choose>
</div>

</body>
</html>

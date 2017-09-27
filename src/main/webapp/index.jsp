<%@include file="taglib.jsp"%>
<c:set var="title" value="User Search Home Page" />
<%@include file="head.jsp"%>
<html>
    <body>
        <h2>User Display Exercise - Week 1</h2>
        <form action="searchUser" class="form-inline">
            <div class="form-group">
                <label for="searchTerm">Last Name Search</label>
                <input type="text" class="form-control" id="searchTerm" name="searchTerm">
            </div>
            <button type="submit" name="submit" value="search">Search</button>
            <button type="submit" name="submit" value="fullSearch">Full Person Search</button>
        </form>
    </body>
</html>
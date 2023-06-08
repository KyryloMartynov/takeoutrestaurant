<%@ include file="../jspf/page.jspf" %>
<%@ include file="../jspf/taglib.jspf" %>
<html>
<head>
    <title>Dishes</title>
    <link rel="stylesheet" type="text/css" media="screen" href="../../style/profile.css"/>
    <%@ include file="../jspf/head.jspf" %>
</head>
<body>
<div class="card my-5">
    <div class="card-body">
        <table class="table table-bordered table-striped">
            <thead class="thead-dark">
            <tr>
                <th scope="col">id</th>
                <th scope="col">name</th>
                <th scope="col">portion</th>
                <th scope="col">price</th>
            </tr>
            </thead>
            <tbody>
            <c:forEach var="dish" items="${dishes}">
            <tr>
                <td><p>${dish.id}</p></td>
                <td><p>${dish.name}</p></td>
                <td><p>${dish.portion}</p></td>
                <td><p>${dish.price}</p></td>
                <td>
                    <form id="delete" action="/deleteDish" method="post">
                        <input type="hidden" name="deleteId" value="${dish.id}"/>
                        <p>
                            <button type="submit" class="btn btn-info">delete</button>
                        </p>
                    </form>
                </td>
                <td>
                    <form id="getById" action="/getById" method="post">
                        <input type="hidden" name="id" value="${dish.id}"/>
                        <p>
                            <button type="submit" class="btn btn-info">Get full info</button>
                        </p>
                    </form>
                </td>
            </tr>
            </c:forEach>
            </tbody>
        </table>
        <div>
            <p>
            <form id="add" action="/addDish" method="post">
                <input type="hidden" name="command" value="redirect"/>
                <p>
                    <button type="submit" class="btn btn-success">add</button>
                </p>
            </form>
            </p>
        </div>
    </div>
</div>
</body>
</html>

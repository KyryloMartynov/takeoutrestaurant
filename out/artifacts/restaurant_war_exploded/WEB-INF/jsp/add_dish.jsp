<%@ include file="../jspf/page.jspf" %>
<%@ include file="../jspf/taglib.jspf" %>

<html>
<head>
    <c:set var="title" value="add_booking"/>
    <%@ include file="../jspf/head.jspf" %>
</head>
<body>
<div class="wrap content card my-5 card-body">
    <form id="register_form" action="/addDish" method="post">
        <input type="hidden" name="command" value="add"/>
        <fieldset>
            <legend>
                Adding dish
            </legend>
            <p> Input name
                <input name="name" required/><br/>
            </p>
            <p> Input portion
                <input name="portion" required/><br/>
            </p>
            <p>Input price
                <input name="price" required/><br/></p>
            <p>Id of category
                <input name="fk_category" required/><br/></p>
        </fieldset>
        <div class="button_wrap">
            <button class="btn-lg btn-success" type="submit">Add
            </button>
        </div>
    </form>
</div>
</body>
</html>

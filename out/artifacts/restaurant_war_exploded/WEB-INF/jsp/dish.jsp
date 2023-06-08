<%@ include file="../jspf/page.jspf" %>
<%@ include file="../jspf/taglib.jspf" %>

<html>
<head>
    <title>
        Dish
    </title>
    <link rel="stylesheet" type="text/css" media="screen" href="../../style/profile.css"/>
    <%@ include file="../jspf/head.jspf" %>
</head>
<body>
<div class="wrap">
    <div class="content">
        <h1>ID: ${dish.id}</h1>
        <p>Price: ${dish.price}</p>
        <p>Name: ${dish.name}</p>
        <p>Portion: ${dish.portion}</p>
        <p>Category: ${dish.category.name}</p>
    </div>
</div>
</body>
</html>

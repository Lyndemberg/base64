<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="m" uri="/WEB-INF/tags" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Exibição</title>
    </head>
    <body>
        <h1>Exibição das fotos salvas</h1>
        <m:listImagens />
        <c:forEach items="${fotos}" var="foto">
            <img src="data:image/jpg;base64,${foto}"/><br>
        </c:forEach>
        
    </body>
</html>

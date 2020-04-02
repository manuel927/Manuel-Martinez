<%-- 
    Document   : curso
    Created on : 2/04/2020, 12:54:31 PM
    Author     : manuel martinez
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
         <h1>Curso Information</h1>
        <form action="./CursoServlet" method="POST">
            <table>
                <tr>
                    <td>Curso Id</td>
                    <td><input type="text" name="codigocurso" value="${curso.codigocurso}" /></td>
                </tr>
                <tr>
                    <td>Nombre Curso</td>
                    <td><input type="text" name="nombrecurso" value="${curso.nombrecurso}" /></td>
                </tr>
                <tr>
                    <td>Creditos</td>
                    <td><input type="text" name="creditos" value="${curso.creditos}" /></td>
                </tr>
                <tr>
                    <td>Semestre</td>
                    <td><input type="text" name="semestre" value="${curso.semestre}" /></td>
                </tr>
                <tr>
                    <td>Admitidos</td>
                    <td><input type="text" name="admitidos" value="${curso.admitidos}" /></td>
                </tr>
                <tr>
                    <td colspan="2">
                        <input type="submit" name="action" value="Add" />
                        <input type="submit" name="action" value="Edit" />
                        <input type="submit" name="action" value="Delete" />
                        <input type="submit" name="action" value="Search" />
                    </td>
                </tr>
            </table>
        </form>
        <br>
        <table border="1">
            <th>ID</th>
            <th>Nombre</th>
            <th>Creditos</th>
            <th>Semestre</th>
            <th>Admitidos</th>
                <c:forEach items="${allCursos}" var="curs">
                <tr>
                    <td>${curs.codigocurso}</td>
                    <td>${curs.nombrecurso}</td>
                    <td>${curs.creditos}</td>
                    <td>${curs.semestre}</td>
                    <td>${curs.admitidos}</td>
                </tr>
            </c:forEach> 
        </table>
    </body>
</html>

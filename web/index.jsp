<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
    <head>
        <title>Gerenciamento de Usuarios</title>
    </head>
    <body>
    <center>
        <h2>
            <a href="/novo">Adicionar Usuario</a>
            &nbsp;&nbsp;&nbsp;
            <a href="/listar">Listar Usuarios</a>

        </h2>
    </center>
    <div align="center">
        <table border="1" cellpadding="5">
            <caption><h2>Lista de Usuários</h2></caption>
            <tr>
                <th>ID</th>
                <th>Nome</th>
                <th>Email</th>
                <th>Cidade</th>
            </tr>
            <c:forEach var="usuario" items="${listaUsuarios}">
                <tr>
                    <td><c:out value="${usuario.usuario_id}" /></td>
                    <td><c:out value="${usuario.nome}" /></td>
                    <td><c:out value="${usuario.email}" /></td>
                    <td><c:out value="${usuario.cidade}" /></td>
                    <td>
                        <a href="/editar?id=<c:out value='${usuario.usuario_id}' />">Editar</a>
                        &nbsp;&nbsp;&nbsp;&nbsp;
                        <a href="/deletar?id=<c:out value='${usuario.usuario_id}' />">Deletar</a>                     
                    </td>
                </tr>
            </c:forEach>
        </table>
    </div>   
</body>
</html>
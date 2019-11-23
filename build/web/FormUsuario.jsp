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
            <a href="novo">Novo Usuario</a>
            &nbsp;&nbsp;&nbsp;
            <a href="listar">Listar Usuarios</a>

        </h2>
    </center>
    <div align="center">
        <c:if test="${usuario != null}">
            <form action="atualizar" method="post">
            </c:if>
            <c:if test="${usuario == null}">
                <form action="inserir" method="post">
                </c:if>
                <table border="1" cellpadding="5">
                    <caption>
                        <h2>
                            <c:if test="${usuario != null}">
                                Editar Usuario
                            </c:if>
                            <c:if test="${usuario == null}">
                                Adicionar Usuario
                            </c:if>
                        </h2>
                    </caption>
                    <c:if test="${usuario != null}">
                        <input type="hidden" name="usuario_id" value="<c:out value='${usuario.usuario_id}' />" />
                    </c:if>           
                    <tr>
                        <th>Nome: </th>
                        <td>
                            <input type="text" name="nome" size="45"
                                   value="<c:out value='${usuario.nome}' />"
                                   />
                        </td>
                    </tr>
                    <tr>
                        <th>E-Mail: </th>
                        <td>
                            <input type="text" name="email" size="45"
                                   value="<c:out value='${usuario.email}' />"
                                   />
                        </td>
                    </tr>
                    <tr>
                        <th>Cidade: </th>
                        <td>
                            <input type="text" name="cidade" size="45"
                                   value="<c:out value='${usuario.cidade}' />"
                                   />
                        </td>
                    </tr>
                    <tr>
                        <td colspan="2" align="center">
                            <input type="submit" value="Salvar" />
                        </td>
                    </tr>
                </table>
            </form>
    </div>   
</body>
</html>
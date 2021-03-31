

<%@page import="DAO.CategoriaDAO"%>
<%@page import="Entidade.Categoria"%>
<%@page import="java.util.ArrayList"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>

        <style>
            .bd-placeholder-img {
                font-size: 1.125rem;
                text-anchor: middle;
                -webkit-user-select: none;
                -moz-user-select: none;
                user-select: none;
            }

            @media (min-width: 768px) {
                .bd-placeholder-img-lg {
                    font-size: 3.5rem;
                }
            }
        </style>

        <!-- Bootstrap core CSS -->
        <link href="../css/bootstrap.min.css" rel="stylesheet">

        <link href="../css/navbar.css" rel="stylesheet">
    </head>
    <body>
        <nav class="navbar navbar-expand-md navbar-dark bg-dark" aria-label="Fourth navbar example">
            <div class="container-fluid">
                <a class="navbar-brand" href="#">Controle de Despesas</a>
                <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarsExample04" aria-controls="navbarsExample04" aria-expanded="false" aria-label="Toggle navigation">
                    <span class="navbar-toggler-icon"></span>
                </button>

                <div class="float-end" id="navbarsExample04">
                    <div class="float-end" id="navbarsExampleDefault">

                        <form action="../home.jsp">
                            <button type="submit" class="btn btn-dark">Voltar</input>
                        </form>

                    </div>
                </div>
            </div>
        </nav>

        <div class="container-fluid">
            <div class="row">
                <main class="col-sm-12 ml-sm-auto col-md-12 " role="main">
                    <div>
                        <section layout:fragment="content">
                            <div class="container">
                                <div class="row">
                                    <div class="col-sm-10">Lista de Categorias</div>
                                    <div class="col-sm-1">
                                        <a href="../DAOCategoria/CadastroCategorias.jsp" class="btn btn-dark active" role="button"
                                           aria-pressed="true"><i class="fas fa-plus"></i>Adicionar</a>
                                    </div>
                                </div>
                                <div class="row">
                                    <br>
                                </div>

                                <%
                                    ArrayList<Categoria> categoria = new CategoriaDAO().consultarTodos();
                                %>

                                <div class="row">
                                    <table class="table table-striped ">
                                        <thead>
                                            <tr>
                                                <th scope="col">#</th>
                                                <th scope="col">Nome</th>
                                                <th scope="col">Descrição</th>
                                                <th scope="col"></th>
                                            </tr>
                                        </thead>
                                        <%
                                            for (int i = 0; i < categoria.size(); i++) {
                                                Categoria categ = categoria.get(i);
                                                if (categ.getX().equals("A")) {
                                        %>
                                        <tbody>
                                            <tr>
                                                <td><%= categ.getId_categoria()%></td>
                                                <td><%= categ.getNome()%></td>
                                                <td><%= categ.getDescricao()%></td>
                                                <td>
                                                    <a href=""   class="btn btn-success" title="Editar">
                                                        <i class="fas fa-edit"></i>
                                                    </a>
                                                    <a href="@{/money/categorias/delete/{id}(id=${c.id_categoria})}" class="btn btn-danger" title="Excluir">
                                                        <i class="fas fa-trash"></i>
                                                    </a>
                                                </td>

                                            </tr>
                                            <%
                                                    }
                                                }
                                            %>
                                        </tbody>
                                    </table>
                                </div>
                            </div>
                        </section>
                    </div>
                </main>
            </div>
        </div>

        <script src="../js/bootstrap.bundle.min.js"></script>

    </body>
</html>

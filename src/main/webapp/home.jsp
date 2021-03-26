

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
        <link href="css/bootstrap.min.css" rel="stylesheet">

        <link href="css/navbar.css" rel="stylesheet">
    </head>
    <body>
        <nav class="navbar navbar-expand-md navbar-dark bg-dark" aria-label="Fourth navbar example">
            <div class="container-fluid">
                <a class="navbar-brand" href="#">Controle de Despesas</a>
                <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarsExample04" aria-controls="navbarsExample04" aria-expanded="false" aria-label="Toggle navigation">
                    <span class="navbar-toggler-icon"></span>
                </button>

                <div class="collapse navbar-collapse" id="navbarsExample04">
                    <ul class="navbar-nav me-auto mb-2 mb-md-0">

                        <li class="nav-item dropdown">
                            <a class="nav-link dropdown-toggle" href="#" id="dropdown04" data-bs-toggle="dropdown" aria-expanded="false">Usuários</a>
                            <ul class="dropdown-menu" aria-labelledby="dropdown04">
                                <li><a class="dropdown-item" href="DAOUsuario/CadastroUsuario.jsp">Cadastro Usuário</a></li>
                                <li><a class="dropdown-item" href="DAOUsuario/ListarUsuarios.jsp">Listar Usuários</a></li>
                                <li><a class="dropdown-item" href="DAOUsuario/EditarUsuarios.jsp">Editar Usuários</a></li>
                                <li><a class="dropdown-item" href="DAOUsuario/ExcluirUsuarios.jsp">Excluir Usuários</a></li>
                            </ul>
                        </li>

                        <li class="nav-item dropdown">
                            <a class="nav-link dropdown-toggle" href="#" id="dropdown04" data-bs-toggle="dropdown" aria-expanded="false">Pessoas</a>
                            <ul class="dropdown-menu" aria-labelledby="dropdown04">
                                <li><a class="dropdown-item" href="DAOPessoa/CadastroPessoas.jsp">Cadastro Pessoas</a></li>
                                <li><a class="dropdown-item" href="DAOPessoa/ListarPessoas.jsp">Listar Pessoas</a></li>
                                <li><a class="dropdown-item" href="DAOPessoa/EditarPessoas.jsp">Editar Pessoas</a></li>
                                <li><a class="dropdown-item" href="DAOPessoa/ExcluirPessoas.jsp">Excluir Pessoas</a></li>
                            </ul>
                        </li>

                        <li class="nav-item dropdown">
                            <a class="nav-link dropdown-toggle" href="#" id="dropdown04" data-bs-toggle="dropdown" aria-expanded="false">Categorias</a>
                            <ul class="dropdown-menu" aria-labelledby="dropdown04">
                                <li><a class="dropdown-item" href="DAOCategoria/CadastroCategorias.jsp">Cadastro Categorias</a></li>
                                <li><a class="dropdown-item" href="DAOCategoria/ListarCategorias.jsp">Listar Categorias</a></li>
                                <li><a class="dropdown-item" href="DAOCategoria/EditarCategorias.jsp">Editar Categorias</a></li>
                                <li><a class="dropdown-item" href="DAOCategoria/ExcluirCategorias.jsp">Excluir Categorias</a></li>
                            </ul>
                        </li>

                        <li class="nav-item dropdown">
                            <a class="nav-link dropdown-toggle" href="#" id="dropdown04" data-bs-toggle="dropdown" aria-expanded="false">Movimentos</a>
                            <ul class="dropdown-menu" aria-labelledby="dropdown04">
                                <li><a class="dropdown-item" href="DAOMovimento/CadastroMovimentos.jsp">Cadastro Movimentos</a></li>
                                <li><a class="dropdown-item" href="DAOMovimento/ListarMovimentos.jsp">Listar Movimentos</a></li>
                                <li><a class="dropdown-item" href="DAOMovimento/EditarMovimentos.jsp">Editar Movimentos</a></li>
                                <li><a class="dropdown-item" href="DAOMovimento/ExcluirMovimentos.jsp">Excluir Movimentos</a></li>
                            </ul>
                        </li>
                    </ul>

                    <div class="collapse navbar-collapse" id="navbarsExampleDefault">
                        <ul class="navbar-nav mr-auto">
                        </ul>

                        <form include file="login.jsp">
                            <button type="submit" class="btn btn-dark">Sair</input>
                        </form>
                    </div>
                </div>
            </div>
        </nav>

        <script src="js/bootstrap.bundle.min.js"></script>

    </body>
</html>

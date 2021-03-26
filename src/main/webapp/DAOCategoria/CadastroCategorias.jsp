

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
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
                                <li><a class="dropdown-item" href="CadastroUsuario.jsp">Cadastro Usuário</a></li>
                                <li><a class="dropdown-item" href="ListarUsuarios.jsp">Listar Usuários</a></li>
                                <li><a class="dropdown-item" href="EditarUsuarios.jsp">Editar Usuários</a></li>
                                <li><a class="dropdown-item" href="ExcluirUsuarios.jsp">Excluir Usuários</a></li>
                            </ul>
                        </li>

                        <li class="nav-item dropdown">
                            <a class="nav-link dropdown-toggle" href="#" id="dropdown04" data-bs-toggle="dropdown" aria-expanded="false">Pessoas</a>
                            <ul class="dropdown-menu" aria-labelledby="dropdown04">
                                <li><a class="dropdown-item" href="CadastroPessoas.jsp">Cadastro Pessoas</a></li>
                                <li><a class="dropdown-item" href="ListarPessoas.jsp">Listar Pessoas</a></li>
                                <li><a class="dropdown-item" href="EditarPessoas.jsp">Editar Pessoas</a></li>
                                <li><a class="dropdown-item" href="ExcluirPessoas.jsp">Excluir Pessoas</a></li>
                            </ul>
                        </li>

                        <li class="nav-item dropdown">
                            <a class="nav-link dropdown-toggle" href="#" id="dropdown04" data-bs-toggle="dropdown" aria-expanded="false">Categorias</a>
                            <ul class="dropdown-menu" aria-labelledby="dropdown04">
                                <li><a class="dropdown-item" href="CadastroCategorias.jsp">Cadastro Categorias</a></li>
                                <li><a class="dropdown-item" href="ListarCategorias.jsp">Listar Categorias</a></li>
                                <li><a class="dropdown-item" href="EditarCategorias.jsp">Editar Categorias</a></li>
                                <li><a class="dropdown-item" href="ExcluirCategorias.jsp">Excluir Categorias</a></li>
                            </ul>
                        </li>

                        <li class="nav-item dropdown">
                            <a class="nav-link dropdown-toggle" href="#" id="dropdown04" data-bs-toggle="dropdown" aria-expanded="false">Movimentos</a>
                            <ul class="dropdown-menu" aria-labelledby="dropdown04">
                                <li><a class="dropdown-item" href="CadastroMovimentos.jsp">Cadastro Movimentos</a></li>
                                <li><a class="dropdown-item" href="ListarMovimentos.jsp">Listar Movimentos</a></li>
                                <li><a class="dropdown-item" href="EditarMovimentos.jsp">Editar Movimentos</a></li>
                                <li><a class="dropdown-item" href="ExcluirMovimentos.jsp">Excluir Movimentos</a></li>
                            </ul>
                        </li>
                    </ul>
                </div>
            </div>
        </nav>

        <h1>Hello World!</h1>
    </body>
</html>

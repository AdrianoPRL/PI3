

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="css/bootstrap.min.css" rel="stylesheet">
        <link href="css/Cadastros.css" rel="stylesheet">
        <link href="css/nav.css" rel="stylesheet" type="text/css"/>
        <link href="css/inputOff.css" rel="stylesheet" type="text/css"/>

        <link href="css/loca.css" rel="stylesheet" type="text/css"/>
        <script src="js/function.js" type="text/javascript"></script>
        <link rel="shortcut icon" href="${pageContext.request.contextPath}/img/icon.png" type="image/x-icon" />
        <title>Locação</title>
    </head>
    <body style="background-image: url(${pageContext.request.contextPath}/img/fundo-site.jpg );">
         <header></header>	
        <input type="checkbox" id="chk"/>

        <label for="chk"class="menu-icon"><span class="glyphicon glyphicon-menu-hamburger" aria-hidden="true"></span></label>
        <input type="checkbox" id="chk2"/>
        <label for="chk2"class="menu-icon2"><span class="glyphicon glyphicon-option-vertical" aria-hidden="true"></span></label>
        <div class="bg"></div>
        <nav class="menu" id="principal">
            <ul>
                <li class="user"><span class="glyphicon glyphicon-user" aria-hidden="true"></span><c:out value="${sessionScope.username.nomeCompleto}" /></li>
                <li><a href="" class="voltar">Voltar</a></li>
                <li><a href="home">Home</a></li>
                <li><a href="#Cliente">Cliente <span>+</span></a></li>
                <li><a href="#Automovel"> Automovel <span>+</span></a></li>
                <li><a href="selecionarCliente  ">Venda</a></li>

                <li><a href="#">Relatorio</a></li>

                <li><a href="criarLogin">Criar Login</a></li>

            </ul>
        </nav>
        <nav class="menu" id="Cliente">
            <ul>
                <li><a href="#" class="voltar">Voltar</a></li>
                <li><a href="CadastrarClienteF">Cadastro Fisico</a></li>
                <li><a href="CadastrarClienteJ">Cadastro Juridico</a></li>
                <li><a href="consultarCliente">Consultar</a></li>
            </ul>
        </nav>
        <nav class="menu" id="Automovel">
            <ul>
                <li><a href="#" class="voltar">Voltar</a></li>
                <li><a href="cadastrarAutomovel">Cadastrar</a></li>
                <li><a href="consultarAutomovel">Consultar</a></li>

            </ul>
        </nav>
        <div class="bg2"></div>
        <nav class="menu" id="navright">
            <ul>
                <li><a href="" class="voltar2">Voltar</a></li>
                <li><a href="AlterarSenha" >Trocar Senha</a></li>
                <li><a href="./logout">Logout</a></li>
            </ul>
        </nav>
        <div class="container pesq">
            <div class="row centered-form">
                <div class="panel-body">
                    <form action="./selecionarCliente" method="post">
                        <div class="col-md-5">
                            <div class="input-group col-md-12">
                                <input name="procurar" class="form-control"  id="search" type="text" placeholder="Pesquisar Clientes">
                                <div class="input-group-btn">
                                    <button class="btn btn-primary" type="submit">
                                        <span class="glyphicon glyphicon-search"></span>
                                    </button>


                                </div>
                            </div>
                         


                        </div>
                    </form>
                </div>
            </div>

        </div>




        <div class="container dados">
            <div class="row centered-form">

                <div class="">
                    <div class="panel-heading">
                        <div class="panel-body">


                            <div class="form-row">
                                <table class="table table-striped" cellspacing="0" cellpadding="0">
                                    <thead>

                                        <tr>
                                            <th>Nome Completo</th>
                                            <th>CPF</th>
                                            <th>CNH</th>
                                            <th>bairro</th>
                                            <th class="actions">Ações</th>
                                        </tr>
                                    </thead>
                                    <tbody>


                                        <c:forEach items="${model}" var="item">
                                            <tr>
                                                <td>${item.nomeCompleto}</td>
                                                <td>${item.CPF}</td>
                                                <td>${item.numeroCnh}</td>
                                                <td>${item.bairro}</td>
                                                <td class="actions">
                                                    <form action="./selecionarCliente" method="post">

                                                        <button type="submit" name="tipodeuser" value="selecionar" class=" btn btn-success btn-xs botao">Selecionar</button>
                                                        <input name="repeat" class="sla"  value="${item.CPF}">

                                                        
                                                    </form>
                                                </td>
                                            </tr>
                                        </c:forEach>



                                    </tbody>
                                </table>

                            </div>
                        </div>
                    </div>
                </div><!--
    
                --></div>
        </div>
    </body>
</html>

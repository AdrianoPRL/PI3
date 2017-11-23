<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="css/bootstrap.min.css" rel="stylesheet">
        <link rel="stylesheet" href="css/bootstrap.css">
        <link href="css/banner.css" rel="stylesheet" type="text/css"/>
        <link href="css/navbar.css" rel="stylesheet" type="text/css"/>

        <link rel="shortcut icon" href="${pageContext.request.contextPath}/img/icon.png" type="image/x-icon" />

        <title>Home</title>
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
        <!--
             <div id="myCarousel" class="carousel slide" data-ride="carousel">

            <ol class="carousel-indicators">
                <li data-target="#myCarousel" data-slide-to="0" class="active"></li>
                <li data-target="#myCarousel" data-slide-to="1"></li>
                <li data-target="#myCarousel" data-slide-to="2"></li>
            </ol>


            <div class="carousel-inner">
                <div class="item active">
                    <img src="${pageContext.request.contextPath}/img/banner.jpg">
                </div>

            </div>


            <a class="left carousel-control" href="#myCarousel" data-slide="prev">
                <span class="glyphicon glyphicon-chevron-left"></span>
                <span class="sr-only">Previous</span>
            </a>
            <a class="right carousel-control" href="#myCarousel" data-slide="next">
                <span class="glyphicon glyphicon-chevron-right"></span>
                <span class="sr-only">Next</span>
            </a>
        </div>
        
<!---->    </body>
</html>

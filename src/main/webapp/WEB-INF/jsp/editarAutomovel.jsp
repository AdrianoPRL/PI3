
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Edição Fisico</title>
        <link href="css/bootstrap.min.css" rel="stylesheet">
        <link href="css/nav.css" rel="stylesheet" type="text/css"/>
        <link href="css/new.css" rel="stylesheet" type="text/css"/>
        <link href="css/inputOff.css" rel="stylesheet" type="text/css"/>
        <link rel="shortcut icon" href="${pageContext.request.contextPath}/img/icon.png" type="image/x-icon" />

        <script src="js/function.js" type="text/javascript"></script>
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
        <!--termino da navbar-->


        <div class="container">
            <div class="row centered-form">

                <div class="">
                    <div class="panel-heading">
                        <div class="panel-body">
                            <form action="./editarAuto" method="post">
                                <div class="form-row">
                                    <div class="form-group col-md-6">
                                        <label for="marcaAuto" >Marca</label>
                                        <input type="text " class="form-control" value="${sessionScope.automovel.marca}"id="marcaAuto" placeholder="Digite a marca do automóvel" name="marca">
                                    </div>
                                    <div class="form-group col-md-6">
                                        <label for="modelo">Modelo</label>
                                        <input type="text" class="form-control" value="${sessionScope.automovel.modelo}"id="modeloAuto" placeholder="Digite o modelo do carro" name="model">
                                    </div>

                                </div>

                                <div class="form-row"> 
                                    <div class="form-group col-md-3">
                                        <label for="ano" >Ano</label>
                                        <input type="text " class="form-control" value="${sessionScope.automovel.ano}"id="anoAuto" placeholder="Digite o ano do automóvel" name="anoAuto">
                                    </div>

                                    <div class="form-row">

                                        <div class="form-row">
                                            <div class="form-group col-md-3">
                                                <label for="categoria"class="control-label">Categoria</label>
                                                <input type="text " class="form-control" value="${sessionScope.automovel.categoria}"id="categoria" placeholder="Ex:A,B,C" name="categoria">
                                            </div>
                                            <div class="form-group col-md-6">
                                                <label for="placa "class="control-label">Placa</label>
                                                <input type="text " class="form-control" value="${sessionScope.automovel.placa}"id="placaAuto" placeholder="Digite a placa do automóvel" name="placa">
                                            </div>
                                        </div>

                                        <div class="form-group col-md-3">
                                            <label for="renavam" class=" control-label ">Renavam</label>
                                            <input type="text " class="form-control" value="${sessionScope.automovel.renavam}"id="renavam" placeholder="Digite o renavam do automóvel" name="renavam">

                                        </div>
                                    </div>
                                </div>                            

                                <div class="form-row">
                                    <div class="form-group col-md-3">
                                        <label for="numeroChassi"  class=" control-label ">numero do Chassi</label>

                                        <input type="text " class="form-control" value="${sessionScope.automovel.numeroChassi}"id="numeroChassi" placeholder="Digite o número do chassi" name="nchassi">
                                    </div>
                                    <div class="form-group col-md-3">
                                        <label for="cor" class=" control-label ">Cor</label>

                                        <input type="text " class="form-control" value="${sessionScope.automovel.cor}"id="cor" placeholder="Digite a cor " name="cor">

                                    </div>
                                    <div class="form-group col-md-3">
                                        <label for="Portas" class=" control-label ">Portas</label>

                                        <input type="text " class="form-control" value="${sessionScope.automovel.portas}"id="Portas" placeholder="numero de portas " name="portas">

                                    </div>
                                    <div class="form-group col-md-2">
                                        <label for="comb">Combusitvel</label>
                                        <select id="comb" class="form-control " name="combustivel">
                                            <option selected>Combusitvel...</option>
                                            <option value="Flex">Flex</option>
                                            <option value="Gasolina">Gasolina</option>
                                            <option value="Etanol">Etanol</option>
                                            <option value="Diesel">Diesel</option>

                                        </select>
                                    </div>
                                    <div class="form-group col-md-2">
                                        <label for="Kilometragem" class=" control-label ">Kilometragem</label>

                                        <input type="text " class="form-control" value="${sessionScope.automovel.kilometragem}"id="Portas" placeholder="KM " name="KMs">

                                    </div>
                                    <div class="form-group col-md-8">
                                        <label for="desc" class=" control-label ">Descrição</label>

                                        <input type="text" class="form-control" value="${sessionScope.automovel.descrição}"id="desc" placeholder="ex:ABS+ " name="desc">
                                        <input type="text" class="sla"  value="${sessionScope.automovel.renavam}"  name="atualRenavam" >
                                    </div>

                                </div>


                                <div class="form-row">
                                    <div class="form-group col-md-5 col-sm-offset-5">
                                        <button type="submit" class="btn btn-success">Confirmar</button>
                                        <button type="reset" class="btn btn-danger">Cancelar</button>
                                    </div> 
                                </div>
                            </form>





                        </div>
                    </div>
                </div>
            </div>

        </div>
    </body>
</html>

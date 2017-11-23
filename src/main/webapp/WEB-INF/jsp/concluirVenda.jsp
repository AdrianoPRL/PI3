
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="css/bootstrap.min.css" rel="stylesheet">

     
        <link href="css/new.css" rel="stylesheet" type="text/css"/>
    <link href="css/nav.css" rel="stylesheet" type="text/css"/>
        <link href="css/inputOff.css" rel="stylesheet" type="text/css"/>
        <script src="js/criaCampo.js" type="text/javascript"></script>

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
        <!--termino da navbar-->
        <div class="container">
            <div class="row centered-form">

                <div class="">
                    <div class="panel-heading">
                        <div class="panel-body">
                            <fo
                                <div class="form-row">

                                    <legend>Detalhes do Cliente</legend>

                                    <div class="form-group col-md-6">
                                        <label for="Name">Nome completo/Nome fantasia</label>
                                        <input name="nomecompleto" type="text"  id="Name"class="form-control" disabled="true" placeholder="Nome completo" value="<c:out value="${sessionScope.usuario.nomeCompleto}"/>">

                                    </div>
                                    <div class="form-group col-md-6">
                                        <label for="inputPassword4">CPF</label>
                                        <input type="text" class="form-control" id="cpf"  disabled="true" name="cpf" maxlength="11"value="<c:out value="${sessionScope.usuario.CPF}"/>">
                                    </div>

                                </div>

                                <div class="form-row">

                                    <div class="form-group col-md-6">
                                        <label for="numeroCNH" class=" control-label ">Numero da CNH</label>

                                        <input type="text " class="form-control" id="NumeroCNH" disabled="true"  name="CNHNumber" value="<c:out value="${sessionScope.usuario.numeroCnh}"/>">
                                    </div>
                                    <div class="form-group col-md-2">
                                        <label for="inputState">Categoria da CNH</label>
                                        <select id="cat" class="form-control " disabled="true" name="categoria">
                                            <option selected>Categoria...</option>
                                            <option value="A">A</option>
                                            <option value="B">B</option>
                                            <option value="C">C</option>
                                            <option value="D">D</option>
                                            <option value="E">E</option>
                                        </select>
                                    </div>
                                    <div class="form-group col-md-4">
                                        <label for="Val" class=" control-label ">Validade da CNH</label>

                                        <input type="text " class="form-control" disabled="true" id="Val" placeholder="Validade da CNH" name="valCNH">
                                    </div>
                                </div>
                                <div class="form-row">
                                    <legend>Informações do Veiculo</legend>              
                                    <div class="form-row">
                                        <div class="form-group col-md-3">
                                            <label for="marcaAuto" >Marca</label>
                                            <input type="text " class="form-control" id="marcaAuto" disabled="true"value="${sessionScope.automovel.marca}"placeholder="Digite a marca do automóvel" name="marca">
                                        </div>
                                        <div class="form-group col-md-3">
                                            <label for="modelo">Modelo</label>
                                            <input type="text" class="form-control" id="modeloAuto"disabled="true" value="${sessionScope.automovel.modelo}"placeholder="Digite o modelo do carro" name="model">
                                        </div>

                                    </div>
                                    <div class="form-group col-md-2">
                                        <label for="placa "class="control-label">Placa</label>
                                        <input type="text " class="form-control" id="placaAuto" disabled="true" value="${sessionScope.automovel.placa}" placeholder="Digite a placa do automóvel" name="placa">
                                    </div>
                                    <div class="form-group col-md-2">
                                        <label for="renavam" class=" control-label ">Renavam</label>
                                        <input type="text " class="form-control" id="renavam" disabled="true" value="${sessionScope.automovel.renavam}" placeholder="Digite o renavam do automóvel" name="renavam">

                                    </div>  
                                    <div class="form-group col-md-2">
                                        <label for="renavam" class=" control-label ">Val</label>
                                        <input type="text " class="form-control" id="val" disabled="true" value="${sessionScope.automovel.valorDeLocacao}" >

                                    </div> 
                                </div>
                        </div>
                    </div>
                </div>

                <!--second-->
            </div>
            <div class="container">
                <div class="row centered-form">

                    <div class="">
                        <div class="panel-heading">
                            <div class="panel-body">
                                <form action="./venda" method="post">
                                    <div class="form-row">

                                        <legend>Detalhes do  aluguel </legend>


                                        <div class="form-group col-md-6">
                                            <label for="dataE">Data de entrega</label>
                                            <input type="text" class="form-control" id="dataE" name="dataE"  maxlength="10"onkeypress="mascara(this, '##/##/####')">
                                        </div>
                                        <div class="form-group col-md-6">
                                            <label for="dataD" class=" control-label ">Data de devolução</label>

                                            <input type="text " class="form-control" id="dataD"  name="dataD"maxlength="10" onkeypress="mascara(this, '##/##/####')">
                                        </div>
                                    </div>

                                    <div class="form-row">
                                        <div class="form-group col-md-3">
                                            <label for="rad" class=" control-label ">Serviço(KM)</label> 
                                            <div class="checkbox agrupar">     

                                                <label class="radio-inline">
                                                    <input type="radio" class="tipoServ"name="Servico" id="radioControl" value="Controlado">Controlado
                                                </label>
                                                <label class="radio-inline">
                                                    <input type="radio" class="tipoServ"name="Servico" id="radioFree" value="Livre">Livre
                                                </label>

                                            </div>
                                        </div>                                        
                                    </div>
                                    <div class="form-row">
                                        <div class="form-group col-md-1 ">
                                            <label for="Seguro" class="control-label ">Seguro</label>
                                            <div class="checkbox">     
                                                <label class="radio-inline">
                                                    <input type="checkbox" id="Seguro"class="" name="seguro" value="True">
                                                </label>  
                                            </div>
                                        </div>
                                    </div>
                                    <div class="form-row">
                                        <div class="form-group col-md-3">
                                            <label for="preco">Preço</label>
                                            <input name="preco" type="text"  id="preco"class="form-control"  placeholder="" >

                                        </div>
                                        <div class="form-group col-md-2 ei">



                                        </div>
                                        <div class="form-row">
                                            <div class="form-group col-md-3">
                                                <label for="Total" >Total</label>
                                                <input type="text " class="form-control" id="Total" placeholder="Digite o total" name="total">
                                            </div>


                                        </div>
                                    </div>
                                </form>
                            </div>
                        </div>

                        <div class="form-row">
                            <div class="form-group col-md-5 col-sm-offset-5">
                                <button type="submit" class="btn btn-success">Confirmar</button>
                                <button type="reset" class="btn btn-danger">Cancelar</button>
                            </div> 
                        </div>

                    </div>


                </div>
            </div>





    </body>
</html>

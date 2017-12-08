
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
        <title>concluirVendaJ</title>
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
                <li><a href="encerrarVenda  ">EncerrarVenda</a></li>
                <li><a href="encerrarVendaJ  ">EncerrarVendaJ</a></li>
                <li><a href="Relatorio">Relatorio</a></li>

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
                                        <input name="nomecompleto" type="text"  id="Name"class="form-control" disabled="true" placeholder="Nome completo" value="<c:out value="${sessionScope.usuario.nomeFantasia}"/>">

                                    </div>
                                    <div class="form-group col-md-6">
                                        <label for="inputPassword4">CPF</label>
                                        <input type="text" class="form-control" id="cpf"  disabled="true" name="cpf" maxlength="11"value="<c:out value="${sessionScope.usuario.CNPJ}"/>">
                                    </div>

                                </div>


                                <div class="form-row">
                                    <legend>Informações do Veiculo</legend>              
                                    <div class="form-row">
                                        <div class="row centered-form">

                                            <div class="">
                                                <div class="panel-heading">
                                                    <div class="panel-body">


                                                        <div class="form-row">
                                                            <table class="table table-striped" cellspacing="0" cellpadding="0">
                                                                <thead>

                                                                    <tr>
                                                                        <th>Renavam</th>
                                                                        <th>Marca</th>
                                                                        <th>Modelo</th>
                                                                        <th>Placa</th>

                                                                    </tr>
                                                                </thead>
                                                                <tbody>


                                                                    <tr>
                                                                        <td><c:out value="${sessionScope.automovel.renavam}"/></td>
                                                                        <td><c:out value="${sessionScope.automovel.placa}"/></td>
                                                                        <td><c:out value="${sessionScope.automovel.modelo}"/></td>
                                                                        <td><c:out value="${sessionScope.automovel.marca}"/></td>
                                                                    </tr>




                                                                </tbody>
                                                            </table>

                                                        </div>
                                                    </div>
                                                </div>
                                            </div><!--
                                
                                            --></div>

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
                                <form action="./ConcluirVendaJuridica" method="post">
                                    <div class="form-row">

                                        <legend>Detalhes do  aluguel </legend>

                                        <input name="cli" class="sla"  value="${sessionScope.usuario.CNPJ}">
                                        <input name="autot" class="sla"  value="${sessionScope.automovel.renavam}">                                     
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


                                        <div class="form-group col-md-5 ei">
                                            <div class="form-row">
                                                <div class="form-group col-md-10">
                                                    <label for="Tarifas" >Tarifa</label>
                                                    <input type="text " class="form-control" id="Tarifas" placeholder="Digite o total" name="tarifa">
                                                </div>


                                            </div>

                                        </div>

                                        <div class="form-row">
                                            <div class="form-group col-md-3">
                                                <label for="Total" >Total</label>
                                                <input type="text " class="form-control" id="Total" placeholder="Digite o total" name="total">
                                            </div>


                                        </div>
                                        <div class="form-group col-md-9">
                                            <select name="filial">  
                                                <c:forEach var="elemento" items="${filiais}">  

                                                    <option name="filial" value="<c:out value="${elemento.id}" />">${elemento.nome}      </option>  

                                                </c:forEach>  
                                            </select>
                                        </div>

                                        <div class="form-row">
                                            <div class="form-group col-md-5 col-sm-offset-5">
                                                <button type="submit" class="btn btn-success">Confirmar</button>
                                                <button type="reset" class="btn btn-danger">Cancelar</button>
                                            </div> 
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

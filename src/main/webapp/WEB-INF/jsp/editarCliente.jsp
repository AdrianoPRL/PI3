
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Edição cliente</title>
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
                            <form action="./editarCliente" method="post">
                                <div class="form-row">
                                    <legend>Editar Cliente</legend>
                                    <div class="form-group col-md-6">
                                        <label for="Name">Nome completo</label>
                                        <input name="nomecompleto" type="text"  value="${sessionScope.usuario.nomeCompleto}"id="Name"class="form-control"  placeholder="Nome completo">
                                    </div>
                                    <div class="form-group col-md-6">
                                        <label for="inputPassword4">CPF</label>
                                        <input type="text" class="form-control"  disabled="true" value="<c:out value="${sessionScope.usuario.CPF}"/>" id="cpf" name="cpf" maxlength="11">
                                    </div>
                                    
                                </div>
                                <div class="form-row"> 
                                    <div class="form-group col-md-3">
                                        <label for="datanasc "class="control-label">Data de nascimento</label>
                                        <input  type="text" class="form-control" value="${sessionScope.usuario.dataNasc}" id="datanasc" placeholder="data de nascimento" name="datanasc">
                                    </div>
                                    <div class="form-group col-md-3">
                                        <label for="sexo" class="control-label ">Sexo</label>

                                        <select id="sexo" value="2"class="form-control " name="sexo">
                                            <option selected="" value="${sessionScope.usuario.sexo}" >${sessionScope.usuario.sexo}</option>
                                            <option value="Masculino">Masculino</option>
                                            <option value="Masculino">Feminino</option>
                                            <option value="nulo">Prefiro nao dizer</option>
                                        </select>
                                    </div>
                                </div>
                                <div class="form-row">
                                   
                                    <div class="form-row">
                                    <div class="form-group col-md-4">
                                        <label for="endereco  "class="control-label">Endereço</label>
                                        <input type="text"  value="${sessionScope.usuario.end}" class="form-control" id="endereco" placeholder="endereco" name="endereco">
                                    </div>
                                         <div class="form-group col-md-2">
                                        <label for="numeroCasa "class="control-label">Numero</label>
                                        <input  type="text" value="${sessionScope.usuario.numero}" class="form-control" id="numeroCasa" placeholder="123" name="numerocasa">
                                    </div>
                                        </div>
                                    <div class="form-group col-md-3">
                                         
                                        <label for="inputState">Estado</label>
                                        <select id="inputState" class="form-control" name="UF">
                                            <option selected value="${sessionScope.usuario.UF}">${sessionScope.usuario.UF}</option>
                                            <option value="AC">AC</option>
                                            <option value="AL">AL</option>
                                            <option value="AM">AM</option>
                                            <option value="AP">AP</option>
                                            <option value="BA">BA</option>
                                            <option value="CE">CE</option>
                                            <option value="DF">DF</option>
                                            <option value="ES">ES</option>
                                            <option value="GO">GO</option>
                                            <option value="MA">MA</option>
                                            <option value="MG">MG</option>
                                            <option value="MS">MS</option>
                                            <option value="MT">MT</option>
                                            <option value="PA">PA</option>
                                            <option value="PB">PB</option>
                                            <option value="PE">PE</option>
                                            <option value="PI">PI</option>
                                            <option value="PR">PR</option>
                                            <option value="RJ">RJ</option>
                                            <option value="RN">RN</option>
                                            <option value="RS">RS</option>
                                            <option value="RO">RO</option>
                                            <option value="RR">RR</option>
                                            <option value="SC">SC</option>
                                            <option value="SE">SE</option>
                                            <option value="SP">SP</option>
                                            <option value="TO">TO</option>
                                        </select>
                                    </div>
                                    <div class="form-group col-md-3">
                                        <label for="cidade" class=" control-label ">Cidade</label>
                                        <input type="text" value="${sessionScope.usuario.cidade}" class="form-control" id="cidade" placeholder="Digite sua cidade" name="cidade">

                                    </div>
                                </div>
                                <div class="form-row">
                                    <div class="form-group col-md-6">
                                        <label for="complemento" class=" control-label ">Complemento</label>

                                        <input type="text "value="${sessionScope.usuario.complemento}" class="form-control" id="complemento" placeholder="Digite o complemento" name="complemento">
                                    </div>
                                    <div class="form-group col-md-3">
                                        <label for="bairro" class=" control-label ">Bairro</label>

                                        <input type="text "value="${sessionScope.usuario.bairro}" class="form-control" id="bairro" placeholder="Digite o bairro " name="bairro">

                                    </div>
                                     <div class="form-group col-md-3">
                                        <label for="bairro" class=" control-label ">CEP</label>

                                        <input type="text " class="form-control"value="${sessionScope.usuario.CEP}" id="bairro" placeholder="Digite o CEP " name="cep">

                                    </div>
                                    <div class="form-group col-md-3">
                                        <label for="telefone" class=" control-label ">Telefone</label>

                                        <input type="text " class="form-control" value="${sessionScope.usuario.telefone}"id="telefone" placeholder="(11)000000000" name="tel">

                                    </div>
                                    <div class="form-group col-md-3">
                                        <label for="email" class=" control-label ">E-mail</label>

                                        <input type="email" class="form-control" value="${sessionScope.usuario.email}"id="email" placeholder="Digite o seu e-mail" name="email">

                                    </div>
                                </div>
                               
                                <div class="form-row">
                              
                                 <div class="form-group col-md-6">
                                        <label for="numeroCNH" class=" control-label ">Numero da CNH</label>
                                        <input type="text" class="sla"  value="${sessionScope.usuario.CPF}"  name="atualCPF" >
                                        
                                        <input type="text " class="form-control" value="${sessionScope.usuario.numeroCNH}"id="NumeroCNH" placeholder="Numero da CNH" name="CNHNumber">
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

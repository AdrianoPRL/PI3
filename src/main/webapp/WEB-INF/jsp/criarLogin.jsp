

<%@page language="java" contentType="text/html; charset=ISO-8859-1"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="css/bootstrap.min.css" rel="stylesheet">
        <script src="js/function.js" type="text/javascript"></script>
        <link href="css/criarlog.css" rel="stylesheet" type="text/css"/>
       
        <link href="css/teste.css" rel="stylesheet" type="text/css"/>
        <title>CANDT</title>
    </head>
    <body style="background-image: url(${pageContext.request.contextPath}/img/fundo-site.jpg) ;">
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
        
            <div class="container">
                <div class="row centered-form">
                    <div class="">
                        <div class="panel-heading">
                            <div class="panel-body">
                                <form action="./criarLogin "method="post">
                                    <div class="form-row">
                                        <div class="form-group col-md-8 col-sm-offset-2">
                                            <label for="inputName" >Nome completo</label>
                                            <input type="text" class="form-control" id="inputName" placeholder="Nome" name="nome">                                   
                                    </div>    
                                    </div>
                                      <div class="form-row">
                                            <div class="form-group col-md-8 col-sm-offset-2">
                                             <label for="usuario" >Usuario</label>
                                             <input type="text" class="form-control" id="usuario" placeholder="Usuario" name="username">
                                             </div>
                                      </div>
                                      <div class="form-row">
                                             <div class="form-group col-md-8 col-sm-offset-2">
                                             <label for="senha" >Senha</label>
                                               <input type="password" class="form-control" id="senha" placeholder="Senha" name="password">
                                        </div> 
                                    </div>
                                    <div class="form-row "> 
                                        <div class="form-group col-md-8 col-sm-offset-3">
                                        <div class="checkbox">     
                                            <label for="rad" ></label> 
                                        <label class="radio-inline">
                                            <input type="radio" name="tipodeuser" id="radioAdm" value="Admin">Admin
                                        </label>
                                        <label class="radio-inline">
                                            <input type="radio" name="tipodeuser" id="radioGer" value="Gerente">Gerente
                                        </label>
                                        <label class="radio-inline">
                                            <input type="radio" name="tipodeuser" id="radioFunc" value="Funcionario">Funcionario
                                        </label>
                                        </div>
                                    </div>                                        
                                    </div>
                                    <div ld="botoes" class="form-row col-md-7 col-sm-offset-4">
                                    <button type="submit" class="btn btn-success">Confirmar</button>
                                    <button type="reset" class="btn btn-danger">Cancelar</button>
                                </div> 
                                    
                                    
                                </form>





                            </div>
                        </div>
                    </div>
                </div>

            </div>


            <script src="https://ajax.googleapis.com/ajax/libs/jquery/2.1.1/jquery.min.js"></script>
            <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
    </body>
</html>

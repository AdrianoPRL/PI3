

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="css/bootstrap.min.css" rel="stylesheet">
        <link href="css/Cadastros.css" rel="stylesheet">

        <link rel="stylesheet" href="css/font-awesome.min.css">
        <title>Cliente fisico</title>
    </head>
    <body style="background-image: url(${pageContext.request.contextPath}/img/fundo-site.jpg) ;">
        <nav class="navbar navbar-default" style="background-image:none">
            <div class="container-fluid">
                <!-- Brand and toggle get grouped for better mobile display -->
                <div class="navbar-header">
                    <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#bs-example-navbar-collapse-1" aria-expanded="false">
                        <span class="sr-only"></span>
                        <span class="icon-bar"></span>
                        <span class="icon-bar"></span>
                        <span class="icon-bar"></span>
                    </button>
                    <a id="candt" class="navbar-brand" href="home">CANDT</a>
                </div>

                <!-- Collect the nav links, forms, and other content for toggling -->
                <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
                    <ul class="nav navbar-nav">

                        <li class="dropdown">
                            <a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-haspopup="true" aria-expanded="false">Cliente <span class="caret"></span></a>
                            <ul class="dropdown-menu">
                                <li class=""><a href="CadastroDeClienteFisico">Cadastro Fisico</a></li>
                                <li class=""><a href="CadastroDeClienteJuridico">Cadastro Juridico</a></li> 

                                <li class=""><a>Consultar</a></li>

                            </ul>
                        </li>
                        <li class="dropdown">
                            <a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-haspopup="true" aria-expanded="false">Automovel <span class="caret"></span></a>
                            <ul class="dropdown-menu">
                                <li><a href="CadastroDeAutomovel">Cadastrar</a></li>
                                <li><a href="#">Consultar </a></li>
                            </ul>
                        </li>
                        <li><a href="Locacao">Efetuar Venda</a></li>
                        <li><a href="#">Relatorio</a></li>
                        <li><a href="criarLogin">Novo Login</a></li>
                    </ul>

                    <ul class="nav navbar-nav navbar-right">
                        <li class="dropdown">
                            <a  class="dropdown-toggle" data-toggle="dropdown" role="button" aria-haspopup="true" aria-expanded="false"> <span class="caret"></span></a>
                            <ul class="dropdown-menu">
                                <li></li>
                                <li><a href="AlterarLogin">Alterar senha</a></li>
                                <li><a >Sair</a></li>
                            </ul>
                        </li>
                    </ul>
                </div><!-- /.navbar-collapse -->
            </div><!-- /.container-fluid -->
        </nav>
        <div class="container " >
            <div class="col-lg-4"></div>
            <div class="col-lg-5">
                <div class="jumbotron">
                    <div class="form-group col-sm-offset-3">
                        <i class="fa fa-address-book fa-5x" aria-hidden="true"></i>                        
                    </div>
                    <form class="form-horizontal" method="post" align="center">
                        <div class="form-group">
                            <label for="nomeCompleto" class="col-sm-2 control-label "></label>
                            <div class="col-sm-10">
                                <input type="text " class="form-control" id="nomeCompleto" placeholder="Nome Completo" name="completeName">
                            </div>
                        </div>
                        <div class="form-group">
                            <label for="cpf" class=" col-sm-2 control-label"></label>
                            <div class="col-sm-10">
                                <input type="cpf" class="form-control col-lg-8 " id="cpf" placeholder="Digite o número de CPF" name="cpf">
                            </div>
                        </div>
                        <div class="form-group">
                            <label for="datadeNascimento" class="col-sm-2 control-label "></label>
                            <div class="col-sm-10">
                                <input type="text " class="form-control" id="dataNascimento" placeholder="Data de nascimento" name="dateofbirth">
                            </div>
                        </div>
                        <div class="form-group">
                            <label for="numeroCNH" class="col-sm-2 control-label "></label>
                            <div class="col-sm-10">
                                <input type="text " class="form-control" id="NumeroCNH" placeholder="Número da CNH" name="CNHNumber">
                            </div>
                        </div>
                        <div class="form-group">
                            <label for="endereco" class="col-sm-2 control-label "></label>
                            <div class="col-sm-10">
                                <input type="text " class="form-control" id="endereco" placeholder="Endereço Completo" name="address">
                            </div>
                        </div>
                        <div class="form-group ">
                            <label for="inputState" class="col-sm-2 control-label"></label>
                            <div class="col-sm-10" >
                                <select id="inputState" class="form-control col-sm-8">
                                    <option selected>UF</option>
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
                        </div>
                        <div class="form-group">
                            <label for="cidade" class="col-sm-2 control-label "></label>
                            <div class="col-sm-10">
                                <input type="text " class="form-control" id="cidade" placeholder="Digite sua cidade" name="city">
                            </div>
                        </div>
                        <div class="form-group">
                            <label for="complemento" class="col-sm-2 control-label "></label>
                            <div class="col-sm-10">
                                <input type="text " class="form-control" id="complemento" placeholder="Digite o complemento" name="complement">
                            </div>
                        </div>   
                        <div class="form-group">
                            <label for="bairro" class="col-sm-2 control-label "></label>
                            <div class="col-sm-10">
                                <input type="text " class="form-control" id="bairro" placeholder="Digite o bairro " name="neighborhood">
                            </div>
                        </div>
                        <div class="form-group">
                            <label for="telefone" class="col-sm-2 control-label "></label>
                            <div class="col-sm-10">
                                <input type="text " class="form-control" id="telefone" placeholder="Digite o telefone" name="tel">
                            </div>
                        </div>
                        <div class="form-group">
                            <label for="email" class="col-sm-2 control-label "></label>
                            <div class="col-sm-10">
                                <input type="email" class="form-control" id="email" placeholder="Digite o seu e-mail" name="email">
                            </div>
                        </div>
                        <div class="form-group">
                            <div class="col-sm-offset-1 col-sm-10">
                                <button type="submit" class="btn btn-default ">Cadastrar</button>
                                <button type="submit" class="btn btn-default ">Cancelar</button>
                            </div>                            
                        </div>
                    </form>
                </div>
            </div>
        </div>
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/2.1.1/jquery.min.js"></script>
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
    </body>
</html>
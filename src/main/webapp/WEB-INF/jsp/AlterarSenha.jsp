
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
                <link href="css/bootstrap.min.css" rel="stylesheet">
                <link href="css/AlterarSenha.css" rel="stylesheet">
                 <link rel="stylesheet" href="css/font-awesome.min.css">   
        <title>CANDT</title>
    </head>
    <body style="background-image: url(${pageContext.request.contextPath}/img/fundo-site.jpg) ;">
        <nav class="navbar navbar-default" style="background-image: none">
            <div class="container-fluid">

                <div class="navbar-header">
                    <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#bs-example-navbar-collapse-1" aria-expanded="false">
                        <span class="sr-only"></span>
                        <span class="icon-bar"></span>
                        <span class="icon-bar"></span>
                        <span class="icon-bar"></span>
                    </button>
                    <a id="candt" class="navbar-brand" href="home">CANDT</a>
                </div>


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
                                <li><a href="AlterarLogin">Alterar senha</a></li>
                                <li><a >Sair</a></li>
                            </ul>
                        </li>
                    </ul>
                </div><!-- /.navbar-collapse -->
            </div><!-- /.container-fluid -->
        </nav>
        <div>
            <div class="container " >
                <div class="col-lg-4"></div>
                <div class="col-lg-5">
                    <div  class="jumbotron">
                        <form class="form-horizontal">
                           

                            <div class="form-group">
                                <label for="senha" class="col-sm-2 control-label"><i class="fa fa-lock fa-2x" aria-hidden="true"  ></i></label>
                                <div class="col-sm-10">
                                    <input type="password" class="form-control" id="senha" placeholder="Nova Senha" name="password">
                                </div>
                            </div>
                       
                            <div class="form-group">
                                <div class="col-sm-offset-2 col-sm-10">
                                             <button type="reset" class="btn btn-default">Cancelar</button>
                                    <button type="submit" class="btn btn-default">Confirmar</button>
                           
                                </div>
                            </div>
                        </form>
                    </div>
                </div>
            </div>
        </div>
    </form>
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/2.1.1/jquery.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
</body>
</html>

<%-- 
    Document   : cadastroclientejuridico
    Created on : 23/10/2017, 17:00:43
    Author     : Terui
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="css/bootstrap.min.css" rel="stylesheet">
        <link href="css/log.css" rel="stylesheet">
        <link rel="stylesheet" href="css/font-awesome.min.css">
        <title>Cadastrar cliente juridico</title>
    </head>
    <body style="background-image: url(${pageContext.request.contextPath}/img/fundo-site.jpg) ;">
        <div class="container " >
            <div class="col-lg-4"></div>
            <div class="col-lg-5">
                <div class="jumbotron">
                    <div class="form-group col-sm-offset-3">
                        <i class="fa fa-building-o fa-5x" aria-hidden="true"></i>
                    </div>
                    <form class="form-horizontal" method="post" align="center">
                        <div class="form-group">
                            <label for="nomeEmpresaCompleto" class="col-sm-2 control-label "></label>
                            <div class="col-sm-10">
                                <input type="text " class="form-control" id="nomeCompletoEmpresa" placeholder="Nome Completo da Empresa" name="empresaName">
                            </div>
                        </div>
                        <div class="form-group">
                            <label for="cnpj" class=" col-sm-2 control-label"></label>
                            <div class="col-sm-10">
                                <input type="text" class="form-control col-lg-8 " id="cpf" placeholder="Digite o número de CNPJ" name="cnpj">
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
                                <input type="text " class="form-control" id="encereco" placeholder="Endereço Completo" name="address">
                            </div>
                        </div>
                        <div class="form-group">
                            <label for="uf" class="col-sm-2 control-label "></label>
                            <div class="col-sm-10">
                                <input type="text " class="form-control" id="unidadeFederacao" placeholder="Digite seu Estado" name="estado">
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
    </body>
</html>

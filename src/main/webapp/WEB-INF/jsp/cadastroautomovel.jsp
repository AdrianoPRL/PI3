

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="css/bootstrap.min.css" rel="stylesheet">
        <link href="css/log.css" rel="stylesheet">
        <link rel="stylesheet" href="css/font-awesome.min.css">
        <title>Cadastrar automóvel</title>
    </head>
    <body style="background-image: url(${pageContext.request.contextPath}/img/fundo-site.jpg) ;">
        <div class="container " >
            <div class="col-lg-4"></div>
            <div class="col-lg-5">
                <div class="jumbotron">
                    <div class="form-group col-sm-offset-3">
                        <i class="fa fa-car fa-5x" aria-hidden="true" ></i>
                    </div>
                    <form class="form-horizontal" method="post" align="center">
                        <div class="form-group">
                            <label for="marcaAuto" class="col-sm-2 control-label "></label>
                            <div class="col-sm-10">
                                <input type="text " class="form-control" id="marcaAuto" placeholder="Digite a marca do automóvel" name="marca">
                            </div>
                        </div>
                        <div class="form-group">
                            <label for="modelo" class=" col-sm-2 control-label"></label>
                            <div class="col-sm-10">
                                <input type="text" class="form-control col-lg-8 " id="modeloAuto" placeholder="Digite o modelo do carro" name="model">
                            </div>
                        </div>            
                        <div class="form-group">
                            <label for="ano" class="col-sm-2 control-label "></label>
                            <div class="col-sm-10">
                                <input type="text " class="form-control" id="anoAuto" placeholder="Digite o ano do automóvel" name="anoAuto">
                            </div>
                        </div>
                        <div class="form-group">
                            <label for="categoria" class="col-sm-2 control-label "></label>
                            <div class="col-sm-10">
                                <input type="text " class="form-control" id="categoria" placeholder="Digite a categoria do automóvel" name="acategoria">
                            </div>
                        </div>
                        <div class="form-group">
                            <label for="placa" class="col-sm-2 control-label "></label>
                            <div class="col-sm-10">
                                <input type="text " class="form-control" id="placaAuto" placeholder="Digite a placa do automóvel" name="placa">
                            </div>
                        </div>
                        <div class="form-group">
                            <label for="renavam" class="col-sm-2 control-label "></label>
                            <div class="col-sm-10">
                                <input type="text " class="form-control" id="renavam" placeholder="Digite o renavam do automóvel" name="renavam">
                            </div>
                        </div>
                        <div class="form-group">
                            <label for="numeroChassi" class="col-sm-2 control-label "></label>
                            <div class="col-sm-10">
                                <input type="text " class="form-control" id="numeroChassi" placeholder="Digite o número do chassi" name="nchassi">
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

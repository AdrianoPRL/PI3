
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="css/bootstrap.min.css" rel="stylesheet">
        <link href="css/log.css" rel="stylesheet">
        <link rel="stylesheet" href="css/font-awesome.min.css">
        <title>Login</title>
    </head>
    <body style="background-image: url(${pageContext.request.contextPath}/img/fundo-site.jpg) ;">

        <div class="container " >
            <div class="col-lg-4"></div>
            <div class="col-lg-5">
                <div class="jumbotron">
                    <div class="form-group col-sm-offset-3">
                        <img s rc="${pageContext.request.contextPath}/img/candt.png"  class="img-responsive " width="150" /> 
                    </div>
                    <form class="form-horizontal" method="post" align="center">
                        <div class="form-group">

                            <label for="usuario" class="col-sm-2 control-label ">  <span class="glyphicon glyphicon-user"></span></label>
                            <div class="col-sm-10">
                                <input type="text " class="form-control" id="usuario" placeholder="Usuario" name="username">
                            </div>
                        </div>
                        <div class="form-group">
                            <label for="senha" class=" col-sm-2 control-label"><i class="fa fa-lock" aria-hidden="true"></i></label>
                            <div class="col-sm-10">
                                <input type="password" class="form-control col-lg-8 " id="senha" placeholder="Senha" name="password">
                            </div>
                        </div>
                        <div class="form-group">
                            <div class="col-sm-offset-1 col-sm-10">
                                <div class="lembrar">
                                    <label>
                                        <input type="checkbox" name="lembrar" value="true"> lembra-se de mim
                                    </label>
                                </div>
                            </div>
                        </div>
                        <div class="form-group">
                            <div class="col-sm-offset-1 col-sm-10">
                                <button type="submit" class="btn btn-default ">Logar</button>
                            </div>
                        </div>
                    </form>
                </div>
            </div>
        </div>
    </body>
</html>

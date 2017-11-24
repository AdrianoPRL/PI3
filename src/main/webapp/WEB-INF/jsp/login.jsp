<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
                <div id="first" class="jumbotron" >
                    <div class="form-group col-sm-offset-3">
                       <img src="${pageContext.request.contextPath}/img/candt.png"  class="img-responsive " width="150" /> 
                    </div>
                   
                    <form  action="./login "method="post" class="form-horizontal" >
                        <div class="form-group">
                          
                            <label for="usuario" class="col-sm-2 control-label "><i class="fa fa-user fa-2x" aria-hidden="true"></i></label>
                            <div class="col-sm-10">
                                <input type="text " class="form-control" id="usuario" placeholder="Usuario" name="username">
                            </div>
                        </div>
                        <div class="form-group">
                            <label for="senha" class=" col-sm-2 control-label"><i class="fa fa-lock fa-2x" aria-hidden="true"  ></i></label>
                            <div class="col-sm-10">
                                <input type="password" class="form-control col-lg-8 " id="senha" placeholder="Senha" name="password">
                           
                            </div>
                        </div>
                        <div class="form-group">
                            <div class="col-sm-offset-3 col-sm-10">
                                <div class="lembrar">
                                    <label>
                                        <input type="checkbox" name="lembrar" value="true"> lembra-se de mim
                                    </label>
                                </div>
                            </div>
                        </div>
                        <div class="form-group">
                            <div class="col-sm-offset-4 col-sm-10">
                                
                                <button type="submit" class="btn btn-default ">Logar</button>
                            </div>
                        </div>
                    </form>
                </div>
            </div>
        </div>
    </body>
</html>

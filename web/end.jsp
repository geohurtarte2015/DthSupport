

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>

<%
session.invalidate();//destruye la sesion
%>

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <!-- Bootstrap Core CSS -->
        <link href="plantilla/bower_components/bootstrap/dist/css/bootstrap.min.css" rel="stylesheet">
        
        <script type="text/javascript" src="plantilla/js/jquery-1.9.1.min.js"></script>
        <script type="text/javascript" src="plantilla/bower_components/bootstrap/dist/js/bootstrap.min.js"></script>

          <script language="JavaScript" src ="script.js"> </script>
        <title>DTH Support</title>
    </head>
    <body>
    <center><h1>DTH Support</h1></center>
        <br>
        <br>
        
        
        
<div class="container">
        <div class="row">
            <div class="col-md-4 col-md-offset-4">
                <div class="login-panel panel panel-default">
                    <div class="panel-heading">
                        <h2 class="panel-title">Acaba de salir de la sesión</h2>
                        <br>
                        <h2 class="panel-title">Si desea ingresar nuevamente, ingrese <font color="red"><a href="index.jsp">aqui</a></font></h2> 
                    </div>
                </div>
            </div>
        </div>
    </div>
        
    </body>
</html>

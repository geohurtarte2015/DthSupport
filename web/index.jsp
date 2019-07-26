

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>

<html>
    <head>
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <!-- Bootstrap Core CSS -->
        
      
    <!-- Bootstrap -->
    <link href="plantilla/vendors/bootstrap/dist/css/bootstrap.min.css" rel="stylesheet">
    <!-- Font Awesome -->
    <link href="plantilla/vendors/font-awesome/css/font-awesome.min.css" rel="stylesheet">
   
    <!-- JQVMap -->
    <link href="plantilla/vendors/jqvmap/dist/jqvmap.min.css" rel="stylesheet"/>
    <!-- bootstrap-daterangepicker -->
    <link href="plantilla/vendors/bootstrap-daterangepicker/daterangepicker.css" rel="stylesheet">
    <!-- Custom Theme Style -->
    <link href="plantilla/build/css/custom.min.css" rel="stylesheet">
    <!-- jQuery -->
    <!-- <script src="plantilla/vendors/jquery/dist/jquery.min.js"></script> -->
    <!-- Bootstrap -->
    <script src="plantilla/vendors/bootstrap/dist/js/bootstrap.min.js"></script>
    
    <!-- Alerts -->
    <script src="plantilla/js/bootbox.min.js"></script>  
    
    <script src="plantilla/js/jquery-1.9.1.min.js"></script>
    
    
    
        <title>DTH Support</title>
    </head>
    <body>
    <center><h1 style="color:red">DTH Support</h1></center>
        <br>
        <br>
        
<div class="container">
        <div class="row">
            <div class="col-md-4 col-md-offset-4">
                <div class="login-panel panel panel-default">
                    <div class="panel-heading">
                        <h3 class="panel-title">Ingreso del Usuario</h3>
                    </div>
                   
                    <div class="panel-body">
                        <div id="alerts"></div>
                       
                            <fieldset>
                                
                                <div class="form-group">
                                    <input class="form-control" placeholder="Usuario" id="name" name="name" type="text" autofocus>
                                </div>
                                <div class="form-group">
                                    <input class="form-control" placeholder="Password" id="pass" name="pass" type="password" value="">
                                </div>
                                
                                <input type="button" id="ingresar" value="Ingresar" class="btn btn-lg btn-success btn-block"/>
                            </fieldset>
                    
                    </div>
                </div>
            </div>
        </div>
    </div>
        <script>
           
            $(document).ready(function(){
                $("#ingresar").click(function(){
                   name=$('#name').val();
                   pass=$('#pass').val();
                  $.ajax({
                      type:"post",
                      url: "User",
                      dataType:"text",
                      data: {
                              name: name,
                              pass: pass
                          },
                      success:
                        function(message){
                             if (message.toString().trim() == "errorusuario") {
                           $('#alerts').html("<div class='alert alert-danger'>"+"Error de usuario"+"</div>");
                            } else {
                            $('#alerts').html("<div class='alert alert-success'>"+"Aceptado"+"</div>");
                            window.location.href = "principal.jsp";
                            }
                        }
                  });
                });
              });
            
        </script>
    </body>
</html>

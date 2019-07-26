
<!DOCTYPE html>
<!DOCTYPE html>
<%  
    String nombre = (String) session.getAttribute("nombre");    
    String apellido = (String) session.getAttribute("apellido");
    
    if (session.getAttribute("nombre") == null) {
            response.sendRedirect("index.jsp");
            nombre=null;
    } 
%>
<html lang="en">
  <head>
    <style type="text/css" class="init">
	
	tfoot input {
		width: 100%;
		padding: 3px;
		box-sizing: border-box;
	}

   </style>
   <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <!-- Meta, title, CSS, favicons, etc. -->
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">

    <title>DataTables | Dth Support</title>

    <!-- DatePick -->
    <link href="plantilla/bootdate/build/css/bootstrap-datetimepicker.css" rel="stylesheet">
        
    <!-- Bootstrap -->
    <link href="plantilla/vendors/bootstrap/dist/css/bootstrap.min.css" rel="stylesheet">

    <!-- NProgress -->
    <link href="plantilla/vendors/nprogress/nprogress.css" rel="stylesheet">
    <!-- iCheck -->
    <link href="plantilla/vendors/iCheck/skins/flat/green.css" rel="stylesheet">
    <!-- Datatables -->
    <link href="plantilla/vendors/datatables.net-bs/css/dataTables.bootstrap.min.css" rel="stylesheet">
    <link href="plantilla/vendors/datatables.net-buttons-bs/css/buttons.bootstrap.min.css" rel="stylesheet">
    <link href="plantilla/vendors/datatables.net-fixedheader-bs/css/fixedHeader.bootstrap.min.css" rel="stylesheet">
    <link href="plantilla/vendors/datatables.net-responsive-bs/css/responsive.bootstrap.min.css" rel="stylesheet">
    <link href="plantilla/vendors/datatables.net-scroller-bs/css/scroller.bootstrap.min.css" rel="stylesheet">
    

    <!-- Custom Theme Style -->
    <link href="plantilla/build/css/custom.min.css" rel="stylesheet">
    
  </head>

  <body class="nav-md">
    <div class="container body">
      <div class="main_container">
        <div class="col-md-3 left_col">
          <div class="left_col scroll-view">
            <div class="navbar nav_title" style="border: 0;">
              <a href="index.html" class="site_title"><span>CLARO</span></a>
            </div>

            <div class="clearfix"></div>

            <!-- menu profile quick info -->
            <div class="profile">
            
              <div class="profile_info">
                  <span>Bienvenido,<%=" "+nombre+" "+apellido%></span>
                <h2></h2>
              </div>
            </div>
            <!-- /menu profile quick info -->

            <br />
             <br />
              <br />
               <br />
                <br />

            <!-- sidebar menu -->
            <div id="sidebar-menu" class="main_menu_side hidden-print main_menu">
              <div class="menu_section">
                <h3>General</h3>
                <ul class="nav side-menu">
                  <li><a><i class="fa fa-home"></i> Home <span class="fa fa-chevron-down"></span></a>
                    <ul class="nav child_menu">
                      <li><a href="creacion.jsp">Creacion STB</a></li>  
                      <li><a href="borrar.jsp">Borrar STB</a></li>  
                      <li><a href="borrarCintillo.jsp">Borrar Mensaje Emergente</a></li>  
                      <li><a href="enabled.jsp">Habilitar STB</a></li>  
                      <li><a href="disabled.jsp">Deshabilitar STB</a></li>                  
                      <!--  <li><a href="#">Crear usuario</a></li>  -->
                     <!-- <li><a href="#">Estadisticas</a></li>  -->
                    </ul>
                  </li>
                </ul>
              </div>
      

            </div>
            <!-- /sidebar menu -->

         
          </div>
        </div>

        <!-- top navigation -->
        <div class="top_nav">
          <div class="nav_menu">
            <nav>
              <div class="nav toggle">
                <a id="menu_toggle"><i class="fa fa-bars"></i></a>
              </div>

              <ul class="nav navbar-nav navbar-right">
                <li class="">
                  <a href="javascript:;" class="user-profile dropdown-toggle" data-toggle="dropdown" aria-expanded="false">
                    Opciones
                    <span class=" fa fa-angle-down"></span>
                  </a>
                  <ul class="dropdown-menu dropdown-usermenu pull-right">
                    <li><a href="EndSesion"><i class="fa fa-sign-out pull-right"></i> Salir</a></li>
                  </ul>
                </li>
         
              </ul>
            </nav>
          </div>
        </div>
        <!-- /top navigation -->

        <!-- page content -->
        <div class="right_col" role="main">

        
        </div>
        <!-- /page content -->

        <!-- footer content -->
        <footer>
          <div class="pull-right">
            DTH Support - Desarrollado por Claro Guatemala <a href="https://www.claro.com.gt">Claro que si!</a>
          </div>
          <div class="clearfix"></div>
        </footer>
        <!-- /footer content -->
      </div>
    </div>

    <!-- DatePick -->
    <script src="plantilla/js/jquery-1.9.1.min.js"></script>
    
    <!-- jQuery -->
    <!-- <script src="plantilla/vendors/jquery/dist/jquery.min.js"></script> -->
    
    <!-- bootstrap-daterangepicker -->
    <script src="plantilla/vendors/moment/min/moment.min.js"></script>
    <script src="plantilla/bootdate/src/js/bootstrap-datetimepicker.js"></script>  
    
    <!-- Bootstrap -->
    <script src="plantilla/vendors/bootstrap/dist/js/bootstrap.min.js"></script>
    <!-- FastClick -->
    <script src="plantilla/vendors/fastclick/lib/fastclick.js"></script>
    <!-- NProgress -->
    <script src="plantilla/vendors/nprogress/nprogress.js"></script>
    <!-- iCheck -->
    <script src="plantilla/vendors/iCheck/icheck.min.js"></script>
    <!-- Datatables -->
    <script src="plantilla/vendors/datatables.net/js/jquery.dataTables.min.js"></script>
    <script src="plantilla/vendors/datatables.net-bs/js/dataTables.bootstrap.min.js"></script>
    <script src="plantilla/vendors/datatables.net-buttons/js/dataTables.buttons.min.js"></script>
    <script src="plantilla/vendors/datatables.net-buttons-bs/js/buttons.bootstrap.min.js"></script>
    <script src="plantilla/vendors/datatables.net-buttons/js/buttons.flash.min.js"></script>
    <script src="plantilla/vendors/datatables.net-buttons/js/buttons.html5.min.js"></script>
    <script src="plantilla/vendors/datatables.net-buttons/js/buttons.print.min.js"></script>
    <script src="plantilla/vendors/datatables.net-fixedheader/js/dataTables.fixedHeader.min.js"></script>
    <script src="plantilla/vendors/datatables.net-keytable/js/dataTables.keyTable.min.js"></script>
    <script src="plantilla/vendors/datatables.net-responsive/js/dataTables.responsive.min.js"></script>
    <script src="plantilla/vendors/datatables.net-responsive-bs/js/responsive.bootstrap.js"></script>
    <script src="plantilla/vendors/jszip/dist/jszip.min.js"></script>
    <script src="plantilla/vendors/pdfmake/build/pdfmake.min.js"></script>
    <script src="plantilla/vendors/pdfmake/build/vfs_fonts.js"></script>
    
    

    <!-- Custom Theme Scripts -->
    <script src="plantilla/build/js/custom.min.js"></script>
    
     <script type="text/javascript">
      var dateinit="";  
      var datefinish="";
      
      $('#message').hide();
     $(function () {
                    $('#fechainicio').datetimepicker({
                        format: "DD-MM-YYYY hh:mm:ss a"                      
                        });
                    });
                    
     $(function () {
                    $('#fechafinal').datetimepicker({
                        format: "DD-MM-YYYY hh:mm:ss a"                      
                        });
                    });
         
     $(document).ready(function() {
         
         var tableTransaction= $('#TBTRANSACTION').DataTable( {
                    "ajax" : {
                        "url": "ServletTransactionVas",
                        "type": "POST",
                        "data" : function(d){
                                d.datefinish = datefinish;
                                d.dateinit = dateinit;
                            },
                         "complete" : function(response){
                             $('#message').hide();
                         }
                        },
                        "global" : false,
                        "lengthMenu": [[ 6, -1], [ 10,20,"All"]],
                        "dom" : "Bfrtip",
                        "buttons" : [
                                'csv', 'excel'
                        ],
                        "dataType" : "json",
                       
                        "columns" : [
                            {"title": "ID"},                        
                            {"title": "PAIS"},
                            {"title": "MSISDN"},  
                            {"title": "ID CONTRATO"}, 
                            {"title": "ID PRODDUCTO"}, 
                            {"title": "NOMBRE"},
                            {"title": "APELLIDO"},
                            {"title": "EMAIL"},
                            {"title": "ESTADO"},
                            {"title": "FECHA REGISTRO"},
                            {"title": "WS ID"},     
                            {"title": "WS RESPUESTA"}
                        ]
              
                    });
         
         $("#btnClear").click(function(){
             
             $("#fechainiciotxt").val("");
             $("#fechafinaltxt").val("");
             tableTransaction.clear().draw();
             
         });
         
         $("#btnSubmit").click(function(){
             
             dateinit=$("#fechainiciotxt").val();
             datefinish=$("#fechafinaltxt").val();
             
            $('#TBTRANSACTION tfoot th').each( function () {
                var title = $(this).text();
                $(this).html( '<input type="text" placeholder="Filtrar por '+title+'" />' );
            } );  
         
         
                    
        
        tableTransaction.clear().draw();
        $('#message').show();
           //recarga los datos nuevamente en el dataTable por ajax
        tableTransaction.ajax.reload(); 
            
         tableTransaction.columns().every( function () {
            var that = this;
 
                $( 'input', this.footer() ).on( 'keyup change', function () {
                    if ( that.search() !== this.value ) {
                        that
                            .search( this.value )
                            .draw();
                        }
                } );
            } );
           
           
          }); 
         
         
        
            
         
     } );
        
     
    
    
    </script>


  </body>
</html>


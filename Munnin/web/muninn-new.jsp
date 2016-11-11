<!DOCTYPE html>
<html lang="en">
<head>
	<title>Munnin</title>
	<meta charset="UTF-8">
	<meta name="viewport" content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
	<link rel="shortcut icon" type="image/x-icon" href="imagenes/logo.png">
	<link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css">
	<link rel="stylesheet" href="css/skin-start.css">
	<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
</head>
<body data-spy="scroll" data-target=".navbar" data-offset="50">
	<!--<div class="container-fluid" style="background-color:#FFFFFF;color:#fff;height:100px;">
		<img src="imagenes/logo-completo.png" alt="munnin_icono" class="full-logo">
	</div>-->

	<!--navbar-->
	<nav class="navbar navbar-default navbar-fixed-top">
		<div class="container-fluid">
			<div class="navbar-header">
				<button type="button" class="navbar-toggle" data-toggle="collapse" data-target="#myNavbar" style="padding-top: 1px;padding-bottom: 0px;padding-left: 5px;padding-right: 5px;margin-right: 12px;">
					<div class="container" onclick="myFunction(this)" style="padding-right: 0px;padding-left: 0px;">
						<div class="bar1"></div>
						<div class="bar2"></div>
						<div class="bar3"></div>
					</div>
				</button>
				<a class="navbar-brand" href="#">Munnin</a>
			</div>
			<div class="collapse navbar-collapse" id="myNavbar">
				<ul class="nav navbar-nav">
					<li><a href="#vtn1" class="btn" data-toggle="modal">Material de Apoyo </a></li>
					<li><a href="#vtn2" class="btn" data-toggle="modal">listas de chequeo </a></li>
					<li><a href="#vtn3" class="btn" data-toggle="modal">buscar </a></li>
					<li><a href="#vtn4" class="btn" data-toggle="modal">agregar usuario</a></li>
				</ul>
				<ul class="nav navbar-nav navbar-right">
					<li><a href="#" data-toggle="popover" data-placement="bottom" title="funciona!" data-content="Aqui irian las notificaciones."><span class="glyphicon glyphicon-bell"></span></a></li>
					<li class="dropdown">
			            <a href="#" class="dropdown-toggle" data-toggle="dropdown"><span class="glyphicon glyphicon-user"></span> Usuario</a>
		              	<ul class="dropdown-menu ">
		                	<li><a href="#"><span class="glyphicon glyphicon-cog"></span> Editar Perfil</a></li>
		                	<li><a href="#"><span class="glyphicon glyphicon-envelope"></span> Bandeja</a></li>
		               		<li><a href="#"><span class="glyphicon glyphicon-credit-card"></span> Calendario</a></li>
		               		<li><a href="#"><span class="glyphicon glyphicon-warning-sign"></span> PF</a></li>
		               		<li><a href="#" onclick="openNav()"> Rol</a></li>			
		              	</ul>
		            </li>
					<li><a href="index.jsp"><span class="glyphicon glyphicon-log-in"></span> Salir</a></li>
				</ul>
			</div>
		</div>
	</nav>

	<!--changing role-->
	<div id="mySidenav" class="sidenav">
		<a href="javascript:void(0)" class="closebtn" onclick="closeNav()">&times;</a>
	  	<a href="#"><span class="fa fa-eye" style="font-size:18px"></span> Administrador</a>
	  	<a href="#">Cordinador</a>
	  	<a href="#">ETecnico</a>
	  	<a href="#">EPedagojico</a>
	  	<a href="#">Instructor</a>
	</div>

	<!--left changing_role-->
	<div class="left">
		<div class="item">
			<span class="fa fa-eye glyphicon" style="font-size:18px"></span>Administrador
		</div>
		<div class="item active">
			<span class="fa fa-file-o glyphicon" style="font-size:18px"></span>Cordinador
		</div>
		<div class="item">
			<span class="fa fa-group glyphicon" style="font-size:18px"></span>ETecnico
		</div>
		<div class="item">
			<span class="fa fa-group glyphicon" style="font-size:18px"></span>EPedagojico
		</div> 
		<div class="item">
			<span class="fa fa-user-circle glyphicon" style="font-size:18px"></span>Instructor
		</div>    
	</div>

	<!--content start_page-->
	<div class="container-fluid filled">
		<div class="inbox-mail">
			<div class="col-md-3 compose">
			        <h2>Hacer</h2>
			    <nav class="nav-sidebar">
					<ul class="nav tabs">
			          	<li class=""><a href="#tab1" data-toggle="tab"><i class="fa fa-inbox"></i> Entrada <span>9</span><div class="clearfix"></div></a></li>
			         	<li class=""><a href="#tab2" data-toggle="tab"><i class="fa fa-paper-plane-o"></i> Enviados</a></li>
			         	<li class="active"><a href="#tab3" data-toggle="tab"><i class="fa fa-star-o"></i> Importante</a></li> 
			         	<li class=""><a href="#tab4" data-toggle="tab"><i class="fa fa-pencil-square-o"></i> Borrador<span>6</span><div class="clearfix"></div></a></li>  
			          	<li class=""><a href="#tab5" data-toggle="tab"><i class="fa fa-trash-o"></i> Eliminados</a></li>                              
					</ul>
				</nav>
				<div class="content-box">
					<ul>
					<li><span>Carpeta</span></li>
					<li><a href="#"><i class="fa fa-folder-o"></i>Tareas</a></li>
					<li><a href="#"><i class="fa fa-folder-o"></i>Trabajos</a></li>
					<li><a href="#"><i class="fa fa-folder-o"></i>Otros</a></li>
					</ul>
		        </div>
			</div>

			<div class="col-md-9 tab-content tab-content-in">
				<div class="tab-pane text-style" id="tab1">
			  		<div class="inbox-right">	
			            <div class="mailbox-content">
			               	<div class="mail-toolbar clearfix">
						     	<div class="float-left">
							       	<div class="btn-group m-r-sm mail-hidden-options" style="display: inline-block;">
		                                <div class="btn-group">
		                                    <a class="btn btn-default dropdown-toggle" data-toggle="dropdown" aria-expanded="false"><i class="fa fa-folder"></i> <span class="caret"></span></a>
		                                    <ul class="dropdown-menu dropdown-menu-right" role="menu">
		                                        <li><a href="#">Social</a></li>
		                                        <li><a href="#">Foros</a></li>
		                                        <li><a href="#">Recientes</a></li>
		                                       
		                                        <li><a href="#">Spam</a></li>
		                                        <li><a href="#">Basura</a></li>
		                                       
		                                        <li><a href="#">Nuevo</a></li>
		                                    </ul>
		                                </div>
		                                <div class="btn-group">
		                                    <a class="btn btn-default dropdown-toggle" data-toggle="dropdown" aria-expanded="false"><i class="fa fa-tags"></i> <span class="caret"></span></a>
		                                    <ul class="dropdown-menu dropdown-menu-right" role="menu">
		                                        <li><a href="#">Work</a></li>
		                                        <li><a href="#">Family</a></li>
		                                        <li><a href="#">Social</a></li>
		                                       
		                                        <li><a href="#">Primary</a></li>
		                                        <li><a href="#">Promotions</a></li>
		                                        <li><a href="#">Forums</a></li>
		                                    </ul>
		                                </div>
				                    </div>
								</div>
							    <div class="float-right">
									<div class="dropdown">
							            <a href="#" title="" class="btn btn-default" data-toggle="dropdown" aria-expanded="false">
							                <i class="fa fa-cog icon_8"></i>
							                <i class="fa fa-chevron-down icon_8"></i>
							            <div class="ripple-wrapper"></div></a>
							            <ul class="dropdown-menu float-right">
							                <li>
							                    <a href="#" title="">
							                        <i class="fa fa-pencil-square-o icon_9"></i>
							                        Edit
							                    </a>
							                </li>
							                <li>
							                    <a href="#" title="">
							                        <i class="fa fa-calendar icon_9"></i>
							                        Schedule
							                    </a>
							                </li>
							                <li>
							                    <a href="#" title="">
							                        <i class="fa fa-download icon_9"></i>
							                        Download
							                    </a>
							                </li>
							               
							                <li>
							                    <a href="#" class="font-red" title="">
							                        <i class="fa fa-times" icon_9=""></i>
							                        Delete
							                    </a>
							                </li>
							            </ul>
							        </div>        
		                            <div class="btn-group">
		                                <a class="btn btn-default"><i class="fa fa-angle-left"></i></a>
		                                <a class="btn btn-default"><i class="fa fa-angle-right"></i></a>
		                            </div>   
							    </div>
			               	</div>

			                <table class="table">
			                    <tbody>
			                        <tr class="table-row">
			                            <td class="table-img">
			                               <img src="imagenes/in.jpg" alt="" />
			                            </td>
			                            <td class="table-text">
			                            	<h6> Lorem ipsum</h6>
			                                <p>Nullam quis risus eget urna mollis ornare vel eu leo</p>
			                            </td>
			                            <td>
			                            	<span class="fam">Family</span>
			                            </td>
			                            <td class="march">
			                               in 5 days 
			                            </td>
			                          
			                             <td >
										 <i class="fa fa-star-half-o icon-state-warning"></i>
			                                
			                            </td>
			                        </tr>
			                       <tr class="table-row">
			                            <td class="table-img">
			                               <img src="imagenes/in1.jpg" alt="" />
			                            </td>
			                            <td class="table-text">
			                            	<h6> Lorem ipsum</h6>
			                                <p>Nullam quis risus eget urna mollis ornare vel eu leo</p>
			                            </td>
			                            <td>
			                            	<span class="mar">Market</span>
			                            </td>
			                            <td class="march">
			                                in 5 days 
			                            </td>
			                          
			                             <td >
			                               <i class="fa fa-star-half-o icon-state-warning"></i>
			                            </td>
			                        </tr>
			                        <tr class="table-row">
			                            <td class="table-img">
			                               <img src="imagenes/in2.jpg" alt="" />
			                            </td>
			                            <td class="table-text">
			                            	<h6> Lorem ipsum</h6>
			                                <p>Nullam quis risus eget urna mollis ornare vel eu leo</p>
			                            </td>
			                            <td>
			                            	<span class="work">work</span>
			                            </td>
			                            <td class="march">
			                                in 5 days 
			                            </td>
			                          
			                             <td >
			                               <i class="fa fa-star-half-o icon-state-warning"></i>
			                            </td>
			                        </tr>
			                        <tr class="table-row">
			                            <td class="table-img">
			                               <img src="imagenes/in3.jpg" alt="" />
			                            </td>
			                            <td class="table-text">
			                            	<h6> Lorem ipsum</h6>
			                                <p>Nullam quis risus eget urna mollis ornare vel eu leo</p>
			                            </td>
			                            <td>
			                            	<span class="fam">Family</span>
			                            </td>
			                            <td class="march">
			                              in 4 days 
			                            </td>
			                          
			                             <td >
			                               <i class="fa fa-star-half-o icon-state-warning"></i>
			                            </td>
			                        </tr>
			                        <tr class="table-row">
			                            <td class="table-img">
			                               <img src="imagenes/in4.jpg" alt="" />
			                            </td>
			                            <td class="table-text">
			                            	<h6> Lorem ipsum</h6>
			                                <p>Nullam quis risus eget urna mollis ornare vel eu leo</p>
			                            </td>
			                            <td>
			                            	<span class="ur">urgent</span>
			                            </td>
			                            <td class="march">
			                                in 4 days 
			                            </td>
			                          
			                             <td >
			                               <i class="fa fa-star-half-o icon-state-warning"></i>
			                            </td>
			                        </tr>
			                        <tr class="table-row">
			                            <td class="table-img">
			                               <img src="imagenes/in5.jpg" alt="" />
			                            </td>
			                            <td class="table-text">
			                            	<h6> Lorem ipsum</h6>
			                                <p>Nullam quis risus eget urna mollis ornare vel eu leo</p>
			                            </td>
			                            <td>
			                            	
			                            </td>
			                            <td class="march">
			                                in 3 days  
			                            </td>
			                          
			                             <td >
			                               <i class="fa fa-star-half-o icon-state-warning"></i>
			                            </td>
			                        </tr>
			                        <tr class="table-row">
			                            <td class="table-img">
			                               <img src="imagenes/in6.jpg" alt="" />
			                            </td>
			                            <td class="table-text">
			                            	<h6> Lorem ipsum</h6>
			                                <p>Nullam quis risus eget urna mollis ornare vel eu leo</p>
			                            </td>
			                            <td>
			                            	<span class="fam">Family</span>
			                            </td>
			                            <td class="march">
			                               in 2 days  
			                            </td>
			                          
			                             <td >
			                               <i class="fa fa-star-half-o icon-state-warning"></i>
			                            </td>
			                        </tr>
			                        <tr class="table-row">
			                            <td class="table-img">
			                               <img src="imagenes/in7.jpg" alt="" />
			                            </td>
			                            <td class="table-text">
			                            	<h6> Lorem ipsum</h6>
			                                <p>Nullam quis risus eget urna mollis ornare vel eu leo</p>
			                            </td>
			                            <td>
			                            	<span class="ur">urgent</span>
			                            </td>
			                            <td class="march">
			                                in 2 days 
			                            </td>
			                          
			                             <td >
			                               <i class="fa fa-star-half-o icon-state-warning"></i>
			                            </td>
			                        </tr>
									<tr class="table-row">
			                            <td class="table-img">
			                               <img src="imagenes/in8.jpg" alt="" />
			                            </td>
			                            <td class="table-text">
			                            	<h6> Lorem ipsum</h6>
			                                <p>Nullam quis risus eget urna mollis ornare vel eu leo</p>
			                            </td>
			                            <td>
			                            
			                            </td>
			                            <td class="march">
			                                in 2 days 
			                            </td>
			                          
			                             <td >
			                               <i class="fa fa-star-half-o icon-state-warning"></i>
			                            </td>
			                        </tr>
									<tr class="table-row">
			                            <td class="table-img">
			                               <img src="imagenes/in9.jpg" alt="" />
			                            </td>
			                            <td class="table-text">
			                            	<h6> Lorem ipsum</h6>
			                                <p>Nullam quis risus eget urna mollis ornare vel eu leo</p>
			                            </td>
			                            <td>
			                            	
			                            </td>
			                            <td class="march">
			                                in 2 days 
			                            </td>
			                          
			                             <td >
			                               <i class="fa fa-star-half-o icon-state-warning"></i>
			                            </td>
			                        </tr>
									<tr class="table-row">
			                            <td class="table-img">
			                               <img src="imagenes/in10.jpg" alt="" />
			                            </td>
			                            <td class="table-text">
			                            	<h6> Lorem ipsum</h6>
			                                <p>Nullam quis risus eget urna mollis ornare vel eu leo</p>
			                            </td>
			                            <td>
			                            	<span class="mar">Market</span>
			                            </td>
			                            <td class="march">
			                                in 1 days 
			                            </td>
			                          
			                             <td >
			                               <i class="fa fa-star-half-o icon-state-warning"></i>
			                            </td>
			                        </tr>
									<tr class="table-row">
			                            <td class="table-img">
			                               <img src="imagenes/in11.jpg" alt="" />
			                            </td>
			                            <td class="table-text">
			                            	<h6> Lorem ipsum</h6>
			                                <p>Nullam quis risus eget urna mollis ornare vel eu leo</p>
			                            </td>
			                            <td>
			                            	<span class="ur">urgent</span>
			                            </td>
			                            <td class="march">
			                                in 1 days 
			                            </td>
			                          
			                             <td >
			                               <i class="fa fa-star-half-o icon-state-warning"></i>
			                            </td>
			                        </tr>
			                    </tbody>
			                </table>
			            </div>
			        </div>
				</div>
				<div class="tab-pane text-style" id="tab2">
					<div class="inbox-right">
			            <div class="mailbox-content">
			               	<div class="mail-toolbar clearfix">
					     		<div class="float-left">
					       			<div class="btn-group m-r-sm mail-hidden-options" style="display: inline-block;">
		                                <div class="btn-group">
		                                    <a class="btn btn-default dropdown-toggle" data-toggle="dropdown" aria-expanded="false"><i class="fa fa-folder"></i> <span class="caret"></span></a>
		                                    <ul class="dropdown-menu dropdown-menu-right" role="menu">
		                                        <li><a href="#">Social</a></li>
		                                        <li><a href="#">Forums</a></li>
		                                        <li><a href="#">Updates</a></li>
		                                       
		                                        <li><a href="#">Spam</a></li>
		                                        <li><a href="#">Trash</a></li>
		                                       
		                                        <li><a href="#">New</a></li>
		                                    </ul>
		                                </div>
		                                <div class="btn-group">
		                                    <a class="btn btn-default dropdown-toggle" data-toggle="dropdown" aria-expanded="false"><i class="fa fa-tags"></i> <span class="caret"></span></a>
		                                    <ul class="dropdown-menu dropdown-menu-right" role="menu">
		                                        <li><a href="#">Work</a></li>
		                                        <li><a href="#">Family</a></li>
		                                        <li><a href="#">Social</a></li>
		                                       
		                                        <li><a href="#">Primary</a></li>
		                                        <li><a href="#">Promotions</a></li>
		                                        <li><a href="#">Forums</a></li>
		                                    </ul>
		                                </div>
		                            </div>
					        	</div>
					    		<div class="float-right">
									<div class="dropdown">
							            <a href="#" title="" class="btn btn-default" data-toggle="dropdown" aria-expanded="false">
							                <i class="fa fa-cog icon_8"></i>
							                <i class="fa fa-chevron-down icon_8"></i>
							            <div class="ripple-wrapper"></div></a>
							            <ul class="dropdown-menu float-right">
							                <li>
							                    <a href="#" title="">
							                        <i class="fa fa-pencil-square-o icon_9"></i>
							                        Edit
							                    </a>
							                </li>
							                <li>
							                    <a href="#" title="">
							                        <i class="fa fa-calendar icon_9"></i>
							                        Schedule
							                    </a>
							                </li>
							                <li>
							                    <a href="#" title="">
							                        <i class="fa fa-download icon_9"></i>
							                        Download
							                    </a>
							                </li>
							               
							                <li>
							                    <a href="#" class="font-red" title="">
							                        <i class="fa fa-times" icon_9=""></i>
							                        Delete
							                    </a>
							                </li>
							            </ul>
							        </div>
		                            <div class="btn-group">
		                                <a class="btn btn-default"><i class="fa fa-angle-left"></i></a>
		                                <a class="btn btn-default"><i class="fa fa-angle-right"></i></a>
		                            </div>
		                        </div>
			               	</div>
			                <table class="table">
			                    <tbody>
			                       	<tr class="table-row">
			                            <td class="table-img">
			                               <img src="imagenes/in1.jpg" alt="" />
			                            </td>
			                            <td class="table-text">
			                            	<h6> Lorem ipsum</h6>
			                                <p>Nullam quis risus eget urna mollis ornare vel eu leo</p>
			                            </td>
			                            <td>
			                            	<span class="mar">Market</span>
			                            </td>
			                            <td class="march">
			                                in 5 days 
			                            </td>
			                          
			                             <td >
			                               <i class="fa fa-star-half-o icon-state-warning"></i>
			                            </td>
			                        </tr>
			                        <tr class="table-row">
			                            <td class="table-img">
			                               <img src="imagenes/in2.jpg" alt="" />
			                            </td>
			                            <td class="table-text">
			                            	<h6> Lorem ipsum</h6>
			                                <p>Nullam quis risus eget urna mollis ornare vel eu leo</p>
			                            </td>
			                            <td>
			                            	<span class="work">work</span>
			                            </td>
			                            <td class="march">
			                                in 5 days 
			                            </td>
			                          
			                             <td >
			                               <i class="fa fa-star-half-o icon-state-warning"></i>
			                            </td>
			                        </tr>
			                        <tr class="table-row">
			                            <td class="table-img">
			                               <img src="imagenes/in3.jpg" alt="" />
			                            </td>
			                            <td class="table-text">
			                            	<h6> Lorem ipsum</h6>
			                                <p>Nullam quis risus eget urna mollis ornare vel eu leo</p>
			                            </td>
			                            <td>
			                            	<span class="fam">Family</span>
			                            </td>
			                            <td class="march">
			                              in 4 days 
			                            </td>
			                          
			                             <td >
			                               <i class="fa fa-star-half-o icon-state-warning"></i>
			                            </td>
			                        </tr>
			                        <tr class="table-row">
			                            <td class="table-img">
			                               <img src="imagenes/in4.jpg" alt="" />
			                            </td>
			                            <td class="table-text">
			                            	<h6> Lorem ipsum</h6>
			                                <p>Nullam quis risus eget urna mollis ornare vel eu leo</p>
			                            </td>
			                            <td>
			                            	<span class="ur">urgent</span>
			                            </td>
			                            <td class="march">
			                                in 4 days 
			                            </td>
			                          
			                             <td >
			                               <i class="fa fa-star-half-o icon-state-warning"></i>
			                            </td>
			                        </tr>
			                        <tr class="table-row">
			                            <td class="table-img">
			                               <img src="imagenes/in5.jpg" alt="" />
			                            </td>
			                            <td class="table-text">
			                            	<h6> Lorem ipsum</h6>
			                                <p>Nullam quis risus eget urna mollis ornare vel eu leo</p>
			                            </td>
			                            <td>
			                            	
			                            </td>
			                            <td class="march">
			                                in 3 days  
			                            </td>
			                          
			                             <td >
			                               <i class="fa fa-star-half-o icon-state-warning"></i>
			                            </td>
			                        </tr>
			                        <tr class="table-row">
			                            <td class="table-img">
			                               <img src="imagenes/in6.jpg" alt="" />
			                            </td>
			                            <td class="table-text">
			                            	<h6> Lorem ipsum</h6>
			                                <p>Nullam quis risus eget urna mollis ornare vel eu leo</p>
			                            </td>
			                            <td>
			                            	<span class="fam">Family</span>
			                            </td>
			                            <td class="march">
			                               in 2 days  
			                            </td>
			                          
			                             <td >
			                               <i class="fa fa-star-half-o icon-state-warning"></i>
			                            </td>
			                        </tr> 
			                    </tbody>
			                </table>
			            </div>
				    </div>
				</div>
				<div class="tab-pane active text-style" id="tab3">
					<div class="inbox-right">
		            	<div class="mailbox-content">
		               		<div class="mail-toolbar clearfix">
					     		<div class="float-left">
					       			<div class="btn-group m-r-sm mail-hidden-options" style="display: inline-block;">
		                                <div class="btn-group">
		                                    <a class="btn btn-default dropdown-toggle" data-toggle="dropdown" aria-expanded="false"><i class="fa fa-folder"></i> <span class="caret"></span></a>
		                                    <ul class="dropdown-menu dropdown-menu-right" role="menu">
		                                        <li><a href="#">Social</a></li>
		                                        <li><a href="#">Forums</a></li>
		                                        <li><a href="#">Updates</a></li>
		                                       
		                                        <li><a href="#">Spam</a></li>
		                                        <li><a href="#">Trash</a></li>
		                                       
		                                        <li><a href="#">New</a></li>
		                                    </ul>
		                                </div>
		                                <div class="btn-group">
		                                    <a class="btn btn-default dropdown-toggle" data-toggle="dropdown" aria-expanded="false"><i class="fa fa-tags"></i> <span class="caret"></span></a>
		                                    <ul class="dropdown-menu dropdown-menu-right" role="menu">
		                                        <li><a href="#">Work</a></li>
		                                        <li><a href="#">Family</a></li>
		                                        <li><a href="#">Social</a></li>
		                                       
		                                        <li><a href="#">Primary</a></li>
		                                        <li><a href="#">Promotions</a></li>
		                                        <li><a href="#">Forums</a></li>
		                                    </ul>
		                                </div>
		                            </div>
					        	</div>
					    		<div class="float-right">
									<div class="dropdown">
							            <a href="#" title="" class="btn btn-default" data-toggle="dropdown" aria-expanded="false">
							                <i class="fa fa-cog icon_8"></i>
							                <i class="fa fa-chevron-down icon_8"></i>
							            	<div class="ripple-wrapper"></div></a>
							            <ul class="dropdown-menu float-right">
							                <li>
							                    <a href="#" title="">
							                        <i class="fa fa-pencil-square-o icon_9"></i>
							                        Edit
							                    </a>
							                </li>
							                <li>
							                    <a href="#" title="">
							                        <i class="fa fa-calendar icon_9"></i>
							                        Schedule
							                    </a>
							                </li>
							                <li>
							                    <a href="#" title="">
							                        <i class="fa fa-download icon_9"></i>
							                        Download
							                    </a>
							                </li>
							               
							                <li>
							                    <a href="#" class="font-red" title="">
							                        <i class="fa fa-times" icon_9=""></i>
							                        Delete
							                    </a>
							                </li>
							            </ul>
					        		</div>
		                            <div class="btn-group">
		                                <a class="btn btn-default"><i class="fa fa-angle-left"></i></a>
		                                <a class="btn btn-default"><i class="fa fa-angle-right"></i></a>
		                            </div>
					    		</div>
		               		</div>
		                	<table class="table">
		                    	<tbody>
			                        <tr class="table-row">
			                            <td class="table-img">
			                               <img src="imagenes/in6.jpg" alt="" />
			                            </td>
			                            <td class="table-text">
			                            	<h6> Lorem ipsum</h6>
			                                <p>Nullam quis risus eget urna mollis ornare vel eu leo</p>
			                            </td>
			                            <td>
			                            	<span class="fam">Family</span>
			                            </td>
			                            <td class="march">
			                               in 2 days  
			                            </td>
			                          
			                             <td >
			                               <i class="fa fa-star-half-o icon-state-warning"></i>
			                            </td>
			                        </tr>
			                        <tr class="table-row">
			                            <td class="table-img">
			                               <img src="imagenes/in7.jpg" alt="" />
			                            </td>
			                            <td class="table-text">
			                            	<h6> Lorem ipsum</h6>
			                                <p>Nullam quis risus eget urna mollis ornare vel eu leo</p>
			                            </td>
			                            <td>
			                            	<span class="ur">urgent</span>
			                            </td>
			                            <td class="march">
			                                in 2 days 
			                            </td>
			                          
			                             <td >
			                               <i class="fa fa-star-half-o icon-state-warning"></i>
			                            </td>
			                        </tr>
									<tr class="table-row">
			                            <td class="table-img">
			                               <img src="imagenes/in8.jpg" alt="" />
			                            </td>
			                            <td class="table-text">
			                            	<h6> Lorem ipsum</h6>
			                                <p>Nullam quis risus eget urna mollis ornare vel eu leo</p>
			                            </td>
			                            <td>
			                            
			                            </td>
			                            <td class="march">
			                                in 2 days 
			                            </td>
			                          
			                             <td >
			                               <i class="fa fa-star-half-o icon-state-warning"></i>
			                            </td>
			                        </tr>
									<tr class="table-row">
			                            <td class="table-img">
			                               <img src="imagenes/in9.jpg" alt="" />
			                            </td>
			                            <td class="table-text">
			                            	<h6> Lorem ipsum</h6>
			                                <p>Nullam quis risus eget urna mollis ornare vel eu leo</p>
			                            </td>
			                            <td>
			                            	
			                            </td>
			                            <td class="march">
			                                in 2 days 
			                            </td>
			                          
			                             <td >
			                               <i class="fa fa-star-half-o icon-state-warning"></i>
			                            </td>
			                        </tr>
									<tr class="table-row">
			                            <td class="table-img">
			                               <img src="imagenes/in10.jpg" alt="" />
			                            </td>
			                            <td class="table-text">
			                            	<h6> Lorem ipsum</h6>
			                                <p>Nullam quis risus eget urna mollis ornare vel eu leo</p>
			                            </td>
			                            <td>
			                            	<span class="mar">Market</span>
			                            </td>
			                            <td class="march">
			                                in 1 days 
			                            </td>
			                          
			                             <td >
			                               <i class="fa fa-star-half-o icon-state-warning"></i>
			                            </td>
			                        </tr>
									<tr class="table-row">
			                            <td class="table-img">
			                               <img src="imagenes/in11.jpg" alt="" />
			                            </td>
			                            <td class="table-text">
			                            	<h6> Lorem ipsum</h6>
			                                <p>Nullam quis risus eget urna mollis ornare vel eu leo</p>
			                            </td>
			                            <td>
			                            	<span class="ur">urgent</span>
			                            </td>
			                            <td class="march">
			                                in 1 days 
			                            </td>
			                          
			                             <td >
			                               <i class="fa fa-star-half-o icon-state-warning"></i>
			                            </td>
			                        </tr>
		                    	</tbody>
		                	</table>
		               	</div>
		            </div>
		 		</div>
		  		<div class="tab-pane text-style" id="tab4">
		  			<div class="inbox-right">
		            	<div class="mailbox-content">
		               		<div class="mail-toolbar clearfix">
					    	 	<div class="float-left">
					       			<div class="btn-group m-r-sm mail-hidden-options" style="display: inline-block;">
		                                <div class="btn-group">
		                                    <a class="btn btn-default dropdown-toggle" data-toggle="dropdown" aria-expanded="false"><i class="fa fa-folder"></i> <span class="caret"></span></a>
		                                    <ul class="dropdown-menu dropdown-menu-right" role="menu">
		                                        <li><a href="#">Social</a></li>
		                                        <li><a href="#">Forums</a></li>
		                                        <li><a href="#">Updates</a></li>
		                                       
		                                        <li><a href="#">Spam</a></li>
		                                        <li><a href="#">Trash</a></li>
		                                       
		                                        <li><a href="#">New</a></li>
		                                    </ul>
		                                </div>
		                                <div class="btn-group">
		                                    <a class="btn btn-default dropdown-toggle" data-toggle="dropdown" aria-expanded="false"><i class="fa fa-tags"></i> <span class="caret"></span></a>
		                                    <ul class="dropdown-menu dropdown-menu-right" role="menu">
		                                        <li><a href="#">Work</a></li>
		                                        <li><a href="#">Family</a></li>
		                                        <li><a href="#">Social</a></li>
		                                       
		                                        <li><a href="#">Primary</a></li>
		                                        <li><a href="#">Promotions</a></li>
		                                        <li><a href="#">Forums</a></li>
		                                    </ul>
		                                </div>
		                            </div>
					        	</div>
					    		<div class="float-right">
									<div class="dropdown">
							            <a href="#" title="" class="btn btn-default" data-toggle="dropdown" aria-expanded="false">
							                <i class="fa fa-cog icon_8"></i>
							                <i class="fa fa-chevron-down icon_8"></i>
							            <div class="ripple-wrapper"></div></a>
							            <ul class="dropdown-menu float-right">
							                <li>
							                    <a href="#" title="">
							                        <i class="fa fa-pencil-square-o icon_9"></i>
							                        Edit
							                    </a>
							                </li>
							                <li>
							                    <a href="#" title="">
							                        <i class="fa fa-calendar icon_9"></i>
							                        Schedule
							                    </a>
							                </li>
							                <li>
							                    <a href="#" title="">
							                        <i class="fa fa-download icon_9"></i>
							                        Download
							                    </a>
							                </li>
							               
							                <li>
							                    <a href="#" class="font-red" title="">
							                        <i class="fa fa-times" icon_9=""></i>
							                        Delete
							                    </a>
							                </li>
							            </ul>
					        		</div>
		                            <div class="btn-group">
		                                <a class="btn btn-default"><i class="fa fa-angle-left"></i></a>
		                                <a class="btn btn-default"><i class="fa fa-angle-right"></i></a>
		                            </div>
					    		</div>
		               		</div>
		                	<table class="table">
			                    <tbody>
			                        <tr class="table-row">
			                            <td class="table-img">
			                               <img src="imagenes/in.jpg" alt="" />
			                            </td>
			                            <td class="table-text">
			                            	<h6> Lorem ipsum</h6>
			                                <p>Nullam quis risus eget urna mollis ornare vel eu leo</p>
			                            </td>
			                            <td>
			                            	<span class="fam">Family</span>
			                            </td>
			                            <td class="march">
			                               in 5 days 
			                            </td>
			                          
			                             <td >
										 <i class="fa fa-star-half-o icon-state-warning"></i>
			                                
			                            </td>
			                        </tr>
			                       <tr class="table-row">
			                            <td class="table-img">
			                               <img src="imagenes/in1.jpg" alt="" />
			                            </td>
			                            <td class="table-text">
			                            	<h6> Lorem ipsum</h6>
			                                <p>Nullam quis risus eget urna mollis ornare vel eu leo</p>
			                            </td>
			                            <td>
			                            	<span class="mar">Market</span>
			                            </td>
			                            <td class="march">
			                                in 5 days 
			                            </td>
			                          
			                             <td >
			                               <i class="fa fa-star-half-o icon-state-warning"></i>
			                            </td>
			                        </tr>
			                        <tr class="table-row">
			                            <td class="table-img">
			                               <img src="imagenes/in2.jpg" alt="" />
			                            </td>
			                            <td class="table-text">
			                            	<h6> Lorem ipsum</h6>
			                                <p>Nullam quis risus eget urna mollis ornare vel eu leo</p>
			                            </td>
			                            <td>
			                            	<span class="work">work</span>
			                            </td>
			                            <td class="march">
			                                in 5 days 
			                            </td>
			                          
			                             <td >
			                               <i class="fa fa-star-half-o icon-state-warning"></i>
			                            </td>
			                        </tr>
			                        <tr class="table-row">
			                            <td class="table-img">
			                               <img src="imagenes/in3.jpg" alt="" />
			                            </td>
			                            <td class="table-text">
			                            	<h6> Lorem ipsum</h6>
			                                <p>Nullam quis risus eget urna mollis ornare vel eu leo</p>
			                            </td>
			                            <td>
			                            	<span class="fam">Family</span>
			                            </td>
			                            <td class="march">
			                              in 4 days 
			                            </td>
			                          
			                             <td >
			                               <i class="fa fa-star-half-o icon-state-warning"></i>
			                            </td>
			                        </tr>
			                        <tr class="table-row">
			                            <td class="table-img">
			                               <img src="imagenes/in4.jpg" alt="" />
			                            </td>
			                            <td class="table-text">
			                            	<h6> Lorem ipsum</h6>
			                                <p>Nullam quis risus eget urna mollis ornare vel eu leo</p>
			                            </td>
			                            <td>
			                            	<span class="ur">urgent</span>
			                            </td>
			                            <td class="march">
			                                in 4 days 
			                            </td>
			                          
			                             <td >
			                               <i class="fa fa-star-half-o icon-state-warning"></i>
			                            </td>
			                        </tr>
			                        <tr class="table-row">
			                            <td class="table-img">
			                               <img src="imagenes/in5.jpg" alt="" />
			                            </td>
			                            <td class="table-text">
			                            	<h6> Lorem ipsum</h6>
			                                <p>Nullam quis risus eget urna mollis ornare vel eu leo</p>
			                            </td>
			                            <td>
			                            	
			                            </td>
			                            <td class="march">
			                                in 3 days  
			                            </td>
			                          
			                             <td >
			                               <i class="fa fa-star-half-o icon-state-warning"></i>
			                            </td>
			                        </tr>
			                    </tbody>
		                	</table>
		               	</div>
		            </div>
		  		</div>
		  		<div class="tab-pane text-style" id="tab5">
		  			<div class="inbox-right">
		            	<div class="mailbox-content">
		               		<div class="mail-toolbar clearfix">
					     		<div class="float-left">
					       			<div class="btn-group m-r-sm mail-hidden-options" style="display: inline-block;">
		                                <div class="btn-group">
		                                    <a class="btn btn-default dropdown-toggle" data-toggle="dropdown" aria-expanded="false"><i class="fa fa-folder"></i> <span class="caret"></span></a>
		                                    <ul class="dropdown-menu dropdown-menu-right" role="menu">
		                                        <li><a href="#">Social</a></li>
		                                        <li><a href="#">Forums</a></li>
		                                        <li><a href="#">Updates</a></li>
		                                       
		                                        <li><a href="#">Spam</a></li>
		                                        <li><a href="#">Trash</a></li>
		                                       
		                                        <li><a href="#">New</a></li>
		                                    </ul>
		                                </div>
		                                <div class="btn-group">
		                                    <a class="btn btn-default dropdown-toggle" data-toggle="dropdown" aria-expanded="false"><i class="fa fa-tags"></i> <span class="caret"></span></a>
		                                    <ul class="dropdown-menu dropdown-menu-right" role="menu">
		                                        <li><a href="#">Work</a></li>
		                                        <li><a href="#">Family</a></li>
		                                        <li><a href="#">Social</a></li>
		                                       
		                                        <li><a href="#">Primary</a></li>
		                                        <li><a href="#">Promotions</a></li>
		                                        <li><a href="#">Forums</a></li>
		                                    </ul>
		                                </div>
		                            </div>
		                        </div>
					    		<div class="float-right">
									<div class="dropdown">
							            <a href="#" title="" class="btn btn-default" data-toggle="dropdown" aria-expanded="false">
							                <i class="fa fa-cog icon_8"></i>
							                <i class="fa fa-chevron-down icon_8"></i>
							            <div class="ripple-wrapper"></div></a>
							            <ul class="dropdown-menu float-right">
							                <li>
							                    <a href="#" title="">
							                        <i class="fa fa-pencil-square-o icon_9"></i>
							                        Edit
							                    </a>
							                </li>
							                <li>
							                    <a href="#" title="">
							                        <i class="fa fa-calendar icon_9"></i>
							                        Schedule
							                    </a>
							                </li>
							                <li>
							                    <a href="#" title="">
							                        <i class="fa fa-download icon_9"></i>
							                        Download
							                    </a>
							                </li>
							               
							                <li>
							                    <a href="#" class="font-red" title="">
							                        <i class="fa fa-times" icon_9=""></i>
							                        Delete
							                    </a>
							                </li>
							            </ul>
					       	 		</div>
		                            <div class="btn-group">
		                                <a class="btn btn-default"><i class="fa fa-angle-left"></i></a>
		                                <a class="btn btn-default"><i class="fa fa-angle-right"></i></a>
		                            </div>
		                        </div>
							</div>
			                <table class="table">
			                    <tbody>
			                       
			                       <tr class="table-row">
			                            <td class="table-img">
			                               <img src="imagenes/in1.jpg" alt="" />
			                            </td>
			                            <td class="table-text">
			                            	<h6> Lorem ipsum</h6>
			                                <p>Nullam quis risus eget urna mollis ornare vel eu leo</p>
			                            </td>
			                            <td>
			                            	<span class="mar">Market</span>
			                            </td>
			                            <td class="march">
			                                in 5 days 
			                            </td>
			                          
			                             <td >
			                               <i class="fa fa-star-half-o icon-state-warning"></i>
			                            </td>
			                        </tr>
			                       
			                        <tr class="table-row">
			                            <td class="table-img">
			                               <img src="imagenes/in3.jpg" alt="" />
			                            </td>
			                            <td class="table-text">
			                            	<h6> Lorem ipsum</h6>
			                                <p>Nullam quis risus eget urna mollis ornare vel eu leo</p>
			                            </td>
			                            <td>
			                            	<span class="fam">Family</span>
			                            </td>
			                            <td class="march">
			                              in 4 days 
			                            </td>
			                          
			                             <td >
			                               <i class="fa fa-star-half-o icon-state-warning"></i>
			                            </td>
			                        </tr>
			                       
			                        <tr class="table-row">
			                            <td class="table-img">
			                               <img src="imagenes/in5.jpg" alt="" />
			                            </td>
			                            <td class="table-text">
			                            	<h6> Lorem ipsum</h6>
			                                <p>Nullam quis risus eget urna mollis ornare vel eu leo</p>
			                            </td>
			                            <td>
			                            	
			                            </td>
			                            <td class="march">
			                                in 3 days  
			                            </td>
			                          
			                             <td >
			                               <i class="fa fa-star-half-o icon-state-warning"></i>
			                            </td>
			                        </tr>
			                       
			                        <tr class="table-row">
			                            <td class="table-img">
			                               <img src="imagenes/in7.jpg" alt="" />
			                            </td>
			                            <td class="table-text">
			                            	<h6> Lorem ipsum</h6>
			                                <p>Nullam quis risus eget urna mollis ornare vel eu leo</p>
			                            </td>
			                            <td>
			                            	<span class="ur">urgent</span>
			                            </td>
			                            <td class="march">
			                                in 2 days 
			                            </td>
			                          
			                             <td >
			                               <i class="fa fa-star-half-o icon-state-warning"></i>
			                            </td>
			                        </tr>
									
									<tr class="table-row">
			                            <td class="table-img">
			                               <img src="imagenes/in10.jpg" alt="" />
			                            </td>
			                            <td class="table-text">
			                            	<h6> Lorem ipsum</h6>
			                                <p>Nullam quis risus eget urna mollis ornare vel eu leo</p>
			                            </td>
			                            <td>
			                            	<span class="mar">Market</span>
			                            </td>
			                            <td class="march">
			                                in 1 days 
			                            </td>
			                          
			                             <td >
			                               <i class="fa fa-star-half-o icon-state-warning"></i>
			                            </td>
			                        </tr>
									<tr class="table-row">
			                            <td class="table-img">
			                               <img src="imagenes/in11.jpg" alt="" />
			                            </td>
			                            <td class="table-text">
			                            	<h6> Lorem ipsum</h6>
			                                <p>Nullam quis risus eget urna mollis ornare vel eu leo</p>
			                            </td>
			                            <td>
			                            	<span class="ur">urgent</span>
			                            </td>
			                            <td class="march">
			                                in 1 days 
			                            </td>
			                          
			                             <td >
			                               <i class="fa fa-star-half-o icon-state-warning"></i>
			                            </td>
			                        </tr>
			                    </tbody>
			                </table>
		               	</div>
		            </div>
				</div>
			</div>   
		</div>
	</div>
	
	
	<!--Upload files-->
	<div class="modal fade" id="vtn1">
		<div class="modal-dialog">	
			<div class="modal-content">
				<div class="modal-header">	
					<button tyle="button" class="close" data-dismiss="modal" aria-hiden="true">&times;</button>
					<h3 class="modal-title">Material de apoyo </h3>
				</div>
				<div class="modal-body" style="background:#F6FBFC">
					<label for="#upload">Ingresa el archivo : </label><input id="upload" name="imagen" type="file" style="display:inline">
					<br>
					<form role="form">
					    <div class="form-group">
							<label for="#sel1">Categoria : </label>
							<select class="form-control" id="sel1">
								<option>Categoria </option>
								<option>Programacion</option>
								<option>Dibujo Artistico</option>
								<option>Libro claramente no plagiado</option>
								<option>Chupa el perro 2</option>
								<option>Mi libro luna de pluton es todo un exito...</option>
							</select>
							<br>
							<label for="#sel2">Tipo : </label>
							<select class="form-control" id="sel2">
								<option>Taller </option>
								<option>Esto no es una guia</option>
								<option>Lectura </option>
								<option>Evaluacion </option>
								<option>Otro </option>
							</select>
						</div>
					</form>		
					<h4>Comentarios : </h4>
					<textarea name="" id="" cols="77" rows="10"></textarea>
				</div>
				<div class="modal-footer">
					<button type="button" class="btn btn-primary">Enviar</button>
					<button type="button" class="btn btn-danger" data-dismiss="modal">Cancelar</button>	
				</div>
			</div>
		</div>
	</div>

	<!--check_list-->
	<div class="modal fade" id="vtn2">
		<div class="modal-dialog">	
			<div class="modal-content">
				<div class="modal-header">
					<button tyle="button" class="close" data-dismiss="modal" aria-hiden="true">&times;</button>
					<h3 class="modal-title">Lista de chequeo equipo X </h3>
				</div>
				<div class="modal-body">
					<form method="POST">
						<label for="nombreLista">nombre de la lista:</label>
						<input type="text" class="form-control" id="nombreLista">
					    <div id="dynamicInput">
					        <input type="checkbox"><label for="item"> Item 1</label>
					        <textarea class="form-control" cols="77" rows="3"></textarea><br>
					    </div>
					    <input type="button" class="btn btn-default" value="Agregar Item" onClick="addInput('dynamicInput');">
					    <a href="#" title="Ayuda al Usuario" data-toggle="popover" data-content="El boton 'guardar' permitira que el usuario pueda guardar la lista de chequeo actual para usarla posteriormente, y el boton 'agregar' añadira la lista de chequeo sin guardarla.">¿Primera vez?</a>
					</form>
				</div>
				<div class="modal-footer">
					<button type="button" class="btn btn-success">Guardar</button>
					<button type="button" class="btn btn-primary">Agregar</button>
		            <button type="button" class="btn btn-danger" data-dismiss="modal">Cancelar</button>
		        </div>
			</div>
		</div>
	</div>
			
	<!--pruebas filtro-->
	<div class="modal fade" id="vtn3">
		<div class="modal-dialog">	
			<div class="modal-content">
				<div class="modal-header">
					<button tyle="button" class="close" data-dismiss="modal" aria-hiden="true">&times;</button>
					<h3 class="modal-title">Filtros : </h3>
				</div>
				<div class="modal-body">
					<form>
						<!--<input class="search" type="text" name="search" placeholder="Buscar...">-->
						<br>
						<label for="#sel3">Categoria :</label>
						<select id="sel3" class="form-control">
							<option>Categoria </option>
							<option>Programacion </option>
							<option>Diseño </option>
							<option>Dibujo Artistico </option>
						</select>
						<label for="#sel4">Tipo :</label>
						<select id="sel4" class="form-control">
							<option>Taller </option>
							<option>Esto sigue sin ser una guia </option>
							<option>Evaluacion </option>
							<option>Lectura </option>
						</select>
						<label for="#sel5">Area de Formacion</label>
						<select id="sel4" class="form-control">
							<option>Area... </option>
							<option>opcion 1 </option>
							<option>opcion 2 </option>
							<option>opcion 3 </option>
						</select>
					</form>
				</div>
			</div>
		</div>
	</div>

	<!--add user -->
	<div class="modal fade" id="vtn4">
		<div class="modal-dialog">
			<div class="modal-content">
				<div class="modal-header">
					<button tyle="button" class="close" data-dismiss="modal" aria-hiden="true">&times;</button>
					<h3 class="modal-title">Agregar Usuario</h3>
				</div>
				<div class="modal-body">
					<div style="position:relative">
					<form action="">
						<label for="nombre">Nombres : </label>
						<input type="text" class="form-control" id="nombre">
						<label for="apellido">Apellidos : </label>
						<input type="text" class="form-control" id="apellido">
						<label for="documento">Documento :</label>
						<select id="documento" class="form-control" style="width:120px">
							<option value="">C.C. </option>
							<option value="">C.E. </option>
							<option value="">Pasaporte </option>	
						</select>
						<input type="text" class="form-control" id="documento">
						<label for="correo">Correo : </label>
						<input type="text" class="form-control" id="correo">
						<label for="correo1">Confirme su correo  </label>
						<input type="text" class="form-control" id="correo1">
						<label for="contraseña">Contraseña :</label>
						<input type="text" class="form-control" id="contraseña">
						<label for="contraseña1">Confirme su contraseña :</label>
						<input type="text" class="form-control" id="contraseña1">
						<label for="rol">Seleccione rol :</label>
						<select id="rol" class="form-control">
							<option value="">Instructor </option>
							<option value="">Jefe equipo tecnico</option>
							<option value="">Jefe equipo pedagogico</option>
							<option value="">Cordinador </option>
							<option value="" disabled>Admin </option>
						</select>
					</form>
					</div>
				</div>
				<div class="modal-footer">
					<button type="button" class="btn btn-success">Añadir </button>
					<button type="button" class="btn btn-danger" data-dismiss="modal">Cancelar</button>
				</div>
			</div>
		</div>
	</div>
	
	<!--footer-->
	<div class="Restricted__footer">
		<div class="Footer">
			<div class="Footer__topMenu">
				<div class="Footer__topMenu__item">
					<a class="Footer__topMenu__item__link" href="#">
						About
					</a>
				</div>
				<div class="Footer__topMenu__item">
					<a class="Footer__topMenu__item__link" href="#">
						Blog
					</a>
				</div>
				<div class="Footer__topMenu__item">
					<a class="Footer__topMenu__item__link" href="#">
						Privacy
					</a>
				</div>
				<div class="Footer__topMenu__item">
					<a class="Footer__topMenu__item__link" href="#">
						Terms
					</a>
				</div>
			</div>
			<div class="Footer__bottomMenu">
				<div class="Footer__copyrightText">
					<p>© 2016 Munnin.</p>
				</div>
			</div>
		</div>
	</div>
	
	

	<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.2/jquery.min.js"></script>
	<script src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/js/bootstrap.min.js"></script>
	<script src="js/add-forms.js" language="Javascript" type="text/javascript"></script>
	<script src="js/rol.js" language="Javascript" type="text/javascript"></script>
	<script src="js/menu.js" languaje="Javascript" type="text/javascript"></script>
	<!-- <script src="js/jquery.nicescroll.js"></script> -->
	<!-- <script src="js/scripts.js"></script> -->
</body>
</html>


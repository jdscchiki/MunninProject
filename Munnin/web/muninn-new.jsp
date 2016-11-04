<!DOCTYPE html>
<html lang="en">
	<head>
		<title>Munnin</title>
		<meta charset="UTF-8">
		<meta name="viewport" content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
		<link rel="shortcut icon" type="image/x-icon" href="imagenes/logo.png">
		<link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css">
		<link rel="stylesheet" href="css/skin-start.css">
		<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.6.3/css/font-awesome.min.css">
	
		<style>

		</style>
		
	</head>
<body>
	<div class="container-fluid" style="background-color:#FFFFFF;color:#fff;height:100px;">
		<img src="imagenes/logo-completo.png" alt="munnin_icono" class="full-logo">
	</div>

	<nav class="navbar navbar-default" data-spy="affix" data-offset-top="197" style="margin-bottom: 0px;">
		<div class="container-fluid">
			<div class="navbar-header">
				<button type="button" class="navbar-toggle" data-toggle="collapse" data-target="#myNavbar">
					<span class="icon-bar"></span>
					<span class="icon-bar"></span>
					<span class="icon-bar"></span>
				</button>
			</div>
			<div class="collapse navbar-collapse" id="myNavbar">
				<ul class="nav navbar-nav">
					<li><a href="#vtn1" class="btn" data-toggle="modal">Material de Apoyo </a></li>
					<li><a href="#vtn2" class="btn" data-toggle="modal">listas de chequeo </a></li>
					<li><a href="#vtn3" class="btn" data-toggle="modal">buscar </a></li>
					<li><a href="#vtn4" class="btn" data-toggle="modal">agregar usuario</a></li>
				</ul>
				<ul class="nav navbar-nav navbar-right">
					<li><input type="text" name="search" class="search" placeholder="Buscar..."></li>
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
	<div id="mySidenav" class="sidenav">
		<a href="javascript:void(0)" class="closebtn" onclick="closeNav()">&times;</a>
	  	<a href="#">Administrador</a>
	  	<a href="#">Profesor</a>
	  	<a href="#">ETecnico</a>
	  	<a href="#">EPedagojico</a>
	</div>

	<div class="left">
		<div class="item">
			<span class="glyphicon glyphicon-th-large"></span>
		</div>
		<div class="item active">
			<span class="glyphicon glyphicon-th-list"></span>opcion1
		</div>
		<div class="item">
			<span class="glyphicon glyphicon-log-out"></span>opcion2
		</div>
		<div class="item">
			<span class="fa fa-group glyphicon" style="font-size:18px"></span></span>opcion3
		</div> 
		<div class="item">
			<span class="glyphicon glyphicon-random"></span>opcion4
		</div>
		<div class="item">
			<span class="glyphicon glyphicon-remove"></span>opcion5
		</div>    
	</div>

	<div class="container-fluid">
		<!--<h1>Lorem Ipsum es simplemente el texto de relleno de las imprentas y archivos de texto. Lorem Ipsum ha sido el texto de relleno estándar de las industrias desde el año 1500, cuando un impresor (N. del T. persona que se dedica a la imprenta) desconocido usó una galería de textos y los mezcló de tal manera que logró hacer un libro de textos especimen. No sólo sobrevivió 500 años, sino que tambien ingresó como texto de relleno en documentos electrónicos, quedando esencialmente igual al original. Fue popularizado en los 60s con la creación de las hojas "Letraset", las cuales contenian pasajes de Lorem Ipsum, y más recientemente con software de autoedición, como por ejemplo Aldus PageMaker, el cual incluye versiones de Lorem Ipsum.</h1>-->

		<div class="inbox-mail container-fluid">
			<div class="col-md-4 compose">
		            <h2>Compose</h2>
		    <nav class="nav-sidebar">
				<ul class="nav tabs">
		          <li class="active"><a href="#tab1" data-toggle="tab"><i class="fa fa-inbox"></i>Inbox <span>9</span><div class="clearfix"></div></a></li>
		          <li class=""><a href="#tab2" data-toggle="tab"><i class="fa fa-paper-plane-o"></i>Sent</a></li>
		          <li class=""><a href="#tab3" data-toggle="tab"><i class="fa fa-star-o"></i>Important</a></li> 
		          <li class=""><a href="#tab4" data-toggle="tab"><i class="fa fa-pencil-square-o"></i>Draft <span>6</span><div class="clearfix"></div></a></li>  
		          <li class=""><a href="#tab5" data-toggle="tab"><i class="fa fa-trash-o"></i>Delete</a></li>                              
				</ul>
			</nav>
				<div class="content-box container-fluid">
					<ul>
					<li><span>Folder</span></li>
					<li><a href="#"><i class="fa fa-folder-o"></i>Tasks</a></li>
					<li><a href="#"><i class="fa fa-folder-o"></i>Jobs</a></li>
					<li><a href="#"><i class="fa fa-folder-o"></i>Client</a></li>
					</ul>
		        </div>
		</div>
		<!-- tab content -->
		<div class="col-md-8 tab-content tab-content-in">
		<div class="tab-pane active text-style" id="tab1">
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
		<div class="tab-pane text-style" id="tab3">
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
		<div class="clearfix"> </div>
		   </div>
		    
		</div>
	</div>
	
	
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

			<!--btn listas de chequeo-->
			
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

			<!--agregar usuario -->
			
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

	<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.2/jquery.min.js"></script>
	<script src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/js/bootstrap.min.js"></script>
	<script src="js/add-forms.js" language="Javascript" type="text/javascript"></script>
	<script src="js/rol.js" language="Javascript" type="text/javascript"></script>

</body>

</html>
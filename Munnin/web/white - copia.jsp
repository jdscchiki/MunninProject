<!DOCTYPE html>
<html lang="en">
<head>
	<title>Munnin</title>
	<meta charset="UTF-8">
	<meta name="viewport" content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
	<link rel="shortcut icon" type="image/x-icon" href="imagenes/logo.png">
	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
	<link rel="stylesheet" href="css/skin-start3.css">
	<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
</head>
<body data-spy="scroll" data-target=".navbar" data-offset="50">

<!--navbar-->
	<nav class="navbar navbar-default">
		<div class="container-fluid">
			<div class="navbar-header">
				<button type="button" class="navbar-toggle" data-toggle="collapse" data-target="#myNavbar" style="padding-top: 1px;padding-bottom: 0px;padding-left: 5px;padding-right: 5px;margin-right: 12px;">
					<div class="container" onclick="myFunction(this)" style="padding-right: 0px;padding-left: 0px;">
						<div class="bar1"></div>
						<div class="bar2"></div>
						<div class="bar3"></div>
					</div>
				</button>
				<img class="navbar-brand" src="imagenes/LogoNavbar.png" alt="munnin-logo" style="padding: 7px 7px;">
			</div>
			<div class="collapse navbar-collapse" id="myNavbar">
				<ul class="nav navbar-nav">
					<li><a href="javascript:void(0)">opcion1</a></li>
					<li><a href="javascript:void(0)">opcion2</a></li>
			      	<li><a href="javascript:void(0)">opcion3</a></li>
				</ul>
				<ul class="nav navbar-nav navbar-right">
					<li><a href="#" data-toggle="popover" data-placement="bottom" title="funciona!" data-content="Aqui irian las notificaciones."><span class="glyphicon glyphicon-bell"></span></a></li>
					<li class="dropdown">
			            <a href="#" class="dropdown-toggle" data-toggle="dropdown"><span class="glyphicon glyphicon-user"></span> Usuario</a>
		              	<ul class="dropdown-menu ">
		                	<li><a href="#"><span class="glyphicon glyphicon-cog"></span> Editar Perfil</a></li>
		               		<li><a href="#"><span class="glyphicon glyphicon-credit-card"></span> Calendario</a></li>
		               		<li><a href="#"><span class="fa fa-question-circle-o glyphicon"></span> Preguntas Frecuentes</a></li>		
		              	</ul>
		            </li>
					<li><a href="#vtn" data-toggle="modal"><span class="glyphicon glyphicon-log-in"></span> Salir</a></li>
				</ul>
			</div>
		</div>
	</nav>

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
			<span class="fa fa-group glyphicon" style="font-size:18px"></span>EPedagogico
		</div> 
		<div class="item">
			<span class="fa fa-user-circle glyphicon" style="font-size:18px"></span>Instructor
		</div>    
	</div>

<!--Log out-->
	<div class="modal fade" id="vtn">
    	<div class="modal-dialog modal-sm">
			<div class="modal-content">
				<div class="modal-header">
					<button type="button" class="close" data-dismiss="modal">&times;</button>
					<h4 class="modal-title">Modal Header</h4>
				</div>
				<div class="modal-body">
					<p>¿Esta seguro de querer salir?</p>
				</div>
				<div class="modal-footer">
					<button type="button" class="btn btn-default" data-dismiss="modal">Cancelar</button>
					<button type="button" class="btn btn-primary" data-dismiss="modal" onclick=" location.href='index.jsp'">Salir</button>
				</div>
			</div>
		</div>
	</div>

<!--content start_page-->
	<div id="main" class="container-fluid filled" style="padding-top: 0px;margin-left: 50px">
		
		<div class="contain">
			<div class="col-md-12">
				<div class="panel"> 	
					<p>Lorem ipsum dolor sit amet, consectetur adipiscing elit. Quisque sed auctor nisi, vitae cursus nunc. Integer cursus congue quam quis vestibulum. Suspendisse quis iaculis sem. Ut eu lacus nibh. Nullam fermentum varius tempor. In fringilla felis in elit placerat ultricies. Donec convallis vitae purus ut posuere. In consectetur pellentesque ipsum quis accumsan. Pellentesque lorem nulla, tincidunt vitae felis in, auctor feugiat dui. Phasellus lectus diam, posuere nec viverra fermentum, porttitor ut ipsum. Suspendisse sed finibus diam. Aenean ac fermentum magna.

					Cum sociis natoque penatibus et magnis dis parturient montes, nascetur ridiculus mus. Nulla elementum dolor enim, vel bibendum lacus porta sed. Proin nec fermentum purus. Nunc vel ante eros. Vestibulum ante ipsum primis in faucibus orci luctus et ultrices posuere cubilia Curae; Cras volutpat sem et neque volutpat feugiat. Quisque non tortor risus. Mauris tincidunt congue mi vitae varius. Integer id libero non ex vehicula ullamcorper. Mauris et velit eu libero feugiat mollis. Vestibulum augue tortor, consectetur nec purus viverra, interdum mattis nulla.

					Maecenas laoreet fermentum justo id finibus. Curabitur volutpat iaculis orci sed finibus. Ut vestibulum consequat vestibulum. Sed vel est leo. Etiam semper est eros, id lacinia leo porta nec. Suspendisse quis vehicula nulla, nec semper erat. Sed lacinia diam in nisl tincidunt, ac tristique tortor ultricies. Sed cursus ante a ipsum vestibulum ullamcorper accumsan ut elit. Donec ultricies tellus a enim rhoncus malesuada. Donec ut pharetra nunc.

					In hac habitasse platea dictumst. Duis rhoncus consequat orci et pharetra. Mauris purus augue, ultricies vel tellus aliquam, luctus porta urna. Donec aliquet est nec nunc ullamcorper, ac dignissim odio vestibulum. Maecenas molestie odio libero. Integer vitae est ac ligula vehicula efficitur in nec urna. Maecenas bibendum pharetra tortor, nec lacinia ex tristique in. Interdum et malesuada fames ac ante ipsum primis in faucibus. Maecenas ultricies lacus id efficitur consequat. Morbi massa tellus, posuere et bibendum at, gravida aliquet odio. Cras sed dapibus elit. Proin cursus nisi sed leo lobortis condimentum. Fusce id mattis quam. Donec sit amet scelerisque sapien. Vestibulum eu accumsan nibh. Phasellus tincidunt tincidunt magna, id pharetra ante.

					Donec at ipsum id velit dictum sodales. Phasellus eleifend tellus mauris, accumsan vehicula enim euismod ac. Integer viverra enim non cursus sollicitudin. Nunc accumsan, magna sit amet lacinia scelerisque, leo magna ultrices nisi, ut gravida erat nisi et tellus. Pellentesque euismod porta libero, sit amet efficitur tellus. Sed leo arcu, vulputate ut eleifend ut, laoreet vitae diam. Cras ut facilisis sem. Fusce condimentum posuere purus in auctor. Quisque auctor augue nulla, eget aliquam eros pulvinar ac. Pellentesque lacinia, nunc sed blandit condimentum, eros ligula accumsan neque, vitae convallis ligula arcu a augue. Curabitur mollis sollicitudin porttitor. Nam facilisis eleifend velit, vitae pulvinar urna sodales eu.

					Sed eget odio eu enim consequat interdum sed non tellus. Pellentesque eget velit vehicula, gravida est non, ultrices nibh. Nam sed leo dictum, imperdiet turpis nec, malesuada enim. Phasellus dapibus nibh id imperdiet pellentesque. Quisque at egestas nulla. Praesent vitae mattis elit. Cras mattis, dui nec efficitur convallis, turpis felis tempor quam, a elementum turpis magna et magna. Vestibulum ultrices eros nulla, non rutrum tellus suscipit eget. Nulla laoreet nibh non nisl consectetur egestas. Curabitur ut dictum quam. Aenean ultricies sit amet orci id consequat. Proin lobortis velit a odio maximus, ut malesuada metus congue.

					Duis faucibus faucibus gravida. Donec eu sapien ut urna sollicitudin vehicula. Morbi eu nisi massa. Integer ac fermentum dui. Fusce velit sem, laoreet a ex eu, laoreet elementum nunc. Morbi bibendum egestas odio quis imperdiet. Pellentesque nisl nisl, maximus sit amet ante id, pretium sagittis velit. Cras tellus nibh, pulvinar at nunc ac, commodo commodo velit.

					Nullam tristique dui tortor, vitae molestie mauris rutrum at. Maecenas vestibulum facilisis mauris, quis ornare tortor bibendum vel. Sed tristique ipsum sed turpis accumsan, id ornare metus condimentum. Nunc volutpat mollis purus id lacinia. Suspendisse ac odio laoreet, vestibulum turpis at, euismod quam. Pellentesque habitant morbi tristique senectus et netus et malesuada fames ac turpis egestas. Vivamus ante nibh, accumsan in efficitur tincidunt, eleifend sit amet nisi. Praesent dignissim mauris nec posuere posuere. Ut convallis tristique lorem, ut gravida quam pulvinar vel.

					Cum sociis natoque penatibus et magnis dis parturient montes, nascetur ridiculus mus. Suspendisse sed leo purus. Aenean gravida quis turpis in venenatis. Maecenas nec neque sodales, porttitor leo lobortis, vestibulum risus. Aenean tincidunt porta lorem, a placerat urna. Donec tincidunt vel metus sed luctus. Pellentesque ante dolor, finibus quis magna sed, bibendum molestie mauris.

					Vivamus egestas, tortor a vulputate tempor, eros sem scelerisque magna, vel fermentum ex mi non ex. Morbi porta a sapien iaculis accumsan. Nulla a diam nisl. Donec a ultrices mauris, at maximus mauris. Nulla tincidunt turpis ex, vel condimentum leo euismod id. Curabitur nulla est, consequat et aliquet at, lacinia eget eros. Etiam augue dui, venenatis et sem a, egestas dictum diam.

					Phasellus tincidunt posuere mauris, eget ornare massa malesuada quis. Morbi porttitor rhoncus elit eget fringilla. Cras vestibulum auctor dictum. Fusce tincidunt velit massa, nec ornare magna vehicula non. Phasellus non dapibus dolor, eget volutpat magna. Suspendisse non imperdiet nisi. Nam et nisi pharetra, ornare libero at, pulvinar est. Pellentesque lacinia finibus mi eu rhoncus.

					Proin aliquam ligula a nulla lobortis ultrices. Nunc accumsan pellentesque orci, vitae tincidunt orci scelerisque sit amet. Mauris sit amet enim non dolor sodales fermentum. Maecenas et eros non sem ullamcorper vulputate a quis augue. Maecenas vel urna vel erat efficitur sollicitudin vitae ac tellus. Phasellus ultricies dictum neque. Vestibulum ante ipsum primis in faucibus orci luctus et ultrices posuere cubilia Curae; In egestas diam a libero maximus, quis molestie lacus tristique. Maecenas placerat dolor lacinia eros ultricies, in fermentum purus eleifend. Nulla pharetra sodales orci sit amet dictum. Pellentesque aliquet blandit justo, laoreet vestibulum quam sodales in. Vestibulum elementum metus vitae eros venenatis, non interdum augue feugiat. Mauris molestie diam volutpat auctor rutrum. In egestas odio in mauris tempor ultrices.

					Etiam vulputate nunc ac lorem vulputate, vel auctor quam imperdiet. Quisque gravida at nisi sed faucibus. Sed ultricies suscipit nulla, id dictum quam cursus a. Aenean venenatis nibh in pharetra elementum. Quisque ullamcorper risus vitae ornare gravida. Vivamus tempor, tortor ac rhoncus pellentesque, purus turpis iaculis est, luctus aliquam ligula dolor nec nisl. Curabitur tempus neque quam, et aliquam urna cursus ac. Fusce efficitur, eros vitae condimentum rhoncus, odio justo viverra nulla, quis interdum urna lectus ac odio. In iaculis pellentesque rutrum. Proin suscipit, mi nec venenatis viverra, enim ipsum interdum nunc, vitae sollicitudin dolor dolor nec tellus. Aenean porttitor nunc non varius hendrerit.

					Sed malesuada tristique felis, hendrerit mollis nisi varius id. Curabitur nec odio libero. Vivamus elementum, dolor at congue ultrices, neque orci venenatis sem, quis bibendum libero metus sit amet arcu. Vestibulum interdum ac erat sollicitudin tempus. Fusce hendrerit lacinia iaculis. Nam et tincidunt erat. Aenean dapibus nibh hendrerit quam lobortis posuere. Phasellus imperdiet felis at fringilla luctus. Praesent ipsum libero, posuere ac magna quis, aliquam pulvinar elit.

					Maecenas vitae nulla urna. Suspendisse vel feugiat lorem, id facilisis lacus. Vestibulum tempus lorem id cursus convallis. Phasellus vel augue accumsan enim fringilla vehicula. Ut ullamcorper dui in erat ultrices rutrum. Nulla quis scelerisque metus. Nam volutpat risus at ultricies luctus. Praesent dignissim massa non neque fermentum, nec pellentesque quam mollis. Donec sit amet tortor sed risus posuere rutrum. Lorem ipsum dolor sit amet, consectetur adipiscing elit. Praesent dictum pharetra purus, quis volutpat orci blandit eget.

					Quisque blandit congue elit, at molestie purus eleifend ac. In hac habitasse platea dictumst. Donec justo odio, cursus vitae nunc cursus, dapibus congue lacus. Mauris interdum hendrerit tempus. Maecenas scelerisque augue in ex convallis, vel faucibus arcu hendrerit. Aenean dictum, ex at volutpat scelerisque, metus neque lacinia quam, ut venenatis erat risus quis ex. Etiam eget gravida dui. Aliquam pharetra consectetur lorem nec bibendum. Maecenas consectetur enim nunc, sodales eleifend sem condimentum et. Fusce vitae ex sapien.

					Integer sit amet ex sed purus convallis aliquam. Vestibulum ut ullamcorper ex. Fusce rhoncus aliquet dui, non accumsan ex semper ac. Donec quis nisi quis ante accumsan interdum. Donec pulvinar tellus turpis, eu mollis eros tincidunt non. Maecenas quis rhoncus lorem. Sed bibendum, ligula a lobortis consequat, mauris lectus pharetra ex, et consequat ligula tellus nec justo. Nunc pulvinar semper maximus. Sed et nisl lacus. Nulla orci ex, rutrum fringilla est id, hendrerit malesuada lacus. Integer a purus ac ante mattis sagittis. Sed sit amet tristique magna, eget pretium justo.

					In laoreet erat non nulla gravida, sed ultricies elit aliquam. Nunc fermentum, eros sed laoreet euismod, dui massa blandit nunc, at gravida enim metus ut nunc. Vestibulum vel leo erat. Aenean nulla orci, dictum ac fermentum ut, semper non purus. Donec commodo orci a nisl posuere, non aliquet metus eleifend. Quisque id nisi ac ipsum suscipit lobortis non vel tortor. Aenean tempor at dolor ut dapibus. Proin ligula nisi, malesuada fringilla eros id, ullamcorper vestibulum eros. Suspendisse aliquet eleifend ipsum, feugiat consectetur mauris efficitur in. Donec semper erat ex, non luctus erat consectetur at. Pellentesque libero nulla, vulputate sed consequat sed, ornare eget urna. Aliquam sit amet magna sed purus pulvinar viverra. Cras id sem diam. Ut lobortis nisl mauris, ac molestie arcu luctus sodales. Mauris hendrerit elementum tortor, a finibus urna condimentum a.

					Morbi diam lacus, iaculis sit amet viverra quis, tincidunt nec arcu. Nam faucibus quis massa non pharetra. Curabitur eu dictum augue. Etiam imperdiet, nisl eget imperdiet posuere, lectus urna porttitor sapien, quis fermentum ex justo suscipit nunc. Maecenas interdum velit tellus, sit amet pellentesque nulla consectetur non. Nulla facilisi. Donec vehicula dolor quis faucibus feugiat. Phasellus imperdiet arcu eu metus aliquet, sed faucibus purus porttitor. Duis imperdiet est eu dictum bibendum.

					Nam vulputate diam risus, a porta augue tempus pellentesque. Maecenas vitae velit magna. Praesent sodales vel ex ut imperdiet. Vestibulum sed nulla vitae massa viverra sollicitudin at eu ante. Nulla et porttitor mauris, nec ultricies quam. Curabitur a viverra sapien, aliquet dapibus quam. Nunc vitae leo vel leo dignissim porttitor non nec eros. Nunc accumsan magna eget lectus vestibulum hendrerit. Vestibulum lacinia arcu ut diam feugiat, vitae fringilla enim scelerisque. Pellentesque hendrerit lorem quam, eu vehicula diam lobortis vitae. Praesent id sodales nisi. Nunc sit amet tempor sem, vel dapibus orci. Sed non erat vel augue pellentesque gravida ut ac felis. Maecenas mauris nibh, tincidunt a maximus et, mollis sit amet justo. Sed quis risus arcu.</p>	
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
	
	
	
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>
	<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
	<script src="js/add-forms.js" language="Javascript" type="text/javascript"></script>
	<script src="js/selectTables.js" language="Javascript" type="text/javascript"></script>
</body>
</html>


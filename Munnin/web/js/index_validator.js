/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


function validar(){
    var user, pass;
    user = $("#email").val();
    pass = $("#pwd").val();
    if(user===""){
        $("#div_mensaje").addClass("alert");
        $("#div_mensaje").addClass("alert-danger");
        $("#mensaje").text("El campo Correo esta vacio");
        return false;
    }else if(pass===""){
        $("#div_mensaje").addClass("alert");
        $("#div_mensaje").addClass("alert-danger");
        $("#mensaje").text("El campo Contraseña esta vacio");
        return false;
    }else{
        $("#div_mensaje").removeClass("alert");
        $("#div_mensaje").removeClass("alert-danger");
        $("#mensaje").text("");
    }
}

function validarPass(){
    var pass1, pass2, pass3;
    pass1 = $("#passwordActual").val();
    pass2 = $("#passwordNew1").val();
    pass3 = $("#passwordNew2").val();
    if(pass1===""){
        $("#div_mensaje").addClass("alert");
        $("#div_mensaje").addClass("alert-danger");
        $("#mensaje").text("El campo Contraseña Actual esta vacio");
        return false;
    }else if(pass2===""){
        $("#div_mensaje").addClass("alert");
        $("#div_mensaje").addClass("alert-danger");
        $("#mensaje").text("El campo Nueva Contraseña esta vacio");
        return false;
    }else if(pass3===""){
        $("#div_mensaje").addClass("alert");
        $("#div_mensaje").addClass("alert-danger");
        $("#mensaje").text("El campo Repite Contraseña esta vacio");
        return false;
    }else if(pass2 !== pass3){
        $("#div_mensaje").removeClass("alert");
        $("#div_mensaje").removeClass("alert-danger");
        $("#mensaje").text("Las contraseñas no coinciden");
        return false;
    }else{
        $("#div_mensaje").removeClass("alert");
        $("#div_mensaje").removeClass("alert-danger");
        $("#mensaje").text("");
    }
}

function seguridad_clave(clave){
   var seguridad = 0;
   if (clave.length!=0){
      if (tiene_numeros(clave) && tiene_letras(clave)){
         seguridad += 30;
      }
      if (tiene_minusculas(clave) && tiene_mayusculas(clave)){
         seguridad += 30;
      }
      if (clave.length >= 4 && clave.length <= 5){
         seguridad += 10;
      }else{
         if (clave.length >= 6 && clave.length <= 8){
            seguridad += 30;
         }else{
            if (clave.length > 8){
               seguridad += 40;
            }
         }
      }
   }
   return seguridad;         
}

function muestra_seguridad_clave(clave,formulario){
   seguridad=seguridad_clave(clave);
   formulario.seguridad.value=seguridad + "%";
}

var numeros="0123456789";
var letras="abcdefghyjklmnñopqrstuvwxyz";
var letras_mayusculas="ABCDEFGHYJKLMNÑOPQRSTUVWXYZ";

function tiene_numeros(texto){
   for(i=0; i<texto.length; i++){
      if (numeros.indexOf(texto.charAt(i),0)!=-1){
         return 1;
      }
   }
   return 0;
} 

function tiene_letras(texto){
   texto = texto.toLowerCase();
   for(i=0; i<texto.length; i++){
      if (letras.indexOf(texto.charAt(i),0)!=-1){
         return 1;
      }
   }
   return 0;
} 

function tiene_minusculas(texto){
   for(i=0; i<texto.length; i++){
      if (letras.indexOf(texto.charAt(i),0)!=-1){
         return 1;
      }
   }
   return 0;
} 

function tiene_mayusculas(texto){
   for(i=0; i<texto.length; i++){
      if (letras_mayusculas.indexOf(texto.charAt(i),0)!=-1){
         return 1;
      }
   }
   return 0;
} 

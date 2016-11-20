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
    }else{
        $("#div_mensaje").removeClass("alert");
        $("#div_mensaje").removeClass("alert-danger");
        $("#mensaje2").text("");
    }
}

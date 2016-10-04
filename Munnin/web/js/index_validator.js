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


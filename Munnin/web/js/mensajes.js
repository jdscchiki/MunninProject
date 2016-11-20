/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


function usuarioNoValido(){
    $("#div_mensaje").addClass("alert");
    $("#div_mensaje").addClass("alert-danger");
    $("#mensaje").text("Usuario o Contraseña no son validos");
}

function contrasenaNoValido(){
    $("#div_mensaje").addClass("alert");
    $("#div_mensaje").addClass("alert-danger");
    $("#mensaje").text("Contraseña Incorrecta");
}

function contrasenaOK(){
    $("#div_mensaje").addClass("alert");
    $("#div_mensaje").addClass("alert-info");
    $("#mensaje").text("Cambio contraseña completado");
}

function contrasenaNoSegura(){
    $("#div_mensaje").addClass("alert");
    $("#div_mensaje").addClass("alert-danger");
    $("#mensaje").text("La contrasela no es Segura");
}
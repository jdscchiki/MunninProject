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
    $("#div_mensaje2").addClass("alert");
    $("#div_mensaje2").addClass("alert-danger");
    $("#mensaje2").text("Contraseña Incorrecta");
}

function contrasenaOK(){
    $("#div_mensaje2").addClass("alert");
    $("#div_mensaje2").addClass("alert-danger");
    $("#mensaje2").text("Contraseña OK");
}

function contrasenaMal(){
    $("#div_mensaje2").addClass("alert");
    $("#div_mensaje2").addClass("alert-danger");
    $("#mensaje2").text("Contraseñas No Coinciden");
}
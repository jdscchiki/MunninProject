/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
function encrypt(){
    var txt_string = document.getElementById('pwd').value;
    document.getElementById('pwd_encrypt').value = SHA512(txt_string);
}


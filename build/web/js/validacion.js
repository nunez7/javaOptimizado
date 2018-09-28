/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

function validacion() {
    var isbn = document.getElementById("isbn");
    var miformulario = document.getElementById("miformulario");
    if (isbn.value === "") {
        alert("Datos no válidos");
        return false;
    } else {
        miformulario.submit();
    }
}




function main() {
    let a = document.querySelector("#radioControl");

    let b = document.querySelector("#radioFree")
    a.addEventListener("change", criarLabel);
    b.addEventListener("change", fechar);

}
function criarLabel() {
//    let c = document.createElement("label");
//    c.for = "preco";
//    c.id = "label";
//    c.textContent = "Tarifa";
//    let d = document.querySelector(".ei");
//    d.appendChild(c);
//
//    let e = document.createElement("input");
//
//    e.type = "text";
//    e.value = " ";
//    e.name = "tarifa"
//    e.id = "tarifado"
//    e.className = "form-control";
//    e.placeholder = "tarifa"
//    d.appendChild(e);
//    let b = document.querySelector("#Total");
//  
//    b.value = " ";
//    b.disabled = false;
}
function fechar() {
//    let b = document.querySelector("#Total");
//    let e = document.querySelector("#val").value;
//    b.value = e;
//    b.disabled = true;
    let d = document.querySelector(".ei");
    let c = document.querySelector("#label");
    let a = document.querySelector("#tarifado");
    a.disabled = true;




}
function SomenteNumero(e){
    var tecla=(window.event)?event.keyCode:e.which;   
    if((tecla>47 && tecla<58)) return true;
    else{
    	if (tecla==8 || tecla==0) return true;
	else  return false;
    }
}
function mascara(t, mask) {
    var i = t.value.length;
    var saida = mask.substring(1, 0);
    var texto = mask.substring(i);
    if (texto.substring(0, 1) != saida) {
        t.value += texto.substring(0, 1);
    }
}



window.addEventListener("load", main);



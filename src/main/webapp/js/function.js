


function main(){
    let a = document.querySelector("#chk");
     let b = document.querySelector("#chk2");

    a.addEventListener("change",fechar);
    b.addEventListener("change",fechar);
  
}
function fechar(){
    let d = document.querySelectorAll("input");
    let e=document.querySelectorAll("select");
    let f=document.querySelectorAll("button");
    let j=[...d,...e,...f];
   for(let i of j) i.disabled = true;

    
    
}


window.addEventListener("load",main); 



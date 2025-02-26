/**
 * 
 */
const login_form = document.getElementById("login_form");
const login_btn = document.getElementById("login_btn");
const id = document.getElementById("id");
const pw = document.getElementById("pw");


login_btn.addEventListener("click", function(){
    if(id.value != "" && pw.value != ""){
        login_form.submit();
    }else{
        alert("ID와 PW를 입력하세요")
        id.focus();
    }
})
/**
 * 
 */
const login_form = document.getElementById("login_form");
const login_btn = document.getElementById("login_btn");
const userName = document.getElementById("userName");
const passWord = document.getElementById("passWord");


login_btn.addEventListener("click", function(){
    if(userName.value != "" && passWord.value != ""){
        login_form.submit();
    }else{
        alert("ID와 PW를 입력하세요")
        id.focus();
    }
})
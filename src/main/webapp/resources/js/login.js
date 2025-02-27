/**
 * 
 */
const login_form = document.getElementById("login_form");
const login_btn = document.getElementById("login_btn");
const userName = document.getElementById("userName");
const passWord = document.getElementById("passWord");


login_btn.addEventListener("click", function(){
    if(userName.getAttribute("value") == "") {
        alert("ID를 입력하세요");
        return;
    }
    login_form.submit();

})
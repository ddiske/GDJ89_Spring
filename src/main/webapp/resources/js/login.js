/**
 * 
 */
 
const btn = document.getElementsByClassName("btn");
const id = document.getElementsByName("userName");
const pw = document.getElementsByName("passWord");


btn[0].addEventListener("click", function(){
    if(id[0].value != "" && pw[0].value != ""){
        console.log(id[0].value);
        console.log(pw[0].value);
        alert("ID : "+id[0].value+
            "PW : "+pw[0].value
        );
    }else{
        alert("다시 입력")

    }
})
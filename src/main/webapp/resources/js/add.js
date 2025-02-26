const add_form = document.getElementById("add_form");
const pdtName = document.getElementById("pdtName");
const add_btn  = document.getElementById("add_btn");

add_btn.addEventListener("click", function(){
    if(pdtName.getAttribute("value") == "") {
        alert("상품명은 필수 입력항목입니다");
        pdtName.focus();
        return;
    }
    add_form.submit();
})
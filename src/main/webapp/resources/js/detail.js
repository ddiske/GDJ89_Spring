const updatebtn = document.getElementById("updatebtn");
const deletebtn = document.getElementById("deletebtn");
const frm = document.getElementById("frm");


// 수정 버튼을 클릭했을 때 콘솔에 출력
// form method의 값을 콘솔에 출력
updatebtn.addEventListener("click", function(){
    console.log("수정");
    console.log(frm.method);// get
    console.log(frm.getAttribute("method"));// null
    frm.action = "./update";
    frm.submit();
})


// 삭제 버튼을 클릭했을 때 콘솔에 출력
// form action의 주소값을 콘솔에 출력
deletebtn.addEventListener("click", function(){
    console.log("삭제");
    console.log(frm.action);// url
    console.log(frm.getAttribute("action"));// uri
    frm.action = "./delete";
    frm.method = "POST";

    if(confirm("정말 삭제하시겠습니까?")) {
        frm.submit();
    }

})
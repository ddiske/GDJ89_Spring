const updatebtn = document.getElementById("updatebtn");
const deletebtn = document.getElementById("deletebtn");
const replybtn = document.getElementById("replybtn");
const frm = document.getElementById("frm");
const frm2 = document.getElementById("frm2");
const addCart = document.getElementById("addCart");
const input = document.getElementById("input");
const reply = document.getElementById("reply");
const contents = document.getElementById("contents")
const commentsListResult = document.getElementById("commentsListResult")
const pages = document.getElementsByClassName("pages");
const deleteComments = document.getElementsByClassName("deleteComments");
const modal_change = document.getElementById("modal_change");

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

try {
    replybtn.addEventListener("click", function(){
        frm.action = "./reply";
        frm.submit();
    })
    
    addCart.addEventListener('click', function(){
        // console.log(input.value);
        // let s = `hello ${input.value}`;
        // console.log(s);
        fetch(`../users/addCart?productNum=${input.value}`)
        .then(res => res.text())
        .then(res => {
            if(res.trim()==1) {
                let flag = confirm("장바구니로 이동하시겠습니까?");
                if(flag == true) {
                    location.href = "../users/carts"
                }
            }else{
                alert("실패")
            }
        })
    })
} catch (error) {
    
}

reply.addEventListener("click", ()=>{
    // let params = new URLSearchParams();
    // params.append("productNum", input.value)
    // params.append("boardContents", contents.value)
    
    addComments();
    
    contents.value = "";
})

getList(1)

function getList(page){
    let url = new URL("listComments", location)
    url.searchParams.append("productNum", input.value)
    url.searchParams.append("page", page)

    fetch(url)
    .then(r => r.text())
    .then(r => {
        commentsListResult.innerHTML = r;
    })
    .catch(e => alert("Error"))
}

function addComments(){
    let params = new FormData();
    params.append("productNum", input.value)
    params.append("boardContents", contents.value)

    fetch("./addComments", {
        method : "POST",
        // headers : {
        //     'Content-type' : 'application/x-www-form-urlencoded; charset=UTF-8'
        // },
        body : params
    })
    .then(r=>r.text())
    .then(r=> {
        // getList()
        if(r.trim()*1>0){
            alert("등록 성공");
        }else{
            alert("등록 실패")
        }
    })
    .catch(e=>{
        alert("Error");
    })
    getList(1);
}

let num = 0;
commentsListResult.addEventListener("click", (e)=>{
    if(e.target.classList.contains('pages')){
        getList(e.target.getAttribute("data-page-num"))
    }else if(e.target.classList.contains('deleteComments')){
        deletecmnt(e.target.value);
        getList(1);
    }else if(e.target.classList.contains('updateComments')){
        // let boardContents = prompt("수정할 댓글 내용 입력");
        // updatecmnt(e.target.value, boardContents);
        let c = e.target.parentElement.previousElementSibling.previousElementSibling.innerHTML;
        document.getElementById("message-text").value = c;
        num = e.target.value;
        
    }
})

modal_change.addEventListener("click", ()=>{
    let params = new FormData();
    params.append("boardNum", num)
    params.append("boardContents", document.getElementById("message-text").value)
    
    fetch("./updateComments", {
        method : "POST",
        body : params
    })
    .then(r=>r.text())
    .then(r=> {
        if(r.trim()*1>0){
            alert("수정 완료")
        }else{
            alert("실패")
        }
    })
    .catch(e=>alert("Error"))
    getList(1);
})

function deletecmnt(boardNum){
    if(confirm("정말 삭제하시겠습니까?")) {
        let params = new FormData();
        params.append("boardNum", boardNum)
    
        fetch("./deleteComments", {
            method : "POST",
            body : params
        })
        .then(r=>r.text())
        .then(r=> {
            if(r.trim()*1>0){
                alert("삭제 완료")
            }else{
                alert("실패")
            }
        })
        .catch(e=>alert("Error"))
    }

}

function updatecmnt(boardNum, boardContents){
    let params = new FormData();
    params.append("boardNum", boardNum)
    params.append("boardContents", boardContents)

    fetch("./updateComments", {
        method : "POST",
        body : params
    })
    .then(r=>r.text())
    .then(r=> {
        if(r.trim()*1>0){
            alert("수정 완료")
        }else{
            alert("실패")
        }
    })
    .catch(e=>alert("Error"))

    getList(1);
}


// Modal
// const myModal = document.getElementById('myModal')
// const myInput = document.getElementById('myInput')

// myModal.addEventListener('shown.bs.modal', () => {
//   myInput.focus()
// })
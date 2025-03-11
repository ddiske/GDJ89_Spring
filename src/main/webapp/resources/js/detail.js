const updatebtn = document.getElementById("updatebtn");
const deletebtn = document.getElementById("deletebtn");
const replybtn = document.getElementById("replybtn");
const frm = document.getElementById("frm");
const frm2 = document.getElementById("frm2");
const addCart = document.getElementById("addCart");
const input = document.getElementById("input");
const reply = document.getElementById("reply");
const contents = document.getElementById("contents")


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
})

getList()

function getList(){
    let url = new URL("listComments", location)
    url.searchParams.append("productNum", input.value)

    fetch(url)
}
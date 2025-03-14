const checkAll = document.getElementById('checkAll');
const checks = document.getElementsByClassName('checks');
const cart_add = document.getElementById('cart_add');
const cart_delete = document.getElementById('cart_delete');

checkAll.addEventListener('click', ()=>{
    for(let check of checks) {
        check.checked = checkAll.checked;
    }
})

for(let check of checks) {
    check.addEventListener('click', ()=>{
        let r = true;
        for(let c of checks) {
            if(!c.checked) {
                r = false;
            }
        }

        checkAll.checked = r;
    })
}

cart_add.addEventListener('click', ()=>{
    let params = new URLSearchParams();

    for(let check of checks) {
        if(check.checked){
            params.append("productNum", check.value);
        }
    }

    // let url = "../accounts/add"+params.toString();
    // let url = `../accounts/add?${params.toString()}`;

    // enctype = multipart/form-data
    fetch("../accounts/add", {
        method : "POST",
        headers : {
            'Content-type' : 'application/x-www-form-urlencoded; charset=UTF-8'
        },
        body : params
    })
    // promise
    .then(res => res.text())
    .then(res => {
        console.log(res);
        if(res.trim()>0) {
            alert(res+'개의 상품 가입 성공')
            location.reload();
        }
    })
    .catch(e=>{
        alert("관리자에게 문의")
    })
})

cart_delete.addEventListener('click', ()=>{
    let url = new URL("cartDelete", window.location);


    for(let check of checks) {
        if(check.checked) {
            url.searchParams.append("productNum", check.value);
        }
    }

    fetch(url)
    .then(res => res.text())
    .then(res =>{
        alert('삭제완료')
        location.reload();
    }).catch(e=>{
        alert('실패')
    })
})
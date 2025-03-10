function fileDelete () {
    const file_delete = document.getElementsByClassName("file_delete");
    
    for(let fd of file_delete) {
        fd.addEventListener("click", ()=>{
            console.log("delete");
            if(confirm("정말 삭제하시겠습니까?")) {
                // DB에서 삭제, HDD에서 삭제
                let num = fd.getAttribute("data-file-data")
                let kind = fd.getAttribute("data-kind");
                console.log(num);
                console.log(kind);
    
                // 동기식 비동기식
                // 'post'
                let url = `/${kind}/fileDelete`;
                url = './fileDelete';
                fetch(url, {
                    method: 'POST',
                    headers: {
                        "Content-type":"application/x-www-form-urlencoded; charset=UTF-8"
                    },
                    body: `fileNum=${num}`// 'fileNum='+num
                })
                .then(r => r.text())
                .then(r => {
                    if(r.trim()=="1") {
                        // 1. 파일갯수 수정
                        // count--;
                        // 2. Element 삭제
                        fd.parentElement.remove();
                    }else{
                        alert("실패");
                    }
                })
                .catch(e => {
                    alert("실패");
                })
            }
        })
    }
}
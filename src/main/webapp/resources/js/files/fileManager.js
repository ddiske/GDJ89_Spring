// import fileDelete from "/resources/js/files/fileDelete.js";
const files = document.getElementById("files");
const add_file = document.getElementById("add_file");
const del = document.getElementsByClassName('del');
let count = files.getAttribute("data-files-size");
const file_delete = document.getElementsByClassName("file_delete");
    
    for(let fd of file_delete) {
        fd.addEventListener("click", ()=>{
            console.log("delete");
            if(confirm("정말 삭제하시겠습니까?")) {
                // DB에서 삭제, HDD에서 삭제
                let num = fd.getAttribute("data-file-num")
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
                        count--;
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

files.addEventListener('click', function(e){
    if(e.target.classList.contains('del')){
        e.target.parentElement.remove();
        count--;
    }
})

add_file.addEventListener("click", function(){
    if(count > 4) {
        alert("파일 첨부는 5개 까지만 가능함");
        return;
    }
    
    let div = document.createElement('div');
    let label = document.createElement('label');
    let input = document.createElement('input');
    
    div.classList.add('mb-3', 'input-group');
    label.classList.add('form-label');
    input.classList.add('form-control');
    
    label.innerHTML = "<span class='input-group-text'>첨부파일</span>";
    let type = document.createAttribute('type');
    type.value = 'file';
    let name = document.createAttribute('name');
    name.value = 'attaches'
    input.setAttributeNode(type);
    input.setAttributeNode(name);
    
    files.append(div);
    div.append(label);
    div.append(input);
    
    // button 추가
    let child = document.createElement('button');
    child.type = 'button';
    child.innerHTML = 'X';
    child.classList.add('btn', 'btn-outline-danger', 'del');
    div.append(child);
    
    count++;
    
})

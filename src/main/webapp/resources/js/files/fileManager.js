const files = document.getElementById("files");
const add_file = document.getElementById("add_file");
const del = document.getElementsByClassName('del');
let count = files.getAttribute("data-files-size");

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

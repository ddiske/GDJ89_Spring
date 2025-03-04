const files = document.getElementById("files");
const add_file = document.getElementById("add_file");

add_file.addEventListener("click", function(){
    let div = document.createElement('div');
    let label = document.createElement('label');
    let input = document.createElement('input');

    div.classList.add('mb-3');
    label.classList.add('form-label');
    input.classList.add('form-control');

    label.innerHTML = "첨부파일";
    let type = document.createAttribute('type');
    type.value = 'file';
    let name = document.createAttribute('name');
    name.value = 'attaches'

    files.append(div);
    div.append(label);
    div.append(input);

})
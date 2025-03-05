const un = document.getElementById("un");
const userNameResult = document.getElementById("userNameResult");

un.addEventListener('change',function(){
    console.log(un.value);

    fetch("./check?userName="+un.value)
    .then(res => res.text())
    .then(res =>{
        if(res.trim()=='0'){
            // 중복o 가입x
            userNameResult.innerHTML='중복된 ID입니다'
        }else{
            // 중복x 가입o
            userNameResult.innerHTML='사용 가능한 ID입니다'
        }
    })
})
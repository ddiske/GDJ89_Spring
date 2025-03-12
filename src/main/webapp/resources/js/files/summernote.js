$('#detail').summernote({
    height: 300,
    callbacks:{
        onImageUpload: function(files){
            console.log(files[0]); // <input type="file">
            let f = new FormData();
            f.append("uploadFile", files[0]);
            fetch('./detailFiles', {
                method : "POST",
                body : f
            })
        }
    }
})
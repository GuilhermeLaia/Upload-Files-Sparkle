$(function () {
    $('#fileupload').fileupload({
    	maxChunkSize: 1000000,//1MB
        dataType: 'json',
        autoUpload: true,
        done: function (e, data) {
            $("tr:has(td)").remove();
            $.each(data.result.files, function (index, file) {
 
                $("#uploaded-files").append(
                        $('<tr/>')
                        .append($('<td/>').text(file.fileName))
                        .append($('<td/>').text(file.sizeBlocksFile))
                        .append($('<td/>').text(file.fileType))
                        .append($('<td/>').text(file.filePart+"/"+((file.filePartTotal == null) ? file.filePart : file.filePartTotal)))
                        .append($('<td/>').html("<a href='http://localhost:8080/api/downloadFile/"+index+"'>Click</a>"))
                        )
            }); 
        },
        chunksend: function (e, data) {
            console.log(data.result);
          cleanMessage();
          $('<p style="color: green;">Upload in progress...<i class="elusive-remove" style="padding-left:10px;"/></p>').appendTo(('#div_message'));
          if((data.uploadedBytes + data.chunkSize ) == data.total){
            cleanMessage();
            $('<p style="color: blue;">Uploaded files successfully!<i class="elusive-remove" style="padding-left:10px;"/></p>').appendTo(('#div_message'));
          }
        },
        fail: function (e, data) {
            cleanMessage();
            $('<p style="color: red;">Upload file error:<i class="elusive-remove" style="padding-left:10px;"/></p>').appendTo(('#div_message'));
        },
        progressall: function (e, data) {

            var progress = parseInt(data.loaded / data.total * 100, 10);
            $('#progress .bar').css(
                'width',
                progress + '%'
            );
        },
 
        dropZone: $('#dropzone')
    });

    $.ajax({
    type: "GET",
    url: "http://localhost:8080/api/loadFiles",
    success: function (data) {
        $("tr:has(td)").remove();
            $.each(data, function (index, file) {
 
                $("#uploaded-files").append(
                        $('<tr/>')
                        .append($('<td/>').text(file.fileName))
                        .append($('<td/>').text(file.sizeBlocksFile))
                        .append($('<td/>').text(file.fileType))
                        .append($('<td/>').text(file.filePart+"/"+((file.filePartTotal == null) ? file.filePart : file.filePartTotal)))
                        .append($('<td/>').html("<a href='http://localhost:8080/api/downloadFile/"+index+"'>Click</a>"))
                        )
            }); 
        }
    });
    function cleanMessage(){
        $('#div_message').length != null ? $('#div_message').empty() : null;
    }
});
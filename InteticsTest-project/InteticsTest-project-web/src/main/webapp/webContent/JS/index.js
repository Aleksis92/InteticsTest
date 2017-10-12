$(document).ready(function(){
    $.get('api/Images', function(data){
        $.each(data, function(index, data){
            var img = $("<img>", {
                src: 'data:image/png;base64, ' + data.image,
                class: 'img-fluid card-img'
            });
            var col = $('<div>', {
                class: 'col-sm-6 col-md-4 col-lg-3 card div-images-size',
            }).appendTo('#row');
            col.append(img);
        });
    });
});

$(document).ready(function(){
    $('#new-image').click(function() {
        $('#new-image-modal').modal('show');
    });
});

$(document).ready(function(){
var isAdvancedUpload = function() {
    var div = document.createElement('div');
    return (('draggable' in div) || ('ondragstart' in div && 'ondrop' in div)) && 'FormData' in window && 'FileReader' in window;
}();


var $form = $('.box');
var $div = $('.box__input');

if (isAdvancedUpload) {
    $div.addClass('has-advanced-upload');
}

    if (isAdvancedUpload) {

        var droppedFiles = false;

        $div.on('drag dragstart dragend dragover dragenter dragleave drop', function(e) {
            e.preventDefault();
            e.stopPropagation();
        })
         .on('dragover dragenter', function() {
                $div.addClass('is-dragover');
         })
         .on('dragleave dragend drop', function() {
                $div.removeClass('is-dragover');
         })
         .on('drop', function(e) {

                droppedFiles = e.originalEvent.dataTransfer.files[0];
         });
    }

    $form.on('submit', function(e) {
        if ($div.hasClass('is-uploading')) return false;
        $div.addClass('is-uploading').removeClass('is-error');

            if (isAdvancedUpload) {
                e.preventDefault();

                var ajaxData = new FormData($form.get(0));

                if (droppedFiles) {
                        ajaxData.delete("image");
                        ajaxData.append("image", droppedFiles );
                }
                $.ajax({
                    url: $form.attr('action'),
                    type: $form.attr('method'),
                    data: ajaxData,
                    dataType: 'json',
                    cache: false,
                    contentType: false,
                    processData: false,
                    complete: function() {
                        $form.removeClass('is-uploading');
                    },
                    success: function(data) {
                        var img = $("<img>", {
                        src: 'data:image/png;base64, ' + data.image,
                        class: 'img-fluid card-img'
                    });
                        var col = $('<div>', {
                            class: 'col-sm-6 col-md-4 col-lg-3 card div-images-size',
                        }).appendTo('#row');
                        col.append(img);
                    }
                });
        }
    });
});

/*droppedFiles = e.originalEvent.dataTransfer.files[0];
xhr = new XMLHttpRequest();
var form = document.getElementById("images-form"),
    fd = new FormData(form);
fd.append("image", droppedFiles);
xhr.open("POST", "/checkImageForm.html");
xhr.send(fd); */



var main={
    init : function() { // var init = function() {...} 로 선언하지 않고 var main 안에 index라는 변수의 속성으로 function을 만듬
        // index객체 안에서만 function이 유효하게 만들어 다른 JS와 겹치지 않게 함.
        var _this = this;
        $('#btn-save').on('click', function () {
            _this.save();
        });

        $('#btn-update').on('click', function(){
            _this.update();
        });

        $('#btn-delete').on('click', function(){
            _this.delete();
        })
    },
    save : function (){
        var data = {
            title: $('#title').val(),
            author: $('#author').val(),
            content: $('#content').val()
        };

        $.ajax({
            type: 'POST',
            url: '/api/v1/posts',
            dataType: 'json',
            contentType:'application/json; charset=utf-8',
            data: JSON.stringify(data)
        }).done(function() {
            alert('글이 등록되었습니다.');
            window.location.href = '/'; //글 등록을 성공하면 메인페이지(/)로 이동함.
        }).fail(function (error){
            alert(JSON.stringify(error));
        });
    },
    update : function (){
        var data = {
            title: $('#title').val(),
            content: $('#content').val()
        };

        var id = $('#id').val()

        $.ajax({
            type: 'PUT',
            url: '/api/v1/posts/'+id,
            dataType: 'json',
            contentType: 'application/json; charset=utf-8',
            data: JSON.stringify(data)
        }).done(function(){
            alert('글이 수정되었습니다.');
            window.location.href = '/';
        }).fail(function(error){
            alert(JSON.stringify(error));
        });
    },
    delete : function(){
        var id = $('#id').val()

        $.ajax({
            type: 'DELETE',
            url: '/api/v1/posts/'+id,
            dataType: 'json', //애가 json이라서 PostsAPIController의 delete() 메소드의 return type이 void면 안되는거다.
            contentType: 'application/json; charset=utf-8'
        }).done(function(){
            alert('글이 삭제되었습니다.');
            window.location.href = '/';
        }).fail(function(error){
            alert(JSON.stringify(error));
        });
    }
};

main.init();
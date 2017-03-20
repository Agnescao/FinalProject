

window.onload = function () {
    var list = document.getElementById('list');
    var boxs = list.children;
    var timer;

    //格式化日期
    function formateDate(date) {
        var y = date.getFullYear();
        var m = date.getMonth() + 1;
        var d = date.getDate();
        var h = date.getHours();
        var mi = date.getMinutes();
        m = m > 9 ? m : '0' + m;
        return y + '-' + m + '-' + d + ' ' + h + ':' + mi;
    }


    function removeNode(node) {
        node.parentNode.removeChild(node);
    }

   
   
   

   
   
    function operate(el) {
        var commentBox = el.parentNode.parentNode.parentNode;
        var box = commentBox.parentNode.parentNode.parentNode;
        var txt = el.innerHTML;
        var user = commentBox.getElementsByClassName('user')[0].innerHTML;
        var textarea = box.getElementsByClassName('comment')[0];
        if (txt == 'reply') {
            textarea.focus();
            textarea.value = 'reply' + user;
            textarea.onkeyup();
        }
        else {
            removeNode(commentBox);
        }
    }

   
    for (var i = 0; i < boxs.length; i++) {

        //点击
        boxs[i].onclick = function (e) {
            e = e || window.event;
            var el = e.srcElement;
            switch (el.className) {

                //关闭分享
                case 'close':
                    removeNode(el.parentNode);
                    break;

               
                case 'btn':
                    reply(el.parentNode.parentNode.parentNode, el);
                    break;

                //回复按钮灰
                case 'btn btn-off':
                    clearTimeout(timer);
                    break;

               
            }
        }

        //评论
        var textArea = boxs[i].getElementsByClassName('comment')[0];

        //评论获取焦点
        textArea.onfocus = function () {
            this.parentNode.className = 'text-box text-box-on';
            this.value = this.value == 'comment' ? '' : this.value;
            this.onkeyup();
        }

        //评论失去焦点
        textArea.onblur = function () {
            var me = this;
            var val = me.value;
            if (val == '') {
                timer = setTimeout(function () {
                    me.value = 'comment';
                    me.parentNode.className = 'text-box';
                }, 200);
            }
        }

        //评论按键事件
        textArea.onkeyup = function () {
            var val = this.value;
            var len = val.length;
            var els = this.parentNode.children;
            var btn = els[1];
            var word = els[2];
            if (len <=0 || len > 140) {
                btn.className = 'btn btn-off';
            }
            else {
                btn.className = 'btn';
            }
            word.innerHTML = len + '/140';
        }

    }
}


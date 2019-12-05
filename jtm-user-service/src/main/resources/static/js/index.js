function send() {
    $.ajax({
        type: "GET",
        dataType:"json",
        url: "/user/send",
        data: $("#fm").serialize(),
        success: function (result) {
            console.log(result);//打印服务端返回的数据(调试用)
            if (result.resultCode == 200) {
                alert("SUCCESS");
            }
        },
        error: function () {
            alert("发送失败！");
        }
    })
    // fm.action="/user/send";
    // fm.submit();
}

function setName() {
    var name = document.getElementById("name").value;
    if(name == null || name == ""){
        alert("请输入您的名称！");
        return;
    }

    $.ajax({
        type: "GET",
        dataType:"text",
        url: "/user/login",
        data: {
            "name": $("#name").val()
        },
        success: function (result) {
            document.getElementById("name1").value=name;
            document.getElementById("setNameDiv").style.display='none';
            document.getElementById("messageDiv").style.display='';
        },
        error: function () {
            alert("发送失败！");
        }
    })
}
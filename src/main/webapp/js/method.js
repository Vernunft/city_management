/**
 * Created by Administrator on 2016/2/29.
 */
$(document).ready(function(){
    //var x={"troubleId":"6L"};
    $.ajax({
        type:"post",
        datatype:"json",
        //data:JSON.stringify(x),
        url:"http://192.168.199.156:8080/demo/createJSONURL.do",
        contentType:"application/json",
        success:function(){

        }
    })
})

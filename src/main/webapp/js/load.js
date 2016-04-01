/**
 * Created by Administrator on 2016/2/17.
 */
function check(str)
{
    var x = document.getElementById(str);
    var y = document.getElementById(str+"Check");
//alert("check!");
    if(str=="username")
    {
        if(x.value=="")
            y.hidden = false;
        else
            y.hidden = true;
    }
    else if(str=="password")
    {
        if(isNaN(x.value) || x.value < 17)
            y.hidden = false;
        else
            y.hidden = true;
    }

//    else if(str=="password")
//    {
//        x = x.value.length;
//        if(x < 8)
//        {
//            y.hidden = false;
////alert("check!");
//        }
//        else
//            y.hidden = true;
//    }
//    else if(str=="cpassword")
//    {
//        var z = document.getElementById("password").value;
//        x = x.value;
//        if(x != z)
//            y.hidden = false;
//        else
//            y.hidden = true;
//    }
//    else if(str=="email")
//    {
//        x = x.value.indexOf("@")
//        if(x == -1)
//            y.hidden = false;
//        else
//            y.hidden = true;
//    }
//    return y.hidden;
}

function validate()
{
    var arr=["username", "password"];
    var i = 0;
    submitOK = true;
    while(i <= 1)
    {
        if(!check(arr[i]))
        {
            alert(arr[i]+" wrong!");
            submitOK = false;
            break;
        }
        i++;
    }
    if(submitOK)
    {
        alert("提交成功！");
        return true;
    }
    else
    {
        alert("提交失败");
        return false;
    }
}

function load_greeting()
{
//alert("visit \n");
}
<%@ page language="java" import="java.util.*" pageEncoding="utf-8" %>
 <!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
    <head>
        <script src="jquery-1.3.2.js">
        </script>
        <script src="json2.js">
        </script>
        <script>
            function userinfo(username, password){
                this.username = username;
                this.password = password;
            }
            
            function sendAjax(){
                var jsonStringRef = JSON.stringify(userinfoRef);
                
                $.ajax({
                    type: "POST",
                    data: jsonStringRef,
                    url: "createJSONURL.spring?t=" + new Date().getTime(),
                    contentType: "application/json",
                    dataType: "json",
                    success: function(data, type){
                        alert(data.username + "  " + data.password);
                        var aihaoArray = data.studyList;
                        for (var i = 0; i < aihaoArray.length; i++) {
                            alert(aihaoArray[i]);
                        }
                    }
                });
            }
        </script>
    </head>
    <body>
        <input type="button" onclick="sendAjax()"/>
    </body>
</html>
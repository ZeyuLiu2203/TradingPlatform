<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<style type="text/css">
    body {
    background-image: url("img/login/loginBackground.jpg");;
    background-size: 100%;
    background-repeat: no-repeat;
}
 
#login_frame {
    width: 400px;
    height: 260px;
    padding: 13px;
 
    position: absolute;
    left: 50%;
    top: 50%;
    margin-left: -200px;
    margin-top: -200px;
 
    background-color: rgba(240, 255, 255, 0.5);
 
    border-radius: 10px;
    text-align: center;
}
 
form p > * {
    display: inline-block;
    vertical-align: middle;
}
 
#image_logo {
    margin-top: 22px;
}
 
.label_input {
    font-size: 14px;
    font-family:serif;
 
    width: 65px;
    height: 28px;
    line-height: 28px;
    text-align: center;
 
    color: white;
    background-color: #3CD8FF;
    border-top-left-radius: 5px;
    border-bottom-left-radius: 5px;
    
    border: solid 2px black;
}
 
.text_field {
    width: 278px;
    height: 28px;
    border-top-right-radius: 5px;
    border-bottom-right-radius: 5px;
    border: solid 2px black;
}
 
#btn_login {
    font-size: 14px;
    font-family: serif;
 
    width: 120px;
    height: 28px;
    line-height: 28px;
    text-align: center;
 
    color: white;
    background-color: #3BD9FF;
    border-radius: 6px;
    border: 0;
 
    float: left;
}
 
#forget_pwd {
    font-size: 12px;
    color: blue;
    text-decoration: none;
    position: relative;
    float: right;
    top: 5px;
 
}
 

 
#login_control {
    padding: 0 28px;
}
    </style>

<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Welcome to FDM</title>
</head>
<body>
<div id="login_frame" background-image=url(https://placeimg.com/640/480/nature)>
 
    <p id="image_logo"><img src="img/login/welcome.png"></p>
 
    <form action="login" method="get">
        <p><label class="label_input">UserID</label><input type="text" id="username" class="text_field" name="username" placeholder="Username"/></p>
        <p><label class="label_input">Password</label><input type="password" id="password" class="text_field" placeholder="Password" name="password"/></p>
 
        <div id="login_control">
            <input type="submit" id="btn_login" value="submit"/>
            <a id="forget_pwd" href="register.jsp">register</a>
            ${error}
        </div>
    </form>
</div>
 
</body>
</html>
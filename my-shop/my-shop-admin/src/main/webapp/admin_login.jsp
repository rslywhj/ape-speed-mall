<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<%--
    admin登录页面
--%>

<head>
    <meta charset="UTF-8">
    <base href="<%=request.getContextPath()%>/"/>
    <title>Ape-Speed 管理后台登录</title>
    <script src="./static/js/jquery-3.3.1.js"></script>
    <script src="./static/js/jquery.vide.js"></script>
    <script type="text/javascript">
        function changeImg() {
            document.getElementById("img").src="validateCode?n="+Math.random();
        }
    </script>
    <style type="text/css">
        body{
            margin: 0;
            padding: 0;
            width: 100%;
            height: 100vh;
            background-color: #000000;
            font-family: sans-serif;
        }
        .login-form{
            position: absolute;
            top: 50%;
            left: 50%;
            transform: translate(-50%,-50%);
            width: 300px;
            padding: 60px 40px;
            background-color: rgba(255,255,255,.8);
            box-shadow: 0 15px 20px rgba(0,0,0,.2);
        }
        .login-form h2{
            margin: 0 0 40px;
            padding: 0;
            text-align: center;
        }
        .login-form .form-input{
            position: relative;
            margin: 20px 0;
        }
        .login-form .form-input input{
            outline: none;
            height: 40px;
            padding: 10px;
            box-sizing: border-box;
            width: 100%;
            border:1px solid rgba(0,0,0,.5);
            background: transparent;
            font-size: 18px;
        }
        .login-form .form-input2{
            position: relative;
        }
        .login-form .form-input2 input{
            height: 40px;
            padding: 10px;
            box-sizing: border-box;
            width: 50%;
            border:1px solid rgba(0,0,0,.5);
            background: transparent;
            font-size: 18px;
        }
        .login-form .form-input2 img{
            position: relative;
            height: 40px;
            width: 40%;
            top: 13px;
        }
        .login-form .form-input input[type='submit']{
            background-color: #e91e63;
            color: #fff;
            border: none;
            cursor: pointer;
        }
        .login-form .form-input input[type='submit']:hover{
            background-color: #0090ff;
        }
        .login-form a{
            display: block;
            margin-top: 30px;
            color:#000;
            font-weight: 700;
        }
    </style>
</head>

<body data-vide-bg='./static/video/oceans.mp4'>
<div class="login-form">
    <h2>Ape-Speed </br>管理后台登录</h2>
    <form id="loginForm" action="adminLoginServlet" method="post">
    <div class="form-input">
        <input type="text" id="username" name='username' placeholder="用户名">
    </div>
    <div class="form-input">
        <input type="password" id="password" name='password' placeholder="密码">
    </div>
        <div class="form-input2">
            <input type="text" id="validate" name="validate" placeholder="请输入验证码">
            <img id="img" src="validateCode"  onclick="changeImg()"/>
        </div>
    <p id="msg" style="font-size: 2px; color: red; margin-left: 70px;"></p>
       <%-- <p>${errorMsg}</p>--%>
    <div class="form-input">
        <input type="submit" id="loginBtn" value='登录'>
    </div>
    </form>
</div>
<script type="text/javascript">
    //取出传回来的参数error并与yes比较
    var errori ='<%=request.getParameter("error")%>';
    var codeErrori ='<%=request.getParameter("codeError")%>';
    if(codeErrori=='yes'){
        alert("验证码错误!");
    }
    if(errori=='yes'){
        alert("登录失败!");
    }
    $("#loginBtn").click(function () {
        var username = $("#username").val();
        var password = $("#password").val();
        if (isEmpty(username)){
            //如果姓名为空，提示用户（标签赋值），并且return   html()
            $("#msg").html("用户账号不可为空!");
            return;
        }

        if (isEmpty(password)){
            //如果姓名为空，提示用户（标签赋值），并且return   html()
            $("#msg").html("用户密码不可为空!");
            return;
        }
        //手动提交表单
        $("#loginForm").submit();
    });

    /**
     * 判断字符串是否为空，
     *          如果为空返回true
     *          如果不为空返回false
     * @param str
     * @returns {boolean}
     */
    function isEmpty(str) {
        if (str==null || str.trim()==""){
            return true;
        }
        return false;
    }

</script>
</body>
</html>
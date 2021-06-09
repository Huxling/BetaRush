<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">	
<html>
<head>
<meta charset="utf-8">
<meta name="renderer" content="webkit|ie-comp|ie-stand">
<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
<meta name="viewport" content="width=device-width,initial-scale=1,minimum-scale=1.0,maximum-scale=1.0,user-scalable=no" />
<meta http-equiv="Cache-Control" content="no-siteapp" />
<link rel="shortcut icon" href="favicon.ico"/>
<link rel="bookmark" href="favicon.ico"/>
<link href="h-ui/css/H-ui.min.css" rel="stylesheet" type="text/css" />
<link href="h-ui/css/H-ui.login.css" rel="stylesheet" type="text/css" />
<link href="h-ui/lib/icheck/icheck.css" rel="stylesheet" type="text/css" />
<link href="h-ui/lib/Hui-iconfont/1.0.1/iconfont.css" rel="stylesheet" type="text/css" />

<link rel="stylesheet" type="text/css" href="easyui/themes/default/easyui.css">
<link rel="stylesheet" type="text/css" href="easyui/themes/icon.css">

<script type="text/javascript" src="easyui/jquery.min.js"></script> 
<script type="text/javascript" src="h-ui/js/H-ui.js"></script> 
<script type="text/javascript" src="h-ui/lib/icheck/jquery.icheck.min.js"></script> 

<script type="text/javascript" src="easyui/jquery.easyui.min.js"></script>

<title>登录|至诚微座</title>
<meta name="keywords" content="User">
</head>
<body>
<% Integer hitsCount = (Integer)application.getAttribute("hitCounter");
     if( hitsCount ==null || hitsCount == 0 ){
        /* 第一次访问 */
        
        hitsCount = 1;
     }else{
        /* 返回访问值 */
       
        hitsCount += 1;
     }
     application.setAttribute("hitCounter", hitsCount);
%>
 
<p></p>
<div class="header" style="padding: 0;">
	<h2 style="color: white; width: 400px; height: 60px; line-height: 60px; margin: 0 0 0 30px; padding: 0;">跳转页面，页面访问量为: <%= hitsCount%></h2>
</div>
<div class="loginWraper">
  <div id="loginform" class="loginBox">
    
        
      
      <div class="mt-20 skin-minimal" style="text-align: center;">
      
		<input type="button" value="学生   " onclick="javascrtpt:window.location.href='http://570decba.nat123.net/WorkTest/'" />
		<input type="button" value="教师   " onclick="javascrtpt:window.location.href =' http://570decba.nat123.net/StudentTest/view/index.html'"; />
		<input type="button" value="管理员   " onclick="javascrtpt:window.location.href='http://570decba.nat123.net/WorkTest/SystemServlet?method=toAdminView'" />
	</div>
       
      <div class="row">
        <div class="formControls col-8 col-offset-3">
          
        </div>
      </div>
    </form>
  </div>
</div>
<div class="footer">Team &nbsp;  @ SKJOR </div>


</body>
</html>
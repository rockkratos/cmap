<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>Canditu Admin ${errorCode}</title>
<link type="text/css" rel="stylesheet" rev="stylesheet" media="screen" href="${rc.contextPath}/css/admin-error.css" />
<script type="text/javascript" language="javascript" src="${rc.contextPath}/js/unitpngfix.js"></script>
</head>

<body>

<div class="error-box">
	<img src="${rc.contextPath}/imgs/admin/errors/${errorCode}.png" />
    <a href="javascript:history.go(-1);">&lt;&lt; 返回上一页</a>
    <a href="${rc.contextPath}/admin/login">&lt;&lt; 返回首页</a>
</div>

</body>
</html>
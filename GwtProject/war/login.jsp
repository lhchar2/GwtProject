<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%
String loginId = request.getParameter("loginId");
if (loginId == null) loginId = "";
//session.removeAttribute("SVC_SSO_LAST_CONTACT")
session.setAttribute("SVC_SSO_USERID", loginId);
session.setAttribute("SVC_SSO_USIHASH", "ABCD1234");
session.setAttribute("SVC_WEBSESSION", null);

String gwtModule = request.getParameter("gwt.codesvr");
%>    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script type="text/javascript" >
function openSVC() {
	// var aaa = window.open("../home.html", "", "menubar=no,width=1024,height=768");
	// var aaa = window.open("", "SVC", "menubar=no,width=1024,height=768");
	var aaa = window.open("../GwtProject.html", "SVC", "menubar=no,width=1024,height=768,resizable=yes");

	//response.sendRedirect("GwtProject.html");
	//document.form1.submit();
	//aaa.focus();
}
</script>
</head>
<body>
<form name="form1" action="login2.jsp" target="SVC">
	UserId: <input name="loginId" value="<%=loginId%>" />
	<input name="gwt.codesvr" type="HIDDEN" value="<% if (gwtModule != null) { %><%=gwtModule%><% }%>" />
	<button onClick="javascript:openSVC();">Login</button>
</form>
<button onClick="javascript:openSVC();">Login</button>
<a href="logout.jsp">Logout</a>	
</body>
</html>

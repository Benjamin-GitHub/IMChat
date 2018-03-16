<%@ page contentType="application/json;charset=UTF-8" language="java"%>
<% 
response.setStatus(500);
%>
<%=request.getAttribute("msg").toString()
%>
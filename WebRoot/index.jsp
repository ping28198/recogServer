<%@ page 
	language="java" 
	import="java.util.*,java.text.*" 
	pageEncoding="utf-8"
	contentType="text/html; charset=utf-8"
	
	%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <title>查询结果</title>
  </head>
  <body>
  	<h1>${rcontent.name}</h1>
   	<c:if test="${rcontent.videoPath.isEmpty() == false}">
		<video src="resource/video/${rcontent.videoPath}" controls="controls" autoplay="autoplay">
		</video>
	</c:if>
	<c:if test="${rcontent.modelPath.isEmpty() == false}">
		<div class = showModel>显示模型</div>
		<c:if test="${rcontent.audioPath.isEmpty() == false}">
			<audio src="resource/audio/${rcontent.audioPath}" controls="controls" autoplay="autoplay">
			</audio>
		</c:if>
	</c:if>
	<c:if test="${rcontent.picPath.isEmpty() == false}">
		<img src="resource/img/${rcontent.picPath}" width = "100%" height = "500">
	</c:if>
	<c:if test="${(rcontent.modelPath.isEmpty() == true) && (rcontent.audioPath.isEmpty() == false)}">
		<audio src="resource/audio/${rcontent.audioPath}" controls="controls" autoplay="autoplay">
		</audio>
	</c:if>
	<div>${rcontent.text}</div>
  </body>
</html>

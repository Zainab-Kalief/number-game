<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>Welcome to the Great Number Game</h1> 
	<p>I'm thinking of a number between 1 and 100</p>
	<p>Take a guess!</p>
	
	<% if(request.getAttribute("message") != "Perfect") { %>
	<form action="/GreatNumberGame/Guess" method="post" >
		<input name="guess" type="text" ><br>
		<input name="submit" type="submit" >
	<% if(request.getAttribute("message") != "" && request.getAttribute("message") != "Perfect") { %>	
		<p><%= request.getAttribute("message") %></p>
	<% }%>
	</form>
	
	<% } else if(request.getAttribute("message") == "Perfect") { %>
		<p><a href="/GreatNumberGame/Home" >Play again</a> </p>		
	<% }%>
</body>
</html>
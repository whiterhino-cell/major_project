<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>


<form action="addAlien">
<label for="cars">Choose a car:</label>
  <select id="cars" name="cars">
    <option value="volvo">Volvo</option>
    <option value="saab">Saab</option>
    <option value="fiat">Fiat</option>
    <option value="audi">Audi</option>
  </select><br>
<input type="text" name="aid"><br>
<input type="text" name="aname"><br>
<input type="submit"><br>
</form>

<form action="getAlien">
<input type="text" name="aid"><br>
<input type="submit"><br>
</form>

</body>
</html>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<!DOCTYPE html>
<html>
<head>
  <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
  <link href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" 
        rel="stylesheet" media="screen">
  <script src="http://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
</head>


<body>
<div class="container">
  <h1>edit3</h1>
  <hr />
  <form:form method="post" modelAttribute="ta">
    <div class="form-group">
      <label>아이디:</label>
      <form:input path="ta_id" class="form-control"/>
    </div>
    <div class="form-group">
    <label>비밀번호:</label>
      <form:input path="password"  class="form-control" placeholder="password" />
    </div>
    <hr />
    <button type="submit" class="btn btn-primary">Submit</button>
  </form:form>

</div>
</body>
</html>
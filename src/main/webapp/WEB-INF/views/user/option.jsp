<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%> 
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!doctype html>
<html lang="en">

<head>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
  <meta name="description" content="">
  <meta name="author" content="">
  <link rel="icon" href="/docs/4.1/assets/img/favicons/favicon.ico">

  <title>회원가입 분류</title>

  <link rel="canonical" href="https://getbootstrap.com/docs/4.1/examples/checkout/">

 <style type="text/css">
    <%@include file="/WEB-INF/bootstrap/css/bootstrap.min.css" %>
    <%@include file="/WEB-INF/bootstrap/css/offcanvas.css" %>
    <%@include file="/WEB-INF/bootstrap/css/form-validation.css" %>
  </style>
</head>

<body class="bg-light">

  <div class="container">

    <nav class="navbar navbar-expand-lg fixed-top navbar-dark bg-dark">

      <a class="navbar-brand mr-auto mr-lg-0" href="loginform.html">성공회대학교 과제제출시스템</a>

    </nav>


    <div class="my-3 p-3 bg-white rounded shadow-sm">
      <h4 class="mb-3">회원가입</h4>
        <hr class="mb-4">
        <button class="btn btn btn-primary btn-lg btn-block" type="button" onclick="location.href='studentsignup'" >학생 회원가입</button>
        <button class="btn btn btn-primary btn-lg btn-block" type="button" onclick="location.href='professorsignup'">교수 회원가입</button>

    </div>
    </form>
    <footer class="my-5 pt-5 text-muted text-center text-small">

    </footer>
  </div>

</body>

</html>

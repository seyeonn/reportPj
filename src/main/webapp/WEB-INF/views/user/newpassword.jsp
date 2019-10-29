<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!doctype html>
<html lang="en">

<head>
 <meta http-equiv="Content-Type" content="text/html; charset=utf-8"> 
 <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="canonical" href="https://getbootstrap.com/docs/3.3/examples/signin/">

  <title>비밀번호 변경</title>

  <style type="text/css">
    <%@include file="/WEB-INF/bootstrap/css/bootstrap.min.css" %>
    <%@include file="/WEB-INF/bootstrap/css/signin.css" %>
    <%@include file="/WEB-INF/bootstrap/css/form-validation.css" %>
  </style>
  <link href="../../assets/css/ie10-viewport-bug-workaround.css" rel="stylesheet">
  <script src="../../assets/js/ie-emulation-modes-warning.js"></script>
</head>

<body>
  <div class="container">
    <nav class="navbar navbar-expand-lg fixed-top navbar-dark bg-dark">
      <a class="navbar-brand mr-auto mr-lg-0" href="loginform">성공회대학교 과제제출시스템</a>
    </nav>

    <form class="form-signin my-3 p-3 bg-white rounded shadow-sm">
      <h4 class="mb-3">비밀번호 변경</h4>
      <hr class="mb-4">
      <div class="my-3 p-3 bg-white rounded shadow-sm">
      <div class="mb-3">
        <label for="address">비밀번호</label>
        <input type="password" class="form-control" id="password" placeholder="password" required>
        <div class="invalid-feedback">
          비밀번호를 입력해주세요.
        </div>
      </div>

      <div class="mb-3">
        <label for="address">비밀번호 확인</label>
        <input type="password" class="form-control" id="passwordok" placeholder="password" required>
        <div class="invalid-feedback">
          비밀번호 확인을 입력해주세요.
        </div>
      </div>
    </div>
      <div class="checkbox">
        <label>

        </label>
      </div>
      <button class="btn btn-lg btn-primary btn-block" type="submit">확인</button>
      <button class="btn btn-lg btn-primary btn-block" type="submit">로그인 하러 가기</button>

    </form>
  </div>

  <script src="../../assets/js/ie10-viewport-bug-workaround.js"></script>
</body>

</html>

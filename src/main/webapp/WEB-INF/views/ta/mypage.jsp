<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%> 
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!doctype html>
<html lang="en">

<!-- Head -->
<c:import url="../common/head.jsp" />

<body class="bg-light">

  <div class="container">
        <!-- Nav -->
  <c:import url="../ta/nav.jsp" />


    <div class="my-3 p-3 bg-white rounded shadow-sm">
      <h4 class="mb-3">마이페이지</h4>
      <form class="needs-validation" novalidate>
        <hr class="mb-4">
        <div class="mb-3">
          <label for="username">아이디</label>
          <div class="student_number">
            <span class="student_number-text">201732032</span>
          </div>
        </div>
        <hr class="mb-4">
        <div class="mb-3">
          <label for="username">담당 교수 이름<span class="text-muted"></span></label>
          <div class="input-group">
            <span class="student_number-text">홍은지</span>
          </div>
        </div>

        <hr class="mb-4">
        <div class="mb-3">
          <label for="username">이름<span class="text-muted">&nbsp(반드시 실명이어야 합니다.)</span></label>
          <div class="input-group">
            <input type="text" class="form-control" id="username" placeholder="안세연" required>
          </div>
        </div>

        <div class="mb-3">
          <label for="email">이메일</label>
          <input type="email" class="form-control" id="email" placeholder="dmsdo1234@gmail.com">
        </div>


        <div class="mb-3">
          <label for="address">전화번호<span class="text-muted">&nbsp(-없이 숫자만 입력해주세요.)</span></label>
          <input type="text" class="form-control" id="phonenumber" placeholder="01012341234" required>
        </div>

        <div class="mb-3">
          <label for="address">비밀번호</label>
          <input type="password" class="form-control" id="password" placeholder="password" required>
        </div>
        <div class="mb-3">
          <label for="address">비밀번호 확인</label>
          <input type="password" class="form-control" id="password" placeholder="password" required>
        </div>
        <button class="btn btn-primary btn-lg btn-block" type="submit" >수정</button>
    </div>


    </form>



    <footer class="my-5 pt-5 text-muted text-center text-small">

    </footer>
  </div>


</body>

</html>

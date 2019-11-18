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
  <c:import url="../student/nav.jsp" />


    <div class="my-3 p-3 bg-white rounded shadow-sm">
      <h4 class="mb-3">마이페이지</h4>
      <form method="post" name="student" modelAttribute="student" class="needs-validation" novalidate >
      

        <hr class="mb-4">
        <div class="mb-3">
          <label for="username">아이디</label>
          <div class="student_number">
            <span class="student_number-text">${student.id}</span>
          </div>
        </div>
        <hr class="mb-4">
        <div class="mb-3">
          <label for="username">이름<span class="text-muted">&nbsp(반드시 실명이어야 합니다.)</span></label>
          <div class="input-group">
            <input type="text" class="form-control" name="name" value="${student.name}" placeholder="이름" required>
          </div>
        </div>

        <div class="row">
          <div class="col-md-5 mb-3">
            <label for="country">학과</label>
            <select class="custom-select d-block w-100" id="department_no" name="department_no" required >
            
              <option value= "9" ${student.department_no == 9 ? "selected" :""}>소프트웨어공학과</option>
              <option value="10" ${student.department_no == 10 ? "selected" :""}>정보통신공학과</option>
              <option value="11" ${student.department_no == 11 ? "selected" :""}>글로컬IT학과</option>
              <option value="12" ${student.department_no == 12 ? "selected" :""}>컴퓨터공학과</option>
            </select>
          </div>


        </div>


        <div class="mb-3">
          <label for="email">이메일</label>
          <input type="email" class="form-control" value="${student.student_email}" name="student_email" placeholder="dmsdo1234@gmail.com">
        </div>


        <div class="mb-3">
          <label for="address">전화번호<span class="text-muted">&nbsp(-없이 숫자만 입력해주세요.)</span></label>
          <input type="text" class="form-control" name="student_phone" value="${student.student_phone}" placeholder="01012341234" required>
        </div>

        <div class="mb-3">
          <label for="question">질문</label>
          <input type="text" class="form-control" name="password_question" value="${student.password_question}" placeholder="가장 좋아하는 음식" required>
          <div class="invalid-feedback">
            비밀번호 재발급을 위한 질문을 입력해주세요.
          </div>
        </div>

        <div class="mb-3">
          <label for="answer">답</label>
          <input type="text" class="form-control" name="password_answer" value="${student.password_answer}" placeholder="치킨" required>
          <div class="invalid-feedback">
            비밀번호 재발급을 위한 답을 입력해주세요.
          </div>
        </div>

        <div class="mb-3">
          <label for="address">비밀번호</label>
          <input type="password" class="form-control" name="password1" value="${student.password1}" placeholder="password" required>
        </div>
        <div class="mb-3">
          <label for="address">비밀번호 확인</label>
          <input type="password" class="form-control" name="password2" value="${student.password2}" placeholder="password" required>
        </div>
        <button class="btn btn-primary btn-lg btn-block" type="submit" onclick="location='mypage'">수정</button>
        
    </form>

    </div>


    



    <footer class="my-5 pt-5 text-muted text-center text-small">

    </footer>
  </div>


</body>

</html>
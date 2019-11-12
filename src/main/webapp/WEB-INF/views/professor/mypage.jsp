<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!doctype html>
<html lang="en">

<!-- Head -->
<c:import url="../common/head.jsp" />

<body class="bg-light">
	<div class="container">
	
		<!-- Nav -->
		<c:import url="../professor/nav.jsp" />

		<div class="my-3 p-3 bg-white rounded shadow-sm">
			<h4 class="mb-3">마이페이지</h4>
			<form method="post" name="professor" modelAttribute="professor" class="needs-validation" novalidate >
				<hr class="mb-4">
				<div class="mb-3">
					<label for="username">아이디</label>
					<div class="professor_number">
						<span class="professor_number-text">${professor.id}</span>
					</div>
				</div>
				<hr class="mb-4">
				<div class="mb-3">
					<label for="username">이름<span class="text-muted">&nbsp(반드시
							실명이어야 합니다.)</span></label>
					<div class="input-group">
						<input type="text" class="form-control" name="name" value="${professor.name}" placeholder="이름" required>
					</div>
				</div>

				<div class="mb-3">
					<label for="email">이메일</label>
					<input type="email" class="form-control" value="${professor.professor_email}" name="professor_email" placeholder="dmsdo1234@gmail.com">
				</div>


				<div class="mb-3">
					<label for="address">전화번호<span class="text-muted">&nbsp(-없이숫자만 입력해주세요.)</span></label> 
					<input type="text" class="form-control" name="professor_phone" value="${professor.professor_phone}" placeholder="01012341234" required>
				</div>

				<%--교수랑 학생만--%>
				<div class="mb-3">
					<label for="question">질문</label> 
					<input type="text" class="form-control" name="password_question" value="${professor.password_question}" placeholder="가장 좋아하는 음식" required>
					<div class="invalid-feedback">비밀번호 재발급을 위한 질문을 입력해주세요.</div>
				</div>
				<div class="mb-3">
					<label for="answer">답</label> 
					<input type="text" class="form-control" name="password_answer" value="${professor.password_answer}" placeholder="치킨" required>
					<div class="invalid-feedback">비밀번호 재발급을 위한 답을 입력해주세요.</div>
				</div>


				<div class="mb-3">
					<label for="address">비밀번호</label>
					<input type="password" class="form-control" name="password1" value="${professor.password1}" placeholder="password" required>
				</div>
				<div class="mb-3">
					<label for="address">비밀번호 확인</label>
					<input type="password" class="form-control" name="password2" value="${professor.password2}" placeholder="password" required>
				</div>
				<button class="btn btn-primary btn-lg btn-block" type="submit" >수정</button>
			</form>
		</div>






		<footer class="my-5 pt-5 text-muted text-center text-small">

		</footer>
	</div>


</body>

</html>

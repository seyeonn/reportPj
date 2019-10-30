<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%> 
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!doctype html>
<html lang="en">

<!-- Head -->
<c:import url="../common/loginhead.jsp" />

<body>

	
  <div class="container">
  
    <!-- Nav -->
	<c:import url="../professor/nav.jsp" />


    <form class="form-signin my-3 p-3 bg-white rounded shadow-sm">
      <h4 class="mb-3">TA 생성</h4>
      <hr class="mb-4">
      아이디<label for="inputId" class="sr-only">아이디</label>
      <input type="text" id="inputEmail" class="form-control" required autofocus>

        <label>

        </label>
      </div>
      <button class="btn btn-lg btn-primary btn-block" type="submit" onclick="location='professormypage'">확인</button>
    </form>

  <script src="../../assets/js/ie10-viewport-bug-workaround.js"></script>
</body>

</html>

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


    <form:form method="post" modelAttribute="ta" class="form-signin my-3 p-3 bg-white rounded shadow-sm">
      <h4 class="mb-3">TA 생성</h4>
      <hr class="mb-4">
      <div class="form-group">
      <label>아이디:</label>
      <form:input path="ta_id" class="form-control"/>
    </div>
    <div class="form-group">
    <label>비밀번호:</label>
      <form:input path="password"  class="form-control" placeholder="password" />
    </div>
    <hr />
    <button type="submit" class="btn btn-lg btn-primary btn-block">생성하기</button>
  	</form:form>
      </div>
 

  <script src="../../assets/js/ie10-viewport-bug-workaround.js"></script>
  </body>

</html>
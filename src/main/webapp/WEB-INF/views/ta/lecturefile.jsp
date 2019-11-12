<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%> 
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!doctype html>
<html lang="en">

<!-- Head -->
<c:import url="../common/head.jsp" />


<body class="bg-light">

      <!-- Nav -->
  <c:import url="../ta/nav.jsp" />


  <main role="main" class="main-container">
    <c:import url="../ta/lecturename.jsp" />
    <div class="row">
      <div class="col-md-3 order-md-1 mb-4">
		<c:import url="../common/menu.jsp" />
      </div>

      <div class="col-md-9 order-md-2">
        <div class="my-3 p-3 bg-white rounded shadow-sm">
          
          <hr>
          <form>

            <%--교수만--%>
<%--          <form action="http://localhost/upload.php" method="post" enctype="multipart/form-data">
              <input type="file" name="profile">
              <input type="submit">
            </form> --%>

        </div>


        </form>
      </div>
    </div>
    </div>
  </main>
</body>

</html>

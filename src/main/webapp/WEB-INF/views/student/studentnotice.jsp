<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%> 
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!doctype html>
<html lang="en">

<!-- Head -->
<c:import url="../common/head.jsp" />

<body class="bg-light">

   <!-- Nav -->
  <c:import url="../student/nav.jsp" />

  <main role="main" class="main-container">
    <div class="my-3 p-3 bg-white rounded shadow-sm">
    <strong>&nbsp&nbsp ${lecture.lecture_name} &nbsp&nbsp&nbsp&nbsp</strong>
    <small>&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp ${professor.name} &nbsp교수님 &nbsp&nbsp  &nbsp&nbsp </small>
	</div>
    <div class="row">
      <div class="col-md-3 order-md-1 mb-4">
		<c:import url="../common/menu.jsp" />
      </div>

      <div class="col-md-9 order-md-2">
        <div class="my-3 p-3 bg-white rounded shadow-sm">
          

          <form class="form">
            <table class="table table-hover  text-center">
              <thead class="thead-light">
                <tr>
                  <th>번호</th>
                  <th>제목</th>
                  <th>파일</th>
                  <th>작성자</th>
                  <th>작성일</th>
                </tr>
              </thead>
              <tbody>
                <%-- <c:forEach var="" items="${  }">  --%>
                <%-- <tr data-url="edtit?id=${ }"> --%>
                <tr onClick = " location.href='studentcontent' ">
                  <td>4 </td>
                  <td>발표 주제</td>
                  <td></td>
                  <td>용동중</td>
                  <td>2019-10-30</td>
                </tr>
                <%-- </c:forEach> --%>
              </tbody>
            </table>
            <div style="float: right; display:inline-block; width: 900px;">
                <%--학생만--%>
              <button class="btn btn-primary my-2 my-sm-0" type="button" style="width: 100px; float: right" onclick="location.href='studentposting'">작성</button>
            </div>
            <div>
			<label></label>
			<label></label>
            </div>
          </form>
        </div>
      </div>
    </div>
  </main>
</body>

</html>

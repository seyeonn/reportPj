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
    <small>&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp ${professor.name } &nbsp&nbsp  &nbsp&nbsp </small>
    </div>
    <div class="row">
      <div class="col-md-3 order-md-1 mb-4">
		<!-- Menu -->
		<c:import url="../common/menu.jsp" />
      </div>

      <div class="col-md-9 order-md-2">
        <div class="my-3 p-3 bg-white rounded shadow-sm">
          <form>

            <table class="table table-hover  text-center">
              <thead class="thead-light">
                <tr>
                  <th>번호</th>
                  <th>머리말</th>
                  <th>제목</th>
                  <th>제출기한</th>
                  <th>연장기한</th>
                  <th>파일</th>
                  <th>제출여부</th>
                  <th>성적/만점</th>
                </tr>
              </thead>
              <tbody>
                <form class="form">
                <%-- <c:forEach var="" items="${studentNotice.getTitle()}"> --%>
                <%-- <tr data-url="edtit?id=${ }"> --%>
				 <tr onClick = " location.href='noticecontent' ">
                  <td>1 </td>
                  <td>과제</td>
                  <td>캡스톤 디자인 과제 계획서 및 보고서</td>
                  <td>09/10 09:00</td>
                  <td>09/13 09:00 </td>
                  <td><button type="button" class="btn btn-outline-primary">파일</button></td>
                  <td> Y</td>
                  <td> 미부여</td>
                </tr>
                 <%-- </c:forEach> --%> 
              </tbody>
              
              </tbody>
            </table>
            <div style="float: right; display:inline-block; width: 900px;">
			 <!--  <button class="btn btn-primary mx-2 my-sm-0" type="button" style="width: 100px; float: right">삭제</button>
              <button class="btn btn-primary my-2 my-sm-0" type="button" style="width: 100px; float: right" onclick="location.href='posting.html'">작성</button> -->
             
            </div>
        </div>

        </form>
      </div>
    </div>
    </div>
  </main>
</body>

</html>

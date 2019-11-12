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
    <small>&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp 홍은지 교수님 &nbsp&nbsp / &nbsp&nbsp 학생수 :26</small>
    </div>
    <div class="row">
      <div class="col-md-3 order-md-1 mb-4">
        <c:import url="../common/menu.jsp" />
      </div>

      <div class="col-md-9 order-md-2">
        <div class="my-3 p-3 bg-white rounded shadow-sm">

          <form class="form">
            <table class="table table-bordered text-center">
              <thead class="thead-light">
                <tr>
                  <th>과제 번호</th>
                  <th style="width: 700px">3</th>
                </tr>
              </thead>
              <tbody>
                <tr>
                  <td class="table-active">강좌 </td>
                  <td>데이터베이스 캡스톤디자인</td>
                </tr>
                <tr>
                  <td class="table-active">과제 제목 </td>
                  <td>사용자 인터페이스</td>
                </tr>
                <tr>
                  <td class="table-active">첨부파일 </td>
                  <td>
                    <form action="http://localhost/upload.php" method="post" enctype="multipart/form-data">
                      <input type="file" name="profile">
                      <input type="submit">
                    </form>
                  </td>
                </tr>
                <tr>
                  <td class="table-active">제출된 파일</td>
                  <td>제출된 파일이 존재하지 않습니다.</td>
                </tr>
            </table>
            <div style="float: right; display:inline-block; width: 900px;">
              <button class="btn btn-primary mx-2 my-sm-0" type="button" style="width: 100px; float: right" onclick="location.href='noticecontent'">목록보기</button>
              <button class="btn btn-primary my-2 my-sm-0" type="button" style="width: 100px; float: right" onclick="location.href='noticecontent'">제출</button>
            </div>
            <label for=""><br></label>
          </form>
        </div>
      </div>
    </div>
  </main>
</body>

</html>

<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%> 
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%> 
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!doctype html>
<html lang="en">

<!-- Head -->
<c:import url="../common/head.jsp" />

<body class="bg-light">

   <!-- Nav -->
  <c:import url="../professor/nav.jsp" />

  <main role="main" class="main-container">
    <div class="my-3 p-3 bg-white rounded shadow-sm">
      <strong>&nbsp&nbsp DB 캡스톤디자인 &nbsp&nbsp&nbsp&nbsp</strong>
      <small>&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp 홍은지 교수님 &nbsp&nbsp / &nbsp&nbsp 학생수 :26</small>
    </div>
    <div class="row">
      <div class="col-md-3 order-md-1 mb-4">
        <!-- Menu -->
		<c:import url="../common/menu.jsp" />
      </div>

      <div class="col-md-9 order-md-2">
        <div class="my-3 p-3 bg-white rounded shadow-sm">
          <hr>
          <form>
            <table class="table text-center table-bordered">
                <form class="form">
                  <tr>
                    <td class="table-active">제목 </td>
                    <td><input type="text" id="name" name="name" style="width: 600px"></td>
                  </tr>
                  <tr>
                    <td class="table-active">내용</td>
                    <td><input type="text" id="ctt" name="ctt" style="width: 600px; height: 200px"></td>
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
                    <td class="table-active">만점</td>
                    <td><input type="text" id="sco" name="sco"></td>
                  </tr>
                <tr>
                  <td class="table-active">제출기한</td>
                  <td><input type="text" id="per" name="per" style="width: 250px"></td>
                </tr>
                <tr>
                  <td class="table-active">연장기한</td>
                  <td><input type="text" id="per2" name="per2" style="width: 250px"></td>
                </tr>
            </table>


            <div style="float: right; display:inline-block; width: 900px;">
              <button class="btn btn-primary mx-2 my-sm-0" type="button" style="width: 100px; float: right" onclick="location.href='notice'">목록보기</button>
              <button class="btn btn-primary my-2 my-sm-0" type="button" style="width: 100px; float: right" onclick="location.href='notice'">등록</button>
            </div>
            <label for=""><br></label>
        </div>

        </form>
      </div>
    </div>
    </div>
  </main>
</body>

</html>
v
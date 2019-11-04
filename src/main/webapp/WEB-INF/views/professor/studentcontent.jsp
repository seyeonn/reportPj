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
        <c:import url="../common/menu.jsp" />
      </div>

      <div class="col-md-9 order-md-2">
        <div class="my-3 p-3 bg-white rounded shadow-sm">
          <div class="my-2 ">
            <select>
              <optgroup label="전공">
                <option>DB 캡스톤디자인</option>
                <option>고급 웹프로그래밍2</option>
                <option>모바일 프로그래밍</option>
              </optgroup>
              <optgroup label="교양">
                <option>기초 영자신문 읽기</option>
                <option>교양 러시아어</option>
              </optgroup>
            </select>
          </div>
          <hr>

          <form class="form">
            <table class="table table-bordered  text-center">
              <thead class="thead-light">
                <tr>
                  <th>번호</th>
                  <th>3</th>
                </tr>
              </thead>

              <tbody>
                <tr>
                  <td class="table-active">제목 </td>
                  <td> 발표 주제 확정 </td>
                </tr>
                <tr>
                  <td class="table-active">내용</td>
                  <td> 데이터베이스의 오류 개선 ... <br><br><br></td>

                </tr>
                <tr>
                  <td class="table-active">파일 </td>
                  <td><button type="button" class="btn btn-outline-primary">열람</button></td>
                </tr>
                <tr>
                  <td class="table-active">작성자</td>
                  <td>장은애</td>
                </tr>
                <tr>
                  <td class="table-active">작성일</td>
                  <td>2019-10-22</td>
                </tr>
              </tbody>
            </table>



            <div style="float: right; display:inline-block; width: 900px;">
              <button class="btn btn-primary mx-2 my-sm-0" type="button" style="width: 100px; float: right" onclick="location.href='studentnotice'">목록</button>
              <button class="btn btn-primary my-2 my-sm-0" type="button" style="width: 100px; float: right" onclick="location.href=''">삭제</button>
            </div>
            <label for=""><br></label>
          </form>
        </div>
      </div>
    </div>
  </main>
</body>

</html>

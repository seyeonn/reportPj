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
    <c:import url="../professor/lecturename.jsp" />
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
            <hr>

            <form class="form-inline mt-2 mt-md-0">
              <input class="form-control mr-sm-2" type="text" placeholder="게시글 이름으로 검색하기" aria-label="Search">
              <button class="btn btn btn-primary my-2 my-sm-0" type="submit">검색</button>
            </form>
          </div>

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

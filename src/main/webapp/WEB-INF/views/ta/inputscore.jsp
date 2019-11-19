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
    <div class="my-3 p-3 bg-white rounded shadow-sm">
    <strong>&nbsp&nbsp ${lecture.lecture_name } &nbsp&nbsp&nbsp&nbsp</strong>
    <small>&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp &nbsp&nbsp / &nbsp&nbsp </small>
    </div>
    <div class="row">
      <div class="col-md-3 order-md-1 mb-4">
        <!-- Menu -->
      <c:import url="../common/menu.jsp" />
      </div>
      

      <div class="col-md-9 order-md-2">
        <div class="my-3 p-3 bg-white rounded shadow-sm">
        <div class="my-2 ">
        <form class="form-inline mt-2 mt-md-0">
          <input class="form-control mr-sm-2" type="text" placeholder="학생 이름으로 검색하기" aria-label="Search">
          <button class="btn btn btn-primary my-2 my-sm-0" type="submit">검색</button>
        </form>
        </div>
       
        
          <form method="post">
          <table class="table table-striped  text-center">
            <thead class="thead-light">
              <tr>
              	<th>과제번호</th>
                <th>학번</th>
                <th>이름</th>
                <th>학과</th>
                <th>채점</th>
                <th>제출정보</th>
                <th>성적</th>
                <th>등수</th>
              </tr>
            </thead>

            <tbody>
            <c:forEach var="homework" items="${homeworks}">
                <tr>
                  <td>
                  	<input type="hidden" name="hw_no" value="${ homework.hw_no }" />
                  	${homework.hw_no}
                  </td>           
                  <td>${homework.student.id } </td>
                  <td>${homework.student.name } </td>
                  <td>${homework.student.department.department_name}</td>
                  <td><button type="button" class="btn btn-outline-primary" >열람</button></td>
                  <td>${homework.submitdate}</td>
                  <td>
                  	<input type="text" class="form-control" name="grade" value="${homework.grade}" style="width:50px"  />
                  </td>
                  <td>
                  	<input type="text" class="form-control" name="ranking" value="${homework.ranking}" style="width:50px"  />
                  </td>
                </tr>
                </c:forEach>
            </tbody>
          </table>
		
			<div style="float: right; display:inline-block; width: 900px;">
            	<button class="btn btn-primary mx-2 my-sm-0" type="button" style="width: 100px; float: right" onclick="location.href='noticecontent?id=#{professorNotice.notice_no}'">목록</button>
            	<button type="submit"class="btn btn-primary my-2 my-sm-0" name="cmd" value="input" style="width: 100px; float: right" >입력</button>
          	</div>
		</form>
         
          
        </div>
        
	</div>
	</div>

  </main>
</body>

</html>
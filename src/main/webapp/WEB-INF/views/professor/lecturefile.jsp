<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%> 
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib prefix = "fmt" uri = "http://java.sun.com/jsp/jstl/fmt" %>
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
          <table class="table table-hover text-center">
          <thead class="thead-light">
                <tr>
                  <th>파일이름</th>
                  <th>Size</th>
                  <th>제출시간</th>
                  <th>다운로드</th>
                  <th>삭제</th>
                </tr>
              </thead>
          <c:forEach var="Lecturefile" items="${ files }">
            <tr>
             <td style="min-width:200px">${ Lecturefile.file_name }</td>
             <td class="text-right">
                <fmt:formatNumber type = "number" value="${ Lecturefile.file_size }" /> bytes</td>
             <td>
                <fmt:formatDate pattern="yyyy-MM-dd HH:mm:ss" value="${ Lecturefile.file_time }" /></td>
             <td>
                <a class="btn btn-default btn-xs" href="/professor/lecturefile/download?no=${Lecturefile.no}">다운로드</a></td>
                <td>
                
                <a class="btn btn-default btn-xs" href="/professor/lecturefile/deletefile?no=${Lecturefile.no}&id=${lecture.lecture_no}">삭제</a> 
                
             </td>
            </tr>
        </c:forEach>
            </table>
          <hr>
       

            <%--교수만--%>
         <form method="post" enctype="multipart/form-data">
              <input type="file" name="upload" multiple> 
              <input type="hidden" name="id" value="${lecture.lecture_no}">
              <button type="submit" name="cmd" value="upload" class="btn btn-primary">업로드</button>
              <!-- <input type="submit"> -->
            </form>
      
        </div>
      </div>
    </div>
  </main>
</body>

</html>
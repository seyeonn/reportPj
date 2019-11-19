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
   <c:import url="../professor/lecturename.jsp" />
    <div class="row">
      <div class="col-md-3 order-md-1 mb-4">
        <!-- Menu -->
		<c:import url="../common/menu.jsp" />
      </div>

      <div class="col-md-9 order-md-2">
        <div class="my-3 p-3 bg-white rounded shadow-sm">
       

            <table class="table table-bordered  text-center">
              <tbody>
                <tr>
                  <td class="table-active" width="15%">제목 </td>
                  <td> ${professorNotice.title}</td>
                </tr>
                <tr>
                  <td class="table-active">내용</td>
                  <td style="white-space:pre;">${professorNotice.content}</td>

                </tr>
                <tr>
                  <td class="table-active">첨부파일 </td>
                  <td><button type="button" class="btn btn-outline-primary">열람</button></td>
                </tr>
                <tr>
                  <td class="table-active">만점</td>
                  <td>${professorNotice.perfect_score}</td>
                </tr>
                <tr>
                  <td class="table-active">제출기한</td>
                  <td>${professorNotice.deadline}</td>
                </tr>
                <tr>
                  <td class="table-active">연장기한</td>
                  <td>${professorNotice.deadline_add}</td>
                </tr>
              </tbody>
            </table>
            <table class="table text-center">
              <tr class="table-active">
                <td>댓글 </td>
                <td style="width:700px">익명: 감사합니다 교수님~!</td>
              </tr>
              <tr>
                <td>익명 </td>
                  <td style="width:700px">
                    <input type="text" name="comment" id="comment" style="width: 450px">
                    <button type="submit">입력</button>
                  </td>
              </tr>
            </table>


            <div style="float: right; display:inline-block; width: 900px;">
	
              <button class="btn btn-primary my-sm-0" type="button" style="width: 100px; float: right" onclick="location.href='notice?id=${lecture.lecture_no}'">목록보기</button>
              <%--교수랑 TA만--%>
              <button class="btn btn-primary mx-2 my-sm-0" type="button" style="width: 100px; float: right" onClick = " location.href='/ta/inputscore?notice_no=${professorNotice.notice_no}'">점수부여</button>
          	
          	</div>
            <label for=""><br></label>

        </div>
      </div>
    </div>
  </main>
</body>

</html>

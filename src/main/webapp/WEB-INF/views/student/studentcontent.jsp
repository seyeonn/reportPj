<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!doctype html>
<html lang="en">

<!-- Head -->
<c:import url="../common/head.jsp"/>

<body class="bg-light">

<!-- Nav -->
<c:import url="../student/nav.jsp"/>


<main role="main" class="main-container">
    <div class="my-3 p-3 bg-white rounded shadow-sm">
        <strong>&nbsp&nbsp ${lecture.lecture_name} &nbsp&nbsp&nbsp&nbsp</strong>
        <small>&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp ${professor.professor_name}님 &nbsp&nbsp
            / &nbsp&nbsp </small>
    </div>
    <div class="row">
        <div class="col-md-3 order-md-1 mb-4">
            <c:import url="../common/menu.jsp"/>
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


                    <table class="table table-bordered  text-center">

                        <tbody>
                        <tr>
                            <td class="table-active">제목</td>
                            <td> ${studentNotice.title} </td>
                        </tr>
                        <tr>
                            <td class="table-active">내용</td>
                            <td style="white-space:pre;">${studentNotice.content}</td>

                        </tr>
                        <tr>
                            <td class="table-active">작성자</td>
                            <td>${studentNotice.student.name}</td>
                        </tr>
                        <tr>
                            <td class="table-active">작성일</td>
                            <td>
                               <fmt:formatDate value="${studentNotice.submitdate}" pattern="yyyy-MM-dd"/>
                            </td>
                        </tr>
                        </tbody>
                    </table>


                    <div style="float: right; display:inline-block; width: 900px;">
                        <button class="btn btn-primary mx-2 my-sm-0" type="button" style="width: 100px; float: right"
                                onclick="location.href='studentnotice?id=${lecture.lecture_no}'">목록
                        </button>

                        <form method="post">
                            <input type="hidden" name="studentnotice_no" value="${studentNotice.studentnotice_no}" />
                            <input type="hidden" name="lecture_no" value="${lecture.lecture_no}" />
                            <button class="btn btn-primary my-sm-0" type="submit" name="cmd" value="delete" style="width: 100px; float: right">삭제</button>
                        </form>
<%--                        <form method="post">--%>
<%--                            <input type="hidden" name="notice_no" value="${ professorNotice.notice_no }" />--%>
<%--                            <input type="hidden" name="lecture_no" value="${ lecture.lecture_no }" />--%>
<%--                            <button class="btn btn-primary my-sm-0" type="submit" name="cmd" value="delete" style="width: 100px; float: right">삭제</button>--%>
<%--                        </form>--%>
                        <button class="btn btn-primary mx-2 my-sm-0" type="button" style="width: 100px; float: right"
                                onclick="location.href='studentcontentedit?studentnotice_no=${studentNotice.studentnotice_no}&lecture_no=${ lecture.lecture_no }'">수정
                        </button>
                    </div>
                    <label for=""><br></label>
            </div>
        </div>
    </div>
</main>
</body>

</html>
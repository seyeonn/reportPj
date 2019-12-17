<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<!doctype html>
<html lang="en">

<!-- Head -->
<c:import url="../common/head.jsp"/>

<body class="bg-light">

<!-- Nav -->
<c:import url="../student/nav.jsp"/>

<main role="main" class="main-container">
    <c:import url="../student/lecturename.jsp" />
    <div class="row">
        <div class="col-md-3 order-md-1 mb-4">
            <c:import url="../common/menu.jsp"/>
        </div>

        <div class="col-md-9 order-md-2">
            <div class="my-3 p-3 bg-white rounded shadow-sm">
                <form:form method="post" modelAttribute="studentNotice">
                    <table class="table table-bordered text-center">
                        <tbody>
                        <tr>
                            <td class="table-active">제목</td>
                            <td><form:input path="title" class="form-control"/></td>
                        </tr>
                        <tr>
                            <td class="table-active">내용</td>
                            <td><form:textarea path="content" class="form-control"
                                               style="height: 300px; overflow:auto"/></td>
                        </tr>
                        
                    </table>
                    <div style="float: right; display:inline-block; width: 900px;">
                        <button class="btn btn-primary mx-2 my-sm-0" type="button" style="width: 100px; float: right"
                                onclick="location.href='studentnotice?id=${lecture.lecture_no}'">목록보기
                        </button>
                        <button class="btn btn-primary my-2 my-sm-0" type="submit" style="width: 100px; float: right"
                                onclick="location.href='studentposting?id=${lecture.lecture_no}'">등록
                        </button>
                    </div>
                    <label for=""><br></label>
                </form:form>
            </div>
        </div>
    </div>
</main>
</body>

</html>

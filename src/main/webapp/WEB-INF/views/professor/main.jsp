<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%> 
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%> 
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

<!-- Head -->
<c:import url="../../common/head.jsp" />

<!DOCTYPE HTML>
<html lang="en">

  <body class="bg-light">

    <nav class="navbar navbar-expand-lg fixed-top navbar-dark bg-dark">

        <a class="navbar-brand mr-auto mr-lg-0" href="professormain.html">성공회대학교 과제제출시스템</a>
        <button class="navbar-toggler p-0 border-0" type="button" data-toggle="offcanvas">
          <span class="navbar-toggler-icon"></span>
        </button>

        <div class="navbar-collapse offcanvas-collapse" id="navbarsExampleDefault">
          <ul class="navbar-nav mr-auto">
            <li class="nav-item">
              <a class="nav-link" href="professormain.html">초기화면</a>
            </li>
            <li class="nav-item">
              <a class="nav-link" href="professormypage.html">마이페이지</a>
            </li>
            <li class="nav-item">
              <a class="nav-link" href="taapprove.html">TA 승인</a>
            </li>
            <li class="nav-item">
              <a class="nav-link" href="#">도움말</a>
            </li>

          </ul>
          <form class="form-inline my-2 my-lg-0">
            <h7 class="mb-0 text-white lh-100">소프트웨어공학과 교수 홍은지&nbsp&nbsp</h7>
            <button class="btn btn-outline-success my-2 my-sm-0" type="button" onclick="location.href='loginform.html'">로그아웃</button>
          </form>
        </div>
    </nav>
  <div class="main-container">
      <div class="row">
        <div class="col-md-3 order-md-1 mb-4">
            <div class="my-3 p-3 bg-white rounded shadow-sm">
          <h6 class="border-bottom border-gray pb-2 mb-0">내 강좌</h6>
          <div class="text-gray-dark"> 전공
          <div class="media text-muted pt-3">
            <img data-src="holder.js/32x32?theme=thumb&bg=007bff&fg=007bff&size=1" alt="" class="mr-2 rounded">
            <div class="media-body pb-3 mb-0 small lh-125 border-bottom border-gray">
              <div class="d-flex justify-content-between align-items-center w-100">
                <button type="button" class="btn btn-block" style="color: #6f6f6f; text-align: left; font-size: 11pt; font-weight: bold;" onclick="location.href='professorlecture1.html'">DB 캡스톤디자인</button>
              </div>

            </div>
          </div>
          <div class="media text-muted pt-3">
            <img data-src="holder.js/32x32?theme=thumb&bg=007bff&fg=007bff&size=1" alt="" class="mr-2 rounded">
            <div class="media-body pb-3 mb-0 small lh-125 border-bottom border-gray">
              <div class="d-flex justify-content-between align-items-center w-100">
                <button type="button" class="btn btn-block" style="color: #6f6f6f; text-align: left; font-size: 11pt; font-weight: bold;" onclick="location.href=''">Python 프로그래밍</button>
              </div>

            </div>
          </div>
          <div class="media text-muted pt-3">
            <img data-src="holder.js/32x32?theme=thumb&bg=007bff&fg=007bff&size=1" alt="" class="mr-2 rounded">
            <div class="media-body pb-3 mb-0 small lh-125 border-bottom border-gray">
              <div class="d-flex justify-content-between align-items-center w-100">
                <button type="button" class="btn btn-block" style="color: #6f6f6f; text-align: left; font-size: 11pt; font-weight: bold;" onclick="location.href=''">C프로그래밍</button>
              </div>

            </div>
          </div>
        </div>

        <div class="text-gray-dark"> 교양
        <div class="media text-muted pt-3">
          <img data-src="holder.js/32x32?theme=thumb&bg=007bff&fg=007bff&size=1" alt="" class="mr-2 rounded">
          <div class="media-body pb-3 mb-0 small lh-125 border-bottom border-gray">
            <div class="d-flex justify-content-between align-items-center w-100">
              <button type="button" class="btn btn-block" style="color: #6f6f6f; text-align: left; font-size: 11pt; font-weight: bold;" onclick="location.href=''">대학생활세미나2<br>(IT융합 5반)</button>
            </div>

          </div>
        </div>
        <div class="media text-muted pt-3">
          <img data-src="holder.js/32x32?theme=thumb&bg=007bff&fg=007bff&size=1" alt="" class="mr-2 rounded">
          <div class="media-body pb-3 mb-0 small lh-125 border-bottom border-gray">
            <div class="d-flex justify-content-between align-items-center w-100">
              <button type="button" class="btn btn-block" style="color: #6f6f6f; text-align: left; font-size: 11pt; font-weight: bold;" onclick="location.href=''">대학생활세미나2<br>(IT융합 1반)</button>
            </div>

          </div>
        </div>

      </div>
          <small class="d-block text-right mt-3">

            <a href="createlecture.html">강좌 개설 </a>
          </small>
        </div>
          </div>

        <div class="col-md-6 order-md-2">
          <div class="my-3 p-3 bg-white rounded shadow-sm">
        <h6 class="border-bottom border-gray pb-2 mb-0">타임 라인</h6>
        <div class="media text-muted pt-3">
          <img data-src="holder.js/32x32?theme=thumb&bg=007bff&fg=007bff&size=1" alt="" class="mr-2 rounded">
          <div class="media-body pb-3 mb-0 small lh-125 border-bottom border-gray">
            <div class="d-flex justify-content-between align-items-center w-100">
              <button type="button" class="btn btn-block" style="color: #6f6f6f; text-align: left; font-size: 10pt; font-weight: bold;" onclick="location.href='studentposting2.html'">DB 캡스톤디자인
              <span class="d-block" style="font-weight: normal">발표 주제</span></button>
            </div>
          </div>
        </div>
        <div class="media text-muted pt-3">
          <img data-src="holder.js/32x32?theme=thumb&bg=007bff&fg=007bff&size=1" alt="" class="mr-2 rounded">
          <div class="media-body pb-3 mb-0 small lh-125 border-bottom border-gray">
            <div class="d-flex justify-content-between align-items-center w-100">
              <button type="button" class="btn btn-block" style="color: #6f6f6f; text-align: left; font-size: 10pt; font-weight: bold;" onclick="location.href='studentposting2.html'">DB 캡스톤디자인
              <span class="d-block" style="font-weight: normal">발표 주제 확정</span></button>
            </div>
          </div>
        </div>
        <div class="media text-muted pt-3">
          <img data-src="holder.js/32x32?theme=thumb&bg=007bff&fg=007bff&size=1" alt="" class="mr-2 rounded">
          <div class="media-body pb-3 mb-0 small lh-125 border-bottom border-gray">
            <div class="d-flex justify-content-between align-items-center w-100">
              <button type="button" class="btn btn-block" style="color: #6f6f6f; text-align: left; font-size: 10pt; font-weight: bold;" onclick="location.href='studentposting2.html'">DB 캡스톤디자인
              <span class="d-block" style="font-weight: normal">자유주제 발표 주제</span></button>
            </div>
          </div>
        </div>
        <div class="media text-muted pt-3">
          <img data-src="holder.js/32x32?theme=thumb&bg=007bff&fg=007bff&size=1" alt="" class="mr-2 rounded">
          <div class="media-body pb-3 mb-0 small lh-125 border-bottom border-gray">
            <div class="d-flex justify-content-between align-items-center w-100">
              <button type="button" class="btn btn-block" style="color: #6f6f6f; text-align: left; font-size: 10pt; font-weight: bold;" onclick="location.href='studentposting2.html'">DB 캡스톤디자인
              <span class="d-block" style="font-weight: normal">자유주제 발표</span></button>
            </div>
          </div>
        </div>
        <small class="d-block text-right mt-3">
          <a href="#"> </a>
        </small>
      </div>
        </div>
      <div class="col-md-3 order-md-3">
		<!-- 달력 -->
		<c:import url="../../common/calendar.jsp" />
		
      </div>
      </div>
      </div>
    </div>

      <footer class="my-5 pt-5 text-muted text-center text-small">

      </footer>
    </div>
  </body>
</html>

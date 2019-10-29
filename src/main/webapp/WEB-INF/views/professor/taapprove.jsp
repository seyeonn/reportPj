<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!doctype html>
<html lang="en">

<!-- Head -->
<c:import url="../common/head.jsp" />

<body class="bg-light">
  <nav class="navbar navbar-expand-lg fixed-top navbar-dark bg-dark">
    <a class="navbar-brand mr-auto mr-lg-0" href="main">성공회대학교 과제제출시스템</a>
    <button class="navbar-toggler p-0 border-0" type="button" data-toggle="offcanvas">
      <span class="navbar-toggler-icon"></span>
    </button>

    <div class="navbar-collapse offcanvas-collapse" id="navbarsExampleDefault">
      <ul class="navbar-nav mr-auto">
        <li class="nav-item">
          <a class="nav-link" href="main">초기화면</a>
        </li>
        <li class="nav-item">
          <a class="nav-link" href="mypage">마이페이지</a>
        </li>
        <li class="nav-item active">
          <a class="nav-link" href="TA">TA 승인</a>
        </li>
        <li class="nav-item">
          <a class="nav-link" href="information">도움말</a>
        </li>

      </ul>
      <form class="form-inline my-2 my-lg-0">
        <h7 class="mb-0 text-white lh-100">소프트웨어공학과 교수 홍은지&nbsp&nbsp</h7>
        <button class="btn btn-outline-success my-2 my-sm-0" type="button" onclick="location.href='loginform'">로그아웃</button>
      </form>
    </div>
  </nav>

  <main role="main" class="container">

    <div class="my-3 p-3 bg-white rounded shadow-sm">
      <h6 class="border-bottom border-gray pb-2 mb-0">미승인</h6>
      <div class="media text-muted pt-3">
        <img data-src="holder.js/32x32?theme=thumb&bg=007bff&fg=007bff&size=1" alt="" class="mr-2 rounded">
        <div class="media-body pb-3 mb-0 small lh-125 border-bottom border-gray">
          <div class="d-flex justify-content-between align-items-center w-100">
            <strong class="text-gray-dark"> DB 캡스톤디자인</strong>
            <button type="button" class="btn btn-primary" name="button">승인</button>
          </div>

        </div>
      </div>
      <div class="media text-muted pt-3">
        <img data-src="holder.js/32x32?theme=thumb&bg=007bff&fg=007bff&size=1" alt="" class="mr-2 rounded">
        <div class="media-body pb-3 mb-0 small lh-125 border-bottom border-gray">
          <div class="d-flex justify-content-between align-items-center w-100">
            <strong class="text-gray-dark">Python 프로그래밍</strong>
            <button type="button" class="btn btn-primary" name="button">승인</button>
          </div>

        </div>
      </div>
      <div class="media text-muted pt-3">
        <img data-src="holder.js/32x32?theme=thumb&bg=007bff&fg=007bff&size=1" alt="" class="mr-2 rounded">
        <div class="media-body pb-3 mb-0 small lh-125 border-bottom border-gray">
          <div class="d-flex justify-content-between align-items-center w-100">
            <strong class="text-gray-dark">대학생활세미나2(IT융합 5반)</strong>
            <button type="button" class="btn btn-primary" name="button">승인</button>
          </div>
        </div>
      </div>
    </div>

    <div class="my-3 p-3 bg-white rounded shadow-sm">
      <h6 class="border-bottom border-gray pb-2 mb-0">승인</h6>

      <div class="media text-muted pt-3">
        <img data-src="holder.js/32x32?theme=thumb&bg=007bff&fg=007bff&size=1" alt="" class="mr-2 rounded">
        <div class="media-body pb-3 mb-0 small lh-125 border-bottom border-gray">
          <div class="d-flex justify-content-between align-items-center w-100">
            <strong class="text-gray-dark">대학생활세미나2(IT융합 1반)</strong>
            <button type="button" class="btn btn-outline-primary" name="button">취소</button>
          </div>
        </div>
      </div>
      <div class="media text-muted pt-3">
        <img data-src="holder.js/32x32?theme=thumb&bg=007bff&fg=007bff&size=1" alt="" class="mr-2 rounded">
        <div class="media-body pb-3 mb-0 small lh-125 border-bottom border-gray">
          <div class="d-flex justify-content-between align-items-center w-100">
            <strong class="text-gray-dark">C프로그래밍</strong>
            <button type="button" class="btn btn-outline-primary" name="button">취소</button>
          </div>
        </div>
      </div>
    </div>

  </main>
  <footer class="my-5 pt-5 text-muted text-center text-small">

  </footer>

  <script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
  <script>
    window.jQuery || document.write('<script src="../../assets/js/vendor/jquery-slim.min.js"><\/script>')
  </script>
  <script src="../../assets/js/vendor/popper.min.js"></script>
  <script src="../../dist/js/bootstrap.min.js"></script>
  <script src="../../assets/js/vendor/holder.min.js"></script>
  <script src="offcanvas.js"></script>
</body>

</html>

<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<div class="my-3 p-3 bg-white rounded shadow-sm">
	<h6 class="border-bottom border-gray pb-2 mb-0">승인받은강좌</h6>
	<div class="text-gray-dark">
		<c:forEach var="lecture" items="${ taLecture }">
			<div class="media text-muted pt-3">
				<img
					data-src="holder.js/32x32?theme=thumb&bg=007bff&fg=007bff&size=1"
					alt="" class="mr-2 rounded">
				<div
					class="media-body pb-3 mb-0 small lh-125 border-bottom border-gray">
					<div
						class="d-flex justify-content-between align-items-center w-100">
						<%--학생--%>
						<button type="button" class="btn btn-block"
							style="color: #6f6f6f; text-align: left; font-size: 11pt; font-weight: bold;"
							onclick="location.href='notice?id=${lecture.lecture_no}'">${lecture.lecture_name}
						</button>
					</div>
				</div>
			</div>
		</c:forEach>

	</div>
</div>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>MYCGV</title>
<link rel="stylesheet" href="http://localhost:9000/css/mycgv_jsp.css">
</head>
<body>
	<!-- header -->
	<!-- <iframe src="http://localhost:9000/header.jsp"
			scrolling="no" width="100%" height="149px" frameborder=0></iframe> -->
	<jsp:include page="../../header.jsp"></jsp:include>
	
	<!-- content -->
	<div class="content">
		<section class="board">
			<h1 class="title">관리자 - 공지사항</h1>
			<table class="board_content">
				<tr>
					<th>제목</th>
					<td>${boardNoticeVo.bntitle }</td>
				</tr>
				<tr>
					<th>내용</th>
					<td>
						${boardNoticeVo.bncontent }
					</td>
				</tr>
				<tr>
					<th>조회수</th>
					<td>${boardNoticeVo.bnhits }</td>
				</tr>
				<tr>
					<th>작성일자</th>
					<td>${boardNoticeVo.bndate }</td>
				</tr>
				<tr>
					<td colspan="2">
						<a href="/admin/notice_update/${boardNoticeVo.bnid }">
							<button type="button">수정하기</button></a>
						<a href="/admin/notice_delete/${boardNoticeVo.bnid }">
							<button type="button">삭제하기</button></a>
						<a href="/admin/notice_list/${page}">
							<button type="button">리스트</button></a>
						<a href="http://localhost:9000/admin/index">
						<button type="button">관리자홈</button></a>
					</td>
				</tr>
			</table>
		</section>
	</div>
	
	<!-- footer -->
	<!-- <iframe src="http://localhost:9000/footer.jsp"
			scrolling="no" width="100%" height="500px" frameborder=0></iframe> -->	
	<jsp:include page="../../footer.jsp"></jsp:include>
</body>
</html>

















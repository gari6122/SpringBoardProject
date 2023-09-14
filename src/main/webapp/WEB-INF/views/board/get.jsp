<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ include file="../includes/header.jsp" %>
<!DOCTYPE html>
<html lang="ko">
<head>
<meta charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>게시글 상세조회</title>
</head>
<body>
<h1>조회 페이지</h1>
	<div class="input_wrap form-group">
		<label>게시판 번호</label>
		<input class="form-control" name="bno" readonly="readonly" value='<c:out value="${pageInfo.bno}"/>' >
	</div>
	<div class="input_wrap form-group">
		<label>게시판 제목</label>
		<input class="form-control" name="title" readonly="readonly" value='<c:out value="${pageInfo.title}"/>' >
	</div>
	<div class="input_wrap form-group">
		<label>게시판 내용</label>
		<textarea class="form-control" rows="3" name="content" readonly="readonly"><c:out value="${pageInfo.content}"/></textarea>
	</div>
	<div class="input_wrap form-group">
		<label>게시판 작성자</label>
		<input class="form-control" name="writer" readonly="readonly" value='<c:out value="${pageInfo.writer}"/>' >
	</div>
	<div class="input_wrap form-group">
		<label>게시판 등록일</label>
		<input class="form-control" name="regDate" readonly="readonly" value='<fmt:formatDate pattern="yyyy/MM/dd" value="${pageInfo.regDate}"/>' >
	</div>
	<div class="input_wrap form-group">
		<label>게시판 수정일</label>
		<input class="form-control" name="updateDate" readonly="readonly" value='<fmt:formatDate pattern="yyyy/MM/dd" value="${pageInfo.updateDate}"/>' >
	</div>
	
	<div class="btn_wrap">
		<a class="btn" id="list_btn">목록 페이지</a> 
		<a class="btn" id="modify_btn"">수정 하기</a>
	</div>
	
	<form id="infoForm" action="/board/modify" method="get">
		<input type="hidden" id="bno" name="bno" value='<c:out value="${pageInfo.bno}"/>'>
		<input type="hidden" name="pageNum" value='<c:out value="${cri.pageNum}"/>'>
		<input type="hidden" name="amount" value='<c:out value="${cri.amount}"/>'>
		<input type="hidden" name="type" value="${cri.type }">
		<input type="hidden" name="keyword" value="${cri.keyword }">
	</form>
<script>
	var form = $("#infoForm");
	
	$("#list_btn").on("click", function(e) {
			form.find("#bno").remove();
			form.attr("action", "/board/list");
			form.submit();
	});
	
	$("#modify_btn").on("click", function(e) {
			form.attr("action", "/board/modify");
			form.submit();
	})
</script>
</body>
</html>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ include file="../includes/header.jsp" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

<div class="table_wrap">
	<a href="/board/register" class="btn btn-default">게시글 등록</a>
	<table class="table table-striped table-hover">
		<thead>
			<tr>
				<th class="bno_width">번호</th>
				<th class="title_width">제목</th>
				<th class="content_width">내용</th>
				<th class="writer_width">작성자</th>
				<th class="regdate_width">작성일</th>
				<th class="updatedate_width">수정일</th>
			</tr>
		</thead>
		<c:forEach items="${list}" var="list">
			<tr>
				<td><c:out value="${list.bno}"/></td>
				<td>
					<a class="move" href='<c:out value="${list.bno}"/>'>
						<c:out value="${list.title}"/>
					</a>
				</td>
				<td><c:out value="${list.content}"/></td>
				<td><c:out value="${list.writer}"/></td>
				<td><fmt:formatDate pattern="yyyy/MM/dd" value="${list.regDate}"/></td>
				<td><fmt:formatDate pattern="yyyy/MM/dd" value="${list.updateDate}"/></td>
			</tr>
		</c:forEach>
	</table>
	
	<div class="search_wrap">
		<div class="search_area">
		
			<select name="type" class="form-control">
				<option value="" <c:out value="${pageMaker.cri.type == nll?'selected':''}"/>>--</option>
				<option value="T" <c:out value="${pageMaker.cri.type eq 'T'?'selected':''}"/>>제목</option>
				<option value="C" <c:out value="${pageMaker.cri.type eq 'C'?'selected':''}"/>>내용</option>
				<option value="W" <c:out value="${pageMaker.cri.type eq 'W'?'selected':''}"/>>작성자</option>
				<option value="TC" <c:out value="${pageMaker.cri.type eq 'TC'?'selected':''}"/>>제목 + 내용</option>
				<option value="TW" <c:out value="${pageMaker.cri.type eq 'TW'?'selected':''}"/>>제목 + 작성자</option>
				<option value="TCW" <c:out value="${pageMaker.cri.type eq 'TCW'?'selected':''}"/>>제목 + 내용 + 작성자</option>
			</select>
		
		<input type="text" name="keyword" value="${pageMaker.cri.keyword}">
		<button class="btn btn-default">검색</button>
		</div>
	</div>
	
	<div class="pageInfo_wrap">
		<div class="pageInfo_area">
			<ul id="pageInfo" class="pageInfo">
			
  					<ul class="pagination">
				<!-- 이전 페이지 버튼 -->
				<c:if test="${pageMaker.prev}">
					<li class="pageInfo_btn page-item">
						<a href="${pageMaker.startPage-1}">이전</a>
					</li>
				</c:if>
				
				<!-- 각 번호 페이지 버튼 -->
				<!-- 서버로부터 전달받은 pageMaker 속성에 저장된 startPage, endPage 값을 forEach활용 페이지번호 출력 href 속성의 값은 페이지 번호 form태그로 작동 -->
						<c:forEach var="num" begin="${pageMaker.startPage}" end="${pageMaker.endPage}">
							<li class="page-item ${pageMaker.cri.pageNum == num ? "active" : "" }">
								<a href="${num}">${num}</a>
							</li>				
						</c:forEach>
				<!-- 다음 페이지 버튼 -->
				<c:if test="${pageMaker.next}">
					<li class="pageInfo_btn page-item">
						<a href="${pageMaker.endPage+1}">다음</a>
					</li>
				</c:if>
					</ul>
				
			</ul>
		</div>
	</div>
	<form id="moveForm" method="get">
		<input type="hidden" name="pageNum" value="${pageMaker.cri.pageNum }">
		<input type="hidden" name="amount" value="${pageMaker.cri.amount }">
		<input type="hidden" name="keyword" value="${pageMaker.cri.keyword }">
		<input type="hidden" name="type" value="${pageMaker.cri.type }">
	</form>
</div>

<script>
	$(document).ready(function() {
		// 서버로부터 전달받은 값을 저장하기 위한 result 선언,
		// 전달받은 값으로 초기화
		var result = '<c:out value="${result}"/>';		
		// result에 담긴 값이 없을 경우 실행되지 않게,
		// 값이 있다면 메시지 체크 후 등록 완료 경고창을 뜨위는 로직 함수
		checkAlert(result);
		console.log(result);
		
		function checkAlert(result) {
			if (result === '') {
				return;
			}
			if (result === "register success") {
				alert("등록이 완료되었습니다.");
			}
			if (result === "modify success") {
				alert("수정이 완료되었습니다.");
			}
			if (result === "remove success") {
				alert("삭제가 완료되었습니다.");
			}
		}
		
		$(".search_btn").keydown(function (key) {
			if (key.keyCode == 13) {
				alert("엔터키 누름");
			}
		});
		
	});
	
	// 아래 설명: 클릭한 a태그 기능 정지 => form태그 내부 bno값 저장하는 input 태그 생성
	// -> form태그 action 속성 추가 -> form태그 내부 데이터 서버 전송
	var moveForm = $("#moveForm");
	
	$(".move").on("click", function(e) {
		e.preventDefault();
		
		moveForm.append("<input type='hidden' name='bno' value='" + $(this).attr("href") + "'>");
		moveForm.attr("action", "/board/get");
		moveForm.submit();
	});
	
	$(".pageInfo a").on("click", function(e) {
		e.preventDefault();
		
		moveForm.find("input[name='pageNum']").val($(this).attr("href"));
		moveForm.attr("action", "/board/list");
		moveForm.submit();
	});
	
	// 검색 버튼 수행
	// 1.e이벤트로 버튼 기능 정지
	// 2.클라이언트가 작성한 keyword 데이터를 form 태그 내부 name 속성 keyword인 input 태그에 저장
	// 3.form 태그 내부 name이 pageNum인 input에 저장되어 있는 값을 1로 변경 후 서버로 전송
	// 4.pageNum 데이터 변경 이유: 검색 후 1 페이지로 이동 지정
	$(".search_area button").on("click", function(e) {
		e.preventDefault();
		
		var type = $(".search_area select").val();
		var keyword = $(".search_area input[name='keyword']").val();
		
		if (!type) {
			alert("검색 종류를 선택하세요.");
			return false;
		}
		
		if (!keyword) {
			alert("키워드를 입력하세요");
			return false;
		}
		
		if (e.keyCode === 13) {
			e.preventDefault();
			document.getElementById("btn btn-default").click();
		}
		
		moveForm.find("input[name='type']").val(type);
		moveForm.find("input[name='keyword']").val(keyword);
		moveForm.find("input[name='pageNum']").val(1);
		moveForm.submit();
		
	});
	
	
</script>
</body>
</html>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="root" value="${pageContext.request.contextPath}"/>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script	src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<style>
 	input[type="text"]{
 		width:800px;
 		height:100px;
 		placeholder:채팅 내역을 넣어주세요;
 		autofocus:autofocus;
 	}
 	
 	.warnning{
 		color:red;
 	}
 	
 	.inlineclass{
		display:inline;
 	}
</style>
</head>
<body>
<h1>자동 출석 체크 프로그램입니다</h1>
<h2 class="warnning">"[지역_반_이름] 출석" 의 양식을 맞추지 않으면 카운팅 되지 않습니다</h2>
<h3>아래 텍스트박스에 채팅 기록을 넣어주세요</h3>
<form method="post" action="${root}/main.do">
	<div>
		<input type="text" name="input">
		<input type="hidden" name="act" value="do">
	</div>
	<div>
		<br>
		<div>
			<select name="local">
				<option value="all">전체</option>
				<option value="seoul">서울</option>
				<option value="daejeon">대전</option>
				<option value="gumi">구미</option>
				<option value="gwangju">광주</option>
			</select>
			<h4 class="inlineclass">(선택)지역을 골라 보고 싶다면 값을 선택하고 확인버튼을 눌러주세요.(전체보기를 원하신다면 선택안하셔도 됩니다.)</h4>
		</div>
		<br>
		<div>
			<input type="number" min=0 max=20 name="bannum">
			<h4 class="inlineclass">(선택)반을 선택하고 싶다면 숫자를 입력하고 확인버튼을 눌러주세요.(전체보기를 원하신다면 0을 입력하시거나 입력 안하셔도 됩니다.)</h4>
		</div>
	</div>
	<br>
	<div>
		<button type="submit" id="submit" value="">확인</button>
		<button type="reset" value="">비우기</button>
	</div>
</form>
</body>
</html>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%! int cnt = 0; %>
<c:set var="root" value="${pageContext.request.contextPath}"/>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
	div{
		display:inline-block;
	}
	td{
		width:70px;
		padding:3px;
	}
</style>
</head>
<body>
<h1 align="center">결과 페이지 입니다</h1>
<a href="${root}/main.do?act=mvindex">[메인으로 돌아가기]</a>
<c:if test="${local == null}">
<h2>죄송합니다 결과를 찾을 수 없습니다.</h2>
</c:if>
<c:if test="${local != null}">
<h2>결과가 확인되었습니다.</h2>
<% cnt=0; %>
<div class="inlineblockdiv">
<table border="1">
	<c:if test="${local.equals('all') || local.equals('seoul')}">
		<c:forEach var="items" items="${seoul}">
			<c:if test="${bannum == null || bannum.equals('0') || items.ban == Integer.parseInt(bannum)}">
			<tr>
				<td>${items.location}</td>
				<td>${items.ban}반</td>
				<td>${items.name}</td>
			</tr>
			<% cnt++; %>
			</c:if>
		</c:forEach>
	</c:if>
</table>
</div>

<div class="inlineblockdiv">
	<c:if test="${local.equals('all') || local.equals('daejeon')}">
		<table border="1">
			<c:forEach var="items" items="${daejeon}">
			<c:if test="${bannum == null || bannum.equals('0') || items.ban == Integer.parseInt(bannum)}">
				<tr>
					<td>${items.location}</td>
					<td>${items.ban}반</td>
					<td>${items.name}</td>
				</tr>
				<% cnt++; %>
			</c:if>
			</c:forEach>
		</table>
	</c:if>
</div>

<div class="inlineblockdiv">
	<c:if test="${local.equals('all') || local.equals('gumi')}">
		<table border="1">
		<c:forEach var="items" items="${gumi}">
			<c:if test="${bannum == null || bannum.equals('0') || items.ban == Integer.parseInt(bannum)}">
				<tr>
					<td>${items.location}</td>
					<td>${items.ban}반</td>
					<td>${items.name}</td>
				</tr>
				<% cnt++; %>
			</c:if>
		</c:forEach>
		</table>
	</c:if>
</div>

<div class="inlineblockdiv">
	<c:if test="${local.equals('all') || local.equals('gwangju')}">
		<table border="1">
		<c:forEach var="items" items="${gwangju}">
			<c:if test="${bannum == null || bannum.equals('0') || items.ban == Integer.parseInt(bannum)}">
				<tr>
					<td>${items.location}</td>
					<td>${items.ban}반</td>
					<td>${items.name}</td>
				</tr>
				<% cnt++; %>
			</c:if>
		</c:forEach>
		</table>
	</c:if>
</div>
<%=cnt %> 명이 발견되었습니다
</c:if>
</body>
</html>
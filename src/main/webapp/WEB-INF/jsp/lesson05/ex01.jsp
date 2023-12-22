<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>JSTL Core 라이브러리(1)</title>
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/css/bootstrap.min.css" integrity="sha384-xOolHFLEh07PJGoPkLv1IbcEPTNtaed2xpHsD9ESMhqIYd0nLMwNLD69Npy4HI+N" crossorigin="anonymous">
<script src="https://cdn.jsdelivr.net/npm/jquery@3.5.1/dist/jquery.slim.min.js" integrity="sha384-DfXdz2htPH0lsSSs5nCTpuj/zy4C+OGpamoFVy38MVBnE+IbbVYUew+OrCXaRkfj" crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-Fy6S3B9q64WdZWQUiU+q4/2Lc9npb8tCaSX9FK7E8HnRr0Jz8D6OP9dO5Vg3Q9ct" crossorigin="anonymous"></script>

</head>
<body>
	<h1>1. 변수 정의하기 (c:set)</h1>
	<c:set var="number1" value="100" />  <%-- 숫자여도 ""에 감싸야함 --%>
	<c:set var="number2">250</c:set> <%-- 이 방법보다는 위의 value속성에 지정하는 것을 추천 --%>
	number1: ${number1}<br> <%-- x표시 있어도 에러 아님 --%>
	number2: ${number2}<br>
	number1 + number2 : ${number1 + number2} <%--${number1} +  ${number2} 하면  + 기호는 그냥 문자가 됨 실제 연산x --%>
	
	<h2>2. 변수 출력하기 (c:out)</h2>
	<c:out value="Hello world"/><br> <%-- 문장 자체도 출력 가능 --%>
	<c:out value="${number1}"/><br>
	
	<%-- 문자열 escape --%>
	<c:out value="<script>alert('alert창 띄우기')</script>"/><br>
	<c:out value="<script>alert('alert창 띄우기')</script>" escapeXml="true"/><br><%--escapeXml이거 생략하면 걍 true값 --%>
	<c:out value="<script>alert('alert창 띄우기')</script>" escapeXml="false"/><br><%--false하면 ㄹㅇ alert창 뜸 --%>
	
	<h1>3. 조건문(c:if)</h1>
	<c:if test="${number1 >50}" >
		number1은 50보다 크다.<br>
	</c:if>
	
	<c:if test="${number1 == 100}">
		number1은 100이다.<br>
	</c:if>
	
	<c:if test="${number1 eq 100}"> <%-- eq(equal)이 정석 --%>
		number1은 100이다.<br>
	</c:if>
	
	<c:if test="${number1 != 50}"> <%-- ne 가 정석--%>
		number1은 50이 아니다.<br>
	</c:if>
	
	<c:if test="${number1 ne 50}"> <%-- ne 가 정석--%>
		number1은 50이 아니다.<br>
	</c:if>
	
	<c:if test="${empty number1 }">  <%--empty 꼭 기억하기! 많이 쓰임 --%>
		number1은 비어있다.<br>
	</c:if>
	
	<c:if test="${!empty number1 }"> <%--empty 의 반대 --%>
		number1은 비어있지 않다.<br>
	</c:if>
	
	<c:if test="${not empty number1 }"> 
		number1은 비어있지 않다.<br>
	</c:if>
	
</body>
</html>
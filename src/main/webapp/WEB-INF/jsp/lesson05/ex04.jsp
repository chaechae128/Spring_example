<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>JSTL fn 라이브러리</title>
</head>
<body>
	<c:set var="str1" value="No pain. No gain." />
	
	<h1>1. 길이 구하기 fn:length()</h1>
	${fn:length(str1)}<br>
	
	<h1>2. 특정 문자열이 포함되어 있는지 확인 fn:contains()</h1>
	No가 존재하는거? ${fn:contains(str1, "No")}<br>
	no가 존재하는거? ${fn:contains(str1, "no")}<br>
	
	<%-- 대소문자 구별 X contains --%>
	<c:if test="${fn:containsIgnoreCase(str1, 'no')}">
		문장에 no 라는 문자열이 존재한다.(대소문자 구별 안 함)<br>
	</c:if>
	
	<h1>3. 특정 문자열로 시작하는지 확인 fn:startsWith</h1>
	No로 시작하는가? ${fn:startsWith(str1, 'No')}<br>
	
	<h1>4. 특정 문자열로 끝나는지 확인 fn:endsWith</h1>
	n으로 끝나는가? ${fn:endsWith(str1, 'n')}<br>
	.으로 끝나는가? ${fn:endsWith(str1, '.')}<br>
	
	<h1>5. 문자열 치환 fn:replace()</h1>
	<c:set var="str2" value="나는 치킨이 먹고싶다." />
	${str2}<br>
	${fn:replace(str2, "치킨", "마라탕")}
	
	<h1>6. 구분자로 잘라서 배열 만들기 fn:split()</h1>
	${fn:split(str1, '.')[0]}<br> <%--자바에서 .을 사용하려면 역슬래시 \\ 이걸 붙여야함!! --%>
	${fn:split(str1, '.')[1]}<br> <%--no gain --%>
	
	<h1>7. 시작 인덱스부터 종료 인덱스까지 문자열 추출 fn:substring()</h1>
	<%--str2에서 치킨 추출 --%>
	${fn:substring(str2, 3, 5)}
	
	<h1>8. 모두 소문자로 변경 fn:tolowerCase()</h1>
	${fn:toLowerCase(str1)}
	
	<h1>9. 모두 대문자로 변경 fn:toUpperCase()</h1>
	${fn:toUpperCase(str1)}
	
	<h1>10. 앞 뒤 공백 제거 fn:trim()</h1>
	<c:set var="str3" value="   h  e ll     o     " />
	<pre>${str3}</pre>  <%--여백이 사라지지않고 그대로 나타남 --%>
	<pre>${fn:trim(str3)}</pre>
</body>
</html>
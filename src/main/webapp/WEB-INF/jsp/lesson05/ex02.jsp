<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>JSTL Core 라이브러리(2)</title>
</head>
<body>
	<h1>1. 조건문(c:choose, c:when, c:otherwise)</h1>
	<%--choose  when-if, elseif otherwise-else --%>
	<c:set var="weight" value="85"/>
	
	<c:choose>
		<c:when test="${weight < 60}">
			치맥 먹자!<br>
		</c:when>
		<%-- 60이상 ~ 70 미만 --%>
		<c:when test="${weight < 70}">
			샐러드 먹자! <br>
		</c:when>
		<%-- 70 이상 --%>
		<c:otherwise>
			굶자!<br>
		</c:otherwise>
	</c:choose>
	
	<h1>2. 반복문 (c:forEach)</h1>
	<%-- begin-초기값  end-끝값(포함) step-몇씩 var-i같은 느낌 varStatus-상태에 대한 정보--%>
	<%-- varStatus-상태에 대한 정보
		*current : 현재 값
		*first :  이 반복문이 첫번째로 도는 것인가?
		*last: 이 반복문이 마지막번째 인가?
		*index: 숫자로 돌릴때 current랑 같고 list로 돌릴때 0부터 출력
		*coun: 반복문의 횟수
	 --%>
	<c:forEach begin="0" end="5" step="1" var="i">
		${i} <br>
	</c:forEach>
	
	<%-- 16~ 20: 5번 --%>
	<c:forEach begin="16" end="20" step="1" var="i" varStatus="status">
		var: ${i} 
		current: ${status.current}
		first :  ${status.first}
		last : ${status.last }
		index: ${status.index}
		count: ${status.count}
		<br>
	</c:forEach>
	
	${fruits} <br>
	
	<%-- 서버에서 가져온 List<String>출력 --%>
	<%-- items에는 모델에 있는 데이터를 담음 ${}로 담아야 쓸 수 있음
	이걸 var에다 담아야함  ★★★items와 var이름은 달라야 함!!!!★★★--%>
	<c:forEach items="${fruits}" var="fruit" varStatus="status">
		 ${fruit} ::: index:${status.index}  <%--리스트를 꺼낼 때는 index 0부터 시작 --%>
		 ${fruit} ::: index:${status.count} <%--반복문의 횟수이기에 1부터 시작 --%>
		 <br>
	</c:forEach>
	
	<%-- 서버에서 가져온 List<Map> 테이블 출력 --%>
	<table border="1">
		<thead>
			<tr>
				<th>번호</th>
				<th>이름</th>
				<th>나이</th>
			</tr>
		</thead>
		<tbody>
			
			<c:forEach items="${users}" var="user" varStatus="status">
				<tr>
					<td>${status.count}</td>
					<td>${user.name}</td>
					<td>${user.age}</td>
				</tr>				
			</c:forEach>
			
		</tbody>
	</table>
	
	
</body>
</html>
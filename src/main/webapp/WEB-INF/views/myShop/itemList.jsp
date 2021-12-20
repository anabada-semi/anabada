<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>


<div>
	상품 <span id="itemText">0</span>
</div>

<hr>
<table>
	<tr><td></td><td></td><td></td><td></td></tr>
	<c:forEach var="s" items="${itemList}" varStatus="i">
		<c:set var="idx" value="${i.index/4}"></c:set>
		<c:set var="trIdx" value="${i.index}"></c:set>
<%-- 		<h1>${s.itemName}</h1>
		<h1>${i.last }</h1> --%>
		
		
 		<c:if test="${i.index % 4 == 0}">
			<tr class="itemTr">
				<c:forEach var="d" items="${itemList}" varStatus="j">
					<c:if test="${j.index < i.index && j.index >= i.index-4}">
						<td class="itemTd">
							<img class="itemImg" src="${contextPath}/resources/images/myShop/itemList/신발.jpg">
							<div class="itemTextDiv">
								<div class="itemText1">${d.itemName}</div>
								<div class="itemText2">${d.itemPrice}원</div>
								<div class="itemText3">${d.uploadDate}</div>
							</div>
						</td>
					</c:if>
				</c:forEach>
			</tr>
		</c:if>
	</c:forEach>
	
	<tr class="itemTr">
		<c:forEach var="s" items="${itemList}" varStatus="i">
			<c:if test="${ i.index > trIdx - (idx - (idx%1)) }">
				<td class="itemTd">
					<img class="itemImg" src="${contextPath}/resources/images/myShop/itemList/신발.jpg">
					<div class="itemTextDiv">
						<div class="itemText1">${s.itemName}</div>
						<div class="itemText2">${s.itemPrice}원</div>
						<div class="itemText3">${s.uploadDate}</div>
					</div>
				</td>
			</c:if>
		</c:forEach>
	</tr>
</table>


<!-- 5개 기능 중 표시할 내역 없을 시 이걸로 하면 됨 -->
<!-- <div style="display: contents;">
	상품 <span>0</span>
</div>
<div style="float: right;">
	<select
		style="width: 150px; text-align-last: center; float: right; height: 25px; border: 0.3px solid #ccc">
		<option>전체</option>
	</select>
</div>

<hr>

<div>
	<span>등록된 상품이 없습니다.</span>
</div>
 -->
 
 <script>
 	(function(){
		$("#itemText").text($(".itemTd").length);
	}());
 	
 	$(".itemTd").on("click", function(){
 		(function(){
			$("#itemText").text($(".itemTd").length);
		}());
 	});
 </script>


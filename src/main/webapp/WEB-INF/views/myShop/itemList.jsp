<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>


<div>
	상품 <span id="itemText">0</span>
</div>

<hr>

<table>
	<tr><td></td><td></td><td></td><td></td></tr>
	<tr class="itemTr">
		<td class="itemTd">
			<img class="itemImg" src="${contextPath}/resources/images/myShop/itemList/신발.jpg">
			<div class="itemTextDiv">
				<div class="itemText1">운동화 팔아요~</div>
				<div class="itemText2">40,000원</div>
				<div class="itemText3">10분 전</div>
			</div>
		</td>
		<td class="itemTd">
			<img class="itemImg" src="${contextPath}/resources/images/myShop/itemList/핸드폰.jpg">
			<div class="itemTextDiv">
				<div class="itemText1">핸드폰 팔아요</div>
				<div class="itemText2">200,000원</div>
				<div class="itemText3">3일 전</div>
			</div>
		</td>
		<td class="itemTd">
			<img class="itemImg" src="${contextPath}/resources/images/myShop/itemList/셔츠.jpg">
			<div class="itemTextDiv">
				<div class="itemText1">셔츠</div>
				<div class="itemText2">20,000원</div>
				<div class="itemText3">4달 전</div>
			</div>
		</td>
		<td class="itemTd">
			<img class="itemImg" src="${contextPath}/resources/images/myShop/itemList/셔츠_남.jpg">
			<div class="itemTextDiv">
				<div class="itemText1">셔츠</div>
				<div class="itemText2">20,000원</div>
				<div class="itemText3">4달 전</div>
			</div>
		</td>
	</tr>
	
	<tr class="itemTr">
		<td class="itemTd">
			<img class="itemImg" src="${contextPath}/resources/images/myShop/itemList/배찌.jpg">
			<div class="itemTextDiv">
				<div class="itemText1">배찌 인형 팜</div>
				<div class="itemText2">40,000,000원</div>
				<div class="itemText3">3년 전</div>
			</div>
		</td>
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


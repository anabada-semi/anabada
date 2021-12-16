<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
	
<link rel="stylesheet" href="${contextPath}/resources/css/myShop/myShop.css">

<jsp:include page="../header.jsp" />

<section>
	<div class="container">
		<div id="div" class="head1-1">
			<div class="head1">
				<div id="h1">
					<div>
						<img id="img"
							src="data:image/jpeg;base64,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">
						<div style="text-align: center;">
							<span id="userName123">userName</span>
						</div>
						<img
							src="data:image/png;base64,iVBORw0KGgoAAAANSUhEUgAAAB4AAAAcCAYAAAB2+A+pAAAAAXNSR0IArs4c6QAAAqNJREFUSA2tVk1rE0EYzrYbSKQXRYIfCaUiggaJJiH+AIsnL1poRQ+CBy8VvOivUA8evHgoeNCbRz3pH5B8HlIvYpG0VULxJBqMZn2eZWc7O5nZ7I5deJl33vf5yMzsTpvJWD6tVussw5KembMlgnc9CCsJa2PP81YYVq4gOTbEXq+3NB6PP5ObzWZPVSqVrbQ6ViuGKbfZf+Rc1JKMVsaO44RbLOdJDAUm9Va32+0TONtthM+FsYcoVqvVXSGaZEy9YhheE6Y0YM5aEjMZk9oY5PB8JSFdTWpPp6m2utlsHoXEN8S8IvUX82P1en1PqRunbrfbvYitOmRESI3JZLIMrGpKxDzOeb3T6byT4MYU2J8Orz2IvQLqghF5sI0ujG/O1Wq1j/l8/hImjxHewXrsq1GbHvSiZ+SM8alcxupfIE7uU/4/g+EO4jY+ufdCLWLMYr/fPzIajZ7DPLwkBNhmhOHrXC53t1wuf5f5U8aiidXfgflTxIKopRlh+ANxH6vc0PGMxgTjxTsN45dIGzpyTO0DTG/hLD+ZMLHGJMHYxep7GM+ZROQ6DDexygrGP3JdzWfeXPg2D8P0jEo0zYklx9QX9ZnGAPIlcwUhwUjszBdzpjFWcCOBWQSShBN7xribj+Os+Cdw6gei7l+P6C1HXDFBb4J6EXf3V7Un5lOCohGMq6opRH+j9wAv0BUG86AWUgPOaljQJLHGEFyTOZhvIhpYyROMvAK9IG+wp2AjXLnH3LjV+IQW8cu3ED4Gws8KhcLDUqn0SxXhfDAY5IfD4SPg1zkPftgSduUL5+pjXDEEuM3gO0OQruIyuGcypSh7xBBLDrnUYE/3xBnzbX7ruu55bOcbHVlXI5YccmGc7ovA/81FXJf+lunEk9aoQS0d/h/pAwlu3rYpxwAAAABJRU5ErkJggg=="
							width="15" height="14" alt="작은 별점 0점 이미지"> <img
							src="data:image/png;base64,iVBORw0KGgoAAAANSUhEUgAAAB4AAAAcCAYAAAB2+A+pAAAAAXNSR0IArs4c6QAAArVJREFUSA2tVs1rE0EUf28TWr8uBQU/AqLGhAh+QWhrTECwePJiC1r0IHit4MU/Qw8evAoe9OZRTwqCNVEpaC+Wpqle4gfiURobdvN8b9JdZ7a7k822C8u++b3fx87sZFqAlBc1jpfkTikHJ60Qer1pdac0SB9MOANyp7wwjY7eF49Q1/0iWhzJHsWJ5a/D+qSbcdedDoL0OgAHF+mCUVtivR6cFzCGXmqaLx4EcNtEoLSIQADZHFaXvweuCYrhZ0zeFT9U/FXNWIIsgzJ8MNL/7+tbRWF+L+Y51FLTQmEvdLyfvLYZ3Y9NPNiZ2Y/l5m8dt9VZqufPAmZ22UhBb92bCodKTzBc781Ro/gy4NoK8tZQHXsePSWiMzbudvUQ8RO/5nUHz60swdjoBKJzr79DtyvC9BFvyVBZnGl8Y6oXLvL5+5hnf8iUbW3Es/wGjnMTK81XvpOxq1XDGT3FxGc+YatP5SWeWqh4GjPWQ+hN/haPHxDQHh1PWiPgH+bewVrrUZQmNljIVD+WBw+fcPh4lDgO49APkKEbWFltxXPiOhs40YUszLcXOfzEAKpqc+hnqOZOI752bXzjG0cSP7bHGC9E9qLBAvQ10d0NdHDwGs7wbLNWF62puKzRoMhycDDRbKTSBibQ2DfXQukA/O3Kn8BNL8hCdTzycTkVfgc+LHqwYySH5aUf4Z4/3mToN9Sz414Nh/Lvssuhd6HauiS31ILpOqVhrY6Fa3sw0jVdoHYsOeNYW73PYXwE8s01CCa7Wb9CWr0ldWwwvS0d5l/ypC/gkIeQ2VfGWnPRx/ynwqQnnOCiyb5HABhFbDCQWmb2gl/oOJex2rqNlUbHUGsD6SmOcFnT/88kfrktwTTLBi8Ad5/E8yvPtQxrqbiiEW2C3W2Y0bt8js/qOQNMMRAP8YqS/gMbzegG1X8tjgAAAABJRU5ErkJggg=="
							width="15" height="14" alt="작은 별점 2점 이미지"> <img
							src="data:image/png;base64,iVBORw0KGgoAAAANSUhEUgAAAB4AAAAcCAYAAAB2+A+pAAAAAXNSR0IArs4c6QAAArVJREFUSA2tVs1rE0EUf28TWr8uBQU/AqLGhAh+QWhrTECwePJiC1r0IHit4MU/Qw8evAoe9OZRTwqCNVEpaC+Wpqle4gfiURobdvN8b9JdZ7a7k822C8u++b3fx87sZFqAlBc1jpfkTikHJ60Qer1pdac0SB9MOANyp7wwjY7eF49Q1/0iWhzJHsWJ5a/D+qSbcdedDoL0OgAHF+mCUVtivR6cFzCGXmqaLx4EcNtEoLSIQADZHFaXvweuCYrhZ0zeFT9U/FXNWIIsgzJ8MNL/7+tbRWF+L+Y51FLTQmEvdLyfvLYZ3Y9NPNiZ2Y/l5m8dt9VZqufPAmZ22UhBb92bCodKTzBc781Ro/gy4NoK8tZQHXsePSWiMzbudvUQ8RO/5nUHz60swdjoBKJzr79DtyvC9BFvyVBZnGl8Y6oXLvL5+5hnf8iUbW3Es/wGjnMTK81XvpOxq1XDGT3FxGc+YatP5SWeWqh4GjPWQ+hN/haPHxDQHh1PWiPgH+bewVrrUZQmNljIVD+WBw+fcPh4lDgO49APkKEbWFltxXPiOhs40YUszLcXOfzEAKpqc+hnqOZOI752bXzjG0cSP7bHGC9E9qLBAvQ10d0NdHDwGs7wbLNWF62puKzRoMhycDDRbKTSBibQ2DfXQukA/O3Kn8BNL8hCdTzycTkVfgc+LHqwYySH5aUf4Z4/3mToN9Sz414Nh/Lvssuhd6HauiS31ILpOqVhrY6Fa3sw0jVdoHYsOeNYW73PYXwE8s01CCa7Wb9CWr0ldWwwvS0d5l/ypC/gkIeQ2VfGWnPRx/ynwqQnnOCiyb5HABhFbDCQWmb2gl/oOJex2rqNlUbHUGsD6SmOcFnT/88kfrktwTTLBi8Ad5/E8yvPtQxrqbiiEW2C3W2Y0bt8js/qOQNMMRAP8YqS/gMbzegG1X8tjgAAAABJRU5ErkJggg=="
							width="15" height="14" alt="작은 별점 2점 이미지"> <img
							src="data:image/png;base64,iVBORw0KGgoAAAANSUhEUgAAAB4AAAAcCAYAAAB2+A+pAAAAAXNSR0IArs4c6QAAArVJREFUSA2tVs1rE0EUf28TWr8uBQU/AqLGhAh+QWhrTECwePJiC1r0IHit4MU/Qw8evAoe9OZRTwqCNVEpaC+Wpqle4gfiURobdvN8b9JdZ7a7k822C8u++b3fx87sZFqAlBc1jpfkTikHJ60Qer1pdac0SB9MOANyp7wwjY7eF49Q1/0iWhzJHsWJ5a/D+qSbcdedDoL0OgAHF+mCUVtivR6cFzCGXmqaLx4EcNtEoLSIQADZHFaXvweuCYrhZ0zeFT9U/FXNWIIsgzJ8MNL/7+tbRWF+L+Y51FLTQmEvdLyfvLYZ3Y9NPNiZ2Y/l5m8dt9VZqufPAmZ22UhBb92bCodKTzBc781Ro/gy4NoK8tZQHXsePSWiMzbudvUQ8RO/5nUHz60swdjoBKJzr79DtyvC9BFvyVBZnGl8Y6oXLvL5+5hnf8iUbW3Es/wGjnMTK81XvpOxq1XDGT3FxGc+YatP5SWeWqh4GjPWQ+hN/haPHxDQHh1PWiPgH+bewVrrUZQmNljIVD+WBw+fcPh4lDgO49APkKEbWFltxXPiOhs40YUszLcXOfzEAKpqc+hnqOZOI752bXzjG0cSP7bHGC9E9qLBAvQ10d0NdHDwGs7wbLNWF62puKzRoMhycDDRbKTSBibQ2DfXQukA/O3Kn8BNL8hCdTzycTkVfgc+LHqwYySH5aUf4Z4/3mToN9Sz414Nh/Lvssuhd6HauiS31ILpOqVhrY6Fa3sw0jVdoHYsOeNYW73PYXwE8s01CCa7Wb9CWr0ldWwwvS0d5l/ypC/gkIeQ2VfGWnPRx/ynwqQnnOCiyb5HABhFbDCQWmb2gl/oOJex2rqNlUbHUGsD6SmOcFnT/88kfrktwTTLBi8Ad5/E8yvPtQxrqbiiEW2C3W2Y0bt8js/qOQNMMRAP8YqS/gMbzegG1X8tjgAAAABJRU5ErkJggg=="
							width="15" height="14" alt="작은 별점 2점 이미지"> <img
							src="data:image/png;base64,iVBORw0KGgoAAAANSUhEUgAAAB4AAAAcCAYAAAB2+A+pAAAAAXNSR0IArs4c6QAAArVJREFUSA2tVs1rE0EUf28TWr8uBQU/AqLGhAh+QWhrTECwePJiC1r0IHit4MU/Qw8evAoe9OZRTwqCNVEpaC+Wpqle4gfiURobdvN8b9JdZ7a7k822C8u++b3fx87sZFqAlBc1jpfkTikHJ60Qer1pdac0SB9MOANyp7wwjY7eF49Q1/0iWhzJHsWJ5a/D+qSbcdedDoL0OgAHF+mCUVtivR6cFzCGXmqaLx4EcNtEoLSIQADZHFaXvweuCYrhZ0zeFT9U/FXNWIIsgzJ8MNL/7+tbRWF+L+Y51FLTQmEvdLyfvLYZ3Y9NPNiZ2Y/l5m8dt9VZqufPAmZ22UhBb92bCodKTzBc781Ro/gy4NoK8tZQHXsePSWiMzbudvUQ8RO/5nUHz60swdjoBKJzr79DtyvC9BFvyVBZnGl8Y6oXLvL5+5hnf8iUbW3Es/wGjnMTK81XvpOxq1XDGT3FxGc+YatP5SWeWqh4GjPWQ+hN/haPHxDQHh1PWiPgH+bewVrrUZQmNljIVD+WBw+fcPh4lDgO49APkKEbWFltxXPiOhs40YUszLcXOfzEAKpqc+hnqOZOI752bXzjG0cSP7bHGC9E9qLBAvQ10d0NdHDwGs7wbLNWF62puKzRoMhycDDRbKTSBibQ2DfXQukA/O3Kn8BNL8hCdTzycTkVfgc+LHqwYySH5aUf4Z4/3mToN9Sz414Nh/Lvssuhd6HauiS31ILpOqVhrY6Fa3sw0jVdoHYsOeNYW73PYXwE8s01CCa7Wb9CWr0ldWwwvS0d5l/ypC/gkIeQ2VfGWnPRx/ynwqQnnOCiyb5HABhFbDCQWmb2gl/oOJex2rqNlUbHUGsD6SmOcFnT/88kfrktwTTLBi8Ad5/E8yvPtQxrqbiiEW2C3W2Y0bt8js/qOQNMMRAP8YqS/gMbzegG1X8tjgAAAABJRU5ErkJggg=="
							width="15" height="14" alt="작은 별점 2점 이미지">
						<div style="text-align: center;">내 상점 관리</div>
					</div>
				</div>
			</div>


			<div class="head2">
				<div id="h2">
					<div id="save" style="padding-bottom: 30px;">
						<span id="userNameCng">userName</span>
						<button class="shopNameBtn">상점명 수정</button>
					</div>

					<div>

						<div id="myShopContent" style="font-weight: lighter;">청춘! 이는 듣기만 하여도 가슴이 설레는 말이다 청춘! 너의 두손을 가슴에 대고 물방아 같은 심장의 고동을 들어 보라 청춘의 피는 끓는다 끓는 피에 뛰노는 심장은 거선의 기관과 같이 힘있다 이것이다 인류의 역사를(소개글)</div>
						<div id="myShopContent1">
							<div id="myShopContent2" style="padding: 0px 10px 0px 10px; font-weight: lighter; border: 0.3px solid #ccc; font-size: 12px; display: inline-block;">소개글 수정</div>			
						</div>
					</div>
				</div>

			</div>
		</div>
	</div>

	
	<div class="container">
		<div id="div">
			<div class="btn active" onclick="location.href='${contextPath}/myShop/itemList';">
				<span>상품</span>
			</div>
			<div class="btn" onclick="location.href='${contextPath}/myShop/wishList';">
				<span>찜 목록</span>
			</div>
			<div class="btn" onclick="location.href='${contextPath}/myShop/postScript';">
				<span>상점후기</span>
			</div>
			<div class="btn" onclick="location.href='${contextPath}/myShop/buyList';">
				<span>구매내역</span>
			</div>
			<div class="btn" onclick="location.href='${contextPath}/myShop/sellList';">
				<span>판매내역</span>
			</div>
		</div>
	</div>
	
	<br>
	<br>
	
	<div class="container" id="con-1">
		<div id="changeDiv">
 			<div id="div">
				<div style="width: 50%">
					상품 <span>0</span>
				</div>
				<div style="width: 50%">
					<select
						style="width: 150px; text-align-last: center; float: right; height: 25px; border: 0.3px solid #ccc">
						<option>전체</option>
					</select>
				</div>
			</div>

			<hr>

			<div>
				<span>등록된 상품이 없습니다.</span>
			</div> 
			
		</div>
	</div>
</section>

<jsp:include page="../footer.jsp" />


<script src="${contextPath}/resources/js/myShop/myShop.js"></script>


	
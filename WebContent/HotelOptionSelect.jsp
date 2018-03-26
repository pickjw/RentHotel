<%@page import="db.HotelRoomListDTO"%>
<%@page import="db.HotelDAO"%>
<%@page import="java.util.Date"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>

<body>

		<%
		
			int no = Integer.parseInt(request.getParameter("no"));
			
			//이미지
			String img = request.getParameter("img");
	
			//데이터베이스에 접근
			HotelDAO hdao = new HotelDAO();
			//호텔룸에 1개에 대한 정보를 얻어옴
			HotelRoomListDTO dto = hdao.getOneHotel(no);
	
			//카테고리 분류값을 받아옴
			int category = dto.getCategory();
			String temp = "";
			if (category == 1)
				temp = "스탠다드룸 (Standard Room)";
			else if (category == 2)
				temp = "슈페리어룸 (Superior Room)";
			else if (category == 3)
				temp = " 딜럭스룸 (Deluxe Room)";
			else if (category == 4)
				temp = " 이그제큐티브룸 (Executive Room)";
			else if (category == 5)
				temp = " 스위트룸 (Suite Room)";
		
		%>
	
		<center>
		<form action="HotelMain.jsp?center=HotelReserveResult.jsp" method="post">
			<table width="100%">

				<tr height="100">
					<td colspan="3" align="center"><font size="6" color="white">INFORMATION&nbsp;<%=dto.getName()%></font>
					</td>
				</tr>

				<tr>
					<td rowspan="6" width="600"><img alt=""
						src="img/<%=dto.getImg()%>" width="550"></td>
					<td width="250" align="center"><font size="3" color="white">등급</font></td>
					<td width="250" align="center"><font size="3" color="white"><%=temp%></font></td>
				</tr>

				<tr>
				<tr>
					<td width="250" align="center"><font size="3" color="white">가격</font></td>
					<td width="250" align="center"><font size="3" color="white">&#8361;&nbsp;<%=dto.getPrice()%>&nbsp;원
					</font></td>
				</tr>

				<tr>
					<td width="250" align="center"><font size="3" color="white">기간</font></td>
					<td width="250" align="center"><select name="dday">
							<option value="1">1일</option>
							<option value="2">2일</option>
							<option value="3">3일</option>
							<option value="4">4일</option>
							<option value="5">5일</option>
							<option value="6">6일</option>
							<option value="7">7일</option>
							<option value="8">2주</option>
							<option value="9">3주</option>
							<option value="10">1달</option>
					</select></td>
				</tr>

				<tr>
					<td width="250" align="center"><font size="3" color="white">날짜</font>
					</td>
					<td width="250" align="center"><input type="date" name="rday"
						size="15"></td>
				</tr>

				<tr>
					<td width="250" align="center"><font size="3" color="white">조식</font>
					</td>
					<td width="250" align="center"><select name="useblackfast">
							<option value="11">비적용</option>
							<option value="1">적용(1일 1만원)</option>
							<option value="2">적용(2일 2만원)</option>
							<option value="3">적용(3일 3만원)</option>
							<option value="4">적용(4일 4만원)</option>
							<option value="5">적용(5일 5만원)</option>
							<option value="6">적용(6일 6만원)</option>
							<option value="7">적용(7일 7만원)</option>
							<option value="8">적용(2주 14만원)</option>
							<option value="9">적용(3주 21만원)</option>
							<option value="10">적용(1달 30만원)</option>
					</select></td>
				</tr>

			</table>
			<br>
			<br>
			<br> <font size="4" color="white"><%=dto.getInfo()%></font> <br>
			<div style="height: auto; width: 200px; margin: 50px 0px 0px 0px;">
				<ul>
					<li>
						<input type="hidden" name="no" value="<%= no %>">
						<input type="submit" value="예약하기"
						style="font-size: 15pt; height: 50px; width: 150px;">
					</li>
				</ul>
			</div>
			<br>
			<br>
		</form>
	</center>
</body>
</html>
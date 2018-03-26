<%@page import="db.HotelDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<%
		String id = request.getParameter("id");
		String rday = request.getParameter("rday");
		
		
		HotelDAO hdao = new HotelDAO();
		//예약삭제 메소드 호출
		hdao.hotelRemoveReserve(id, rday);
		
		response.sendRedirect("HotelMain.jsp");
	%>
<body>

</body>
</html>
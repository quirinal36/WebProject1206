<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@page import="www.jcc.com.control.BoardControl"%>
<%@page import="www.jcc.com.vo.Board"%>
<%
	// 1. 파라미터 받아와 문자열->숫자 변환하기
	String strId = request.getParameter("id");
	int id = Integer.parseInt(strId);
	
	// 2. board 객체 만들어, id 값을 지정하기
	Board board = new Board();
	board.setId(id);
	
	// 3. deleteBoard() 메소드에 board 객체 전달하기
	BoardControl control = new BoardControl();
	int result = control.deleteBoard(board);
%>
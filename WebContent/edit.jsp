<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@page import="www.jcc.com.control.BoardControl"%>
<%@page import="www.jcc.com.vo.Board"%>
<%
	String title = request.getParameter("title");
	String writer = request.getParameter("writer");
	String content = request.getParameter("content");
	
	Board board = new Board();
	board.setTitle(title);
	board.setWriter(writer);
	board.setContent(content);
	
	BoardControl control = new BoardControl();
	int result = control.updateBoard(board);
	
	out.print("result: " + result);	
%>
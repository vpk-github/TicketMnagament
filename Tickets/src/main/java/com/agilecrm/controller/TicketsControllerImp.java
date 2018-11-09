package com.agilecrm.controller;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.agilecrm.service.TicketsServiceImp;
import com.agilecrm.ticket.Ticket;
import com.fasterxml.jackson.databind.ObjectMapper;

public class TicketsControllerImp extends HttpServlet
{
	private static final long serialVersionUID = 1L;

	@Override
	 protected void doPost( HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	 {
		System.out.println("I am in DoPost method");
		
		Ticket ticket = new Ticket();
		
		//ticket.setId(Integer.parseInt(request.getParameter("id")));
		ticket.setName(request.getParameter("name"));
		ticket.setEmail(request.getParameter("email"));
		ticket.setProblemType(request.getParameter("problemType"));
		ticket.setProblemDescription(request.getParameter("problemDescription"));
		ticket.setGroup(request.getParameter("groupedIn"));
		ticket.setAssigne(request.getParameter("assignedTo"));
		ticket.setStatus(Boolean.parseBoolean(request.getParameter("status")));
		 
		TicketsServiceImp service = new TicketsServiceImp();
/*		
		ObjectMapper mapper = new ObjectMapper();
		byte[] jsonData = Files.readAllBytes(Paths.get("/home/agile/Documents/jsonData.txt"));
		Ticket ticket2 = mapper.readValue(jsonData, Ticket.class);
		
		System.out.println(ticket2.toString());

		try 
		{
			service.addTicket(ticket2);

		}
		catch (SQLException e) 
		{
			e.printStackTrace();
		}
*/
		
/*
		try 
		{
			service.updateTicket(ticket.getId(), ticket.getGroup(),ticket.getAssigne(),ticket.getStatus());
		
		} 
		catch (SQLException e) 
		{
			e.printStackTrace();
		}*/
		
		
		/*Ticket ticket3 = new Ticket();
		try 
		{
			ticket3 = service.getTicket(ticket.getId());
		} 
		catch (SQLException e) 
		{
			e.printStackTrace();
		}
		
		System.out.println(ticket3.toString());
		*/
		
		/*try 
		{
			service.deleteTicket(ticket.getId());
		}
		catch (SQLException e) 
		{
			e.printStackTrace();
		}*/
		
		try
		{
			service.channgeStatus(ticket.getId());
		}
		catch (SQLException e) 
		{
			e.printStackTrace();
		}
	 }
	
	 
	 @Override
	 protected void doGet( HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	 {
		
	 }
	
	 
}

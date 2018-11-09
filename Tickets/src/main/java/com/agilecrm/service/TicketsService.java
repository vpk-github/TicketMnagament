package com.agilecrm.service;

import java.sql.SQLException;

import com.agilecrm.ticket.Ticket;

public interface TicketsService
{
	void addTicket(Ticket ticket) throws SQLException;
	void updateTicket(int id, String s1, String s2,String s3) throws SQLException;
	Ticket getTicket(int id) throws SQLException;
	void deleteTicket(int id) throws SQLException;
	void channgeStatus(int id) throws SQLException;
}

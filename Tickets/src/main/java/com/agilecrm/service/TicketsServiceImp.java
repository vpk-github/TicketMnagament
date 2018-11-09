package com.agilecrm.service;

import java.sql.SQLException;

import com.agilecrm.dao.TicketsDao;
import com.agilecrm.dao.TicketsDaoImp;
import com.agilecrm.ticket.Ticket;

public class TicketsServiceImp implements TicketsService
{
	TicketsDao daoImp;

	public  TicketsServiceImp()
	{
		daoImp = new TicketsDaoImp();
	}
	public void addTicket(Ticket ticket) throws SQLException
	{
		daoImp.addTicket(ticket);
	}

	public void updateTicket(int id, String s1,String s2,String s3) throws SQLException
	{
		daoImp.updateTicket(id, s1, s2, s3);
	}

	public Ticket getTicket(int id) throws SQLException
	{
		return daoImp.getTicket(id);
	}

	public void deleteTicket(int id) throws SQLException
	{
		daoImp.deleteTicket(id);
	}
	@Override
	public void channgeStatus(int id) throws SQLException
	{
		daoImp.changeStatus(id);
	}

}

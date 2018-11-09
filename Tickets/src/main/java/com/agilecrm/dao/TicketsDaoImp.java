package com.agilecrm.dao;

import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.agilecrm.service.TicketsService;
import com.agilecrm.ticket.Ticket;
import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;

public class TicketsDaoImp implements TicketsDao
{
	private static final String DB_DRIVER = "com.mysql.jdbc.Driver";
	private static final String DB_CCONNECTION = "jdbc:mysql://localhost:3306/agile_crm";
	private static final String DB_USER = "root";
	private static final String DB_PASSWORD = "root123";

	
	public void addTicket(Ticket ticket) throws SQLException 
	{
		String sql = "INSERT INTO tickets (name, email, problemType, problemDescription, groupedIn, assignedTo,status) VALUES(?,?,?,?,?,?,?)";
		Connection conn = null;
		PreparedStatement pstmt = null;
		
		try  
		{
			conn = getDBConnection();
			pstmt = (PreparedStatement) conn.prepareStatement(sql);
			
		    pstmt.setString(1,ticket.getName());
		    pstmt.setString(2,ticket.getEmail());
		    pstmt.setString(3,ticket.getProblemType());
		    pstmt.setString(4,ticket.getProblemDescription());
		    pstmt.setString(5,ticket.getGroup());
		    pstmt.setString(6,ticket.getAssigne());
		    pstmt.setBoolean(7,ticket.getStatus());
		    	
			pstmt.executeUpdate();
		} 
		catch (SQLException e) 
		{
			System.out.println(e.getMessage());
		}
		finally 
		{
			if (pstmt != null) 
				pstmt.close();	

			if (conn != null) 
			{
				conn.close();
			}
		}
	
	}

	@Override
	public void updateTicket(int id, String s1, String s2, String s3) throws SQLException
	{
		PreparedStatement preparedStatement = null;
		Connection dbConnection = null;
		String updateTableSQL = "UPDATE tickets SET groupedIn =?, assignedTo = ?, status =?  WHERE id = ?";
		int result = -1;
		try 
		{
			dbConnection = getDBConnection();
			preparedStatement = (PreparedStatement) dbConnection.prepareStatement(updateTableSQL);

			System.out.println(s1);
			System.out.println(s2);
			System.out.println(s3);
			System.out.println(id);
			
			preparedStatement.setString(1, s1);
			preparedStatement.setString(2 ,s2);
			preparedStatement.setString(3, s3);
			preparedStatement.setInt(4, id);
			
			result = preparedStatement.executeUpdate();
			System.out.println("result: "+result);
						
		} 
  
		catch (SQLException e) 
		{
				System.out.println(e.getMessage());
		}
		
		finally
		{

			if (preparedStatement != null) 
			{
				preparedStatement.close();
			}

			if (dbConnection != null) 
			{
				dbConnection.close();
			}
		}
	
	}

	public Ticket getTicket(int id) throws SQLException 
	{
		PreparedStatement preparedStatement = null;
		Connection dbConnection = null;
		String updateTableSQL = "SELECT * from tickets where id = ?";
		Ticket ticket = new Ticket();
		int result = -1;
		try 
		{
			dbConnection = getDBConnection();
			preparedStatement = (PreparedStatement) dbConnection.prepareStatement(updateTableSQL);
			
			preparedStatement.setInt(1, id);
			
			ResultSet rs = preparedStatement.executeQuery();
			
			while(rs.next())
			{
				ticket.setId(Integer.parseInt(rs.getString("id")));
				ticket.setName(rs.getString("name"));
				ticket.setEmail(rs.getString("email"));
				ticket.setProblemType(rs.getString("problemType"));
				ticket.setProblemDescription(rs.getString("problemDescription"));
				ticket.setGroup(rs.getString("groupedIn"));
				ticket.setAssigne(rs.getString("assignedTo"));
				ticket.setStatus(rs.getBoolean("status"));	
			}
						
		} 
  
		catch (SQLException e) 
		{
				System.out.println(e.getMessage());
		}
		
		finally
		{

			if (preparedStatement != null) 
			{
				preparedStatement.close();
			}

			if (dbConnection != null) 
			{
				dbConnection.close();
			}
		}
	
	
		return ticket;
	}

	public void deleteTicket(int id) throws SQLException 
	{
		PreparedStatement preparedStatement = null;
		Connection dbConnection = null;
		String updateTableSQL = "DELETE from tickets where id = ?";
		
		try 
		{
			dbConnection = getDBConnection();
			preparedStatement = (PreparedStatement) dbConnection.prepareStatement(updateTableSQL);
			
			preparedStatement.setInt(1, id);
			
			preparedStatement.executeUpdate();
								
		} 
  
		catch (SQLException e) 
		{
				System.out.println(e.getMessage());
		}

		finally
		{

			if (preparedStatement != null) 
			{
				preparedStatement.close();
			}

			if (dbConnection != null) 
			{
				dbConnection.close();
			}
		}		
	}
	
	@Override
	public void changeStatus(int id) throws SQLException 
	{
		PreparedStatement preparedStatement = null;
		Connection dbConnection = null;
		String updateTableSQL = "UPDATE tickets SET status=? where id = ?";
		
		try 
		{
			dbConnection = getDBConnection();
			preparedStatement = (PreparedStatement) dbConnection.prepareStatement(updateTableSQL);
			preparedStatement.setBoolean(1, false);		
			preparedStatement.setInt(2, id);
			
			preparedStatement.executeUpdate();
								
		} 
  
		catch (SQLException e) 
		{
				System.out.println(e.getMessage());
		}

		finally
		{

			if (preparedStatement != null) 
			{
				preparedStatement.close();
			}

			if (dbConnection != null) 
			{
				dbConnection.close();
			}
		}		
		
	}
	
	private static Connection getDBConnection() 
	{
		Connection dbConnection = null;
		try 
		{
			Class.forName(DB_DRIVER);
			dbConnection = (Connection) DriverManager.getConnection(DB_CCONNECTION, DB_USER,DB_PASSWORD);
			return dbConnection;

		}
		
		catch (ClassNotFoundException e) 
		{	
			System.out.println(e.getMessage());
		}

		catch (SQLException e) 
		{
			System.out.println(e.getMessage());
		}

		return dbConnection;

	}



	
}

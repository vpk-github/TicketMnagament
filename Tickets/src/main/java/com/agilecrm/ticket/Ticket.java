package com.agilecrm.ticket;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Ticket 
{
	int id;
	@JsonProperty
	String name, email, problemType, problemDescription, groupedIn, assignedTo;
	boolean status;	
	
	public Ticket(int id, String name, String email, String problemType, String problemDescription, String group, String assigne,boolean status) 
	{
		super();
		this.id = id;
		this.name = name;
		this.email = email;
		this.problemType = problemType;
		this.problemDescription = problemDescription;
		this.groupedIn = group;
		this.assignedTo = assigne;
		this.status = status;
	}
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Ticket() {
		// TODO Auto-generated constructor stub
	}

	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getProblemType() {
		return problemType;
	}
	public void setProblemType(String problemType) {
		this.problemType = problemType;
	}
	public String getProblemDescription() {
		return problemDescription;
	}
	public void setProblemDescription(String problemDescription) {
		this.problemDescription = problemDescription;
	}
	public String getGroup() 
	{
		return groupedIn;
	}
	public void setGroup(String group) {
		this.groupedIn = group;
	}
	public String getAssigne() {
		return assignedTo;
	}
	public void setAssigne(String assigne) {
		this.assignedTo = assigne;
	}
	public Boolean getStatus() {
		return status;
	}
	public void setStatus(boolean status) {
		this.status = status;
	}
	
	
	public String toString()
	{
		return "\"name\": "+ this.getName()+ "\n" + "\"email\": "+ this.getEmail()+ "\n" + "\"problemType\": "+this.getProblemType()+ "\n" + "\"problemType\": "+this.getProblemDescription()+"\n" + 
				"\"groupedTo\": "+ this.getGroup() + "\n" + "\"assignedTo\": "+ this.getAssigne() + "\n" + "\"status\": "+this.getStatus();
	}

}

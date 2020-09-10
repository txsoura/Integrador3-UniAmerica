package com.Model.bean;

import com.Enum.TicketStatus;

public class Ticket{
private int id;
private double price;
private TicketStatus status;

public Ticket() {
}


public Ticket(int id, double price, TicketStatus status) {
	this.id = id;
	this.price = price;
	this.status = status;
}


public int getId() {
	return id;
}


public void setId(int id) {
	this.id = id;
}


public double getPrice() {
	return price;
}


public void setPrice(double price) {
	this.price = price;
}


public TicketStatus getStatus () {
	return status;
}


public void setStatus (TicketStatus status) {
	this.status = status;
}


@Override
public String toString() {
	return "Ticket {id=" + id + ", price=" + price  + ", status=" + status + "}";
}

}

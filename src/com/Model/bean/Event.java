package com.Model.bean;

import com.Enum.EventType;
import java.util.Date;

public class Event extends Tag{
private int id;
private double price,promo_price;
private String name,description;
private Date start,end;
private EventType type;

public Event() {
}


public Event(int tagId, String tagName,int id, double price, double promo_price, String name, String description, Date start,
		Date end, EventType type) {
	super(tagId,tagName);
	this.id = id;
	this.price = price;
	this.promo_price = promo_price;
	this.name = name;
	this.description = description;
	this.start = start;
	this.end = end;
	this.type = type;
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


public double getPromo_price() {
	return promo_price;
}


public void setPromo_price(double promo_price) {
	this.promo_price = promo_price;
}


public String getName() {
	return name;
}


public void setName(String name) {
	this.name = name;
}


public String getDescription() {
	return description;
}


public void setDescription(String description) {
	this.description = description;
}


public Date getStart() {
	return start;
}


public void setStart(Date start) {
	this.start = start;
}


public Date getEnd() {
	return end;
}


public void setEnd(Date end) {
	this.end = end;
}


public EventType getType() {
	return type;
}


public void setType(EventType type) {
	this.type = type;
}


@Override
public String toString() {
	return "Event {id=" + id + ", price=" + price + ", promo_price=" + promo_price + ", name=" + name + ", description="
			+ description + ", start=" + start + ", end=" + end + ", type=" + type + "}";
}

}

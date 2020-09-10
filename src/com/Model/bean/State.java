package com.Model.bean;

public class State extends Country {
	private int id;
	private String name,code;
	
	public State() {
	}

	public State(int CountryId, String CountryName, String CountryCode, int id, String name, String code) {
		super(CountryId,CountryName,CountryCode);
		this.id = id;
		this.name = name;
		this.code = code;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	@Override
	public String toString() {
		return "State {id=" + id + ", name=" + name + ", code=" + code + "}";
	}
}

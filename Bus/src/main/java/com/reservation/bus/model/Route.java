package com.reservation.bus.model;

public class Route {

	private int id;
	private String origin;
	private String destination;

	public Route() {
	}

	public Route(int id, String origin, String destination) {
		this.id = id;
		this.origin = origin;
		this.destination = destination;
	}

	@Override
	public String toString() {
		return "Route->[ID =" + id + ",ORIGIN=" + origin + ",DESTINATION=" + destination + "]";
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getOrigin() {
		return origin;
	}

	public void setOrigin(String origin) {
		this.origin = origin;
	}

	public String getDestination() {
		return destination;
	}

	public void setDestination(String destination) {
		this.destination = destination;
	}
}

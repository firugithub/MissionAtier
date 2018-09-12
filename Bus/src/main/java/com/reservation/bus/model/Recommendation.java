package com.reservation.bus.model;

public class Recommendation {
	int id;
	String departureDate;
	String arrivalDate;
	String arrivalTime;
	String departureTime;
	String fare;
	String origin;
	String destination;

	public Recommendation(int id, String departureDate, String arrivalDate, String arrivalTime, String departureTime,
			String fare, String origin, String destination) {
		super();
		this.id = id;
		this.departureDate = departureDate;
		this.arrivalDate = arrivalDate;
		this.arrivalTime = arrivalTime;
		this.departureTime = departureTime;
		this.fare = fare;
		this.origin = origin;
		this.destination = destination;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getDepartureDate() {
		return departureDate;
	}

	public void setDepartureDate(String departureDate) {
		this.departureDate = departureDate;
	}

	public String getArrivalDate() {
		return arrivalDate;
	}

	public void setArrivalDate(String arrivalDate) {
		this.arrivalDate = arrivalDate;
	}

	public String getArrivalTime() {
		return arrivalTime;
	}

	public void setArrivalTime(String arrivalTime) {
		this.arrivalTime = arrivalTime;
	}

	public String getDepartureTime() {
		return departureTime;
	}

	public void setDepartureTime(String departureTime) {
		this.departureTime = departureTime;
	}

	public String getFare() {
		return fare;
	}

	public void setFare(String fare) {
		this.fare = fare;
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

	@Override
	public String toString() {
		return "Recommendation [id=" + id + ", departureDate=" + departureDate + ", arrivalDate=" + arrivalDate
				+ ", arrivalTime=" + arrivalTime + ", departureTime=" + departureTime + ", fare=" + fare + ", origin="
				+ origin + ", destination=" + destination + "]";
	}

}

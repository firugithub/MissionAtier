package com.reservation.bus.model;

public class ItineraryPricer {
	int id;
	Route route;
	double fare;
	String departureDate;
	String arrivalDate;
	String departureTime;
	String arrivalTime;

	public ItineraryPricer(int id, Route route, double fare, String departureDate, String arrivalDate,
			String departureTime, String arrivalTime) {
		super();
		this.id = id;
		this.route = route;
		this.fare = fare;
		this.departureDate = departureDate;
		this.departureTime = departureTime;
		this.arrivalTime = arrivalTime;
		this.arrivalDate = arrivalDate;
	}

	@Override
	public String toString() {
		return "ItineraryPricer [id=" + id + ", route=" + route + ", fare=" + fare + ", departureDate=" + departureDate
				+ ", arrivalDate=" + arrivalDate + ", departureTime=" + departureTime + ", arrivalTime=" + arrivalTime
				+ "]";
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

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Route getRoute() {
		return route;
	}

	public void setRoute(Route route) {
		this.route = route;
	}

	public double getFare() {
		return fare;
	}

	public void setFare(double fare) {
		this.fare = fare;
	}

	public String getDepartureTime() {
		return departureTime;
	}

	public void setDepartureTime(String departureTime) {
		this.departureTime = departureTime;
	}

	public String getArrivalTime() {
		return arrivalTime;
	}

	public void setArrivalTime(String arrivalTime) {
		this.arrivalTime = arrivalTime;
	}

}

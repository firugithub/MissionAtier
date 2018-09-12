package com.reservation.bus.model;

public class Trip {
	String userId;
	String origin;
	String destination;
	String dateOfJourney;
	int numOfSeats;

	public Trip(String userId, String origin, String destination, String dateOfJourney, int numOfSeats) {
		super();
		this.userId = userId;
		this.origin = origin;
		this.destination = destination;
		this.dateOfJourney = dateOfJourney;
		this.numOfSeats = numOfSeats;
	}

	public String getUserId() {
		return userId;
	}

	public String getOrigin() {
		return origin;
	}

	public String getDestination() {
		return destination;
	}

	public String getDateOfJourney() {
		return dateOfJourney;
	}

	public int getNumOfSeats() {
		return numOfSeats;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((dateOfJourney == null) ? 0 : dateOfJourney.hashCode());
		result = prime * result + ((destination == null) ? 0 : destination.hashCode());
		result = prime * result + numOfSeats;
		result = prime * result + ((origin == null) ? 0 : origin.hashCode());
		result = prime * result + ((userId == null) ? 0 : userId.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Trip other = (Trip) obj;
		if (dateOfJourney == null) {
			if (other.dateOfJourney != null)
				return false;
		} else if (!dateOfJourney.equals(other.dateOfJourney))
			return false;
		if (destination == null) {
			if (other.destination != null)
				return false;
		} else if (!destination.equals(other.destination))
			return false;
		if (numOfSeats != other.numOfSeats)
			return false;
		if (origin == null) {
			if (other.origin != null)
				return false;
		} else if (!origin.equals(other.origin))
			return false;
		if (userId == null) {
			if (other.userId != null)
				return false;
		} else if (!userId.equals(other.userId))
			return false;
		return true;
	}

}

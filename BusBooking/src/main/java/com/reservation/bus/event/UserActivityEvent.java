package com.reservation.bus.event;

import java.io.Serializable;
import java.util.Date;

/*
 * Object to hold the user activity event.
 */
public class UserActivityEvent implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	Date activityDate;
	String userId;
	Event eventType;

	public UserActivityEvent(Date activityDate, String userId, Event eventType) {
		super();
		this.activityDate = activityDate;
		this.userId = userId;
		this.eventType = eventType;
	}

	public Date getActivityDate() {
		return activityDate;
	}

	public void setActivityDate(Date activityDate) {
		this.activityDate = activityDate;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public Event getEventType() {
		return eventType;
	}

	public void setEventType(Event eventType) {
		this.eventType = eventType;
	}

	@Override
	public String toString() {
		return "UserActivityEvent [activityDate=" + activityDate + ", userId=" + userId + ", eventType=" + eventType
				+ "]";
	}

}

package com.reservation.bus.event;

public enum Event {
	ENTER_TRIP_DETAIL(1), CLICK_TO_PAY_TRIP(2), SUBMIT_PAYMENT(3);
	private int event_id;

	private Event(int event_id) {
		this.event_id = event_id;
	}

	public int getEvent_id() {
		return event_id;
	}

}

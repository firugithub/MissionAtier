package com.reservation.bus.kafka;

import java.text.SimpleDateFormat;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.reservation.bus.event.UserActivityEvent;
import com.reservation.bus.model.Trip;
import com.reservation.bus.util.Constants;

public class KafkaEventValueGenerator {

	public static String getUserActivityEventValue(UserActivityEvent eventObj) {
		if (null == eventObj)
			return null;
		String value = null;
		ObjectMapper mapper = new ObjectMapper();
		try {
			mapper.setDateFormat(new SimpleDateFormat(Constants.DATE_FORMAT_WITH_TIMEZONE));
			value = mapper.writeValueAsString(eventObj);
		} catch (JsonProcessingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return value;

	}

	public static String getTripRequestEventValue(Trip trip) {
		if (null == trip)
			return null;
		String value = null;
		ObjectMapper mapper = new ObjectMapper();
		try {
			mapper.setDateFormat(new SimpleDateFormat(Constants.DATE_FORMAT_WITH_TIMEZONE));
			value = mapper.writeValueAsString(trip);
		} catch (JsonProcessingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return value;

	}
}

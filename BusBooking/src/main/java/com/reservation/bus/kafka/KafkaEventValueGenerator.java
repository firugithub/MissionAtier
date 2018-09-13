package com.reservation.bus.kafka;

import java.text.SimpleDateFormat;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.reservation.bus.event.UserActivityEvent;
import com.reservation.bus.util.Constants;

/**
 * Generator class to generate message values that will be send to kafka
 * topics.Values are generated from the corresponding event object.
 * 
 */
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
			// TODO:Implement some error handling.
			e.printStackTrace();
		}
		return value;

	}

}

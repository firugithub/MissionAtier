package com.reservation.bus.test;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.reservation.bus.event.Event;
import com.reservation.bus.event.UserActivityEvent;
import com.reservation.bus.util.Constants;

/**
 * Generator class to generate Test data .This test data will be used by the job
 * that reads from a file and streams it.
 * 
 * @author srawat1
 *
 */
public class UserActivityEventGenerator {

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void test() {

		UserActivityEvent eventObj1 = new UserActivityEvent(new Date(), "userid1", Event.ENTER_TRIP_DETAIL);
		UserActivityEvent eventObj = new UserActivityEvent(new Date(), "userid1", Event.CLICK_TO_PAY_TRIP);
		UserActivityEvent eventObj3 = new UserActivityEvent(new Date(), "userid2", Event.ENTER_TRIP_DETAIL);
		UserActivityEvent eventObj4 = new UserActivityEvent(new Date(), "userid2", Event.CLICK_TO_PAY_TRIP);
		UserActivityEvent eventObj5 = new UserActivityEvent(new Date(), "userid1", Event.SUBMIT_PAYMENT);
		UserActivityEvent eventObj6 = new UserActivityEvent(new Date(), "userid3", Event.CLICK_TO_PAY_TRIP);
		UserActivityEvent eventObj7 = new UserActivityEvent(new Date(), "userid4", Event.CLICK_TO_PAY_TRIP);
		UserActivityEvent eventObj8 = new UserActivityEvent(new Date(), "userid2", Event.SUBMIT_PAYMENT);
		UserActivityEvent eventObj9 = new UserActivityEvent(new Date(), "userid4", Event.SUBMIT_PAYMENT);
		UserActivityEvent eventObj10 = new UserActivityEvent(new Date(), "userid3", Event.CLICK_TO_PAY_TRIP);
		produceToUserActivityTopic(eventObj1);
		produceToUserActivityTopic(eventObj);
		produceToUserActivityTopic(eventObj3);
		produceToUserActivityTopic(eventObj4);
		produceToUserActivityTopic(eventObj5);
		produceToUserActivityTopic(eventObj6);
		produceToUserActivityTopic(eventObj7);
		produceToUserActivityTopic(eventObj8);
		// produceToUserActivityTopic(eventObj9);
		// produceToUserActivityTopic(eventObj10);

	}

	private void produceToUserActivityTopic(UserActivityEvent eventObj) {
		String value = null;
		ObjectMapper mapper = new ObjectMapper();
		try {
			mapper.setDateFormat(new SimpleDateFormat(Constants.DATE_FORMAT_WITH_TIMEZONE));
			value = mapper.writeValueAsString(eventObj);
		} catch (JsonProcessingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		BufferedWriter writer = null;
		try {
			writer = new BufferedWriter(new FileWriter("resources/eventData/event_data.json", true));
			writer.append(value);
			writer.append('\n');
			writer.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}

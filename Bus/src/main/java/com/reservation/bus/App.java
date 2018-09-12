package com.reservation.bus;

import java.util.Date;
import java.util.Scanner;

import com.reservation.bus.event.Event;
import com.reservation.bus.event.UserActivityEvent;
import com.reservation.bus.kafka.EventConsumer;
import com.reservation.bus.kafka.EventProducer;
import com.reservation.bus.model.Trip;

/**
 * Hello world!
 *
 */
public class App {
	public static void main(String[] args) {
		System.out.println(new Date());
		Scanner sc = new Scanner(System.in);
		System.out.println("Please enter the following details to start a booking:");
		// System.out.println("Please enter From Destination:");
		// String origin = sc.next();
		// System.out.println("Please enter To Destination:");
		// String destination = sc.next();
		// System.out.println("Please enter Date_Of_Journey in this format: " +
		// Constants.DATE_FORMAT);
		// String date_of_journey = sc.next();
		// System.out.println("Please enter Max_No_Of_Seats(Max Allowed Limit:5)
		// : ");
		// int required_seats = sc.nextInt();
		// Validator code
		String origin = "Bangalore";
		String destination = "Jaipur";
		String date_of_journey = "16/09/2018";
		int required_seats = 4;
		Trip trip = new Trip("userId2", origin, destination, date_of_journey, required_seats);
		UserActivityEvent eventObj1 = new UserActivityEvent(new Date(), "userid1", Event.CLICK_TO_PAY_TRIP);
		UserActivityEvent eventObj = new UserActivityEvent(new Date(), "userid2", Event.CLICK_TO_PAY_TRIP);
		System.out.println(trip);
		EventProducer kafkaProducer = new EventProducer();
		kafkaProducer.createProducer();
		kafkaProducer.produceToUserActivityTopic(eventObj1);
		kafkaProducer.produceToUserActivityTopic(eventObj);
		kafkaProducer.produceToUserBookingTopic(trip);
		final EventConsumer consumer = new EventConsumer();
		Thread thread = new Thread(new Runnable() {

			@Override
			public void run() {
				consumer.consumeFromTripRequest();

			}
		});
		Thread thread2 = new Thread(new Runnable() {

			@Override
			public void run() {
				consumer.consumeFromUserActivity();

			}

		});
		thread.start();
		thread2.start();

		kafkaProducer.closeProducer();
	}
}

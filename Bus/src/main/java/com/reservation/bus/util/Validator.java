package com.reservation.bus.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.concurrent.TimeUnit;
import java.util.regex.Pattern;

public class Validator {

	public boolean validatePlace(String place) {
		if (!place.equals("") && !Pattern.matches("[A-Za-z ]+", place)) {
			return false;
		}
		return true;
	}

	public boolean validateDate(String dateToValidate) {
		if (dateToValidate == null) {
			return false;
		}

		SimpleDateFormat sdf = new SimpleDateFormat(Constants.DATE_FORMAT);
		sdf.setLenient(false);

		try {
			Date date = sdf.parse(dateToValidate);
		} catch (ParseException e) {

			// Some error handling can be put in place over here.
			return false;
		}

		return true;
	}

//	private boolean checkInvalidStartDate(String date) {
//		SimpleDateFormat sdf = new SimpleDateFormat(Constants.DATE_FORMAT, Locale.ENGLISH);
//		Date firstDate = sdf.parse(Dat);
//		Date secondDate = sdf.parse("06/30/2017");
//
//		long diffInMillies = Math.abs(secondDate.getTime() - firstDate.getTime());
//		long diff = TimeUnit.DAYS.convert(diffInMillies, TimeUnit.MILLISECONDS);
//	}

}

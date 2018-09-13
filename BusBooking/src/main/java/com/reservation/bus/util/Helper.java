package com.reservation.bus.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class Helper {

	public static Date convertStringToDate(String date, String dateFormat) {
		Date formattedDate;
		if (date == null)
			return null;
		SimpleDateFormat sdf = new SimpleDateFormat(dateFormat);
		sdf.setLenient(false);

		try {
			formattedDate = sdf.parse(date);
		} catch (ParseException e) {

			// TODO:Some error handling can be put in place over here.
			return null;
		}
		return formattedDate;
	}

	public static String convertDateToString(Date date, String dateFormat) {
		Calendar cal = Calendar.getInstance();
		SimpleDateFormat dateOnly = new SimpleDateFormat(dateFormat);
		return dateOnly.format(cal.getTime());
	}

}

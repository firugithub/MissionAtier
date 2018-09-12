package BookingSystem.Bus;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import org.junit.After;
import org.junit.Before;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.reservation.bus.model.ItineraryPricer;
import com.reservation.bus.model.Route;
import com.reservation.bus.util.Constants;

public class Test {

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@org.junit.Test
	public void test() {
		Route route1 = new Route(1, "Bangalore", "Jaipur");
		List<ItineraryPricer> itineraryList = new ArrayList<>();
		itineraryList.add(new ItineraryPricer(1, route1, 540.45, "16/09/2018", "20/09/2018", "20:40", "05:30"));
		itineraryList.add(new ItineraryPricer(2, route1, 840.45, "16/09/2018", "20/09/2018", "08:40", "15:30"));
		itineraryList.add(new ItineraryPricer(3, route1, 940.45, "16/09/2018", "20/09/2018", "14:40", "11:30"));
		itineraryList.add(new ItineraryPricer(4, route1, 1040.45, "16/09/2018", "20/09/2018", "11:40", "16:30"));
		Route route2 = new Route(2, "Bangalore", "Hyderabad");
		itineraryList.add(new ItineraryPricer(5, route2, 540.45, "16/09/2018", "20/09/2018", "20:40", "05:30"));
		itineraryList.add(new ItineraryPricer(6, route2, 840.45, "16/09/2018", "20/09/2018", "08:40", "15:30"));
		itineraryList.add(new ItineraryPricer(7, route2, 940.45, "16/09/2018", "20/09/2018", "14:40", "11:30"));
		itineraryList.add(new ItineraryPricer(8, route2, 1040.45, "16/09/2018", "20/09/2018", "11:40", "16:30"));

		String value = null;
		ObjectMapper mapper = new ObjectMapper();
		List<String> recommendedItinerary = new ArrayList<>();
		BufferedWriter writer = null;
		for (ItineraryPricer itinerary : itineraryList) {
			try {
				mapper.setDateFormat(new SimpleDateFormat(Constants.DATE_FORMAT_WITH_TIMEZONE));
				String itineraryStr = mapper.writeValueAsString(itinerary);
				writer = new BufferedWriter(new FileWriter("eventData/recommended_itinerary.json", true));
				writer.append('\n');
				writer.append(itineraryStr);
				writer.close();
				recommendedItinerary.add(itineraryStr);
			} catch (JsonProcessingException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		System.out.println(recommendedItinerary);

	}

}

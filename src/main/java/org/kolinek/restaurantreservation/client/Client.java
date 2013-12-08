package org.kolinek.restaurantreservation.client;

import javax.xml.datatype.DatatypeFactory;
import org.kolinek.restaurant_reservation.Reservation;
import org.kolinek.restaurant_reservation.ReservationService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Client {
	private static final Logger LOGGER = LoggerFactory.getLogger(Client.class);

	public static void main(String args[]) throws Exception {

		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext(
				"client-context.xml");
		ReservationService reservationService = (ReservationService) context
				.getBean("reservationService");

		Reservation reserv = new Reservation();
		DatatypeFactory f = DatatypeFactory.newInstance();
		reserv.setDuration(f.newDuration(true, 0, 0, 0, 1, 0, 0));
		reserv.setDate(f.newXMLGregorianCalendar(2013, 12, 8, 14, 0, 0, 0, 1));
		reserv.setNumberOfPeople(3);
		LOGGER.info("Test1 (reservation): result = {}",
				reservationService.reserve(reserv));

		context.close();
		System.exit(0);
	}
}

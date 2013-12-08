package org.kolinek.restaurantreservation.impl;

import javax.xml.datatype.DatatypeConfigurationException;
import javax.xml.datatype.DatatypeFactory;

import org.kolinek.restaurant_reservation.Reservation;
import org.kolinek.restaurant_reservation.ReservationService;

public class ReservationServiceImpl implements ReservationService {

	DatatypeFactory f;

	public ReservationServiceImpl() throws DatatypeConfigurationException {
		f = DatatypeFactory.newInstance();
	}

	@Override
	public boolean reserve(Reservation parameters) {
		return parameters.getNumberOfPeople() < 10
				&& parameters.getDuration().isShorterThan(
						f.newDuration(true, 0, 0, 0, 5, 0, 0));
	}
}

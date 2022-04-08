package com.location.repositories;

import com.location.entities.Client;
import com.location.entities.Reservation;
import com.location.entities.Voiture;

public interface ReservationRepositoryCustom {
	Reservation ListeReservationByClient(Client client);

	Reservation listeReservationByVoiture(Voiture voiture);
}

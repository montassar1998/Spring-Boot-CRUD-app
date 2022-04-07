package com.location.repositories;

import com.location.entities.Client;
import com.location.entities.Location;
import com.location.entities.Voiture;

public interface LocationRepositoryCustom {
	Location ListeLocationByClient(Client client);

	Location listeLocationByVoiture(Voiture voiture);
}

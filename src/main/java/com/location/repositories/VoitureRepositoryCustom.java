package com.location.repositories;

import com.location.entities.Voiture;

public interface VoitureRepositoryCustom {
	Voiture ListeVoitureByModel(String model);
}

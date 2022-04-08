package com.location.repositories;

import com.location.entities.Modele;

public interface ModeleRepositoryCustom {
	Modele getModeleByFamille(String family);

	Modele getAllModels();

}

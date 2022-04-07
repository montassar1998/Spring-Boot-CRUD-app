package com.location.repositories;

import com.location.entities.Client;

public interface ClientRepositoryCustom {
	Client getClientByName(String name);
}

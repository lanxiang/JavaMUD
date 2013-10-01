package be.vdab.services;

import java.util.List;

import be.vdab.entities.Gebruiker;
import be.vdab.entities.Karakter;
import be.vdab.entities.Lokatie;

public interface KarakterService {
	void create(Karakter karakter);

	Karakter read(long id);

	void update(Karakter karakter);

	void delete(long id);

	List<Karakter> findByGebruiker(Gebruiker gebruiker);

	List<Karakter> findByLokatie(Lokatie lokatie);
}

package be.vdab.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import be.vdab.dao.KarakterDAO;
import be.vdab.entities.Gebruiker;
import be.vdab.entities.Karakter;
import be.vdab.entities.Lokatie;

@Service
public class KarakterServiceImpl implements KarakterService {
	private final KarakterDAO karakterDAO;
	
	@Autowired
	public KarakterServiceImpl(KarakterDAO karakterDAO) {
		this.karakterDAO = karakterDAO;
	}

	@Override
	public void create(Karakter karakter) {
		karakterDAO.create(karakter);
	}

	@Override
	public Karakter read(long id) {
		return karakterDAO.read(id);
	}

	@Override
	public void update(Karakter karakter) {
		karakterDAO.update(karakter);
	}

	@Override
	public void delete(long id) {
		karakterDAO.delete(id);
	}

	@Override
	public List<Karakter> findByGebruiker(Gebruiker gebruiker) {
		return karakterDAO.findByGebruiker(gebruiker);
	}

	@Override
	public List<Karakter> findByLokatie(Lokatie lokatie) {
		return karakterDAO.findByLokatie(lokatie);
	}

}

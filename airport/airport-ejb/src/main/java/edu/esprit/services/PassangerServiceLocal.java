package edu.esprit.services;

import java.util.List;

import javax.ejb.Local;

import edu.esprit.persistance.Passanger;

@Local
public interface PassangerServiceLocal {

	void addPassanger(Passanger passanger);
	public List<Passanger> findPassangerByFlight(Integer id);
	
}

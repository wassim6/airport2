package edu.esprit.services;

import javax.ejb.Local;

import edu.esprit.persistance.Passanger;

@Local
public interface PassangerServiceLocal {

	void addPassanger(Passanger passanger);
	
}

package edu.esprit.services;

import java.util.List;

import javax.ejb.Local;

import edu.esprit.persistance.Affectation;

@Local
public interface AffectationServiceLocal {
	List<Affectation> findAll(Integer id);	
}

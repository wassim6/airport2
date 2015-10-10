package edu.esprit.services;

import java.util.List;

import javax.ejb.Local;

import edu.esprit.persistance.AirlineCompany;

@Local
public interface AirlineCompanyServiceLocal {
	
	void add(AirlineCompany airlineCompany);
	void delete(AirlineCompany airlineCompany);
	void deleteById(Integer id);
	void update(AirlineCompany airlineCompany);
	AirlineCompany findAirlineCompanyById(Integer id);
	List<AirlineCompany> findAllAirlineCompanies();
	
	//testGit

}

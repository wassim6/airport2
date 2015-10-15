package edu.esprit.services;

import java.util.List;

import javax.ejb.Remote;

import edu.esprit.persistance.AirlineCompany;

@Remote
public interface AirlineCompanyServiceRemote {
	
	void add(AirlineCompany airlineCompany);
	void delete(AirlineCompany airlineCompany);
	void deleteById(Integer id);
	void update(AirlineCompany airlineCompany);
	AirlineCompany findAirlineCompanyById(Integer id);
	AirlineCompany findAirlineCompanyByName(String name);
	List<AirlineCompany> findAllAirlineCompanies();
	
	//testGit

}

package edu.esprit.services;

import javax.ejb.Local;

import edu.esprit.persistance.Client;

@Local
public interface ClientServiceLocal {
	
	
	public boolean add(Client client);
    
    public Client find(Integer id);

	public boolean update(Client client);

	public boolean delete(Integer id);
	
	public Client existC(String email,String password);

}

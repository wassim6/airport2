package edu.esprit.services;

import javax.ejb.Local;

import edu.esprit.persistance.Client;

@Local
public interface ClientServiceLocal {
	
	
	public void add(Client client);
    
    public Client find(Integer id);

	public void update(Client client);

	public void delete(Client client);
	
	public Client existC(String email,String password);

}

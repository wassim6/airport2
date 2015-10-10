package edu.esprit.services;

import javax.ejb.Local;

import edu.esprit.persistance.ClientInfo;

@Local
public interface ClientInfoServiceLocal {
	
	
	public void add(ClientInfo client);
    
    public ClientInfo find(Integer id);

	public void update(ClientInfo client);

	public void delete(ClientInfo client);


}

package edu.esprit.services;

import javax.ejb.Local;

import edu.esprit.persistance.Claim;

@Local
public interface ClaimServiceLocal {
	
	
    public void add(Claim claim);
    public Claim find(Integer id);
	public void update(Claim claim);
	public void delete(Claim claim);
}

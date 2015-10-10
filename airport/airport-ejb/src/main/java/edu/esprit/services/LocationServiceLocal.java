package edu.esprit.services;

import java.util.List;

import javax.ejb.Local;
import edu.esprit.persistance.Location;

@Local
public interface LocationServiceLocal {
	
    public void add(Location location);
    public Location find(Integer id);
	public void update(Location location);
	public void delete(Integer id);
	public List<Location> findAll();

}

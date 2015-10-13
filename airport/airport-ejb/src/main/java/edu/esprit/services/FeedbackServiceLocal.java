package edu.esprit.services;


import java.util.List;

import javax.ejb.Local;

import edu.esprit.persistance.Feedback;

@Local
public interface FeedbackServiceLocal {
	
	
    public void add(Feedback feedback);
    public Feedback find(Integer id);
	public void update(Feedback feedback);

	public void delete(Feedback feedback);
	public List<Feedback> findAll(Integer id);
	


}

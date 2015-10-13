package edu.esprit.services;

import java.util.Date;
import java.util.List;

import javax.ejb.Local;




import edu.esprit.persistance.Deal;
import edu.esprit.persistance.Feedback;

@Local
public interface DealServiceLocal {


	List<Deal> findAllDeal();
	
	public List<Deal> findDealByDate(Date startDeal);
	
}

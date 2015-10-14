package edu.esprit.services;


import java.sql.Date;
import java.util.List;

import javax.ejb.Local;





import edu.esprit.persistance.Deal;

@Local
public interface DealServiceLocal {


	List<Deal> findAllDeal();
	
	public List<Deal> findDealByDate(Date Deal);
	
}

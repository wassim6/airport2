package edu.esprit.services;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;


@Stateless
@LocalBean
public class ReservationService implements ReservationServiceLocal {

    /**
     * Default constructor. 
     */
    public ReservationService() {
        // TODO Auto-generated constructor stub
    }

	@Override
	public void CancelReservation() {
		// TODO Auto-generated method stub
		
		//Change the status of reservation
		
	}

}

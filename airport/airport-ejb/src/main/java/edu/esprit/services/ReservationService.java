package edu.esprit.services;


import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.print.DocFlavor.STRING;

import edu.esprit.persistance.Reservation;


@Stateless
@LocalBean
public class ReservationService implements ReservationServiceLocal {

	@PersistenceContext
	private EntityManager em;
    public ReservationService() {
        
    	
    }

	@Override
	public void CancelReservation(Reservation reservation) {
		
		
		
		if(reservation.getStatus()!="canceled")
		{
			reservation.setStatus("canceled");
			em.merge(reservation);
		}

/*		if(reservation.getStatus()!="canceled")
		{
			reservation.setStatus("canceled");
			em.merge(reservation);
//			em.remove(em.merge(reservation));
		}*/
			
		
	}

}

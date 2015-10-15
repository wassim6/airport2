package edu.esprit.services;


import java.util.logging.Level;
import java.util.logging.Logger;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import javax.print.DocFlavor.STRING;

import edu.esprit.persistance.Flight;
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
		
		Reservation r =null;
		r=em.find(Reservation.class, reservation.getIdReservation());
		
		if(r!=null)
		{
			String jpql = "UPDATE Reservation r SET r.status='cancled' WHERE r.idReservation = :id";
			Query query= em.createQuery("UPDATE Reservation r SET r.status='cancled' WHERE r.idReservation=:id");
			query.setParameter("id", reservation.getIdReservation());
			query.executeUpdate();
		}			
		
	}

	@Override
	public void addReservation(Reservation reservation) {
		em.persist(reservation);
	}

}

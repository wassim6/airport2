package edu.esprit.services;


import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

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
		
		}

	@Override
	public void Reserver(Reservation reservation) {

		em.persist(reservation);
		
	}

	@Override
	public Reservation find(Integer id) {
		//modifier id par autre chose qui joue le même rôle
		return em.find(Reservation.class, id);
		
	}

	@Override
	public void update(Reservation reservation) {

		em.merge(reservation);
		
	}

	

	@Override
	public List<Reservation> ConsultAll(Integer id) {
		
		List<Reservation> reservations = null;
		String jpql = "select r from Reservation r where r.passanger.idPassanger=:x";
		TypedQuery<Reservation> query = em.createQuery(jpql,Reservation.class);
		query.setParameter("x", id);
		reservations = query.getResultList();
		return reservations;
		
	}

	/*@Override
	public List<Reservation> FindByMonth(String month) {
		List<Reservation> reservations = null;
		String jpql = "select r from Reservation r where FUNC('MONTH', r.dateReservation)=:month ";
		TypedQuery<Reservation> query = em.createQuery(jpql,Reservation.class);
		reservations = query.getResultList();
		return reservations;
	}*/

	@Override
	public List<Reservation> FindByYear(String year) {
		//2015
		String year1=year+"-01-01-00:00:00";
		String year2=year+"-12-31-23:59:00";
		
		SimpleDateFormat sdf= new SimpleDateFormat("yyyy-MM-dd-hh:mm");
		Date date1= new Date();
		Date date2 = new Date();
		try{
			date1=sdf.parse(year1);
			date2=sdf.parse(year2);
		}catch(ParseException e){
			e.printStackTrace();
		}
		
		List<Reservation> reservations = null;
		String jpql = "select r from Reservation r where r.dateReservation>=:date1 AND r.dateReservation<=:date2 ";
		TypedQuery<Reservation> query = em.createQuery(jpql,Reservation.class);
		query.setParameter("date1", date1);
		query.setParameter("date2", date2);
		reservations = query.getResultList();
		return reservations;
		
	}

	@Override
	public List<Reservation> FindByPlace(String code) {
		
		
		
		List<Reservation> reservations = null;
		String jpql = "select r from Reservation r where r.flight.arrivalLocation.airportCode=:y";
		TypedQuery<Reservation> query = em.createQuery(jpql,Reservation.class);
		query.setParameter("y", code);
		reservations = query.getResultList();
		return reservations;
		
	}

}
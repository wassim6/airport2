package edu.esprit.services;


import java.sql.Date;
import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import edu.esprit.persistance.AirlineCompany;
import edu.esprit.persistance.Deal;
import edu.esprit.persistance.Feedback;


@Stateless
@LocalBean
public class DealService implements DealServiceLocal {

	@PersistenceContext
	private EntityManager em;
	
    public DealService() {

    }

	@Override
	public List<Deal> findAllDeal() {

		return em
				.createQuery("select a from Deal a", Deal.class)
				.getResultList();
	
	}

	public List<Deal> findDealByDate(Date Deal) {
				
				List<Deal> Deals = null;
				String jpql = " select a from Deal a where :deal BETWEEN a.startDeal AND a.endDeal  ";
				TypedQuery<Deal> query = em.createQuery(jpql,Deal.class);
				query.setParameter("deal",Deal);
				Deals = query.getResultList();
				return Deals;
			}
	


		
	}


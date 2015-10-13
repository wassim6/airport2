package edu.esprit.services;

import java.util.Date;
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

	@Override
	public List<Deal> findDealByDate(Date startDeal) {
				
				List<Deal> Deals = null;
				String jpql = " select a from deal a where a.date=to_char(StartDate,jj) between date-7 and date+7=:x  ";
				TypedQuery<Deal> query = em.createQuery(jpql,Deal.class);
				query.setParameter("x",startDeal);
				Deals = query.getResultList();
				return Deals;
			}
	


		
	}


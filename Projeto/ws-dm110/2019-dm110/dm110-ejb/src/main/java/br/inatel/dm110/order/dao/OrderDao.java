package br.inatel.dm110.order.dao;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import br.inatel.dm110.order.entities.Order;

@Stateless
public class OrderDao {

	@PersistenceContext(unitName = "order_pu")
	private EntityManager em;

	public List<Order> listAll() {
		Query query = em.createQuery("from Order o", Order.class);
		return query.getResultList();
	}

	public void insert(Order order) {
		em.persist(order);
	}

	public Order getOrder(Order order) {
		// TODO Do the correct query
		Query query = em.createQuery("from Order o where ", Order.class);
		return (Order) query.getSingleResult();
	}

	public void updateOrder(Order order) {
		// TODO
	}

}

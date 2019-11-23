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
		System.out.println("[OrderDAO] List all Orders");

		Query query = em.createQuery("from Order o", Order.class);
		return query.getResultList();
	}

	public void insert(Order order) {
		System.out.println("[OrderDAO] Save Order " + order.getOrderCode());

		em.persist(order);
	}

	public Order getOrder(int orderId) {
		System.out.println("[OrderDAO] Get Order by Id " + orderId);

		Order order = em.find(Order.class, orderId);
		return order;
	}

	public void updateOrder(Order order) {
		System.out.println("[OrderDAO] Update Order " + order.getOrderCode());

		em.merge(order);
	}
}

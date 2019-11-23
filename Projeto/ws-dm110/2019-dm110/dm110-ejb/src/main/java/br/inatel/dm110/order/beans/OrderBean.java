package br.inatel.dm110.order.beans;

import java.util.List;

import javax.ejb.Local;
import javax.ejb.Remote;
import javax.ejb.Stateless;

import br.inatel.dm110.api.OrderTO;
import br.inatel.dm110.order.entities.Order;
import br.inatel.dm110.order.interfaces.OrderLocal;
import br.inatel.dm110.order.interfaces.OrderRemote;

@Stateless
@Remote(OrderRemote.class)
@Local(OrderLocal.class)
public class OrderBean implements OrderLocal, OrderRemote {

	@Override
	public void saveOrder(OrderTO orderTO) {

		Order order = mapToOrder(orderTO);

		System.out.println("Saving new Order: " + order.getOrderCode());

		// TODO Auto-generated method stub
	}

	@Override
	public OrderTO getOrderById(int orderId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<OrderTO> getAllOrders() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void updateOrderById(OrderTO orderTO) {

		Order order = mapToOrder(orderTO);

		System.out.println("Updating Order: " + order.getOrderCode());

		// TODO Auto-generated method stub
	}

	/**
	 * Map OrderTO to Order
	 *
	 * @param orderTO
	 * @return The Order mapped
	 */
	private Order mapToOrder(OrderTO orderTO) {

		Order order = new Order();

		order.setAmount(orderTO.getAmount());
		order.setCpf(orderTO.getCpf());
		order.setOrderCode(orderTO.getOrderCode());
		order.setProducCode(orderTO.getProducCode());
		order.setSaleDate(orderTO.getSaleDate());
		order.setValue(orderTO.getValue());

		return order;
	}

	/**
	 * Map Order to OrderTO
	 *
	 * @param order
	 * @return The OrderTO mapped
	 */
	private OrderTO mapToOrderTO(Order order) {

		OrderTO orderTO = new OrderTO();

		orderTO.setAmount(order.getAmount());
		orderTO.setCpf(order.getCpf());
		orderTO.setOrderCode(order.getOrderCode());
		orderTO.setProducCode(order.getProducCode());
		orderTO.setSaleDate(order.getSaleDate());
		orderTO.setValue(order.getValue());

		return orderTO;
	}

}

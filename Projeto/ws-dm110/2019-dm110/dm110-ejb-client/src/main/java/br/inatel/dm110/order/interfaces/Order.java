package br.inatel.dm110.order.interfaces;

import java.util.List;

import br.inatel.dm110.api.OrderTO;

public interface Order {

	/**
	 * Include new Order.
	 *
	 * @param order
	 *            The Order to be saved.
	 */
	public void saveOrder(OrderTO order);

	/**
	 * Search for an order by Id.
	 */
	public OrderTO getOrderById(int orderId);

	/**
	 * List all saved Orders.
	 *
	 * @return The list containig all Orders.
	 */
	public List<OrderTO> getAllOrders();

	/**
	 * Update an Order by Id.
	 *
	 * @param order
	 *            The order to be updated
	 */
	public void updateOrderById(OrderTO order);

}

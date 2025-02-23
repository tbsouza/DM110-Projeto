package br.inatel.dm110.api;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("ralethi")
public interface OrderService {

	/**
	 * Include new Order.
	 *
	 * @param order
	 *            The Order to be saved.
	 */
	@POST
	@Path("/order")
	@Consumes(MediaType.APPLICATION_JSON)
	public void saveOrder(OrderTO order);

	/**
	 * Search for an order by Id.
	 */
	@GET
	@Path("/order/{orderId}")
	@Produces(MediaType.APPLICATION_JSON)
	public OrderTO getOrderById(@PathParam("orderId") int orderId);

	/**
	 * List all saved Orders.
	 *
	 * @return The list containig all Orders.
	 */
	@GET
	@Path("/orders")
	@Produces(MediaType.APPLICATION_JSON)
	public List<OrderTO> getAllOrders();

	/**
	 * Update an Order by Id.
	 *
	 * @param order
	 *            The order to be updated
	 */
	@PUT
	@Path("/order")
	@Consumes(MediaType.APPLICATION_JSON)
	public void updateOrderById(OrderTO order);

}

package br.inatel.dm110.order.beans;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Local;
import javax.ejb.Remote;
import javax.ejb.Stateless;

import br.inatel.dm110.api.OrderTO;
import br.inatel.dm110.audit.AuditMessageSender;
import br.inatel.dm110.order.dao.OrderDao;
import br.inatel.dm110.order.entities.Audit;
import br.inatel.dm110.order.entities.Order;
import br.inatel.dm110.order.interfaces.OrderLocal;
import br.inatel.dm110.order.interfaces.OrderRemote;

@Stateless
@Remote(OrderRemote.class)
@Local(OrderLocal.class)
public class OrderBean implements OrderLocal, OrderRemote {

	@EJB
	private OrderDao dao;
	
	@EJB
	private AuditMessageSender auditSender;

	@Override
	public void saveOrder(OrderTO orderTO) {
		System.out.println("[OrderBean] Save new Order: " + orderTO.getOrderCode());

		// Map and insert into database
		Order order = mapToOrder(orderTO);
		dao.insert(order);
		
		// Create audit and send the audit message
		Audit audit = createAudit(order.getOrderCode(), "CREATE", new Date(System.currentTimeMillis()));
		auditSender.sendAuditMessage(audit);
	}

	@Override
	public OrderTO getOrderById(int orderId) {
		System.out.println("[OrderBean] Get Order by Id " + orderId);

		// Get the Order from database
		Order order = dao.getOrder(orderId);

		// Transalte the order to OrderTO
		OrderTO orderTO = mapToOrderTO(order);

		// Send the audit message
		Audit audit = createAudit(order.getOrderCode(), "GET", new Date(System.currentTimeMillis()));
		auditSender.sendAuditMessage(audit);
		
		return orderTO;
	}

	@Override
	public List<OrderTO> getAllOrders() {
		System.out.println("[OrderBean] Get all saved orders");

		// Get all ORders from database
		List<Order> orders = dao.listAll();
		List<OrderTO> orderTOList = new ArrayList<OrderTO>();

		// Translate the list of Order to list of OrderTO
		for (Order order : orders) {
			OrderTO orderTO = mapToOrderTO(order);
			orderTOList.add(orderTO);
		}
		
		// TODO Send the audit message

		return orderTOList;
	}

	@Override
	public void updateOrderById(OrderTO orderTO) {
		System.out.println("[OrderBean] Update Order: " + orderTO.getOrderCode());

		// Translate OrderTO to Order
		Order order = mapToOrder(orderTO);

		// Update the Order
		dao.updateOrder(order);
		
		// Send the audit message
		Audit audit = createAudit(order.getOrderCode(), "UPDATE", new Date(System.currentTimeMillis()));
		auditSender.sendAuditMessage(audit);
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
	
	private Audit createAudit(int orderCode, String operation, Date date) {

		Audit audit = new Audit();
		audit.setRegisterCode(orderCode);
		audit.setOperation(operation);
		audit.setDateTime(date);

		return audit;
	}

}

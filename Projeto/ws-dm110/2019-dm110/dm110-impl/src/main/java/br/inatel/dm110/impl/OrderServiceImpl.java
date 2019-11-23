package br.inatel.dm110.impl;

import java.util.List;

import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;

import br.inatel.dm110.api.OrderService;
import br.inatel.dm110.api.OrderTO;
import br.inatel.dm110.order.interfaces.OrderRemote;

@RequestScoped
public class OrderServiceImpl implements OrderService {

	@EJB(lookup = "ejb:dm110-ear-1.0/dm110-ejb-1.0/OrderBean!br.inatel.dm110.order.interfaces.OrderRemote")
	private OrderRemote orderBean;

	@Override
	public void saveOrder(OrderTO orderTO) {
		System.out.println("[OrderServiceImpl] Save Order " + orderTO.getOrderCode());

		orderBean.saveOrder(orderTO);
	}

	@Override
	public OrderTO getOrderById(int orderId) {
		System.out.println("[OrderServiceImpl] Get Order by Id " + orderId);

		OrderTO order = orderBean.getOrderById(orderId);
		return order;
	}

	@Override
	public List<OrderTO> getAllOrders() {
		System.out.println("[OrderServiceImpl] Get All Orders");

		List<OrderTO> orders = orderBean.getAllOrders();
		return orders;
	}

	@Override
	public void updateOrderById(OrderTO orderTO) {
		System.out.println("[OrderServiceImpl] Update Order " + orderTO.getOrderCode());

		orderBean.updateOrderById(orderTO);
	}

}

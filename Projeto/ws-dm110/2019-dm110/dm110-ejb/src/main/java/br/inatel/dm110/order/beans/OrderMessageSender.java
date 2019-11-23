package br.inatel.dm110.order.beans;

import javax.annotation.Resource;
import javax.ejb.Stateless;
import javax.jms.Connection;
import javax.jms.ConnectionFactory;
import javax.jms.JMSException;
import javax.jms.MessageProducer;
import javax.jms.ObjectMessage;
import javax.jms.Queue;
import javax.jms.Session;

import br.inatel.dm110.order.entities.Audit;

@Stateless
public class OrderMessageSender {

	@Resource(lookup = "java:/ConnectionFactory")
	private ConnectionFactory connectionFactory;

	// TODO Create Queue
	@Resource(lookup = "java:/jms/queue/orderqueue")
	private Queue queue;

	public void sendStateMessage(Audit audit) {

		try {
			Connection connection = connectionFactory.createConnection();
			Session session = connection.createSession();
			MessageProducer producer = session.createProducer(queue);

			ObjectMessage auditMessage = session.createObjectMessage(audit);
			producer.send(auditMessage);

		} catch (JMSException e) {

			System.out.println("Error sending Audit: " + audit.toString());
			throw new RuntimeException(e);
		}
	}

}

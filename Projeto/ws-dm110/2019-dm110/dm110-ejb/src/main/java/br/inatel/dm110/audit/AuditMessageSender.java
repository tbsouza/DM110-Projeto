package br.inatel.dm110.audit;

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
public class AuditMessageSender {

	@Resource(lookup = "java:/ConnectionFactory")
	private ConnectionFactory connectionFactory;

	@Resource(lookup = "java:/jms/queue/auditqueue")
	private Queue queue;

	public void sendAuditMessage(Audit audit) {

		try {
			Connection connection = connectionFactory.createConnection();
			Session session = connection.createSession();
			MessageProducer producer = session.createProducer(queue);

			ObjectMessage auditMessage = session.createObjectMessage(audit);

			// Send the message to queue
			producer.send(auditMessage);

		} catch (JMSException e) {
			System.out.println("[AuditMessageSender] Error sending Audit: " + audit.toString());
			throw new RuntimeException(e);
		}
	}
}

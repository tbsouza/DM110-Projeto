package br.inatel.dm110.audit.mdb;

import javax.ejb.ActivationConfigProperty;
import javax.ejb.EJB;
import javax.ejb.MessageDriven;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jms.ObjectMessage;

import br.inatel.dm110.api.AuditTO;
import br.inatel.dm110.audit.dao.AuditDao;
import br.inatel.dm110.order.entities.Audit;

@MessageDriven(activationConfig = {
		@ActivationConfigProperty(propertyName = "destinationType", propertyValue = "javax.jms.Queue"),
		@ActivationConfigProperty(propertyName = "destination", propertyValue = "java:/jms/queue/auditqueue"),
		@ActivationConfigProperty(propertyName = "maxSession", propertyValue = "5") })
public class AuditMdb implements MessageListener {

	@EJB
	private AuditDao dao;

	/**
	 * Process the message received from the queue
	 */
	@Override
	public void onMessage(Message message) {

		if (message instanceof ObjectMessage) {
			System.out.println("[AuditMdb] Message received from queue");

			ObjectMessage objMessage = (ObjectMessage) message;

			try {
				AuditTO auditTO = objMessage.getBody(AuditTO.class);

				// Map AuditTO to Audit and insert into database
				dao.insert(mapToAudit(auditTO));
			} catch (JMSException e) {
				e.printStackTrace();
			}

		}

	}

	private Audit mapToAudit(AuditTO auditTO) {

		Audit audit = new Audit();
		audit.setId(auditTO.getId());
		audit.setDateTime(auditTO.getDateTime());
		audit.setOperation(auditTO.getOperation());
		audit.setRegisterCode(auditTO.getRegisterCode());

		return audit;
	}
}

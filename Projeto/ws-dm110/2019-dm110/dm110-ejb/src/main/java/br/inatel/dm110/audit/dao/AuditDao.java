package br.inatel.dm110.audit.dao;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import br.inatel.dm110.order.entities.Audit;

@Stateless
public class AuditDao {

	@PersistenceContext(unitName = "order_pu")
	private EntityManager em;

	public void insert(Audit audit) {
		System.out.println("[AuditDao] Save Audit");

		em.persist(audit);
	}
}

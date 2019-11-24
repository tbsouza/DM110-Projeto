package br.inatel.dm110.audit.dao;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import br.inatel.dm110.order.entities.Audit;

@Stateless
public class AuditDao {

	// TODO Check if unitName is correct for Audit
	@PersistenceContext(unitName = "audit_pu")
	private EntityManager em;

	public void insert(Audit audit) {
		System.out.println("[AuditDao] Save Audit");

		em.persist(audit);
	}
}

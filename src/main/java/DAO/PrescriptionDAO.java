package DAO;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import Modal.Prescription;
import Utils.HibernateUtil;

public class PrescriptionDAO {

	public void getAllPrescription() {
		EntityManager em = HibernateUtil.getEntityManager();
		String ql = "select p from prescription p";
		TypedQuery<Prescription> query = em.createQuery(ql, Prescription.class);
		List<Prescription> prescriptions = query.getResultList();
		System.out.println("prescriptions: " + prescriptions);

	}

	public void getPrescriptionById(Integer id) {
		EntityManager em = HibernateUtil.getEntityManager();
		String ql = "select p from prescription p where p.id_doc = :id";
		TypedQuery<Prescription> query = em.createQuery(ql, Prescription.class);
		query.setParameter("id", id);
		Prescription doctors = query.getSingleResult();
		System.out.println("Receita por id: " + doctors);
	}

	public void deletePrescription(Integer id) {
		EntityManager em = HibernateUtil.getEntityManager();
		Prescription pres = em.find(Prescription.class, id);
		if (pres!= null) {
			em.getTransaction().begin();
			em.remove(pres);
			em.getTransaction().commit();
		} else {
			System.out.println("Receita " + id + " não encontrado.");
		}
	}

	public void insetNewProject(Prescription pres) {
		EntityManager em = HibernateUtil.getEntityManager();
		em.getTransaction().begin();
		em.persist(pres);
		em.getTransaction().commit();
		System.out.println("Valor gerado pelo insert na tabela Prescription: " + pres.getIdPrescription());

	}

	public void updateProject(Prescription pres) {
		EntityManager em = HibernateUtil.getEntityManager();

		Prescription objCargo = em.find(Prescription.class, pres.getIdPrescription());
		if (objCargo != null) {
			em.getTransaction().begin();
			em.merge(pres);
			em.getTransaction().commit();
		} else {
			System.out.println("Prescription " + pres.getIdPrescription() + " não encontrado.");
		}
	}
}

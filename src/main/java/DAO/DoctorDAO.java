package DAO;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import Modal.Doctor;
import Utils.HibernateUtil;

public class DoctorDAO {

	public void getAllDoctors() {
		EntityManager em = HibernateUtil.getEntityManager();
		String ql = "SELECT d FROM doctor d";
		TypedQuery<Doctor> query = em.createQuery(ql, Doctor.class);
		List<Doctor> doctors = query.getResultList();
		System.out.println("Médico: " + doctors);

	}

	public void getDoctorById(Integer id) {
		EntityManager em = HibernateUtil.getEntityManager();
		String ql = "select d from doctor d where r.id_doc = :id";
		TypedQuery<Doctor> query = em.createQuery(ql, Doctor.class);
		query.setParameter("id", id);
		Doctor doctors = query.getSingleResult();
		System.out.println("Médico por ID: " + doctors);
	}

	public void deleteDoctor(Integer id) {
		EntityManager em = HibernateUtil.getEntityManager();
		Doctor doctor = em.find(Doctor.class, id);
		if (doctor != null) {
			em.getTransaction().begin();
			em.remove(doctor);
			em.getTransaction().commit();
		} else {
			System.out.println("Médico " + id + " não existente.");
		}
	}

	public void insetNewDoctor(Doctor doc) {
		EntityManager em = HibernateUtil.getEntityManager();
		em.getTransaction().begin();
		em.persist(doc);
		em.getTransaction().commit();
		System.out.println("Valor gerado pelo insert na tabela DOCTOR: " + doc.getIdDoctor());

	}

	public void updateDoctor(Doctor doc) {
		EntityManager em = HibernateUtil.getEntityManager();
		Doctor objCargo = em.find(Doctor.class, doc.getIdDoctor());
		if (objCargo != null) {
			em.getTransaction().begin();
			em.merge(doc);
			em.getTransaction().commit();
		} else {
			System.out.println("DOCTOR" + doc.getIdDoctor() + " não encontrado.");
		}
	}
}

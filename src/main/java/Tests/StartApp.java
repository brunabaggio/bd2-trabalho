package Tests;

import java.util.Date;
import DAO.DoctorDAO;
import DAO.PrescriptionDAO;
import Modal.Doctor;
import Modal.Prescription;


public class StartApp {
	public static void main(String[] args) {
		prescriptiontestes();
	}
	
	private static void doctortestes() {
		DoctorDAO dDAO = new DoctorDAO();
		Doctor d = new Doctor();
		dDAO.getAllDoctors();
	}

	private static void prescriptiontestes() {
		PrescriptionDAO pDAO = new PrescriptionDAO();
		Prescription p = new Prescription();	
		Doctor d = new Doctor();
	}
}

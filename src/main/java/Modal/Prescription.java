package Modal;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.*;

import Modal.Doctor;

@Entity
@Table(name="prescription")

public class Prescription implements Serializable{
	@Id
	@GeneratedValue
	@Column(name = "idPrescription")
	private Integer idPrescription;

	private String description;

	@Temporal(TemporalType.TIMESTAMP)
	private Date dtPres;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "idprescription")
	private Doctor iddoctor;

	public Prescription() {
	}
	
	public Doctor getIdDoctor() {
		return iddoctor;
	}

	public void setIdDoctor(Doctor doctor) {
		this.iddoctor = doctor;
	}

	public Integer getIdPrescription() {
		return idPrescription;
	}

	public void setIdPrescription(Integer idPrescription) {
		this.idPrescription = idPrescription;
	}


	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}


	public Date getdtPres() {
		return dtPres;
	}

	public void setdtPres(Date dtPres) {
		this.dtPres = dtPres;
	}
}

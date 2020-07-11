package Modal;

import java.io.Serializable;
import javax.persistence.*;

@Entity
@Table(name = "doctor")

public class Doctor implements Serializable {

	@Id
	@GeneratedValue
	@Column(name = "iddoctor")
	private Integer iddoctor;

	private String namedoctor;
	private String specialty;
	private String phone;

	public Doctor() {

	}

	@Override
	public String toString() {
		return "Doctor [nameDoctor=" + namedoctor + "]";
	}

	public Integer getIdDoctor() {
		return iddoctor;
	}

	public void setIdDoctor(Integer idDoctor) {
		this.iddoctor = idDoctor;
	}

	public String getNameDoctor() {
		return namedoctor;
	}

	public void setNameDoctor(String nameDoctor) {
		this.namedoctor = nameDoctor;
	}

	public String getSpecialty() {
		return specialty;
	}

	public void setSpecialty(String specialty) {
		this.specialty = specialty;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

}

package Utils;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class HibernateUtil {

	public static EntityManager getEntityManager() {
		
		EntityManagerFactory emFactory = null;
		try {
			emFactory = Persistence.createEntityManagerFactory("banco_de_dados_2");
		} catch (Throwable e) {
			System.err.println("Error creating EntityManagerFactory ." + e);
			throw new ExceptionInInitializerError(e);
		}
		return emFactory.createEntityManager();
	}
}

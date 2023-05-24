package Contact_Book;


import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

import org.springframework.stereotype.Component;



@Component
public class MyContactsDao {
public void saveContact( MyContacts mc) {
	EntityManagerFactory emf =Persistence.createEntityManagerFactory("suman");
	EntityManager em=emf.createEntityManager();
	EntityTransaction et=em.getTransaction();
	
	et.begin();
	em.persist(mc);
	et.commit();
	
}

public List<MyContacts> getAllContacts() {
	EntityManagerFactory emf=Persistence.createEntityManagerFactory("suman");
	EntityManager em=emf.createEntityManager();
	
	Query q=em.createQuery("select c MyContacts c",MyContacts.class);
	List<MyContacts> contacts = q.getResultList() ;
	return contacts;
}
public MyContacts getcontactsById(int id) {
	EntityManagerFactory emf=Persistence.createEntityManagerFactory("suman");
	EntityManager em=emf.createEntityManager();
	MyContacts mc=em.find(MyContacts.class, id);
	return mc;
	}
public void updateContact(MyContacts mc) {
	EntityManagerFactory emf=Persistence.createEntityManagerFactory("suman");
	EntityManager em=emf.createEntityManager();
	EntityTransaction et=em.getTransaction();
	
	et.begin();
	em.merge(mc) ;
	et.commit();
	
}
public void deleteContact(int id) {
	EntityManagerFactory emf=Persistence.createEntityManagerFactory("suman");
	EntityManager em=emf.createEntityManager();
	EntityTransaction et=em.getTransaction();
	MyContacts mc=em.find(MyContacts.class, id);  
	
	et.begin();
	em.remove(mc) ;
	et.commit();
	
}

}

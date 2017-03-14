package facade;

import entities.CityInfo;
import entities.Company;
import entities.Hobby;
import entities.Person;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.TypedQuery;

/**
 *
 * @author madsr
 */
public class FacadeCurrent {

    public FacadeCurrent(EntityManagerFactory emf) {
        this.emf = emf;
    }

    EntityManagerFactory emf;

    public Person getPerson(long id) { //Kunne alternativt være telefonnummer
        EntityManager em = emf.createEntityManager();

        try {
            return em.find(Person.class, id);
        } finally {
            em.close();
        }
    }

    public List<Person> getHobbies(String hobby) { //Returns a list of the persons who has the same hobbies.

        EntityManager em = emf.createEntityManager();

        try {
            return em.createQuery("SELECT u FROM person WHERE hobbies = " + hobby).getResultList(); //Lidt usikker på min query, vi snakker lige om den.

        } finally {
            em.close();
        }
    }

    public int getHobbieCount(String hobby) { //Returns how many have the same hobbies. 

        EntityManager em = emf.createEntityManager();

        try {
            List<Person> persons = em.createQuery("SELECT u FROM person WHERE hobbies = " + hobby).getResultList();
            return persons.size();

//            En overvejelse hvor count(*) bruges. 
//            int count = em.createQuery("SELECT u, count(*) FROM person WHERE hobbies = " + hobby).executeUpdate(); 
//            return count;
        } finally {
            em.close();
        }
    }

    public List<Hobby> getCitizens(String postcode) {
        EntityManager em = emf.createEntityManager();

        try {
            return em.createQuery("").getResultList(); //Vi tager den lige imorgen om det her er noget vi skal kunne. 
        } finally {
            em.close();
        }
    }

    public void addPerson(Person p) {
        EntityManager em = emf.createEntityManager();

        try {
            em.getTransaction().begin();
            em.persist(p);
            em.getTransaction().commit();
        } finally {
            em.close();
        }
    }

    public void deletePerson(long id) {//Removes a person, could be phonenumber instead. 
        EntityManager em = emf.createEntityManager();

        try {
            em.getTransaction().begin();
            Person p = em.find(Person.class, id);
            em.remove(p);
            em.getTransaction().commit();
        } finally {
            em.close();
        }

    }

    public Person editPerson(Person p) //Need to edit a person? 
    {
        EntityManager em = emf.createEntityManager();

        try {

            em.getTransaction().begin();
            Person person = em.find(Person.class, p.getId());
            p = em.merge(person);
            em.getTransaction().commit();
            return p;
        } finally {
            em.close();
        }

    }

    public List<CityInfo> getAllCities() {
        EntityManager em = emf.createEntityManager();

        try {
            List<CityInfo> ci = em.createQuery("SELECT zip FROM cityinfo").getResultList();
            return ci;

        } finally {
            em.close();
        }
    }

    public List<Company> getCompanies(int employees) { //Gets the companies with x number of employees and above. 
        EntityManager em = emf.createEntityManager();
        
        try {
           return em.createQuery("SELECT u FROM company WHERE numEmployees <" + employees).getResultList(); 
           
        } finally {
            em.close(); 
        }

    }

}

package br.com.fredericci;

import br.com.fredericci.model.Person;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

public class Main {

    public static void main(String[] args) {

        EntityManagerFactory emf = Persistence.createEntityManagerFactory("PersonUnit");
        EntityManager em = emf.createEntityManager();


        em.getTransaction().begin();
        em.persist(createPerson(1, "Dennys Fredericci"));
        em.persist(createPerson(2, "Pietro Fredericci"));
        em.persist(createPerson(3, "Andrea Fredericci"));
        em.getTransaction().commit();

        TypedQuery<Person> query = em.createQuery("select p from Person p", Person.class);


        query.getResultStream().forEach(p -> System.out.println(p.getName()));


    }

    private static Person createPerson(int id, String name) {
        Person person = new Person();
        person.setId(id);
        person.setName(name);
        return person;
    }

}

import java.util.ArrayList;
import java.util.List;

import logic.Person;

import org.hibernate.Session;

import until.HibernateUntil;


public class Main {

  public static void main(String[] args) {
    Session session = HibernateUntil.getSessionFactory().openSession();
    List<Person>persons = new ArrayList<Person>();
    
    try{
    session.beginTransaction();
    persons = session.createCriteria(Person.class).list();
    for (int i = 0; i < persons.size(); i++) {
      System.out.println(persons.get(i));
    }
    }catch(Exception e){
     System.err.println("Exeption "+e); 
    }finally{
      session.close();
    }
  }
}

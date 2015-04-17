package until;

import org.hibernate.HibernateException;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateUntil {

  private static SessionFactory sessionFactory = null;
  
  static{
    try{
      Configuration configuration = new Configuration();
      configuration.configure("hibernate.cfg.xml");
      sessionFactory = configuration.buildSessionFactory();
    }catch(HibernateException e){
      System.out.println(e);
    }catch (Exception e) {
      System.out.println(e);
    }
  }
  public static SessionFactory getSessionFactory(){
    return sessionFactory;
  }
      
}

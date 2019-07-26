
package dao;


import org.hibernate.FlushMode;
import org.hibernate.Session;
import org.hibernate.context.internal.ManagedSessionContext;
import dao.HibernateUtil;



public abstract class ManagedSessionUnitTest  {


   protected org.hibernate.Session createNewSession() {
      org.hibernate.Session session = HibernateUtil.getSessionFactory().openSession();
      session.setFlushMode(FlushMode.MANUAL);
      ManagedSessionContext.bind(session);
      return (org.hibernate.Session) session;
   }


   protected void startNewTransaction(Session session) {
      session.beginTransaction();
   }

 
   protected org.hibernate.Session createNewSessionAndTransaction() {
      Session session = createNewSession();
      startNewTransaction(session);
      return session;
   }


   protected void commitTransaction(Session session) {
      ManagedSessionContext.unbind(HibernateUtil.getSessionFactory());
      session.flush();
      session.getTransaction().commit();
      session.close();
   }

}

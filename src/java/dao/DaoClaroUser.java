package dao;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import pojo.TbUserDth;




public class DaoClaroUser extends ManagedSessionUnitTest{
    
    
     public DaoClaroUser(){
    
    }
    
     public List<Object> getValidateUser(String password, String user){
  
     Session session = this.createNewSessionAndTransaction();
      
      List<Object> tbClaroUser = null;
       
       try{           
           tbClaroUser= session.createQuery("select claroUser.firstName,claroUser.lastName "
           + "from TbUserDth claroUser where "
           + "claroUser.password='"+password+"' and claroUser.userName='"+user+"'").list();   
           
       } finally
       {
           
           this.commitTransaction(session);
        
       }
       
       return tbClaroUser;
  
  }
     
     public List<TbUserDth> getUser(String id){
  
     long val=0;
     val=Integer.parseInt(id);
     
     Session session = this.createNewSessionAndTransaction();
      
      List<TbUserDth> tbClaroUser = null;
       
       try{
           
           tbClaroUser= session.createQuery("from TbUserDth claroUser where claroUser.idUser="+val+"").list();   
           
       } finally
       {
           
           this.commitTransaction(session);
        
       }
       
       return tbClaroUser;
  
  }
     
    public void setUser(BigDecimal idUser, String firstName , String lastName, String userName){    
     
     Session session = this.createNewSessionAndTransaction();
     
     Date dateCreate = new Date();    
         
     TbUserDth user = new TbUserDth(idUser, firstName,lastName,userName);
     
     
     try{     
    
        session.persist(user);  
    
        } finally
        {
                
            this.commitTransaction(session);
    
        }
  
  }  
     
 
    
      
     
}
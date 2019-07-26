/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.math.BigDecimal;
import java.sql.Clob;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import modelo.ConnectionBd;
import modelo.DriverConnection;
import oracle.jdbc.OracleConnection;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.AnnotationConfiguration;
import pojo.IdentityIdentifier;
import pojo.TbUserDth;
import pojo.TbCasCommand;



public class DaoDthTrx  extends ManagedSessionUnitTest {
    
    
     public DaoDthTrx(){
         
    
    }
     
     
     public void setDth(String idTrx, String trxType , Date trxDate,String xmlParam,Date lastModDate,String status,String lote,String stb, String ip) throws SQLException{    
     
     SessionFactory sessionFactory  = new AnnotationConfiguration().configure().buildSessionFactory(); 
     Session session = sessionFactory.openSession(); 
     session.beginTransaction();
         
     TbCasCommand tbCas = new TbCasCommand(idTrx, trxType,trxDate,xmlParam,lastModDate,status,lote,stb,ip);
     
     
     try{     
    
        session.persist(tbCas);  
     
    
        } finally
        {
                
            session.getTransaction().commit();
            session.evict(tbCas);
            session.close();
         
    
        }
  
  }  
     
     public void setList(List<TbCasCommand> listDth) throws SQLException{ 
         

     
     //Session session = this.createNewSessionAndTransaction();
     
     SessionFactory sessionFactory2  = new AnnotationConfiguration().configure().buildSessionFactory(); 
     Session session2 = sessionFactory2.openSession(); 
     session2.beginTransaction(); 
      
     int size = listDth.size();
     
     
     try{    
     for (int i=0;i<size;i++){
             
        String xmlParam= listDth.get(i).getXmlParam();
        String idTrx = listDth.get(i).getIdTrx();
        String trxType = listDth.get(i).getTrxType();
        Date trxDate = listDth.get(i).getTrxDate();
        Date lastModDate = listDth.get(i).getTrxDate();
        String status = listDth.get(i).getStatus();     
        String lote = listDth.get(i).getLote();             
        String stb = listDth.get(i).getStb();
        String ip = listDth.get(i).getIp();
        TbCasCommand tbCas = new TbCasCommand(idTrx, trxType,trxDate,xmlParam,lastModDate,status,lote,stb,ip);             
        session2.persist(tbCas);  
    
        //session.evict(tbCas);
      
     
     }
      } finally
        {                
               session2.getTransaction().commit();
                   
         
             
    
        }
  }
     
     public String getSequence() throws SQLException{         
         ConnectionBd connection = new ConnectionBd();
         DriverConnection driver = new DriverConnection();
         ArrayList<String[]>  val =connection.getSequence(driver);         
         String value = val.get(0)[0];       
         return value;
     }
     

    
}

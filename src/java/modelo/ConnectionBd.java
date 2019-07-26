
package modelo;


import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Properties;
import pojo.TbCasCommand;



public class ConnectionBd {
    
    private Connection con = null;
    private PreparedStatement pr = null;
    private ResultSet rs = null;


    public ArrayList<String[]> getSequence(DriverConnection driverConnection) throws SQLException {
          ArrayList<String[]> sequence = new ArrayList<String[]>();
        try {         
            con = driverConnection.getCon();
            String sql = "select SEQ_DTH_FILE.nextval from dual";
            pr = con.prepareStatement(sql);   
            rs = pr.executeQuery();
            ResultSetMetaData rsmd = rs.getMetaData();
            int columnsNumber = rsmd.getColumnCount();    
            int valResp = rs.getRow();
            
            
           while (rs.next()) {
             String[] column = new String[columnsNumber];  
               int cont=0;
             while (columnsNumber >cont) {
             column[cont] = rs.getString(cont+1);
              cont++;
             }
               sequence.add(column);
           }
           
        } catch (SQLException ex) {
            System.out.println("Error SQL"+" "+ex);        
        }
        
        pr.close();
        rs.close();
      
            
         return sequence;
     }
    
    public void insertPack(ArrayList<TbCasCommand> list,DriverConnection connection) {
          int cont =  0;
          String sql="";
        try {           
              
            while (list.size()>cont) { 
                
            sql = "INSERT INTO TB_CAS_COMMAND " 
            + " (ID_TRX, TRX_TYPE, TRX_DATE, XML_PARAM, STATUS, LAST_MOD_DATE, LOTE,IP,STB)" +
            " VALUES (?,?,?,?,?,?,?,?,?)";
            
            java.util.Date utilStartDate = list.get(cont).getTrxDate();
            java.sql.Date sqlStartDate = new java.sql.Date(utilStartDate.getTime());
            
            con = connection.getCon();
            pr = con.prepareStatement(sql);
            pr.setString(1, list.get(cont).getIdTrx());
            pr.setString(2, list.get(cont).getTrxType());
            pr.setDate(3, sqlStartDate);
            pr.setString(4, list.get(cont).getXmlParam());     
            pr.setString(5, list.get(cont).getStatus());
            pr.setDate(6, sqlStartDate);
            pr.setString(7, list.get(cont).getLote());
            pr.setString(8, list.get(cont).getIp());
            pr.setString(9, list.get(cont).getStb());
            
            pr.executeUpdate();    
            cont++;
            }           
           
            connection.getCon().commit();
           
        } catch (SQLException ex) {
            System.out.println(ex);
            System.out.println("Error SQL"+" "+ex);
            System.out.println("Rolling back data here.....");
            try{
		 if(con!=null)
                 con.rollback();
            }catch(SQLException se2){
         se2.printStackTrace();
      }//end try
            
        }finally {
            if (con != null) {
                try {
                   System.out.println("Insert");
                     pr.close();                    
                     rs.close();
                     con.close();
                } catch (Exception ignored) {
                    System.out.println("Error SQL"+" "+ignored);
                    // ignore
                }

            }
        }
        
     }
    
   
    
     
  }


package servlet;

import dao.DaoClaroUser;
import dao.DaoDthTrx;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.InetAddress;
import java.sql.SQLException;
import java.util.Date;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import pojo.TbCasCommand;
import pojo.XmlDth;

/**
 *
 * @author LENOVO
 */
public class DthMain extends HttpServlet {


    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
 
    }


    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

  
      @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
        
//        String val = request.getHeader("x-forwarded-for");
//        String val2 = request.getHeader("x-real-ip");
//        
//        String valRempote = request.getRemoteAddr();
//        
//        String ipAdress = InetAddress.getLocalHost().getHostAddress();
        
        
         PrintWriter out = response.getWriter();
         String option = "";
         int valOption = 0;
         String ip = request.getRemoteAddr();
         try  {
           DaoDthTrx daoDth = new DaoDthTrx();
           TransactionVal transaction = new TransactionVal();
           
 
            
            Map<String, String> result = new HashMap<>();

            Enumeration headerNames = request.getHeaderNames();
            
            while (headerNames.hasMoreElements()) {
            String key = (String) headerNames.nextElement();
            String value = request.getHeader(key);
            result.put(key, value);
        }

 
              
            
            
            String status = "P";
            String stb = request.getParameter("stb");
            option = request.getParameter("option");
            String address = request.getParameter("address");   
            String packs = request.getParameter("packs"); 
            String trxType = request.getParameter("option");
            Date trxDate = new Date();
            Date lastModDate = trxDate;
            String trxId = transaction.sequence(stb);
            String lote = "-1";
            
            valOption = Integer.parseInt(option);
            
            if(valOption==2 || valOption==7){
            packs="0";
            }
            
            
       
           
            XmlDth xmlDth = new XmlDth();
            String xmlRead = xmlDth.getXml(stb, address, packs);
            
            try {
                daoDth.setDth(trxId, trxType, trxDate, xmlRead, lastModDate,status,lote,stb,ip);

            } catch (SQLException ex) {
                Logger.getLogger(DthMain.class.getName()).log(Level.SEVERE, null, ex);
            }
            
        } finally{        
             PrintWriter outHtml = response.getWriter(); 
             outHtml.println("Procesado");
             
             
             
             switch(valOption){
                 case 1:
                      response.sendRedirect("creacion.jsp");
                      break;
                 case 2:
                      response.sendRedirect("borrar.jsp");
                      break;
                 case 3:
                      response.sendRedirect("enabled.jsp");
                      break;
                 case 4:
                      response.sendRedirect("disabled.jsp");
                      break;
                 case 7:
                      response.sendRedirect("borrarCintillo.jsp");
                      break;
                }
             
             
            
           
        }
    }

    
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}

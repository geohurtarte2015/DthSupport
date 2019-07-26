
package servlet;


import dao.DaoDthTrx;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;
import modelo.ConnectionBd;
import modelo.DriverConnection;
import org.apache.tomcat.util.http.fileupload.servlet.ServletFileUpload;
import pojo.TbCasCommand;
import pojo.XmlDth;


@WebServlet("/upload")
@MultipartConfig
public class Upload extends HttpServlet {
    
          
      private  String UPLOAD_DIR = "uploads";
    
     

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
          try {
              //String description = request.getParameter("description"); // Retrieves <input type="text" name="description">
              boolean isMultipart = ServletFileUpload.isMultipartContent(request);
              
              String host = request.getRemoteHost();
              String ip = request.getRemoteAddr();
              String user = request.getSession().getId();
              
              //int option = Integer.parseInt(request.getParameter("option"));
              String fileName = "";
              
              // gets absolute path of the web application
              String applicationPath = request.getServletContext().getRealPath("");
              // constructs path of the directory to save uploaded file
              String uploadFilePath = applicationPath + UPLOAD_DIR;
              
              // creates upload folder if it does not exists
              File uploadFolder = new File(uploadFilePath);
              if (!uploadFolder.exists()) {
                  uploadFolder.mkdirs();
              }
              
              for (Part part : request.getParts()) {
                  fileName = extractFileName(part);
                  // refines the fileName in case it is an absolute path
                  fileName = new File(fileName).getName();
                  part.write(uploadFilePath + File.separator + fileName);
              }
              
              String csvFile  = uploadFilePath + File.separator + fileName;
              
              BufferedReader br = null;
              String line = "";
              String cvsSplitBy = ";";
              TransactionVal transaction = new TransactionVal();
              
              DaoDthTrx daoDth = new DaoDthTrx();
              XmlDth xmlDth = new XmlDth();
              List<TbCasCommand> listDth = new ArrayList<TbCasCommand>();
              
              br = new BufferedReader(new FileReader(csvFile));
              
              String lote = daoDth.getSequence();
                  
              
              int val =1 ;
              String trxType = "1";
              Date trxDate = new Date();
              Date lastModDate = trxDate;
              while ((line = br.readLine()) != null) {                  
                  if (val>1){
                      TbCasCommand tbCasCommand = new TbCasCommand();
                    
                      // use comma as separator
                      String[] lineCsv = line.split(cvsSplitBy);
                      String trxId = transaction.sequence(lineCsv[0]);
                      String xmlRead = xmlDth.getXml(lineCsv[0], lineCsv[1], lineCsv[2]);
                      
                      tbCasCommand.setIdTrx(trxId);
                      tbCasCommand.setStatus("P");
                      tbCasCommand.setTrxType(trxType);
                      tbCasCommand.setTrxDate(trxDate);
                      tbCasCommand.setLastModDate(lastModDate);
                      tbCasCommand.setXmlParam(xmlRead);
                      tbCasCommand.setLote(lote);
                      tbCasCommand.setStb(lineCsv[0]);
                      tbCasCommand.setIp(ip);
                      
                      
                      listDth.add(tbCasCommand);
                      //System.out.println(lineCsv);
                      
                  }
                  val++;
              }
              
              DriverConnection driver = new DriverConnection();
              ConnectionBd bd = new ConnectionBd();
              bd.insertPack((ArrayList<TbCasCommand>) listDth, driver);
                                      
              
              //DELETE FILE
               br.close();
               
               
               File file = new File(csvFile); 
          
                if(file.delete()) 
                { 
                    System.out.println("File deleted successfully"); 
                } 
                else
                { 
                    System.out.println("Failed to delete the file"); 
                } 

              
                            
              
              

          } catch (SQLException ex) {
              Logger.getLogger(Upload.class.getName()).log(Level.SEVERE, null, ex);
          }
        
           response.sendRedirect("creacion.jsp");
        
        
        
    }
    
    private String extractFileName(Part part) {
        String contentDisp = part.getHeader("content-disposition");
        String[] items = contentDisp.split(";");
        for (String s : items) {
            if (s.trim().startsWith("filename")) {
                return s.substring(s.indexOf("=") + 2, s.length()-1);
            }
        }
        return "";
    }


    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}

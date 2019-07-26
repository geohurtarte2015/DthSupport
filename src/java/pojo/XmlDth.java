/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pojo;


public class XmlDth {   
    
    public String getXml(String stu,String address,String packs){
     String xmlPacks = "";
     
     String[] listPacks = packs.split(",");
     int size = listPacks.length;
    for (int i=0;i<size;i++){
        if(i>0){
            xmlPacks=xmlPacks+"<Paquete><id>"+listPacks[i]+"</id></Paquete>";
        }else{
         xmlPacks="<Paquete><id>"+listPacks[i]+"</id></Paquete>";    
         }
        }
        
        String xml="<Command_DTH_CAS><NumeroST>"+stu+"</NumeroST>"
                + "<Address>"+address+"</Address>"
                + "<Paquetes>"
                + xmlPacks
                + "</Paquetes>"
                + "</Command_DTH_CAS>";
    
    return xml;
    }
    
}

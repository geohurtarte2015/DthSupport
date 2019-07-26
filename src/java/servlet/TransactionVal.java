/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlet;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;


public class TransactionVal {
    
    public String sequence(String number){
     String sequence="";
     String ultimateDigits="";
     String dthc = "DTHCCT";
     if(number.length()>=3){
     ultimateDigits = number.substring(number.length()-4);
     }else{
     ultimateDigits="000";
     }
     DateFormat newFormat = new SimpleDateFormat("yyyyMMddHHmmssSSS");
     Date date = new Date();
     sequence = dthc+newFormat.format(date).trim()+ultimateDigits;

return sequence;
}
    
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pojo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;

@Entity(name = "identityIdentifier")
public class IdentityIdentifier {
    
    @Id     
    @GeneratedValue(strategy=GenerationType.AUTO, generator="dthClaroSeqGen")
    @SequenceGenerator(name = "dthClaroSeqGen", sequenceName = "SEQ_CLARO_VIDEO_USER")
    private Long id;
    
    
    
    
}

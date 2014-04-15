package gov.dhs.uscis.kata.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Data
@Table(name="DOCUMENTS")
public class Document {
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)	
	private Long id;
	private String description;
	
	

}

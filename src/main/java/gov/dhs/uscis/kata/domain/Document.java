package gov.dhs.uscis.kata.domain;

import javax.persistence.Entity;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Data
@Table(name="DOCUMENTS")
public class Document {
	
	private Long id;
	private String description;
	
	

}

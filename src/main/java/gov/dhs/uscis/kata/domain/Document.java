package gov.dhs.uscis.kata.domain;

import javax.persistence.Basic;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import gov.dhs.uscis.kata.domain.DocumentStatus;
import lombok.Data;

@Entity
@Data
@Table(name="DOCUMENTS")
public class Document {
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)	
	private Long id;
	private String description;
	
	@Basic
    @Enumerated(EnumType.STRING)	
	private DocumentStatus  documentStatus = DocumentStatus.SUBMITTED;
	
	

}

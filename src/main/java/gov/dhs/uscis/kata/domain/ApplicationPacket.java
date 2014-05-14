package gov.dhs.uscis.kata.domain;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import org.hibernate.annotations.Type;
import org.joda.time.DateTime;


@Entity
@Getter
@Setter
@ToString(exclude = "documents")
@Table(name = "APPLICANT_PACKET")

public class ApplicationPacket {
	@Id
	@GeneratedValue	
	private Long id;
	@Enumerated(EnumType.ORDINAL)
	private DegreeTypeEnum degreeType;
	@ManyToOne( optional = false, fetch=FetchType.LAZY)
	private Applicant applicant;
	@Basic
    @Enumerated(EnumType.STRING)
	private DepartmentEnum deparment;

	@Type(type = "org.jadira.usertype.dateandtime.joda.PersistentDateTime")
	private DateTime submiteddDate;
	@Enumerated(EnumType.STRING)
    private ApplicationStatusEnum applicationStatusEnum = ApplicationStatusEnum.DRAFT;
    
	@OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
	private Set<Document> documents = new HashSet<Document>();

}

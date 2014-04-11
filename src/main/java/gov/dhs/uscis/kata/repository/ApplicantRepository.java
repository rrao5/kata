package gov.dhs.uscis.kata.repository;

import java.util.List;

import gov.dhs.uscis.kata.domain.Applicant;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface ApplicantRepository extends CrudRepository<Applicant, Long> {
	
	List<Applicant> findByLastName(String lastName);

}

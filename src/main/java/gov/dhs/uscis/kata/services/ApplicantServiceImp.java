package gov.dhs.uscis.kata.services;

import gov.dhs.uscis.kata.domain.Applicant;
import gov.dhs.uscis.kata.repository.ApplicantRepository;




import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class ApplicantServiceImp implements ApplicantService {

	@Autowired
	ApplicantRepository applicantRepository;
	
	@Override
	public Applicant createApplicant(Applicant applicant) {
		return applicantRepository.save(applicant);
	}

}

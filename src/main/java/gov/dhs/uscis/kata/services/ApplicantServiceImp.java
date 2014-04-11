package gov.dhs.uscis.kata.services;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import gov.dhs.uscis.kata.domain.Applicant;
import gov.dhs.uscis.kata.repository.ApplicantRepository;

@Component("applicationService")
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

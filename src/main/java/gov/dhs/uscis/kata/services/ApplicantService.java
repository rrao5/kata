package gov.dhs.uscis.kata.services;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import gov.dhs.uscis.kata.domain.Applicant;

public interface ApplicantService {
	
	public Applicant createApplicant(Applicant applicant);

}

package gov.dhs.uscis.kata.domain;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public enum ApplicationStatusEnum {
	DRAFT, SUBMITTED, ACCEPTED, REJECTED;

}

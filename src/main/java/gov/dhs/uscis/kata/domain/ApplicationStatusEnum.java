package gov.dhs.uscis.kata.domain;

import lombok.EnumId;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public enum ApplicationStatusEnum {
	DRAFT(0), SUBMITTED(1), ACCEPTED(2), REJECTED(4);

	@EnumId
	@Getter
	private final int code;
}

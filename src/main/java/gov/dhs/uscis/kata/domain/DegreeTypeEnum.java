package gov.dhs.uscis.kata.domain;

import lombok.EnumId;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public enum DegreeTypeEnum {
	ASSOCIATES(0), BACHELORS(1), MASTERS(2), PHD(4);

	@EnumId
	@Getter
	private final int code;
}

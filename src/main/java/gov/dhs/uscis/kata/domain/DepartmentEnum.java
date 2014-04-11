package gov.dhs.uscis.kata.domain;

import lombok.EnumId;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public enum DepartmentEnum {
	MATH(0), PHYSICS(1), CHEMISTRY(2), IT(3), MANAGEMENT(4);

	@EnumId
	@Getter
	private final int code;

}

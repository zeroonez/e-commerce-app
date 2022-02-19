package com.ecommerce.common.converter;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;
import java.util.Arrays;
import java.util.Collections;
import java.util.Set;
import java.util.UUID;
import java.util.stream.Collectors;

@Converter
public class UuidSetConverter implements AttributeConverter<Set<UUID>, String> {
	private static final String SPLIT_CHAR = ",";

	@Override
	public String convertToDatabaseColumn(Set<UUID> uuids) {
		if (uuids.isEmpty()) {
			return "";
		}
		Set<String> uuidsInStrings = uuids.stream().map(UUID::toString).collect(Collectors.toSet());
		return String.join(SPLIT_CHAR, uuidsInStrings);
	}

	@Override
	public Set<UUID> convertToEntityAttribute(String objectsString) {
		if (objectsString == null || objectsString.equals("")) {
			return Collections.emptySet();
		}
		return Arrays.stream(objectsString.split(SPLIT_CHAR)).map(UUID::fromString).collect(Collectors.toSet());
	}
}

package com.github.bogdanovmn.humanreadablevalues;

import lombok.Builder;
import lombok.NonNull;
import lombok.Value;

@Value
@Builder
public class FractionDefinition {
	long minimalUnitsAmount;
	@NonNull
	String shortNotation;
	String name;
}

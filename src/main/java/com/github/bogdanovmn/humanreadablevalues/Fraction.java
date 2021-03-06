package com.github.bogdanovmn.humanreadablevalues;

import lombok.Builder;
import lombok.NonNull;
import lombok.Value;

@Value
@Builder
class Fraction {
	@NonNull
	FractionDefinition definition;
	long value;
}

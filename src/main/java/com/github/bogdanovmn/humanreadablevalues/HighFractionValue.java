package com.github.bogdanovmn.humanreadablevalues;

import lombok.Builder;
import lombok.Value;

@Builder
@Value
public class HighFractionValue {
	double value;
	FractionDefinition definition;
}

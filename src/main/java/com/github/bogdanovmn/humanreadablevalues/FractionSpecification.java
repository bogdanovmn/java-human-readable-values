package com.github.bogdanovmn.humanreadablevalues;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class FractionSpecification {
	private final List<FractionDefinition> definitions;

	public FractionSpecification(FractionDefinition... definitions) {
		if (definitions == null || definitions.length == 0) {
			throw new IllegalStateException("At least one fraction has been expected");
		}
		this.definitions = Stream.of(definitions)
			.sorted(
				Comparator.comparingLong(FractionDefinition::minimalUnitsAmount)
					.reversed()
			).collect(Collectors.toList());
	}

	public List<FractionDefinition> definitions() {
		return new ArrayList<>(definitions);
	}

	public Fraction minimalValue() {
		return Fraction.builder()
			.definition(
				lowFractionDefinition()
			)
			.value(0)
		.build();
	}

	public FractionDefinition lowFractionDefinition() {
		return definitions.get(definitions.size() - 1);
	}
}

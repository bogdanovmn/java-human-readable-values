package com.github.bogdanovmn.humanreadablevalues;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.stream.Collectors;

public abstract class FractionatedValue {
	private final FractionSpecification specification;
	private final long value;

	public FractionatedValue(long value, FractionSpecification specification) {
		this.value = value;
		this.specification = specification;
	}

	public String fullString() {
		return allFractions().stream()
			.map(fraction ->
				String.format("%d%s",
					fraction.value(),
					fraction.definition().shortNotation()
				)
			)
			.collect(Collectors.joining(" "));
	}

	public final List<Fraction> allFractions() {
		List<Fraction> result = new ArrayList<>();
		long currentValue = value;
		for (FractionDefinition fractionDefinition : specification.definitions()) {
			long fractionValue = currentValue / fractionDefinition.minimalUnitsAmount();
			if (fractionValue != 0) {
				result.add(
					Fraction.builder()
						.definition(fractionDefinition)
						.value(fractionValue)
					.build()
				);
			}
			currentValue = value % fractionDefinition.minimalUnitsAmount();
			if (currentValue == 0) {
				break;
			}
		}
		if (result.isEmpty()) {
			result.add(
				specification.minimalValue()
			);
		}
		return result;
	}

	public String shortString() {
		HighFractionValue highFraction = highFractionValue();
		return String.format(Locale.ROOT, "%.1f%s", highFraction.value(), highFraction.definition().shortNotation());
	}

	public final HighFractionValue highFractionValue() {
		for (FractionDefinition fractionDefinition : specification.definitions()) {
			long fractionValue = value / fractionDefinition.minimalUnitsAmount();
			if (fractionValue != 0) {
				return HighFractionValue.builder()
					.definition(fractionDefinition)
					.value(value / (1.0* fractionDefinition.minimalUnitsAmount()))
				.build();
			}
		}
		return HighFractionValue.builder()
			.definition(specification.lowFractionDefinition())
			.value(0)
		.build();
	}
}

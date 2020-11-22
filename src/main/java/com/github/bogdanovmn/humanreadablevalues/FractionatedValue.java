package com.github.bogdanovmn.humanreadablevalues;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public abstract class FractionatedValue {
	private final List<Fraction> fractions;
	private final long value;

	public FractionatedValue(long value, List<Fraction> fractions) {
		if (fractions.isEmpty()) {
			throw new IllegalStateException("At least one fraction has been expected");
		}
		this.value = value;
		this.fractions = fractions.stream()
			.sorted(
				Comparator.comparingLong(Fraction::getMinimalUnitsAmount)
					.reversed()
			).collect(Collectors.toList());
	}

	public final String fullView() {
		List<String> result = new ArrayList<>();
		long currentValue = value;
		for (Fraction fraction : fractions) {
			long fractionValue = currentValue / fraction.getMinimalUnitsAmount();
			if (fractionValue != 0) {
				result.add(
					String.format("%d%s", fractionValue, fraction.getShortNotation())
				);
			}
			currentValue = value % fraction.getMinimalUnitsAmount();
			if (currentValue == 0) {
				break;
			}
		}
		return result.isEmpty()
			? minimalValue()
			: String.join(" ", result);
	}

	public final String shortView() {
		for (Fraction fraction : fractions) {
			long fractionValue = value / fraction.getMinimalUnitsAmount();
			if (fractionValue != 0) {
				return String.format("%.1f%s", value / (1.0*fraction.getMinimalUnitsAmount()), fraction.getShortNotation());
			}
		}
		return minimalValue();
	}

	private String minimalValue() {
		return String.format(
			"0%s",
			fractions.get(fractions.size() - 1)
				.getShortNotation()
		);
	}
}

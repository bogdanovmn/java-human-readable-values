package com.github.bogdanovmn.humanreadablevalues;

import java.util.Arrays;

public class BytesValue extends FractionatedValue {
	public BytesValue(long seconds) {
		super(
			seconds,
			Arrays.asList(
				Fraction.builder()
					.name("byte")
					.shortNotation("b")
					.minimalUnitsAmount(1)
				.build(),

				Fraction.builder()
					.name("kilobyte")
					.shortNotation("K")
					.minimalUnitsAmount(1024)
				.build(),

				Fraction.builder()
					.name("megabyte")
					.shortNotation("M")
					.minimalUnitsAmount(1024 * 1024)
				.build(),

				Fraction.builder()
					.name("gigabyte")
					.shortNotation("G")
					.minimalUnitsAmount(1024 * 1024 * 1024)
				.build()
			)
		);
	}
}

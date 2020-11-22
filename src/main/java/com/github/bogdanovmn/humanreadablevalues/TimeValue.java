package com.github.bogdanovmn.humanreadablevalues;

import java.util.Arrays;

public class TimeValue extends FractionatedValue {
	public TimeValue(long seconds) {
		super(
			seconds,
			Arrays.asList(
				Fraction.builder()
					.name("second")
					.shortNotation("s")
					.minimalUnitsAmount(1)
				.build(),

				Fraction.builder()
					.name("minute")
					.shortNotation("m")
					.minimalUnitsAmount(60)
				.build(),

				Fraction.builder()
					.name("hour")
					.shortNotation("h")
					.minimalUnitsAmount(3600)
				.build(),

				Fraction.builder()
					.name("day")
					.shortNotation("d")
					.minimalUnitsAmount(3600*24)
				.build(),

				Fraction.builder()
					.name("week")
					.shortNotation("w")
					.minimalUnitsAmount(3600*24*7)
				.build()
			)
		);
	}
}

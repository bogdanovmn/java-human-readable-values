package com.github.bogdanovmn.humanreadablevalues;

public class SecondsValue extends FractionatedValue {
	public SecondsValue(long seconds) {
		super(
			seconds,
			new FractionSpecification(
				FractionDefinition.builder()
					.name("second")
					.shortNotation("s")
					.minimalUnitsAmount(1)
				.build(),

				FractionDefinition.builder()
					.name("minute")
					.shortNotation("m")
					.minimalUnitsAmount(60)
				.build(),

				FractionDefinition.builder()
					.name("hour")
					.shortNotation("h")
					.minimalUnitsAmount(3600)
				.build(),

				FractionDefinition.builder()
					.name("day")
					.shortNotation("d")
					.minimalUnitsAmount(3600*24)
				.build(),

				FractionDefinition.builder()
					.name("week")
					.shortNotation("w")
					.minimalUnitsAmount(3600*24*7)
				.build()
			)
		);
	}
}

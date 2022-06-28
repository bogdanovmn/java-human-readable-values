package com.github.bogdanovmn.humanreadablevalues;

public class MillisecondsValue extends FractionatedValue {
	public MillisecondsValue(long mills) {
		super(
			mills,
			new FractionSpecification(
                FractionDefinition.builder()
                    .name("millisecond")
                    .shortNotation("ms")
                    .minimalUnitsAmount(1)
                    .build(),

				FractionDefinition.builder()
					.name("second")
					.shortNotation("s")
					.minimalUnitsAmount(1000)
				.build(),

				FractionDefinition.builder()
					.name("minute")
					.shortNotation("m")
					.minimalUnitsAmount(60_000)
				.build(),

				FractionDefinition.builder()
					.name("hour")
					.shortNotation("h")
					.minimalUnitsAmount(3600_000)
				.build(),

				FractionDefinition.builder()
					.name("day")
					.shortNotation("d")
					.minimalUnitsAmount(3600*24_000)
				.build(),

				FractionDefinition.builder()
					.name("week")
					.shortNotation("w")
					.minimalUnitsAmount(3600*24*7_000)
				.build()
			)
		);
	}
}

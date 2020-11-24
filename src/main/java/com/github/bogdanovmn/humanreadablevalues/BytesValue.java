package com.github.bogdanovmn.humanreadablevalues;

public class BytesValue extends FractionatedValue {
	public BytesValue(long seconds) {
		super(
			seconds,
			new FractionSpecification(
				FractionDefinition.builder()
					.name("byte")
					.shortNotation("b")
					.minimalUnitsAmount(1)
				.build(),

				FractionDefinition.builder()
					.name("kilobyte")
					.shortNotation("K")
					.minimalUnitsAmount(1024)
				.build(),

				FractionDefinition.builder()
					.name("megabyte")
					.shortNotation("M")
					.minimalUnitsAmount(1024 * 1024)
				.build(),

				FractionDefinition.builder()
					.name("gigabyte")
					.shortNotation("G")
					.minimalUnitsAmount(1024 * 1024 * 1024)
				.build()
			)
		);
	}
}

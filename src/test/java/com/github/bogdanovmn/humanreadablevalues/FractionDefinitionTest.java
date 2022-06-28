package com.github.bogdanovmn.humanreadablevalues;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class FractionDefinitionTest {

	@Test
	public void view() {
        assertEquals(
            "1h 1s 50ms",
            new MillisecondsValue(3600_000 + 1050).fullString()
        );

        assertEquals(
            "1.1s",
            new MillisecondsValue(1050).shortString()
        );

		assertEquals(
			"10h 30m",
			new SecondsValue(3600*10 + 60*30).fullString()
		);

		assertEquals(
			"10.5h",
			new SecondsValue(3600*10 + 60*30).shortString()
		);

		assertEquals(
			"10M 500K",
			new BytesValue(10*1024*1024 + 500*1024).fullString()
		);

		assertEquals(
			"10.5M",
			new BytesValue(10*1024*1024 + 500*1024).shortString()
		);

		assertEquals(
			"10M 500K",
			new BytesValue(10*1024*1024 + 500*1024).fullString()
		);

		assertEquals(
			"0b",
			new BytesValue(0).fullString()
		);

		assertEquals(
			"0.0s",
			new SecondsValue(0).shortString()
		);
	}
}
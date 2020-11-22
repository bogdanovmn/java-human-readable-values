package com.github.bogdanovmn.humanreadablevalues;

import org.junit.Test;

import static org.junit.Assert.*;

public class FractionTest {

	@Test
	public void view() {
		assertEquals(
			"10h 30m",
			new TimeValue(3600*10 + 60*30).fullView()
		);

		assertEquals(
			"10.5h",
			new TimeValue(3600*10 + 60*30).shortView()
		);

		assertEquals(
			"10M 500K",
			new BytesValue(10*1024*1024 + 500*1024).fullView()
		);

		assertEquals(
			"10.5M",
			new BytesValue(10*1024*1024 + 500*1024).shortView()
		);

		assertEquals(
			"10M 500K",
			new BytesValue(10*1024*1024 + 500*1024).fullView()
		);

		assertEquals(
			"0b",
			new BytesValue(0).fullView()
		);

		assertEquals(
			"0s",
			new TimeValue(0).shortView()
		);
	}
}
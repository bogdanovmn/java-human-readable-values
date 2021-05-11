

# Overview

A small library that will help you to get convenient for analyzing values. For instance, a big amount of seconds or bytes.

# How to use it

## 1. Get the latest dependency
[![Maven Central](
    https://maven-badges.herokuapp.com/maven-central/com.github.bogdanovmn.humanreadablevalues/human-readable-values/badge.svg
)]( https://maven-badges.herokuapp.com/maven-central/com.github.bogdanovmn.humanreadablevalues/human-readable-values)
```xml
<dependency>
    <groupId>com.github.bogdanovmn.humanreadablevalues</groupId>
    <artifactId>human-readable-values</artifactId>
    <version>...</version>
</dependency>
```

## 2. Print out your values
### Seconds
```java
assertEquals(
	"2h 46m 40s",
	new SecondsValue(10000).fullString()
);

assertEquals(
	"2.8h",
	new SecondsValue(10000).shortString()
);
```

### Bytes
```java
assertEquals(
	"9K 784b",
	new BytesValue(10000).fullString()
);

assertEquals(
	"9.8K",
	new BytesValue(10000).shortString()
);

```

## 3. Customization
### Define a custom type
```java
public class MyTypeValue extends FractionatedValue {
	public MyTypeValue(long value) {
		super(
			value,
			new FractionSpecification(
				FractionDefinition.builder()
					.name("the minimal fraction unit")
					.shortNotation("mu")
					.minimalUnitsAmount(1)
				.build(),

				FractionDefinition.builder()
					.name("another fraction unit")
					.shortNotation("afu")
					.minimalUnitsAmount(60)
				.build(),

				FractionDefinition.builder()
					.name("the last fraction unit")
					.shortNotation("lfu")
					.minimalUnitsAmount(3600)
				.build()
			)
		);
	}
}
```
```java
assertEquals(
	"2lfu 46afu 40mu",
	new MyTypeValue(10000).fullString()
);
```
### Using of custom formatting
The base class `FractionatedValue` has methods that return components of the divided on fractions value so you can use them for your better formatting

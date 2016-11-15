package com.jaosn.gwtproject.shared.utils;

// Because GWT Client side cannot use the Apache Common Language Library
public class ToStringBuilder {
	private final StringBuilder buffer = new StringBuilder();

	private final Object object;

	public ToStringBuilder(Object object) {
		if (object == null) {
			throw new IllegalArgumentException("Non-null object expected.");
		}

		this.object = object;
	}

	private void appendComma() {
		if (buffer.length() > 0) {
			buffer.append(", ");
		}
	}

	public ToStringBuilder append(String name, Object value) {
		appendComma();

		buffer.append(name);
		buffer.append("=");
		buffer.append(value);

		return this;
	}

	@Override
	public String toString() {
		return object.getClass().getName() + "(" + buffer + ")";
	}
}

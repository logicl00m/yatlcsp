package org.noman5237.yatlcsp;

import org.noman5237.yatlcspap.FunctionDefinition;

import java.util.function.Function;

@FunctionDefinition
public class HelloFunction implements Function<String, String> {
	
	@Override
	public String apply(String name) {
		System.out.println("HelloFunction: " + name);
		return String.format("HelloFunction: %s!", name);
	}
}

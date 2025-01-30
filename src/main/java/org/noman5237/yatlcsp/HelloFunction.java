package org.noman5237.yatlcsp;

import org.noman5237.yatlcspap.FunctionDefinition;

import java.util.function.Function;

@FunctionDefinition
public class HelloFunction implements Function<String, String> {
	
	@Override
	public String apply(String nnn) {
		System.out.println("HelloFunction: " + nnn);
		return String.format("Hello, %s!", nnn);
	}
}

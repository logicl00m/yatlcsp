package org.noman5237.yatlcsp;

import org.noman5237.yatlcspap.FunctionDefinition;

import java.util.function.Function;

@FunctionDefinition
public class HiFunction implements Function<Integer, String> {
	
	@Override
	public String apply(Integer i) {
		System.out.println("Hi: " + i);
		return String.format("Input found: %d!", i);
	}
}

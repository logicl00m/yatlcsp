package org.noman5237.yatlcsp;

import lombok.Builder;
import lombok.Singular;

import java.util.List;
import java.util.function.Supplier;


@Builder
@SuppressWarnings ("rawtypes")
public class Step {
	
	private String name;
	
	@Singular
	private List<Parameter> parameters;
	
	private Supplier with;
	
	public void run() {
		System.out.println("Step: " + name);
		for (Parameter parameter : parameters) {
			System.out.println("Parameter: " + parameter.getName() + " = " + parameter.getSupplier()
			                                                                          .get());
		}
		System.out.println("Result: " + with.get());
	}
}

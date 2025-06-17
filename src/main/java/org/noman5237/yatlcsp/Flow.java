package org.noman5237.yatlcsp;

import lombok.Builder;
import lombok.Singular;

import java.util.List;
import java.util.function.Supplier;

@Builder
public class Flow <R> implements Supplier<R> {
	
	@Singular
	private List<Step<?>> steps;
	
	private Persistence persistence;
	
	@Override
	public R get() {
		Object output = null;
		for (var step : steps) {
			output = step.get();
			if (persistence != null) {
				persistence.put(step.getName(), output);
			}
		}
		return (R) output;
	}
}

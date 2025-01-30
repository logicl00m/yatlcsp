package org.noman5237.yatlcsp;

import lombok.Builder;
import lombok.Singular;

import java.util.List;
import java.util.function.Function;

@Builder
public class Flow <T, R> implements Function<T, R> {
	
	
	@Singular
	private List<Step> steps;
	
	@Override
	public R apply(T t) {
		for (Step step : steps) {
			step.run();
		}
		return null;
	}
}

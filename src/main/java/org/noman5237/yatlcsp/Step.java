package org.noman5237.yatlcsp;

import lombok.Builder;
import lombok.Getter;

import java.util.function.Supplier;

@Builder
public class Step <R> implements Supplier<R> {
	
	@Getter
	private String name;
	private Supplier<R> with;
	
	@Override
	public R get() {
		return with.get();
	}
}

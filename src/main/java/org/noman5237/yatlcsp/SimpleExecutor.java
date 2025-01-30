package org.noman5237.yatlcsp;

import java.util.function.Function;

public class SimpleExecutor <R> implements Executor<R> {
	
	@Override
	public R execute(Function<?, R> function) {
		return null;
	}
}

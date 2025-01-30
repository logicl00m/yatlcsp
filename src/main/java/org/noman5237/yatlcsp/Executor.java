package org.noman5237.yatlcsp;

import java.util.function.Function;

public interface Executor <R> {
	
	R execute(Function<?, R> function);
}

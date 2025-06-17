package org.noman5237.yatlcsp;

import java.util.function.Supplier;

public interface Persistence <T> {
	
	// FIXME: add type safety for step name
	T put(String step, Object output);
	
	Supplier<T> get(String name);
}

package org.noman5237.yatlcsp;

import lombok.Builder;
import lombok.Getter;

import java.util.function.Supplier;

@Builder
@Getter
public class Parameter <T> {
	
	private String name;
	private Supplier<T> supplier;
}

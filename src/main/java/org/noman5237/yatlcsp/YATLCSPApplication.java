package org.noman5237.yatlcsp;

import java.util.Scanner;
import java.util.function.Supplier;

import static org.noman5237.yatlcsp.SinglePassInMemoryJsonMap.convert;

public class YATLCSPApplication {
	
	public static void main(String[] args) {
		Supplier<String> StringFromConsole = () -> new Scanner(System.in).next();
		
		var persistence = SinglePassInMemoryJsonMap.builder()
		                                           .build();
		
		var hello = Step.<String>builder()
		                .name("hello")
		                .with(HelloFunctionBuilder
				                      .builder()
				                      .name(StringFromConsole)
				                      .build())
		                .build();
		
		var hello2 = Step.<String>builder()
		                 .name("hello2")
		                 .with(HelloFunctionBuilder
				                       .builder()
				                       .name(convert(persistence.get("hello"), String.class))
				                       .build())
		                 .build();
		
		Supplier<String> flow = Flow.<String>builder()
		                            .persistence(persistence)
		                            .step(hello)
		                            .step(hello2)
		                            .build();
		
		var newFlow = Flow.<String>builder()
		                  .step(Step.<String>builder()
		                            .name("newFlow")
		                            .with(flow)
		                            .build())
		                  .build();
		newFlow.get();
		
	}
	
}

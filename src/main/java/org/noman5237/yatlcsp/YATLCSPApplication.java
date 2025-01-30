package org.noman5237.yatlcsp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Scanner;
import java.util.function.Supplier;

//@SpringBootApplication
public class YATLCSPApplication {
	
	public static void main(String[] args) {
		Supplier<String> StringFromConsole = () -> new Scanner(System.in).next();
		var flow = Flow.builder()
		               .step(Step.builder()
		                         .name("Say Hello")
		                         .with(HelloFunctionBuilder
				                               .builder()
				                               .nnn(StringFromConsole)
				                               .build())
		                         .build())
		               .build();
		flow.apply(null);
//		var flow = Flow.builder()
//		               .step(Step.builder()
//		                         .name("Say Hello")
//		                         .with(HelloFunction
//				                               .builder()
//				                               .name(StringFromConsole)
//				                               .build())
//		                         .build())
//		               .build();
//		SpringApplication.run(YATLCSPApplication.class, args);
	}
	
}

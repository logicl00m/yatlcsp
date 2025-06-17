package org.noman5237.yatlcsp;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.Builder;

import java.util.HashMap;
import java.util.function.Supplier;

@Builder
public class SinglePassInMemoryJsonMap implements Persistence<String> {
	
	private final ObjectMapper mapper = new ObjectMapper();
	private static final ObjectMapper staticMapper = new ObjectMapper();
	private final HashMap<String, String> map = new HashMap<>();
	
	@Override
	public String put(String step, Object output) {
		try {
			String value = mapper.writeValueAsString(output);
			map.put(step, value);
			return value;
		} catch (JsonProcessingException e) {
			throw new RuntimeException(e);
		}
	}
	
	@Override
	public Supplier<String> get(String name) {
		return () -> map.get(name);
	}
	
	public static <T> Supplier<T> convert(Supplier<String> json, Class<T> clazz) {
		return () -> {
			try {
				return staticMapper.readValue(json.get(), clazz);
			} catch (JsonProcessingException e) {
				throw new RuntimeException(e);
			}
		};
	}
}

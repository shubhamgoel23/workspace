package io.spring.springbootconfig;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RefreshScope
public class GreetingController {

	@Value("${app.description:default_value}")
	private String greetingMessage;

	@Value("${my.lists}")
	private List<String> value;
	
//	@Value("#{${db.values}}")
//	private Map<String, String> dbValues;
	
	@GetMapping("/greeting")
	public String greeting() {
		return value.toString();
	}

}

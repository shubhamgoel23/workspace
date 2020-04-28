package guru.sfg.beer.inventory.service.config;

import org.springframework.context.annotation.Bean;
import org.springframework.jms.support.converter.MappingJackson2MessageConverter;
import org.springframework.jms.support.converter.MessageConverter;
import org.springframework.jms.support.converter.MessageType;

import com.fasterxml.jackson.databind.ObjectMapper;

public class JmsConfig {
	
	public static final String NEW_INVENTORY_QUEUE = "new-inventory";

	@Bean//serialize the message content to json using text message
	public MessageConverter messageConverter(ObjectMapper objectMapper) {
		MappingJackson2MessageConverter converter = new MappingJackson2MessageConverter();
		converter.setTargetType(MessageType.TEXT);
		converter.setTypeIdPropertyName("_type");
		converter.setObjectMapper(objectMapper);
		return converter;
	}
}

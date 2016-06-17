package br.com.agricopias.enums.helper;

import java.io.IOException;
import java.util.Arrays;
import java.util.stream.Stream;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.BeanProperty;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.deser.ContextualDeserializer;

public class JSONEnumDeserializer extends JsonDeserializer<Enum<?>> implements ContextualDeserializer {

	private Enum<?>[] constants;

    @Override
    public Enum<?> deserialize(JsonParser jp, DeserializationContext ctx) throws IOException { 
    	JsonNode node = jp.getCodec().readTree(jp);
    	final String value = node.get("value").asText();    	
        final Stream<Enum<?>> stream = Arrays.asList(constants).stream();            
        return stream.filter(a -> a.name().equals(value)).findAny().get();    	
    }

    @SuppressWarnings("unchecked")
    @Override
	public JsonDeserializer<Enum<?>> createContextual(DeserializationContext ctxt, BeanProperty property) throws JsonMappingException {
    	Class<? extends Enum<?>> clazz = (Class<? extends Enum<?>>) ctxt.getContextualType().getRawClass();
    	constants = clazz.getEnumConstants();
    	return this;
    }
}

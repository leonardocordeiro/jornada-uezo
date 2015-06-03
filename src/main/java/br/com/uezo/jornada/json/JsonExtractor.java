package br.com.uezo.jornada.json;

import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

public final class JsonExtractor {
	
	private static final JsonParser parser = new JsonParser();
	
	public static final String get(String json, String property) { 
		JsonObject object = (JsonObject) parser.parse(json);
		JsonElement element = object.get(property);
		
		return element.toString();	
	}
}

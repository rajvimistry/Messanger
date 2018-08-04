package org.restservices.messanger.database;

import java.util.HashMap;
import java.util.Map;

import org.restservices.messanger.model.Message;
import org.restservices.messanger.model.Profile;

public class Database {
	
	private static Map<Long, Message> messages = new HashMap<>();
	private static Map<String, Profile> profile = new HashMap<>();
	
	public static Map<Long,Message> getMessage(){
		return messages;
	}
	
	public static Map<String,Profile> getProfile(){
		return profile;
	}
}

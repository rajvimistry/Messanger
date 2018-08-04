package org.restservices.messanger.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.restservices.messanger.database.Database;
import org.restservices.messanger.model.Message;
import org.restservices.messanger.model.Profile;

public class ProfileService {
	
	private Map<String, Profile> profiles = Database.getProfile();
	
	public ProfileService() {
		profiles.put("rajvimistry", new Profile(1L, "rajvimistry", "Rajvi", "Mistry"));
	}
	
	public List<Profile> getAllProfile(){
		
		return new ArrayList<Profile>(profiles.values());
	}
	
	public Profile getProfile(String profileName) {
		return profiles.get(profileName);
	}
	
	public Profile addProfile(Profile profile) {
		profile.setId(profiles.size()+1);
		profiles.put(profile.getProfilename(), profile);
		return profile;
	}
	
	public Profile updateProfile(Profile profile) {
		if(profile.getProfilename().isEmpty()) {
			return null;
		}
		profiles.put(profile.getProfilename(), profile);
		return profile;
	}
	
	public Profile removeProfile(String profileName) {
		return profiles.remove(profileName);
	}

}

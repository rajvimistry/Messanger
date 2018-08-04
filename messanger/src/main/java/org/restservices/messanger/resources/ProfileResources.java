package org.restservices.messanger.resources;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.restservices.messanger.model.Message;
import org.restservices.messanger.model.Profile;
import org.restservices.messanger.service.MessageService;
import org.restservices.messanger.service.ProfileService;

@Path("/profiles")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class ProfileResources {

ProfileService profileservice = new ProfileService();
	
	@GET
	public List<Profile> getAllProfiles() {
		return profileservice.getAllProfile();
	}
	
	@POST
	public Profile addProfile(Profile profile) {
		return profileservice.addProfile(profile);
	}
	
	@PUT
	@Path("/{profileName}")
	public Profile updateProfile(@PathParam("profileName") String profileName, Profile profile) {
		profile.setProfilename(profileName);
		return profileservice.updateProfile(profile);
	}
	
	@DELETE
	@Path("/{profileName}")
	public void deleteProfile(@PathParam("profileName") String profileName) {
		profileservice.removeProfile(profileName);
	}
	
	@GET
	@Path("/{profileName}")
	public Profile getProfile(@PathParam("profileName") String profileName) {
		return profileservice.getProfile(profileName);
	}
}

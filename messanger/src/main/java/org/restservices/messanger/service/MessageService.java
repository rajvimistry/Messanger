package org.restservices.messanger.service;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Map;

import org.restservices.messanger.database.Database;
import org.restservices.messanger.exception.DataNotFoundException;
import org.restservices.messanger.model.Message;

public class MessageService {
	
	private Map<Long, Message> messages = Database.getMessage();

	public MessageService() {
		messages.put(1L, new Message(1, "Hello World", "Rajvi Mistry"));
		messages.put(2L, new Message(2, "Hello", "ABC"));
	}
	
	
	public List<Message> getAllMessages(){
		/*Message m1 = new Message(1L, "Hello", "Rajvi Mistry");
		Message m2 = new Message(2L, "Hello People", "ABC");
		List<Message> list = new ArrayList<>();
		list.add(m1);
		list.add(m2);
		return list;*/
		
		return new ArrayList<Message>(messages.values());
	}
	
	public List<Message> getAllMessageForYear(int year){
		List<Message> messagesForYear = new ArrayList();
		Calendar cal = Calendar.getInstance();
		for(Message message:messages.values()) {
			cal.setTime(message.getCreated());
			if(cal.get(Calendar.YEAR) == year) {
				messagesForYear.add(message);
			}
		}
		return messagesForYear;
	}
	
	public List<Message> getAllMessagesPaginated(int start, int size){
		ArrayList<Message> list = new ArrayList<>(messages.values());
		if(start + size > list.size()) return new ArrayList<Message>();
		return list.subList(start, start + size);
	}
	
	public Message getMessage(long id) {
		Message message = messages.get(id);
		if(message == null) {
			throw new DataNotFoundException("Message with id "+id+" does not exist");
		}
		return message;
	}
	
	public Message addMessage(Message message) {
		message.setId(messages.size()+1);
		messages.put(message.getId(), message);
		return message;
	}
	
	public Message updateMessage(Message message) {
		if(message.getId() <= 0) {
			return null;
		}
		messages.put(message.getId(), message);
		return message;
	}
	
	public Message removeMessage(long id) {
		return messages.remove(id);
	}
}

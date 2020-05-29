package com.cognizant.academy.qbthon.service;

import java.util.List;

import com.cognizant.academy.qbthon.model.Events;

public interface EventsService {

	public List<Events> getEvents();

	public void createEventsTable();

	public void addEvents(Events events);

	public void deleteEvents(String eventId);

}

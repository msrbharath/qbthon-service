package com.cognizant.academy.qbthon.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.cognizant.academy.qbthon.model.Events;
import com.cognizant.academy.qbthon.service.EventsService;

@RestController
@RequestMapping("/api/events")
public class EventsController {


	@Autowired
	EventsService eventsService;
	
	@RequestMapping(value = "/greeting", produces = {"application/json"}, method = RequestMethod.GET)
	public String greeting() {
		return "Hello Bharath Raj R!!!";
	}
	
	@RequestMapping(value = "/", produces = {"application/json"}, method = RequestMethod.GET)
	public ResponseEntity<List<Events>> getEvents() {
		return ResponseEntity.status(HttpStatus.OK).body(eventsService.getEvents());
	}
	
	@RequestMapping(value = "/create", produces = {"application/json"}, method = RequestMethod.GET)
	public void createEventsTable() {
		eventsService.createEventsTable();
		ResponseEntity.status(HttpStatus.OK);
	}
	
	@RequestMapping(value = "/add", produces = {"application/json"}, method = RequestMethod.POST)
	public void addEvents(@RequestBody Events events) {
		eventsService.addEvents(events);
		ResponseEntity.status(HttpStatus.OK);
	}
	
	@RequestMapping(value = "/delete", produces = {"application/json"}, method = RequestMethod.GET)
	public void deleteEvents(String eventId) {
		eventsService.deleteEvents(eventId);
		ResponseEntity.status(HttpStatus.OK);
	}
}

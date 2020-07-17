package com.cognizant.academy.qbthon.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cognizant.academy.qbthon.dao.QBThonDao;
import com.cognizant.academy.qbthon.model.Events;
import com.cognizant.academy.qbthon.repository.EventRepository;

@Service
public class EventsServiceImpl implements EventsService{

	@Autowired
	QBThonDao qbthonDao;
	
	@Autowired
	EventRepository eventRepository;
	
	@Override
	public List<Events> getEvents() {
		List<Events> events = (List<Events>)eventRepository.findAll();
		events.forEach(event -> {
			String skills = event.getSkills().stream()
			           .map(a -> String.valueOf(a.getSkillName()))
			           .collect(Collectors.joining(","));
			String associates = event.getAssociateDetails().stream()
			           .map(a -> String.valueOf(a.getAssociateId()))
			           .collect(Collectors.joining(","));
			String smes = event.getSmeDetails().stream()
			           .map(a -> String.valueOf(a.getAssociateId()))
			           .collect(Collectors.joining(","));
			event.setSkillsList(skills);
			event.setAssociateList(associates);
			event.setSmeList(smes);
		});
		return events;
	}

	@Override
	public void createEventsTable() {
		try {
			qbthonDao.createEventsTable();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public void addEvents(Events events) {		
		eventRepository.save(events);
	}

	@Override
	public void deleteEvents(String eventId) {
		Optional<Events> eventToDelete = eventRepository.findById(eventId);
		if(eventToDelete.isPresent()) {
			eventRepository.delete(eventToDelete.get());
		}else {
			System.out.println("Nothing to delete");
		}
	}

}

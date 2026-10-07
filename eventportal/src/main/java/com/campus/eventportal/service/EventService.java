package com.campus.eventportal.service;

import com.campus.eventportal.model.Event;
import com.campus.eventportal.repository.EventRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EventService {

    private final EventRepository repository;

    public EventService(EventRepository repository) {
        this.repository = repository;
    }

    public List<Event> getAllEvents() {
        return repository.findAll();
    }

    public Event getEventById(Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Event not found with id: " + id));
    }

    public Event saveEvent(Event event) {
        return repository.save(event);
    }

    public Event updateEvent(Long id, Event updated) {
        Event existing = getEventById(id);

        existing.setTitle(updated.getTitle());
        existing.setDescription(updated.getDescription());
        existing.setVenue(updated.getVenue());
        existing.setEventDate(updated.getEventDate());
        existing.setOrganizer(updated.getOrganizer());
        existing.setCapacity(updated.getCapacity());
        return repository.save(existing);
    }

    public void deleteEvent(Long id) {
        repository.deleteById(id);
    }
}
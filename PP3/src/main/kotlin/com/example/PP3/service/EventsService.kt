package com.example.PP3.service

import com.example.PP3.entity.Events
import com.example.PP3.repository.EventsRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service


@Service
class EventsService {
    @Autowired
    lateinit var eventsRepository: EventsRepository
    fun getEvents(): List<Events> {
        return eventsRepository.findAll()
    }
}
package com.example.pp3.service

import com.example.pp3.entity.Events
import com.example.pp3.repository.EventsRepository
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
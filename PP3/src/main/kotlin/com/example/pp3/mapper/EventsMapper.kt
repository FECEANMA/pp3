package com.example.pp3.mapper

import com.example.pp3.dto.EventsDto
import com.example.pp3.entity.Events
import com.example.pp3.entity.EventType
import com.example.pp3.entity.Users

object EventsMapper {
    fun toEntity(eventsDto: EventsDto): Events {
        val events = Events()
        // Convertir el String de eventType al tipo enum correspondiente
        events.eventType = eventsDto.eventType?.let { EventType.valueOf(it) }
        events.eventTime = eventsDto.eventTime
        if (eventsDto.userId != null) {
            val user = Users().apply {
                id = eventsDto.userId
            }
            events.user = user
        }
        return events
    }

    fun toDto(events: Events): EventsDto {
        return EventsDto().apply {
            // Convertir el enum eventType de nuevo a String
            eventType = events.eventType?.name
            eventTime = events.eventTime
            userId = events.user?.id
        }
    }
}

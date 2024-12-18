package com.example.pp3.mapper

import com.example.pp3.dto.EventsDto
import com.example.pp3.entity.Events

object EventsMapper {
    fun toEntity(eventsDto: EventsDto): Events{
        var events = Events()
        events.eventType = eventsDto.eventType
        return events
    }
}
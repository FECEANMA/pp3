package com.example.PP3.mapper

import com.example.PP3.dto.EventsDto
import com.example.PP3.entity.Events

object EventsMapper {
    fun toEntity(eventsDto: EventsDto): Events{
        var events = Events()
        events.eventType = eventsDto.eventType
        return events
    }
}
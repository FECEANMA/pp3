package com.example.pp3.service


import com.example.pp3.dto.EventsDto
import com.example.pp3.mapper.EventsMapper
import com.example.pp3.repository.EventsRepository
import com.example.pp3.util.JSendResponse
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service


@Service
class EventsService {

    @Autowired
    private lateinit var eventsRepository: EventsRepository

    fun createEvent(eventsDto: EventsDto): JSendResponse<EventsDto> {
        return try {
            val event = EventsMapper.toEntity(eventsDto)
            val savedEvent = eventsRepository.save(event)
            JSendResponse.success(EventsMapper.toDto(savedEvent))
        } catch (e: Exception) {
            JSendResponse.error("Failed to create event: ${e.message}")
        }
    }

    fun getAllEvents(): JSendResponse<List<EventsDto>> {
        return try {
            val events = eventsRepository.findAll()
            JSendResponse.success(events.map { EventsMapper.toDto(it) })
        } catch (e: Exception) {
            JSendResponse.error("Failed to retrieve events: ${e.message}")
        }
    }

    fun getEventById(id: Long): JSendResponse<EventsDto> {
        return try {
            val event = eventsRepository.findById(id)
            if (event.isPresent) {
                JSendResponse.success(EventsMapper.toDto(event.get()))
            } else {
                JSendResponse.fail("Event not found")
            }
        } catch (e: Exception) {
            JSendResponse.error("Failed to retrieve event: ${e.message}")
        }
    }

    fun updateEvent(id: Long, eventsDto: EventsDto): JSendResponse<EventsDto> {
        return try {
            if (eventsRepository.existsById(id)) {
                val event = EventsMapper.toEntity(eventsDto)
                event.id = id
                val updatedEvent = eventsRepository.save(event)
                JSendResponse.success(EventsMapper.toDto(updatedEvent))
            } else {
                JSendResponse.fail("Event not found")
            }
        } catch (e: Exception) {
            JSendResponse.error("Failed to update event: ${e.message}")
        }
    }

    fun deleteEvent(id: Long): JSendResponse<Unit> {
        return try {
            if (eventsRepository.existsById(id)) {
                eventsRepository.deleteById(id)
                JSendResponse.success(Unit)
            } else {
                JSendResponse.fail("Event not found")
            }
        } catch (e: Exception) {
            JSendResponse.error("Failed to delete event: ${e.message}")
        }
    }
}

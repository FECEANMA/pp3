package com.example.pp3.controller


import com.example.pp3.dto.EventsDto
import com.example.pp3.service.EventsService
import com.example.pp3.util.JSendResponse
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/api/events")
class EventsController {

    @Autowired
    private lateinit var eventsService: EventsService


    @PostMapping
    fun createEvent(@RequestBody eventsDto: EventsDto): JSendResponse<EventsDto> {
        return eventsService.createEvent(eventsDto)
    }


    @GetMapping
    fun getAllEvents(): JSendResponse<List<EventsDto>> {
        return eventsService.getAllEvents()
    }


    @GetMapping("/{id}")
    fun getEventById(@PathVariable id: Long): JSendResponse<EventsDto> {
        return eventsService.getEventById(id)
    }


    @PutMapping("/{id}")
    fun updateEvent(@PathVariable id: Long, @RequestBody eventsDto: EventsDto): JSendResponse<EventsDto> {
        return eventsService.updateEvent(id, eventsDto)
    }


    @DeleteMapping("/{id}")
    fun deleteEvent(@PathVariable id: Long): JSendResponse<Unit> {
        return eventsService.deleteEvent(id)
    }
}

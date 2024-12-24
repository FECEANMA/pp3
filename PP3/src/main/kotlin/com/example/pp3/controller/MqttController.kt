package com.example.pp3.controller

import com.example.pp3.mqttservice.MqttClientService
import com.example.pp3.util.JSendResponse
import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/mqtt")
class MqttController(private val mqttClientService: MqttClientService) {

    @GetMapping("/connect")
    fun connect(): JSendResponse<String> {
        return try {
            mqttClientService.connect()
            JSendResponse.success(data = "Conectado al broker MQTT")
        } catch (e: Exception) {
            JSendResponse.error(message = "Error al conectar: ${e.message}", httpStatus = HttpStatus.INTERNAL_SERVER_ERROR.value())
        }
    }

    @PostMapping("/send")
    fun sendMessage(@RequestParam topic: String, @RequestParam message: String): JSendResponse<String> {
        return if (topic.isBlank() || message.isBlank()) {
            JSendResponse.fail(message = "El tema y el mensaje no pueden estar vacíos", httpStatus = HttpStatus.BAD_REQUEST.value())
        } else {
            return try {
                mqttClientService.publishMessage(topic, message)
                JSendResponse.success(data = "Mensaje enviado al tema: $topic")
            } catch (e: Exception) {
                JSendResponse.error(message = "Error al enviar mensaje: ${e.message}", httpStatus = HttpStatus.INTERNAL_SERVER_ERROR.value())
            }
        }
    }

    @GetMapping("/disconnect")
    fun disconnect(): JSendResponse<String> {
        return try {
            mqttClientService.disconnect()
            JSendResponse.success(data = "Desconectado del broker MQTT")
        } catch (e: Exception) {
            JSendResponse.error(message = "Error al desconectar: ${e.message}", httpStatus = HttpStatus.INTERNAL_SERVER_ERROR.value())
        }
    }
}

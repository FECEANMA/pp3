package com.example.pp3.controller

import com.example.pp3.mqttservice.MqttClientService
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/mqtt")
class MqttController(private val mqttClientService: MqttClientService) {

    @GetMapping("/connect")
    fun connect(): String {  // Aquí devuelve un String
        mqttClientService.connect()
        return "Conectado al broker MQTT"
    }

    @PostMapping("/send")
    fun sendMessage(@RequestParam topic: String, @RequestParam message: String): String { // Devuelve un String
        mqttClientService.publishMessage(topic, message)
        return "Mensaje enviado al tema: $topic"
    }

    @GetMapping("/disconnect")
    fun disconnect(): String {  // Aquí también devuelve un String
        mqttClientService.disconnect()
        return "Desconectado del broker MQTT"
    }
}

package com.example.pp3.mqttservice

import org.eclipse.paho.client.mqttv3.*
import org.eclipse.paho.client.mqttv3.persist.MemoryPersistence
import org.springframework.stereotype.Service

@Service
class MqttClientService {

    private lateinit var mqttClient: MqttClient
    private val brokerUrl = "tcp://broker.hivemq.com:1883"
    private val clientId = "springBootClient"

    init {
        connect()
    }

    fun connect() {
        try {
            mqttClient = MqttClient(brokerUrl, clientId, MemoryPersistence())
            val options = MqttConnectOptions()
            options.isCleanSession = true
            mqttClient.connect(options)
            println("Conectado al broker MQTT")

            // Suscribirse al tema
            subscribeToTopic("home/gasLeak")
        } catch (e: MqttException) {
            println("Error al conectar: ${e.message}")
        }
    }

    fun subscribeToTopic(topic: String) {
        try {
            mqttClient.subscribe(topic)
            println("Suscrito al tema: $topic")

            mqttClient.setCallback(object : MqttCallback {
                override fun messageArrived(topic: String?, message: MqttMessage?) {
                    println("Mensaje recibido en el tema $topic: ${message?.toString()}")
                }

                override fun connectionLost(cause: Throwable?) {
                    println("Conexión perdida: ${cause?.message}")
                }

                override fun deliveryComplete(token: IMqttDeliveryToken?) {
                    // Opcional: manejar el token de entrega de mensaje
                }
            })
        } catch (e: MqttException) {
            println("Error al suscribirse al tema: ${e.message}")
        }
    }

    fun publishMessage(topic: String, eventType: String) {
        try {
            val message = "Evento detectado: $eventType"
            val mqttMessage = MqttMessage(message.toByteArray())
            mqttClient.publish(topic, mqttMessage)
            println("Mensaje enviado al tema $topic: $message")
        } catch (e: MqttException) {
            println("Error al publicar el mensaje: ${e.message}")
        }
    }

    fun disconnect() {
        try {
            mqttClient.disconnect()
            println("Desconectado del broker MQTT")
        } catch (e: MqttException) {
            println("Error al desconectar: ${e.message}")
        }
    }
}
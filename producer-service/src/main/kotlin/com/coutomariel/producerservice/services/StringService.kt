package com.coutomariel.producerservice.services

import com.coutomariel.producerservice.config.RabbitMQConfig.Companion.EXG_NAME_MARKETPLACE
import com.coutomariel.producerservice.config.RabbitMQConfig.Companion.RK_PRODUCT_LOG
import org.springframework.amqp.rabbit.core.RabbitTemplate
import org.springframework.stereotype.Service

@Service
class StringService(
        val rabbitTemplate: RabbitTemplate
) {

    fun produce(message: String) {
        rabbitTemplate.convertAndSend(EXG_NAME_MARKETPLACE, RK_PRODUCT_LOG, message)
    }
}
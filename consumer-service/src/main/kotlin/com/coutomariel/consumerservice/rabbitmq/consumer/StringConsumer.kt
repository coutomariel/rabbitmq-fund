package com.coutomariel.consumerservice.rabbitmq.consumer

import org.slf4j.Logger
import org.slf4j.LoggerFactory
import org.springframework.amqp.core.Message
import org.springframework.amqp.rabbit.annotation.RabbitListener
import org.springframework.stereotype.Component

@Component
class StringConsumer {
    private val logger: Logger = LoggerFactory.getLogger(StringConsumer::class.java)

    @RabbitListener(queues = ["product.log"])
    fun consumerLog(message: Message) {
        logger.info("Consumer received a message: $message")
    }
}
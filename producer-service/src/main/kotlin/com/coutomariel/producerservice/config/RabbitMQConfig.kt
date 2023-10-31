package com.coutomariel.producerservice.config

import org.springframework.amqp.core.BindingBuilder
import org.springframework.amqp.core.DirectExchange
import org.springframework.amqp.core.Queue
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

@Configuration
class RabbitMQConfig {

    companion object {
        val EXG_NAME_MARKETPLACE: String = "marketplace.direct"
        val QUEUE_NAME_PRODUCT_LOG: String = "product.log"
        val RK_PRODUCT_LOG: String = "product.log"
    }

    @Bean
    fun directExchange() = DirectExchange(EXG_NAME_MARKETPLACE, false, false)

    @Bean
    fun queue() = Queue(QUEUE_NAME_PRODUCT_LOG, false, false, false)

    @Bean
    fun binding() = BindingBuilder.bind(queue()).to(directExchange()).with(RK_PRODUCT_LOG)

}
